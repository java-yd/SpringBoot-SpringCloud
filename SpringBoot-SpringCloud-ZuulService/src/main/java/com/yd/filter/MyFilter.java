package com.yd.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * zuul不仅只是路由，并且还能过滤，做一些安全验证 需要继承ZuulFilter，交给spring管理
 	filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下： 
	pre：路由之前
	routing：路由之时
	post： 路由之后
	error：发送错误调用
	filterOrder：过滤的顺序
	shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
	run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
 */
@Component
public class MyFilter extends ZuulFilter {

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		Object accessToken = request.getParameter("token");
		if (accessToken == null) {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token必传，使用zuul的过滤器");
			} catch (Exception e) {
			}

			return null;
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}

package com.jsanhueza.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;

public class FirstFilter extends ZuulFilter{
	
	private static Logger LOGGER = LoggerFactory.getLogger(FirstFilter.class);
    private static final String FILTERTYPE = "pre";
    private static final Integer FILTERORDER = 1;

    public FirstFilter(){ }
    
	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		final String firstFlag = RequestContext.getCurrentContext().getRequest().getHeader("filterFlag");
		if (null == firstFlag) {
			ctx.unset();
			ctx.setResponseBody("se necesita propiedad filterFlag en el headers");
			ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
			return false;
		} else{
			return true;
		}
	}

	@Override
	public Object run() throws ZuulException {
		return null;
	}

	@Override
	public String filterType() {
		return FILTERTYPE;
	}

	@Override
	public int filterOrder() {
		return FILTERORDER;
	}

}

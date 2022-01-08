package com.jsanhueza.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;

public class SecondFilter extends ZuulFilter{

    private static Logger LOGGER = LoggerFactory.getLogger(SecondFilter.class);
    private static final String FILTERTYPE = "pre";
    private static final Integer FILTERORDER = 2;

    public SecondFilter(){ }

    @Override
    public boolean shouldFilter() { return true; }

    @Override
    public Object run() throws ZuulException {
        final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String microservicio = request.getRequestURI().split("/")[1];
        LOGGER.info("Petición {} a microservicio {}", request.getMethod(), microservicio);
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

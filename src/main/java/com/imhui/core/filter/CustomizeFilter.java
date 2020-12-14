package com.imhui.core.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class CustomizeFilter implements Filter {

    final Logger log = LoggerFactory.getLogger(CustomizeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.debug("Filter is running");
    }

    @Override
    public void destroy() {

    }
}

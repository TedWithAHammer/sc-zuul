package com.leo.sczuul.filter;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * Created by leo on 2018/1/26.
 * Description:
 */
@Component
public class XFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(XFilter.class);

    @Override
    public String filterType() {
        return FilterType.PRE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest hsr = rc.getRequest();
        logger.info("XFilter request info Method: {} Url: {}", hsr.getMethod(), hsr.getRequestURL().toString());
        return null;
    }
}

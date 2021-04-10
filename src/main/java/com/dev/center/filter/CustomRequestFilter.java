package com.dev.center.filter;

import com.dev.center.dao.LogRecord;
import com.dev.center.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Filter to log all request for /api basepath
 */
@Component
public class CustomRequestFilter implements Filter {
    private static Logger LOGGER = LoggerFactory.getLogger(CustomRequestFilter.class);

    @Autowired
    CarService carService;


    @Override
    public void doFilter (
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (carService == null) {
            ServletContext context = req.getSession().getServletContext();
            SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, context);
        }

        StringBuffer sb = new StringBuffer();
        sb.append(req.getRequestURI()).append("?").append(req.getQueryString());
        /*Log record information to mongodb*/
        LogRecord lr = new LogRecord();
        lr.setId(UUID. randomUUID().toString());
        lr.setDate(new Date());
        lr.setIp(req.getRemoteAddr());
        lr.setService(sb.toString());

        LOGGER.info(
                "carService {}", carService);
        carService.saveLog(lr);

        LOGGER.info(
                "Logging Request  {} : {} : {}", req.getMethod(),
                req.getRequestURI(),
                req.getRemoteAddr());
        chain.doFilter(request, response);
    }

    @Bean
    public FilterRegistrationBean<CustomRequestFilter> filter() {
        FilterRegistrationBean<CustomRequestFilter> bean = new FilterRegistrationBean<>();

        bean.setFilter(new CustomRequestFilter());
        bean.addUrlPatterns("/api/*");

        return bean;
    }
}

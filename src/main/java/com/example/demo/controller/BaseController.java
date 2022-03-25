package com.example.demo.controller;

import com.example.demo.util.PageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author lenovo
 */
@Controller
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    private static final long serialVersionUID = 6357869213649815390L;


    /**
     * 得到PageData
     */
    public PageData getPageData() {
        return new PageData(this.getRequest());
    }

    /**
     * 得到ModelAndView
     */
    public ModelAndView getModelAndView() {
        return new ModelAndView();
    }

    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        return request;
    }


    public static void logBefore(Logger logger, String interfaceName) {
        logger.info("");
        logger.info("start");
        logger.info(interfaceName);
    }

    public static void logAfter(Logger logger) {
        logger.info("end");
        logger.info("");
    }






}

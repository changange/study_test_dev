package cakes.mock.controller;

import cakes.mock.util.ServletParameterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-04-06-21:23
 * Description：<描述>
 */

@RestController
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private HttpServletRequest servletRequest;

    @RequestMapping("/test")
    public String test(){
        LOGGER.info("test access start-----------");

        Map<String, String > paramMap = ServletParameterUtils.getParam(servletRequest);

        paramMap.forEach((key, val) -> LOGGER.info("param key={}, val={}", key,val));

        LOGGER.info("test access end-----------");

        return "success";
    }
}

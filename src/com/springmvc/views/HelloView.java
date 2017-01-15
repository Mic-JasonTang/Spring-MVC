package com.springmvc.views;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Spring-MVC
 * <p>
 * Created by JasonTang on 1/12/2017 8:28 PM.
 */
@Component
public class HelloView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model,
                       HttpServletRequest request,
                       HttpServletResponse response)
            throws Exception {
        response.getWriter().write("Hello View" + ", time : " + new Date());
    }
}

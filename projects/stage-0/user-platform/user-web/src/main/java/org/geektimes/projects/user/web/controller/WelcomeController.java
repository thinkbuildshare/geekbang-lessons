package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.stream.Collectors;

/**
 * @Author hxchen
 * @Date 2021/2/28
 */
@Path("/welcome")
public class WelcomeController implements PageController {

    @GET
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "welcome.jsp";
    }

//    @POST
//    public String register(HttpServletRequest request, HttpServletResponse response) throws Throwable {
////        request.getconte
//        return "welcome.jsp";
//    }
}

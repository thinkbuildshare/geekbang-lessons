package org.geektimes.projects.user.web.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;
import org.geektimes.web.mvc.controller.RestController;

import javax.annotation.PostConstruct;
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
@Path("/register")
public class UserController implements PageController {

    @GET
    @POST
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        if(request.getMethod().equals("GET")) {
            return "register.jsp";
        } else {
            String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            String[] keyValues = body.split("&");
            User user = new User();
            for(String keyValue : keyValues) {
                if("".equals(keyValue)) {
                    continue;
                }
                String[] currentKeyValue = keyValue.split("=");
                switch (currentKeyValue[0]) {
                    case "name":
                        user.setName(currentKeyValue[1]);
                        break;
                    case "email":
                        user.setEmail(currentKeyValue[1]);
                        break;
                    case "password":
                        user.setPassword(currentKeyValue[1]);
                        break;
                    case "phoneNumber":
                        user.setPhoneNumber(currentKeyValue[1]);
                        break;
                }
            }
            user.setId(1L);
            if (new UserServiceImpl().register(user)) {
                return "welcome.jsp";
            } else {
                return "register.jsp";
            }

        }
    }

//    @POST
//    public String register(HttpServletRequest request, HttpServletResponse response) throws Throwable {
////        request.getconte
//        return "welcome.jsp";
//    }
}

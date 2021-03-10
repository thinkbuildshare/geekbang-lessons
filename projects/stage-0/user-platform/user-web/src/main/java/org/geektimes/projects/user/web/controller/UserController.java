package org.geektimes.projects.user.web.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.geektimes.context.ComponentContext;
import org.geektimes.exception.BizException;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;
import org.geektimes.web.mvc.controller.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
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

    @Resource(name="bean/UserService")
    private UserService userService;

    @Override
    public String inject() {
        if(this.userService == null) {
            this.userService = ComponentContext.getInstance().getComponent("bean/UserService");
        }
        return "";
    }

    @GET
    @POST
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        if(request.getMethod().equals("GET")) {
            return "register.jsp";
        } else {
            User user = new User();
            //form 参数获取方式
            user.setName(request.getParameter("name"));
            user.setPassword(request.getParameter("password"));
            user.setEmail(request.getParameter("email"));
            user.setPhoneNumber(request.getParameter("phoneNumber"));
            /** ajax参数获取方式
            String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            String[] keyValues = body.split("&");

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
             **/
//            user.setId(1L);
            try {
                if (userService.register(user)) {
                    return "welcome.jsp";
                } else {
                    request.getSession().setAttribute("user", user);
                    return "register.jsp";
                }
            } catch (Exception ex) {
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("errMsg", ex.getMessage());
//                return "welcome.jsp";
                                return "register.jsp";
            }

            //怎么传递错误信息

        }
    }

//    @POST
//    public String register(HttpServletRequest request, HttpServletResponse response) throws Throwable {
////        request.getconte
//        return "welcome.jsp";
//    }
}

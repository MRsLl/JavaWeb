package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/userServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void ajaxExistUserName (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
        String username = request.getParameter("username");
        //2.调用userService.existUsername(username):boolean;
        boolean existUsername = userService.existUsername(username);
        //3.返回验证的结果
        Map<String,Object> map = new HashMap<>();
        map.put("existUsername",existUsername);

        Gson gson = new Gson();
        response.getWriter().write(gson.toJson(map));
    }
    protected void regist (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * Constants.KAPTCHA_SESSION_KEY就是谷歌验证码jar包里,保存验证码的key
         */

        String token = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //删除session 中的验证码
        request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);

        //1.获取请求的参数
        String code = request.getParameter("code");

        //通过WebUtils的静态方法将参数注入 user 对象的属性中
        User user = WebUtils.copyParamToBean(new User(),request.getParameterMap());

        //2.检查验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)){
            //正确
            //检查用户名是否可用
            boolean existUsername = userService.existUsername(user.getUsername());
            //可用
            if (existUsername){
                //回显错误信息和用户名，邮箱
                request.setAttribute("username",user.getUsername());
                request.setAttribute("email",user.getEmail());
                request.setAttribute("msg","用户名已存在");
                //不可用则跳回注册页面
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }else {
                //保存到数据库
                userService.registUser(user);
                // 跳向注册成功页面
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }

        }else {
            //回显错误信息和用户名，邮箱
            request.setAttribute("username",user.getUsername());
            request.setAttribute("email",user.getEmail());
            request.setAttribute("msg","验证码错误");
            //错误 跳回注册页面
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }


    }

    protected void login (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = WebUtils.copyParamToBean(new User(),request.getParameterMap());

        //2.通过用户名和密码检验用户是否存在
        User login = userService.login(user);

        if (login == null) {
//            System.out.println("登录失败");
            //回显错误信息和用户名
            request.setAttribute("msg","用户名或密码错误");
            request.setAttribute("username",user.getUsername());
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }else {
//            System.out.println("登录成功");
            request.getSession().setAttribute("user",login);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
    }


    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}

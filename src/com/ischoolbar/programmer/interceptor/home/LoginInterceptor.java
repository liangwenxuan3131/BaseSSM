package com.ischoolbar.programmer.interceptor.home;

import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {

        String reqURI=request.getRequestURI();
        Object admin=request.getSession().getAttribute("account");

        if(admin==null){
            System.out.println( reqURI+"被拦截");
            String header = request.getHeader("X-Requested-With");
            if("XMLHttpRequest".equals(header)){
                //表示是ajax请求
                Map<String, String> ret = new HashMap<String, String>();
                ret.put("type", "error");
                ret.put("msg", "登录会话超时或还未登录，请重新登录!");
                response.getWriter().write(JSONObject.fromObject(ret).toString());
                return false;
            }
            response.sendRedirect(request.getServletContext().getContextPath()+"/home/login");
            return false;
        }
    return true;

    }
}

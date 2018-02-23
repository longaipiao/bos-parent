package com.cock.bos.web.action;

import com.cock.bos.domain.User;
import com.cock.bos.service.IUserService;
import com.cock.bos.utils.BOSUtils;
import com.cock.bos.web.action.base.BaseAction;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

    //属性驱动，接收页面输入的验证码
    private String checkcode;

    private User user;

    @Autowired
    private IUserService userService;

    public  String resist(){
        System.out.println("11111111111111111111");
        return LOGIN;
    }
    public String login(){
        //从Session中获取生成的验证码
        String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
        //校验验证码是否输入正确
        if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)){
            //输入的验证码正确
            User user = userService.login(mModel);
            if(user != null){
                //登录成功,将user对象放入session，跳转到首页
                ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
                return HOME;
            }else{
                //登录失败，,设置提示信息，跳转到登录页面
                //输入的验证码错误,设置提示信息，跳转到登录页面
                this.addActionError("用户名或者密码输入错误！");
                return LOGIN;
            }
        }else{
            //输入的验证码错误,设置提示信息，跳转到登录页面
            this.addActionError("输入的验证码错误！");
            return LOGIN;
        }
    }

    /**
     * 用户注销
     */
    public String logout(){
        ServletActionContext.getRequest().getSession().invalidate();
        return LOGIN;
    }

    /**
     * 修改当前用户密码
     * @throws IOException
     */
    public String editPassword() throws IOException {
        String f = "1";
        //获取当前登录用户
        User user = BOSUtils.getLoginUser();
        try{
            userService.editPassword(user.getUser_id(),mModel.getPassword());
        }catch(Exception e){
            f = "0";
            e.printStackTrace();
        }
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(f);
        return NONE;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }
}

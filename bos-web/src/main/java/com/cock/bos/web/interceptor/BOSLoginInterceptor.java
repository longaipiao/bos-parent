package com.cock.bos.web.interceptor;

import com.cock.bos.domain.User;
import com.cock.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 自定义的拦截器，实现用户未登录自动跳转到登录页面
 */
public class BOSLoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        ActionProxy proxy = actionInvocation.getProxy();
        String actionName = proxy.getActionName();
        String namespace = proxy.getNamespace();
        String url = namespace + actionName;
        System.out.println(url);
        //从session中获取用户对象
        User user = BOSUtils.getLoginUser();
        if (user == null) {
            //没有登录，跳转到登录页面
            return "login";
        }
        //放行
        return actionInvocation.invoke();
    }
}

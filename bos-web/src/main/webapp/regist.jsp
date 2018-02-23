<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册页面</title>
    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style_grey.css"/>
    <style>
        input[type=text] {
            width: 80%;
            height: 25px;
            font-size: 12pt;
            font-weight: bold;
            margin-left: 45px;
            padding: 3px;
            border-width: 0;
        }

        input[type=password] {
            width: 80%;
            height: 25px;
            font-size: 12pt;
            font-weight: bold;
            margin-left: 45px;
            padding: 3px;
            border-width: 0;
        }

        #loginform\:codeInput {
            margin-left: 1px;
            margin-top: 1px;
        }

        #loginform\:vCode {
            margin: 0px 0 0 60px;
            height: 34px;
        }
    </style>
    <script type="text/javascript">
        if (window.self != window.top) {
            window.top.location = window.location;
        }
    </script>
</head>
<body>
<s:actionerror></s:actionerror>
<div
        style="width: 900px; height: 50px; position: absolute; text-align: left; left: 50%; top: 50%; margin-left: -450px;; margin-top: -280px;">
    <span style="float: right; margin-top: 35px; color: #488ED5;">新BOS系统，致力于便捷、安全、稳定等方面的客户体验</span>
</div>
<div class="main-inner" id="mainCnt"
     style="width: 900px; height: 440px; overflow: hidden; position: absolute; left: 50%; top: 50%; margin-left: -450px; margin-top: -220px; background-image: url('${pageContext.request.contextPath }/images/bg_login.jpg')">
    <div id="loginBlock" class="login"
         style="margin-top: 80px; height: 255px;">
        <div class="loginFunc">
            <div id="lbNormal" class="loginFuncMobile">员工注册</div>
        </div>
        <div class="loginForm">
            <form id="registform" name="registform" method="post" class="niceform"
                  action="userAction_resist">
                <input type="hidden" name="method">
                <div id="idInputLine" class="loginFormIpt showPlaceholder"
                     style="margin-top: 5px;">
                    <%--@declare id="idinput"--%>
                    <input id="loginform:idInput" type="text" name="username"
                           class="loginFormTdIpt" maxlength="50"/>
                    <label for="idInput" class="placeholder" id="idPlaceholder">帐号：</label>
                </div>
                <div class="forgetPwdLine"></div>
                <div id="pwdInputLine" class="loginFormIpt showPlaceholder">
                    <%--@declare id="pwdinput"--%>
                    <input id="loginform:pwdInput" class="loginFormTdIpt" type="password"
                           name="password" value=""/>
                    <label for="pwdInput" class="placeholder" id="pwdPlaceholder">密码：</label>
                </div>
                <div>
                    <a onclick="document.getElementById('registform').submit();" href="#"
                       name="loginform:j_id19">
						<span class="btn btn-login"
                              style="margin-left:110px; margin-top: 18px">注册</span>
                    </a>
                </div>

            </form>
        </div>
    </div>
</div>
<%--<div
    style="width: 900px; height: 50px; position: absolute; text-align: left; left: 50%; top: 50%; margin-left: -450px;; margin-top: 220px;">
    <span style="color: #488ED5;">Powered By www.itcast.cn</span><span
        style="color: #488ED5;margin-left:10px;">推荐浏览器（右键链接-目标另存为）：<a
        href="http://download.firefox.com.cn/releases/full/23.0/zh-CN/Firefox-full-latest.exe">Firefox</a>
    </span>
</div>--%>
</body>
</html>
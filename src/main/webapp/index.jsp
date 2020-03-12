<%--
  Created by IntelliJ IDEA.
  User: jq Chen
  Date: 2018/2/1
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <meta name="viewport" content="width=device-width, initial-scale=0.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
    <meta name="keywords" content="记账系统" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap/base.css?v=1.28" />
    <title>记账系统</title>
</head>

<body>

<div class="lyy_header">
    <a class="btn_left">
        <img src="${pageContext.request.contextPath}/Images/common/header_back.png">
    </a>

    <span>记账系统</span>
</div>

<div class="lyy_nonav_box">
    <div class="lyy_business">
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/accounts/add">
                    <div class="ico fl"></div>
                    <div class="fl">
                        <h3>账单添加</h3>
                    </div>
                    <div class="clear"></div>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/accounts/query">
                    <div class="ico1 fl"></div>
                    <div class="fl">
                        <h3>账单查询</h3>
                    </div>
                    <div class="clear"></div>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/accounts/settle">
                    <div class="ico2 fl"></div>
                    <div class="fl">
                        <h3>月结</h3>
                    </div>
                    <div class="clear"></div>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/accounts/users">
                    <div class="ico3 fl"></div>
                    <div class="fl">
                        <h3>账号</h3>
                    </div>
                    <div class="clear"></div>
                </a>
            </li>
        </ul>
    </div>
</div>

</body>
</html>
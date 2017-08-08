<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/8
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4">

        </div>
        <div class="col-md-4">
            <h2>Congratulations!</h2>
            <p class="text-success">
                <div style="background: rgba(128, 128, 128, 0.57);
                              color: rgba(63, 81, 181, 0.78);
                              font-size: 30px;
                              padding: 5px;"
                id="username">${username }
                </div>&nbsp;
                you have register a new Account!<br>
                now ,you can go ahead ,click<br>
            <a class="btn btn-default" href="/loginAndResisterCtrl/${username}/mainPage" role="button">continue</a>
                or, you maybe want to perfected you Account,<br>
                if you want ,you can click<br>
            <a class="btn btn-default" href="#" role="button">perfected</a>
            </p>
        </div>
        <div class="col-md-4">

        </div>
    </div>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/8
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login&register</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../resource/css/index.css">
</head>
<body>
<div class="head_div"></div>
<div class="body_div">
    <div class="body_lift_div">
        <div class="body_lift_title">
            <div class="body_lift_title_big">Data Management System</div>
            <div class="body_lift_title_little">——SDU</div>
        </div>
    </div>
    <div class="body_middle_div">

        <!-- Nav tabs -->
        <ul class="nav nav-tabs" style="border-bottom: none;background: rgba(51, 122, 183, 0.23);" role="tablist">
            <li role="presentation" class="active"><a class="title_page" href="#login" aria-controls="login" role="tab"
                                                      data-toggle="tab">Login</a></li>
            <li role="presentation"><a class="title_page" href="#register" aria-controls="register" role="tab"
                                       data-toggle="tab">Register</a></li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="login">
                <form class="form_style" action="/loginAndResisterCtrl/login" method="post">
                    <div class="form-group">
                        <label for="login_username">username</label>
                        <input type="text" class="form-control" id="login_username" name="login_username" placeholder="login_username">
                    </div>
                    <div class="form-group">
                        <label for="login_password">password</label>
                        <input type="password" class="form-control" id="login_password" name="login_password" placeholder="login_password">
                    </div>
                    <!--<div class="form-group">
                        <label for="exampleInputFile">File input</label>
                        <input type="file" id="exampleInputFile">
                        <p class="help-block">Example block-level help text here.</p>
                    </div>-->
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" id="rember_me"> Rember me
                        </label>
                    </div>
                    <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-ok" aria-hidden="true">&nbsp;Submit</span>
                    </button>
                    <button type="reset" class="btn btn-default">
                        <span class="glyphicon glyphicon-refresh" aria-hidden="true">&nbsp;Reset</span>
                    </button>
                </form>
            </div>
            <div role="tabpanel" class="tab-pane" id="register">
                <form class="form_style" action="/loginAndResisterCtrl/register" method="post">
                    <div class="form-group">
                        <label for="register_username">username</label>
                        <input type="text" class="form-control" id="register_username" name="register_username" placeholder="username">
                    </div>
                    <div class="form-group">
                        <label for="register_password">password</label>
                        <input type="password" class="form-control" id="register_password" name="register_password" placeholder="password">
                    </div>
                    <div class="form-group">
                        <label for="register_password_again">password-again</label>
                        <input type="password" class="form-control" id="register_password_again" name="register_password_again" placeholder="password-again">
                    </div>
                    <!--<div class="form-group">
                        <label for="exampleInputFile">File input</label>
                        <input type="file" id="exampleInputFile">
                        <p class="help-block">Example block-level help text here.</p>
                    </div>-->
                    <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-ok" aria-hidden="true">&nbsp;Submit</span>
                    </button>
                    <button type="reset" class="btn btn-default">
                        <span class="glyphicon glyphicon-refresh" aria-hidden="true">&nbsp;Reset</span>
                    </button>
                </form>
            </div>
        </div>

    </div>
    <div class="body_right_div"></div>
</div>
<div class="foot_div">

</div>
</body>
</html>

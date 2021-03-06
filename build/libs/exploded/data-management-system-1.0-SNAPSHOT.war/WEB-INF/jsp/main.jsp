<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/8
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://cdn.bootcss.com/echarts/3.6.2/echarts.min.js"></script>
    <link rel="stylesheet" href="/resource/css/main.css">
</head>
<body>
<div class="container">
    <div class="row main-head">
        <div class="col-md-12">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="http://gradms.sdu.edu.cn/login">
                            SDU
                        </a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="#">mainPage</a></li>
                            <li><a href="#">monitorPage</a></li>
                            <li class="upAndDown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                                   role="button" aria-haspopup="true" aria-expanded="false">
                                    file operate
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="/upAndDownLoadCtrl/uploadAndDownload">upload and download</a></li>
                                    <li><a href="*">file list</a></li>
                                </ul>
                            </li>
                        </ul>
                        <form class="navbar-form navbar-left" action="" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                        </form>
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="#">
                                    login user:
                                    <span style="color:black;font-size: 15px">${username}</span>
                                </a>
                            </li>
                            <li>
                                <a href="/loginAndResisterCtrl/loginAndRegister">Sign out</a>
                            </li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        </div>
    </div>
    <div class="row main-body">
        <div class="col-xs-16 col-md-8">
            <div class="jumbotron">
                <h3>Document</h3>
                <p>...</p>
                <p><a href="#" class="btn btn-primary" role="button">Button</a>
                    <a href="#" class="btn btn-default" role="button">Button</a>
                </p>
            </div>
            <div class="jumbotron">
                <h3>Images</h3>
                <p>...</p>
                <p><a href="#" class="btn btn-primary" role="button">Button</a>
                    <a href="#" class="btn btn-default" role="button">Button</a>
                </p>
            </div>
            <div class="jumbotron">
                <h3>Others</h3>
                <p>...</p>
                <p><a href="#" class="btn btn-primary" role="button">Button</a>
                    <a href="#" class="btn btn-default" role="button">Button</a>
                </p>
            </div>
        </div>
        <div class="col-xs-8 col-md-4">
            <div class="jumbotron">
                <h4>Upload charts</h4>
                <a href="#" class="thumbnail">
                    <img src="..." alt="...">
                </a>
            </div>
            <div class="jumbotron">
                <h4>Download charts</h4>
                <a href="#" class="thumbnail">
                    <img src="..." alt="...">
                </a>
            </div>
            <div class="jumbotron">
                <h4>Activity ranking</h4>
                <a href="#" class="thumbnail">
                    <img src="..." alt="...">
                </a>
            </div>
            <div class="jumbotron">
                <h4>File Size charts</h4>
                <div id="fileSizeCharts" class="ecartsShow"></div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/resource/js/main.js"></script>
</html>

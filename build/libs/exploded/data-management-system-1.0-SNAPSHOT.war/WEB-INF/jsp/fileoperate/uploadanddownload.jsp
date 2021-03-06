<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/9
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload and download page</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>File Upload and Download  <small>document images others</small></h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div id="fileUpload" class="jumbotron">
                <form action="/upAndDownLoadCtrl/fileUpload" method="post" enctype="multipart/form-data">
                    <div class="form-group" id="file-upload">
                        <label for="fileInput">File upload</label>
                        <input type="file" id="fileInput" name="fileInput">
                        <p class="help-block">please choice your file ,and upload it!</p>
                    </div>
                    <button type="submit" class="btn btn-default">UPLOAD</button>
                </form>
            </div>
        </div>
        <div class="col-md-6">
            <div id="fileDownload" class="jumbotron">
                <form action="/upAndDownLoadCtrl/fileDownload" method="post" enctype="multipart/form-data">
                    <div class="form-group" id="file-download">
                        <label for="fileDown">File download</label><br>
                        <input type="text" id="fileDown" name="fileOutput">
                        <p class="help-block">please choice your file ,and download it!</p>
                    </div>
                    <button type="submit" class="btn btn-default">DOWNLOAD</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

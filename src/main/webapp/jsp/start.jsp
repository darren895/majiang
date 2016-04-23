<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>麻将记番</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="/css/bootstrap.min.css">
	
	<link rel="stylesheet" type="text/css" href="/css/base.css">

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="/js/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="/js/bootstrap.min.js"></script>

</head>
<body>
<form action="/save_name" method="post">
	<div class="maincontent">
		<div class="middlecontent">
			<div class="container-fluid">
			
				<div class="row">
					<div class="col-xs-3"><span>东风：</span></div>
					<div class="col-xs-6"><input class="name" name="east.name" type="text"></div>
				</div>
				<div class="row">
					<div class="col-xs-3"><span>南风：</span></div>
					<div class="col-xs-7"><input class="name" name="south.name" type="text"></div>
				</div>
				<div class="row">
					<div class="col-xs-3"><span>西风：</span></div>
					<div class="col-xs-7"><input class="name" name="west.name" type="text"></div>
				</div>
				<div class="row">
					<div class="col-xs-3"><span>北风：</span></div>
					<div class="col-xs-7"><input class="name" name="north.name" type="text"></div>
				</div>
			
			</div>
		</div>
	</div>
	<div class="foot container-fluid">
		<div class="col-xs-6"><button type="submit" class="btn btn-primary btn-lg btn-add">下一步</button></div>
		<div class="col-xs-6"><a class="btn btn-default btn-lg btn-back" href="/">返回</a></div>
	</div>
	</form>
</body>
</html>
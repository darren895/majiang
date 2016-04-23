<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="top">${user.name }：</div>
		<div style="height:30px;"></div>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<td>
					番型
					</td>
					<td>
					数量
					</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userFanDTOs}" var="userFanDTO">		
					<tr>					
					<td>
					${userFanDTO.fan.name}
					</td>
					<td>
					${userFanDTO.count}
					</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	<div style="height: 46px;"></div>
	<div class="foot">
		<div>
			<div>
				<div class="container-fluid">
					<div class="col-xs-12"><a class="btn btn-default btn-lg btn-back" href="/view_users">返回</a></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
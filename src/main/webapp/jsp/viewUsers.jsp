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
	
	<script src="/js/angular.min.js"></script>

</head>
<body ng-app="user">
	<div class="content" ng-controller="viewUser">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>姓名</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat='user in userList'>
							<td>{{user.name}}</td>
							<td>
								<a class="btn btn-default" href="/view_user/{{user.id}}">查看</a>
							</td>
				</tr>
				<tr>
					<td colspan="6">
						<button ng-click="more()" ng-class="{'hide':nomore}" type="button" class="btn btn-default btn-lg btn-back">更多</button>
				</tr>
			</tbody>
		</table>
	</div>
	<div style="height: 46px;"></div>
	<div class="foot">
		<div>
			<div>
				<div class="container-fluid">
					<div class="col-xs-12"><a class="btn btn-default btn-lg btn-back" href="/">返回</a></div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var app = angular.module('user', []);
		var count = 1;
		app.controller('viewUser', function($scope, $http) {
		   $scope.userList=[];
		   $scope.nomore = false;
		   $http.get('/users/'+count).success(function(response){
			   $scope.userList=response;
			   count +=1;
			   if(response.length == 0){
				   $scope.nomore = true;
			   }
		   });
		   $scope.more = function(){
			   $http.get('/users/'+count).success(function(response){
				   $scope.userList = $scope.userList.concat(response);
				   count +=1;
				   if(response.length == 0){
					   $scope.nomore = true;
				   }
			   });
		   }
		});
	</script>
</body>
</html>
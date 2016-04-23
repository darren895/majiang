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
<body ng-app="game">
	<div class="content" ng-controller="viewGame">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>${game.east.name}</th>
					<th>${game.south.name}</th>
					<th>${game.west.name}</th>
					<th>${game.north.name}</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${scoreMap.east}</td>
					<td>${scoreMap.south}</td>
					<td>${scoreMap.west}</td>
					<td>${scoreMap.north}</td>
					<td>总分</td>
				</tr>
				<tr ng-repeat='fight in fightList'>
							<td>{{fight.east}}</td>
							<td>{{fight.south}}</td>
							<td>{{fight.west}}</td>
							<td>{{fight.north}}</td>
							<td>
								<button class="btn btn-default" data-container="body" data-toggle="popover" data-placement="left" data-content="{{fight.score}}&nbsp">查看</button>
								<a class="btn btn-default" href="/edit_fight/{{fight.id}}?gameId=${game.id}">编辑</a>
								<script type="text/javascript">
									$('[data-toggle="popover"]').popover();
								</script>
							</td>
				</tr>

			</tbody>
		</table>
	</div>
	<div style="height: 46px;"></div>
	<div class="foot">
		<div>
			<div>
				<div class="container-fluid">
					<div class="col-xs-6"><a class="btn btn-primary btn-lg btn-add" href="/edit_fight?gameId=${game.id }">新增</a></div>
					<div class="col-xs-6"><a class="btn btn-default btn-lg btn-back" href="/viewgames">返回</a></div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var app = angular.module('game', []);
		app.controller('viewGame', function($scope, $http) {
		   $scope.fightList=[];
		   $http.get('/fights/${game.id}').success(function(response){
			   $scope.fightList=response;
		   });
		});
	</script>
</body>
</html>
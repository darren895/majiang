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
					<th>东</th>
					<th>南</th>
					<th>西</th>
					<th>北</th>
					<th>时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat='game in gameList'>
							<td>{{game.east.name}}</td>
							<td>{{game.south.name}}</td>
							<td>{{game.west.name}}</td>
							<td>{{game.north.name}}</td>
							<td>{{game.startTime | date:'yyyy-MM-dd'}}</td>
							<td>
								<a class="btn btn-default" href="/edit_game/{{game.id}}">编辑</a>
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
		var app = angular.module('game', []);
		var count = 1;
		app.controller('viewGame', function($scope, $http) {
		   $scope.gameList=[];
		   $scope.nomore = false;
		   $http.get('/games/'+count).success(function(response){
			   $scope.gameList=response;
			   count +=1;
			   if(response.length == 0){
				   $scope.nomore = true;
			   }
		   });
		   $scope.more = function(){
			   $http.get('/games/'+count).success(function(response){
				   $scope.gameList = $scope.gameList.concat(response);
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
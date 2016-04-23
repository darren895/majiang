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
<form action="/save_fight" method="post">
	<input type="hidden" name="gameId" value="${game.id }">
	<c:if test="${fightId!=null}"><input type="hidden" name="fightId" value="${fightId }"/></c:if>
	<div class="top">番数：<span id="result">0</span></div>
	<div class="container-fluid  head">
				<div style="height:30px;"></div>
				<div class="row"><div class="col-xs-12 winner">胡牌</div></div>
				<div class="row"><div class="col-xs-12"></div></div>
				<div class="row">
					<div class="col-xs-3"><label for="east">${game.east.name }：</label><input type="radio" name="winner" <c:if test="${fight.winner=='east'}">checked="checked"</c:if>  value="east" id="east"></div>
					<div class="col-xs-3"><label for="south">${game.south.name }：</label><input type="radio" name="winner" <c:if test="${fight.winner=='south'}">checked="checked"</c:if>  value="south" id="south"></div>
					<div class="col-xs-3"><label for="west">${game.west.name }：</label><input type="radio" name="winner" <c:if test="${fight.winner=='west'}">checked="checked"</c:if>  value="west" id="west"></div>
					<div class="col-xs-3"><label for="north">${game.north.name }：</label><input type="radio" name="winner" <c:if test="${fight.winner=='north'}">checked="checked"</c:if>  value="north" id="north"></div>
				</div>
				<div class="row"><div class="col-xs-12 winner">点炮</div></div>
				<div class="row">
					<div class="col-xs-3"><label for="losereast">${game.east.name }：</label><input type="radio" name="loser" <c:if test="${fight.loser=='east'}">checked="checked"</c:if>  value="east" id="losereast"></div>
					<div class="col-xs-3"><label for="losersouth">${game.south.name }：</label><input type="radio" name="loser" <c:if test="${fight.loser=='south'}">checked="checked"</c:if> value="south" id="losersouth"></div>
					<div class="col-xs-3"><label for="loserwest">${game.west.name }：</label><input type="radio" name="loser" <c:if test="${fight.loser=='west'}">checked="checked"</c:if> value="west" id="loserwest"></div>
					<div class="col-xs-3"><label for="losernorth">${game.north.name }：</label><input type="radio" name="loser" <c:if test="${fight.loser=='north'}">checked="checked"</c:if> value="north" id="losernorth"></div>
				</div>
			<c:forEach items="${fanList }" var="fans">
				<c:set value="${fans.get(0).score }" var="fanScore" />
				<div class="row fight">
					<div class="col-xs-12 col-md-12 col-sm-12 col-lg-12">${fanScore }番
						<div class="row fan">
							<c:forEach items="${fans }" var="fan">
								<div class="col-xs-12 col-md-4 col-sm-4 col-lg-2">
								<div class="col-xs-9 col-md-8 col-sm-8 col-lg-8">
								<label for="check${fan.id }" <c:if test="${fightFans.containsKey(fan.id)}">class="checkedbox"</c:if>>${fan.name}</label>
									<input type="checkbox" id="check${fan.id }" <c:if test="${fightFans.containsKey(fan.id)}">checked="checked"</c:if>  name="score" value="${fan.id }" score="${fan.score }"></div>
									<div class="col-xs-3 col-md-4 col-sm-4 col-lg-4"><select name="number${fan.id }">
										<c:forEach begin="1" end="8" var="num">
											<option value="${num }" <c:if test="${fightFans.containsKey(fan.id)&&fightFans.get(fan.id)==num}">selected="selected"</c:if>>${num}</option>
											
										</c:forEach>
									</select>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:forEach>
	</div>
	<div style="height: 46px;"></div>
	<div class="foot">
		<div>
			<div>
				<div class="container-fluid">
					<div class="col-xs-6"><button type="submit" class="btn btn-primary btn-lg btn-add">确定</button></div>
					<div class="col-xs-6"><a class="btn btn-default btn-lg btn-back" href="/edit_game/${game.id }">返回</a></div>
				</div>
			</div>
		</div>
	</div>
	</form>
<!-- Small modal -->
<div class="modal fade bs-example-modal-sm" id="errorDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">错误</h4>
      </div>
      <div class="modal-body">
        ${errorMessage}
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
	<script type="text/javascript">
		var sumScore = function(){
			var result = 0;
			$("input:checkbox[name='score']:checked").each(function(){
				var score = parseInt($(this).attr('score'));
				var fanId = $(this).val();
				var count = $('select[name="number'+fanId+'"]').val();
				if(count<=0){
					count=0;
				}
				result = result + score*count;
			});
			$('#result').html(result);
		};
		
		$('input[name="score"]').click(function(){
			sumScore();
			if($('#check12').is(':checked')||$('#check25').is(':checked')||$('#check40').is(':checked')){
				$('input[name="loser"]').attr("disabled","disabled");
			}else{
				$('input[name="loser"]').removeAttr("disabled");
			}
			var id = $(this).attr('id');
			$('label[for="'+id+'"]').toggleClass('checkedbox');
		});
		$('select').change(function(){
			var count = $(this).val();
			sumScore();
		});
		$(function(){
			sumScore();
			<c:if test="${errorMessage!=null}">
				$('#errorDialog').modal('show');
			</c:if>
		});
	</script>
</body>
</html>
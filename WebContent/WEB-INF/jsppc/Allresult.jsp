<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.alibaba.fastjson.JSONArray"
	import="com.alibaba.fastjson.JSONObject" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/select.js"></script>
<script type="text/javascript" src="js/jquery-2.1.0.js">
</script>
<style>
.dialog{
	background-color: red;
	margin: 0 auto;
	width: 100px;
	display: none;
}
</style>
<body>

	<div class="rightinfo">



		<form action="selectSlt" method="get">

			<div class="tools">
				<ul class="toolbar">

					<li>起始时间: <input name="startTime" type="date" id="StartTime"
						size="12" onFocus="return showCalendar(this, 'y-m-d')"
						onClick="return showCalendar(this, 'y-m-d')" value=${ startTime}>
					</li>
					<li>结束时间: <input name="endTime" type="date" id="EndTime"
						size="12" onFocus="return showCalendar(this, 'y-m-d')"
						onClick="return showCalendar(this, 'y-m-d')" value=${ endTime}>
					</li>

					<li>工号:<input name="selectjobnumber" type="text"
						id="jobnumber" size="12">
					</li>
					<li><input type="submit" name="提交" value="查询" /></li>
				</ul>

				<ul class="toolbar1">
					<li><span><img src="images/t05.png" /></span>设置</li>
				</ul>
			</div>
		</form>




		<table class="tablelist">
			<!-- width="80%" height="100" border="1" cellpadding="0" cellspacing="1"  align="center" -->
			<tr align="center">
				<th>姓名</th>
				<th>工号</th>
				<th>分数</th>
				<th>日期</th>
				<th>管理</th>
			</tr>

			<c:forEach items="${jsonArray }" var="userInfo">
				<tr>
					<td>${userInfo.name}</td>
					<td>${userInfo.jobnumber}</td>
					<td>${userInfo.grade }</td>
					<td>${userInfo.time}</td>
					<td>
						<button class="tablelink" onclick="deletes('${userInfo.jobnumber}')" type="button">删除</button>
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>
	<div class="dialog">
		<div class="">
			<button>确认</button>
			<button>取消</button>
		</div>
	</div>
</body>
<script type="text/javascript">
function deletes(obj){
// 	$('.dialog').css('display','block');
 	window.location.href="${pageContext.request.contextPath}/DeleteSlt?fromtype=web&jobnumber="+obj;
	alert(obj);
}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.alibaba.fastjson.JSONArray"
	import="com.alibaba.fastjson.JSONObject" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/select.js"></script>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<body>

    <div class="rightinfo">

		<div class="tools">

			<ul class="toolbar">
				<li class="click"><span><img src="images/t01.png" /></span>添加</li>
				<li class="click"><span><img src="images/t02.png" /></span>修改</li>
				<li><span><img src="images/t03.png" /></span>删除</li>
				<li><span><img src="images/t04.png" /></span>统计</li>
			</ul>

			<ul class="toolbar1">
				<li><span><img src="images/t05.png" /></span>设置</li>
			</ul>

		</div>


<form action="selectSlt" method="get">

		<div class="tools">
			<ul class="toolbar">
		
		<li >起始时间: <input name="startTime"
					type="date" id="StartTime" size="12"
					onFocus="return showCalendar(this, 'y-m-d')"
					onClick="return showCalendar(this, 'y-m-d')" value=${ startTime}>
		</li>
		<li>
					结束时间: <input name="endTime"
					type="date" id="EndTime" size="12"
					onFocus="return showCalendar(this, 'y-m-d')"
					onClick="return showCalendar(this, 'y-m-d')" value=${ endTime}>
		</li>	
		
		<li>工号:<input name="selectjobnumber"
					type="text" id="jobnumber" size="12">
		</li>
		<li>
		<input 	type="submit" name="提交" value="查询" />
		</li>
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
				<script type="text/javascript">
				var str = ${jsonArray};
				// 	var obj = JSON.stringify(str);
				// 弹出对话框	alert(str[2].name);	

				for (var i = 0; i < str.length; i++) {
					document.write("<tr>");
					document.write("<td>" + str[i].name + "</td>");
					document.write("<td>" + str[i].jobnumber + "</td>");
					document.write("<td>" + str[i].grade + "</td>");
					document.write("<td>" + str[i].time + "</td>");
					document.write('<td>  <a href="#" class="tablelink">删除</a></td>');
					document.write("</tr>");
					
					
				}
			</script>
	</table>
	</div>
</body>
</html>
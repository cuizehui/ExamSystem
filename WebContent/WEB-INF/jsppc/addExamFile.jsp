<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<form action="AddExamFileSlt" method="post"
			enctype="multipart/form-data" accept-charset="UTF-8">
			<span> 选择文件: <input type="text" name="username"><input
				type="file" name="filename"> <input type="submit"
				value="Submit" />
			</span>
		</form>
		
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">首页</a></li>
				<li><a href="computer.html">文件管理</a></li>
				<li><a href="#">列表</a></li>
			</ul>
		</div>

		<table class="filetable" id="">

			<thead>
				<tr>
					<th width="25%">名称</th>
					<th width="11%">修改日期</th>
					<th width="10%">类型</th>
					<th width="6%">大小</th>
					<th width="48%"></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${files }" var="file">
					<tr >
						<td  > <a  href="FormatExamSlt?filename=${file}" ><img  src="images/f06.png" />${file}</a></td>
						<td>2013/10/14 17:38</td>
						<td>文件</td>
						<td class="tdlast" >0 KB</td>
						<td></td>
					</tr>			
				</c:forEach>			
			</tbody>
		</table>
	</div>
</body>
</html>
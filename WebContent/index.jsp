<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统</title>
</head>

<frameset rows="88,*" cols="*" frameborder="no" border="0"
	framespacing="0">

		<frame src="${pageContext.request.contextPath}/TopViewSlt" name="topFrame" scrolling="No" noresize="noresize"
			id="topFrame" title="topFrame" />

	<frameset cols="187,*" frameborder="no" border="0" framespacing="0">
		<frame src="${pageContext.request.contextPath}/leftviewSlt"
			name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame"
			title="leftFrame" />
		<frame src="right.jsp" name="rightFrame" id="rightFrame"
			title="rightFrame" />
	</frameset>

</frameset>

<body>
<noframes>
	<body>
	浏览器太渣了。
	</body>
</noframes>
</body>
</html>
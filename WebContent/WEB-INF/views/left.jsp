<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- <body>


<form action="query.do">
	
</form>
	

<a target="rightFrame" href="${pageContext.request.contextPath}/InsertDispatcher"><input type="button"  name="insert" value="添加"/></a>

<a target="rightFrame" href="${pageContext.request.contextPath}/QuireSlt?type=1"><input  type="button" name="queary" value="查看"/></a>

<input type="button" name="更改" value="更改" onclick="javascript:window.location='';" />
<div>
<input type="button" name="删除" value="删除" onclick="javascript:window.location='DeleteDispatcher';" />
</div>	

</body>
 --%>
 <link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">

    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>成绩信息
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath}/QuireSlt?type=1" target="rightFrame">成绩查询</a><i></i></li>
      	 <li><cite></cite><a href="imgtable.html" target="rightFrame">成绩修改</a><i></i></li>
        <li><cite></cite><a href="imglist.html" target="rightFrame">成绩打印</a><i></i></li>
      
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>员工信息
    </div>
    <ul class="menuson">
        <li><cite></cite><a  href="${pageContext.request.contextPath}/InsertDispatcher" target="rightFrame">员工录入</a><i></i></li>
        <li><cite></cite><a href="#">员工删除</a><i></i></li>
        <li><cite></cite><a href="#">档案列表显示</a><i></i></li>
        </ul>     
    </dd> 
    

    
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">自定义</a><i></i></li>
       
    </ul>
    
    </dd>   
    
    </dl>
</body>

</html>
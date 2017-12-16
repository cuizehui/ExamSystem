<%@ page language="java" contentType="text/html; charset=UTF-8" 
import="com.alibaba.fastjson.JSONArray"
import="com.alibaba.fastjson.JSONObject"    
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/select.js"></script>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<body>
<form action="selectSlt" method="get">

<div>
<span>
 <tr align="center" valign="middle">
            <td width="93%" align="center">
      起始时间:
              <input name="startTime" type="date" id="StartTime" size="12" onFocus="return showCalendar(this, 'y-m-d')" onClick="return showCalendar(this, 'y-m-d')"  value=${ startTime} >
      结束时间:
     		 <input name="endTime" type="date" id="EndTime" size="12" onFocus="return showCalendar(this, 'y-m-d')" onClick="return showCalendar(this, 'y-m-d')"  value=${endTime}   >

        工号:  <input name="selectjobnumber" type="text"  id="jobnumber" size="12"  >
      
      <input type="submit" name="提交" value="submit"  />
</span>
</div>
</form>
<div>

<table width="80%" height="100" border="1" cellpadding="0" cellspacing="1"  align="center"  bgcolor="CCE8CF">
	<caption>查询结果</caption>
		<tr align="center">
			<th>姓名</th>
			<th>工号</th>
			<th>分数</th>
			<th>日期</th>
			
		</tr>
		
<script type="text/javascript">
	var str = ${jsonArray};
// 	var obj = JSON.stringify(str);
// 弹出对话框	alert(str[2].name);	

	for(var i=0;i<str.length;i++){
		document.write("<tr>");
		document.write("<td>"+str[i].name+"</td>");
		document.write("<td>"+str[i].jobnumber+"</td>");
		document.write("<td>"+str[i].grade+"</td>");
		document.write("<td>"+str[i].time+"</td>");
		document.write("</tr>");
	}
</script>
	
	
<tr ><td colspan="17" align="center">
 <input type="hidden" id="perPagerRows" value="${pager.perPageRows}">
<span>每页显示 
 <select id="selectOp" onchange="self.location.href=options[selectedIndex].value">

  <%-- <option id="50" value="<%= basePath%>JRXTAction.action?pager.perPageRows=50">50</option>
  <option id="100" value="<%= basePath%>JRXTAction.action?pager.perPageRows=100">100</option> --%>

 </select>条记录 
</span>
     <s:if test="%{pager.curPage>1}">
          <a href='JRXTAction.action?pager.curPage=1'>
             <span >首页</span>
          </a>

         <a href='JRXTAction.action?pager.curPage=${pager.curPage-1 }'>
            <span>上一页</span>
         </a>
     </s:if>
     <span>共 ${pager.rowCount}记录，共${pager.curPage}/${pager.pageCount}页</span>
     <s:if test="pager.curPage < pager.pageCount">
     
        <a href="JRXTAction.action?pager.curPage=${pager.curPage+1}">
            <span>下一页</span>
        </a>
        
        <a href='JRXTAction.action?pager.curPage=${pager.pageCount }'>
            <span>尾页</span>
        </a>
        
    </s:if>
</td></tr>
	</table>	
</div>

</body>
</html>
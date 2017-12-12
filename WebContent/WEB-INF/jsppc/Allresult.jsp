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
<body>
<form action="selectSlt" method="get">
<div>
<span>
 <tr align="center" valign="middle">
            <td width="93%" align="center">
      起始时间:
              <input name="startTime" type="date" id="StartTime" size="12" onFocus="return showCalendar(this, 'y-m-d')" onClick="return showCalendar(this, 'y-m-d')"  value="<%=request.getAttribute("startTime")%>">
      结束时间:
     		 <input name="endTime" type="date" id="EndTime" size="12" onFocus="return showCalendar(this, 'y-m-d')" onClick="return showCalendar(this, 'y-m-d')"  value="<%=request.getAttribute("endTime")%>">
       <!-- 统计月份:
      <SELECT id=sel_yy name=sel_yy >
        <OPTION value=2017 Selected>2017</OPTION>
        <OPTION value=2018 >2018</OPTION>
		<OPTION value=2019 >2019</OPTION>  
      </SELECT>
      年
      <SELECT id=sel_mm name=sel_mm>
        <OPTION value=01 
		>01
		</OPTION>
        <OPTION value=02 
		
		>02</OPTION>
        <OPTION value=03 
		
		>03</OPTION>
        <OPTION value=04 
		
		>04</OPTION>
        <OPTION value=05 
		
		>05</OPTION>
        <OPTION value=06 
		
		>06</OPTION>
        <OPTION value=07 
		
		>07</OPTION>
        <OPTION value=08 
		>08</OPTION>
        <OPTION value=09 
		>09</OPTION>
        <OPTION value=10 
		>10</OPTION>
        <OPTION value=11 
		>11</OPTION>
        <OPTION value=12 
		Selected
		>12</OPTION>
      </SELECT>
      月  -->
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
		<%
		JSONArray jsonarray= (JSONArray)request.getAttribute("jsonArray");
			if(jsonarray.size()>0){
				  for(int i=0;i<jsonarray.size();i++){
				    JSONObject jsonob = jsonarray.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
		%>
			<tr align="center">
			<td><%= jsonob.get("name") %></td>
			<td><%= jsonob.get("jobnumber") %></td>
			<td><%= jsonob.get("grade") %></td>
			<td><%= jsonob.get("time") %></td>
			
		
		</tr>
		<%		
				  
				  
				  }	
		}		
	
	%>
	
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
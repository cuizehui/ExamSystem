<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.alibaba.fastjson.JSONArray"
import="com.alibaba.fastjson.JSONObject"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>




<form action="login" method="GET">
<div>
工  号：<input type="text" name="jobnumber">
姓  名：  <input type="text" name="name" />
<input type="submit" value="插入" />
</div>
</form>

	
		
		
		<%
		JSONArray jsonarray= (JSONArray)request.getAttribute("jsonArray");
		 String exception=(String)request.getAttribute("exception");
		if(exception!=null){
		    out.println(exception);
		}
		else{
			
				if(jsonarray!=null){
		
					if(jsonarray.size()>0){
						%>
						<table width="100%" height="100" border="1" cellpadding="0" cellspacing="1"  align="center"  bgcolor="CCE8CF">
						<tr align="center">
						<th>姓名</th>
						<th>工号</th>
						<th>插入结果</th>
							
						</tr>
						<%	
						  for(int i=0;i<jsonarray.size();i++){
						    JSONObject jsonob = jsonarray.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
		%>
		
			<tr align="center">
			<td><%= jsonob.get("name") %></td>
			<td><%= jsonob.get("jobnumber") %></td>
			<td><%= jsonob.get("result") %></td>
			</tr>
	
	
		<%					  
				  }	
					%>
						</table>
					<%
				}		
			}
		}
	%>
	




</body>
</html>
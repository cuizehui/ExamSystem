<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.alibaba.fastjson.JSONArray"
import="com.alibaba.fastjson.JSONObject"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/my.css"  rel="stylesheet"> 
</head>
<script type="text/javascript" src="js/select.js"></script>
<body>


<form action="InsertSlt" method="GET">
<div>
工  号：<input type="text" name="jobnumber">
姓  名：  <input type="text" name="name" />
<input type="submit" value="插入" />
</div>
</form>

	
		<script  type="text/javascript">
	
		var jsonarray= ${jsonArray}
	  	var exception=${empty  exception}
				if(exception){
					document.write("true");
					if(jsonarray.length>0){
						document.write('<table width="100%" height="100" border="1" cellpadding="0" cellspacing="1"  align="center"  bgcolor="CCE8CF"> <tr align="center"> <th>姓名</th> <th>工号</th> <th>插入结果</th> </tr> ');
							for(var i=0;i<jsonarray.length;i++){
								document.write("<tr>");
								alert(jsonarray[i].name);
								document.write("<td>"+jsonarray[i].name+"</td>");
								document.write("<td>"+jsonarray[i].jobnumber+"</td>");
								document.write("<td>"+jsonarray[i].result+"</td>");
								document.write("</tr>");
							}
							document.write("</table>");
						}
				
					
				}
				else{
					var str="${exception}"
					document.write('<table width="100%" height="100" border="1" cellpadding="0" cellspacing="1"  align="center"  bgcolor="CCE8CF"> <tr align="center"> <th>失败原因</th>  </tr> ');
					document.write("<tr>");
					document.write("<td>"+str+"</td>");
					document.write("</tr>");
					document.write("</table>");
				}
				
			
		
		</script>	

</body>
</html>
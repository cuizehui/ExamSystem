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
<style>
.tablelist{border:solid 1px #cbcbcb; width:100%; clear:both;}
.tablelist th{background:url(../images/th.gif) repeat-x; height:34px; line-height:34px; border-bottom:solid 1px #b6cad2; text-indent:11px; text-align:left;}
.tablelist td{line-height:35px; text-indent:11px; border-right: dotted 1px #c7c7c7;}
.tablelink{color:#056dae;}
.tablelist tbody tr.odd{background:#f5f8fa;}
.tablelist tbody tr:hover{background:#e5ebee;}
</style>
<script type="text/javascript" src="js/select.js"></script>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<body>

<div  class="tools">

<form action="InsertSlt" method="GET">
<div>
<ul>
		<li>
工  号：<input type="text" name="jobnumber">
			
		</li>
	<li>
姓  名：<input type="text" name="name" />	 <input type="submit" value="插入" />
	</li>
	



</ul>
</div>
</form>

	
	
		<script  type="text/javascript">
		var jsonarray= ${jsonArray};
	  	var exception=${empty  exception};
				if(exception){
					if(jsonarray.length>0){
						document.write('<table id="demo" class="tablelist" >   <thead align="center"> <th>姓名</th> <th>工号</th> <th>插入结果</th> </thead>');
							// width="100%" height="100" border="1" cellpadding="0" cellspacing="1"  align="center"  > <tr align="center"> <th>姓名</th> <th>工号</th> <th>插入结果</th> </tr>
							for(var i=0;i<jsonarray.length;i++){
								document.write("<tr>");
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
					document.write('<table > <tr align="center"> <th>失败原因</th>  </tr> ');
					// width="100%" height="100" border="1" cellpadding="0" cellspacing="1"  align="center"  bgcolor="CCE8CF"
					document.write("<tr>");
					document.write("<td>"+str+"</td>");
					document.write("</tr>");
					document.write("</table>");
				}

		</script>	
</div>

</body>
</html>
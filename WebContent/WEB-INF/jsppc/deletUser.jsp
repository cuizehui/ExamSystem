<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="DeleteSlt" method="Get">
<div>
工 号 <input  name="jobnumber"  type="text"  > 
 <input type="submit" value="提交" />
</div>
</form>

<script type="text/javascript">
	  if(${empty jsonarray}){
	  }else{
		  var ja= ${jsonarray};
		  document.write("<tr>"+ja[0].result+"</tr>"); 
		  
	  }
	  
</script>

</body>
</html>
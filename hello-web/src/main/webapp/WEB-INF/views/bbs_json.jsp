<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
// location.href = '';

window.onload = function(){
	var obj = {
			"제목": "json",
			"내용": "객체 정보 반환 \n그런데 그게 여기 오면 json형태",
			"no": 1
	}
	
	var jsonObj = obj.stringfy();
	
	alert(jsonObj);
}
</script>

</head>
<body>



</body>
</html>
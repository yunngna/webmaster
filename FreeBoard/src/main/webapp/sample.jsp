<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = 'js/jquery-3.7.1.js'></script> <!-- 위치 지정은 webapp기준 -->

<script>
//jquery 코드 작성 
	document.addEventListener('DOMContentLoaded',function(e){ // 화면상에 있는 body의 경우 body를 읽기 전에 앞에서 만들고 있기 때문에 body가 무엇인지 모르기 때문에 처음부터 끝까지 다 읽고 나서 실행하는 이벤트를 걸어줘야 한다. 
	//jquery객체 생성
	$('<ul/>')	// js 에서는 document.creatElement('ul') 이다. 달러$ 표시 하고 원하는 태그 적고 열고 닫는 괄호 적어준다.
	.append($('<li>사과</li>') // ul 태그 객체 하위에 li 태그 객체 사과 형성 == <ul><li>사과</li></ul> (방법1)
		   ,$('<li/>').html('바나나') // li 태그에 innerHTML 속성과 동일  == innerHTML = '바나나' (방법2)
		   ,$('<li/>').text('복숭아') // li태그에 innerText 와 동일 == innerText ='복숭아' (방법3)
	).appendTo($('body')) // 앞에서 형성한 ul을 body 밑에 붙이겠다. 화면상에 있는 요소에 넣기 위해서는 $('')
		
	})
</script>

</head>
<body>
<!-- WEBAPP/sample.jsp (제일 상위 경로에 위치 지정 )-->


</body>
</html>
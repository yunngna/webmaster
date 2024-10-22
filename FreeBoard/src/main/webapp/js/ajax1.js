/**
 * ajax1.js
 * Asynchronous(비동기방식) Javascript And xml 
 * 비동기 방식 = Ajax 
 */
//동기 방식 = 1이 실행 되고 나면 2,3 연속으로 실행 (자바 = 동기방식)
// 비 동기 방식 = setTimeout 을 사용하는데 일정 시간을 기다렸다가 함수를 실행 setTimeout(function(){},일정시간[1000= 1초]); (자바스크립트= 비동기방식)
// 비 동기 방식을 사용하는 이유? 웹의 경우 웹 실행을 빨리 하기 위해서 


/**대표적인 비동기방식 처리 xhtp 은 객체라서 속성 + 메소드 로 구성 
 * (코드 호출은 xhtp.onload = function()가 먼저 되지만,xhtp.open('get','memberJson.do'); 가 실행되는 시간 동안, 
 * xhtp 함수을 바로 실행 못하고 console.log('2',data); 을 먼저 실행하게 된다. )*/

let xhtp = new XMLHttpRequest(); 
xhtp.open('get','memberJson.do');
// 작업이 실행되려면 send 가 있어야 한다.
xhtp.send(); // 서버상 resource 호출 


let data= [];

//addEventListener = onload
xhtp.onload = function(){ //2번으로 실행
	let obj = JSON.parse(xhtp.responseText); // 객체 -> 배열로 변경  (String->object)
	console.log(obj); 
	data=obj;
	console.log('1',data);
	
	for(let i=0; i>data.length; i++ ){
	console.log(data[i]); 
}
}
console.log('2',data); // 1번으로 실행 



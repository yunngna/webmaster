/**
 * replyService.js
 * 메소드 : 목록 가져오기 , 등록 , 삭제, 
 */

 const svc = {
	 rlist(bno=403, successFnc,errorFnc){ //댓글목록 가져오기 (성공시 successFnc 함수 실행 실패시 errorFnc 실행) (데이터 가져오기)
		 //Ajax 호출
		 fetch('replyList.do?bno='+bno)
		 	.then(resolve => resolve.json())
		 	.then (successFnc)
		 	.catch(errorFnc)
	 },

	 showMsg(msg){
		 console.log(msg);
	 }
 }
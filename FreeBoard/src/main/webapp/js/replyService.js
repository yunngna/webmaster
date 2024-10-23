/**
 * replyService.js
 * 메소드 : 목록 가져오기 , 등록 , 삭제, 
 */

 const svc = {
	 rlist(param={bno,page},successFnc,errorFnc){ //댓글목록 가져오기 (성공시 successFnc 함수 실행 실패시 errorFnc 실행) (데이터 가져오기)
		 //Ajax 호출 (1. 목록)
		 fetch('replyList.do?bno='+param.bno + '&page='+param.page)
		 	.then(resolve => resolve.json())
		 	.then (successFnc)
		 	.catch(errorFnc)
	 },
	 //2. 삭제
	 removeReply(rno =1,successFnc,errorFnc){
		 //Ajax호출 
		 fetch('removeReply.do?rno='+rno)
		 	.then(resolve => resolve.json())
		 	.then (successFnc)
		 	.catch(errorFnc)
	 },
	 
	 //3. 추가  (넘겨 받아야 하는 parameter 3개라서 객체로 만들어 준다.)
	 addReply(param={bno,reply,replyer},successFnc,errorFnc){
		 //Ajax호출 
		 fetch('addReply.do?bno='+param.bno+'&reply='+param.reply+'&replyer='+ param.replyer)
		 	.then(resolve => resolve.json())
		 	.then (successFnc)
		 	.catch(errorFnc)
	 },
	 
	 //4. 댓글 수 카운트
	 getReplyCount(bno=1,successFnc,errorFnc){
		  fetch('replyCount.do?bno='+bno)
		 	.then(resolve => resolve.json())
		 	.then (successFnc)
		 	.catch(errorFnc)
	 }
	 
	 
	 
 }//close svc
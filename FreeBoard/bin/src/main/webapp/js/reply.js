/**
 * reply.js
 * replyService 생성했던 메소드 활용  
 * 
 * <table id="replyList" class ="table">
	<thead>
		<tr>
			<th>댓글번호</th><th>내용</th><th>작성자</th>
		</tr>
	</thead>
	<tbody></tbody>
</table>
 */

let page=1;

//댓글등록 버튼 
// 등록 버튼 가져오기  + 이벤트 추가 (action , 함수)

document.querySelector('#addReply').addEventListener('click',addReplyHandlerFnc) 

function addReplyHandlerFnc(e){	
	let reply = document.querySelector('#reply').value; // input 태그라서 value 그 값을 불러온다.
	if(!reply || !logId){
			alert('필수값이 없습니다')
			return;
		}
	svc.addReply(
		{ bno,reply,replyer:logId },  // parameter이 한개가 아니기 때문에 객체 타입으로 추가 
		result => { // 성공할 경우 실행  //successFuc
			console.log("result", result);
			if(result.retCode == 'OK'){
				//전체페이지 다 보여주기
				//let template = makeLi(result.retVal);
				//document.querySelector(".reply ul li").after(template); // reply ul li 의 첫번째 요소 다음에 작성 
				
				//1페이지만 보여주기 
				page =1;
				showList();
				svc.getReplyCount(bno,creatPageList, err =>console.log(err));
				
			} else if(result.retCode == 'FAIL'){
				alert('등록중 오류 발생')
			}	
		},
		err => { // 예외 발생시 실행 //errorFuc
			console.log('요기',err);
		}
	)
}


//댓글(목록) 출력 함수 
//svc.rlist(bno // bno번호
	//,//successFuc 목록 출력 
	/**function (result){
		let fields = ['replyNo','reply','replyer']
		for(let i=0; i<result.length; i++){
			let template= document.querySelector(".reply ul li").cloneNode(true); //board.jsp의 댓글목록 가져오기 
		//console.log(result[i]['reply']);
		template.querySelector('span').innerText = result[i]['replyNo'];
		template.querySelector('span:nth-of-type(2)').innerText = result[i]['reply'];
		template.querySelector('span:nth-of-type(3)').innerText = result[i]['replyer'];
		template.querySelector('span:nth-of-type(4)').innerHTML = '<button onclick="deleteRow(event)">삭제</button>';
		document.querySelector(".reply ul").appendChild(template);			
		}
	} */



//----------페이지 + 목록 출력 ---------------------------
//pagination a 클릭 이벤트
function linkMove() {
	document.querySelectorAll('nav ul.pagination a').forEach(function(aTag) {
		aTag.addEventListener('click', function(e) {
			e.preventDefault(); // 이동 차단
			//console.log(aTag.innerHTML); //aTag.innerHTML = 페이지 값
			//page = aTag.innerHTML; // page에 aTag.innerHTML = 페이지 값 을 넣어주기
			page = aTag.dataset.page; // <a data-page="2">2</a>
			showList(); // 목록 보여주기 함수 
			//creatPageList(); // 페이징 목록 보여주기 함수 
			svc.getReplyCount(bno, creatPageList, err =>console.log(err));
		})
	})
}
showList();
//db에서의 데이터 만큼의 totalCnt 사용 
// bno가 전달 되어서 성공하면 result 전달해서 creatPageList() 사용
svc.getReplyCount(bno, creatPageList, err =>console.log(err)); 
//creatPageList();

//페이지 목록을 출력하는 함수
function creatPageList(result){ // if page =2 인경우 
	//db에서의 데이터 만큼의 totalCnt 사용 
	let totalCnt = result.totalCount;
	
	let startPage, endPage, realEnd;
	let prev , next;
	
	//보여주고 싶은 페이지 만큼 (page / 원하는페이지수)* 원하는 페이지 수 
	endPage = Math.ceil(page / 5) * 5; // endPage= 5
	startPage= endPage - 4; // startPage=1
	realEnd = Math.ceil(totalCnt / 5); // realEnd = 7 
	endPage = endPage > realEnd ? realEnd : endPage;
	
	//이전, 이후 페이지 유무  ( 조건이 맞으면 true)
	prev = startPage >1; // false
	next = endPage < realEnd;  // true
	
	//페이지리스트 출력 (페이지의번호출력) (1)
	//<li class="page-item">
	//    <a class="page-link" href="#">1</a>
	//</li>
/**let li = document.createElement('li');
		li.className = 'page-item'; // li의 클래스 이름 붙여주기 
		
		let a = document.createElement('a');
		a.className ='page-link'; // a의 클래스 이름 붙이기 
		a.setAttribute('href','#');
		a.innerText = p;
		li.appendChild(a); 
		document.querySelector('nav ul.pagination').appendChild(li); */
	
	
	
	//이전, 다음 페이지 출력	
	let list ='';
	//이전페이지
	/**<li class="page-item">
      		<a class="page-link" href="#" aria-label="Previous">
        		<span aria-hidden="true">&laquo;</span>
      		</a>
    	</li> */
    	
	list += '<li class="page-item">';
	//이전페이지 있으면 링크 모양 생기게 하기
	if(prev)
		list += '	<a class="page-link" href="#" aria-label="Previous" data-page="'+(startPage-1)+'">&laquo;</a>';
	else 
		list += '  <span class="page-link disabled" aria-hidden="true">&laquo;</span>';
	list += '    </li>';

	
	//페이지 목록(숫자) 출력  (2)
	for (let p = startPage; p<= endPage; p++){
		list += '<li class=:"page-item"><a class="page-link" href="#" data-page="'+p+'">'+p+'</a></li>'
	}
		document.querySelector('nav ul.pagination').innerHTML = list;
	
	
	//다음페이지 
	/** <li class="page-item">
      		<a class="page-link" href="#" aria-label="Next">
       		 <span aria-hidden="true">&raquo;</span>
      		</a>
    	</li> */
    list += '<li class="page-item">';
    //다음페이지 있으면 링크 모양 생기게 하기
    if(next)
		list += '	<a class="page-link" href="#" aria-label="Next" data-page="'+(endPage+1)+'">&raquo;</a>';
	else 
		list += ' 		<span class="page-link disabled" aria-hidden="true" >&raquo;</span>';
    list += '    </a></li>';
    document.querySelector('nav ul.pagination').innerHTML = list;
    
    linkMove();
     
} 
    
    
	
//댓글 목록을 출력하는 함수 
function showList(){
	//출력목록을 화면에 지우고 (지워주지 않으면 페이지가 누적이 된다. 2클릭하면 1+2가 뜬다.)
	document.querySelectorAll('div.reply div.content li').forEach((li,idx)=>{
		if(idx >0) 
			li.remove();
	})
	//페이징목록 출력
	svc.rlist({ bno, page }
		,//successFuc
		function(result) {
			for (let i = 0; i < result.length; i++) {
				let template = makeLi(result[i]);
				document.querySelector(".reply ul").appendChild(template);
			}
		}
		, function(err) {
			console.log('요기', err);
		}//errorFuc
	);
}//end of showList()

//댓글 정보가 한건 있으면 <li>...</li> 함수 생성
// 댓글 목록 생성 
function makeLi(rvo={replyNo, reply, replyer}){
	let template= document.querySelector(".reply ul li").cloneNode(true); //board.jsp의 댓글목록 가져오기 
	//console.log(result[i]['reply']);
	template.querySelector('span').innerText = rvo.replyNo;
	template.querySelector('span:nth-of-type(2)').innerText = rvo.reply;
	template.querySelector('span:nth-of-type(3)').innerText = rvo.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = '<button onclick="deleteRow(event)">삭제</button>';
	
	return template;		
}

//댓글 삭제 함수 
function deleteRow(e){
	console.log(e);
	// button 의 상위 요소span , li -> li의 첫번째 요소 = board_no 를 찾아와서 삭제 
	let rno = e.target.parentElement.parentElement.firstElementChild.innerText;
	console.log(rno);
	// replyService.js 의 삭제 함수(기능) 호출 
	svc.removeReply(rno, // 삭제할 댓글 번호
	//success 정상 처리시 실행 함수
	result=>{ 
		if(result.retCod == 'OK'){
			alert('정상 처리');
			e.target.parentElement.parentElement.remove();
		}else if(result.retCod == 'FAIL'){
			alert ('예외가 발생 했습니다.')
		}else{
			alert('알수 없는 코드')
		}
	},
	//fail 예외 발생 실행 함수 
	err=> console.log('요기',err)
	)
	
}


//댓글 (게시글 번호 받아서) 전체 출력 (successFuc)	
/**function makeList(result){
	console.log(result);
	//댓글 배열 (result) 출력하기 
	let fields = ['replyNo','reply','replyer']
	for(let i=0; i<result.length; i++){
		let tr = document.createElement('tr');
		for(let j=0; j<fields.length; j++){
			let td= document.createElement('td');
			td.innerHTML = result[i][fields[j]];
			tr.appendChild(td);
		}
		document.querySelector('#replyList tbody').appendChild(tr);
	}
	
}*/

/**
 *calendarModal.js 
 */
let body = document.querySelector('body');
let div= document.createElement('div');
let modal = document.querySelector('#exampleModal');
function modalShow(arg){
	modalArg = arg; // 여러 함수에서 사용할 용도 
	
	console.log("show");
	
	//모달 창이 뜰때 해당하는 요소들이 캘린더 날짜에 추가 할때 나타 나도록 추가 하고 빼는 것 
	//body 태그 찾아오기 
	//let body = document.querySelector('body');
	body.className = 'modal-open';
	body.style.overflow = 'hidden';
	body.style.paddingRight = '16px';
	console.log(body);
	
	// 모달 창의 화면 생기는 부분 (div_class 가져와야 하기 때문에 div만들어 주고 className 지정후 appendChild로 가져오기)
	//class이름을 지정 할때는 한단어씩 넣어줘야한다. 
	//let div= document.createElement('div');
	div.className = 'modal-backdrop';
	div.className= 'fade'; 
	div.className= 'show';
	
	//modal태그 
	//let modal = document.querySelector('#exampleModal') //아이디 가져올 때는 # 붙이기
	modal.classList.add('modal')
	modal.classList.add('fade')	 
	modal.classList.add('show')
	modal.setAttribute('aria-modal',true);
	modal.setAttribute('role','dialog');
	modal.removeAttribute('aria-hidden');
	modal.style.display = 'block';
	
	body.appendChild(div); 

	
	//modal 창에 title, start, end 값 넣기
	//(1) e.g id가 start 인 곳(calendar.jsp 에서 만든)의 값으로 매개 값 startStr넣어주기 
	start.value = modalArg.startStr;
	end.value=modalArg.endStr;
	
}

function modalClose(){
	//body부분
	body.classList.remove('modal-open');
	body.removeAttribute('overflow', 'hidden');
	body.removeAttribute('padding-right','16px');
	
	//modal부분
	modal.classList.remove('show');
	modal.removeAttribute('aria-modal',true);
	modal.removeAttribute('role','dialog');
	modal.style.display = 'none';
	modal.setAttribute('aria-hidden',true);
	
	//div부분  (class자체 삭제 )
	div.remove();
		
}

function modalSave() {
	//title,startStr, endStr 값 가져와서 저장  (id에 있는 값을 가져올때는 #아이디.value)
	let title = document.querySelector('#title').value;
	let startStr = document.querySelector('#start').value;
	let endStr = document.querySelector('#end').value;
	
	fetch('addEvent.do?title=' + title + '&start=' + startStr + '&end=' + endStr)
		.then(resolve => resolve.json())
		//성공시 화면에 출력 
		.then(result => {
			console.log("function="+result);
			if (result.retCode == 'OK') {
				calendar.addEvent({ //데이터 추가 후 화면에 출력 (캘린더가 추가 되게 보이게 한다.)
					title: title,
					start: modalArg.start,
					end: modalArg.end,
					allDay: modalArg.allDay
				})
			} else if (result.retCode == 'FAIL') {
				alert('등록중 오류 발생')
			}
		})
		.catch(err => console.log(err));
}

function startChange(event){
	console.log(event);
	// 새로 선택한 날짜인 event 값이 이벤트 저장하는데 start로 지정된다. 
	modalArg.start = new Date(event.target.value); // event.target.value 은 2024-10-21로 string 형태 이다. 
}

function endChange(event) {
	console.log(event);
	modalArg.end = new Date(event.target.value);
}
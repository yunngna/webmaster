/**
 *members.js 
 */
//JSP => req.getDispatch ("board.boardList.tiles").forward(req,resp);
//json => json 데이터를 가져와서 활용페이지 그리기  (페이지 이동 없이 데이터 삭제 추가 모두 가능하다. )

//"등록" 버튼에 이벤트 추가 (데이터 저장)
document.querySelector('#addBtn').addEventListener('click',function(e){
	let id = document.querySelector('#mid').value;
	let name = document.querySelector('#mname').value;
	let phone = document.querySelector('#phone').value;

	fetch('addMemberJson.do?id='+id+'&name='+name + '&phone='+phone)
	.then (resolve => {return resolve.json()}) // function 대신에 화살표구문
	.then(result => {
		console.log(result); // {retCode : 'OK'}
		if (result.retCode =='OK'){
			let tr= makeRow({memberId:id,memberName:name,phone:phone});
			document.querySelector('#show tbody').appendChild(tr);
		}else if(result.retCode == 'FAIL'){
			alert('처리중 에러가 발생.');
		}

		})
	.catch(err=>{console.log(err)})
})

//"삭제" 버튼에 이벤트 추가(서버의 데이터 삭제 )

//json형태의 회원목록을 출력하는 데이터 (1) 목록 출력 
/**fetch('memberJson.do')
	.then (function(resolve){
		return resolve.json()
	})
	.then (function(result){
		console.log("result="+ result);
		makeList(result) // 함수에 데이터 목록 매개값 
	})
	.catch (function(err){ // 예외처리
		console.log(err)
})*/
//화살표 형식으로 위의 것 변경 ( 목록출력 변경 후 )
fetch('memberJson.do')
	.then (resolve => resolve.json())
	.then (result =>{
		console.log("result="+ result);
		makeList(result) // 함수에 데이터 목록 매개값 
	})
	.catch (err=> { // 예외처리
		console.log(err)
})



//1. 목록 출력
//함수 생성 (데이터 나오게 하기)
function makeList(obj =[]){
	
	for(let i=0; i<obj.length; i++){
		let tr = makeRow(obj[i]);
		document.querySelector('#show tbody').appendChild(tr);
	}
}


//obj ={} 은 배열이 아닌 객체 
function makeRow(obj={}){
	let fields = ['memberId','memberName','phone'];
	let tr = document.createElement('tr');
	tr.setAttribute('data-id',obj.memberId); // 멤버 아이디를 data-id에 담아두기(삭제단계의 버튼의 아이디 가져오기)
		for(let j=0; j<fields.length; j++){
			let td = document.createElement('td');
			td.innerText = obj[fields[j]];
			tr.appendChild(td);
		}
		console.log(obj);

		//삭제 button만들기
		let td = document.createElement('td');
		let button = document.createElement('button');
		// 삭제 버튼으로 데이터 지우기 (이벤트) (button -> td -> tr) 순으로 상속되어 있어서 )
		button.addEventListener('click',delteteRowFnc);
		button.innerHTML='삭제';
		td.appendChild(button);
		tr.appendChild(td);

		return tr;
}
// 이벤트 핸들러에는 매개값이 항상 이벤트가 들어간다. 
function delteteRowFnc(e){
	// console.log(e.target); //e.target : 버튼
	// console.dir(e.target.parentElement.parentElement.firstElementChild.innerText); // 삭제 하고 싶은 버튼에 해당하는 아이디 불러오기 
	console.dir(e.target.parentElement.parentElement.dataset.id); // 멤버 아이디를 data-id에 담아두기(삭제단계의 버튼의 아이디 가져오기)
	let id = e.target.parentElement.parentElement.dataset.id;
	fetch('removeMemberJson.do?id=' + id)
		.then(resolve => resolve.json())
		.then(result => {
			if(result.retCode=='OK'){
				e.target.parentElement.parentElement.remove();
				alert(id + "님 삭제 성공")
			}else if(result.retCode =='FAIL'){
				alert('처리중 에러가 발생.');
			}
		})
		.catch(err=>console.log(err))
// 	e.target.parentElement.parentElement.remove();
	}

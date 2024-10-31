/**
 * json.js
 * {name:"홍길동",age:20} => object
 * {"name" : "홍길동","age":20} => json object
 * json 문자열 => 자바스크립트 객체  => json 문자열 [타입을  변환시키는 함수가 있다. ]
 * 
 * <table class="table">
		<thead>
			<tr>
				<th>ID</th><th>firstName</th><th>lastName</th><th>Email</th><th>Salary</th><th>삭제</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
 */
let obj = {name:"홍길동", age:20}
let json = JSON.stringify(obj);  //json 문자열로 변환 시키는 함수 (object -> string)
obj = JSON.parse(json); // string -> object 

//json데이터 파일 변수 선언 으로 가져오기
// obj = JSON.parse(data);
// console.log(obj);

//JSP => 페이지 출력 
// AJAX = > JSON 데이터 -> 페이지 작성(DOM을 활용해서)

//json데이터 파일 변수 선언 없이 바로 불러서 가져오기 (fetch 함수를 사용해서 가져오기 )
fetch('js/MOCK_DATA.json') //해당 경로의 파일을 읽어와서 then()메소드로 전달하는데 읽어온 데이터는 then()의 메개값으로 가져온다.
	.then (function(resolve) {
		console.log(resolve);
		return resolve.json(); // json 문자열을 자바스크립트 object타입으로 변환 반환  | json() 메소드는 response 가 가지고 있는 메소드 중 하나이다.
	})
	.then(function(result){ // result = json 문자열을 자바스크립트 object타입으로 변환 된 파일 
		console.log(result);
		makeList(result);
	})




//DOM 사용 해서 데이터(data.js)를 javascript.jsp 파일의 tbody 에 넣기 
//obj 배열에 있는 건수 만큼 tr을 형성하고 tbody의 하위 요소에 등록하기 
//함수 생성 
function makeList(obj = []){
	let fields = ['id' ,'first_name','last_name','email','salary'];
	for(let i = 0; i < obj.length; i++){
		let tr = document.createElement('tr'); // tr을 형성 (데이터 갯수만큼 필요))
		//tr에 이벤트 걸기 => addEventListener (동작, 실행할 이벤트 함수)
		tr.addEventListener('mouseover',function(e){ tr.style.background='grey'});
		tr.addEventListener('mouseout',function(e){ tr.style.background=''});
		// td 형성 (th갯수 만큼 필요 = 4개 필요)
		for(let j = 0; j < fields.length; j++){
			let td = document.createElement('td'); 
			td.innerText = obj[i][fields[j]]; // obj.name , obj['name']: 필드이름을 가변적으로 가져올 수 있다. 그래서  obj[i] : 데이터배열 , [fields[j]] : 배열에 들어 있는 값
			tr.appendChild(td); // td는 tr 의 밑에 있기 때문에 하위로 연결 
		}
		document.querySelector('#show tbody').appendChild(tr);
		
		//삭제 button만들기
		let td = document.createElement('td');
		let button = document.createElement('button');
		// 삭제 버튼으로 데이터 지우기 (이벤트) (button -> td -> tr) 순으로 상속되어 있어서 )
		// button.addEventListener('click',function(e){console.log(button)}); // button의 속성을 보는 것
		button.addEventListener('click',function(e){button.parentElement.parentElement.remove()});
		// console.dir(button); // button 속성 보기 
		button.innerText='삭제';
		td.appendChild(button);
		tr.appendChild(td);
		document.querySelector('#show tbody').appendChild(tr);
		
		
		
	}
}
// makeList(); // 함수는 호출 해야지 실행된다.
// console.log(document.querySelector('#show button').closest('tr'));


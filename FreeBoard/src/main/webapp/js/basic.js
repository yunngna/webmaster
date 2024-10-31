/**
 * basic.js
 */
console.log("basic.js")

let name = "홍길동";//string
let age = 20; //number
// key 와 value 값으로 값을 나타냄 
let obj = {name:"홍길동" 
          ,age : 20
          ,showInfo : function(){
            return this.name + "-" + this.age
          }} 

console.log(obj.name);
console.log(obj['age']);
console.log(obj.showInfo());





//DOM (document object model)

// 홍길동, 박민수, 송민혁 이 들어 있는 obj 배열을 정보를 출력 하기 
let data = [obj]
data.push({name:"박민수" , age:22})
data.push({name:"송민혁" , age:25})

makeList();

function makeList(){
    document.querySelector('#show table:nth-of-type(2)').className='table';
    // 생성
    for(let i=0; i<data.length; i++) {
        //tr 생성
        tr = document.createElement('tr');
        //td 생성
        td = document.createElement('td');
        td.innerHTML = data[i]['name'];
        tr.appendChild(td);
        td = document.createElement('td');
        td.innerHTML = data[i]['age'];
        tr.appendChild(td);
        document.querySelector('#show table:nth-of-type(2) tbody').appendChild(tr);
    }
}


//<li></li> 만들기  , 안에 내용은 innerText
let li = document.createElement("li"); // li라는 변수 가져와서 담기  
li.innerText = 'Cherry';

let ul = document.querySelector('#show ul'); // css의 선택자 
ul.appendChild(li); // cherry 를 담고 있는 li 를 ul 밑에 넣기 

console.log(li);
console.log(ul);//<ul><li>Apple</li><li>Banana</li><li>Cherry</li></ul>

document.querySelectorAll('#show ul li')
          .forEach(function(fruit) {
            fruit.style.color = 'red'; 
            console.log(fruit);
            fruit.addEventListener('click',function(e){
                fruit.remove(); // 화면에서 누르면 삭제 하게 하는 동적 함수
               
            }); 
            console.log(fruit.innerHTML);
          }); 



// tr > th+td를 생성 addChild()실행 
let tr = document.createElement ("tr");
//th, td를 생성
let th = document.createElement("th")
let td = document.createElement("td");

td.innerText='이름';
tr.appendChild(td);

td.innerHTML = name;


document.querySelector('#show table tbody').appendChild(tr);





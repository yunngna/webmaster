<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- webapp바로 밑에 위치한 jsp 의 경우 서버로 바로 연결 된다. -->
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	margin: 0;
	min-width: 250px;
}

/* Include the padding and border in an element's total width and height */
* {
	box-sizing: border-box;
}

/* Remove margins and padding from the list */
ul {
	margin: 0;
	padding: 0;
}

/* Style the list items */
ul li {
	cursor: pointer;
	position: relative;
	padding: 12px 8px 12px 40px;
	list-style-type: none;
	background: #eee;
	font-size: 18px;
	transition: 0.2s;
	/* make the list items unselectable */
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

/* Set all odd list items to a different color (zebra-stripes) */
ul li:nth-child(odd) {
	background: #f9f9f9;
}

/* Darker background-color on hover */
ul li:hover {
	background: #ddd;
}

/* When clicked on, add a background color and strike out text(취소선) */
ul li.checked {
	background: #888;
	color: #fff;
	text-decoration: line-through;
}

/* Add a "checked" mark when clicked on */
ul li.checked::before {
	content: '';
	position: absolute;
	border-color: #fff;
	border-style: solid;
	border-width: 0 2px 2px 0;
	top: 10px;
	left: 16px;
	transform: rotate(45deg);
	height: 15px;
	width: 7px;
}

/* Style the close button */
.close {
	position: absolute;
	right: 0;
	top: 0;
	padding: 12px 16px 12px 16px;
}

.close:hover {
	background-color: #f44336;
	color: white;
}

/* Style the header */
.header {
	background-color: #f44336;
	padding: 30px 40px;
	color: white;
	text-align: center;
}

/* Clear floats after the header */
.header:after {
	content: "";
	display: table;
	clear: both;
}

/* Style the input */
input {
	margin: 0;
	border: none;
	border-radius: 0;
	width: 75%;
	padding: 10px;
	float: left;
	font-size: 16px;
}

/* Style the "Add" button */
.addBtn {
	padding: 10px;
	width: 25%;
	background: #d9d9d9;
	color: #555;
	float: left;
	text-align: center;
	font-size: 16px;
	cursor: pointer;
	transition: 0.3s;
	border-radius: 0;
}

.addBtn:hover {
	background-color: #bbb;
}
</style>
</head>
<body>

	<div id="myDIV" class="header">
		<h2 style="margin: 5px">My To Do List</h2>
		<input type="text" id="myInput" placeholder="Title..."> <span
			onclick="newElement()" class="addBtn">Add</span>
	</div>

	<ul id="myUL">
		<li>Hit the gym</li>
		<li class="checked">Pay bills</li>
		<li>Meet George</li>
		<li>Buy eggs</li>
		<li>Read a book</li>
		<li>Organize office</li>
	</ul>

	<script>
	//on/off가 되는 토글 (toggle)을 사용함 
// Create a "close" button and append it to each list item 
var myNodelist = document.getElementsByTagName("LI"); // getElementsByTagName = querySelectorAll와 비슷하다. 
var i;
for (i = 0; i < myNodelist.length; i++) {
  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7"); // \u00D7 취소표시(x표시) = x버튼 만들기 
  span.className = "close";
  span.appendChild(txt);
  myNodelist[i].appendChild(span);
}



// Click on a close button to hide the current list item (x 버튼 누르면 화면에서 사라지게 만들기 )
var close = document.getElementsByClassName("close"); // close == txt
var i;
for (i = 0; i < close.length; i++) {
  close[i].onclick = function() {
    var div = this.parentElement;
    div.style.display = "none";
  }
}


// Add a "checked" symbol when clicking on a list item (체크 버튼 기능)
var list = document.querySelector('ul');
list.addEventListener('click', function(ev) { //ev= event 
  if (ev.target.tagName === 'LI') {
    ev.target.classList.toggle('checked'); // checked라는 클래스가 없으면 추가, 있으면 제거로 on/off반복하는 toggle 사용 
  }
}, false);


// Create a new list item when clicking on the "Add" button (li추가 = 내용추가 )
function newElement() {
  var li = document.createElement("li");
  var inputValue = document.getElementById("myInput").value;// input 태그값 가져오기 
  var t = document.createTextNode(inputValue);
  li.appendChild(t);
  if (inputValue === '') {
    alert("You must write something!");
  } else {
    document.getElementById("myUL").appendChild(li);
  }
  document.getElementById("myInput").value = "";

  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7");
  span.className = "close";
  span.appendChild(txt);
  li.appendChild(span);

  for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
      var div = this.parentElement;
      div.style.display = "none";
    }
  }
}
</script>

</body>
</html>

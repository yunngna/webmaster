<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='dist/index.global.js'></script> <!-- <-라이브러리 -->
<script>

  document.addEventListener('DOMContentLoaded', async function() {//DOMContentLoaded(페이지가 전체 까지 다 로딩하는 것) 이벤트 발생시 함수 실행 
    var calendarEl = document.getElementById('calendar');
  	//Ajax 호출
  	// new Promise(성공했을때 실행 할 함수 function(){} , 실패시 실행할 함수 function(){} => 2개함수 전달)
  	// promise 객체가 반환 될때 await를 붙이면 await안에 수행 코드가 있으면 다 실행 후에 -> 그 다음 코드 실행 (동기방식으로 진행 되게 만드는것 ) |async + function()
  		var calendarData=[];
	    let resolve = await fetch('calendarByWirter.do')
		let result =  await resolve.json();//.then(resolve =>resolve.json())
		calendarData = result;            //.then(result => {
		                                 //calendarData = result;
		                                //});
		                               //console.log(calendarData);
				
		                              //})
		                             //.catch(err=>console.log(err));
  	console.log(calendarData);
	    
    var calendar = new FullCalendar.Calendar(calendarEl, { // 자바스크립트에서 object 타입은 {중괄호} 사용 
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      initialDate: '2024-10-01',
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      
      
      // 이벤트 추가 함수 (이벤트 추가 함수 데이터 형식에 맞게 query문을 작성해야 한다. [중요])
      select: function(arg) { // arg = start,end
        var title = prompt('Event Title:');
        if (title) {
        	console.log(arg);
        	//title,start,end 값 전달  (arg = start,end)

			let start = eventDate(arg.start, arg.allDay);
			let end = eventDate(arg.end, arg.allDay);
			
        	fetch('addEvent.do?title='+title+'&start='+start+'&end='+end)
        		.then (resolve=>resolve.json())
        	//성공시 화면에 출력 
        		.then (result => {
        			if (result.retCode == 'OK'){
        				 calendar.addEvent({
      			            title: title,
      			            start: arg.start,
      			            end: arg.end,
      			            allDay: arg.allDay
      			          })
        			}else if (result.retCode == 'FAIL'){
        				calendar.unselect()
        			}
        		})
        		.catch(err => console.log(err));	  
        }//end of if
        
      },//end of function 
      
      //이벤트 삭제 함수 
      eventClick: function(arg) {
        if (confirm('Are you sure you want to delete this event?')) {
          arg.event.remove()
        }
      },
      
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      events: calendarData //데이터
      /* [ // object타입으로 배열 안에 데이터가 들어있다. 
    	
	        {
	          title: 'All Day Event',
	          start: '2023-01-01'
	        },
	        {
	          title: 'Long Event',
	          start: '2023-01-07',
	          end: '2023-01-10'
	        },
	        {
	          groupId: 999,
	          title: 'Repeating Event',
	          start: '2023-01-09T16:00:00'
	        },
	        {
	          groupId: 999,
	          title: 'Repeating Event',
	          start: '2023-01-16T16:00:00'
	        },
	        {
	          title: 'Conference',
	          start: '2023-01-11',
	          end: '2023-01-13'
	        },
	        {
	          title: 'Meeting',
	          start: '2023-01-12T10:30:00',
	          end: '2023-01-12T12:30:00'
	        },
	        {
	          title: 'Lunch',
	          start: '2023-01-12T12:00:00'
	        },
	        {
	          title: 'Meeting',
	          start: '2023-01-12T14:30:00'
	        },
	        {
	          title: 'Happy Hour',
	          start: '2023-01-12T17:30:00'
	        },
	        {
	          title: 'Dinner',
	          start: '2023-01-12T20:00:00'
	        },
	        {
	          title: 'Birthday Party',
	          start: '2023-01-13T07:00:00'
	        },
	        {
	          title: 'Click for Google',
	          url: 'http://google.com/',
	          start: '2023-01-28'
	        }
	         
	      ]*/
      
    });

    calendar.render(); //  위에서 생성 한 => var calendar = new FullCalendar.Calendar | calendar 메소드 중 하나이 render();
  });

  const eventDate = (date, allDay) => {
	console.log(allDay)
	if(allDay) {
		let year = date.getFullYear();
		let month = date.getMonth() + 1;
		let day = date.getDate();

		if(month < 10) month = "0" + month;
		if(day < 10) day = "0" + day;

		return year + "-" + month + "-" + day; 
	} else {
		let year = date.getFullYear();
		let month = date.getMonth() + 1;
		let day = date.getDate();
		let hours = date.getHours();
		let minute = date.getMinutes();
		let second = date.getSeconds();

		if(month < 10) month = "0" + month;
		if(day < 10) day = "0" + day;
		if(hours < 10) hours = "0" + hours;
		if(minute < 10) minute = "0" + minute;
		if(second < 10) second = "0" + second;

		return year + "-" + month + "-" + day + "T" + hours + ":" + minute + ":" + second; 

	}
	

	
  }

</script>
<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 1100px;
    margin: 0 auto;
  }

</style>
</head>
<body>

  <div id='calendar'></div>

</body>
</html>
    
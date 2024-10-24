<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      
    //데이터 가져오기
      var chartData =[
    	  	['Writer','Count per Writer']
    	]; // 데이터 가져오기 위해서 먼저 chartData라는 배열 선언 
    	  
      fetch('countByWriter.do')
      	  .then(resolve =>resolve.json())
      	  .then(result => {
      		  console.log(result);
      		  result.forEach((row)=>{ //function 
      			  chartData.push([row.member_name, row.count]); // charData 배열에 
      			  
      		  });
      			console.log(chartData);
      			
	      		google.charts.load('current', {'packages':['corechart']});
	            google.charts.setOnLoadCallback(drawChart); 
	            //drawChart()함수를 매개값으로 가져와서 setOnLoadCallback 실행 
      		  
      	  })
      	  .catch(err=> console.log(err));
      
      

      function drawChart() {
	
        var data = google.visualization.arrayToDataTable(chartData // 데이터 반환을 위해서는 컨트롤이 필요하다. (컨트톨(jsp부르는용,데이터가져오는용)만들고 패치함수 사용)
	         /* 배열 안에 map 형태로 되어있다.
	          [
		          ['Task', 'Hours per Day'],
		          ['Work',     11],
		          ['Eat',      2],
		          ['Commute',  2],
		          ['Watch TV', 2],
		          ['Sleep',    7],
		          ['test',     3]
	          ]*/
       
          ); 

        var options = {
          title: '사용자별 게시글 사용 현황'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart')); //piechart 는 html 파일을 가져오기 (밑에 참고)

        chart.draw(data, options); // 데이터와 옵션을 가져와서 차트 그려주는 부분
   
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>

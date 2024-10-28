/**
 * jreply.js
 */

console.log("start");

//댓글목록 호출
$.ajax('replyList.do?bno=' + bno + '&page=1')
	.done(function(result) {
		console.log(result); // [{}...{}]
		result.forEach((item) => {
			$('<li />').append(
				$('<span />').addClass('col-sm-2').text(item.replyNo), // 댓글번호
				$('<span />').addClass('col-sm-5').text(item.reply), // 댓글내용
				$('<span />').addClass('col-sm-2').text(item.replyer), // 작성자
				$('<span />').addClass('col-sm-2').append($('<button>삭제</button>')) // 삭제버튼
			)
				.appendTo($('div.content ul'))
		});
	})
	.fail(function(err) {
		console.log(err);
	})

//삭제 이벤트 
$('div.content ul').on('click','button', function(e) {
	//$(e.target).parent().parent().remove();
	console.log($(e.target).parent().parent().find('span:eq(0)').text()); // 댓글 번호 가져오기 button의 상위 + 상위 = li에서 span의 인덱스 0번째 것 
	let rno = $(e.target).parent().parent().find('span:eq(0)').text();
		
	$.ajax({
		url: 'removeReply.do',
		data:{rno: rno},
		method: 'get',
		dataType : 'json' // 문자열 을 자바스크립트 객체로 변경 
	})
	.done(function(result){
		console.log(result.retCode);
		if(result.retCode=='OK'){
			$(e.target).closest('li').remove();
		}
	})
	.fail(function(err){
		console.log(err);
	}); // 삭제 
})

//등록이벤트 
$('#addReply').on('click', function(e) {
	// bno (글번호), reply , replyer 가져오기 
	//bno 글번호 

	let reply = $('#reply').val();
	let replyer = logId;
	if (!reply || !logId) {
		alert('값입력');
		return;
	}

	$.ajax({
		url: 'addReply.do',
		data: { bno: bno, reply: reply, replyer: replyer },
		method: 'post',
		dataType: 'json'
	})
		.done(function(result) {
			console.log(reply, logId);
			if (result.retCode=='OK') {
				console.log(result.retCode);
				let item = result.retVal;
				$('<li/>').append(
					$('<span />').addClass('col-sm-2').text(item.bno), //  글번호
					$('<span />').addClass('col-sm-5').text(item.reply), // 댓글내용
					$('<span />').addClass('col-sm-2').text(item.replyer), // 작성자
					$('<span />').addClass('col-sm-2').append($('<button>댓글등록</button>')) // 삭제버튼
				)
				.insertAfter($('div.content ul li:eq(0)'))
				//$('div.content ul li:eq(0)')는 .content 클래스를 가진 div 안에 있는 ul 리스트의 첫 번째 li 요소를 선택
			}


		}).fail(function(err) {
			console.log(err);
	}); 
})

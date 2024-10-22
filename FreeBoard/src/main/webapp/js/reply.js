/**
 * reply.js
 * replyService 생성했던 메소드 활용  
 */


svc.showMsg('Hello');
svc.rlist(403 // bno번호
	,function(result){
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
		
	}//successFuc
	,function(err){
		console.log(err);
	}//errorFuc
)
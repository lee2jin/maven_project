<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
.container{
	width: 70%;
	margin: 0 auto;
}
#add{
display: block;
}
ul{
list-style: none;
float: left;
display: block;
}
p{
text-align: center;
width: 200px;
background-color: rgb(200, 216, 216);
}
li{
}
input{
size: 100px;

}
table {
	 width: 100%;
     border-collapse: seperate;
     border-spacing: 0;
     border: solid 1px black;
}
thead{
background-color: black;
color: white;
}
td{
text-align: center;
}

</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class = "container">
	<jsp:include page="../menu/메뉴바.jsp" />
	<div id = "add">
		<ul>
			<li><p>도서코드</p><input type = "text" id="bId" name="bId" ></li>
			<li><p>도서명</p><input type = "text" id="bname" name="bname"></li>
			<li><p>저자</p><input type = "text" id="bwriter" name="bwriter"></li>
			<li><p>출판사</p><input type = "text" id="bcom" name="bcom"></li>
			<li><p>금액</p><input type = "text" id="bprice" name="bprice"></li>
		</ul>
		<ul id="btn">
			<li><button id="insertBtn">저장</button></li>
			<li><button>선택삭제</button></li>
		</ul>
		
	
	</div>
	
	<div id = "list">
		<table>
			<thead>
				<tr>
					<td><input type = "checkbox"></td>
					<td>도서코드</td>
					<td>도서명</td>
					<td>저자</td>
					<td>출판사</td>
					<td>가격</td>
					<td>삭제</td>
				</tr>
			</thead>
			<tbody id = "bookData"></tbody>
		</table>
	</div>
	</div>

	<script src='js/book.js'></script>
	<script>
	const bookObj = new Book();
	let bookId = "${b.bookId}";
	const fields = ['bookId', 'bookName', 'bookWriter', 'bookCom', 'bookPrice'];
	bookObj.bookList(bookId, function(data){
		console.log(data);
		data.forEach(function (book) {
			let tr = makeTr(book);
		    document.querySelector('#bookData').appendChild(tr);
		})
	})
	
	function makeTr(book) {
					//console.log(book);
					let tr = document.createElement('tr');
					//tr.addEventListener('dblclick', showEditForm); //더블클릭이벤트 
					tr.setAttribute('bid', book.bookId);
					let td = document.createElement('td');
					let input = document.createElement('input');
					input.type = "checkbox";
					td.appendChild(input);
					tr.appendChild(td);
					for (let prop of fields) {
						let td = document.createElement('td');
						td.innerText =book[prop];
						  tr.appendChild(td);
					}
					td = document.createElement('td');
					let btn = document.createElement('button');
					btn.innerText = "삭제";
					//btn.addEventListener('click', deleteReplyFnc);
					td.appendChild(btn);
					tr.appendChild(td);
					//document.querySelector('#replyList').appendChild(tr);
					return tr;
				}
	
	
	$("#insertBtn").click(function () {
		console.log("확인");
		let id = document.querySelector('input[name=bId]').value;
		let name = document.querySelector('input[name=bname]').value;
		let writer = document.querySelector('input[name=bwriter]').value;
		let com = document.querySelector('input[name=bcom]').value;
		let price = document.querySelector('input[name=bprice]').value;
				
		$.ajax({
			url: 'ajaxbookinsert.do',
			type: 'post',
			data: {
				id: id,
				name: name,
				writer: writer,
				com: com,
				price: price,
			},
			success: function (e) {
				console.log(e.retCode);
				if (e.retCode == 'Success') {
					alert('등록 완료');
				} else {
					alert('등록 실패');
				}
			},
			error: function (e) {
				console.log(e.retCode);
			}

		})
	});
	</script>
</body>
</html>
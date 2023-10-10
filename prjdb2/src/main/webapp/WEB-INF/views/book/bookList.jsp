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
			<li><button id="delBtn" name="delBtn">선택삭제</button></li>
		</ul>
		
	
	</div>
	
	<div id = "list">
		<table>
			<thead>
				<tr>
					<td><input type = "checkbox" id="checkAll" name="check"></td>
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
					//체크박스
					let check = document.createElement('input');
					check.setAttribute('type', 'checkbox');
					check.setAttribute('data-bid', book.bookId); //data-() : 개인적인 속성 만들기 넘 신기
					check.setAttribute('class', 'book_chk');
					td.appendChild(check);
					tr.appendChild(td);
					
					for (let prop of fields) {
						let td = document.createElement('td');
						td.innerText =book[prop];
						  tr.appendChild(td);
					}
					td = document.createElement('td');
					let btn = document.createElement('button');
					btn.innerText = "삭제";
					btn.setAttribute('onclick', 'bookDel("'+book.bookId+'",this)');
					td.appendChild(btn);
					tr.appendChild(td);
					//document.querySelector('#replyList').appendChild(tr);
					return tr;
				}
	
	
	$("#insertBtn").click(function () {
		console.log("확인");
		let bookId = document.querySelector('input[name=bId]').value;
		let bookName = document.querySelector('input[name=bname]').value;
		let bookWriter = document.querySelector('input[name=bwriter]').value;
		let bookCom = document.querySelector('input[name=bcom]').value;
		let bookPrice = document.querySelector('input[name=bprice]').value;
		
		const book = {bookId:bookId, bookName:bookName, bookWriter:bookWriter,
				bookCom:bookCom, bookPrice:bookPrice}
		//console.log('book들어옴')
		//console.log(book)
		
		bookObj.bookAdd(book, function(data){
			console.log('bookAdd들어옴')
			if(data.retCode == 'Success'){
				let tr = makeTr(data.data);
				document.querySelector('#bookData').appendChild(tr);
				fieldInit(); //댓글등록 후 창 비우기
			}else if (data.retCode == 'Fail'){
				alert("에러!")
			}else{
				alert("잘못된 코드 반환")
			}
		})
	});
	
	function fieldInit() { //댓글등록후 창 비우기
		document.querySelector('input[name=bId]').value='';
		document.querySelector('input[name=bname]').value='';
		document.querySelector('input[name=bwriter]').value='';
		document.querySelector('input[name=bcom]').value='';
		document.querySelector('input[name=bprice]').value='';
	}
	
	//삭제버튼 클릭
	function bookDel(bookId, obj){
		console.log("삭제 버튼 누름");
		bookObj.bookDelete(bookId, function (result){
			console.log(result);
			console.log(obj);
			if(result.retCode == 'Success'){
				obj.parentElement.parentElement.remove();
			}else if (data.retCode == 'Fail'){
				alert("에러!")
			}else{
				alert("잘못된 코드 반환")
			}
		})
	}
	
	//체크된거 삭제
	document.querySelector('#delBtn').addEventListener('click', function (e) {
		let checkbox = document.querySelectorAll('.book_chk');
		console.log('del들어오나요');
		for (let c of checkbox) {
			if (c.checked == true) {
				let bookId = c.getAttribute('data-bid');
				console.log(bookId);

				bookObj.bookDelete(bookId, function (data) {
					console.log(data);

					if (data.retCode == 'Success') {
						c.parentElement.parentElement.remove();
					} else if (data.retCode == 'Fail') {
						alert("처리중 에러.");
					} else {
						alert("잘못된코드반환.");
					}
				})
			}
		}
	})
	//전체 체크
			document.querySelector('#checkAll').addEventListener('change', function (e) {
				let checkbox = document.querySelectorAll('input[type=checkbox]');
				console.log(e);
				console.log(e.target.checked);
				if (e.target.checked == true) {
					for (let prop of checkbox) {
						prop.checked = true;
					}
				} else {
					for (let prop of checkbox) {
						prop.checked = false;
					}
				}
			})
	</script>
</body>
</html>
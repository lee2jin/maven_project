<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<jsp:include page="../menu/메뉴바.jsp" />
		<div>
			<h2>게시글 목록</h2>
		</div>
		<div>
			<form id="search">
				<table border="1">
					<tr>
						<td><label for="key">Choose a key:</label> <select name="key"
							id="key">
								<option value="title">제목</option>
								<option value="subject">내용</option>
								<option value="writer">작성자</option>
						</select> <input type="text" name="val" id="val">&nbsp;&nbsp; <input
							type="button" id="btn" value="검색" onclick="searchList()"></td>
					</tr>
				</table>
			</form>
		</div>
		<br>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="50">순번</th>
						<th width="100">이미지</th>
						<th width="250">제목</th>
						<th width="100">작성자</th>
						<th width="100">작성일자</th>
						<th width="50">조회수</th>
						<th width="100">첨부파일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty notices }">
							<tr>
								<td colspan="7" align="center">데이터가 존재하지 않습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${notices }" var="n">
								<tr onmouseover="this.style.background='#C8FE2E'"
									onmouseout="this.style.background='#FFFFFF'"
									onclick ="selectNotice(${n.noticeId})">
									<td align="center">${n.noticeId }</td>
									<td align="center">
										<img src="attech/notice/${n.noticeThumb }">
									</td>
									<td>${n.noticeTitle }</td>
									<td align="center">${n.noticeWriterName }</td>
									<td align="center">${n.noticeDate }</td>
									<td align="center">${n.noticeHit }</td>
									<td align="center">${n.noticeAttech }</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<br>
		<div>
			<c:if test="${not empty id }">
				<button type="button" onclick="location.href='noticewriteform.do'">글쓰기</button>
			</c:if>
		<form action="noticeselect.do" id="sform" method="post">
			<input type = "hidden" id="noticeId" name= "noticeId"> 
		</form>
		</div>
	</div>
	<script type="text/javascript">
		function selectNotice(id){
			let form = document.getElementById("sform");
			form.noticeId.value = id;
			form.submit();
		}

		function searchList(){ //ajax post 방식
			let form =document.getElementById("search");
			const formData = new FormData(form); //자바스크립트 FormData class
			let playload= formData;
			let url="ajaxNoticeSearch.do"
			fetch(url,{
				method: "POST",
				body: payload
			}).then(response=>response.json()) // 결과받는 콜백함수
				.then(json=>htmlViews(json)); // 처리하는 콜백함수
		}
		function htmlViews(){
			
		}
	</script>
</body>
</html>
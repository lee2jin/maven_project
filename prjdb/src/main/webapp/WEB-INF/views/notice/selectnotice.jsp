<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <div align="center">
     <jsp:include page="../menu/메뉴바.jsp"/>
     	<div><h1>게시글 상세보기</h1></div>
     	<div>
     		<div>
		<table border="1">
			<tr>
				<th width="100">작성자</th>
				<td width="150">${n.noticeWriterName}</td>
				
				<th width="100">작성일</th>
				<td width="150">${n.noticeDate}</td>
				
			</tr>
			
		<tr>
			<th>이미지</th>
			<td colspan="5">
				<input type="file" id = "imgfile" name="imgfile" required="required">
			</td>
		</tr>
		<tr>
			<th>제 목</th>
			<td colspan="5">${n.noticeTitle }</td>
		</tr>
		<tr>
			<th>내 용</th>
			<td colspan="5">
				<textarea rows="10" cols="80">${n.noticeContent }</textarea>
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="5">${noticeAttach}</td>
		</tr>
		</table>
	</div><br>
		<div>
			<input type="hidden"  name="noticeWriter" value="${id }">&nbsp;&nbsp;
			<input type="submit" value="글등록">&nbsp;&nbsp;
			<input type="reset" value="취소">
		</div>
     	</div>
     </div>
</body>
</html>
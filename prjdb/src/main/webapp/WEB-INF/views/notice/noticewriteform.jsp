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
<div>
<form id="frm" action="noticewrite.do" method="post" enctype="multipart/form-data">
	<div>
		<table border="1">
			<tr>
				<td width="100">작성자</td>
				<td width="150">
					<input type="text" id="noticeWriterName" name="noticeWriterName"
					 value="${name }" readonly>
				</td>
				<td width="100">작성일자</td>
				<td width="150" align="center">
					<input type="date" id="noticeDate" name="noticeDate" required="required">
				</td>
			</tr>
			
		<tr>
			<th>이미지</th>
			<td colspan="3">
				<input type="file" id = "imgfile" name="imgfile" required="required">
			</td>
		</tr>
		<tr>
			<th>제 목</th>
			<td colspan="3">
				<input type="text" size="67" id = "noticeTitle" name="noticeTitle" required="required">
			</td>
		</tr>
		<tr>
			<th>내 용</th>
			<td colspan="3">
				<textarea rows="10" cols="64" id = "noticeContent" name="noticeContent"></textarea>
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="3">
				<input type="file" id = "attechfile" name="attechfile">
			</td>
		</tr>
		</table>
	</div><br>
		<div>
			<input type="hidden"  name="noticeWriter" value="${id }">&nbsp;&nbsp;
			<input type="submit" value="글등록">&nbsp;&nbsp;
			<input type="reset" value="취소">
		</div>
</form>
</div>

</body>
</html>
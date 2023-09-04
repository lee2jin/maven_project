<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <h2>게시글 목록</h2>
</div>
<form action="">
    <table border="1">
     <tr>
          <td>
        <label for="key">Choose a key:</label>
        <select id="key" name="key">
            <option value ="title">제목</option>
            <option value ="content">내용</option>
            <option value ="writer">작성자</option>
        </select>
        <input type="text" name="val" id="val">&nbsp;&nbsp;
        <input type="button" id="btn" value="검색" onclick="serchList()">
         </td>
    </tr>
    </table>
</form>
</div><br>
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
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>
</div>

</body>
</html>
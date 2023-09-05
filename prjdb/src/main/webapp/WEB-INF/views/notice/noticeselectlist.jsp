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
<form id="search">
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
        <input type="button" id="btn" value="검색" onclick="searchList()">
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
       
       		 <c:choose>
       		 	<c:when test="${empty notices }">
       			 <tr>
       				 <td colspan="7" align = "center" >데이터가 존재하지 않습니다.</td>
       			 </tr>
       		 </c:when>
       		 <c:otherwise>
       			  <c:forEach items="${notices }" var="n">
          				<tr>
              			  <td align="center">${n.noticeId }</td>
              			  <td align="center">
                                <img src="attech/notice/${n.noticeImage }">
                           </td>
              			  <td>${n.noticeTitle }</td>
             			   <td align="center">${n.noticeWriterName }</td>
             			   <td align="center">${n.noticeDate }</td>
             			   <td align="center">${n.noticeHit }</td>
             			   <td align="center">${n.noticeAttach }</td>
         			   </tr>
          		  </c:forEach>
          	  </c:otherwise>
            </c:choose>
        </tbody>
    </table>
</div><br>
<div>
<script>

function searchList(){ //ajax 포스트 방식
    let form = document.getElementById("search");
    let key = form.key.value;
    let value = form.value.value;
  //  const formData = new FormData(form); //자바스크립트 FormData class / 포스트 방식으로 던질때는 폼 방식으로 받는게 좋다
 //   let payload = formData;
  let payload = "key"+key+"&val"+val;
    let url = "ajaxNoticeSearch.do";
    fetch(url,{
        method: "POST",
        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        body:payload
    }).then(Response => Response.json())
      .then(json =>htmlViews(json));
}

function htmlViews(datas) {
	document.querySelect('tbody').remove();
	const tbody = document.createElement('tbody');
	tbody.innerHTML = datas.map(data => )
	
}

function enterKey(e) {
	if
	
}
</script>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Admin: 관리자 방</h1>

<p>사용자이름: <sec:authentication property="principal.member.uname"/></p>
<p>사용자이름: <sec:authentication property="principal.member.uid"/></p>
<p>사용자이름: <sec:authentication property="principal.member.upw"/></p>
<p>사용자권한: <sec:authentication property="principal.member.authList"/></p>


 <form action="/customLogout" method="post">
<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
<button class="btn btn-danger">Logout</button>
<!-- 멤버 관리 -->
<!-- 멤버가 등록한 게시글 관리 -->
<!-- 전체 게시글 관리 -->
 
</form>
</body>
</html>
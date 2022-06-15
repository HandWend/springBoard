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
<h1>All: 누구냐</h1>

<sec:authorize access="isAnonymous()">
<button class="btn btn-primary"><a href="/customLogin">로그인</a></button>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
 <form action="/customLogout" method="post">
<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
<button class="btn btn-danger">Logout</button>
</form>
</sec:authorize>

</body>
</html>
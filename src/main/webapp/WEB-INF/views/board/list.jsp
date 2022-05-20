<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!-- JSP include -->

<!-- JSP include -->
<%@ include file="../includes/header.jsp" %>
<!-- JSP 액션태그 include -->
<%-- <jsp:include page="../includes/header.jsp"></jsp:include> --%>

			<div class="col-md-12">
				<h4 class="m-b-lg">Tables</h4>
			</div><!-- END column -->


			<div class="col-md-12">
				<div class="widget p-lg">
					<h4 style="display:inline;" class="m-b-lg">Board List Page</h4>
					<a href="register" style="float:right;" class="btn btn-primary" role="button">Register New Board</a>
					<p class="m-b-lg docs">
						<!-- Add <code>.table-hover</code> to enable a hover state on table rows within a <code>&lt;tbody&gt;</code>. -->
					</p>

					<table class="table table-hover">
					<thead>
						<tr>
							<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>수정일</th>
						</tr>
					</thead>
					<!-- var: 변수선언, items: 넘겨받는 값 -->
					<c:forEach items="${list }" var="board" >
						<tr>
							<td>${board.bno }</td>
							<td><a href="get?bno=${board.bno }">${board.title }</a></td>	<!-- get 방식으로 가는 것. -->
							<td>${board.wrtier }</td>
							<td><f:formatDate value="${board.regDate }" pattern="Y-M-d HH:mm:ss"/></td>
							<td><f:formatDate value="${board.updateDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
					</c:forEach>
					</table>
					
				</div><!-- .widget -->
			</div><!-- END column -->
			<table class="table table-hover">
						<tr>
							<th>bno</th><th>title</th><th>writer</th><th>regDate</th>
						</tr>
						<tr><td>1</td><td>11</td><td>22</td><td>33</td></tr>
						<tr><td>2</td><td>Jacob</td><td>Thornton</td><td>@fat</td></tr>
						<tr><td>3</td><td>Larry</td><td>the Bird</td><td>@twitter</td></tr>
					</table>
					
<!-- JSP include -->
<jsp:include page="../includes/footer.jsp"/>
<%-- <%@ include file="../includes/footer.jsp" %> --%>
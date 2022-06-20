<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %> 
<!-- JSP include -->
<%-- <%@ include file="../includes/header.jsp" %> --%>
<!-- JSP 액션태그 include -->
<jsp:include page="../includes/header.jsp"></jsp:include>

			<div class="col-md-12">
				<h4 class="m-b-lg">Member Authority List Page</h4>
			</div><!-- END column -->


			<div class="col-md-12">
				<div class="widget p-lg">
					<h4 style="display:inline;" class="m-b-lg">Management</h4>
					<!-- <a href="register" style="float:right;" class="btn btn-success" role="button">Register New Member</a> -->
					<p class="m-b-lg docs">
					</p>

					<table class="table table-hover">
						<thead>
							<tr><th>#번호</th><th>ID</th><th>권한</th><th>권한관리</th></tr>
						</thead>
						
						<c:forEach items="${list}" var="author" varStatus="num">
						<tr>
							<td>${num.count }</td>
							<td>${author.uid }</td>
							<td>${author.authority }</td>
							<td></td>
						</tr>
						<!-- <c:set value="${author.uid }" var="uid"></c:set> -->
						<%-- <tr>
							<td>${member.num}</td><td>
							<a href="get?num=${member.num}">${member.uname}</a></td>
							<td>${member.schoolname}</td>
							<td>${member.gradeclass}</td>
							<td>${member.uid}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${member.joindate}"/></td>
							<td><a href="getMemberAuths?uid=${member.uid }">추가 / 삭제</a></td>
						</tr> --%>
						</c:forEach>
					</table>
					
					
					<div class="container-fluid">
						<div class="row">
						  <div class="col-xs-7 pagination">
							  <form method="post" action="wjg">
							  <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
							  <input type="hidden" name="uid" value="${uid }"/>
								<select name="authority" class="form-control" style="float:left; width:50%; height:32px;">
									<option value="">Add authority</option>
									<option value="ROLE_ADMIN" >Admin</option>
									<option value="Role_MEMBER">Manager</option>
									<option value="Role_USER">User</option>
								</select>
								<button class="btn btn-default btn-sm" style="float:left;">add authority</button>
							  </form>
						  </div>
						  <div class="col-xs-5" style="text-align:right;">
							  <ul class="pagination">
							  	<c:if test="${pageMaker.prev}">
							    <li class="paginate_button">
							      <a href="?pageNum=${pageMaker.startPage - 1}" aria-label="Previous">
							        <span aria-hidden="true">&laquo;</span>
							      </a>
							    </li>
							    </c:if>
							    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num">
							    <li class="paginate_button">
							    	<a href="?pageNum=${num}">${num}</a>
							    </li>
							    </c:forEach>
							    <c:if test="${pageMaker.next}">
							    <li class="paginate_button">
							      <a href="?pageNum=${pageMaker.endPage + 1}" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							      </a>
							    </li>
							    </c:if>
							  </ul>
						  </div>
						</div>
					</div>
					
				</div><!-- .widget -->
			</div><!-- END column -->

<!-- JSP 액션태그 include -->
<jsp:include page="../includes/footer.jsp"></jsp:include>
<!-- JSP include -->
<%-- <%@ include file="../includes/footer.jsp" %> --%>




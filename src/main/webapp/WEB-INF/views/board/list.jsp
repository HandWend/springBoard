<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!-- JSP include -->

<!-- JSP include -->
<%@ include file="../includes/header.jsp"%>
<!-- JSP 액션태그 include -->
<%-- <jsp:include page="../includes/header.jsp"></jsp:include> --%>

<div class="col-md-12">
	<h4 class="m-b-lg">Tables</h4>
</div>
<!-- END column -->


<div class="col-md-12">
	<div class="widget p-lg">
		 <h4 style="display: inline;" class="m-b-lg">Board & Gallery</h4> 
		
		<a href="register" style="float: right;" class="btn btn-primary" role="button">Register New Board</a><br/>
		
		<p class="m-b-lg docs">
			
		</p>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>수정일</th>
				</tr>
			</thead>
			<!-- var: 변수선언, items: 넘겨받는 값 -->
			<c:forEach items="${list }" var="board">
				<tr>
					<td>${board.bno }</td>
					<td><a href="get?bno=${board.bno }">${board.title }</a></td>
					<!-- get 방식으로 가는 것. -->
					<td>${board.writer }</td>
					<td><f:formatDate value="${board.regDate }"
							pattern="Y-M-d HH:mm:ss" /></td>
					<td><f:formatDate value="${board.updateDate }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
			</c:forEach>
		</table>
	<div class="container-fluid">
						<div class="row">
						  <div class="col-xs-7 pagination">
						  
						  <div>
						  <form>
						  <!-- cri.type -->
							<select name="type" class="form-control" style="float:left; width:21%; height:32px;">
									<option value="">전체</option>
									<option value="title" ${pageMaker.cri.type == "title"?"selected='selected'":""}>제목</option>
									<option value="content" ${pageMaker.cri.type == "content"?"selected='selected'":""}>내용</option>
								</select>
							<!-- cri.keyword -->
							<!-- jQuery로 안 할 거면 id 필요 없음. -->
							<!-- value에다 넘어온 값 출력 -->
							<input type="text" placeholder="검색어를 입력하세요" value="${pageMaker.cri.keyword }" name="keyword" class="form-control" style="float:left; width:50%;">
							<button class="btn btn-default" style="float:left;">검색</button>
							</form>
							</div>
							
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
	<!-- .widget -->
</div>
</div>
<!-- END column -->
<form id="operForm" action="" method="get">
	<input type="hidden" id="pageNum" name="pageNum" value="${pageMaker.cri.pageNum }"> <input
		type="hidden" name="amount" value="${pageMaker.cri.amount }">
</form>
<script>
/* e.preventDefault() 무효화 버튼, 누르면 이동해야 하는데 안 감 */
	$(document).ready(function() {
		$(".paginate_button a").on("click", function(e) {
			e.preventDefault();
			$("#pageNum").val($(this).attr("href"));
			$("#operForm").submit();
		});
	});
</script>


<!-- JSP include -->
<jsp:include page="../includes/footer.jsp" />
<%-- <%@ include file="../includes/footer.jsp" %> --%>
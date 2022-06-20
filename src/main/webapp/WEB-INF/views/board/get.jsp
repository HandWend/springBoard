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
				<h4 class="m-b-lg">Board Read Page</h4>
			</div><!-- END column -->


			<div class="col-md-12">
				<div class="widget p-lg">
					<h4 style="display:inline;" class="m-b-lg">Board Read Page</h4>
					<p class="m-b-lg docs">
						<!-- Add <code>.table-hover</code> to enable a hover state on table rows within a <code>&lt;tbody&gt;</code>. -->
					</p>

					<div class="panel-body">
					<!--  Get으로 온걸 Post로 넘긴다. -->
					<!-- action에 값이 없는 것은  자기 자신에게로 값을 던진다. -->
						<form id="frm" method="post" action="" enctype="multipart/form-data">
						<input type="hidden" id="bno" name="bno" value=" ${board.bno }" required="required">
						<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
						<div class="form-group">
							<label>Title</label><input type="text" name="title" id="title" class="form-control" value="${board.title }" required="required">
						</div>	
						<div class="form-group">
							<label>Content</label><textarea  required="required" name="content" id="content" class="form-control" style="resize:none">${board.content }</textarea>
						</div>
						<div>
							<label>Content Printing</label><input id="conPrint" class="form-control" value="${board.content }" readonly="readonly">
						</div>
						
							
							<!-- display?fileName=sm_ -->
								<c:set value="-1" var="cnt"></c:set>
								<c:forEach items="${board.attachList}" var="attach" varStatus="status">
								<input type="hidden" name="oldfile" value="${attach.fileName}">
								<c:set value="${status.count}" var="cnt"></c:set> 
								<a href="/download?fileName=${attach.fileName}"><img src="display?fileName=sm_${attach.fileName}" alt="첨부이미지"></a>
								</c:forEach>
								<c:if test="${cnt == -1}"><input type="hidden" name="oldfile" value=""></c:if>
						<div class="form-group">
							<label>Image</label><input  type="file" multiple="multiple" name="upfile" id="upfile" class="form-control" value="">
						</div>	
						
						<div class="form-group">
							<label>Writer</label><input value="${board.writer }" required="required" type="text" name="writer" id="writer" class="form-control" value="">
						</div>	
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Update</button>
							<button type="button" id=btn_list class="btn btn-default">Cancel</button>
							<button type="button" id="btn_del" class="btn btn-link pull-right">Delete</button>
						</div>
						</form>
						
					</div>
					
				</div><!-- .widget -->
			</div><!-- END column -->
			
<script>
	$(document).ready(function () {
		/* Delete 버튼 클릭 시 삭제 여부 묻게 하기 */
		$("#btn_del").on("click", function () {
			
			if(confirm("정말로 삭제하시겠습니까")) {
				// get방식(링크): location.href="remove?bno=${board.bno}"
				// POST방식(폼)
				$("#frm").attr("action", "remove");
				$("#frm").submit();
						
			}
			console.log("삭제버튼" + res);
		})
		
		/* cancel 버튼 클릭 시 다시 list(목록)(으)로 돌아가게 하기 */
		$("#btn_list").on("click", function () {
			$(location).attr("href", "./list");
		})
		
		/* textarea에서 enter 난타하고 Content Printing에서 한 줄로 출력하기 */
		var str = $("#content").val();

		str = str.replace(/(?:\r\n|\r|\n)/g, '<br />');

		//$("#conPrint").html(str);
		//$("conPrint").val(str);
		
		//trim() 작업장
		/* $.trim("#title"); */
		
		/* var title=$("#title").val(); */
		/* $.trim($("#title").val()); */
		/* $(title).trim(); */
		/* $("#title").val().replace(/,/g, '');  */
		/* $("#title").html($.trim("#title")) */
	});

</script>
<!-- JSP include -->
<jsp:include page="../includes/footer.jsp"/>
<%-- <%@ include file="../includes/footer.jsp" %> --%>
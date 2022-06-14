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
				<h4 class="m-b-lg">Board Register</h4>
			</div><!-- END column -->


			<div class="col-md-12">
				<div class="widget p-lg">
					<h4 style="display:inline;" class="m-b-lg">Board Register</h4>
					<p class="m-b-lg docs">
						<!-- Add <code>.table-hover</code> to enable a hover state on table rows within a <code>&lt;tbody&gt;</code>. -->
					</p>

					<div class="panel-body">
					<!--  Get으로 온걸 Post로 넘긴다. -->
					<!-- action에 아무것도 안 적으면 자기자신의 페이지를 부른다. -->
					<!-- 첨부파일: encType="multipart/form-data" -->
						<form method="post" action="" encType="multipart/form-data">
						<div class="form-group">
							<label>Title</label><input type="text" name="title" id="title" class="form-control" value="" required="required">
						</div>	
						<div class="form-group">
							<label>Content</label><textarea required="required" name="content" id="content" class="form-control" style="resize:none"></textarea>
						</div>
						<div class="form-group">
							<label>File</label><input required="required" multiple="multiple" type="file" name="upfile" id="upfile" class="form-control" value="">
						</div>
						<div class="form-group">
							<label>Writer</label><input required="required" type="text" name="writer" id="writer" class="form-control" value="">
						</div>	
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="button" class="btn btn-link">Cancel</button>
						</div>
						</form>
						
					</div>
					
				</div><!-- .widget -->
			</div><!-- END column -->
			
					
<!-- JSP include -->
<jsp:include page="../includes/footer.jsp"/>
<%-- <%@ include file="../includes/footer.jsp" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<br />
	<form>
		<div class="mb-3 mt-3">
			경기장 이름: <input id="stadiumName" type="text" class="form-control"
				placeholder="Enter stadiumName">
		</div>
		<button id="btnSave" type="button" class="btn btn-primary">
			등록</button>

	</form>
</div>

<script src="/js/stadium.js">
	// 구장등록
</script>

<%@ include file="../layout/footer.jsp"%>
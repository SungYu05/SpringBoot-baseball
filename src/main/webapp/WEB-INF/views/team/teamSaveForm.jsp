<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<br />
	<form>
		<div class="d-flex justify-content-center">
			<select id="stadium">
				<c:forEach var="stadium" items="${stadiums}">
					<option value="${stadium.id}">${stadium.stadiumName}</option>
				</c:forEach>
			</select>
			<div class="d-flex align-items-center" style="width: 500px">
				<input id="teamName" class="form-control" placeholder="teamName" />
			</div>
			<button id="btnSave" type="button" class="btn btn-primary">등록</button>
		</div>
	</form>
</div>
<script src="/js/team.js">
	
</script>
<%@ include file="../layout/footer.jsp"%>
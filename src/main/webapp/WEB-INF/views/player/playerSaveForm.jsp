<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<br />
	<form>
		<div class="d-flex justify-content-center">
			<select id="team"> 
				<c:forEach var="team" items="${teams}">
					<option value="${team.id}" >${team.teamName}</option>
				</c:forEach>
			</select>
			<div class="d-flex align-items-center">
				<input id="playerName" class="form-control" placeholder="playerName" />
			</div>
			<div class="d-flex align-items-center">
				<input id="positions" class="form-control" placeholder="positions" />
			</div>
			<button id="btnSave" type="button" class="btn btn-primary">등록</button>
		</div>
	</form>
</div>
<script src="/js/player.js">
	
</script>
<%@ include file="../layout/footer.jsp"%>
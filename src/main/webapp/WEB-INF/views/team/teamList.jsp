<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>야구장이름</th>
				<th>팀이름</th>
				<th>창단일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="team" items="${teamList}">
				<tr>
					<td>${team.numbers}</td>
					<td>${team.stadiumName}</td>
					<td>${team.teamName}</td>
					<td><fmt:formatDate value="${team.createdAt}"
							pattern="yyyy-MM-dd" /></td>
					<td><a href="/teamUpdateForm/${team.id}/${team.teamName}"><i
							class="fa fa-wrench"></i></a></td>
					<td><button onclick="deleteById(${team.id});"
							class="btn btn-danger btn-sm">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script src="/js/team.js"></script>
<%@ include file="../layout/footer.jsp"%>
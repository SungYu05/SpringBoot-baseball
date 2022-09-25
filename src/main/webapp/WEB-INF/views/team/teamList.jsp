<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>팀</th>
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
					<td>${team.createdAt}</td>
					<td><a
						href="/teamUpdateForm/${team.id}/${team.teamName}"><i
							class="fa fa-wrench"></i></a></td>
					<td><i onclick="teamDelete(${stadium.id},this);"
						class="fa fa-minus"></i></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script src="/js/team.js"></script>
<%@ include file="../layout/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>팀이름</th>
				<th>포지션</th>
				<th>선수이름</th>
				<th>등록일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="player" items="${playerList}">
				<tr>
					<td>${player.numbers}</td>
					<td>${player.teamName}</td>
					<td>${player.positions}</td>
					<td>${player.playerName}</td>
					<td><fmt:formatDate value="${player.createdAt}"
							pattern="yyyy-MM-dd" /></td>
					<td><a href="/teamUpdateForm/${player.id}/${player.playerName}"><i
							class="fa fa-wrench"></i></a></td>
					<td><i onclick="steamDelete(${team.id},this);"
						class="fa fa-minus"></i></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script src="/js/team.js"></script>
<%@ include file="../layout/footer.jsp"%>
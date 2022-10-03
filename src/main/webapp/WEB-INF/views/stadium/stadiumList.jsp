<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>경기장</th>
				<th>개장일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stadium" items="${stadiumList}">
				<tr>
					<td>${stadium.numbers}</td>
					<td>${stadium.stadiumName}</td>
					<td><fmt:formatDate value="${stadium.createdAt}"
							pattern="yyyy-MM-dd" /></td>
					<td><a
						href="/stadiumUpdateForm/${stadium.id}/${stadium.stadiumName}"><i
							class="fa fa-wrench">수정</i></a></td>
					<td><button onclick="deleteById(${stadium.id});" class="btn btn-danger btn-sm">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script src="/js/stadium.js"></script>
<%@ include file="../layout/footer.jsp"%>
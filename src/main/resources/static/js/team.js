$("#btn").click(() => {
	let id = {
		id: $("#stadium").val()
	}
});


$("#btnSave").click(() => {
	save();
});

function save() {
	let data = {
		teamName: $("#teamName").val(),
		stadiumId: $("#stadium").val()
	};

	$.ajax("/api/team/save", {
		type: "POST",
		dataType: "json", // 응답 데이터
		data: JSON.stringify(data), // http body에 들고갈 요청 데이터
		headers: { // http header에 들고갈 요청 데이터
			"Content-Type": "application/json; charset=utf-8"
		}
	}).done((res) => {
		if (res.code == 1) {
			alert(res.msg);
			location.href = "/team";
		} else {
			alert("팀 등록 실패");
			history.back();
		}
	});
}


function deleteById(id) {
	$.ajax("/api/team/" + id + "/delete", {
		type: "DELETE",
		datatype: "JSON",
	}).done((res) => {
		if (res.code == 1) {
			alert("팀 삭제 완료");
			location.reload();
		} else {
			alert("팀 삭제 실패")
		}
	});
}
$("#btn").click(() => {
	let id = {
		id: $("#team").val()
	}
});


$("#btnSave").click(() => {
	save();
});

function save() {
	let data = {
		playerName: $("#playerName").val(),
		teamId: $("#team").val(),
		positions: $("#positions").val()
	};

	$.ajax("/api/player/save", {
		type: "POST",
		dataType: "json", // 응답 데이터
		data: JSON.stringify(data), // http body에 들고갈 요청 데이터
		headers: { // http header에 들고갈 요청 데이터
			"Content-Type": "application/json; charset=utf-8"
		}
	}).done((res) => {
		if (res.code == 1) {
			alert(res.msg);
			location.href = "/player";
		} else {
			alert("팀 등록 실패");
			history.back();
		}
	});
}

function deleteById(id) {
	$.ajax("/api/player/" + id + "/delete", {
		type: "DELETE",
		datatype: "JSON",
	}).done((res) => {
		if (res.code == 1) {
			alert("선수 삭제 완료");
			location.reload();
		} else {
			alert("선수 삭제 실패")
		}
	});
}
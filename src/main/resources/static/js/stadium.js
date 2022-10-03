$("#btnSave").click(() => {
	save();
});

function save() {
	let data = {
		stadiumName: $("#stadiumName").val()
	};

	$.ajax("/api/stadium/save", {
		type: "POST",
		dataType: "json", // 응답 데이터
		data: JSON.stringify(data), // http body에 들고갈 요청 데이터
		headers: { // http header에 들고갈 요청 데이터
			"Content-Type": "application/json; charset=utf-8"
		}
	}).done((res) => {
		if (res.code == 1) {
			alert(res.msg);
			location.href = "/stadium";
		} else {
			alert("경기장 등록 실패");
			history.back();
		}
	});
}

function deleteById(id) {
	$.ajax("/api/stadium/" + id + "/delete", {
		type: "DELETE",
		datatype: "JSON",
	}).done((res)=>{
		if(res.code == 1){
			alert("경기장 삭제 완료");
			location.reload();
		}else{
			alert("경기장 삭제 실패")
		}
	});
}
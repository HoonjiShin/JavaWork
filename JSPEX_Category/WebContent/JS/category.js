var ca_depth = 1;
var ca_parent = 0;

$(document).ready(function(){
	loadPage();
});

//ca_depth인 데이터 로딩
function loadPage(){
	
	$.ajax({
		url: "cate_list.ajax?ca_depth="+ca_depth+"&ca_parent="+ca_parent,
		type: "POST",
		cache: false,
		success : function(data, status){
			if(status == "OK"){
				updateList(data);
			}			
		}
	});
}

function updateList(jsonObj){
	result = "<option>선택하세요---</option>"; 
	
	if(jsonObj.status == "OK"){
		var count = jsonObj.count;
		
		var i;
		var items = jsonObj.data;
		for(i=0;i<count;i++){
			$('.cate span:child select').attr("disabled", false);
			result += "<option>"+items[i].ca_name+"</option>";
		}
		$(".cate span:nth-child select").html(result);
	}
	return false;
}
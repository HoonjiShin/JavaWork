var ca_depth = 1;
var ca_parent = 0;

$(document).ready(function(){
	$.ajax({
		url: "cate_list.ajax",
		type: "POST",
		data: {
			"ca_depth" : 1,
			"ca_parent" : $(this).val()
		},
		cache: false,
		success : function(data, status){
			if(status == "success"){
				$('#mycate1').attr("disabled", false);
				result = "<option class='option' value=''>--선택하세요--</option>";
				var count =  data.count;
				var i;
				var items = data.data;
				for (i = 0; i < count; i++) {
					
					result += "<option class='option1' value='"+items[i].ca_uid +"' data-uid='" + items[i].ca_uid 
					+ "' data-ca_parent='"+items[i].ca_parent+"' data-ca_depth='"+items[i].ca_depth+"'>"+ items[i].ca_name + "</option>";
				}
				
				$("#mycate1").html(result);
				
			}else{
				alert("AJAX 실패");
			}		
		}
	});
	$('#mycate1').change(function(){
		if($(this).val() == ""){
			$('#mycate2').attr("disabled", true);
			$('#mycate2').html("");
			$('#mycate3').attr("disabled", true);
			$('#mycate3').html("");
			return ;	
		}
	$.ajax({
		url: "cate_list.ajax",
		type: "POST",
		data: {
			"ca_depth" : 2,
			"ca_parent" : $(this).val()
		},
		cache: false,
		success : function(data, status){
			if(status == "success"){
					result = "<option class='option' value=''>--선택하세요--</option>";
					$('#mycate2').attr("disabled",false);
					var count =  data.count;
					var i;
					var items = data.data;
					for (i = 0; i < count; i++) {
						result += "<option class='option2' value='"+items[i].ca_uid +"' data-uid='" + items[i].ca_uid 
						+ "' data-ca_parent='"+items[i].ca_parent+"' data-ca_depth='"+items[i].ca_depth+"'>"+ items[i].ca_name + "</option>";
					}
					$("#mycate2").html(result);
				
			}else{
			alert("AJAX 실패");
			}		
			}
		});		
		});
	
	$('#mycate2').change(function(){
		//alert($(this).val());
		if($(this).val() == ""){
			$('#mycate3').attr("disabled", true);
			$('#mycate3').html("");
			return ;	
		}
		$.ajax({
			url: "cate_list.ajax",
			
			type: "POST",
			data: {
				"ca_depth" : 3,
				"ca_parent" : $(this).val()
			},
			cache: false,
			success : function(data, status){
				if(status == "success"){
						$('#mycate3').attr("disabled", false);
						result = "<option class='option' value=''>--선택하세요--</option>";
						var count =  data.count;
						var i;
						var items = data.data;
						for (i = 0; i < count; i++) {
							result += "<option value='"+items[i].ca_uid +"' data-uid='" + items[i].ca_uid 
							+ "' data-ca_parent='"+items[i].ca_parent+"' data-ca_depth='"+items[i].ca_depth+"'>"+ items[i].ca_name + "</option>";
						}
						$("#mycate3").html(result);
				}else{
				alert("AJAX 실패");
				}		
				}
			});	
	});

	if($('#mycate1 option').val() == null){
		$('#mycate2').attr("disabled", true);
		$('#mycate3').attr("disabled", true);
	}
	
});

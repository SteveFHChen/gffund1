
function save(){
	//$('#saveBtn').click(function() {
	
		//var id = $('#id').val();
		var name = $('#name').val();
		var state = $('input[name="state"]:checked').val();
		var polling = $('#polling').val();
		var desc = $('#desc').val();

		alert(state);
		params = {
			//id : id,
			name : name,
			state : state,
			polling : polling,
			desc : desc
		};
		
		WD.api.advertiseColumn.save(params, function(data) {
			alert("保存成功");
			//document.location.href = 'advertiseColumn_success.html';
			$U.navigate('advertiseColumn/advertiseColumn_success.html');
		});
	//});
}

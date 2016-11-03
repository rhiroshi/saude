$(function(){
	var form = $('.js-form-prontuario');
	var url = form.attr('action');
	//Pesquisar os cursos sem refresh na página
	$("#paciente").keyup(function(){
		
		var pesquisa = $(this).val();
		
		//Verificar se há algo digitado
		if(pesquisa != ''){
			var dados = {
				palavra : pesquisa
			}		
			$.ajax({
				url: url,
				method: 'POST',
				data: { nome:pesquisa },
				success: onPesquisaPacientes.bind(this)
			});
		}else{
			$(".resultado").html('');
		}
		
		function onPesquisaPacientes(pacientes) {
			console.log('pacientes',pacientes);
			pacientes.forEach(function(paciente){
				console.log('paciente',paciente.nome);
			}.bind(this))
		}
		
	});
});
$(function(){
	var url = 'http://localhost:8080/pacientes/pesquisa';
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
			var listaPacientes = $('#lista-paciente');
			pacientes.forEach(function(paciente){
				listaPacientes.append('<span value="'+ paciente.codigo + '">' + paciente.nome + '</span>');
			}.bind(this))
		}
		
	});
});
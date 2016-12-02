$(function(){
	/* #### Função busca paciente #### */
	//Pesquisar os cursos sem refresh na página
	$("#amostra").keyup(function(){
		var url = document.location.origin + "/pacientes/pesquisa";

		var pesquisa = $(this).val().trim();
		var listaPacientes = $('#lista-paciente');
		
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
			listaPacientes.removeClass('margem-lista');
			listaPacientes.empty();
			$(".resultado").html('');
		}
		
		function onPesquisaPacientes(pacientes) {
			listaPacientes.empty();
			if (pacientes.length > 0) {
				listaPacientes.addClass('margem-lista');
				pacientes.forEach(function(paciente){
					listaPacientes.append('<span id="'+ paciente.cpf + '">' + paciente.nome + '</span>');
				}.bind(this))
			} else {
				listaPacientes.removeClass('margem-lista');		
				listaPacientes.empty();
				$(".resultado").html('');		
			}
		}
	});
	/* #### Função busca paciente #### */
	
	/* #### Função seleciona paciente #### */
	var pacienteLista = $('#lista-paciente');
	pacienteLista.on('click', 'span', function(){
		var paciente = $('#paciente');
		var amostra = $('#amostra');
		var nome = $(this).text();
		amostra.val(nome);
		paciente.val(this.id);
		$('#lista-paciente').removeClass('margem-lista');	
		$('#lista-paciente').empty();
	});
	/* #### Funlção seleciona paciente #### */	
	
});


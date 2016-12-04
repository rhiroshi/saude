//  -------- Controle do Objeto produto ------
var NovoMedicamento = (function(){
	function NovoMedicamento(){
		this.idConsulta = '';
		this.idMedicamento = $('#idMedicamento');
		this.qtdMedicamento = $("#qtdMedicamento");
		this.botaoEnviar = $("#btnEnviar");
		this.modal = $('#ModalAdicionarPrescricao');
		this.inputMedicamento = $("#procuraMedicamento");
	}

	NovoMedicamento.prototype.setIdConsulta = (function(idConsulta){
		this.idConsulta = idConsulta
	})
	
	NovoMedicamento.prototype.iniciar = (function(){
		this.modal.on('hide.bs.modal', onModalHide.bind(this));
		this.botaoEnviar.on('submit',function(e){ e.preventDefault()});
		this.botaoEnviar.on('click', function(){
			if(this.idMedicamento != ''){
				var rreceita = {};
				var pproduto = {};
				pproduto.codigo = this.idMedicamento.val();
				rreceita.codigo = this.idConsulta;
				$.ajax({
					url:'http://localhost:8080/produtos/novoPedido',
					method:'POST',
					async:true,
					cache:false,
					contentType:'application/json',
					data : JSON.stringify({
						receita:rreceita,
						produto:pproduto,
						quantidade:this.qtdMedicamento.val()
					}),
					success:onMedicamentoAdicionado.bind(this)
				})
				var prescricoes = $('#prescricoes');
				$('#receitaConsulta').val(this.idConsulta);
				prescricoes.addClass('receita-ativa');
				var nomeMed = $('#info-nome-medicamento').text().substring(21);
				var info = '<span>'+nomeMed+' x '+this.qtdMedicamento.val()+"</span>";
				prescricoes.removeClass('escondido');
				prescricoes.append(info);
				this.modal.modal('hide');
			}
		}.bind(this));
	})
	
	function onModalHide(){
		$(this).data('bs.modal', null);
		this.inputMedicamento.val('');
		this.qtdMedicamento.val('');
		
		$("#info-medicamento").empty();
	}
	
	function onMedicamentoAdicionado(data){
		console.log(data);
	}
	
	return NovoMedicamento;
})();

// -------- Exibir informacoes do medicamento dentro do Modal --------

var ListaMedicamentos = (function(){
	function ListaMedicamentos(){
		this.listaMedicamentos = $("#lista-medicamentos");
		this.inputMedicamento = $("#procuraMedicamento");
		this.url = document.location.origin;
	}
	
	ListaMedicamentos.prototype.iniciar = (function(){
		this.listaMedicamentos.on('click','span',escolheMedicamento.bind(this));
		this.inputMedicamento.on('keyup', function(){
			this.listaMedicamentos.empty();
			this.listaMedicamentos.removeClass('margem-lista');
			if(this.inputMedicamento.val() != ""){
				purl = this.url + "/produtos/pesquisa",
				$.ajax({
					url:purl,
					method:"GET",
					data:{nome:this.inputMedicamento.val().trim()},
					success:onMedicamentosRetornado.bind(this)
				});
				this.listaMedicamentos.addClass('margem-lista');
			}
		}.bind(this))
	});
	
	function onMedicamentosRetornado(medicamentos){
		if(medicamentos.length == 0){
			this.listaMedicamentos.removeClass('margem-lista');
		}else{
			medicamentos.forEach(function(medicamento){
				spanM = "<span id=" + medicamento.codigo + ">"+medicamento.nome+"</span>";
				this.listaMedicamentos.append(spanM);
			}.bind(this));
		}
	};
	
	function escolheMedicamento(e){
		var nome = e.target.innerHTML;
		var id = e.target.id;
		var info1 = "<h4>Informações do medicamento</h4>";
		var info2 = '<label id="info-nome-medicamento">Nome do medicamento: '+nome+'</label>';
		var info3 = "<label>ID do medicamento:"+id+"</label>";
		this.inputMedicamento.val(nome);
		$('#idMedicamento').val(id);
		this.listaMedicamentos.empty();
		this.listaMedicamentos.removeClass('margem-lista');
		var infos = $("#info-medicamento");
		infos.empty();
		infos.append(info1);
		infos.append(info2);
		infos.append(info3);
	}
	
	return ListaMedicamentos;
})();

$(function(){
	var listaMedicamentos = new ListaMedicamentos();
	listaMedicamentos.iniciar();
	var novoMedicamento = new NovoMedicamento();
	novoMedicamento.iniciar();
	var modal = $('#ModalAdicionarPrescricao');
	modal.on('show.bs.modal', function(event){
		var button = $(event.relatedTarget);
		var idConsulta = button.data('idconsulta');
		novoMedicamento.setIdConsulta(idConsulta);
	});
});


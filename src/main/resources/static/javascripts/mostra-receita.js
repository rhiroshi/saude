var MostraReceita = (function(){
	function MostraReceita(){
		this.codigoReceita;
		this.tabela = $('#tabela-receita tbody');
	}
	
	
	MostraReceita.prototype.abrirModal = (function(rec){
		this.codigoReceita = rec;
		$.ajax({
			url:'http://localhost:8080/receita/pesquisa',
			method:'GET',
			contentType:'application/json',
			data:{codigo:this.codigoReceita},
			success:onReceitaRetornada.bind(this)
		})
	});
	
	function onReceitaRetornada(medicamentos){
		medicamentos.forEach(function(medicamento){
			var td1 = '<td>'+medicamento.produto.nome+'</td>';
			var td2 = '<td>'+medicamento.quantidade+'</td>';
			this.tabela.append('<tr>'+td1+td2+'</tr>');
		}.bind(this));
	}
	
	return MostraReceita;
})();

$(function(){
	var mostraReceita = new MostraReceita();
	$('#ModalMostraReceita').on('show.bs.modal', function(event){
		var button = $(event.relatedTarget);
		receita = button.data('receita');
		var modal = $(this);
		mostraReceita.abrirModal(receita);
	});
	
})

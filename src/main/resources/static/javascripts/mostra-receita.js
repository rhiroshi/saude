var MostraReceita = (function(){
	function MostraReceita(){
		this.codigoReceita;
		this.receita;
	}
	
	MostraReceita.prototype.iniciar = function(){
		
	};
	
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
	
	function onReceitaRetornada(receita){
		this.receita = receita;
		console.log(receita);
	}
	
	return MostraReceita;
})();

$(function(){
	var mostraReceita = new MostraReceita();
	mostraReceita.iniciar();
	$('#ModalMostraReceita').on('show.bs.modal', function(event){
		var button = $(event.relatedTarget);
		receita = button.data('receita');
		var modal = $(this);
		mostraReceita.abrirModal(receita);
	});
	
})

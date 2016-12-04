var ModalMedicamento = (function(){
    function ModalMedicamento(event){
    	this.botaoSalvar = $('#salvar-quantidade');
    	this.inputQuantidade = $('#quantidade'); //input de quantidade
        this.botaoModal = $(event.relatedTarget);
        this.nome = this.botaoModal.data('nome');
        this.codigo = this.botaoModal.data('codigo');
        this.estoque = this.botaoModal.data('estoque');
        this.labelQuantidade = $('.label-quantidade');
    }
    
    ModalMedicamento.prototype.iniciar = function(){
    	this.labelQuantidade.text(this.nome);
    	this.botaoSalvar.on('click', onBotaoSalvarClick.bind(this));
    }
    
    function onBotaoSalvarClick() {
    	var quantidade = this.inputQuantidade.val() != '' ? parseInt(this.inputQuantidade.val()) : 0;
    	var soma = quantidade + parseInt(this.estoque);

    	$.ajax({
			url: 'http://localhost:8080/produtos/abastecer',
			method: 'POST',
			data: { codigo : this.codigo,
				estoque : soma },
			success: onEstoqueSalvo.bind(this)
		});
    	
    	console.log('nome: ',this.nome,' estoque: ',this.estoque, ' soma: ', soma);
    }
    
    function onEstoqueSalvo(produto) {
    	
    }  
    
    return ModalMedicamento;
})();

$(function(){
	var modal = $('#ModalAbastecerMedicamento');
	modal.on('show.bs.modal', function(event) {
	    var modalMedicamento = new ModalMedicamento(event);
	    modalMedicamento.iniciar();
    });
	modal.on('hide.bs.modal', function(event) {
		$('#quantidade').val('');
	});

});
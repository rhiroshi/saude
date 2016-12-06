var ModalMedicamento = (function(){
    function ModalMedicamento(event){
    	this.botaoSalvar = $('#salvar-quantidade');
    	this.inputQuantidade = $('#quantidade'); //input de quantidade
    	this.nome = '';
    	this.codigo = '';
    	this.idEstoque
    	this.labelQuantidade = $('.label-quantidade');
    	this.modal = $('#ModalAbastecerMedicamento');
    }
    
    ModalMedicamento.prototype.abastecer = function(nome, codigo){
    	this.nome = nome;
    	this.codigo = codigo;
    	this.idEstoque = $('#estoque-'+this.codigo);
    	this.labelQuantidade.text(this.nome);
    }
    
    ModalMedicamento.prototype.iniciar = function(){
    	this.botaoSalvar.on('click', onBotaoSalvarClick.bind(this));
    }
    
    function onBotaoSalvarClick() {
    	this.modal.on('hide.bs.modal', onModalHide.bind(this));    	
    	var quantidade = this.inputQuantidade.val() != '' ? parseInt(this.inputQuantidade.val()) : 0;
    	var soma = quantidade + parseInt(this.idEstoque.text());
    	$.ajax({
			url: 'http://localhost:8080/produtos/abastecer',
			method: 'POST',
			data: { codigo : this.codigo,
				estoque : soma },
			success: onEstoqueSalvo.bind(this)
		});
    }
    
    function onModalHide(){
		$(this).data('bs.modal', null);
		this.inputQuantidade.val('');
		$('.label-quantidade').empty();
	}
    
    function onEstoqueSalvo(produto) {
    	var estoque = $(this.idEstoque);
    	estoque.text(produto.estoque);
    	this.estoque = produto.estoque;
    }  
    
    return ModalMedicamento;
})();

$(function(){
	var modal = $('#ModalAbastecerMedicamento');
	var modalMedicamento = new ModalMedicamento(event);
	modalMedicamento.iniciar();
	modal.on('show.bs.modal', function(event) {		
		var botaoModal = $(event.relatedTarget);
		var nome = botaoModal.data('nome');
		var codigo = botaoModal.data('codigo');
		modalMedicamento.abastecer(nome, codigo);
    });
});
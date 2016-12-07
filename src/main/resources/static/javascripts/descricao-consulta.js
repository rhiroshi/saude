$('#ModalObservacaoPesquisa').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);
	var observacao = button.data('observacao');
	var modal = $(this);
	modal.find('.modal-body span').html(observacao);
});
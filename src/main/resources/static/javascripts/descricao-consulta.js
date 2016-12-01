$('#ModalObservacaoPesquisa').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);
	console.log('asd');
	var observacao = button.data('observacao');
	var modal = $(this);
	console.log(observacao);
	modal.find('.modal-body span').html(observacao);
});
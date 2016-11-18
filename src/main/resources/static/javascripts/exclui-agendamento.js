$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);
	var nome = button.data('nome');
	var id = button.data('id');
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if(!action.endsWith('/')){
		action += '/';
	}
	form.attr('action', action+id);
	modal.find('.modal-body span').html('Tem certeza que quer excluir o agendamento de <strong>'+nome+'</strong>?');
});
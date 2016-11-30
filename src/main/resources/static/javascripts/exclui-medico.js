$('#ModalExcluirMedico').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);
	var nome = button.data('nome');
	var cpf = button.data('cpf');
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if(!action.endsWith('/')){
		action += '/';
	}
	form.attr('action', action+cpf);
	modal.find('.modal-body span').html('Tem certeza que quer excluir o médico <strong>'+nome+'</strong>?');
});
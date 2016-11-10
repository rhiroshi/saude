$('document').ready(function($){
	var cpf = $('#cpf');
	var rg = $('#rg');
	var dataNascimento = $('#dataNascimento');
	var telefoneResidencial = $('#telefoneResidencial');
	var telefoneCelular = $('#telefoneCelular');
	var form = $('#formulario');
	telefoneResidencial.mask('(00)0000-0000');
	telefoneCelular.mask('(00)0000-0000');
	dataNascimento.mask('00/00/0000');
	rg.mask('00.000.000-0');
	
	var options = {onKeyPress: function(cpfn, e, field, options){
		var masks = ['0.000.000-00','00.000.000-00','000.000.000-00'];
		if(cpf.length < 9){
			console.log('0', cpf.length);
			mask = masks[0];
		}
		else if(cpfn.length > 9 && cpfn.length < 10){
			console.log('1', cpf.length);
			mask = masks[1];
		}else if(cpfn.length > 10){
			console.log('2', cpf.length);
			mask = masks[2];
		}
		this.cpf.mask(mask, options);
	}};
	
	form.submit(function(){
		cpf.unmask();
		rg.unmask();
		telefoneResidencial.unmask();
		telefoneCelular.unmask();
	});
	cpf.mask('000.000.000-00', options);
});

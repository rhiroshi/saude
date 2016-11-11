$('document').ready(function($){
	var cpf = $('#cpf');
	var rg = $('#rg');
	var dataNascimento = $('#dataNascimento');
	var telefoneResidencial = $('#telefoneResidencial');
	var telefoneCelular = $('#telefoneCelular');
	var form = $('#formulario');
	var altura = $('#altura');
	var peso = $('#peso');
	telefoneResidencial.mask('(00)0000-0000');
	telefoneCelular.mask('(00)0000-0000');
	dataNascimento.mask('00/00/0000');
	rg.mask('00.000.000-0');
	cpf.mask('000.000.000-00', {reverse:true});
	altura.mask('000 cm',{reverse:true});
	peso.mask('000 kg', {reverse:true});
	
	form.submit(function(){
		cpf.unmask();
		rg.unmask();
		telefoneResidencial.unmask();
		telefoneCelular.unmask();
		peso.unmask();
		altura.unmask();
	});
});

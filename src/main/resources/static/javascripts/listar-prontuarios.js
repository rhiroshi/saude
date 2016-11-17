var Prontuarios = (function(){
    function Prontuarios(){
        this.comboStatus = $('#status-prontuario');
        this.listaPaciente = $('.js-lista-paciente');
    }
    
    Prontuarios.prototype.iniciar = function(){
        this.comboStatus.on('change', onStatusSelecionado.bind(this) );
    }
    
    function onStatusSelecionado(){
    	var status = this.comboStatus.val();
        if(status){
            $.ajax({
                url: 'http://localhost:8080/prontuarios/lista',
                method: 'POST',
    			data: {status:status},
                success: onProntuariosRetornados.bind(this)
            });
        }else{
        	this.listaPaciente.empty();
        }
    }
    
    function onProntuariosRetornados(prontuarios){
    	if (prontuarios.length > 0) {
    		this.listaPaciente.empty();
	        prontuarios.forEach(function(prontuario){
	        	var trPaciente = $('<tr>');
	        	var tdPaciente = '<td class="text-center">'+prontuario.paciente.nome+'</td>';
	        	tdPaciente += '<td class="text-center">'+prontuario.status+'</td>';
	        	if (prontuario.status === 'AGENDADO') {
	        		tdPaciente += '<td class="text-right"><a href="/prontuarios/incluir/'+prontuario.id+'" class="btn btn-link btn-xs" title="Editar"><i class="glyphicon glyphicon-pencil"></i></a></td>';
	        	} else {
	        		tdPaciente += '<td></td>';
	        	}
	        	trPaciente.append(tdPaciente);
	        	
	        	this.listaPaciente.append(trPaciente);
	        }.bind(this))
    	} else {
    		this.listaPaciente.empty();
    	}
    }
    
    return Prontuarios;
})();

$(function(){
    var prontuarios = new Prontuarios();
    prontuarios.iniciar();

});
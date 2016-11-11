var Prontuarios = (function(){
    function Prontuarios(){
        this.comboStatus = $('#status-prontuario');
        console.log(this.comboStatus);
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
    			data: { status:status},
                success: onProntuariosRetornados.bind(this)
            });
        }else{
        	console.log('Select sem valor');
           
           
        }
    }
    
    function onProntuariosRetornados(prontuarios){
    	console.log('Protuarios retornados',prontuarios);
    	/*if (docentes.length > 0) {
	    	this.comboCoordenador.html('');
	        this.comboCoordenador.removeAttr('disabled');
	        this.comboCoordenador.html('<option>Selecione o Curso</option>');
	        docentes.forEach(function(docente){
	            var optionDocente = $('<option>').val(docente.codigo).text(docente.nome);
	            this.comboCoordenador.append(optionDocente);
	        }.bind(this))
    	} else {
    		this.comboCoordenador.html('');
            this.comboCoordenador.attr('disabled', 'disabled');
    	}*/
    }
    
    return Prontuarios;
})();

$(function(){
    var prontuarios = new Prontuarios();
    prontuarios.iniciar();

});
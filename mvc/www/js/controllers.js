//Controlador en MVC
angular.module('starter.controllers', [])

.controller('DashCtrl', function($scope,$state,$http) {
		$scope.processConferencia = function(conferencia){
      //Metodo POST en rest para crear conferencia
		$http({
  			method  : 'POST',
  			url     : 'http://domain.com/webservice/conferenciarest',
  			data    : {
  						nombre: conferencia.nombre,
        				nombrepersona: conferencia.nombrepersona,
        				fecha: conferencia.fecha,
        				numeroasistentes:conferencia.numeroasistentes
  						},
  			headers : { 'Content-Type': 'application/x-www-form-urlencoded' } 
  		})
      $state.go('tab.seleccionarevento')
	};
})

.controller('SeleccionarEventoCtrl', function($scope,$state,$http) {
	$scope.processEvento = function(evento){
     //Metodo POST en rest para crear evento
		$http({
  		method  : 'POST',
  		url     : 'http://domain.com/webservice/eventorest',
  		data    : {
  					nombre: evento.nombre,
        			tipoevento: evento.tipo
  					},
  			headers : { 'Content-Type': 'application/x-www-form-urlencoded' } 
  		})
		$state.go("tab.dash")
		console.log("Creado")
	};
})

.controller('SillasCtrl', function($scope,$state,$http) {
	$scope.processSilla = function(servicioconferencia, servicioevento){
		//Obtener conferencias disponibles
		$http.get("http://domain.com/webservice/conferenciasrest")
    	.success(function(response){
      $scope.servicioconferencia = response;
      console.log(response);
    });
    	//Obtener eventos en las conferencias
    $http.get("http://domain.com/webservice/eventosrest")
    	.success(function(response){
      $scope.servicioevento = response;
      console.log(response);
    });
    	//enviar la informacion para comprar la silla
	$http({
  		method  : 'POST',
  		url     : 'http://domain.com/webservice/sillarest',
  		data    : {

  			//		conferenciaseleccionada: servicioconferencia.conferencia,
        	//		eventoseleccionado: servicioevento.evento
  					},
  			headers : { 'Content-Type': 'application/x-www-form-urlencoded' } 
  		})

		$state.go("tab.sillacomprada")
	};
})

.controller('SillaCompradaCtrl', function($scope,$state,$http) {
  //Obtener las sillas que se compraron
	  $http.get("http://domain.com/webservice/sillasrest")
    	.success(function(response){
      $scope.servicio = response;
      console.log(response);
    });
});

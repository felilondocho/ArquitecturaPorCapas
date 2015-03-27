angular.module('starter.controllers', [])

.controller('DashCtrl', function($scope,$state) {
		$scope.processConferencia = function(){
		$state.go("tab.seleccionarevento")
	};
})

.controller('SeleccionarEventoCtrl', function($scope,$state) {
	$scope.processEvento = function(){
		$state.go("tab.dash")
		console.log("Creado")
	};
})

.controller('SillasCtrl', function($scope,$state) {
	$scope.processSilla = function(){
		$state.go("tab.sillacomprada")
	};
})

.controller('SillaCompradaCtrl', function($scope,$state) {
});

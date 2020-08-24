var appTaskList = angular.module("appTaskList", []);

appTaskList.controller("indexController", function ($scope, $http){

	$scope.taskList = {};
	$scope.taskLists = [];	
	
	$scope.task;
		
	$scope.getTaskLists = function() {		
		$http({
			method: 'GET', 
			url:'http://localhost:8080/taskList'})
			.then(function(response){
				$scope.taskLists = response.data;		
			}, function(response){			
				console.log("NO SUCESS");
		});	
	};

	$scope.saveTaskList = function() {
		$http({
			method: 'POST', 
			url:'http://localhost:8080/taskList',
			data:$scope.taskList})
			.then(function(response){
				console.log(response.data);
				$scope.taskLists.push(response.data);	
				$scope.cancelEditionTaskList();	
				$scope.getTaskLists(); 	
			}, function(response){			
				console.log("NO SUCESS");
		});
	};

	$scope.deleteTaskList = function(taskList) {
		$http({
			method: 'DELETE', 
			url:'http://localhost:8080/taskList/' + taskList.id})
			.then(function(response){
				var position = $scope.taskLists.indexOf(taskList);
				$scope.taskLists.splice(position, 1);

				console.log(response.data);						
			}, function(response){			
				console.log("NO SUCESS");
		});
	};
	
	$scope.updateTaskList = function(taskList) {
		$scope.taskList = angular.copy(taskList);	
	};
	
	$scope.cancelEditionTaskList = function() {
		$scope.taskList = {};	
	};
	
	$scope.saveTask = function() {
		$http({
			method: 'POST', 
			url:'http://localhost:8080/task/',
			data:$scope.task})
			.then(function(response){
				$scope.task = (response.data);				
				var position = $scope.taskLists.indexOf(taskList);				
				$scope.taskLists[position].taskCollection.push(task);	
				console.log(response.data);				
			}, function(response){			
				console.log("NO SUCESS");
		});
	};

	$scope.getTaskLists();
});
'use strict';

var app = angular.module('app');
app.service('UserCRUDService', [ '$http', '$q', function($http, $q) {

	var REST_SERVICE_URI = '/springangular/users/';

	this.getAllUsers = function getAllUsers() {
		return $http({
			method : 'GET',
			url : REST_SERVICE_URI
		});
	}

	this.getByName = function getByName(name) {
		return $http({
			method : 'GET',
			url : REST_SERVICE_URI + "name/" + name
		});
	}

	this.addUser = function addUser(user) {
		return $http({
			method : 'POST',
			url : REST_SERVICE_URI,
			data : {
				id : user.id,
				name : user.name,
				email : user.email,
				address : user.address
			}
		});
	}

	this.updateUser = function updateUser(user, id) {
		return $http({
			method : 'PUT',
			url : REST_SERVICE_URI + id,
			data : {
				id : user.id,
				name : user.name,
				email : user.email,
				address : user.address
			}
		});
	}
} ]);

'use strict';

var app = angular.module('app',[]);

app.controller('EmployeeCRUDCtrl', ['$scope', 'UserCRUDService', function($scope, UserCRUDService) {
    $scope.user={id:null,name:'',address:'',email:''};
    $scope.users=[];
    $scope.search = "";
    $scope.errorMessage = "";

    $scope.getAllUsers = function () {
    	console.log("get all users111");
        UserCRUDService.getAllUsers()
          .then(function success(response){
        	  $scope.users = response.data;
        	  console.log($scope.users);
              $scope.message='';
              $scope.errorMessage = '';
          },
          function error (response ){
        	  $scope.users = {};
              $scope.message='';
              $scope.errorMessage = 'Error getting users!';
          });
    }
    $scope.getAllUsers();
    
    $scope.getByName = function(){
    	UserCRUDService.getByName($scope.search)
            .then(
            function(response) {
                $scope.users = response.data;
            },
            function(errResponse){
            	$scope.users = [];
            	console.log("controller error");
            	$scope.message='';
                $scope.errorMessage = 'No Employee found';
            }
        );
    }

    $scope.addUser = function (user) {
        UserCRUDService.addUser(user)
        .then (function success(response){
            $scope.message = 'User added!';
            $scope.errorMessage = '';
            $scope.getAllUsers();
        },
        function error(response){
            $scope.errorMessage = 'Error adding user!';
            $scope.message = '';
      });
  }
    
    $scope.updateUser = function(user, id){
    	UserCRUDService.updateUser(user, id)
        .then (function success(response){
            $scope.message = 'User updated!';
            $scope.errorMessage = '';
            $scope.getAllUsers();
        },
        function error(response){
            $scope.errorMessage = 'Error updating user!';
            $scope.message = '';
      });
    }

    $scope.submit = function() {
        if($scope.user.id===null){
            $scope.addUser($scope.user);
        }else{
            $scope.updateUser($scope.user, $scope.user.id);            
        }
        $scope.reset();
    }

    $scope.edit = function (id) {
        for(var i = 0; i < $scope.users.length; i++){
            if($scope.users[i].id === id) {
                $scope.user = angular.copy($scope.users[i]);
                break;
            }
        }
    }


    $scope.reset = function (){
        $scope.user={id:null,name:'',address:'',email:''};
        $scope.empForm.$setPristine();
        $scope.searchForm.$setPristine();
    }
    
    $scope.resetSearch = function (){
        $scope.search = "";
        $scope.getAllUsers();
    }

}]);
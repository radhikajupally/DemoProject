<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Employee Application</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/service/userService.js' />"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

</head>

<body ng-app="app" class="ng-cloak">
	<div class="generic-container" ng-controller="EmployeeCRUDCtrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Search Form </span>
			</div>
			<div class="formcontainer">
				<!-- search user -->

				<form ng-submit="getByName()" name="searchForm"
					class="form-horizontal">
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Employee
								Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="search" name="uname"
									class="form-control input-sm"
									placeholder="Enter name to search an employee" required
									ng-minlength="3" />
								<div class="has-error" ng-show="searchForm.$dirty">
									<span ng-show="searchForm.uname.$error.minlength">Minimum
										length required is 3</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="Search"
								class="btn btn-primary btn-sm" ng-disabled="searchForm.$invalid">
							<button type="button" ng-click="resetSearch()"
								class="btn btn-warning btn-sm">Reset Form</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Registration Form </span>
			</div>
			<div class="formcontainer">
				<form ng-submit="submit()" name="empForm" class="form-horizontal">
					<input type="hidden" ng-model="user.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="user.name" name="uname"
									class="name form-control input-sm"
									placeholder="Enter your name" required ng-minlength="3" />
								<div class="has-error" ng-show="empForm.$dirty">
									<span ng-show="empForm.uname.$error.required">This is a
										required field</span> <span ng-show="empForm.uname.$error.minlength">Minimum
										length required is 3</span> <span ng-show="empForm.uname.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Address</label>
							<div class="col-md-7">
								<input type="text" ng-model="user.address"
									class="form-control input-sm"
									placeholder="Enter your Address. [This field is validation free]" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Email</label>
							<div class="col-md-7">
								<input type="email" ng-model="user.email" name="email"
									class="email form-control input-sm"
									placeholder="Enter your Email" required />
								<div class="has-error" ng-show="empForm.$dirty">
									<span ng-show="empForm.email.$error.required">This is a
										required field</span> <span ng-show="empForm.email.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="{{!user.id ? 'Add' : 'Update'}}"
								class="btn btn-primary btn-sm" ng-disabled="empForm.$invalid">
							<button type="button" ng-click="reset()"
								class="btn btn-warning btn-sm" ng-disabled="empForm.$pristine">Reset
								Form</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">All Users</span>				
			</div>
			<div ng-if="users.length == 0">
				<div class="alert alert-info" role="alert">
					<p class="text-center">
						<i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
						{{errorMessage}}
					</p>
				</div>
			</div>
			<div ng-if="users.length > 0">
				<div class="tablecontainer">

					<table class="table table-hover">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Address</th>
								<th>Email</th>
								<th width="20%"></th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="u in users">
								<td><span ng-bind="u.id"></span></td>
								<td><span ng-bind="u.name"></span></td>
								<td><span ng-bind="u.address"></span></td>
								<td><span ng-bind="u.email"></span></td>
								<td>
									<button type="button" ng-click="edit(u.id)"
										class="btn btn-success custom-width">Edit</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
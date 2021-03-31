<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/css/adminpanel.css" rel="stylesheet" type="text/css">
        <title>Users</title>
        <link rel="icon" href="${pageContext.request.contextPath}/img/logo.png" type="image/png">
    </head>
    <body>
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed">
					<span class="sr-only">Toggle navigation</span></button>
				<a class="navbar-brand" href="#"><span>Caffee</span>Admin</a>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-usertitle">
				<div class="profile-usertitle-name"><sec:authentication property="principal.username" /></div>
			</div>
			<div class="clear"></div>
		</div>
		<ul class="nav menu">
			<li><a href="${pageContext.request.contextPath}/admin"><em class="fa fa-dashboard">&nbsp;</em> Main</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/admins"><em class="fa fa-user-circle">&nbsp;</em> Admins</a></li>
			<li class="active"><a href="${pageContext.request.contextPath}/admin/users"><em class="fa fa-user-circle">&nbsp;</em> Users</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/orders"><em class="fa fa-cart-arrow-down">&nbsp;</em> View Orders</a></li>
			<li><a href="coffees.html"><em class="fa fa-coffee">&nbsp;</em> Coffees</a></li>
			<li><a href="drinks.html"><em class="fa fa-glass">&nbsp;</em>Drinks</a></li>
			<li><a href="snacks.html"><em class="fa fa-heart-o">&nbsp;</em>Snacks</a></li>
			<li><a href="${pageContext.request.contextPath}/logout"><em class="fa fa-power-off">&nbsp;</em> Logout</a></li>
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Members</li>
			</ol>
		</div><!--/.row-->
		<div class="table-responsive">
			<table class="table">
			  <thead>
				<tr>
				  <th scope="col">#</th>
				  <th scope="col">First Name</th>
				  <th scope="col">Last Name</th>
				  <th scope="col">Username</th>
				  <th scope="col">E-mail</th>
				  <th scope="col">Tel.</th>
				  <th scope="col">Address</th>
				  <th scope="col">Orders</th>
				  <th scope="col">Actions</th>
				</tr>
			  </thead>
			  <tbody>
				<c:forEach items="${users}" var = "account">
                                    <tr>
                                        <th scope="row">${account.id}</th>
                                        <td>${account.firstname}</td>
                                        <td>${account.lastname}</td>
                                        <td>${account.username}</td>
                                        <td>${account.email}</td>
                                        <td>${account.tel}</td>
                                        <td><a href="#"><em class="fa fa-address-book-o"></em> Address</a></td>
                                        <td><a href="#"><em class="fa fa-shopping-cart"></em> Orders</a></td>
                                        <td><a href="#"><em class="fa fa-pencil-square-o"></em> Edit</a></td>
                                    </tr>
                                </c:forEach>
			  </tbody>
			</table>
		  </div>

		
	</div>	<!--/.main-->
		
</body>
</html>

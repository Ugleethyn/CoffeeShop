<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/css/adminpanel.css" rel="stylesheet" type="text/css">
        <title>Coffees</title>
        <link rel="icon" href="${pageContext.request.contextPath}/img/logo.png" type="image/png">
        <script type="text/css">
            .formErrors {
                color: red;
            }
        </script>
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
                <li><a href="${pageContext.request.contextPath}/admin/users"><em class="fa fa-user-circle">&nbsp;</em> Users</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/orders"><em class="fa fa-cart-arrow-down">&nbsp;</em> New Orders</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/acceptedorder"><em class="fa fa-cart-arrow-down">&nbsp;</em> Accepted Orders</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/declinedorder"><em class="fa fa-cart-arrow-down">&nbsp;</em> Declined Orders</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/coffees"><em class="fa fa-coffee">&nbsp;</em> Coffees</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/drinks"><em class="fa fa-glass">&nbsp;</em>Drinks</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/snacks"><em class="fa fa-heart-o">&nbsp;</em>Snacks</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/categories"><em class="fa fa-arrows-alt">&nbsp;</em>Categories</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/disabled"><em class="fa fa-ban">&nbsp;</em>Disabled Products</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/disabled/categories"><em class="fa fa-ban">&nbsp;</em>Disabled Categories</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/upload"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cloud-arrow-up" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M7.646 5.146a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 6.707V10.5a.5.5 0 0 1-1 0V6.707L6.354 7.854a.5.5 0 1 1-.708-.708l2-2z"/>
                        <path d="M4.406 3.342A5.53 5.53 0 0 1 8 2c2.69 0 4.923 2 5.166 4.579C14.758 6.804 16 8.137 16 9.773 16 11.569 14.502 13 12.687 13H3.781C1.708 13 0 11.366 0 9.318c0-1.763 1.266-3.223 2.942-3.593.143-.863.698-1.723 1.464-2.383zm.653.757c-.757.653-1.153 1.44-1.153 2.056v.448l-.445.049C2.064 6.805 1 7.952 1 9.318 1 10.785 2.23 12 3.781 12h8.906C13.98 12 15 10.988 15 9.773c0-1.216-1.02-2.228-2.313-2.228h-.5v-.5C12.188 4.825 10.328 3 8 3a4.53 4.53 0 0 0-2.941 1.1z"/>
                        </svg>Upload Image</a></li>
                <li><a href="${pageContext.request.contextPath}/logout"><em class="fa fa-power-off">&nbsp;</em> Logout</a></li>
            </ul>
        </div><!--/.sidebar-->

        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/user">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Product Form</li>
                </ol>
            </div><!--/.row-->
            <!--            <a href="menu.html"><button class="button"><span>Create </span></button></a>-->
            <div class="table-responsive" style="margin-left: 20px;">
                <table class="table">
                    <div class="h">
                        <h2>User's Form</h2>                   
                        <p style="color: red">${message}</p>
                    </div>
                    <form:form action="${pageContext.request.contextPath}/admin/users/edited" method="POST" modelAttribute="account">
                        <div>
                            <form:label path="id">ID :</form:label><br>
                            <form:input type="number" path="id"  readonly="true" id="idview" />
                                <form:errors path="id"></form:errors>
                                </div>
                                <div hidden="hidden">
                                <form:label path="password">Password :</form:label><br>
                                <form:password path="password"  readonly="true" />
                                <form:errors path="password"></form:errors>
                                </div>
                                <div>
                                <form:label path="email">E-mail:</form:label><br>
                                    <form:input type="email" path="email" />
                                    <form:errors path="email" cssStyle="color:red;">Invalid Email</form:errors>
                                    </div>
                                    <div>
                                    <form:label path="username">Username:</form:label><br>
                                        <form:input path="username" />
                                        <form:errors path="username" cssStyle="color:red;"></form:errors>
                                        </div>
                                        <div>
                                        <form:label path="tel">Tel:</form:label><br>
                                            <form:input path="tel" />
                                            <form:errors path="tel" cssStyle="color:red;">Invalid Tel number</form:errors>
                                            </div>
                                            <div>
                                            <form:label path="firstname">First Name:</form:label><br>
                                                <form:input path="firstname" id="firstname" />
                                                <form:errors path="firstname" cssStyle="color:red;"></form:errors>
                                                </div>
                                                <div>
                                                <form:label path="lastname">Last Name:</form:label><br>
                                                    <form:input path="lastname" id="lastname" />
                                                    <form:errors path="lastname" cssStyle="color:red;"></form:errors>
                                                    </div>                           
                                                    <div>
                                                        <label for="roles">Roles :</label><br/>
                                                        <select id="roles" name="roles" value="${account.roles}" multiple="true" required="required">
                                                        <c:forEach items="${roles}" var="role">
                                                            <option value="${role.id}">${role.rname}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <p></p>
                                                </div>
                                                <div class="addform">
                                                    <input id="addbuttonform" style="margin-left:0;" class="button" type="submit" value="Update" />      
                                                </div>
                                                </form:form>
                                            </table>
                                        </div>
                                    </div>
                                </body>
                            </html>

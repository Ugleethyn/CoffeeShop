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
    </head>
    <body>
        <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed">
                        <span class="sr-only">Toggle navigation</span></button>
                    <a class="navbar-brand" href="#"><span>Coffee</span>Admin</a>
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
                <li><a href="${pageContext.request.contextPath}/admin/upload"><em class="fa fa-ban">&nbsp;</em>Upload Image</a></li>
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
                        <h2>Category's Form</h2>                   
                        <hr/>
                        <p>${message}</p>
                        <p id="message">${errormsg}</p>
                        <c:if test="${param.error != null}"> 
                            <p class="text-center registermsg" style="color: red">Invalid Credentials!</p>
                        </c:if>
                    </div>
                    <c:if test="${category.id == null}">
                        <c:url value="/admin/categories/create" var="link"/>
                    </c:if>
                    <c:if test="${category.id != null}">
                        <c:url  value="/admin/categories/update" var="link"/>
                    </c:if>
                    <form:form action="${link}" method="POST">
                        <div>
                            <input type="number" name="id" value="${category.id}" hidden />
                        </div>
                        <div>
                            <label for="pname">Category Name :</label>
                            <br/>
                            <input id="pname" type="text" placeholder="Category name" name="cname" value="${category.cname}" />
                            <p></p>
                        </div>
                        <div>
                            <label for="catb">Category :</label>
                            <br/>
                            <select id="catBId" name="catBId" value="${category.id}">
                                <c:forEach items="${catb}" var="cat">
                                    <option value="${cat.id}">${cat.catBName}</option>
                                </c:forEach>
                            </select>
                            <p></p>
                        </div>
                        <div class="addform">
                            <input id="addbuttonform" style="margin-left:0;" class="button" type="submit" value="Add/Update" />      
                        </div>
                    </form:form>
                </table>
            </div>
        </div>
    </body>
</html>

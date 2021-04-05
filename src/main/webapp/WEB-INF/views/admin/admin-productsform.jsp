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
                        <h2>Product's Form</h2>                   
                        <hr/>
                        <p>${message}</p>
                        <p id="message">${errormsg}</p>
                        <c:if test="${param.error != null}"> 
                            <p class="text-center registermsg" style="color: red">Invalid Credentials!</p>
                        </c:if>
                    </div>
                    <c:if test="${product.id==null}">
                        <c:url value="/admin/products/create" var="link"/>
                    </c:if>
                    <c:if test="${product.id!=null}">
                        <c:url  value="/admin/products/update" var="link"/>
                    </c:if>
                    <form:form action="${link}" method="POST">
                        <div>
                            <input type="number" name="id" value="${product.id}" hidden />
                        </div>
                        <div>
                            <label for="pname">Product Name :</label>
                            <br/>
                            <input id="pname" type="text" placeholder="Product name" name="pname" value="${product.pname}" />
                            <p></p>
                        </div>
                        <div>
                            <label for="baseprice">Product price :</label>
                            <br/>
                            <input id="baseprice" type="number" min="0" name="baseprice" value="${product.baseprice}" step="0.1" />
                            <p></p>
                        </div>
                        <div>
                            <label for="imgsrc">Image Path :</label>
                            <br/>
                            <input id="imgsrc" type="text" name="imgsrc" value="${product.imgsrc}" />
                            <p></p>
                        </div>    
                        <div>
                            <label for="cata">Product Category :</label>
                            <br/>
                            <select id="catAId" name="catAId" value="${product.catAId}">
                                <c:forEach items="${cata}" var="cat">
                                    <option value="${cat.id}">${cat.catAName}</option>
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

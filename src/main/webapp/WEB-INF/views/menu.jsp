<%-- 
    Document   : menu
    Created on : Mar 9, 2021, 1:28:06 PM
    Author     : Ugleethyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quick Coffee - Menu</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet"
              href="https://techsolutionshere.com/wp-content/themes/techsolution/assets/blog-post-css-js/meanmenu.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>


        <!-- Start Navbar Area -->
        <div class="navbar-area">
            <!-- Menu For Mobile Device -->
            <div class="mobile-nav">
                <a href="#" class="logo">
                    <img src="img/logo.png" alt="logo.png">
                </a>

            </div>

            <!-- Menu For Desktop Device -->
            <div class="main-nav navbr">
                <div class="container">
                    <nav class="navbar navbar-expand-md navbar-light ">
                        <a class="navbar-brand" href="#">
                            <img src="img/logo.png" alt="logo.png">
                        </a>
                        <div class="collapse navbar-collapse mean-menu" id="navbarSupportedContent">
                            <ul class="navbar-nav ml-auto">
                                <li class="nav-item">
                                    <a href="index.html" class="nav-link">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a href="menu.html" class="nav-link active">Catalog</a>
                                </li>
                                <li class="nav-item">
                                    <a href="about.html" class="nav-link">About us</a>
                                </li>
                                <li class="nav-item">
                                    <a href="contact.html" class="nav-link">Contact</a>
                                </li>
                                <li class="nav-item">
                                    <a href="register.html" class="nav-link">Sign Up</a>
                                </li>
                                <li class="nav-item">
                                    <a href="login.html" class="nav-link">Login</a>
                                </li>
                                <li class="nav-item">
                                    <a href="cart.html" class="nav-link"><svg xmlns="http://www.w3.org/2000/svg" width="16"
                                                                              height="16" fill="currentColor" class="bi bi-cart-fill" viewBox="0 0 16 16">
                                        <path
                                            d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
                                        </svg> Cart</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        <!-- End Navbar Area -->
        <div class="background">
            <!-- Page Content -->
            <div class="container section-ourTeam">
                <!-- /.row -->
                <div class="row">
                    <div class="col-md-3">
                        <div class="sticky filters">
                            <ul class="list-group">
                                <li class="list-group-item"> Coffees
                                    <span class="badge">145</span>
                                </li>
                                <li class="list-group-item"> Snacks
                                    <span class="badge">123</span>
                                </li>
                                <li class="list-group-item"> Drinks
                                    <span class="badge">114</span>
                                </li>
                            </ul>
                        </div>
                    </div>


                    <div class="col-md-9">
                        <h1>Coffees</h1>
                        <div class="row mg-b-30">

                            <c:forEach items="${coffeeTypes}" var = "coffeeType">
                                <div class="col-sm-4">
                                    <div class="shop-item">

                                        <div class="info hoveritem">
                                            <div class="row">
                                                <div class="price col-md-12">
                                                    <h5><img src="img/coffee.png" class="img-responsive" alt="a" /></h5>
                                                </div>
                                                <div class="price col-md-12">
                                                    <h5>${coffeeType.tname}</h5>
                                                </div>
                                                <div class="price col-md-12 col align-self-end">
                                                    <h5 class="price-text-color">€ ${coffeeType.cunitprice}</h5>
                                                </div>
                                            </div>
                                            <div class="separator clear-left">
                                                <p class="btn-add">
                                                    <i class="fa fa-shopping-cart"></i>
                                                    <a class="hidden-sm" id="myBtn">Add to cart</a>
                                                </p>
                                            </div>
                                            <div class="clearfix">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                            <div id="myModal" class="modal ">
                                <!-- Modal content -->
                                <div class="modal-content">
                                    <span class="close">&times;</span>
                                    <div class="formcoffe">
                                        <form action="">

                                            <div>
                                                <h5>Please select coffee size <span class="important">*</span></h5>
                                                <c:forEach items="${coffeeSizes}" var = "coffeeSize">
                                                    <div class="funkyradio">
                                                        <div class="funkyradio funkyradio-warning ">
                                                            <input type="radio" name="size" id="${coffeeSize.id}"/>
                                                            <label for="${coffeeSize.id}">${coffeeSize.sname} </label>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>

                                            <div>
                                                <h5>Please select coffee sugar <span class="important">*</span></h5>
                                                <c:forEach items="${coffeeSugar}" var = "sugar">
                                                    <div class="funkyradio">
                                                        <div class="funkyradio funkyradio-warning ">
                                                            <input type="radio" name="sugar" id="${sugar.id}" />
                                                            <label for="${sugar.id}">${sugar.sdescr} </label>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>



                                            <div>
                                                <h5>Please select ingredients</h5>
                                                <c:forEach items="${Ingredients}" var = "ingredients">
                                                    <div class="funkyradio">
                                                        <div class="funkyradio-warning">
                                                            <input type="checkbox" name="checkbox"
                                                                   id="checkbox1" />
                                                            <label for="checkbox1">${ingredients.iname}</label>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                            <div> <input type="number" name="quantity" value="1"
                                                         class="quantity" />
                                                <label for="quantity">Quantity</label>
                                            </div>

                                            <div class="btnplace"><button
                                                    class="button btnpopup"><span>Submit </span></button>
                                            </div>

                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <h1>Snacks</h1>
                        <div class="row">


                            <div class="col-sm-4">
                                <div class="shop-item">

                                    <div class="info hoveritem">
                                        <div class="row">
                                            <div class="price col-md-12">
                                                <h5> <img src="img/snack.png" class="img-responsive" alt="a" /> </h5>
                                            </div>
                                            <div class="price col-md-12">
                                                <h5> Τυρόπιτα </h5>
                                            </div>
                                            <div class="price col-md-12 col align-self-end">
                                                <h5 class="price-text-color"> €2.80 </h5>
                                            </div>
                                        </div>
                                        <div class="separator clear-left">
                                            <p class="btn-add">
                                                <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com"
                                                                                      class="hidden-sm">Add to cart</a>
                                            </p>

                                            <p class="btn-quantity">
                                                Quantity:
                                                <input type="number" value="1" class="quantity">
                                            </p>
                                        </div>
                                        <div class="clearfix">
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-4">
                                <div class="shop-item">

                                    <div class="info hoveritem">
                                        <div class="row">
                                            <div class="price col-md-12">
                                                <h5> <img src="img/snack.png" class="img-responsive" alt="a" /> </h5>
                                            </div>
                                            <div class="price col-md-12">
                                                <h5> Ζαμπονοτυρόπιτα </h5>
                                            </div>
                                            <div class="price col-md-12 col align-self-end">
                                                <h5 class="price-text-color"> €2.80 </h5>
                                            </div>
                                        </div>
                                        <div class="separator clear-left">
                                            <p class="btn-add">
                                                <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com"
                                                                                      class="hidden-sm">Add to cart</a>
                                            </p>

                                            <p class="btn-quantity">
                                                Quantity:
                                                <input type="number" value="1" class="quantity">
                                            </p>
                                        </div>
                                        <div class="clearfix">
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-4">
                                <div class="shop-item">

                                    <div class="info hoveritem">
                                        <div class="row">
                                            <div class="price col-md-12">
                                                <h5> <img src="img/snack.png" class="img-responsive" alt="a" /> </h5>
                                            </div>
                                            <div class="price col-md-12">
                                                <h5> Pizza </h5>
                                            </div>
                                            <div class="price col-md-12 col align-self-end">
                                                <h5 class="price-text-color"> €2.80 </h5>
                                            </div>
                                        </div>
                                        <div class="separator clear-left">
                                            <p class="btn-add">
                                                <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com"
                                                                                      class="hidden-sm">Add to cart</a>
                                            </p>

                                            <p class="btn-quantity">
                                                Quantity:
                                                <input type="number" value="1" class="quantity">
                                            </p>
                                        </div>
                                        <div class="clearfix">
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-4">
                                <div class="shop-item">

                                    <div class="info hoveritem">
                                        <div class="row">
                                            <div class="price col-md-12">
                                                <h5> <img src="img/snack.png" class="img-responsive" alt="a" /> </h5>
                                            </div>
                                            <div class="price col-md-12">
                                                <h5> Τυρόπιτα κουρού </h5>
                                            </div>
                                            <div class="price col-md-12 col align-self-end">
                                                <h5 class="price-text-color"> €2.80 </h5>
                                            </div>
                                        </div>
                                        <div class="separator clear-left">
                                            <p class="btn-add">
                                                <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com"
                                                                                      class="hidden-sm">Add to cart</a>
                                            </p>

                                            <p class="btn-quantity">
                                                Quantity:
                                                <input type="number" value="1" class="quantity">
                                            </p>
                                        </div>
                                        <div class="clearfix">
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-4">
                                <div class="shop-item">

                                    <div class="info hoveritem">
                                        <div class="row">
                                            <div class="price col-md-12">
                                                <h5> <img src="img/snack.png" class="img-responsive" alt="a" /> </h5>
                                            </div>
                                            <div class="price col-md-12">
                                                <h5> Κασερόπιτα </h5>
                                            </div>
                                            <div class="price col-md-12 col align-self-end">
                                                <h5 class="price-text-color"> €2.80 </h5>
                                            </div>
                                        </div>
                                        <div class="separator clear-left">
                                            <p class="btn-add">
                                                <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com"
                                                                                      class="hidden-sm">Add to cart</a>
                                            </p>

                                            <p class="btn-quantity">
                                                Quantity:
                                                <input type="number" value="1" class="quantity">
                                            </p>
                                        </div>
                                        <div class="clearfix">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <h1>Drinks</h1>
                        <div class="row">


                            <div class="col-sm-4">
                                <div class="shop-item">

                                    <div class="info hoveritem">
                                        <div class="row">
                                            <div class="price col-md-12">
                                                <h5> <img src="img/drink.png" class="img-responsive" alt="a" /> </h5>
                                            </div>
                                            <div class="price col-md-12">
                                                <h5> Coca-Cola </h5>
                                            </div>
                                            <div class="price col-md-12 col align-self-end">
                                                <h5 class="price-text-color"> €2.00 </h5>
                                            </div>
                                        </div>
                                        <div class="separator clear-left">
                                            <p class="btn-add">
                                                <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com"
                                                                                      class="hidden-sm">Add to cart</a>
                                            </p>

                                            <p class="btn-quantity">
                                                Quantity:
                                                <input type="number" value="1" class="quantity">
                                            </p>
                                        </div>
                                        <div class="clearfix">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="shop-item">

                                    <div class="info hoveritem">
                                        <div class="row">
                                            <div class="price col-md-12">
                                                <h5> <img src="img/drink.png" class="img-responsive" alt="a" /> </h5>
                                            </div>
                                            <div class="price col-md-12">
                                                <h5> Sprite </h5>
                                            </div>
                                            <div class="price col-md-12 col align-self-end">
                                                <h5 class="price-text-color"> €2.80 </h5>
                                            </div>
                                        </div>
                                        <div class="separator clear-left">
                                            <p class="btn-add">
                                                <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com"
                                                                                      class="hidden-sm">Add to cart</a>
                                            </p>

                                            <p class="btn-quantity">
                                                Quantity:
                                                <input type="number" value="1" class="quantity">
                                            </p>
                                        </div>
                                        <div class="clearfix">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="shop-item">

                                    <div class="info hoveritem">
                                        <div class="row">
                                            <div class="price col-md-12">
                                                <h5> <img src="img/drink.png" class="img-responsive" alt="a" /> </h5>
                                            </div>
                                            <div class="price col-md-12">
                                                <h5> Πορτοκαλάδα Fanta </h5>
                                            </div>
                                            <div class="price col-md-12 col align-self-end">
                                                <h5 class="price-text-color"> €2.80 </h5>
                                            </div>
                                        </div>
                                        <div class="separator clear-left">
                                            <p class="btn-add">
                                                <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com"
                                                                                      class="hidden-sm">Add to cart</a>
                                            </p>

                                            <p class="btn-quantity">
                                                Quantity:
                                                <input type="number" value="1" class="quantity">
                                            </p>
                                        </div>
                                        <div class="clearfix">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="shop-item">

                                    <div class="info hoveritem">
                                        <div class="row">
                                            <div class="price col-md-12">
                                                <h5> <img src="img/drink.png" class="img-responsive" alt="a" /> </h5>
                                            </div>
                                            <div class="price col-md-12">
                                                <h5> Monster </h5>
                                            </div>
                                            <div class="price col-md-12 col align-self-end">
                                                <h5 class="price-text-color"> €2.80 </h5>
                                            </div>
                                        </div>
                                        <div class="separator clear-left">
                                            <p class="btn-add">
                                                <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com"
                                                                                      class="hidden-sm">Add to cart</a>
                                            </p>

                                            <p class="btn-quantity">
                                                Quantity:
                                                <input type="number" value="1" class="quantity">
                                            </p>
                                        </div>
                                        <div class="clearfix">
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <footer class="nb-footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <div class="footer-info-single">
                            <h2 class="title">information</h2>
                            <ul class="list-unstyled">
                                <li><a href="http://www.nextbootstrap.com/" title=""><i
                                            class="fa fa-angle-double-right"></i> About Us</a></li>
                                <li><a href="http://www.nextbootstrap.com/" title=""><i
                                            class="fa fa-angle-double-right"></i> Live Chat</a></li>
                                <li><a href="http://www.nextbootstrap.com/" title=""><i
                                            class="fa fa-angle-double-right"></i> Contact Us</a></li>
                            </ul>
                        </div>
                    </div>


                    <div class="col-md-3 col-sm-6">
                        <div class="footer-info-single">
                            <h2 class="title">Payment</h2>
                            <ul class="list-unstyled">
                                <li><a href="http://www.nextbootstrap.com/" title=""><i
                                            class="fa fa-angle-double-right"></i> Supported Methods</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="footer-info-single location">
                            <h2 class="title">Address</h2>
                            <h6 class="copyrighttext"> Nikolaou Plastira 8<br> Aigaleo 12242</h6>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="footer-info-single location">
                            <iframe
                                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d393.03731652767897!2d23.68237087174767!3d37.993496642855426!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14a1bcb079ef11e3%3A0x5d5a1b265910580!2zzp3Ouc66LiDOoM67zrHPg8-Ezq7Pgc6xIDgsIM6RzrnOs86szrvOtc-JIDEyMiA0Mg!5e0!3m2!1sel!2sgr!4v1615127573355!5m2!1sel!2sgr"
                                width="250" height="200" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
                        </div>
                    </div>
                </div>
            </div>

            <section class="copyright">
                <div class="container">
                    <div class="row">
                        <p class="col-md-12">© 2021 by Company</p>
                    </div>
                </div>
            </section>
        </footer>

        <script src="js/script.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script
        src="https://techsolutionshere.com/wp-content/themes/techsolution/assets/blog-post-css-js/jquery.meanmenu.js"></script>
        <script>
            // Mean Menu
            jQuery('.mean-menu').meanmenu({
                meanScreenWidth: "991"
            });
        </script>
    </body>

</html>
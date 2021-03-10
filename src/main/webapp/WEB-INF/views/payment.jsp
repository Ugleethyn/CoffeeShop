<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quick Coffee - Payment</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://techsolutionshere.com/wp-content/themes/techsolution/assets/blog-post-css-js/meanmenu.css">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="icon" href="img/logo.png" type="image/png">
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>
        <!-- Start Navbar Area -->
        <div class="navbar-area">
            <!-- Menu For Mobile Device -->
            <div class="mobile-nav">
                <a href="${pageContext.request.contextPath}" class="logo">
                    <img src="img/logo.png" alt="logo.png">
                </a>

            </div>

            <!-- Menu For Desktop Device -->
            <div class="main-nav navbr">
                <div class="container">
                    <nav class="navbar navbar-expand-md navbar-light ">
                        <a class="navbar-brand" href="${pageContext.request.contextPath}">
                            <img src="img/logo.png" alt="logo.png">
                        </a>
                        <div class="collapse navbar-collapse mean-menu" id="navbarSupportedContent">
                            <ul class="navbar-nav ml-auto">
                                <li class="nav-item">
                                    <a href="${pageContext.request.contextPath}" class="nav-link">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a href="${pageContext.request.contextPath}/menu" class="nav-link">Catalog</a>
                                </li>
                                <li class="nav-item">
                                    <a href="${pageContext.request.contextPath}/about" class="nav-link">About us</a>
                                </li>
                                <li class="nav-item">
                                    <a href="${pageContext.request.contextPath}/contact" class="nav-link">Contact</a>
                                </li>
                                <li class="nav-item">
                                    <a href="${pageContext.request.contextPath}/register" class="nav-link">Sign Up</a>
                                </li>
                                <li class="nav-item">
                                    <a href="${pageContext.request.contextPath}/login" class="nav-link">Login</a>
                                </li>
                                <li class="nav-item">
                                    <a href="${pageContext.request.contextPath}/cart" class="nav-link"><svg xmlns="http://www.w3.org/2000/svg" width="16"
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


            <div class="container section-ourTeam cartcont">
                <div class="row">
                    <div class="col-md-12 ourTeam-hedding text-center">
                        <h1>Methods of payment </h1>
                        <p>We support payment by PayPal and cash.<br>
                            In the near future support will be added for Mastercard, Visa, American Express & UnionPay credit cards.</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <div class="row section-success ourTeam-box text-center">
                            <div class="col-md-12 section1">
                                <img src="img/paypal.png">
                                <img src="img/euro.png">
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
                            <h6 class="copyrighttext"> ΔΙΑΚΟΣ ΓΕΩΡΓΙΟΣ ΘΩΜΑΣ<br> Αγίου Σπυρίδωνος 30, Αιγάλεω 122 43</h6>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="footer-info-single location">

                            <iframe
                                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2159.7628164473044!2d23.677737899792234!3d38.0035907939023!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14a1bcad2f600229%3A0xe23cb5903685855!2zzpTOmc6RzprOn86jIM6TzpXOqc6hzpPOmc6fzqMgzpjOqc6czpHOow!5e0!3m2!1sel!2sgr!4v1614946725755!5m2!1sel!2sgr"
                                width="250" height="200" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyright">
                <div class="container" style="width: 100%;">
                    <div class="row">
                        <div class="col-md-12">
                            <p>© 2021 by Company</p>
                        </div>
                    </div>
                </div>
        </footer>
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
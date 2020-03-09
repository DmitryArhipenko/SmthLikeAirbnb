<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Bookings4All</title>

    <!-- Bootstrap core CSS -->
    <link href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="${contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet"
          type="text/css">
    <link href="/https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
          rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="${contextPath}/resources/css/landing-page.min.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-light bg-light static-top">
    <div class="container">
        <a class="navbar-brand" href="${contextPath}/welcome">Bookings4All</a>
        <div><a class="btn btn-primary" href="${contextPath}/login">Sign In</a>
            <a class="btn btn-primary" href="${contextPath}/registration">Sign Up!</a></div>
    </div>
</nav>

<!-- Masthead -->
<header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-xl-9 mx-auto">
                <h1 class="mb-5">Start searching apartments for ONS in required city</h1>
            </div>
            <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
                <form:form method="POST" modelAttribute="city" class="adv-form">
                    <div class="form-row">
                        <div class="col-12 col-md-9 mb-2 mb-md-0">
                            <input type="text" name="city" class="form-control form-control-lg"
                                   placeholder="Enter the city you need...">
                        </div>
                        <div class="col-12 col-md-3">
                            <button type="submit" class="btn btn-block btn-lg btn-primary">Search</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</header>

<!-- Icons Grid -->
<section class="features-icons bg-light text-center">
    <div class="container">
        <div><h1>Using our service you may choose one of 3 main apartment types depending on your opportunity. Tap the
            necessary</h1></div>
        <div class="row">
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                    <div class="features-icons-icon d-flex">
                        <a href="${contextPath}/advertisments/search/byapartmenttype/Corner"><i class="icon-list m-auto text-primary"></i></a>
                    </div>
                    <h3>Corner</h3>
                    <p class="lead mb-0">Just a part of the room</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                    <div class="features-icons-icon d-flex">
                        <a href="${contextPath}/advertisments/search/byapartmenttype/Room"><i class="icon-list m-auto text-primary"></i></a>
                    </div>
                    <h3>Room</h3>
                    <p class="lead mb-0">The whole room at your disposal</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-0 mb-lg-3">
                    <div class="features-icons-icon d-flex">
                        <a href="${contextPath}/advertisments/search/byapartmenttype/Apartment"><i class="icon-list m-auto text-primary"></i></a>
                    </div>
                    <h3>Apartment</h3>
                    <p class="lead mb-0">Nobody will bother you, make yourself feel like at home</p>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Image Showcases -->
<section class="showcase">
    <div class="container-fluid p-0">
        <div class="row no-gutters">

            <div class="col-lg-6 order-lg-2 text-white showcase-img"
                 style="background-image: url('/resources/static/corner.jpg');"></div>
            <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                <h2>Corner</h2>
                <p class="lead mb-0">The owner offers you a corner where there is a sofa or bed so that you can spend
                    the night and gain strength to continue your journey.</p>
            </div>
        </div>
        <div class="row no-gutters">
            <div class="col-lg-6 text-white showcase-img"
                 style="background-image: url('/resources/static/room.jpg');"></div>
            <div class="col-lg-6 my-auto showcase-text">
                <h2>Room</h2>
                <p class="lead mb-0">You get the opportunity to stay overnight and this time in your order there will
                    already be not just a corner but a whole room.
            </div>
        </div>
        <div class="row no-gutters">
            <div class="col-lg-6 order-lg-2 text-white showcase-img"
                 style="background-image: url('/resources/static/apartment.jpg');"></div>
            <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                <h2>Apartment</h2>
                <p class="lead mb-0">Wow, the best option for you if you are not traveling alone. The owner can offer
                    you entire apartments with all the amenities that will be at your disposal
            </div>
        </div>
    </div>
</section>

<!-- Testimonials -->
<section class="testimonials text-center bg-light">
    <div class="container">
        <h2 class="mb-5">What people are saying...</h2>
        <div class="row">
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="img-fluid rounded-circle mb-3" src="/resources/static/testimonials-1.jpg" alt="">
                    <h5>Margaret E.</h5>
                    <p class="font-weight-light mb-0">"This is fantastic! Thanks so much guys!"</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="img-fluid rounded-circle mb-3" src="/resources/static/testimonials-2.jpg" alt="">
                    <h5>Fred S.</h5>
                    <p class="font-weight-light mb-0">"I used it to stay in Barcelona this summer. Thanks!"</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="img-fluid rounded-circle mb-3" src="/resources/static/testimonials-3.jpg" alt="">
                    <h5>Sarah W.</h5>
                    <p class="font-weight-light mb-0">"Thanks so much for making my travelling much easier!"</p>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Call to Action -->
<section class="call-to-action text-white text-center">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-xl-9 mx-auto">
                <h2 class="mb-4">Haven't joined us yet? Sign up now!</h2>
            </div>
            <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
                <a class="btn btn-primary" href="${contextPath}/registration">Sign Up!</a></div>
        </div>
    </div>
    </div>
</section>

<!-- Footer -->
<footer class="footer bg-light">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 h-100 text-center text-lg-left my-auto">
                <p class="text-muted small mb-4 mb-lg-0">&copy;My non comercial pet-project 2020. All Rights Reserved.</p>
            </div>
            <div class="col-lg-6 h-100 text-center text-lg-right my-auto">
                <ul class="list-inline mb-0">
                    <li class="list-inline-item mr-3">
                        <a href="https://www.linkedin.com/in/dmytro-arkhypenko-1657201a0?lipi=urn%3Ali%3Apage%3Ad_flagship3_profile_view_base_contact_details%3BYzr5tUyyRnOKXKgS6nzFYQ%3D%3D">
                            <i class="fab fa-linkedin fa-2x fa-fw"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="https://github.com/DmytroArkhypenko">
                            <i class="fab fa-github fa-2x fa-fw"></i>
                        </a>
                    </li>
                    <li class="list-inline-item mr-3">
                        <a href="#">
                            dmytro.arkhypenko1@gmail.com
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>

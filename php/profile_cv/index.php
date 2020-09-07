<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>oRESUME | 1 Page Resume & Portfolio</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- jQuery -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

    <!-- Bootstrap -->
    <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="./bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <script src="./bootstrap/js/bootstrap.min.js"></script>

    <!-- Glyphicons -->
    <link href="./css/glyphicons.css" rel="stylesheet" media="screen">

    <!-- Plugins -->
    <script src="./js/jquery.easing.1.3.js"></script>
    <script src="./js/jquery.isotope.min.js"></script>
    <script src="./js/jquery.ba-resize.min.js"></script>

    <link href="./css/prettyPhoto.css" rel="stylesheet" media="screen">
    <script src="./js/jquery.prettyPhoto.js"></script>

    <script src="./js/klass.min.js"></script>
    <script src="./js/code.photoswipe.jquery-3.0.4.min.js"></script>
    <link href="./css/photoswipe.css" rel="stylesheet" media="screen">

    <!-- Theme -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans|Oswald|Droid+Sans|Yanone+Kaffeesatz|Droid+Serif|Ubuntu|Lobster|Francois+One|Arvo|Changa+One|Rokkitt|Nunito|Bitter|Merriweather|Raleway|Pacifico|Josefin+Sans|Questrial|Cantarell|Norican|Vollkorn|Quicksand|Limelight|Cantata+One|Bree+Serif|Oleo+Script|Playfair+Display|Quattrocento+Sans|Berkshire+Swash|Passion+One|Cuprum' rel='stylesheet' type='text/css'>
    <link href="./style.css" rel="stylesheet" media="screen">
    <script src="./js/scripts.js"></script>

    <!-- Skin -->
    <link type="text/css" rel="stylesheet" href="./css/skin.php" media="screen">


    <!--[if lt IE 9]>
    <link rel="stylesheet" type="text/css" href="./css/ie.css" />
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- PRINT CSS -->
    <link type="text/css" rel="stylesheet" href="./css/print.css" media="print">


</head>

<body class="backgrounded" data-spy="scroll" data-target=".sidebar-nav">
<?php
/**** SKIN CONFIGURATOR ****/   /* once your skin defined, remove or comment the line below */
require('./configurator/configurator.php');
?>


<div class="navbar navbar-inverse navbar-fixed-top visible-phone noprint" id="phone-navbar">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="btn btn-navbar" href="#" style="padding: 5px 10px 3px;"><i class="icon-white icon-download "></i></a>
            <a class="brand" href="#">Arturo López</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li><a href="#about-me" class="scroller">Sobre mi</a></li>
                    <li><a href="#personal-information" class="scroller">Información Personal</a></li>
                    <li><a href="#employment" class="scroller">Experiencia</a></li>
                    <li><a href="#education" class="scroller">Educación</a></li>
                    <li><a href="#skills" class="scroller">Conocimientos</a></li>
                    <li><a href="#hobbies" class="scroller">Aficiones</a></li>
                    <li><a href="#portfolio" class="scroller">Portafolio</a></li>
                    <li><a href="#blog" class="scroller">Blog</a></li>
                    <li><a href="#contact" class="scroller">Contacto</a></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>
<!--/#phone-navbar -->

<div class="container">
    <div class="row" id="content">

        <!-- If you want the sidebar placed on the left, place it just after this and change the sbright class by sbleft -->

        <!-- MAIN CONTENT -->
        <div class="span9 equal" id="main-content">

            <div class="tools noprint visible-desktop">
                <a href="javascript:if(window.print)window.print()" title="Print" data-placement="bottom" class="tips glyphicons print"><i></i></a>
                <a href="#" title="Download" data-placement="bottom" class="tips glyphicons file_import"><i></i></a>
            </div>


            <div class="section first-section" id="about-me">
                <div class="row author">
                    <div class="span3">
                        <img class="img-rounded" src="./images/portrait.jpg" alt="">
                    </div>
                    <div class="span6">
                        <h1>Arturo López</h1><br />
                        <h2 class="primary-color">Webmaster</h2>
                    </div>
                </div>


                <div class="well">
                    <h3>Soy programador web @ <a href="http://www.grupoargos.com.mx" target="_blank">Grupo Argos</a>
                    </h3>
                    <p class="lead">
                        Desarrollo de apicaciones web para el control interno de la compañia.
                    </p>
                </div>

                <div class="social-media noprint">
                    <h5>Sigueme</h5>
                    <div>
                        <div class="tips icon-btn" title="Facebook" data-placement="bottom">
                            <a href="http://www.facebook.com/arthurolg" class="glyphicons white facebook" target="_blank"><i></i></a>
                        </div>
                        <div class="tips icon-btn" title="Twitter" data-placement="bottom">
                            <a href="#http://www.twitter.com/arthurolg" class="glyphicons white twitter" target="_blank"><i></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <!--/section-->

            <div class="section" id="personal-information">
                <h2 class="section-title">
                    <span class="glyphicons user"><i></i></span>Información Personal<a href="#phone-navbar" class="top visible-phone"><span class="glyphicons white up_arrow"><i></i></span></a>
                </h2>

                <div class="row">
                    <div class="infoline span9 first">
                        <div class="row">
                            <div class="span2 muted">Fecha nacimiento</div>
                            <div class="span7">Enero 17, 1983</div>
                        </div>
                    </div>
                    <span class="clear"></span>

                    <div class="infoline span9">
                        <div class="row">
                            <div class="span2 muted">Direccion</div>
                            <div class="span7">
                                Residencial Alejandria<br />
                                Cancún<br />
                                Q. Roo
                            </div>
                        </div>
                    </div>
                    <span class="clear"></span>

                    <div class="infoline span9">
                        <div class="row">
                            <div class="span2 muted">Correo</div>
                            <div class="span7">arthurolg@gmail.com</div>
                        </div>
                    </div>
                    <span class="clear"></span>

                    <div class="infoline span9">
                        <div class="row">
                            <div class="span2 muted">Telefono</div>
                            <div class="span7">
                                998 169 75 78
                            </div>
                        </div>
                    </div>
                    <span class="clear"></span>

                    <div class="infoline span9 last">
                        <div class="row">
                            <div class="span2 muted">Sitio web</div>
                            <div class="span7">
                                <a href="http://www.arthurolg.com" title="Personal" target="_blank">arthurolg.com</a><br />
                                <a href="http://blog.arthurolg.com" title="Blog" target="_blank">blog.arthurolg.com</a>
                            </div>
                        </div>
                    </div>
                    <span class="clear"></span>

                </div>
            </div>
            <!--/section-->

            <div class="section" id="employment">
                <h2 class="section-title">
                    <span class="glyphicons share_alt"><i></i></span>Employment<a href="#phone-navbar" class="top visible-phone"><span class="glyphicons white up_arrow"><i></i></span></a>
                </h2>

                <div class="timeline">

                    <div class="timeline-item">
                        <div class="timeline-item-date">2011 - now</div>
                        <div class="timeline-item-trigger">
                            <span class="glyphicons white circle_minus" data-toggle="collapse" data-target="#position1"><i></i></span>
                        </div>
                        <div class="timeline-arrow"><i></i></div>
                        <div class="timeline-item-content">
                            <h3 class="timeline-item-title" data-toggle="collapse" data-target="#position1">Senior UX Designer @ Company</h3>
                            <div class="collapse in" id="position1">
                                <p><small class="muted">from 2011 to present day</small></p>
                                <h4 class="media-heading primary-color">Lorem ipsum dolor sit amet</h4>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tincidunt diam ac lectus tristique scelerisque. Quisque vitae libero sit amet turpis faucibus auctor eget vitae tortor. Aenean metus erat, ultricies non mattis quis, molestie ac massa. Sed sollicitudin erat ac dui viverra a posuere eros adipiscing. Phasellus nisi lectus, imperdiet sed hendrerit ac, dictum quis sem. Phasellus vel nisi non massa elementum porta. Aliquam erat volutpat.</p>
                                <p><a href="#" title="" class="noprint">&rarr; View website</a></p>
                            </div>
                        </div>
                    </div>
                    <!--/timeline-item-->
                    <span class="clear"></span>

                    <div class="timeline-item">
                        <div class="timeline-item-date">2010 - 2011</div>
                        <div class="timeline-item-trigger">
                            <span class="glyphicons white circle_plus" data-toggle="collapse" data-target="#position2"><i></i></span>
                        </div>
                        <div class="timeline-arrow"><i></i></div>
                        <div class="timeline-item-content">
                            <h3 class="timeline-item-title" data-toggle="collapse" data-target="#position2">Junior UX Designer @ Company</h3>
                            <div class="collapse" id="position2">
                                <p><small class="muted">from 2010 to 2011</small></p>
                                <h4 class="media-heading primary-color">Lorem ipsum dolor sit amet</h4>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tincidunt diam ac lectus tristique scelerisque. Quisque vitae libero sit amet turpis faucibus auctor eget vitae tortor. Aenean metus erat, ultricies non mattis quis, molestie ac massa. Sed sollicitudin erat ac dui viverra a posuere eros adipiscing. Phasellus nisi lectus, imperdiet sed hendrerit ac, dictum quis sem. Phasellus vel nisi non massa elementum porta. Aliquam erat volutpat.</p>
                            </div>
                        </div>
                    </div>
                    <!--/timeline-item-->
                    <span class="clear"></span>

                    <div class="timeline-item">
                        <div class="timeline-item-date">2009 - 2010</div>
                        <div class="timeline-item-trigger">
                            <span class="glyphicons white circle_plus" data-toggle="collapse" data-target="#position3"><i></i></span>
                        </div>
                        <div class="timeline-arrow"><i></i></div>
                        <div class="timeline-item-content">
                            <h3 class="timeline-item-title" data-toggle="collapse" data-target="#position3">Webdesigner @ Studioprod</h3>
                            <div class="collapse" id="position3">
                                <p><small class="muted">from october 2009 to 2010</small></p>
                                <h4 class="media-heading primary-color">Lorem ipsum dolor sit amet</h4>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tincidunt diam ac lectus tristique scelerisque. Quisque vitae libero sit amet turpis faucibus auctor eget vitae tortor. Aenean metus erat, ultricies non mattis quis, molestie ac massa. Sed sollicitudin erat ac dui viverra a posuere eros adipiscing. Phasellus nisi lectus, imperdiet sed hendrerit ac, dictum quis sem. Phasellus vel nisi non massa elementum porta. Aliquam erat volutpat.</p>
                            </div>
                        </div>
                    </div>
                    <!--/timeline-item-->
                    <span class="clear"></span>

                    <div class="timeline-item">
                        <div class="timeline-item-date">2008 - 2009</div>
                        <div class="timeline-item-trigger">
                            <span class="glyphicons white circle_plus" data-toggle="collapse" data-target="#position4"><i></i></span>
                        </div>
                        <div class="timeline-arrow"><i></i></div>
                        <div class="timeline-item-content">
                            <h3 class="timeline-item-title" data-toggle="collapse" data-target="#position4">Designer @ Creativecompany</h3>
                            <div class="collapse" id="position4">
                                <p><small class="muted">from 2008 to 2009</small></p>
                                <h4 class="media-heading primary-color">Lorem ipsum dolor sit amet</h4>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tincidunt diam ac lectus tristique scelerisque. Quisque vitae libero sit amet turpis faucibus auctor eget vitae tortor. Aenean metus erat, ultricies non mattis quis, molestie ac massa. Sed sollicitudin erat ac dui viverra a posuere eros adipiscing. Phasellus nisi lectus, imperdiet sed hendrerit ac, dictum quis sem. Phasellus vel nisi non massa elementum porta. Aliquam erat volutpat.</p>
                            </div>
                        </div>
                    </div>
                    <!--/timeline-item-->
                    <span class="clear"></span>

                </div>
                <!--/timeline -->
            </div>
            <!--/section-->


            <div class="section" id="education">
                <h2 class="section-title">
                    <span class="glyphicons certificate"><i></i></span>Education<a href="#phone-navbar" class="top visible-phone"><span class="glyphicons white up_arrow"><i></i></span></a>
                </h2>

                <div class="timeline">

                    <div class="timeline-item">
                        <div class="timeline-item-date">2007 - 2009</div>
                        <div class="timeline-item-trigger">
                            <span class="glyphicons white circle_minus" data-toggle="collapse" data-target="#education1"><i></i></span>
                        </div>
                        <div class="timeline-arrow"><i></i></div>
                        <div class="timeline-item-content">
                            <h3 class="timeline-item-title" data-toggle="collapse" data-target="#education1">University of Design</h3>
                            <div class="collapse in" id="education1">
                                <p><small class="muted">from 2007 to 2009</small></p>
                                <h4 class="media-heading primary-color">Lorem ipsum dolor sit amet</h4>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tincidunt diam ac lectus tristique scelerisque. Quisque vitae libero sit amet turpis faucibus auctor eget vitae tortor. Aenean metus erat, ultricies non mattis quis, molestie ac massa. Sed sollicitudin erat ac dui viverra a posuere eros adipiscing. Phasellus nisi lectus, imperdiet sed hendrerit ac, dictum quis sem. Phasellus vel nisi non massa elementum porta. Aliquam erat volutpat.</p>
                            </div>
                        </div>
                    </div>
                    <!--/timeline-item-->
                    <span class="clear"></span>

                    <div class="timeline-item">
                        <div class="timeline-item-date">2004 - 2007</div>
                        <div class="timeline-item-trigger">
                            <span class="glyphicons white circle_plus" data-toggle="collapse" data-target="#education2"><i></i></span>
                        </div>
                        <div class="timeline-arrow"><i></i></div>
                        <div class="timeline-item-content">
                            <h3 class="timeline-item-title" data-toggle="collapse" data-target="#education2">School of Design</h3>
                            <div class="collapse" id="education2">
                                <p><small class="muted">from 2004 to 2007</small></p>
                                <h4 class="media-heading primary-color">Lorem ipsum dolor sit amet</h4>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tincidunt diam ac lectus tristique scelerisque. Quisque vitae libero sit amet turpis faucibus auctor eget vitae tortor. Aenean metus erat, ultricies non mattis quis, molestie ac massa. Sed sollicitudin erat ac dui viverra a posuere eros adipiscing. Phasellus nisi lectus, imperdiet sed hendrerit ac, dictum quis sem. Phasellus vel nisi non massa elementum porta. Aliquam erat volutpat.</p>
                            </div>
                        </div>
                    </div>
                    <!--/timeline-item-->
                    <span class="clear"></span>
                </div>
                <!--/timeline -->

            </div>
            <!--/section-->


            <div class="section skills" id="skills">
                <h2 class="section-title">
                    <span class="glyphicons cogwheels"><i></i></span>Skills<a href="#phone-navbar" class="top visible-phone"><span class="glyphicons white up_arrow"><i></i></span></a>
                </h2>
                <h3>Design</h3>

                <div class="row">
                    <div class="span2">Print</div>
                    <div class="span3">
                        <span class="printonly">Good</span>
                        <div class="progress">
                            <div class="bar" style="width: 60%;"></div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="span2">Web</div>
                    <div class="span3">
                        <span class="printonly">Very good</span>
                        <div class="progress">
                            <div class="bar" style="width: 80%;"></div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="span2">User Interface</div>
                    <div class="span3">
                        <span class="printonly">Expert</span>
                        <div class="progress">
                            <div class="bar" style="width: 100%;"></div>
                        </div>
                    </div>
                </div>

                <hr />

                <h3>Development</h3>

                <div class="row">
                    <div class="span2">Programming Languages</div>
                    <div class="span7">
                        <span class="label">HTML5</span>
                        <span class="label">CSS3</span>
                        <span class="label">javaScript</span>
                        <span class="label">jQuery</span>
                        <span class="label">XML</span>
                        <span class="label">php5</span>
                    </div>
                </div>
                <span class="spacer"></span>
                <div class="row">
                    <div class="span2">CMS</div>
                    <div class="span7">
                        <span class="label">Wordpress</span>
                        <span class="label">Drupal</span>
                        <span class="label">Joomla</span>
                    </div>
                </div>

            </div>
            <!--/section-->

            <div class="section" id="testimonials">
                <h2 class="section-title">
                    <span class="glyphicons comments"><i></i></span>Testimonials<a href="#phone-navbar" class="top visible-phone"><span class="glyphicons white up_arrow"><i></i></span></a>
                </h2>

                <div class="testimonial">
                    <blockquote>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                        <p>Integer posuere erat a ante. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                        <small><a href="#" title="">Mike Johanson</a><cite> | SEO @ SDA Company</cite></small>
                    </blockquote>
                </div>

                <div class="testimonial">
                    <div class="media">
                        <img class="media-object pull-left" src="images/80-80-portrait.jpg" alt="">
                        <div class="media-body">
                            <blockquote>
                                <p>Donec eros magna, blandit eu tempus a, ornare quis nulla. Cras gravida fringilla tellus a euismod. Curabitur risus lacus, congue eget condimentum id, feugiat et nisl. Nulla diam lacus, posuere eget gravida in, gravida id sem. Etiam pharetra ornare sollicitudin.</p>
                                <small><a href="#" title="">John Robinson</a><cite> | client @ Starlabs</cite></small>
                            </blockquote>
                        </div>
                    </div>
                </div>

                <div class="testimonial">
                    <blockquote>
                        <p>Vivamus gravida convallis est, non tristique nisl pellentesque ut. Praesent congue tortor vel quam scelerisque in suscipit elit malesuada. Nam volutpat ultricies augue, ac accumsan dolor ornare eu. Nam ut egestas nulla.</p>
                        <p>Nunc ullamcorper, nulla vitae pellentesque dictum, diam ligula iaculis ipsum, aliquam vestibulum leo libero vel turpis.</p>
                        <small><a href="#" title="">Bob Smith</a><cite> | Designer @ ZNS Agency</cite></small>
                    </blockquote>
                </div>

            </div>
            <!--/section-->

            <div class="section hobbies" id="hobbies">
                <h2 class="section-title">
                    <span class="glyphicons heart_empty"><i></i></span>Hobbies<a href="#phone-navbar" class="top visible-phone"><span class="glyphicons white up_arrow"><i></i></span></a>
                </h2>

                <div class="row">
                    <div class="span9">
							<span class="label tips mobtoo" title="I love sci-fy & action movies">
								<span class="glyphicons white film"><i></i>Movies</span>
							</span>
                        <span class="label tips mobtoo" title="PADI Open Waters<br/>About 50 dives all around the world: Thailand, Indonesia, Malaysia, Mediterranean Sea…">
								<span class="glyphicons white scuba_diving"><i></i>Scuba Diving</span>
							</span>
                        <span class="label"><span class="glyphicons white pool"><i></i>Swimming</span></span>
                        <span class="label"><span class="glyphicons white bicycle"><i></i>Bicycling</span></span>
                        <span class="label"><span class="glyphicons white baseball"><i></i>Baseball</span></span>
                        <span class="label"><span class="glyphicons white gamepad"><i></i>Video games</span></span>
                        <span class="label"><span class="glyphicons white piano"><i></i>Piano</span></span>
                        <span class="label"><span class="glyphicons white globe"><i></i>Traveling</span></span>
                        <span class="label"><span class="glyphicons white cake"><i></i>Cooking</span></span>
                    </div>
                </div>

            </div>
            <!--/section-->


            <div class="section clearfix noprint" id="portfolio">
                <h2 class="section-title">
                    <span class="glyphicons show_thumbnails"><i></i></span>Portfolio<a href="#phone-navbar" class="top visible-phone"><span class="glyphicons white up_arrow"><i></i></span></a>
                </h2>

                <ul class="nav nav-pills" id="portfolio-filters">
                    <li class="active"><a href="#" data-filter="*">All</a></li>
                    <li><a href="#" data-filter=".portfolio-type1">Type 1</a></li>
                    <li><a href="#" data-filter=".portfolio-type2">Type 2</a></li>
                    <li><a href="#" data-filter=".portfolio-type3">Type 3</a></li>
                </ul>

                <!-- Featured Portfolio items -->
                <div class="row" id="portfolio-items">

                    <div class="span3 portfolioitem portfolio-type1">
                        <img src="./images/thumb01.jpg" alt="">
                        <div class="portfolioitem-hoverinfo">
                            <h3>Lorem ipsum</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                            <div class="portfolioitem-actions">
                                <a href="./images/01.jpg" class="tips img-circle lightbox" title="Preview image" data-placement="bottom" data-fancybox-group="portfolioimages"><span class="glyphicons white zoom_in"><i></i></span></a>
                                <a href="#portfolioitem-1" class="tips more-info img-circle" title="View Project" data-placement="bottom"><span class="glyphicons white share"><i></i></span></a>
                            </div>
                        </div>
                    </div>
                    <!--/portfolioitem-->

                    <div class="span3 portfolioitem portfolio-type2">
                        <img src="./images/thumb02.jpg" alt="">
                        <div class="portfolioitem-hoverinfo">
                            <h3>Cras gravida fringilla</h3>
                            <p>Donec eros magna, blandit eu tempus a, ornare quis nulla.</p>
                            <div class="portfolioitem-actions">
                                <a href="./images/02.jpg" class="tips img-circle lightbox" title="Preview image" data-placement="bottom" data-fancybox-group="portfolioimages"><span class="glyphicons white zoom_in"><i></i></span></a>
                                <a href="#portfolioitem-2" class="tips more-info img-circle" title="View Project" data-placement="bottom"><span class="glyphicons white share"><i></i></span></a>
                            </div>
                        </div>
                    </div>
                    <!--/portfolioitem-->

                    <div class="span3 portfolioitem portfolio-type3">
                        <img src="./images/thumb03.jpg" alt="">
                        <div class="portfolioitem-hoverinfo">
                            <h3>Nulla diam lacus</h3>
                            <p>Curabitur risus lacus, congue eget condimentum id, feugiat et nisl.</p>
                            <div class="portfolioitem-actions">
                                <a href="./images/03.jpg" class="tips img-circle lightbox" title="Preview image" data-placement="bottom" data-fancybox-group="portfolioimages"><span class="glyphicons white zoom_in"><i></i></span></a>
                                <a href="#portfolioitem-3" class="tips more-info img-circle" title="View Project" data-placement="bottom"><span class="glyphicons white share"><i></i></span></a>
                            </div>
                        </div>
                    </div>
                    <!--/portfolioitem-->

                    <div class="span3 portfolioitem portfolio-type1">
                        <img src="./images/thumb04.jpg" alt="">
                        <div class="portfolioitem-hoverinfo">
                            <h3>Proin quam lacus</h3>
                            <p>Proin quam lacus, dapibus non sodales ac, pharetra et urna.</p>
                            <div class="portfolioitem-actions">
                                <a href="./images/04.jpg" class="tips img-circle lightbox" title="Preview image" data-placement="bottom" data-fancybox-group="portfolioimages"><span class="glyphicons white zoom_in"><i></i></span></a>
                                <a href="#portfolioitem-4" class="tips more-info img-circle" title="View Project" data-placement="bottom"><span class="glyphicons white share"><i></i></span></a>
                            </div>
                        </div>
                    </div>
                    <!--/portfolioitem-->

                    <div class="span3 portfolioitem portfolio-type2">
                        <img src="./images/thumb05.jpg" alt="">
                        <div class="portfolioitem-hoverinfo">
                            <h3>Tellus ligula</h3>
                            <p>Cras vestibulum, mi aliquam molestie tincidunt, tellus ligula tempor neque. </p>
                            <div class="portfolioitem-actions">
                                <a href="./images/05.jpg" class="tips img-circle lightbox" title="Preview image" data-placement="bottom" data-fancybox-group="portfolioimages"><span class="glyphicons white zoom_in"><i></i></span></a>
                                <a href="#portfolioitem-5" class="tips more-info img-circle" title="View Project" data-placement="bottom"><span class="glyphicons white share"><i></i></span></a>
                            </div>
                        </div>
                    </div>
                    <!--/portfolioitem-->

                    <div class="span3 portfolioitem portfolio-type1">
                        <img src="./images/thumb07.jpg" alt="">
                        <div class="portfolioitem-hoverinfo">
                            <h3>In sed eleifend orci</h3>
                            <p>Morbi ultrices ullamcorper magna, quis placerat libero pretium at.</p>
                            <div class="portfolioitem-actions">
                                <a href="./images/07.jpg" class="tips img-circle lightbox" title="Preview image" data-placement="bottom" data-fancybox-group="portfolioimages"><span class="glyphicons white zoom_in"><i></i></span></a>
                                <a href="#portfolioitem-6" class="tips more-info img-circle" title="View Project" data-placement="bottom"><span class="glyphicons white share"><i></i></span></a>
                            </div>
                        </div>
                    </div>
                    <!--/portfolioitem-->


                </div>
                <!--/row-->
                <!-- /Featured Portfolio Items -->

                <div class="row" id="full-portfolio-items">
                    <div class="span9">

                        <a href="#" class="btn btn-primary hidden" id="portfolio-back">&larr; Back to Portfolio List</a>

                        <!-- This is a Portfolio item -->
                        <div class="portfolioitem-content hidden" id="portfolioitem-1">
                            <img src="./images/01.jpg" alt="">
                            <h2 class="primary-color">Lorem ipsum</h2>

                            <h3>Lectus tristique scelerisque</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tincidunt diam ac lectus tristique scelerisque. Quisque vitae libero sit amet turpis faucibus auctor eget vitae tortor. Aenean metus erat, ultricies non mattis quis, molestie ac massa. Sed sollicitudin erat ac dui viverra a posuere eros adipiscing. Phasellus nisi lectus, imperdiet sed hendrerit ac, dictum quis sem. Phasellus vel nisi non massa elementum porta. Aliquam erat volutpat.</p>


                            <ul class="pager">
                                <li class="previous"><a href="#portfolioitem-6" class="">&larr; Previous</a></li>
                                <li class="next"><a href="#portfolioitem-2" class="">Next &rarr;</a></li>
                            </ul>

                        </div>
                        <!-- /Portfolio item -->

                        <!-- This is a Portfolio item -->
                        <div class="portfolioitem-content hidden" id="portfolioitem-2">
                            <img src="./images/02.jpg" alt="">
                            <h2 class="primary-color">Cras gravida fringilla</h2>

                            <h3>Accumsan dolor ornare</h3>
                            <p>Vivamus gravida convallis est, non tristique nisl pellentesque ut. Praesent congue tortor vel quam scelerisque in suscipit elit malesuada. Nam volutpat ultricies augue, ac accumsan dolor ornare eu. Nam ut egestas nulla. Nunc ullamcorper, nulla vitae pellentesque dictum, diam ligula iaculis ipsum, aliquam vestibulum leo libero vel turpis. Nunc cursus dignissim sodales. </p>


                            <ul class="pager">
                                <li class="previous"><a href="#portfolioitem-1" class="">&larr; Previous</a></li>
                                <li class="next"><a href="#portfolioitem-3" class="">Next &rarr;</a></li>
                            </ul>

                        </div>
                        <!-- /Portfolio item -->

                        <!-- This is a Portfolio item -->
                        <div class="portfolioitem-content hidden" id="portfolioitem-3">
                            <img src="./images/03.jpg" alt="">
                            <h2 class="primary-color">Nulla diam lacus</h2>

                            <h3>Etiam sagittis, felis id </h3>
                            <p>Etiam eleifend sem ornare lacus ullamcorper interdum. Aenean nec justo nisl, vel cursus nulla. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellentesque, eros at vestibulum feugiat, ante urna cursus turpis, in rhoncus enim lorem ac nisl. Phasellus tristique ultricies metus, a condimentum lacus sagittis non. Phasellus euismod nulla eget lacus aliquam auctor. </p>
                            <p>Sed nisl sem, semper id sollicitudin vitae, pharetra at tellus. Ut eu sem vitae erat rhoncus posuere. Praesent hendrerit, nunc nec molestie bibendum, leo metus volutpat lacus, a luctus ante massa a lectus. Etiam sagittis, felis id dignissim pulvinar, purus lorem tempor lectus, et suscipit mauris lorem et elit. </p>


                            <ul class="pager">
                                <li class="previous"><a href="#portfolioitem-2" class="">&larr; Previous</a></li>
                                <li class="next"><a href="#portfolioitem-4" class="">Next &rarr;</a></li>
                            </ul>

                        </div>
                        <!-- /Portfolio item -->

                        <!-- This is a Portfolio item -->
                        <div class="portfolioitem-content hidden" id="portfolioitem-4">
                            <img src="./images/04.jpg" alt="">
                            <h2 class="primary-color">Proin quam lacus</h2>

                            <h3>Subtitle</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tincidunt diam ac lectus tristique scelerisque. Quisque vitae libero sit amet turpis faucibus auctor eget vitae tortor. Aenean metus erat, ultricies non mattis quis, molestie ac massa. Sed sollicitudin erat ac dui viverra a posuere eros adipiscing. Phasellus nisi lectus, imperdiet sed hendrerit ac, dictum quis sem. Phasellus vel nisi non massa elementum porta. Aliquam erat volutpat.</p>


                            <ul class="pager">
                                <li class="previous"><a href="#portfolioitem-3" class="">&larr; Previous</a></li>
                                <li class="next"><a href="#portfolioitem-5" class="">Next &rarr;</a></li>
                            </ul>

                        </div>
                        <!-- /Portfolio item -->

                        <!-- This is a Portfolio item -->
                        <div class="portfolioitem-content hidden" id="portfolioitem-5">
                            <img src="./images/05.jpg" alt="">
                            <h2 class="primary-color">Tellus ligula</h2>

                            <h3>ullam pharetra, metus id semper fringilla</h3>
                            <p>Praesent suscipit pellentesque est, non blandit ante feugiat in. Aliquam erat volutpat. Donec lorem sem, vestibulum ac vehicula in, tempus sit amet sem. Curabitur nec ante risus. Integer libero nunc, euismod in mattis ac, auctor in arcu. Nullam pharetra, metus id semper fringilla, est lorem euismod lectus, at dignissim elit turpis et dolor. Praesent adipiscing, metus eget lacinia viverra, dolor nibh consequat erat, a rutrum leo nulla non metus. </p>


                            <ul class="pager">
                                <li class="previous"><a href="#portfolioitem-4" class="">&larr; Previous</a></li>
                                <li class="next"><a href="#portfolioitem-6" class="">Next &rarr;</a></li>
                            </ul>

                        </div>
                        <!-- /Portfolio item -->

                        <!-- This is a Portfolio item -->
                        <div class="portfolioitem-content hidden" id="portfolioitem-6">
                            <img src="./images/07.jpg" alt="">
                            <h2 class="primary-color">In sed eleifend orci</h2>

                            <h3>Enim mauris rhoncus elit</h3>
                            <p>Phasellus condimentum pulvinar tincidunt. Phasellus vehicula, felis id auctor placerat, nunc magna feugiat nunc, vitae tempor metus lorem ac quam. In vel lacus nibh, a varius metus.</p>
                            <p>Suspendisse ut tortor ligula, id fringilla mi. Curabitur bibendum tortor tempus sem posuere vehicula accumsan mauris molestie. Etiam eget nulla vel sem tristique dapibus. In orci justo, pharetra vel scelerisque eu, gravida vel felis. Etiam mattis blandit rutrum. Maecenas viverra massa sed sem feugiat sed mollis dolor venenatis. In aliquet, sem et cursus scelerisque, enim mauris rhoncus elit, sit amet ornare massa metus non lectus. </p>


                            <ul class="pager">
                                <li class="previous"><a href="#portfolioitem-5" class="">&larr; Previous</a></li>
                                <li class="next"><a href="#portfolioitem-1" class="">Next &rarr;</a></li>
                            </ul>

                        </div>
                        <!-- /Portfolio item -->

                    </div>
                    <!--/span9-->

                </div>
                <!--/row-->


            </div>
            <!--/section-->
            <span class="clear"></span>

            <div class="section noprint" id="blog">
                <h2 class="section-title">
                    <span class="glyphicons pencil"><i></i></span>Blog<a href="#phone-navbar" class="top visible-phone"><span class="glyphicons white up_arrow"><i></i></span></a>
                </h2>

                <!-- Featured Blog items -->
                <div class="row" id="blog-items">
                    <div class="span3 blogitem">
                        <img src="./images/thumbblog01.jpg" alt="">
                        <h3>Lorem ipsum</h3>
                        <div class="blogitem-date">
                            <span class="month">JUN</span>
                            <span class="day">15</span>
                        </div>
                        <div class="blogitem-hoverinfo">
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                            <div class="blogitem-actions">
                                <a href="./images/blog01.jpg" class="tips img-circle lightbox" title="Preview image" data-placement="bottom" data-fancybox-group="blogimages"><span class="glyphicons white zoom_in"><i></i></span></a>
                                <a href="#blogitem-1" class="tips more-info img-circle" title="View Post" data-placement="bottom"><span class="glyphicons white share"><i></i></span></a>
                            </div>
                        </div>
                    </div>

                    <div class="span3 blogitem">
                        <img src="./images/thumbblog02.jpg" alt="">
                        <h3>Cras gravida fringilla</h3>
                        <div class="blogitem-date">
                            <span class="month">MAY</span>
                            <span class="day">16</span>
                        </div>
                        <div class="blogitem-hoverinfo">
                            <p>Praesent congue tortor vel quam scelerisque in suscipit elit malesuada. </p>
                            <div class="blogitem-actions">
                                <a href="./images/blog02.jpg" class="tips img-circle lightbox" title="Preview image" data-placement="bottom" data-fancybox-group="blogimages"><span class="glyphicons white zoom_in"><i></i></span></a>
                                <a href="#blogitem-2" class="tips more-info img-circle" title="View Post" data-placement="bottom"><span class="glyphicons white share"><i></i></span></a>
                            </div>
                        </div>
                    </div>

                    <div class="span3 blogitem">
                        <img src="./images/thumbblog03.jpg" alt="">
                        <h3>Nulla diam lacus</h3>
                        <div class="blogitem-date">
                            <span class="month">APR</span>
                            <span class="day">22</span>
                        </div>
                        <div class="blogitem-hoverinfo">
                            <p>Etiam eleifend sem ornare lacus ullamcorper interdum.</p>
                            <div class="blogitem-actions">
                                <a href="./images/blog03.jpg" class="tips img-circle lightbox" title="Preview image" data-placement="bottom" data-fancybox-group="blogimages"><span class="glyphicons white zoom_in"><i></i></span></a>
                                <a href="#blogitem-3" class="tips more-info img-circle" title="View Post" data-placement="bottom"><span class="glyphicons white share"><i></i></span></a>
                            </div>
                        </div>
                    </div>

                    <div class="span3 blogitem">
                        <img src="./images/thumbblog04.jpg" alt="">
                        <h3>Proin quam lacus</h3>
                        <div class="blogitem-date">
                            <span class="month">MAR</span>
                            <span class="day">27</span>
                        </div>
                        <div class="blogitem-hoverinfo">
                            <p>Proin tincidunt diam ac lectus tristique scelerisque.</p>
                            <div class="blogitem-actions">
                                <a href="./images/blog04.jpg" class="tips img-circle lightbox" title="Preview image" data-placement="bottom" data-fancybox-group="blogimages"><span class="glyphicons white zoom_in"><i></i></span></a>
                                <a href="#blogitem-4" class="tips more-info img-circle" title="View Post" data-placement="bottom"><span class="glyphicons white share"><i></i></span></a>
                            </div>
                        </div>
                    </div>

                    <div class="span3 blogitem">
                        <img src="./images/thumbblog05.jpg" alt="">
                        <h3>Tellus ligula</h3>
                        <div class="blogitem-date">
                            <span class="month">FEB</span>
                            <span class="day">13</span>
                        </div>
                        <div class="blogitem-hoverinfo">
                            <p>Praesent adipiscing, metus eget lacinia viverra, dolor nibh consequat erat, a rutrum leo nulla non metus. </p>
                            <div class="blogitem-actions">
                                <a href="./images/blog05.jpg" class="tips img-circle lightbox" title="Preview image" data-placement="bottom" data-fancybox-group="blogimages"><span class="glyphicons white zoom_in"><i></i></span></a>
                                <a href="#blogitem-5" class="tips more-info img-circle" title="View Post" data-placement="bottom"><span class="glyphicons white share"><i></i></span></a>
                            </div>
                        </div>
                    </div>

                    <div class="span3 blogitem">
                        <img src="./images/thumbblog06.jpg" alt="">
                        <h3>In sed eleifend orci</h3>
                        <div class="blogitem-date">
                            <span class="month">JAN</span>
                            <span class="day">02</span>
                        </div>
                        <div class="blogitem-hoverinfo">
                            <p>Curabitur bibendum tortor tempus sem posuere vehicula accumsan mauris molestie.</p>
                            <div class="blogitem-actions">
                                <a href="./images/blog06.jpg" class="tips img-circle lightbox" title="Preview image" data-placement="bottom" data-fancybox-group="blogimages"><span class="glyphicons white zoom_in"><i></i></span></a>
                                <a href="#blogitem-6" class="tips more-info img-circle" title="View Post" data-placement="bottom"><span class="glyphicons white share"><i></i></span></a>
                            </div>
                        </div>
                    </div>


                </div>
                <!--/row-->
                <!-- /Featured Blog items -->

                <div class="row" id="full-blog-items">
                    <div class="span9">

                        <a href="#" class="btn btn-primary hidden" id="blog-back">&larr; Back to Blog List</a>

                        <!-- This is a blog item -->
                        <div class="blogitem-content hidden" id="blogitem-1">
                            <img src="./images/blog01.jpg" alt="">
                            <h2 class="primary-color">Lorem ipsum</h2>
                            <div class="blogmeta muted">
                                <div><span class="glyphicons user"><i></i></span>Mike Smith</div>
                                <div><span class="glyphicons calendar"><i></i></span>June 15, 2012</div>
                                <div><span class="glyphicons inbox"><i></i></span>Category</div>
                                <div><span class="glyphicons tags"><i></i></span>Lorem, Ipsum, Dolor, Sit amet</div>
                            </div>
                            <h3>Lorem ipsum</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tincidunt diam ac lectus tristique scelerisque. Quisque vitae libero sit amet turpis faucibus auctor eget vitae tortor. Aenean metus erat, ultricies non mattis quis, molestie ac massa. Sed sollicitudin erat ac dui viverra a posuere eros adipiscing. Phasellus nisi lectus, imperdiet sed hendrerit ac, dictum quis sem. Phasellus vel nisi non massa elementum porta. Aliquam erat volutpat.</p>


                            <ul class="pager">
                                <li class="previous"><a href="#blogitem-6" class="">&larr; Previous</a></li>
                                <li class="next"><a href="#blogitem-2" class="">Next &rarr;</a></li>
                            </ul>

                        </div>
                        <!-- / Blog item -->

                        <!-- This is a blog item -->
                        <div class="blogitem-content hidden" id="blogitem-2">
                            <img src="./images/blog02.jpg" alt="">
                            <h2 class="primary-color">Cras gravida fringilla</h2>
                            <div class="blogmeta muted">
                                <div><span class="glyphicons user"><i></i></span>Mike Smith</div>
                                <div><span class="glyphicons calendar"><i></i></span>May 16, 2012</div>
                                <div><span class="glyphicons inbox"><i></i></span>Category</div>
                                <div><span class="glyphicons tags"><i></i></span>Lorem, Ipsum, Dolor, Sit amet</div>
                            </div>
                            <h3>Accumsan dolor ornare</h3>
                            <p>Vivamus gravida convallis est, non tristique nisl pellentesque ut. Praesent congue tortor vel quam scelerisque in suscipit elit malesuada. Nam volutpat ultricies augue, ac accumsan dolor ornare eu. Nam ut egestas nulla. Nunc ullamcorper, nulla vitae pellentesque dictum, diam ligula iaculis ipsum, aliquam vestibulum leo libero vel turpis. Nunc cursus dignissim sodales. </p>


                            <ul class="pager">
                                <li class="previous"><a href="#blogitem-1" class="">&larr; Previous</a></li>
                                <li class="next"><a href="#blogitem-3" class="">Next &rarr;</a></li>
                            </ul>

                        </div>
                        <!-- / Blog item -->

                        <!-- This is a blog item -->
                        <div class="blogitem-content hidden" id="blogitem-3">
                            <img src="./images/blog03.jpg" alt="">
                            <h2 class="primary-color">Nulla diam lacus</h2>
                            <div class="blogmeta muted">
                                <div><span class="glyphicons user"><i></i></span>Mike Smith</div>
                                <div><span class="glyphicons calendar"><i></i></span>April 22, 2012</div>
                                <div><span class="glyphicons inbox"><i></i></span>Category</div>
                                <div><span class="glyphicons tags"><i></i></span>Lorem, Ipsum, Dolor, Sit amet</div>
                            </div>
                            <h3>Etiam sagittis, felis id </h3>
                            <p>Etiam eleifend sem ornare lacus ullamcorper interdum. Aenean nec justo nisl, vel cursus nulla. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellentesque, eros at vestibulum feugiat, ante urna cursus turpis, in rhoncus enim lorem ac nisl. Phasellus tristique ultricies metus, a condimentum lacus sagittis non. Phasellus euismod nulla eget lacus aliquam auctor.</p>
                            <p>Sed nisl sem, semper id sollicitudin vitae, pharetra at tellus. Ut eu sem vitae erat rhoncus posuere. Praesent hendrerit, nunc nec molestie bibendum, leo metus volutpat lacus, a luctus ante massa a lectus. Etiam sagittis, felis id dignissim pulvinar, purus lorem tempor lectus, et suscipit mauris lorem et elit. </p>


                            <ul class="pager">
                                <li class="previous"><a href="#blogitem-2" class="">&larr; Previous</a></li>
                                <li class="next"><a href="#blogitem-4" class="">Next &rarr;</a></li>
                            </ul>

                        </div>
                        <!-- / Blog item -->

                        <!-- This is a blog item -->
                        <div class="blogitem-content hidden" id="blogitem-4">
                            <img src="./images/blog04.jpg" alt="">
                            <h2 class="primary-color">Proin quam lacus</h2>
                            <div class="blogmeta muted">
                                <div><span class="glyphicons user"><i></i></span>Mike Smith</div>
                                <div><span class="glyphicons calendar"><i></i></span>March 27, 2012</div>
                                <div><span class="glyphicons inbox"><i></i></span>Category</div>
                                <div><span class="glyphicons tags"><i></i></span>Lorem, Ipsum, Dolor, Sit amet</div>
                            </div>
                            <h3>Proin tincidunt diam ac lectus tristique scelerisque</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tincidunt diam ac lectus tristique scelerisque. Quisque vitae libero sit amet turpis faucibus auctor eget vitae tortor. Aenean metus erat, ultricies non mattis quis, molestie ac massa. Sed sollicitudin erat ac dui viverra a posuere eros adipiscing. Phasellus nisi lectus, imperdiet sed hendrerit ac, dictum quis sem. Phasellus vel nisi non massa elementum porta. Aliquam erat volutpat.</p>


                            <ul class="pager">
                                <li class="previous"><a href="#blogitem-3" class="">&larr; Anterior</a></li>
                                <li class="next"><a href="#blogitem-5" class="">Siguiente &rarr;</a></li>
                            </ul>

                        </div>
                        <!-- / Blog item -->

                        <!-- This is a blog item -->
                        <div class="blogitem-content hidden" id="blogitem-5">
                            <img src="./images/blog05.jpg" alt="">
                            <h2 class="primary-color">In sed eleifend orci</h2>
                            <div class="blogmeta muted">
                                <div><span class="glyphicons user"><i></i></span>Mike Smith</div>
                                <div><span class="glyphicons calendar"><i></i></span>February 13, 2012</div>
                                <div><span class="glyphicons inbox"><i></i></span>Category</div>
                                <div><span class="glyphicons tags"><i></i></span>Lorem, Ipsum, Dolor, Sit amet</div>
                            </div>
                            <h3>Enim mauris rhoncus elit</h3>
                            <p>Phasellus condimentum pulvinar tincidunt. Phasellus vehicula, felis id auctor placerat, nunc magna feugiat nunc, vitae tempor metus lorem ac quam. In vel lacus nibh, a varius metus.</p>
                            <p>Suspendisse ut tortor ligula, id fringilla mi. Curabitur bibendum tortor tempus sem posuere vehicula accumsan mauris molestie. Etiam eget nulla vel sem tristique dapibus. In orci justo, pharetra vel scelerisque eu, gravida vel felis. Etiam mattis blandit rutrum. Maecenas viverra massa sed sem feugiat sed mollis dolor venenatis. In aliquet, sem et cursus scelerisque, enim mauris rhoncus elit, sit amet ornare massa metus non lectus. </p>


                            <ul class="pager">
                                <li class="previous"><a href="#blogitem-4" class="">&larr; Anterior</a></li>
                                <li class="next"><a href="#blogitem-6" class="">Siguiente &rarr;</a></li>
                            </ul>

                        </div>
                        <!-- / Blog item -->

                        <!-- This is a blog item -->
                        <div class="blogitem-content hidden" id="blogitem-6">
                            <img src="./images/blog06.jpg" alt="">
                            <h2 class="primary-color">In sed eleifend orci</h2>
                            <div class="blogmeta muted">
                                <div><span class="glyphicons user"><i></i></span>Mike Smith</div>
                                <div><span class="glyphicons calendar"><i></i></span>January 2nd, 2012</div>
                                <div><span class="glyphicons inbox"><i></i></span>Category</div>
                                <div><span class="glyphicons tags"><i></i></span>Lorem, Ipsum, Dolor, Sit amet</div>
                            </div>
                            <h3>Consectetur adipiscing elit</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tincidunt diam ac lectus tristique scelerisque. Quisque vitae libero sit amet turpis faucibus auctor eget vitae tortor. Aenean metus erat, ultricies non mattis quis, molestie ac massa. Sed sollicitudin erat ac dui viverra a posuere eros adipiscing. Phasellus nisi lectus, imperdiet sed hendrerit ac, dictum quis sem. Phasellus vel nisi non massa elementum porta. Aliquam erat volutpat.</p>


                            <ul class="pager">
                                <li class="previous"><a href="#blogitem-5" class="">&larr; Anterior</a></li>
                                <li class="next"><a href="#blogitem-1" class="">Siguiente &rarr;</a></li>
                            </ul>

                        </div>
                        <!-- / Blog item -->

                    </div>
                    <!--/span9-->
                </div>
                <!--/row-->

            </div>
            <!--/section-->
            <span class="clear"></span>


            <div class="section noprint" id="contact">
                <h2 class="section-title">
                    <span class="glyphicons message_flag"><i></i></span>Contacto<a href="#phone-navbar" class="top visible-phone"><span class="glyphicons white up_arrow"><i></i></span></a>
                </h2>

                <?php

                $name = $email = $subject = $message = '';

                if (isset($_POST['submit'])) {

                    // PHP form validation
                    $errormessage = '';

                    $name = trim($_POST['name']);
                    if ($name == '') {
                        $hasError = true;
                        $errormessage .= '<p>- El campo <strong>Nombre</strong> está vacío.</p>';
                    }

                    $email = trim($_POST['email']);
                    if ($email == '') {
                        $hasError = true;
                        $errormessage .= '<p>- El campo <strong>Correo</strong> está vacío.</p>';
                    } else if (!eregi("^[A-Z0-9._%-]+@[A-Z0-9._%-]+\.[A-Z]{2,4}$", $email)) {
                        $hasError = true;
                        $errormessage .= '<p>- El campo <strong>Correo</strong> no es una dirección de correo válida.</p>';
                    }

                    $subject = trim($_POST['subject']);
                    if ($subject == '') {
                        $hasError = true;
                        $errormessage .= '<p>- El campo <strong>Asunto</strong> está vacío.</p>';
                    }

                    if (function_exists('stripslashes')) {
                        $message = stripslashes(trim($_POST['message']));
                    } else {
                        $message = trim($_POST['message']);
                    }
                    if ($message == '') {
                        $hasError = true;
                        $errormessage .= '<p>- El campo <strong>Mensaje</strong> está vacío.</p>';
                    }

                    // PHP email
                    $emailTo = 'arthurolg@gmail.com'; //Put your own email address here
                    $websitename = "arthurolg.com"; //Put your website name here

                    if (!isset($hasError)) {

                        $body = "Nombre: $name \n\nCorreo: $email \n\nAsunto: $subject \n\nMensaje:\n $message";
                        $headers = 'Desde: ' . $websitename . ' <' . $emailTo . '>' . "\r\n" . 'Responder A: ' . $email;

                        mail($emailTo, $subject, $body, $headers);
                        $emailSent = true;
                    }
                } else { ?>

                    <div class="alert alert-info">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        Favor de llenar todos los campos de manera correcta antes de dar clic en el boton enviar!
                    </div>

                <?php } ?>

                <?php
                // if errors
                if (isset($hasError)) { ?>
                    <div class="alert alert-error">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <h4>Favor de corregir los siguiente(s) error(es):</h4><br />
                        <?php echo $errormessage; ?>
                    </div>
                <?php } ?>

                <?php
                // if email is sent
                if (isset($emailSent) && $emailSent == true) { ?>
                    <div class="alert alert-success">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <h4>Correo enviado exitosamente!</h4><br />
                        <p>Gracias por establecer contacto <strong><?php echo $name; ?></strong></p>
                        <p>A la brevedad posible atendere tu solicitud.</p>
                    </div>
                    <?php
                    $name = $email = $subject = $message = ''; //reset values to clear fields
                } ?>

                <form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>#contact" class="form-horizontal">
                    <fieldset>
                        <legend>Envia un mensaje usando el formulario de abajo.</legend>

                        <div class="control-group">
                            <label class="control-label" for="form-name">Nombre</label>
                            <div class="controls">
                                <div class="input-append">
                                    <input type="text" placeholder="Your name" id="form-name" name="name" class="input-xlarge" value="<?php echo $name; ?>">
                                    <span class="add-on"><span class="glyphicons user"><i></i></span></span>
                                </div>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="form-email">Correo</label>
                            <div class="controls">
                                <div class="input-append">
                                    <input type="text" placeholder="Your email" id="form-email" name="email" class="input-xlarge" value="<?php echo $email; ?>">
                                    <span class="add-on">@</span>
                                </div>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="form-subject">Asunto</label>
                            <div class="controls">
                                <div class="input-append">
                                    <input type="text" placeholder="Email Subject" id="form-subject" name="subject" class="input-xlarge" value="<?php echo $subject; ?>">
                                    <span class="add-on"><span class="glyphicons circle_question_mark"><i></i></span></span>
                                </div>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="form-message">Mensaje</label>
                            <div class="controls">
                                <div class="input-append">
                                    <textarea rows="6" placeholder="Your message" id="form-message" name="message" class="input-xlarge"><?php echo $message; ?></textarea>
                                    <span class="add-on"><span class="glyphicons pen"><i></i></span></span>
                                </div>
                            </div>
                        </div>

                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn btn-primary input-medium" name="submit">Enviar</button>
                            </div>
                        </div>


                    </fieldset>
                </form>
            </div>
            <!--/section-->


        </div>
        <!--/span9-->
        <!-- END OF THE MAIN CONTENT -->

        <!-- Sidebar placed on the RIGHT of the screen -->
        <div class="span3 sbright noprint" id="sidebar">
            <div class="sidebar-nav equal hidden-phone">
                <ul class="nav nav-list affix" id="resumenav">
                    <li><a href="#about-me" class="scroller">Sobre mi</a></li>
                    <li><a href="#personal-information" class="scroller">Información Personal</a></li>
                    <li><a href="#employment" class="scroller">Experiencia</a></li>
                    <li><a href="#education" class="scroller">Educación</a></li>
                    <li><a href="#skills" class="scroller">Conocimientos</a></li>
                    <li><a href="#hobbies" class="scroller">Aficiones</a></li>
                    <li><a href="#portfolio" class="scroller">Portafolio</a></li>
                    <li><a href="#blog" class="scroller">Blog</a></li>
                    <li><a href="#contact" class="scroller">Contacto</a></li>
                </ul>
            </div>
            <!--/sidebar-nav -->
            <span class="clear"></span>
        </div>
        <!--/span3 -->


    </div>
    <!--/row-->

    <div id="footer">
        <p>&copy; Arturo López</p>
    </div>

</div>
<!--/.container-->

</body>

</html>

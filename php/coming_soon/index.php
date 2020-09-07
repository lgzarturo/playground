<!DOCTYPE html>
<!--[if IE 9]>
<html class="lt-ie10" lang="en"> <![endif]-->
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Próximamente</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/foundation.css">
    <link rel="stylesheet" type="text/css" href="css/jquery.realperson.css">
    <link rel="stylesheet" href="tools/style.css">
    <script src="js/modernizr.js"></script>
</head>

<body>
<div id="top-element">
    <div class="row">
        <div class="large-12 columns">
            <div class="logo">
                <h1>WEB</h1>
                <span><?php echo $_SERVER['HTTP_HOST'] ?></span>
            </div>

            <h2>
                PRÓXIMAMENTE<br />
                <span>Este sitio web está en desarrollo.</span>
            </h2>
        </div>
    </div>

    <div id="social" class="row">
        <div class="large-12 columns">
            <ul class="social" id="jquery">
                <li class="github">
                    <a href="https://github.com/lgzarturo" target="_blank">
                        <strong>GitHub</strong>
                    </a>
                </li>
                <li class="linkedin">
                    <a href="https://www.linkedin.com/in/lgzarturo" target="_blank">
                        <strong>LinkedIn</strong>
                    </a>
                </li>
                <li class="facebook">
                    <a href="https://www.facebook.com/lgzarturo" target="_blank">
                        <strong>Facebook</strong>
                    </a>
                </li>
                <li class="twitter">
                    <a href="http://twitter.com/lgzarturo" target="_blank">
                        <strong>Twitter</strong>
                    </a>
                </li>
                <!-- More services -->
            </ul>
        </div>
    </div>

    <div id="tweets" class="row">
        <div class="large-12 columns">
            <div id="tweets"></div>
        </div>
    </div>

    <div class="row">

        <?php
        function rpHash($value)
        {
            $hash = 5381;
            $value = strtoupper($value);
            for ($i = 0; $i < strlen($value); $i++) {
                $hash = (($hash << 5) + $hash) + ord(substr($value, $i));
            }
            return $hash;
        }

        function rpHash64($value)
        {
            $hash = 5381;
            $value = strtoupper($value);
            for ($i = 0; $i < strlen($value); $i++) {
                $hash = (leftShift32($hash, 5) + $hash) + ord(substr($value, $i));
            }
            return $hash;
        }

        // Perform a 32bit left shift
        function leftShift32($number, $steps)
        {
            // convert to binary (string)
            $binary = decbin($number);
            // left-pad with 0's if necessary
            $binary = str_pad($binary, 32, "0", STR_PAD_LEFT);
            // left shift manually
            $binary = $binary . str_repeat("0", $steps);
            // get the last 32 bits
            $binary = substr($binary, strlen($binary) - 32);
            // if it's a positive number return it
            // otherwise return the second complement
            return ($binary{
            0} == "0" ? bindec($binary) : -(pow(2, 31) - bindec(substr($binary, 1))));
        }

        ?>

        <?php
        $captcha = $name = $email = $subject = $message = '';

        if (isset($_POST['submit'])) {

            $name = trim($_POST['name']);
            $email = trim($_POST['email']);
            $subject = trim($_POST['subject']);
            if (function_exists('stripslashes')) {
                $message = stripslashes(trim($_POST['message']));
            } else {
                $message = trim($_POST['message']);
            }

            // PHP form validation
            $errormessage = '';

            if ($name == '') {
                $hasError = true;
                $errormessage .= '<p>- El campo <strong>Nombre</strong> está vacío.</p>';
            }

            if ($email == '') {
                $hasError = true;
                $errormessage .= '<p>- El campo <strong>Correo</strong> está vacío.</p>';
            } else if (!preg_match("/^[_.0-9a-zA-Z-]+@([0-9a-zA-Z][0-9a-zA-Z-]+\.)+[a-zA-Z]{2,6}$/i", $email)) {
                $hasError = true;
                $errormessage .= '<p>- El campo <strong>Correo</strong> no es una dirección de válida.</p>';
            }

            if ($subject == '') {
                $hasError = true;
                $errormessage .= '<p>- El campo <strong>Asunto</strong> está vacío.</p>';
            }

            if ($message == '') {
                $hasError = true;
                $errormessage .= '<p>- El campo <strong>Mensaje</strong> está vacío.</p>';
            }

            if (rpHash64($_POST['defaultReal']) != $_POST['defaultRealHash']) {
                $hasError = true;
                $captcha = "El código de captcha es incorrecto";
                echo rpHash($_POST['defaultReal']);
            }

            if (!isset($hasError)) {
                include("phpmailer/class.phpmailer.php");
                include("phpmailer/class.smtp.php");
                $actual_link = (isset($_SERVER['HTTPS']) && $_SERVER['HTTPS'] === 'on' ? "https" : "http") . "://$_SERVER[HTTP_HOST]$_SERVER[REQUEST_URI]";
                $email_sent = "{GMAIL_ACCOUNT}";


                $body = "Nombre: $name \n\nCorreo: $email \n\nAsunto: $subject \n\nMensaje:\n $message \n\nEnviado desde el formulario de contacto de $actual_link";

				try {
					$mail = new PHPMailer();
					$mail->IsSMTP();
					//$mail->SMTPDebug = 1;
					$mail->SMTPAuth = true;
					$mail->CharSet = "UTF-8";
					$mail->SMTPSecure = "ssl";
					$mail->Host = "smtp.gmail.com";
					$mail->Port = 465;
					$mail->Username = $email_sent;
					$mail->Password = "{GMAIL_PASSWORD}";
					$mail->Priority = 1;
					$mail->Subject = $subject;
					$mail->AltBody = $body;
					$mail->MsgHTML(str_replace("\n", "<br />", $body));
					$mail->AddAddress($email_sent, "{ACCOUNT_EMAIL}");
					$mail->SetFrom($email, $name);
					$mail->AddReplyTo($email, $name);
					$mail->WordWrap = 80;
					$mail->IsHTML(true);
					$emailSent = $mail->Send();

					if (!$emailSent) {
						$mail_error = "Error: No se pudo efectuar el envío, intente más tarde.";
						//echo $mail->ErrorInfo;
					}
				} catch (phpmailerException $e) {
					$mail_error = "Error: No se pudo efectuar el envío, intente más tarde.";
				}
            }
        }
        ?>

        <div class="large-12 medium-12 columns">
            <div class="panel" id="contact">
                <h5>
                    Contacto&nbsp;
                    <span><?php echo $captcha; ?></span>
                </h5>
                <hr />
                <form id="contact-action" method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>#contact">

                    <?php
                    // if email is sent
                    if (isset($emailSent) && $emailSent == true) { ?>
                        <div class="row">
                            <div class="large-12 columns">
                                <div class="callout panel" id="success">
                                    <h6>Correo enviado!</h6>
                                    <p><strong><?php echo $name; ?></strong>, Gracias por enviar su información</p>
                                    <p>A la brevedad posible atenderé su solicitud.</p>
                                </div>
                            </div>
                        </div>
                        <?php
                        $name = $email = $subject = $message = ''; //reset values to clear fields
                    } ?>

                    <?php
                    if (isset($mail_error) && $mail_error != '') { ?>
                        <div class="row">
                            <div class="large-12 columns">
                                <div class="callout panel" id="error">
                                    <h6>Error en el envío!</h6>
                                    <p><?php echo $mail_error; ?></p>
                                </div>
                            </div>
                        </div>
                    <?php } ?>

                    <?php if (isset($errormessage) && $errormessage != '') { ?>
                        <div class="row">
                            <div class="large-12 columns">
                                <div class="callout panel" id="errors">
                                    <h6>Error en los siguientes campos:</h6>
                                    <?php echo $errormessage; ?>
                                </div>
                            </div>
                        </div>
                    <?php } ?>

                    <div class="row">
                        <div class="large-12 columns">
                            <label for="name">Nombre <strong>*</strong></label>
                            <input name="name" id="name" type="text" placeholder="Con quien tengo el gusto" value="<?php echo $name; ?>" />
                        </div>
                    </div>

                    <div class="row">
                        <div class="large-12 columns">
                            <label for="email">Correo Electrónico <strong>*</strong></label>
                            <input name="email" id="email" type="text" placeholder="Como te contacto" value="<?php echo $email; ?>" />
                        </div>
                    </div>

                    <div class="row">
                        <div class="large-12 columns">
                            <label for="subject">Asunto <strong>*</strong></label>
                            <input name="subject" id="subject" type="text" placeholder="De que tema hablaremos" value="<?php echo $subject; ?>" />
                        </div>
                    </div>

                    <div class="row">
                        <div class="large-12 columns">
                            <label for="message">Mensaje <strong>*</strong></label>
                            <textarea name="message" id="message" placeholder="Explica tu idea"><?php echo $message; ?></textarea>
                        </div>
                    </div>

                    <div class="row">
                        <div class="large-10 columns">
                            <label for="defaultReal">Captcha <strong>*</strong></label>
                            <div class="small-3 columns">
                                <div id="captcha-content"></div>
                            </div>
                            <div class="small-9 columns" id="resolution">
                                <input type="text" id="defaultReal" name="defaultReal" placeholder="Resuelve el captcha" />
                            </div>
                        </div>
                        <div class="large-2 columns" style="text-align: right; padding-top: 18px;">
                            <input type="submit" name="submit" value="Enviar" class="small button no-margin" />
                        </div>
                    </div>
                </form>
            </div>

            <hr />

            <p>
                &copy; <?php echo date("Y") ?>
                <a href="mailto:arthurolg@gmail.com">Arturo López</a>,
                Cancún, México. Todos los derechos reservados.
            </p>
        </div>
    </div>

    <!-- libraries -->
    <script src="tools/jquery-3.5.1.min.js"></script>
    <script src="js/foundation.min.js"></script>
    <!--[if IE]>
    <script src="js/script.js"></script><![endif]-->
    <script>
        $(document).foundation();
    </script>

    <script src="js/tweetable.jquery.min.js"></script>
    <script src="js/jquery.timeago.js"></script>
    <script src="js/jquery.realperson.min.js"></script>
    <script type="text/javascript">
        jQuery(function () {
            jQuery('#tweets').tweetable({
                username: '{TWEET_ACCOUNT}',
                time: true,
                rotate: false,
                speed: 4000,
                limit: 5,
                replies: false,
                position: 'append',
                failed: "Por el momento no se pudo establecer conexión con Twitter.",
                loading: "...",
                html5: true,
                onComplete: function () {
                    $('time').timeago();
                }
            });

            $("label").click(function () {
                const target = $(this).attr('for');
                $(`#${target}`).focus();
            });

            $("#captcha-content").realperson({
                length: 6,
                includeNumbers: false,
                regenerate: 'Cambiar',
                hashName: 'defaultRealHash'
            });
        });
    </script>
</div>
</body>

</html>

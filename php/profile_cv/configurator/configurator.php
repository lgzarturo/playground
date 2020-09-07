<link type="text/css" rel="stylesheet" href="./configurator/css/configurator.css">
<link type="text/css" rel="stylesheet" href="./configurator/css/colorpicker.css">
<link type="text/css" rel="stylesheet" href="./configurator/css/reveal.css">

<script src="./configurator/js/configurator.js"></script>
<script type="text/javascript" src="./configurator/js/colorpicker.js"></script>
<script type="text/javascript" src="./configurator/js/eye.js"></script>
<script type="text/javascript" src="./configurator/js/utils.js"></script>
<script type="text/javascript" src="./configurator/js/layout.js?ver=1.0.2"></script>
<script type="text/javascript" src="./configurator/js/jquery.reveal.js"></script>

<div id="exportModal" class="reveal-modal">
    <h2>Skin Export</h2>
    <p>Copy and paste the code above in the <strong>skin.less</strong> file which you can find in the
        <strong>css</strong> folder. Replace the Skin Parameters.</p>
    <textarea>expore xportMod alexpo tModalexpo rtModal</textarea>
    <h4>Dark Skin</h4>
    <p>If you selected <strong>Dark</strong> skin, don't forget to add the <strong>dark</strong> class to the
        <strong>&lt;body&gt;</strong> element in the <strong>index.php</strong> file.</p>
    <h4>nav Position Navigation</h4>
    <p>If you selected <strong>Right</strong> navigation, add the <strong>sbright</strong> class to the
        <strong>&lt;div&gt;</strong> element with id <strong>#sidebar</strong> in the <strong>index.php</strong> file.
    </p>
    <p>If you selected <strong>Left</strong> navigation, add the <strong>sbleft</strong> class to the
        <strong>&lt;div&gt;</strong> element with id <strong>#sidebar</strong> in the <strong>index.php</strong> file.
    </p>
    <p>/!\ don't forget invert <strong>#sidebar</strong> &
        <strong>#main-content</strong> position!(read doc for more info).</p>
    <a class="close-reveal-modal">&#215;</a>
</div>


<div id="configurator" class="noprint">
    <div class="trigger openme"><span class="glyphicons white adjust_alt"><i></i></span></div>
    <h3>Skin config</h3>
    <div class="options">

        <p>
            <label for="starter">Starter Skins</label>
            <select class="skinselect" id="starter">
                <option value="pastel" selected>Pastel (light)</option>
                <option value="soft">Soft (light)</option>
                <option value="acid">Acid (dark)</option>
                <option value="bootstrap_original">Bootstrap Original</option>
                <option value="bootstrap_dark">Bootstrap Dark</option>
            </select>
            <label for="colorscheme">Color Scheme</label>
            <select class="skinselect" id="colorscheme">
                <option value="light" selected>Light</option>
                <option value="dark">Dark</option>
            </select>
            <label for="navposition">Nav position</label>
            <select class="skinselect" id="navposition">
                <option value="left" selected>Left</option>
                <option value="right">Right</option>
            </select>
            <label for="font">Font</label>
            <select class="skinselect" id="font">
                <option value="'Open Sans', sans-serif" selected>Open Sans</option>
                <option value="'Oswald', sans-serif">Oswald</option>
                <option value="'Droid Sans', sans-serif">Droid Sans</option>
                <option value="'Yanone Kaffeesatz', sans-serif">Yanone Kaffeesatz</option>
                <option value="'Droid Serif', serif">Droid Serif</option>
                <option value="'Ubuntu', sans-serif">Ubuntu</option>
                <option value="'Lobster', cursive">Lobster</option>
                <option value="'Francois One', sans-serif">Francois One</option>
                <option value="'Arvo', serif">Arvo</option>
                <option value="'Changa One', cursive">Changa One</option>
                <option value="'Rokkitt', serif">Rokkitt</option>
                <option value="'Nunito', sans-serif">Nunito</option>
                <option value="'Bitter', serif">Bitter</option>
                <option value="'Merriweather', serif">Merriweather</option>
                <option value="'Raleway', sans-serif">Raleway</option>
                <option value="'Pacifico', cursive">Pacifico</option>
                <option value="'Josefin Sans', sans-serif">Josefin Sans</option>
                <option value="'Questrial', sans-serif">Questrial</option>
                <option value="'Cantarell', sans-serif">Cantarell</option>
                <option value="'Norican', cursive">Norican</option>
                <option value="'Vollkorn', serif">Vollkorn</option>
                <option value="'Quicksand', sans-serif">Quicksand</option>
                <option value="'Limelight', cursive">Limelight</option>
                <option value="'Cantata One', serif">Cantata One</option>
                <option value="'Bree Serif', serif">Bree Serif</option>
                <option value="'Oleo Script', cursive">Oleo Script</option>
                <option value="'Playfair Display', serif">Playfair Display</option>
                <option value="'Quattrocento Sans', sans-serif">Quattrocento Sans</option>
                <option value="'Berkshire Swash', cursive">Berkshire Swash</option>
                <option value="'Passion One', cursive">assion One</option>
                <option value="'Cuprum', sans-serif">Cuprum</option>
            </select>
            <label for="bgimage">Background image</label>
            <select class="skinselect" id="bgimage">
                <option value="../images/textures/none.png" selected>None</option>
                <option value="../images/textures/wood_pattern.png">Wood</option>
                <?php
                $lighttextures = array(
                    'batthern',
                    'candyhole',
                    'checkered_pattern',
                    'connect',
                    'fabric_plaid',
                    'foggy_birds',
                    'foil',
                    'graphy',
                    'gridme',
                    'grilled',
                    'groovepaper',
                    'knitted-netting',
                    'light_grey_floral_motif',
                    'lined_paper',
                    'merely_cubed',
                    'old_wall',
                    'pineapplecut',
                    'plaid',
                    'polonez_car',
                    'ravenna',
                    'ricepaper',
                    'ricepaper2',
                    'small-crackle-bright',
                    'soft_pad',
                    'struckaxiom',
                    'texturetastic_gray',
                    'white_brick_wall',
                    'white_paperboard',
                    'white_plaster',
                    'whitediamond',
                    '45degreee_fabric',
                    '60degree_gray',
                    'beige_paper',
                    'bright_squares',
                    'brushed_alu',
                    'concrete_wall_2',
                    'concrete_wall_3',
                    'cork_1',
                    'double_lined',
                    'exclusive_paper',
                    'fabric_1',
                    'green_gobbler',
                    'grunge_wall',
                    'handmadepaper',
                    'leather_1',
                    'light_honeycomb',
                    'little_pluses',
                    'noisy',
                    'old_mathematics',
                    'paper_1',
                    'paper_2',
                    'paper_3',
                    'pinstripe',
                    'rockywall',
                    'smooth_wall',
                    'soft_wallpaper',
                    'subtle_freckles',
                    'subtle_orange_emboss',
                    'vichy',
                    'wavecut',
                    'white_carbon',
                    'white_sand',
                    'bgnoise_lg',
                    'cardboard',
                    'circles',
                    'crosses',
                    'cubes',
                    'diagonal-noise',
                    'diamonds',
                    'elastoplast',
                    'elegant_grid',
                    'fancy_deboss',
                    'felt',
                    'gold_scale',
                    'light_alu',
                    'light_checkered_tiles',
                    'littleknobs',
                    'noise_pattern_with_crosslines',
                    'paven',
                    'polaroid',
                    'project_papper',
                    'roughcloth',
                    'silver_scales',
                    'small_tiles',
                    'soft_circle_scales',
                    'square_bg',
                    'stucco',
                    'washi',
                    'white_texture',
                    'whitey',
                    'xv'
                );

                foreach ($lighttextures as $texture) {
                    echo "<option value='../images/textures/$texture.png'>$texture (light)</option>";
                }
                $darktextures = array(
                    'black_thread',
                    'broken_noise',
                    'carbon_fibre_big',
                    'classy_fabric',
                    'dark_matter',
                    'dark_wood',
                    'darkdenim3',
                    'denim',
                    'diagmonds',
                    'dvsup',
                    'fake_brick',
                    'gun_metal',
                    'hixs_pattern_evolution',
                    'irongrip',
                    'nami',
                    'px_by_Gre3g',
                    'starring',
                    'vertical_cloth',
                    'zigzag',
                    'always_grey',
                    'black_denim',
                    'black_paper',
                    'black-Linen',
                    'blackmamba',
                    'carbon_fibre',
                    'concrete_wall',
                    'crossed_stripes',
                    'dark_stripes',
                    'darth_stripe',
                    'gray_sand',
                    'green-fibers',
                    'micro_carbon',
                    'padded',
                    'random_grey_variations',
                    'tactile_noise',
                    'brushed_alu_dark',
                    'wood_1',
                    'black_linen_v2',
                    'black_scales',
                    'carbon_fibre_v2',
                    'crissXcross',
                    'dark_brick_wall',
                    'dark_circles',
                    'dark_leather',
                    'dark_mosaic',
                    'flowers',
                    'inflicted',
                    'real_cf',
                    'robots',
                    'squares',
                    'triangles',
                    'type',
                    'woven'
                );

                foreach ($darktextures as $texture) {
                    echo "<option value='../images/textures/$texture.png'>$texture (dark)</option>";
                }
                ?>

            </select>
            <label for="navposition">Shadow opacity</label>
            <select class="skinselect" id="shadowopacity">
                <option value="0">No Shadow</option>
                <option value="0.1">10%</option>
                <option value="0.2">20%</option>
                <option value="0.3">30%</option>
                <option value="0.4">40%</option>
                <option value="0.5" selected>50%</option>
                <option value="0.6">60%</option>
                <option value="0.7">70%</option>
                <option value="0.8">80%</option>
                <option value="0.9">90%</option>
                <option value="1">100%</option>
            </select>
            <input type="hidden" value="15px" id="shadowsize">
        </p>

        <div class="colorpick" id="primarycolor" data-color="#2a768f"><a href="#">Primary Color</a>
            <div class="previewcolor"></div>
        </div>
        <span class="clear"></span>
        <div class="colorpick" id="bgcolor" data-color="#fcfcfc"><a href="#">Background Color</a>
            <div></div>
        </div>
        <span class="clear"></span>
        <div class="colorpick" id="navcolor" data-color="#fff"><a href="#">Nav links</a>
            <div></div>
        </div>
        <span class="clear"></span>

        <p>
            <br /><label for="enableadvancedcustom"><input type="checkbox" checked id="enableadvancedcustom" data-toggle="collapse" data-target="#advancedcustom"> Advanced config</label>
        </p>
        <div class="collapse in" id="advancedcustom">

            <div class="colorpick" id="secondarycolor" data-color="#08546D"><a href="#">Links</a>
                <div class="previewcolor"></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="navbgprimarycolor" data-color="#2a768f"><a href="#">Nav Background</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="navbgsecondarycolor" data-color="#08546D"><a href="#">Nav Active state</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="navborder" data-color="#08546D"><a href="#">Nav Border</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="navcolorhover" data-color="#fff"><a href="#">Nav links hover</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="footercolor" data-color="#666"><a href="#">Footer text color</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="sectiontitlecolor" data-color="#fff"><a href="#">Section title text</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="sectiontitlebgprimarycolor" data-color="#2a768f">
                <a href="#">Section Title Background</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="sectiontitlebgsecondarycolor" data-color="#08546D">
                <a href="#">Section Title Border</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="btnbgcolor" data-color="#2a768f"><a href="#">Buttons Color</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="btnbgcolorhover" data-color="#08546D"><a href="#">Buttons Color Hover</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="timelinebgcolor" data-color="#2a768f"><a href="#">Timeline Buttons</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="timelinebgcolorhover" data-color="#08546D"><a href="#">Timeline Buttons Hover</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="progressbarprimary" data-color="#2a768f">
                <a href="#">Skills Progressbar Color (1)</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="progressbarsecondary" data-color="#08546D">
                <a href="#">Skills Progressbar Color (2)</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="itemhover" data-color="#2a768f"><a href="#">Blog & Portf. hover background</a>
                <div></div>
            </div>
            <span class="clear"></span>
            <div class="colorpick" id="itemhovertext" data-color="#08546D"><a href="#">Blog & Portf. hover text</a>
                <div></div>
            </div>
            <span class="clear"></span>

            <label for="backgrounded">Section titles stick left</label>
            <select class="skinselect" id="backgrounded">
                <option value="0" selected>No</option>
                <option value="1">Yes</option>
            </select>

        </div>

        <span class="clear"></span>
        <input type="button" id="configuratorreset" value="Reset">
        <input type="button" id="configuratorexport" value="Export" data-reveal-id="myModal">


    </div>
</div>
<div id="configuratorstyles"></div>

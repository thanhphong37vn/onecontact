window.CHITIKA_ADHESION = window.CHITIKA_ADHESION ? window.CHITIKA_ADHESION : (function() {
    "use strict";
    var adhesion_container;
    var adhesion_unit;
    var animate_end         = {};
    var animate_start       = {};
    var config              = {
        'animate'           : [ 'l', 'ob' ],
        'close_config'      : {
            'background'    : 'url(//images.chitika.net/buttons/close_white_on_black.gif)',
            'height'        : '18px',
            'right'         : '10px',
            'top'           : '0px',
            'width'         : '18px'
        },
        'height'            : Math.floor(window.innerHeight/5),
        'offset'            : { 'x': 0, 'y': 0 },
        'padding'           : '0px',
        'width'             : window.innerWidth
    };
    var offscreen_offset    = 15;
    var update_interval;

    var adhesion_config     = [
        { // 0: Desktop
            'animate'           : [ 'or', 'b' ],
            'border'            : '3px solid #cccccc',
            'borderRadius'      : '7px',
            'boxShadow'         : 'none',
            'close_config'      : {
                'height'        : '16px',
                'background'    : 'url(//images.chitika.net/buttons/close_white_on_black.gif)',
                'right'         : '3px',
                'top'           : '3px',
                'width'         : '16px'
            },
            'height'            : 250,
            'min_zoom'          : 1,
            'offset'            : { 'x': 10, 'y': 10 },
            'sid'               : 'hover app',
            'width'             : 500
        },
        { // 1: iPad
            'borderRadius'      : '0px',
            'borderTop'         : '1px solid #cccccc',
            'boxShadow'         : '0px -5px 5px #7d7d7d',
            'min_zoom'          : 0.4,
            'sid'               : 'mobile ad'
        },
        { // 2: iPhone
            'border'            : '1px solid #cccccc',
            'borderRadius'      : '0px',
            'boxShadow'         : '0px -5px 5px #7d7d7d',
            'min_zoom'          : 0.7,
            'sid'               : 'mobile ad'
        },
        { // 3: Android Phone
            'border'            : '1px solid #cccccc',
            'borderRadius'      : '0px',
            'boxShadow'         : '0px -5px 5px #7d7d7d',
            'min_zoom'          : 1,
            'min_zoom_landscape': 0.7,
            'sid'               : 'mobile ad'
        }
    ];

    function make_it_so() {
        var mobile_type = CHITIKA_ADS.mobile_type();
        if (mobile_type === 4 || mobile_type === 5) { return; }
        if (adhesion_unit) { return; }
        adhesion_container = top.document.getElementById('chitika-container-adhesion');
        if (adhesion_container) { return; }

        CHITIKA_ADS.send_event('adhesion_activate', undefined, undefined);

        if (!CHITIKA_ADS.window_data.top_accessible) { return; }
        if (top.document.cookie.indexOf("ch_adhesion_first_load") != -1) { return; }

        if (!adhesion_config[mobile_type]) { return; }
        CHITIKA_ADS.set_properties(config, adhesion_config[mobile_type]);
        if (CHITIKA.adhesion_config &&
            CHITIKA.adhesion_config[mobile_type]) {
            CHITIKA_ADS.set_properties(config, CHITIKA.adhesion_config[mobile_type]);
        }

        adhesion_container = CHITIKA_ADS.create_container('chitika-container-adhesion', config, top.document);
        top.document.body.appendChild(adhesion_container);

        if (config.animate[0] == 'l') {
            adhesion_container.style.left = config.offset.x + 'px';
        }
        else if (config.animate[0] == 'ol') {
            var offset = -config.width - offscreen_offset;
            adhesion_container.style.left = offset + 'px';
            animate_start.l = offset;
            animate_end.l = config.offset.x;
        }
        else if (config.animate[0] == 'r') {
            adhesion_container.style.right = config.offset.x + 'px';
        }
        else if (config.animate[0] == 'or') {
            var offset = -config.width - offscreen_offset;
            adhesion_container.style.right = offset + 'px';
            animate_start.r = offset;
            animate_end.r = config.offset.x;
        }


        if (config.animate[1] == 't') {
            adhesion_container.style.top = config.offset.y + 'px';
        }
        else if (config.animate[1] == 'ot') {
            var offset = -config.height - offscreen_offset;
            adhesion_container.style.top = offset + 'px';
            animate_start.t = offset;
            animate_end.t = config.offset.y;
        }
        else if (config.animate[1] == 'b') {
            adhesion_container.style.bottom = config.offset.y + 'px';
        }
        else if (config.animate[1] == 'ob') {
            var offset = -config.height - offscreen_offset;
            adhesion_container.style.bottom = offset + 'px';
            animate_start.b = offset;
            animate_end.b = config.offset.y;
        }

        adhesion_unit = {
            'callback'          : adhesion_callback,
            'cid'               : config.cid,
            'container_id'      : 'chitika-container-adhesion',
            'container_document': top.document,
            'disable_vcpm'      : true,
            'fluidH'            : true,
            'frame_id'          : 'chitikaAdhesionAd',
            'height'            : config.height,
            'impsrc'            : 'adhesion_js',
            'product'           : 'adhesion-'+mobile_type,
            'sid'               : config.sid,
            'skip_one_call'     : 1,
            'width'             : config.width
        };
        CHITIKA.units.push(adhesion_unit);
        CHITIKA_ADS.make_it_so();
    }

    function adhesion_callback(response) {
        if (response === undefined ||
            (!response.output &&
             !response.alturl)) {
            adhesion_hide();
        }
        var mobile_type = CHITIKA_ADS.mobile_type();

        CHITIKA_ADS.render_ad_basic(response);
        CHITIKA_ADS.render_ad_inject_content(response);

        setTimeout(
            function(){
                var unit = CHITIKA.units[response.unit_id];
                var frame = unit.frames[0];
                CHITIKA_ADS.attach_close(
                    frame.contentWindow.document.body,
                    config.close_config,
                    adhesion_hide,
                    frame.contentWindow.document
                );
            }, 1000);


        CHITIKA_ADS.animate(adhesion_container,
                            50,
                            animate_start,
                            animate_end);

        if (mobile_type != 0) {
            update_interval = setInterval(adhesion_update, 36);
        }

        var metadata = {
            'xargs'         : adhesion_unit.navajo
        };
        CHITIKA_ADS.send_event('adhesion_render', adhesion_unit.impId, metadata);
    }

    function adhesion_hide() {
        adhesion_container.style.visibility = "hidden";
        top.document.cookie = "ch_adhesion_first_load%3d1%3b%20expires%3d0%3b%20path%3d/index.html";
        clearInterval(update_interval);
        var metadata = {
            'xargs'         : adhesion_unit.navajo
        };
        CHITIKA_ADS.send_event('adhesion_close', adhesion_unit.impId, metadata);
    }

    function adhesion_update() {
        var portrait = window.innerHeight > window.innerWidth;
        var ad_zoom = get_zoom();
        var mobile_type = CHITIKA_ADS.mobile_type();
        var min_zoom = config.min_zoom;
        if (mobile_type === 3 && !portrait) {
            min_zoom = config.min_zoom_landscape;
        }

        var unit = adhesion_unit;
        // If the orientation or zoom have changed, resize the ad
        if (portrait !== config.portrait ||
            ad_zoom !== config.ad_zoom ||
            mobile_type === 1) {
            var ad_height = Math.floor(window.innerHeight/5);
            unit.container.style.setProperty('height', ad_height + 'px', 'important');
            unit.container.style.setProperty('width', window.innerWidth + 'px', 'important');
            unit.frames[0].style.setProperty('height', ad_height + 'px', 'important');
            unit.frames[0].style.setProperty('width', window.innerWidth + 'px', 'important');
            unit.frames[0].contentWindow.document.body.style.zoom = ad_zoom;
            if (mobile_type === 1) {
                unit.container.style.setProperty('position', 'absolute', 'important');
                unit.container.style.setProperty('top', ((window.innerHeight - ad_height) + window.pageYOffset) + 'px', 'important');
                unit.container.style.setProperty('left', window.pageXOffset + 'px', 'important');
            }
        }
        // Disappear at a particular zoom level
        if (ad_zoom < min_zoom) {
            unit.container.style.display = 'none';
            config.zoom_hide = 1;
        } else if(config.zoom_hide == 1 && ad_zoom >= min_zoom) {
            unit.container.style.display = 'block';
            config.zoom_hide = 0;
        }
        config.ad_zoom = ad_zoom;
        config.portrait = portrait;
    }

    function get_zoom() {
        var mobile_type = CHITIKA_ADS.mobile_type();
        var nua = navigator.userAgent.toLowerCase();
        var portrait = window.innerHeight > window.innerWidth;
        var ad_zoom;
        var browser = 'other';
        if (nua.indexOf('android') > -1 && nua.indexOf('chrome') > -1) {
            browser = 'chrome';
        } else if (nua.indexOf('firefox') > -1) {
            browser = 'firefox';
        } else if (nua.indexOf('android') > -1) {
            browser = 'android';
        } else if (nua.indexOf('safari') > -1) {
            browser = 'safari';
        }
        if (mobile_type == 3 && browser == 'android') {
            var devicePixelRatio = window.devicePixelRatio || 1;
            var deviceHeight = (portrait) ? screen.height : screen.width;
            var dips = deviceHeight / devicePixelRatio;
            ad_zoom = window.innerHeight / dips;
        } else {
            ad_zoom = window.innerHeight / screen.height;
        }
        return ad_zoom;
    }

    return {
        'adhesion_hide'             : adhesion_hide,
        'already_adhesion'          : false,
        'make_it_so'                : make_it_so
    };
}());

if (!CHITIKA_ADHESION.already_adhesion) { CHITIKA_ADHESION.make_it_so(); }

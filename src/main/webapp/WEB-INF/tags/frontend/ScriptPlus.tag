
 <!-- Scripts -->
    
    <script>
        $(document).ready(function () {            
            $("#footer").parent().parent().removeAttr("style");
        });
	</script>
    <!-- Syntaxhighlighter -->
    

    <script src="${contextPath}/OneContact/Js/app.js"></script>
    <script src="${contextPath}/OneContact/Js/index.js"></script>
    <script id="hiddenlpsubmitdiv" style="display: none;"></script>
    <script>try { for (var lastpass_iter = 0; lastpass_iter < document.forms.length; lastpass_iter++) { var lastpass_f = document.forms[lastpass_iter]; if (typeof (lastpass_f.lpsubmitorig2) == "undefined") { lastpass_f.lpsubmitorig2 = lastpass_f.submit; lastpass_f.submit = function () { var form = this; var customEvent = document.createEvent("Event"); customEvent.initEvent("lpCustomEvent", true, true); var d = document.getElementById("hiddenlpsubmitdiv"); if (d) { for (var i = 0; i < document.forms.length; i++) { if (document.forms[i] == form) { d.innerText = i; } } d.dispatchEvent(customEvent); } form.lpsubmitorig2(); } } } } catch (e) { }</script>
    
    <script type="text/javascript">
        window.$zopim || (function (d, s) {
            var z = $zopim = function (c) { z._.push(c) }, $ = z.s =
            d.createElement(s), e = d.getElementsByTagName(s)[0]; z.set = function (o) {
                z.set.
                _.push(o)
            }; z._ = []; z.set._ = []; $.async = !0; $.setAttribute('charset', 'utf-8');
            $.src = 'http://v2.zopim.com/?2MM2f4W2d1YCj1ncy3bAEvEW1jXsJec5'; z.t = +new Date; $.
            type = 'text/javascript'; e.parentNode.insertBefore($, e)
        })(document, 'script');
    </script>

	<script type="text/javascript">
	    $(document).ready(function() {
	        $("#chitikaAdBlock-0").css("display", "none");
	    });
	  ( function() {
	    if (window.CHITIKA === undefined) { window.CHITIKA = { 'units' : [] }; };
	    var unit = {"calltype":"async[2]","publisher":"tuantq","width":728,"height":90,"sid":"Chitika Default"};
	    var placement_id = window.CHITIKA.units.length;
	    window.CHITIKA.units.push(unit);
	    document.write('<div id="chitikaAdBlock-' + placement_id + '"></div>');
	}());
	</script>
	<script type="text/javascript" src="${contextPath}/OneContact/cdn.chitika.net/getads.js" async></script>

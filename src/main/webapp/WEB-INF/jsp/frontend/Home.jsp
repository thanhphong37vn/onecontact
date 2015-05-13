<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<%-- <oa:importstyles/> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request" />

<link rel="stylesheet" href="${contextPath}/OneContact/Style/0/275_2097cc.css?v=13022014131300" type="text/css"></link>
	<title>	Tổng đài di động OneContact</title>
	<script type="text/javascript" src="${contextPath}/OneContact/JsGlobal/jquery.min.js"></script>
	<link rel="SHORTCUT ICON" href="#" /><meta name="description" content="Giới thiệu" />
	<meta name="keywords" content="Giới thiệu" />
	<script type="text/javascript" src="${contextPath}/OneContact/JsGlobal/0/275_2097cc.js?v=13022014131300"></script>
	<link href="${contextPath}/OneContact/WebResource/WebResource4f70.css?d=urCACUaUZeT6oPoIZXShbg_mmz4IxolKBU2f2lGICcVr9zVasgvejRaViEKfDAFWSA6ZT8y3cDNFY4itK64CLadDTa212W-qSLgPe1DwgKR0rIjnR9i0MSkswhiYheFT0&amp;t=635005040540000000" type="text/css" rel="stylesheet" class="Telerik_stylesheet" />
	<link href="${contextPath}/OneContact/WebResource/WebResourcee5ee.css?d=QKX1AO1vX8ebWKfbb4eOTIuvEeQZeqb7Di-sEOkH8Q5SCCRL6kJow5nIicOKrhJpsSQVTjTfN0N9T7mxMuODBsNpCr5Opv-BAraYpyq3IWVjjOy-YsAGmtwxTSC6XVFe0&amp;t=635005040540000000" type="text/css" rel="stylesheet" class="Telerik_stylesheet" />
	<link href="${contextPath}/OneContact/WebResource/WebResource1238.css?d=L0_AKNDhmYFLmFvOBCSI4TnRui_H58krRDKEkY9-aqYGbDkYMxPogWFGBONtQCI5WqgeO95bx2DFa5gjdsZw_kbYArtKWhfsx-LuuBDXZ3gwvUOtstQML_vEuSk8Z2mc-CIqfmvwtmChmeacZOdtsoFrLgY_7oIM1PbI-4Q_BqQ1&amp;t=635005040540000000" type="text/css" rel="stylesheet" class="Telerik_stylesheet" />
</head>

<body>
    <!-------------------------------------------------------------------------
---------------------NCS PORTAL VERSION 1.0.0.2------------------------
---------------------Development by NCS Technology---------------------
----------------------------------------------------------------------- -->
<%--     <form method="post" action="http://42.112.31.59:8181/275/Gioi-thieu.html/BPF/vi-VN/CMS_Cat/Gioi_Thieu/" id="form1"> --%>
<div class="aspNetHidden">
<input type="hidden" name="RadScriptManager1_TSM" id="RadScriptManager1_TSM" value="" />
<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="" />
<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="" />
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="vijVgvhQgY5x/yKbCtZNJvdP/kZaILH1/ftMwvNOkeeu6j/9MK3tUT8olPN4Oh8IfvytDrBeRm/BU51O+umnsUSPa7Y4qK8iuAmjZVGpdypWEhoSXvGnjlxFIFgjFo+akAO2zuTqk92A166UMqWYXCCk+bDknRsxrmD/aoFGP1PNIdKxPNTqHUm5mQSoWJMQyN+Q0AEWFxSr2n+RjFEG0Q==" />
</div>

<!-- <script type="text/javascript"> -->
<!-- //<![CDATA[ -->
<!-- var theForm = document.forms['form1']; -->
<!-- if (!theForm) { -->
<!--     theForm = document.form1; -->
<!-- } -->
<!-- function __doPostBack(eventTarget, eventArgument) { -->
<!--     if (!theForm.onsubmit || (theForm.onsubmit() != false)) { -->
<!--         theForm.__EVENTTARGET.value = eventTarget; -->
<!--         theForm.__EVENTARGUMENT.value = eventArgument; -->
<!--         theForm.submit(); -->
<!--     } -->
<!-- } -->
<!-- //]]> -->
<!-- </script> -->


<script src="${contextPath}/OneContact/WebResource/WebResource7f07.js?d=pynGkmcFUV13He1Qd6_TZCFfzXizu66Bppmw_YHlGDxivMVJ8AdixWvU6OWweunCevgVYr5OcHzIKH3i0yqOfg2&amp;t=634774370700000000" type="text/javascript"></script>


<script src="${contextPath}/OneContact/WebResource/Telerik.Web.UI.WebResourcef4bc.js?_TSM_HiddenField_=RadScriptManager1_TSM&amp;compress=1&amp;_TSM_CombinedScripts_=%3b%3bSystem.Web.Extensions%2c+Version%3d4.0.0.0%2c+Culture%3dneutral%2c+PublicKeyToken%3d31bf3856ad364e35%3aen-US%3ac9cbdec3-c810-4e87-846c-fb25a7c08002%3aea597d4b%3ab25378d2%3bTelerik.Web.UI%3aen-US%3a66639117-cae4-4d6c-a3d7-81eea986263a%3a16e4e7cd%3af7645509%3aed16cbdc%3a24ee1bba%3a19620875%3af46195d3%3a874f8ea2%3a490a9d4e" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
if (typeof(Sys) === 'undefined') throw new Error('ASP.NET Ajax client-side framework failed to load.');
//]]>
</script>

<script type="text/javascript">
//<![CDATA[
var PageMethods = function() {
PageMethods.initializeBase(this);
this._timeout = 0;
this._userContext = null;
this._succeeded = null;
this._failed = null;
}
PageMethods.prototype = {
_get_path:function() {
 var p = this.get_path();
 if (p) return p;
 else return PageMethods._staticInstance.get_path();},
UpdateDrag:function(tagname,iddel,succeededCallback, failedCallback, userContext) {
/// <param name="tagname" type="String">System.String</param>
/// <param name="iddel" type="String">System.String</param>
/// <param name="succeededCallback" type="Function" optional="true" mayBeNull="true"></param>
/// <param name="failedCallback" type="Function" optional="true" mayBeNull="true"></param>
/// <param name="userContext" optional="true" mayBeNull="true"></param>
return this._invoke(this._get_path(), 'UpdateDrag',false,{tagname:tagname,iddel:iddel},succeededCallback,failedCallback,userContext); }}
PageMethods.registerClass('PageMethods',Sys.Net.WebServiceProxy);
PageMethods._staticInstance = new PageMethods();
PageMethods.set_path = function(value) {
PageMethods._staticInstance.set_path(value); }
PageMethods.get_path = function() { 
/// <value type="String" mayBeNull="true">The service url.</value>
return PageMethods._staticInstance.get_path();}
PageMethods.set_timeout = function(value) {
PageMethods._staticInstance.set_timeout(value); }
PageMethods.get_timeout = function() { 
/// <value type="Number">The service timeout.</value>
return PageMethods._staticInstance.get_timeout(); }
PageMethods.set_defaultUserContext = function(value) { 
PageMethods._staticInstance.set_defaultUserContext(value); }
PageMethods.get_defaultUserContext = function() { 
/// <value mayBeNull="true">The service default user context.</value>
return PageMethods._staticInstance.get_defaultUserContext(); }
PageMethods.set_defaultSucceededCallback = function(value) { 
 PageMethods._staticInstance.set_defaultSucceededCallback(value); }
PageMethods.get_defaultSucceededCallback = function() { 
/// <value type="Function" mayBeNull="true">The service default succeeded callback.</value>
return PageMethods._staticInstance.get_defaultSucceededCallback(); }
PageMethods.set_defaultFailedCallback = function(value) { 
PageMethods._staticInstance.set_defaultFailedCallback(value); }
PageMethods.get_defaultFailedCallback = function() { 
/// <value type="Function" mayBeNull="true">The service default failed callback.</value>
return PageMethods._staticInstance.get_defaultFailedCallback(); }
PageMethods.set_enableJsonp = function(value) { PageMethods._staticInstance.set_enableJsonp(value); }
PageMethods.get_enableJsonp = function() { 
/// <value type="Boolean">Specifies whether the service supports JSONP for cross domain calling.</value>
return PageMethods._staticInstance.get_enableJsonp(); }
PageMethods.set_jsonpCallbackParameter = function(value) { PageMethods._staticInstance.set_jsonpCallbackParameter(value); }
PageMethods.get_jsonpCallbackParameter = function() { 
/// <value type="String">Specifies the parameter name that contains the callback function name for a JSONP request.</value>
return PageMethods._staticInstance.get_jsonpCallbackParameter(); }
PageMethods.set_path("Default.aspx");
PageMethods.UpdateDrag= function(tagname,iddel,onSuccess,onFailed,userContext) {
/// <param name="tagname" type="String">System.String</param>
/// <param name="iddel" type="String">System.String</param>
/// <param name="succeededCallback" type="Function" optional="true" mayBeNull="true"></param>
/// <param name="failedCallback" type="Function" optional="true" mayBeNull="true"></param>
/// <param name="userContext" optional="true" mayBeNull="true"></param>
PageMethods._staticInstance.UpdateDrag(tagname,iddel,onSuccess,onFailed,userContext); }
//]]>
</script>

       <script type="text/javascript">
//<![CDATA[
Sys.WebForms.PageRequestManager._initialize('RadScriptManager1', 'form1', [], [], [], 90, '');
//]]>
</script>
    
<link href="${contextPath}/OneContact/Image/preload.css" rel="stylesheet" media="screen"/>
<link href="${contextPath}/OneContact/Image/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="${contextPath}/OneContact/Image/font-awesome.min.css" rel="stylesheet" media="screen"/>
<link href="${contextPath}/OneContact/Image/animate.min.css" rel="stylesheet" media="screen">
<link href="${contextPath}/OneContact/Image/slidebars.css" rel="stylesheet" media="screen">
<link href="${contextPath}/OneContact/Image/lightbox.css" rel="stylesheet" media="screen">
<link href="${contextPath}/OneContact/Image/jquery.bxslider.css" rel="stylesheet">
<link href="${contextPath}/OneContact/Image/shCore.css" rel="stylesheet" media="screen">

<link href="${contextPath}/OneContact/Image/style-blue.css" rel="stylesheet" media="screen" title="default">
<link href="${contextPath}/OneContact/Image/width-full.css" rel="stylesheet" media="screen" title="default">

<link href="${contextPath}/OneContact/Image/buttons.css" rel="stylesheet" media="screen">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
        <script src="../js/html5shiv.min.js"></script>
        <script src="../js/respond.min.js"></script>
    <![endif]-->

<div>
    <div class="boxed" >
    <div id="preloader" style="display: none;">
        <div id="status" style="display: none;">&nbsp;</div>
    </div>
    <div id="ctl07_ContentPane" style="width: 100%"><div></div></div>
    <div id="ctl07_boxcenter">
		<div align="Left" style="width:100%;float:left;">
			<div class="top-nav" style="width: 100%;background: #f1f1f1;margin-bottom:10px;height:30px;line-height:30px">
				<div class="animated fadeInDown animation-delay-11" style="float:right;padding-right:10px">
				   MobiFone | <a href="http://1contact.vn/" ><i class="fa fa-user"></i> Đăng nhập</a>
				</div>
				<!-- dropdown -->
				<input type="hidden" name="ctl07$ctl02$fieldParamPrivate" id="ctl07_ctl02_fieldParamPrivate" value="searchTab#267;" />
			</div>
			<header id="header-full-top" class="header-full hidden-xs" style="background:white">
				<div class="container">
					<div class="header-full-title" style="width:100%;">
						<div style="float: left;">
							<a href="#" class="animated fadeInRight">
								<img src="${contextPath}/OneContact/Image/logo_mobifone.png" alt="Tổng đài di động OneContact" />
							</a>
							<p class="animated fadeInRight"></p>
	
						</div>
						<div style="float: right">
							<a href="#" class="animated fadeInRight">
								<img src="${contextPath}/OneContact/Image/logo_onecontact.png" alt="Tổng đài di động OneContact" />
							</a>
						</div>
					</div>
	
				</div>
				<!-- container -->
			</header>
		</div>
		
		<div align="Left" style="width:100%;float:left;">
			<div class="navbar navbar-static-top navbar-default navbar-header-full navbar-dark" role="navigation" id="header">
				<div class="container">
					 <div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<i class="fa fa-bars"></i>
						</button>
						  <a href="#" class="navbar-brand hidden-lg hidden-md hidden-sm active" style="width:300px">   </a>
					   
					</div> <!-- navbar-header -->
	
					<!-- Collect the nav links, forms, and other content for toggling -->
			   
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul id="ctl07_ctl04_root" class="nav navbar-nav">					   
						<li class=""><a href="http://1contact.vn/meg/index.jsp">Trang chủ</a></li>
						<li class="active"><a href="index.html">Giới thiệu</a></li>
						<li class=""><a href="#">Khuyến mại v&#224; tin tức</a></li>
						<li class=""><a href="#">Hướng dẫn sử dụng</a></li>
						<li class=""><a href="#">Li&#234;n hệ</a></li></ul>
					</div>
					<!-- navbar-collapse -->
				</div>
				<!-- container -->
			</div>
		</div>
		<div align="Left" style="width:100%;float:left;">
		<header class="main-header">
			<div class="container">
			   <!-- <h1 class="page-title">Giới thiệu</h1>-->
				<ol class="breadcrumb pull-right">
					<li>
						<a href='http://tongdaididong.com/'><i class="icon-home"></i>Trang chủ</a>
					</li>
					<li>
						<a class='last-child'>Giới thiệu</a>
					</li>	
				</ol>
			</div>
		</header>
		<input type="hidden" name="ctl07$ctl06$fieldParamPrivate" id="ctl07_ctl06_fieldParamPrivate" value="CMS_getaddresssite#http://tongdaididong.com;" />
		</div>
	</div>	
	
    <div class="container">
        <div class="row">
            <div id="ctl07_ListCenter" class="col-md-8">
				<div align="Left" style="width:100%;float:left;">
				<section>
					<h2 id="ctl07_ctl08_aTitle" class="page-header no-margin-top">Tổng đ&#224;i di động OneContact</h2>    
					<div id="ctl07_ctl08_pContent" style="padding-left:20px;padding-right:20px">
						<p style="text-align: justify; font-family: arial,helvetica,sans-serif;" margin-top:12.0pt;margin-right:0in;margin-bottom:.0001pt;margin-left:.5in;text-align:justify;text-indent:.5in;line-height:normal""=""> 
							Tổng đài OneContact là một giải pháp toàn diện của MobiFone, dựa trên nền tảng mạng di động, 
							nhằm cung cấp dịch vụ Tổng đài di động cho khách hàng doanh nghiệp. 
							Doanh nghiệp khi đăng ký&nbsp;sử dụng dịch vụ sẽ được khai báo một số tổng đài di động (số hotline), 
							nhằm sử dụng cho tất cả các liên lạc liên quan đến doanh nghiệp đó, bao gồm cả thoại và SMS. 
							Mỗi số thuê bao di động của nhân viên sẽ được khai báo như một số máy lẻ để&nbsp;
							kết nối vào hệ thống tổng đài OneContact của doanh nghiệp đó.<a name="loiich" title="Bookmark: loiich"></a>
						</p>
						<p style="text-align: justify; font-family: arial,helvetica,sans-serif;" margin-top:12.0pt;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;text-align:justify;text-indent:0in;line-height:normal""="">
						<strong style="color: #0063af;" mso-bidi-font-weight:normal""="">Lợi&nbsp;ích của dịch vụ:</strong></p>
						<li>Không&nbsp;mất chi phí đầu tư ban đầu, không chi phí bảo trì hệ thống</li><li>
						Sử&nbsp;dụng ngay số di động có sẵn làm số tổng đài và máy lẻ</li><li>  Gọi&nbsp;nội bộ miễn phí (nếu máy lẻ là thuê bao của MobiFone)</li>
						<li>Điện&nbsp;đàm hội nghị, giảm họp trực tiếp</li><li>Tiết&nbsp;kiệm thời gian,&nbsp;tối ưu chi phí cho doanh nghiệp
						<a name="tinhnang" title="Bookmark: tinhnang"></a></li><p style="text-align: justify; font-family: arial,helvetica,sans-serif; color: #0063af;" margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:.75in;text-indent:.25in;line-height:normal""="">
						<strong>Tính&nbsp;năng của dịch vụ:</strong></p><li>&nbsp;Đầy đủ&nbsp;chức năng của tổng đài truyền thống:<br>  
						 Gọi thoại&nbsp;nội bộ doanh nghiệp: 100 + Số máy lẻ người nhận  <br>   
						 Gọi thoại&nbsp;ngoài doanh nghiệp: 100 + Số điện thoại người nhận.  <br>   
						 Khách hàng&nbsp;gọi đến: Holine + Số máy lẻ nhân viên  </li>
						 <li>Điện đàm hội nghị: Cùng 1 lúc thực hiện cuộc gọi hội nghị đa điểm tới 256 số điện thoại khác nhau.
						  Cài đặt tự động thoại hội nghị vào ngày, giờ cụ thể.</li>
						  <li>Cài đặt&nbsp;lời chào: Cài đặt lời chào chung và lời chào riêng cho từng đối tượng khách hàng</li>
						  <li>Quản lý&nbsp;chi phí: Quản lý chi phí thông qua việc đặt hạn mức cước gọi cho từng nhân viên</li>
						  <li>Chuyển tiếp cuộc gọi: Chuyển tiếp cuộc gọi từ số máy lẻ của mình sang ba số khác nhau và có thể lập trình
						   theo thời gian, ngày trong&nbsp;tuần.</li><li>Chặn cuộc gọi: Chặn những số điện&nbsp;thoại không
						    mong muốn bằng cách báo bận hoặc chuyển sang một số máy lẻ khác để xử lý.</li>
						    <li>Thông báo&nbsp;cuộc gọi nhỡ: Tổng đài sẽ thông báo chi tiết về cuộc gọi nhỡ đến từng số máy lẻ trong hệ thống.</li>
						    <li>Tính năng danh bạ: Dịch vụ tích hợp&nbsp;sẵn tính năng danh bạ điện thoại cho doanh nghiệp sử dụng dịch vụ, 
						    gồm Danh bạ nhân viên và Danh bạ khách hàng.</li><li>Ngoài ra OneContact còn cung cấp nhiều tính năng khác như: 
						    tính năng gọi lại, gửi tin nhắn nhóm<a name="quytrinh" title="Bookmark: quytrinh"></a>…
						    </li>
						    <p style="text-align: justify; font-family: arial,helvetica,sans-serif; color: #0063af;" margin-left:.75in;text-indent:.25in;line-height:normal""=""><strong>Quy trình đăng&nbsp;ký dịch vụ</strong></p>
						    <p style="text-align: justify; font-family: arial,helvetica,sans-serif;" margin-bottom:0in;margin-bottom:.0001pt;text-align:justify;text-indent:-.25in;line-height:normal"="">Bước 1: Khách hàng ký Hợp đồng OneContact để sử dụng dịch vụ.&nbsp;
						    </p>
						    <p style="text-align: justify; font-family: arial,helvetica,sans-serif;" margin-bottom:0in;margin-bottom:.0001pt;text-align:justify;text-indent:-.25in;line-height:normal"="">Bước 2: Khách hàng cung cấp thuê bao MobiFone để làm số Hotline, danh sách các nhân viên sử dụng dịch vụ.
						    </p>
						    <p style="text-align: justify; font-family: arial,helvetica,sans-serif;" margin-bottom:0in;margin-bottom:.0001pt;text-align:justify;text-indent:-.25in;line-height:normal"="">Bước 3: Nhân viên MobiFone khai báo số Hotline và danh sách máy lẻ cho Khách hàng.</p>
						    <p style="text-align: justify; font-family: arial,helvetica,sans-serif;" margin-bottom:0in;margin-bottom:.0001pt;text-align:justify;text-indent:-.25in;line-height:normal"="">Bước 4: Nhân viên MobiFone chuyển giao tài khoản quản trị Doanh nghiệp cho khách hàng và hướng dẫn Khách hàng sử dụng dịch vụ.<a name="giacuoc" title="Bookmark: giacuoc"></a></p>
						    <p style="font-family: arial,helvetica,sans-serif; color: #0063af;" margin-bottom:0in;margin-bottom:.0001pt;line-height:normal""="">
						    <strong>Giá cước dịch vụ:</strong>
						    </p>  
						    <div style="text-align:center;font-family:arial,helvetica,sans-serif">
						    <img src="${contextPath}/OneContact/Image/goicuoc.png">  <br></div>  <span style="font-family:arial,helvetica,sans-serif"><br></span></div>

				</section>
			<input type="hidden" name="ctl07$ctl08$fieldParamPrivate" id="ctl07_ctl08_fieldParamPrivate" value="CMS_Detail#106;" />
			</div>
		</div>
		
        <div class="col-md-4">
	        <aside id="ctl07_Sidebar" class="sidebar">
	            <div align="Left" style="width:100%;float:left;">
					<div id="ctl07_ctl10_loading" class="RadAjax RadAjax_NCS" style="display:none;">
							<div class="raDiv"></div>
							<div class="raColor raTransp"></div>
					</div>   
		  
				    <span id="ctl07_ctl10_lblscript"></span>
					<div id="ctl07_ctl10_divcontent">
						<ul class="sidebar-nav animated fadeIn">
						    <li class="active">
						    <a data-toggle="collapse" href="#coll-comp" aria-expanded="true"><em class="fa fa-list-alt"></em> Giới thiệu</a>
						    <ul id="coll-comp" class="menu-submenu list-unstyled collapse in" aria-expanded="true">
						        <li><a href="#onecontactl"><em class="fa fa-arrow-circle-right"></em> OneContact l&agrave; g&igrave;</a></li>
						        <li><a href="#loiich"><em class="fa fa-arrow-circle-right"></em> Lợi &iacute;ch của dịch vụ</a></li>
						        <li><a href="#tinhnang"><em class="fa fa-arrow-circle-right"></em> T&iacute;nh năng của dịch vụ</a></li>
						        <li><a href="#quytrinh"><em class="fa fa-arrow-circle-right"></em> Quy tr&igrave;nh đăng k&yacute; dịch vụ</a></li>
						        <li><a href="#giacuoc"><em class="fa fa-arrow-circle-right"></em> Gi&aacute; cước dịch vụ</a></li>
						    </ul>
						    </li>
						</ul>
					</div>
					<div id="ctl07_ctl10_RadWindowLayout" style="display:none;">
						<!-- 2013.1.403.45 -->
						<div id="ctl07_ctl10_RadWindowLayout_C" style="display:none;"></div>						
					</div>					
				</div>
				<div align="Left" style="width:100%;float:left;">
					<div id="ctl07_ctl12_video" class="panel panel-primary animated fadeInDown animation-delay-8">
					    <div class="panel-heading"><i class="fa fa-play-circle"></i>Video</div>
					    <div id="ctl07_ctl12_videocontent" class="video">
						    <iframe width="300" height="200" src="http://www.youtube.com/embed/2McTAEHW6W0" frameborder="0" allowfullscreen></iframe>
					    </div>
					</div>
				</div>
			</aside>
        </div>
        </div>
    </div>
    <!-- boxed -->
    <div id="ctl07_boxfooter">
    <div align="Left" style="width:100%;float:left;"><div id="ctl07_ctl14_loading" class="RadAjax RadAjax_NCS" style="display:none;">
	<div class="raDiv"></div>
	<div class="raColor raTransp"></div>
</div>
<div id="ctl07_ctl14_divcontent">
	<footer id="footer">Copyright &copy; 2014 VMS MobiFone. Supported by MobiFone Global</footer>
</div>
<div id="ctl07_ctl14_RadWindowLayout" style="display:none;">
	<div id="ctl07_ctl14_RadWindowLayout_C" style="display:none;">

	</div><input id="ctl07_ctl14_RadWindowLayout_ClientState" name="ctl07_ctl14_RadWindowLayout_ClientState" type="hidden" />
</div></div></div>
    <!-- sb-site -->
        </div>


    <div id="back-top" style="display: none;">
        <a href="#header"><i class="fa fa-chevron-up"></i></a>
    </div>
    <!-- Scripts -->
    <script src="${contextPath}/OneContact/Js/jquery.cookie.js"></script>
    <script src="${contextPath}/OneContact/Js/jquery.cookie.js"></script>
    <script src="${contextPath}/OneContact/Js/bootstrap.min.js"></script>
    <script src="${contextPath}/OneContact/Js/wow.min.js"></script>
    <script src="${contextPath}/OneContact/Js/slidebars.js"></script>
    <script src="${contextPath}/OneContact/Js/jquery.bxslider.min.js"></script>
    <script src="${contextPath}/OneContact/Js/holder.js"></script>
    <script src="${contextPath}/OneContact/Js/buttons.js"></script>
    <script src="${contextPath}/OneContact/Js/styleswitcher.js"></script>
    <script src="${contextPath}/OneContact/Js/jquery.mixitup.min.js"></script>
    <script src="${contextPath}/OneContact/Js/circles.min.js"></script>
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
</div>


<!-- <script type="text/javascript"> -->
<!-- //<![CDATA[ -->
<!-- Sys.Application.add_init(function() { -->
<!--     $create(Telerik.Web.UI.RadAjaxLoadingPanel, {"backgroundTransparency":100,"initialDelayTime":0,"isSticky":false,"minDisplayTime":0,"skin":"NCS","uniqueID":"ctl07$ctl10$loading","zIndex":90000}, null, null, $get("ctl07_ctl10_loading")); -->
<!-- }); -->
<!-- Sys.Application.add_init(function() { -->
<!--     $create(Telerik.Web.UI.RadWindow, {"_dockMode":false,"behaviors":4,"clientStateFieldID":"ctl07_ctl10_RadWindowLayout_ClientState","formID":"form1","height":"700px","iconUrl":"","minimizeIconUrl":"","modal":true,"name":"RadWindowLayout","skin":"Metro","visibleStatusbar":false,"width":"900px"}, null, null, $get("ctl07_ctl10_RadWindowLayout")); -->
<!-- }); -->
<!-- Sys.Application.add_init(function() { -->
<!--     $create(Telerik.Web.UI.RadAjaxLoadingPanel, {"backgroundTransparency":100,"initialDelayTime":0,"isSticky":false,"minDisplayTime":0,"skin":"NCS","uniqueID":"ctl07$ctl14$loading","zIndex":90000}, null, null, $get("ctl07_ctl14_loading")); -->
<!-- }); -->
<!-- Sys.Application.add_init(function() { -->
<!--     $create(Telerik.Web.UI.RadWindow, {"_dockMode":false,"behaviors":4,"clientStateFieldID":"ctl07_ctl14_RadWindowLayout_ClientState","formID":"form1","height":"500px","iconUrl":"","minimizeIconUrl":"","modal":true,"name":"RadWindowLayout","skin":"Metro","visibleStatusbar":false,"width":"700px"}, null, null, $get("ctl07_ctl14_RadWindowLayout")); -->
<!-- }); -->
<!-- //]]> -->
<!-- </script> -->
<%-- </form> --%>

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
</body>
</html>

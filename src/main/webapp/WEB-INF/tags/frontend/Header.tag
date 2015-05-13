<!DOCTYPE html>
<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fe" tagdir="/WEB-INF/tags/frontend" %>

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
				<fe:Menu></fe:Menu>				
			</div>
			<!-- container -->
		</div>
	</div>
	<div align="Left" style="width:100%;float:left;">
		<header class="main-header">
			<div class="container">
			   <!-- <h1 class="page-title">Giới thiệu</h1>-->
				<ol class="breadcrumb pull-right">
					<li><a href='http://1contact.vn/'><i class="icon-home"></i>Trang chủ</a></li>
					<li><a class='last-child'>${menu_select}</a></li>	
				</ol>
			</div>
		</header>
	</div>
</div>	
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="fe" tagdir="/WEB-INF/tags/frontend" %>
<fe:wrapper>
	    <div class="container">
	        <div class="row">
	            <div id="ctl07_ListCenter" class="col-md-8">
					<div align="Left" style="width:100%;float:left;">
					<section>
						<h2 id="ctl07_ctl08_aTitle" class="page-header no-margin-top">${entity.title }</h2>    
						<div id="ctl07_ctl08_pContent" style="padding-left:20px;padding-right:20px">
							${entity.content }
						</div>
					</section>			
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
</fe:wrapper>	    
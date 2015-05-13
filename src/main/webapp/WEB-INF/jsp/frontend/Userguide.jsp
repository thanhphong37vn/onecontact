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
						<ul style="list-style-type: none; margin: 0px; padding: 0px;">
					    <li>
						    <a class="thumbnail" href="#">
						    	<img alt="" src="${contextPath}/OneContact/Image/quangcao_phai.jpg" />
						    </a>
					    </li>
					    <li>
						    <a class="thumbnail" href="#">
						    	<img alt="" src="${contextPath}/OneContact/Image/banner_right2.jpg" />
						    </a>
					    </li>
						</ul>
					</div>
					<div id="ctl07_ctl10_RadWindowLayout" style="display:none;">
						<!-- 2013.1.403.45 -->
						<div id="ctl07_ctl10_RadWindowLayout_C" style="display:none;"></div>					
					</div>
					</div>
				</aside>
            </div>
        </div>
    </div>

</fe:wrapper>
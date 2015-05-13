<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="fe" tagdir="/WEB-INF/tags/frontend" %>
<fe:wrapper>
	
	<div class="container">
        <div class="row">
            <div id="ctl07_ListCenter" class="col-md-8">
	            <div align="Left" style="width:100%;float:left;">
					<div class="col-md-8">
					    <section>		
					    	<h2 id="ctl07_ctl08_aTitle" class="page-header no-margin-top">${entity.title }</h2>    
							<div id="ctl07_ctl08_pContent" style="padding-left:20px;padding-right:20px">	    
<!-- 					       	<h4 class="section-title no-margin-top"><span style="font-size: 16px;">Mọi thông tin xin liên hệ:</span></h4>					 -->
<!-- 					      	<p style="" margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:1.0in;text-indent:-.25in;line-height:normal"="">o  Đối với thuê bao MobiFone, VinaPhone: 18001090. </p>					 -->
<!-- 					        <p style="" margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:1.0in;text-indent:-.25in;line-height:normal"="">o Đối với thuê bao mạng khác: 0904144144 </p> -->
					
								${entity.content }
							</div>
					        <div style="display:none" >
					            <div class="form-group">
					                <label for="InputName">Họ và tên:</label>
					                <input name="ctl07$ctl08$InputName" type="text" id="ctl07_ctl08_InputName" class="form-control" />
					            </div>
					            <div class="form-group">
					                <label for="InputEmail1">Địa chỉ Email:</label>
					                <input name="ctl07$ctl08$InputEmail1" type="email" id="ctl07_ctl08_InputEmail1" class="form-control" />
					            </div>
					            <div class="form-group">
					                <label for="InputMessage">Nội dung</label>  
					                <textarea name="ctl07$ctl08$InputMessage" id="ctl07_ctl08_InputMessage" class="form-control" rows="8"></textarea>
					            </div>
					            <button onclick="__doPostBack('ctl07$ctl08$btnSend','')" id="ctl07_ctl08_btnSend" class="btn btn-ar btn-primary">Gửi</button>
					            <div class="clearfix"></div>
					        </div>
					    </section>
					</div>
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
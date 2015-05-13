<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="fe" tagdir="/WEB-INF/tags/frontend" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fe:wrapper>
	<div class="container">
        <div class="row">
            <div id="ctl07_ListCenter" class="col-md-8">
	            <div align="Left" style="width:100%;float:left;">      
	              	<c:forEach items="${listNews}" var="item">	              	
			        	<article class="post animated fadeInLeft animation-delay-8">
				            <div class="panel panel-default">
				                <div class="panel-body">
				                    <h3 class="post-title">
				                        <a href='detailnews-${item.id }.html' class="transicion">${item.title}</a>
				                    </h3>
				                    <div class="row">
				                        <div class="col-lg-4">			
				                            <img class="img-post img-responsive" src="${contextPath}/Images_Upload/${item.thumbnail}" alt="${item.title}" />
				                        </div>
				                        <div class="col-lg-8 post-content">
				                            <p>${item.intro}</p>
				                        </div>
				                    </div>
				                </div>
				                <div class="panel-footer post-info-b">
				                    <div class="row">
				                    	<c:set var="dateUpdate" value="${item.lastUpdate }" />
				                        <div class="col-lg-10 col-md-9 col-sm-8">
	 				                       <i class="fa fa-clock-o"></i><fmt:formatDate pattern="dd-MM-yyyy" value="${dateUpdate}" />
				                            <!--<i class="fa fa-user"></i>admin -->
				                        </div>
				                        <div class="col-lg-2 col-md-3 col-sm-4">
				                            <a href='detailnews-${item.id }.html' class="pull-right">Xem thêm »</a>
				                        </div>
				                    </div>
				                </div>
				            </div>
				        </article>   
			        </c:forEach>
					<!-- post -->
					<section class="text-center">
					   	${htmlInner }
					</section>
				</div>
			</div>
			
			
            <div class="col-md-4">
                <aside id="ctl07_Sidebar" class="sidebar">
	                <div align="Left" style="width:100%;float:left;">
						<div class="block animated fadeInDown animation-delay-10">    
						    <div class="tab-content">
						        <div class="tab-pane active" id="fav">
						            <h3 class="post-title no-margin-top">Bài viết liên quan</h3>
						              <ul class="media-list">
						               <c:forEach items="${listNewsRelation}" var="entity">		
							              <li class="media">
							                  <a class="pull-left" href='detailnews-${entity.id }.html'>
							                      <img class="media-object" width="85" src="${contextPath}/Images_Upload/${entity.thumbnail}" alt="${entity.title }" />
							                  </a>
							                  <div class="media-body">
							                      <p class="media-heading">
							                          <a href='detailnews-${entity.id }.html'>${entity.title }</a>
							                      </p>							                      
												  <c:set var="dateUpdate" value="${entity.lastUpdate }" />
							                      <small>
<%-- 							                      ${entity.lastUpdate } --%>
							                      	<fmt:formatDate pattern="dd-MM-yyyy" value="${dateUpdate}" />
							                      </small>
							                  </div>
							              </li>	
							            </c:forEach>								              
						              </ul>                
						        </div>        
						    </div>
						    <!-- tab-content -->
						</div>					
					</div>
	
					<div align="Left" style="width:100%;float:left;">
						<div class="block animated fadeInDown animation-delay-10">	   
						    <div class="tab-content">
						        <div class="tab-pane active" id="tag">
						           <h3 class="post-title">Tags</h3>	            
				                   <div class="tags-cloud">
				                   <c:forEach items="${listTags}" var="entity">				                   
				                   		<a href='search-${entity.id}.html' class="tag">${entity.name}</a>
				                   </c:forEach>
				                   </div>	                
						        </div>
						    </div>
						    <!-- tab-content -->
						</div>	
					</div>
				</aside>
            </div>
        </div>
    </div>

</fe:wrapper>
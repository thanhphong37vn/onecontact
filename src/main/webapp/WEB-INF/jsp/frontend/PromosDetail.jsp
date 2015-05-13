<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fe" tagdir="/WEB-INF/tags/frontend"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fe:wrapper>
	<div class="container">
		<div class="row">
			<div class="col-md-8" id="ctl07_ListCenter">
				<div align="Left" style="width: 100%; float: left;">
					<section>
					<h2 class="page-header no-margin-top" id="ctl07_ctl08_aTitle">${form.title }</h2>
						<div style="padding-left: 20px; padding-right: 20px" id="ctl07_ctl08_pContent">
							<div style="text-align: justify">
								${form.intro }								
							</div>
							${form.content }
						</div>
					</section>
				</div>
			</div>
			<div class="col-md-4">
				<aside class="sidebar" id="ctl07_Sidebar">
				<div align="Left" style="width: 100%; float: left;">
					<div class="block animated fadeInDown animation-delay-10">

						<div class="tab-content">
							<div id="fav" class="tab-pane active">
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
						                      	<fmt:formatDate pattern="dd/MM/yyyy" value="${dateUpdate}" />
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
				<div align="Left" style="width: 100%; float: left;">
					<div class="block animated fadeInDown animation-delay-10">
						<div class="tab-content">
							<div id="tag" class="tab-pane active">
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

<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fe" tagdir="/WEB-INF/tags/frontend"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
					<style>
						.PagerHyperlinkStyle {
							display: inline-block;
							text-align: center;
							line-height: 20px;
							margin-bottom: 0;
							vertical-align: middle;
							cursor: pointer;
							padding: 5px 9px;
							font-size: 14px;
							background: #eee;
						}
						
						.PagerHyperlinkStyle:hover {
							background: #ccc;
						}
						
						.PagerContainerTable {
							width: 100%;
						}
						
						.PagerOtherPageCells,.PagerCurrentPageCell {
							width: 20px;
						}
						
						.PagerInfoCell {
							font-weight: 800;
						}
					</style>
					
<fe:wrapper>
	<div class="container">
		<div class="row">
			<div class="col-md-8" id="ctl07_ListCenter">
				<div align="Left" style="width: 100%; float: left;">
				<p><strong id="ctl07_ctl08_commentcat">Kết quả tìm kiếm từ khóa: <b>${key }</b></strong></p>
				<c:forEach items="${list}" var="item">	      
					<article class="post animated fadeInLeft animation-delay-8">
						<div class="panel panel-default">
							<div class="panel-body">
								<h3 class="post-title">
									<a class="transicion" href="detailnews-${item.id }.html">${item.title }</a>
								</h3>
								<div class="row">									
									<div class="col-lg-6">
                            			<img alt="${item.title }" src="${contextPath}/Images_Upload/${item.thumbnail }" class="img-post img-responsive" id="ctl07_ctl08_rptList_Image1_2">
                        			</div>
									<div class="col-lg-6 post-content">
										<p>${item.intro }</p>
									</div>
								</div>
							</div>
							<div class="panel-footer post-info-b">
								<div class="row">
									<div class="col-lg-10 col-md-9 col-sm-8">
										<i class="fa fa-clock-o"></i>${item.lastUpdate }
									</div>
									<div class="col-lg-2 col-md-3 col-sm-4">
										<a class="pull-right" href="detailnews-${item.id }.html">Xem thêm »</a>
									</div>
								</div>
							</div>
						</div>
					</article>
				</c:forEach>

<!-- 				<table cellspacing="1" cellpadding="3" border="0" class="PagerContainerTable"> -->
<!-- 					<tbody> -->
<!-- 						<tr> -->
<!-- 							<td class="PagerInfoCell">Trang 1 của 4</td> -->
<!-- 							<td class="PagerCurrentPageCell"><span title="Bạn đang xem bản ghi từ  1 tới 10 của 33" class="PagerHyperlinkStyle"><strong> 1 </strong> -->
<!-- 							</span> -->
<!-- 							</td> -->
<!-- 							<td class="PagerOtherPageCells"><a title="Bài viết từ  11 tới 20 của 33" href="#" class="PagerHyperlinkStyle"> 2 </a> -->
<!-- 							</td> -->
<!-- 							<td class="PagerOtherPageCells"><a title="Bài viết từ  21 tới 30 của 33" href="#" class="PagerHyperlinkStyle"> 3 </a> -->
<!-- 							</td> -->
<!-- 							<td class="PagerOtherPageCells"><a title="Bài viết từ  31 tới 33 của 33" href="#" class="PagerHyperlinkStyle"> 4 </a> -->
<!-- 							</td> -->
<!-- 							<td class="PagerOtherPageCells"><a title=" Chuyển tới trang 2" href="#" class="PagerHyperlinkStyle"> &gt; </a> -->
<!-- 							</td> -->
<!-- 						</tr> -->
<!-- 					</tbody> -->
<!-- 				</table> -->
				</div>
			</div>
			<div class="col-md-4">
				<aside class="sidebar" id="ctl07_Sidebar">
				
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
								                      <small>${entity.lastUpdate }</small>
								                  </div>
								              </li>		
							              </c:forEach>				              
						              </ul>                
						        </div>        
						    </div>
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
						</div>						
					</div>
				</aside>
			</div>
		</div>
	</div>	
</fe:wrapper>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Trang chủ</title>
	<link rel="stylesheet" type="text/css" href="css/trangchu.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="js/trangchu.js"></script>
</head>
<body>
<div class="Homepage">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<img id="Logo-web" src="image/logo.jpg" style="height: 50px;">
		  <div class="container-fluid">
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <form class="d-flex" action="HomePage" method="post">
		    		<input type="hidden" name="command" value="SEARCH">
			        <input class="form-control me-2" type="search" name="title" placeholder="Tìm kiếm tựa sách,tác giả...." aria-label="Search">
			        <button type="button" class="btn btn-warning">Tìm sách</button>
		        </form>
			    <div class="list-menu">
				    <ul class="navbar-nav">
					    <li class="nav-item">
					      <a class="nav-link" href="http://localhost:8080/bookweb/BuyBook?command=BUY">Giỏ hàng </a>
					    </li>
					     <li class="nav-item">
						  <a class="nav-link" href="view/signin.jsp">Đăng nhập </a>
					    </li>
					    <div class="verticalLine"></div>
					    <li class="nav-item">
						  <a class="nav-link" href="view/dangky.jsp">Đăng ký </a>
					    </li>   
					    <div class="verticalLine"></div>
					    <li class="nav-item">
						  <a class="nav-link" href="http://localhost:8080/bookweb/UserServlet?command=LOGOUT">Đăng xuất </a>
					    </li>  
			  		</ul>
			    </div> 
		</nav>
</div>
			<div class="list-menu2">
				<p  id="list item"><i id="generality" style="font-size:24px" 
					class="fa">&#xf039;</i>
				</p>
				<form>
				    <select class="Menu-Book" id="mySelect" onchange="category()">
				    	<option class="text-color">DANH MỤC SÁCH</option>
				    	<c:forEach var="tempCategory" items="${categories}">
				    		<option class="text-color" value="${tempCategory.categoryId}">${tempCategory.categoryName }</option>
						</c:forEach>
				    </select>
		    	</form>

					<nav class="nav">
					  <i  class="material-icons">&#xe61d;</i>
					  <a class="nav-link" href="#">Hotline:1900 6198</a>
					  <div class="verticalLine2"></div>
					  <a class="nav-link" href="#">Tin tức</a>
					  <div class="verticalLine2"></div>
					  <a class="nav-link" href="view/contact.jsp">Liên hệ</a>
					</nav>
			</div>

	<div class="all-group-book">
		
		<div class="news-book">
			<img class="all-image" src="https://www.vinabook.com/images/thumbnails/promo/802x480/363104_06.jpg">
			<img class="all-image"src="https://www.vinabook.com/images/thumbnails/promo/802x480/363107_05.jpg">
			<img class="all-image"src="https://www.vinabook.com/images/thumbnails/promo/802x480/363501_15.jpg">
	
		</div>

			<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		  <ol class="carousel-indicators">
		    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		  </ol>
		  <div  class="carousel-inner">
		    <div class="carousel-item active">
		      <img class="d-block w-100" src="https://www.vinabook.com/images/thumbnails/promo/802x480/363488_final1511.jpg" alt="First slide">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="https://www.vinabook.com/images/thumbnails/promo/802x480/363501_15.jpg" alt="Second slide">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="https://www.vinabook.com/images/thumbnails/promo/802x480/363109_04.jpg" alt="Third slide">
		    </div>
		  </div>
		  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
		
	</div>
	<br>
	  <li class="list-group-item list-group-item-primary">SÁCH KINH TẾ MỚI</li>
<br>
<div class="category-buy-book">
	<div id="display-book">
		<c:forEach var="tempBook" items="${list_book}">
			<c:url var="tempLink" value="BookDetailServlet">
		 		<c:param name="id" value="${tempBook.bookId }"/>
	    	</c:url>
			<div id="book-list">
				<a href = "${tempLink }"><img src="${tempBook.image }" alt="image" class="index-image"></a>
				<div id="display-infor">
				<br>
					<p href = "${tempLink }" style="color:blue;font-size: 20px">${tempBook.bookName }</p>
					<p>${tempBook.shortDescription }<p>
					<p style="color:red">${tempBook.currentPrice }đ<p>
					<p><del>${tempBook.originalPrice }</del>&nbsp; -${tempBook.saleOff }%</p>
					<p style="color:red">Số lượng: ${tempBook.amount }<p>
				</div>
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;
		</c:forEach>
	</div>
</div>
<li class="list-group-item list-group-item-warning">SÁCH VĂN HỌC MỚI</li>
<br>
<div class="category-buy-book2">
	<div id="display-book">
		<c:forEach var="tempBook" items="${list_thebook}">
			<c:url var="tempLink" value="BookDetailServlet">
		 		<c:param name="id" value="${tempBook.bookId }"/>
	    	</c:url>
			<div id="book-list">
				<a href = "${tempLink }"><img src="${tempBook.image }" alt="image" class="index-image"></a>
				<div id="display-infor">
				<br>
					<p href = "${tempLink }" style="color:blue;font-size: 20px">${tempBook.bookName }</p>
					<p>${tempBook.shortDescription }<p>
					<p style="color:red">${tempBook.currentPrice }đ<p>
					<p><del>${tempBook.originalPrice }</del>&nbsp; -${tempBook.saleOff }%</p>
					<p style="color:red">Số lượng: ${tempBook.amount }<p>
				</div>
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;
		</c:forEach>
	</div>
</div>

<div class="introduce">
	<div class="introduce-1">
	<ul class="all-introduce">
		<p class="title-introduce">VỀ CÔNG TY</p>
		<li class="aaa">Giới thiệu công ty</li>
		<li class="aaa">Tuyển dụng</li>
		<li class="aaa">Báo chí</li>
	</ul>

	<ul class="all-introduce">
		<p class="title-introduce">TRỢ GIÚP</p>
		<li class="aaa">Quy định sử dụng</li>
		<li class="aaa">Hướng dẫn mua hàng</li>
		<li class="aaa">Phương thức thanh toán</li>
	</ul>

	<ul class="all-introduce">
		<p class="title-introduce">TIN TỨC SÁCH</p>
		<li class="aaa">Tin tức</li>
		<li class="aaa">Chân dung</li>
		<li class="aaa">Điểm sách</li>
		<li class="aaa">Phê bình</li>
	</ul>
	</div>
	<div class="introduce-2">
	<ul class="all-introduce">
		<p class="title-introduce">CHẤP NHẬN THANH TOÁN</p>
		<div class="all-pay">
			<img class="pay-book" src="https://www.vinabook.com/public/assets/img/cod.jpg">
			<img class="pay-book"src="https://www.vinabook.com/public/assets/img/visa.jpg">
			<img class="pay-book"src="https://www.vinabook.com/public/assets/img/master_card.jpg">
		</div>
		<div class="all-pay2">
			<img class="pay-book"src="https://www.vinabook.com/public/assets/img/jcb.jpg">
			<img class="pay-book"src="https://www.vinabook.com/public/assets/img/atm.jpg">
			<img class="pay-book"src="https://www.vinabook.com/public/assets/img/payoo.jpg">
		</div>
		<p class="title-introduce">THANH TOÁN AN TOÀN</p>
			<img class="pay-book"src="https://www.vinabook.com/public/assets/img/verify_visa.jpg">
			<img class="pay-book"src="https://www.vinabook.com/public/assets/img/mastercard_securecode.jpg">
			<img class="pay-book"src="https://www.vinabook.com/public/assets/img/onepay.jpg">
	</ul>

	<ul class="all-introduce">
		<p class="title-introduce">ĐỐI TÁC VẬN CHUYỂN</p>
			<img class="shipping partner"src="https://www.vinabook.com/public/assets/img/logovnb.png">
			<img class="shipping partner"src="https://www.vinabook.com/public/assets/img/vn-post.jpg">
		
	</ul>
	<ul class="all-introduce">
		<p class="title-introduce">ĐỐI TÁC BÁN HÀNG</p>
			<img class="sales partner"src="https://www.vinabook.com/public/assets/img/lazada.jpg">
			<img class="sales partner"src="https://www.vinabook.com/public/assets/img/shopee.jpg">
			<img class="sales partner"src="https://www.vinabook.com/public/assets/img/amazon.jpg">
	</ul>
	</div>
</div>
<div class="end-page">
		<img id="recognition" src="https://www.vinabook.com/images/thumbnails/images/222/83/logo_so_cong_thuong.png">

			<div id="andress">
			<p id="CTTNHH">CÔNG TY TNHH 4 THÀNH VIÊN ROKET</p>
			<p class="andress-small">Địa chỉ:458 Tôn Đức Thắng,Phường Hòa Minh,Quận Liên Chiểu,TP.Đà Nẵng</p>
			<p class="andress-small">tel:0999888777-fax:023.18888888-Email:thuanduongk18@gmail.com</p>
			</div>

			<div id="same-system-all">
			<p class="giongnhau">WEBSITE CÙNG HỆ THỐNG</p>
			<img class="same system" src="https://www.vinabook.com/images/thumbnails/img/152/22/logo_hotdeal_2x.png">
			<img class="same system" src="https://www.vinabook.com/images/thumbnails/img/146/40/logo_yesgo_2x.png">
			</div>

</div>
</body>
</html>
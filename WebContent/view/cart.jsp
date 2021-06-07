<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gio hang</title>
<link rel="stylesheet" type="text/css" href="css/trangchu.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/cart.css ">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script type="text/javascript" src="js/cart-ajax.js"></script>
</head>
<body>
	<div class="Menu-all">
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
			</div>
		</div>
		</nav>
	</div>
<a class="Comback" href="http://localhost:8080/bookweb/">Quay lại trang chủ</a>
<div class="Order">
	<div>
	<c:forEach var="tempBook" items="${list_book}">
		<c:url var="tempLink" value="BuyBook">
	 		<c:param name = "bookId" value = "${tempBook.bookId }"/>
	 		<c:param name ="command" value = "DELETE" />
    	 </c:url>
    	 <div class="total orders">
			<a href="${tempLink }"><button  class="btn-close" aria-label="Close"></button></a>
			<img src="${tempBook.image }" alt="image" class="card-img-top">
			<div class="total-book">
				<p class="bookname">&nbsp;&nbsp;${tempBook.bookName }</p>
				&nbsp;&nbsp;${tempBook.currentPrice }%
				&nbsp;&nbsp;-${tempBook.saleOff }%	
				<br>
				&nbsp;&nbsp;<strike>${tempBook.originalPrice }<u>đ</u></strike>
			</div>
			<div class="increasing the number">
				<form class="number-product">
		            <p>Số lượng: ${tempBook.amount } </p>
		        </form>
		         <p class="thantien">Thành tiền</p>
		         <p class="into money">${tempBook.total }<u>đ</u></p>

			</div>
		</div>
	</c:forEach>
	</div>
	<%
		int amount = (int)request.getAttribute("amount"); 
		float total = (float)request.getAttribute("total"); 
		int fee = (int)request.getAttribute("fee");
	%>
	<div class="order details" style="height:350px;">
		<div class="tomtat"><p class="donhang">Đơn hàng</p></div>
			<div class="all-paybook">
				<div class="total-pay">
					<p>Số sản phẩm:</p>
					<p>Phí vận chuyển:</p>
					<p>Tổng tiền:</p>
				</div>
				<div class="price">
					<p>${amount }</p>
					<p>${fee }<u>đ</u></p>
					<p>${total }<u>đ</u></p>
				</div>
				
			</div>
			<div class="all-paybook">
				<div class="total-pay">
						<p>Tên:</p>
						<p>Địa chỉ:</p>
						<p>Số điện thoại:</p>
				</div>
					<div class="price1">
						<form>
							<input type="hidden" id="command" value="PAY">
							<p><input type="text" id="name" placeholder="Tên" style="width: 180px;"></p>
							<p><input type="text" id="address" placeholder="Dịa chỉ" style="width: 180px;"></p>
							<p><input type="text" id="phone" placeholder="Số điện thoại" style="width: 180px;"></p>
							<input class="Pay-book" type="button" id="payment" value="Thanh toán"> 
						</form>
					</div>	
					<div id="myModal" class="modal">
						<!-- Modal content -->
						<div class="modal-content">
							<span class="close">&times;</span>
							<p id="message" style="color:red;"></p>
						</div>
					</div>
			</div>
	</div>
</div>	
	

<div class="menu-introduce">
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
	</div>
</div>
</body>
</html>
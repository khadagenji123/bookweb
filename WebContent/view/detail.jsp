<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Detail</title>
	<link rel="stylesheet" type="text/css" href="css/trangchu.css">
	<link rel="stylesheet" type="text/css" href="css/detail.css">
	<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
	<script type="text/javascript" src="js/detail-ajax.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="Homepage">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<img id="Logo-web" src="https://scontent.fdad3-3.fna.fbcdn.net/v/t1.6435-9/167182078_1845877822246934_2234026853077650046_n.jpg?_nc_cat=108&ccb=1-3&_nc_sid=730e14&_nc_ohc=tsPIXpkx6tgAX8Ft5CK&_nc_ht=scontent.fdad3-3.fna&oh=da9f783a11471f97a8b6b4c2974f6862&oe=608D3C72">
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
	        <option class="text-color" value="tieuthuyet">Tiểu thuyết</option>
	        <option class="text-color" value="cotich">Truyện cổ tích</option>
	        <option class="text-color" value="kinhte">Sách kinh tế</option>
	        <option class="text-color" value="laptrinh">Sách lập trình</option>
	    </select>
   	</form>

		<nav class="nav">
		  <i  class="material-icons">&#xe61d;</i>
		  <a class="nav-link" href="#">Hotline:1900 6198</a>
		  <div class="verticalLine2"></div>
		  <a class="nav-link" href="http://localhost:8080/bookweb/">Trang chủ</a>
		  <div class="verticalLine2"></div>
		  <a class="nav-link" href="view/contact.jsp">Liên hệ</a>
		</nav>
</div>
			
<c:forEach var="tempBook" items="${theBook}">
		<div id="product">
	        <div>
	            <img src="${tempBook.image  }" alt="image" class="index-image">
	        </div>
	        <div id="right">
	        	<div class="info">
	        		<p class="part1">Nhà xuất bản: ${tempBook.publishingCompany }</p> 
	        		<p class="part2">Tác giả: ${tempBook.author}</p>
	        	</div>
	        	<div class="info">
	        		<p class="part1">Thể loại: ${tempBook.categoryName }</p>  
	        		<p class="part2">Số lượng: ${tempBook.amount}</p>
	        	</div>
	            ${tempBook.bookName  }
	            <p style="color:red">${tempBook.currentPrice }đ</p>
	            <p><del>${tempBook.originalPrice}đ</del>&nbsp; -${tempBook.saleOff }%</p>
	            <form class="number-product">
	               <input type="button" onclick="down();" value="-" class="button4"/>
	                &nbsp;&nbsp;
	                <div id="up">1</div>
	                &nbsp;&nbsp;
	               <input type="button" onclick="up();" value="+" class="button4" />
	            </form>
	           <p>	
	           		<input type="hidden" id="command" value="CHECKBUY">
	           		<input type="hidden" id="bookId" value="${tempBook.bookId  }">
	           		<button class="button" data-modal="modalOne" id="myBtn">Mua Ngay</button>
	           	</p>
			    <p>
			      <button class="button" data-modal="modalTwo">Thêm vào giỏ hàng</button>
			    </p>

			    
			</div> 
		</div>
		<div id="modalOne" class="modal">
			      <div class="modal-content">
			          <a class="close">&times;</a>
			          <form style="padding: 10px;">
			          	<input type="hidden" id="command1" value="SIGNINTOBUY">
			            <h2 style="color: red;">Chào mừng bạn! Hãy đăng nhập để tiếp tục</h2>
			            <div>
			              <input type="text" id="userName1" placeholder="Tên tài khoản">
			              <input type="password" id="password1" placeholder="Mật khẩu">
			              <p id="missmatch" class="missmatch" style="color: red;"></p>
			              <div id="result"></div>
			            </div>
			            <input style="background-color: white; margin-top:5px;" type="button" id="myBtn1" value="ĐĂNG NHẬP"> 
			          </form>
			      </div>
		</div>
        <div id="describe">
        	
        	<h3>Mô tả sản phẩm:</h3>
        	${tempBook.detailDescription }
		</div>
</c:forEach>

	
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
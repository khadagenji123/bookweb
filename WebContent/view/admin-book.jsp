<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
<title>Book</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/adcategory.css">
</head>
<body>
 <input type="checkbox" id="sidebar-toggle">
    <div class="sidebar">
        <div class="sidebar-header">
            <h3 class="brand">
                <span class="ti-unlink"></span>
                <span>Adminstrator</span>
            </h3>
            <label for="sidebar-toggle" class="ti-menu-alt"></label>
        </div>
        <div class="sidebar-menu">
            <ul>
                <li>
                    <a href="view/admin.jsp">
                        <span class="ti-home"></span>
                        <span>Trang chủ Admin</span>
                    </a>
                </li>
                <li>
                    <a href="http://localhost:8080/bookweb/Admin_CategoryServlet">
                        <span class="ti-agenda"></span>
                        <span>Quản lí danh mục</span>
                    </a>
                </li>
                <li>
                    <a href="">
                        <span class="ti-face-smile"></span>
                        <span>Quản trị giao diện</span>
                    </a>
                </li>
                <li>
                    <a href="">
                        <span class="ti-clipboard"></span>
                        <span>Quản lí thông tin</span>
                    </a>
                </li>
                <li>
                    <a href="http://localhost:8080/bookweb/Admin_CartServlet">
                        <span class="ti-folder"></span>
                        <span>Cart</span>
                    </a>
                </li>
                <li>
                    <a href="http://localhost:8080/bookweb/Admin_UserServlet">
                        <span class="ti-time"></span>
                        <span>User</span>
                    </a>
                </li>
                <li>
                    <a href="http://localhost:8080/bookweb/Admin_BookServlet">
                        <span class="ti-book"></span>
                        <span>Book</span>
                    </a>
                </li>
                <li>
                    <a href="http://localhost:8080/bookweb/Admin_ContactServlet">
                        <span class="ti-settings"></span>
                        <span>Contact</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="main-content">
        <header>
            <div class="search-wrapper">
                <span class="ti-search"></span>
                <input type="search" placeholder="Search">
            </div>
            <div class="social-icons">
                <span class="ti-bell"></span>
                <span class="ti-comment"></span>
                <div></div>
            </div>
        </header>
        <section class="recent">
            <div class="activity-grid">
                <div class="activity-card">
                    <div class="table-responsive">
                        <!-- Bảng sản phẩm (Book) -->
                        <table border="1">
                            <thead>
                                <th>Book Id</th>
                                <th>Category Id</th>
                                <th>Title</th>
                                <th>Publishing Company</th>
                                <th>Author</th>
                                <th>Original Price</th>
                                <th>Sale Off</th>
                                <th>Current Price</th>
                                <th>Short Description</th>
                                <th>Detail Description</th>
                                <th>amount</th>
                                <th>Link Image</th>
                                <th>Action</th>
                            </thead>
                            <tbody>
                                <c:forEach var="tempBook" items="${list_book }">
                                	<c:url var="deleteBook" value="Admin_BookServlet">
					        			<c:param name="command" value="DELETE"/>
					        			<c:param name="bookId" value="${tempBook.bookId }"/>
					        		</c:url>
					        		<tr>
					        			<td>${tempBook.bookId }</td>
					        			<td>
					        				<form action="Admin_BookServlet" method="get">
					        					<input type="hidden" name="command" value="UPDATE">
					        					<input type="hidden" name="bookId" value="${tempBook.bookId }">
					        					<input type="text"  name="categoryId" value="${tempBook.categoryId }" 
					        					style="border: none;outline-width: 0;">
					        			</td>
					        			<td>
					        					<input type="text"  name="bookName" value="${tempBook.bookName }" 
					        					style="border: none;outline-width: 0;">
					        			</td>
					        			<td>
					        					<input type="text"  name="publishingCompany" value="${tempBook.publishingCompany }" 
					        					style="border: none;outline-width: 0;">
					        			</td>
					        			<td>
					        					<input type="text"  name="author" value="${tempBook.author }" 
					        					style="border: none;outline-width: 0;">
					        			</td>
					        			<td>
							        			<input type="text"  name="originalPrice" value="${tempBook.originalPrice }" 
							        			style="border: none;outline-width: 0;">
					        			</td>
					        			<td>
					        					<input type="text"  name="saleOff" value="${tempBook.saleOff }" 
							        			style="border: none;outline-width: 0;">
					        			</td>
					        			<td>
					        					<input type="text"  name="currentPrice" value="${tempBook.currentPrice }" 
							        			style="border: none;outline-width: 0;">
					        			</td>
					        			<td>
					        					<input type="text"  name="shortDescription" value="${tempBook.shortDescription }" 
							        			style="border: none;outline-width: 0;">
					        			</td>
					        			<td>
					        					<input type="text"  name="detailDescription" value="${tempBook.detailDescription }" 
							        			style="border: none;outline-width: 0;">
					        			</td>
					        			<td>
					        					<input type="text"  name="amount" value="${tempBook.amount }" 
							        			style="border: none;outline-width: 0;">
					        			</td>
					        			<td>
					        					<input type="text"  name="image" value="${tempBook.image }" 
							        			style="border: none;outline-width: 0;">
					        			</td>
					        			<td>
					        				<input type="submit" value="Update">
					        				</form>
					        				&nbsp;&nbsp;&nbsp;
					        				<button  onclick="openForm()">Add</button>
					        				&nbsp;&nbsp;&nbsp;
					        				<a href = "${deleteBook }"
					    	 	 			onclick = "if(!(confirm('Are you sure you want to delete this book?'))) {return false; }" >
					    	 	 			<button class="button" >Delete</button></a>
					        			</td>
					        		</tr>
					        	</c:forEach> 
                            </tbody>
                        </table>
                        <br>
                    </div>
                </div>
            </div>
        </section>
    </div>
    
    <div class="loginPopup">
      <div class="formPopup1" id="popupForm">
        <form action="Admin_BookServlet" method="get" class="formContainer1">
          <h2>Add Book</h2>
          <input type="hidden" name="command" value="ADD">
          <input type="text" placeholder="Category Id" name="categoryId" required>
          <input type="text" placeholder="Title" name="bookName" required>
          <input type="text" placeholder="Publishing Company" name="publishingCompany">
          <input type="text" placeholder="author" name="author">
          <input type="text" placeholder="OriginalPrice" name="originalPrice" required>
          <input type="text" placeholder="Sale Off" name="saleOff" required>
          <input type="text" placeholder="Current Price" name="currentPrice" required>
          <input type="text" placeholder="Short Description" name="shortDescription">
          <input type="text" placeholder="Detail Description" name="detailDescription">
          <input type="text" placeholder="Amount" name="amount" required>
          <input type="text" placeholder="Image" name="image">
          <br>
          <button type="submit" class="btn">Submit</button>
          <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
        </form>
      </div>
    </div>
    
    <script>
      function openForm() {
        document.getElementById("popupForm").style.display = "block";
      }
      function openForm1() {
          var theSelect = document.getElementById("id2").value;
          alert(theSelect);
        }
      function closeForm() {
        document.getElementById("popupForm").style.display = "none";
      }
	</script>
</body>
</html>
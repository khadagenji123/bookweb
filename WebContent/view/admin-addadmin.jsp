<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
<title>Category</title>
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
                        <!-- Liên hệ(Contract) -->
                        <table border="1">
                            <thead>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Action</th>
                            </thead>
                            <tbody>
                            	<c:forEach var="tempCategory" items="${list_category }">
					        		<c:url var="deleteCategory" value="Admin_CategoryServlet">
					        			<c:param name="command" value="DELETE"/>
					        			<c:param name="categoryId" value="${tempCategory.categoryId }"/>
					        		</c:url>
					        		
					        		<tr>
					        			<td>${tempCategory.categoryId }</td>
					        			<td>
					        				<form action="Admin_CategoryServlet" method="get">
					        					<input type="hidden" name="command" value="UPDATE">
					        					<input type="hidden" name="categoryId" value="${tempCategory.categoryId }">
					        					<input type="text"  name="categoryName" value="${tempCategory.categoryName }" 
					        					style="border: none;outline-width: 0;">
					        			</td>
					        			<td>
					        				<input type="submit" value="Update">
					        				</form>
					        				&nbsp;&nbsp;&nbsp;
					        				<button  onclick="openForm()">Add</button>
					        				&nbsp;&nbsp;&nbsp;
					        				<a href = "${deleteCategory }"
					    	 	 			onclick = "if(!(confirm('Are you sure you want to delete this category?'))) {return false; }" >
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
      <div class="formPopup" id="popupForm">
        <form action="Admin_CategoryServlet" method="get" class="formContainer">
          <h2>Add Category</h2>
          <input type="hidden" name="command" value="ADD">
          <input type="text" placeholder="Category Name" name="categoryName" required>
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
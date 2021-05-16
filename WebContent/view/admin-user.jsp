<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
<title>User</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
<link rel="stylesheet" href="css/admin.css">
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
                        <!-- Bảng User -->
                        <table border="1">
                            <thead>
                                <th>Id</th>
                                <th>User Name</th>
                                <th>Password</th>
                                <th>Name</th>
                                <th>phone_number</th>
                                <th>Email</th>
                                <th>Address</th>
                                <th>Check User</th>
                            </thead>
                            <tbody>
                            	<c:forEach var="tempUser" items="${list_user }">
					        		<tr>
					        			<td>${tempUser.userId }</td>
					        			<td>${tempUser.userName }</td>
					        			<td>${tempUser.password }</td>
					        			<td>${tempUser.name }</td>
					        			<td>${tempUser.phone }</td>
					        			<td>${tempUser.email }</td>
					        			<td>${tempUser.address }</td>
					        			<td>${tempUser.checkUser }</td>
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
</body>
</html>
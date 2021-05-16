<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang test</title>
<link rel="stylesheet" href="../css/adcategory.css">
</head>
<body>
      <button  onclick="openForm()">Open Form</button>
    <div class="loginPopup">
      <div class="formPopup" id="popupForm">
        <form action="/action_page.php" class="formContainer">
          <h2>Add Category</h2>
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
      function closeForm() {
        document.getElementById("popupForm").style.display = "none";
      }
</script>
  
</body>
</html>
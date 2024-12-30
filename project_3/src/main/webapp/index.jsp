<%@ page import="in.co.rays.project_3.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- responsive bnaya -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- padding is used for space from top of the image and link
 -->
<style>

.p1 {
	padding-top: 155px;
}
body{


	 background-image: url('img/jeshoots.jpg');	
	 background-size:100%;
	background-repeat: no-repeat;
} 
/* background image is for img and size is for cover entire area of container or web page and repeat is for not repeating  the image
 */

</style>
<!-- img fluid to make responsive image accc to size of web page -->
<body class="img-fluid" >
	<div class="p1">
		<label><h1 align="Center" >
			<img src="img/custom.png" width="420px" height="190px" border="0">
		</h1 >
		<h1 align="Center" >
         <a href="<%=ORSView.WELCOME_CTL%>" style="color: red; text-decoration: none;"> <font style="font-size: 60px;">Online Result System</font></a>
		</h1>
		</label>
	</div>
</body>
</html>
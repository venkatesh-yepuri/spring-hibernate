<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Condidate_Registration</title>

<script type="text/javascript"
	src="public/javascript/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="public/javascript/jquery.js"></script>
<script type="text/javascript"
	src="public/javascript/jquery.validate.js"></script>

<script type="text/javascript">
	$().ready(function() {
		// validate signupform on keyup and submit
		$("#registrationform").validate({
			rules : {

				firstname : "required",
				lastname : "required",

			},
			messages : {
				firstname : "Please enter your",
				lastname : "Please enter your lastname",
			},
			//errorElement : "div",
			//wrapper : "div",
			    errorPlacement : function(error, element) {
				error.appendTo($('.errormessg'));
			},
		});
	});
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="site-wrapper">
		<div class="divw-px916 divh-px530 form-div">
			<form action="#" method="post" id="registrationform">
				<div class="divw-px916 divh-px30">
					<div class="fieldtype-text">
						<label for="firstname" id="firstname" class="right push-top-px6">Firstname:</label>
					</div>
					<div class="fieldtype-text">
						<input type="text" id="firstname"
							class="firstname span-px298 text" name="firstname"
							style="width: 298px;" />
					</div>
					<div class="errormessg" style="background-color:orange;"></div>
				</div>
				<!-- <div class="divw-px916 divh-px30">
					<div class="fieldtype-text">
						<label for="lastname" id="lastname" class="right push-top-px6">Lastname:</label>
					</div>
					<div class="fieldtype-text">
						<input type="text" id="lastname" class="lastname span-px298 text"
							name="lastname" style="width: 298px;" />
					</div>
					<div class="errormessg"></div>
				</div> -->
				<div class="divw-px916 divh-px30">
					<div class="fieldtype-text">
						<input type="submit" value="submit" class="right push-top-px6"/>
					</div>

				</div>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
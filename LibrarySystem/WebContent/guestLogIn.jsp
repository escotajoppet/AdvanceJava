<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Library System</title>
	<link rel="stylesheet" href="css/main.css" />
	<link rel="stylesheet" href="css/guestloginfirst.css" />
</head>
<body>
	<div id="main">
	<div id="header">
		<img src="img/logo.png" alt="" />
		<h1>Library</h1>
	</div>
	<div id="GuestLoggedIn">
		<h1>Welcome Guest!</h1><br />
		<form action="Controller">
		<input type="text" class="guestSearch" value="" placeholder="Search Book"/>
		<select name="category" id="category">
			<option value="">Control Number</option>
			<option value="">Book Title</option>
			<option value="">Author</option>
			<option value="">Year Published</option>
		</select>
		<button type="submit" name="btn" value="guestsearch" class="guestsearch"></button>
		</form>
	</div>
	<div id="footer">
	</div>
</div>
</body>
</html>
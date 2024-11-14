
<html>

<head>
<style>

	span
	{
		font-size: 30px;
		color:red;
	}

</style>
</head>

<body>

<span>${message}</span>

<br><br>

<form>
		
		<input type="text" name="username" placeholder="enter user name"><br><br>
		<input type="password" name="password" placeholder="enter password"><br><br>
		
		<input type=submit value="login" formmethod="post" formaction="validate">
		<input type=submit value="register" formmethod="post" formaction="showregister">
		
</form>

</body>


</html>
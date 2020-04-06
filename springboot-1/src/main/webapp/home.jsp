<html>
<head>
<title>welcome</title>
</head>
<body>

	<h1>Adding alien to the planet</h1>
	<form action="addalien">
		<table>
		<tr><td>Alien Id</td><td><input type="text" name="aid"></td></tr>
		<tr><td>Alien Name<td><input type="text" name="aname"></td></tr>
		<tr><td><input type="submit"></td></tr>
		</table>
	</form>
	 <br>
	
	<h1>Find  my alien from planet</h1>
	<form action="fetchalien">
	<table>
		<tr><td>Alien Id</td><td><input type="text" name="aid"></td></tr>
		<tr><td><input type="submit"></td></tr>
	</table>
	</form>
	
	<br>
	
	<h1>Throw my alien from planet</h1>
	<form action="delalien">
	<table>
		<tr><td>Alien Id</td><td><input type="text" name="aid"></td></tr>
		<tr><td><input type="submit"></td></tr>
	</table>
	</form>

	
</body>

</html>
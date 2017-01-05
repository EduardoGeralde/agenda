<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add Contacts</title>
	</head>
	<body>
		<h1> Add Contacts </h1>
		<hr />
		<form action="addContact" method="post">
			Name:
			<input type="text" name="name"/>
			<br />
			E-mail:
			<input type="text" name="email"/>
			<br />
			Address:
			<input type="text" name="address" />
			<br />
			Birth Date:
			<input type="text" name="birthDate" />
			<br />

			<input type="submit" value="Save"/>
		</form>
	</body>
</html>
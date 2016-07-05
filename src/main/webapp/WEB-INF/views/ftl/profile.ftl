<#import "spring.ftl" as spring>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home pejcz</title>
	</head>
	<body>
	USER PROFILE: <br />
	Username: ${userProfile.username!""} <br />
	Email: ${userProfile.email!""} <br />
	Pass: ${userProfile.password!""}
	</body>
</html>
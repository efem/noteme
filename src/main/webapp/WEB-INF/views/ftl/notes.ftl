<#import "spring.ftl" as spring>
<html>
	<head>
		<meta charset="UTF-8">
		<title>NOTES</title>
	</head>
	<body>
		NOTES
	<br />
	<#list noteList as notes>
		<br />
		${notes.message!""}
	</#list>
	
	</body>
</html>
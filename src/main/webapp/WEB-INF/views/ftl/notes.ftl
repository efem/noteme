<#import "spring.ftl" as spring>
<html>
	<head>
		<meta charset="UTF-8">
		<title>NOTES</title>
	</head>
	<body>
	NOTES
	
	<#list noteList as notes>
		${notes.message!""}
	</#list>
	
	</body>
</html>
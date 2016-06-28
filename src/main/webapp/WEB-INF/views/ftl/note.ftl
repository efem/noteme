<#import "spring.ftl" as spring>
<html>
	<head>
		<meta charset="UTF-8">
		<title>NOTES</title>
	</head>
	<body>
	 <#if showNote??>${showNote.message!"dupa"}<#else>"brak notatki"</#if>
	
	
	</body>
</html>
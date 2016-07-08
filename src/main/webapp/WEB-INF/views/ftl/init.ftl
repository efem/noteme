<#import "spring.ftl" as spring>

<#-- MACRO for initializing html page structure -->
<#macro pageInit title>
<html>
	<head>
		<meta charset="UTF-8">
		<@setTitle title=title />
		<@importCss />
		<#nested>
	</head>
</#macro>

<#-- MACRO for creating html page structure -->
<#macro pageBody>
	<body>
		<#nested>
	</body>
</html>
</#macro>

<#macro setTitle title>
	<title>${title!""}</title>
</#macro>

<#macro importCss>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/style.css'/>"/>
</#macro>
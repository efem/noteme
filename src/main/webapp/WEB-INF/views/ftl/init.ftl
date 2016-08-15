<#import "spring.ftl" as spring>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

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

<#-- MACRO for listing roles-->
<#macro getRolemacro roles values>
	<#list values as singleRole>
		<input type="checkbox" name="userRoles" value="${singleRole.id!""}">${singleRole!""}<br >
	</#list>
</#macro>

<#macro setTitle title>
	<title>${title!""}</title>
</#macro>

<#macro importCss>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/style.css'/>"/>
</#macro>

<#macro linksMacro>
	<a href="/">MAIN PAGE</a> | <a href="user/login">LOGIN</a> | <a href="/register">REGISTER</a>
</#macro>
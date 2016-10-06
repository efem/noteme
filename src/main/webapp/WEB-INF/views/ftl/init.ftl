<#import "spring.ftl" as spring>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<#-- MACRO for initializing html page structure -->
<#macro pageInit title>
<html>
	<head>
		<meta charset="UTF-8">
		<@setTitle title=title />
        <@importBootstrap />
        <@importJQuery />
        <@importMyCss />
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

<#macro importMyCss>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/style.css'/>"/>
</#macro>

<#macro importBootstrap>
	<script src="<@spring.url '/resources/bootstrap/js/bootstrap.min.js'/>"></script>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/bootstrap/css/bootstrap.min.css'/>"/>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/bootstrap/css/bootstrap-theme.min.css'/>"/>
</#macro>

<#macro importJQuery>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</#macro>


<#macro linksMacro>
	<a href="/">MAIN PAGE</a> | <a href="user/login">LOGIN</a> | <a href="/register">REGISTER</a>
</#macro>
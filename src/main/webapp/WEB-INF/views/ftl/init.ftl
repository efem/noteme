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

<#-- MACRO for listing roles-->
<#macro getRolemacro role values>
	<select name="role_id">
	<#list values as singleRole>
		<option value="${singleRole.id!""}" <#if singleGenre == user.role>selected</#if>>${singleRole!""}</option>
	</#list>
	</select>
</#macro>

<#macro setTitle title>
	<title>${title!""}</title>
</#macro>

<#macro importCss>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/style.css'/>"/>
</#macro>
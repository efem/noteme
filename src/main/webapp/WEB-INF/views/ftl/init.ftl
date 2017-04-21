<#import "spring.ftl" as spring>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<#-- MACRO for initializing html page structure -->
<#macro pageInit title adminJS=0>
<html>
	<head>
		<meta charset="UTF-8">
		<@setTitle title=title />
				<@importJQuery />
				<#if adminJS == 1>
					<@importAdminJS />
				</#if>
				<@importBootstrap />
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

<#macro renderNaviBar>
<ul class="nav nav-pills">
  <li role="presentation"><a href="/noteme/">Home</a></li>
  <li role="presentation"><a href="user/register"><@init.spring.message "label.register" /></a></li>
  <li role="presentation"><a href="user/login">Login</a></li>
  <li role="presentation"><a href="admin/show">ADMIN</a></li>
  <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Language <span class="caret"></span></a>
    <ul class="dropdown-menu">
      <li><a href="?lang=en">EN</a></li>
      <li><a href="?lang=pl">PL</a></li>
    </ul>
  </li>
</ul>
</#macro>

<#-- MACRO for listing roles-->
<#macro getRolemacro roles values>
	<#list values as singleRole>
		<input type="checkbox" name="userRoles" value="${singleRole.id!""}">${singleRole!""}<br >
	</#list>
</#macro>

<#-- MACRO for listing ALL roles-->
<#macro getAllRoles roles values>
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

<#macro importAdminJS>
	<script src="<@spring.url '/resources/js/note-js.js'/>"></script>
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

<#import "init.ftl" as init />
<@init.pageInit title="HOME PAGE" />
<@init.pageBody>
<ul class="nav nav-pills">
  <li role="presentation" class="active"><a href="admin/showAdmin">ADMIN</a></li>
  <li role="presentation"><a href="user/register">Register</a></li>
  <li role="presentation"><a href="user/login">Login</a></li>
  <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Language <span class="caret"></span></a>
    <ul class="dropdown-menu">
      <li><a href="?lang=en">EN</a></li>
      <li><a href="?lang=pl">PL</a></li>
    </ul>
  </li>
</ul>
	<@init.spring.message code="label.webapp" /><br />
    <@init.spring.message "label.webapp" />

</@init.pageBody>
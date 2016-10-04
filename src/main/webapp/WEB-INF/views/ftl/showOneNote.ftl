<#import "init.ftl" as init />
<!DOCTYPE html>
<html>
    <head>
        <title>Hello jQuery</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="<@spring.url '/resources/js/note-js.js'/>"></script>
    </head>

    <body>

	    http://codetutr.com/2013/04/09/spring-mvc-easy-rest-based-json-services-with-responsebody/
	    <input type="submit" id="randomPerson" value="Get Random Person" /><br/><br/>
	    <div id="personResponse"> </div>
		CPATH: ${ctx.contextPath}
    </body>
</html>


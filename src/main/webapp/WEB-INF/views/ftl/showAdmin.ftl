<#import "init.ftl" as init />
<!DOCTYPE html>
<html>
    <head>
        <title>Hello jQuery</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="<@spring.url '/resources/js/note-js.js'/>"></script>
    </head>

    <body>

	    <input type="submit" id="showAllNotesBtn" value="All Notes" /><br/><br/>
	    <input type="submit" id="showOneNoteBtn" value="One Note" /><br/><br/>
	    <div id="dataLoad"> </div>

    </body>
</html>


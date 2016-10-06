<#import "init.ftl" as init />
<!DOCTYPE html>
<html>
    <head>
        <title>Hello jQuery</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="<@spring.url '/resources/js/note-js.js'/>"></script>
    </head>

    <body>
		<form id="noteByUsernameForm">
	      <label for="authorName">Author: </label><input name="authId" id="authorName" />
	      <input type="submit" value="Get Notes By Author" /> <br /><br/>
	    </form>
	    
	    <form id="userDetailsByUsernameForm">
	      <label for="authorNameForDetails">Author: </label><input name="aName" id="authorNameForDetails" />
	      <input type="submit" value="Get Author's Details" /> <br /><br/>
	    </form>
	    
	    <input type="submit" id="showAllNotesBtn" value="All Notes" /><br/><br/>
	    <input type="submit" id="showOneNoteBtn" value="One Note" /><br/><br/>
	    <div id="dataLoad"> </div>
		<div id="listLoad"> </div>
    </body>
</html>


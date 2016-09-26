<#import "init.ftl" as init />
<!DOCTYPE html>
<html>
    <head>
        <title>Hello jQuery</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="<@spring.url '/resources/js/note-js.js'/>"/>
    </head>

    <body>
        <div>
            <p class="note.id">The ID is </p>
            <p class="content">The content is </p>
        </div>
    </body>
</html>


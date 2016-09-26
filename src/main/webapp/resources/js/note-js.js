$(document).ready(function() {
    $.ajax({
        url: "http://localhost:7080/noteme/note/showOne"
    }).then(function(data) {
       $('.note.id').append(id);
       $('.content').append(note.content);
    });
});
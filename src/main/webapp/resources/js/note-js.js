$(document).ready(function() {
	$('#showAllNotesBtn').click(function() {
        $.getJSON('showAll ', function(note) {
        	$.each(note, function(i, field) {
				$('#dataLoad').append('<div id="divNote'+ i +'" >' + field.content + '</div>');
			});
        });
      });
	
	$('#showOneNoteBtn').click(function() {
        $.getJSON('showOne ', function(note) {
        	 $('#dataLoad').text(note.content);
        });
      });
});
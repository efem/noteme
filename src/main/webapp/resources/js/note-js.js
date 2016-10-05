$(document).ready(function() {
	
	$('#idForm').submit(function(e) {
        var personId = $('#personId').val();
        //alert(personId);
        $.getJSON('showByAuthor/' + personId, function(note) {
        	$('#dataLoad').empty();
      		$.each(note, function(i, field) {
      			$('#dataLoad').append('<div id="divNote'+ i +'" >' + field.content + '</div>');
      		});
        });
        e.preventDefault(); // prevent actual form submit
      });
	
	$('#showAllNotesBtn').click(function() {
        $.getJSON('showAll ', function(note) {
        	$('#dataLoad').empty();
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
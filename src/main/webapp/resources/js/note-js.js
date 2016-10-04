$(document).ready(function() {
	(function() {
		$.getJSON('showAll ', function(note) {
			$.each(note, function(i, field) {
				$('#personResponse').text(field.content + ', id ' + note.id);
			});
		});
	});
});

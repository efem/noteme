$(document).ready(function() {
	$('#randomPerson').click(function() {
        $.getJSON('showOne', function(person) {
          $('#personResponse').text(note.content + ', id ' + note.id);
        });
      });
});
$(document).ready(function() {
	$('#randomPerson').click(function() {
        $.getJSON('${request.requestObject.contextPath} ', function(person) {
          $('#personResponse').text(note.content + ', id ' + note.id);
        });
      });
});
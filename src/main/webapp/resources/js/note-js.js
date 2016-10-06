$(document).ready(function() {
	
	$('#noteByUsernameForm').submit(function(e) {
        var authorName = $('#authorName').val();
        //alert(personId);
        $.getJSON('showByAuthor/' + authorName, function(note) {
        	$('#dataLoad').empty();
        	if (jQuery.isEmptyObject(note)) {
        		$('#dataLoad').append("NOT FOUND");
        	} else {
	      		$.each(note, function(i, field) {
	      			$('#dataLoad').append('<div id="divNote'+ i +'" >' + field.content + '</div>');
	      		});
        	}
        });
        e.preventDefault(); // prevent actual form submit
      });
	
	
	$('#userDetailsByUsernameForm').submit(function(e) {
        var authorNameForDetails = $('#authorNameForDetails').val();
        //alert(authorNameForDetails);
        $.getJSON('showAuthorDetails/' + authorNameForDetails, function(user) {
        	$('#dataLoad').empty();
        	if (jQuery.isEmptyObject(user)) {
        		$('#dataLoad').append("NOT FOUND");
        	} else {
        		var table = $('<table></table>').addClass('foo');
        		var row = $('<tr></tr>').addClass('bar');
        		row.append('<td>' + user.username + '</td>');
        		row.append('<td>' + user.email + '</td>');
        		row.append('<td>' + user.regDate.getDate() + '</td>');
        		//table.append('<tr></tr>').text(user.username);
        		//table.append('<tr></tr>').text(user.email);
        		//table.append('<tr></tr>').text(user.regDate);
        		table.append(row);
        		$('#dataLoad').append(table);
 
	      	
        	}
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
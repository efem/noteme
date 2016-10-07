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
        		
        		var div = $('<div></div>').addClass('userDetailDiv');
        		var roles = '';
        		
        		$.each(user.roles, function( n, value ) {
      			  roles = roles + "|" + value.rolename;
      			});
        		
        		div.append('<p><span class="bold">Username: ' + user.username + '</span></p>');
        		div.append('<p><span class="bold">Email: ' + user.email);
        		div.append('<p><span class="bold">Reg Date: ' + user.regDate.year + '-' + 
        				getMonthFromName(user.regDate.month) + '-' + 
        				checkValueForLessThanTen(user.regDate.dayOfMonth) + ' ' + 
        				checkValueForLessThanTen(user.regDate.hour) + ':' + 
        				checkValueForLessThanTen(user.regDate.minute) + ':' + 
        				checkValueForLessThanTen(user.regDate.second));
        		
        		div.append('<p><span class="bold">Last login: ' + user.loginDate.year + '-' + 
        				getMonthFromName(user.loginDate.month) + '-' + 
        				checkValueForLessThanTen(user.loginDate.dayOfMonth) + ' ' + 
        				checkValueForLessThanTen(user.loginDate.hour) + ':' + 
        				checkValueForLessThanTen(user.loginDate.minute) + ':' + 
        				checkValueForLessThanTen(user.loginDate.second));

        		div.append('<p><span class="bold">Roles: ' + roles);
        		div.append('<p><span class="bold">Enabled: ' + user.enabled);

        		$('#dataLoad').append(div);
 
	      	
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
	
	function getMonthFromName($name) {
		var monthHash = {
			    JANUARY : '01',
			    FEBRUARY: '02',
			    MARCH: '03',
			    APRIL: '04',
			    MAY: '05',
			    JUNE: '06',
			    JULY: '07',
			    AUGUST: '08',
			    SEPTEMBER: '09',
			    OCTOBER: '10',
			    NOVEMBER: '11',
			    DECEMBER: '12'
			   };
		var monthNumber = monthHash[$name];
		
		return monthNumber;
	}
	
	function checkValueForLessThanTen($number) {
		var numberToReturn=$number;;
		if ($number < 10) {
			numberToReturn='0' + numberToReturn;
		}
		return numberToReturn;
	}
});
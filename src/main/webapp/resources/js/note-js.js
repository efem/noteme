$(document).ready(function() {

	$('#noteByUsernameForm').submit(function(e) {
        var authorName = $('#authorName').val();
        //alert(personId);
        $.getJSON('showByAuthor/' + authorName, function(note) {
        	$('#dataLoad').empty();
				if (!$.isArray(note) ||  !note.length ) {
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
        //alert('A');
        $('#dataLoad').empty();
        $.getJSON('showAuthorDetails/' + authorNameForDetails, function(user) {
        		var div = $('<div></div>').addClass('userDetailDiv');
        		var roles = '';

        		$.each(user.roles, function( n, value ) {
        			if (roles=='') {
        				roles = value.rolename;
        			} else {
        				roles = roles + "|" + value.rolename;
        			}

      			});
        		//roles = roles.substring(1);

        		div.append('<p><span class="bold">Username: ' + user.username + '</span></p>');
        		div.append('<p><span class="bold">Email: ' + user.email + '</span></p>');
        		div.append('<p><span class="bold">Reg Date: ' + user.regDate.year + '-' +
        				getMonthFromName(user.regDate.month) + '-' +
        				checkValueForLessThanTen(user.regDate.dayOfMonth) + ' ' +
        				checkValueForLessThanTen(user.regDate.hour) + ':' +
        				checkValueForLessThanTen(user.regDate.minute) + ':' +
        				checkValueForLessThanTen(user.regDate.second) + '</span></p>');

        		div.append('<p><span class="bold">Last login: ' + user.loginDate.year + '-' +
        				getMonthFromName(user.loginDate.month) + '-' +
        				checkValueForLessThanTen(user.loginDate.dayOfMonth) + ' ' +
        				checkValueForLessThanTen(user.loginDate.hour) + ':' +
        				checkValueForLessThanTen(user.loginDate.minute) + ':' +
        				checkValueForLessThanTen(user.loginDate.second) + '</span></p>');

						div.append('<p><span class="bold">Roles: ' + printRoles(roles) + '</span><input id="btnGetRoles" type="button" value="Edit" name="' + user.username + '" /></p><div id="testDiv"></div>');

						div.append('<p><span id ="userEnabled" class="bold">Enabled: ' + user.enabled + '</span></p>');
						
						div.append('<div><input id="btnToggleUser" type="button" value="' + setToggleBtnValue(user.enabled) +'" name="' + user.username + '" /></div>');

        		
			$('#dataLoad').append(div);

        }).error(function() { 
        	$('#dataLoad').append("NOT FOUND");
   		 	//alert('EMPTY');
        	});
        e.preventDefault(); // prevent actual form submit
      });

	$(document).on('click', '#btnToggleUser', function(e) {
		$.getJSON('toggleUser/' + $('#btnToggleUser').attr('name'), function(user) {
			$("#userEnabled").text("Enabled: " + user.enabled);
			$('#btnToggleUser').val(setToggleBtnValue(user.enabled))
		});
		e.preventDefault();
		});
	
	$(document).on('click', '#btnGetRoles', function(e) {
		$.getJSON('getRoles', function(roles) {
			alert('GET ROLES');
			var div = $('<div></div>').addClass('rolesAllDiv');
			
    		$.each(roles, function( n, value ) {
    			div.append('<input type="checkbox" name="userRoles" value="' + value.id +'">' + value.rolename + '<br >');
  			});
    		$('#testDiv').append(div);
		});
		e.preventDefault();
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

	function printRoles($roles) {
		var toExplode = $roles;
		var rolesToHtml = '';
		var arr = toExplode.split('|');
		$.each( arr, function( index, value ){
    	if (value == 'ADMIN') {
				rolesToHtml += ' <span class="label label-warning">ADMIN</span> ';
			} else if (value == 'MOD') {
				rolesToHtml += ' <span class="label label-info">MOD</span> ';
			} else if (value == 'USER') {
				rolesToHtml += ' <span class="label label-success">USER</span> ';
			}
		});

		return rolesToHtml;
	}
	
	function printCheckboxRoles($roles) {
		var toExplode = $roles;
		var rolesToHtml = '';
		var arr = toExplode.split('|');
		$.each( arr, function( index, value ){
    	if (value == 'ADMIN') {
				rolesToHtml += ' <span class="label label-warning">ADMIN</span> ';
			} else if (value == 'MOD') {
				rolesToHtml += ' <span class="label label-info">MOD</span> ';
			} else if (value == 'USER') {
				rolesToHtml += ' <span class="label label-success">USER</span> ';
			}
		});

		return rolesToHtml;
	}
	
	function setToggleBtnValue($value) {
		var enabled = $value;
		var btnValue = '';
		
		if (enabled) {
			btnValue = 'Disable';
		} else {
			btnValue = 'Enable';
		}	
		return btnValue;
	}
	
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
		var numberToReturn=$number;
		if ($number < 10) {
			numberToReturn='0' + numberToReturn;
		}
		return numberToReturn;
	}
});

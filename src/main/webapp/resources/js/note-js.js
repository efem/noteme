$(document).ready(function() {

	var userRoles = [];
	var userObject;
	var sessionUser;
	
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
        userRoles = [];
        $('#dataLoad').empty();
        $.getJSON('showAuthorDetails/' + authorNameForDetails, function(user) {
        		var div = $('<div></div>').addClass('userDetailDiv');
        		var roles = '';
        		userObject = user;
        		sessionUser = user;
        		alert('USS: ' + userObject.username);
        		$.each(user.roles, function( n, value ) {
        			//userRoles.push(value.rolename);
        			if (roles=='') {
        				roles = value.rolename;;
        			} else {
        				roles = roles + "|" + value.rolename;
        			}

      			});
        		//alert("U_R: " + userRoles);

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

						div.append('<p><span id = "listRoles" class="bold">Roles: ' + printRoles(roles) + '</span><input id="btnGetRoles" type="button" value="Edit" name="' + user.username + '" /></p><div id="rolesDiv"></div>');

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
		$('#rolesDiv').empty();
		$.getJSON('getRoles', function(roles) {
			var checked = '';
			var form = $('<form></form>');
			var sessionRoles = [];
			sessionRoles = getRolesNamesForUser(); //nie wypelnia
			alert('sessionRoles' + JSON.stringify(sessionRoles));
			alert('controllerRoles' + JSON.stringify(roles));
    		$.each(roles, function( n, role ) {
    			if(jQuery.inArray(role.rolename, sessionRoles) !== -1) { checked = 'checked';} else { checked = '';}
    			alert('role.rolename from controller: ' + role.rolename);
    			form.append('<input type="checkbox" name="userRoles[]" value="' + role.id +'" ' + checked +'>' + role.rolename + '<br >');
  			});
    		form.append('<input id="btnSaveRoles" type="button" value="Save" name="saveName" />');
    		form.append('<input id="btnCancelRoles" type="button" value="Cancel" />');
    		$('#rolesDiv').append(form);
		});
		e.preventDefault();
		});
	
	function getRolesNamesForUser() {
		alert('Username from getRolesNamesForUser: ' + sessionUser.username);
		userRoles = [];
		$.getJSON('getRolesForUser/' + sessionUser.username, function(rls) {
			alert('ControllernROLES' + JSON.stringify(rls));
			$.each(rls, function( n, value ) {
				alert('Rola z kontrolera dla sessionUser: ' + value.rolename);
				userRoles.push(value.rolename);
			});
		}).error(function() { 
   		 	alert('EMPTY getRolesNamesForUser');
        });
		return userRoles;
	}
	$(document).on('click', '#btnCancelRoles', function(e) {
		$('#rolesDiv').empty();
	});
	
	$(document).on('click', '#btnSaveRoles', function(e) {
		//alert('CLICK SAVE');
		var checkedRoles = { 'userRoles[]' : []};

		$("input:checked").each(function() {
			checkedRoles['userRoles[]'].push($(this).val());
		});

		$.post('saveUserForRoles/' + userObject.username, checkedRoles, function(user) {
			$('#listRoles').empty();
			$('#listRoles').append("Role: " + printRoles(extractRoles(user)));
		});	
		$('#rolesDiv').empty();
		//e.preventDefault();
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


	
	function extractRoles($user) {
		var gotUser = $user;
		var roles = '';
		$.each(gotUser.roles, function( n, value ) {
			if (roles=='') {
				roles = value.rolename;;
			} else {
				roles = roles + "|" + value.rolename;
			}
		});
		return roles;
	}

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

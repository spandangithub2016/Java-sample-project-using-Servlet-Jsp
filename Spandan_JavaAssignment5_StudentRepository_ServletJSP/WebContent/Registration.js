function ValidateContactForm() {

	var _fname = document.ContactForm.fullname;
	var _uname = document.ContactForm.username;
	var _psw = document.ContactForm.password
	var _phn = document.ContactForm.phone;
	var _gender = document.ContactForm.gender;
	var _country = document.ContactForm.country;
	var _cname = document.ContactForm.course;

	if (_fname === null) {
		window.alert("Your Full Name should not be empty");
		_fname.focus();
		return false;
	}
	if (_uname === null) {
		window.alert("Your Username should not be empty");
		_uname.focus();
		return false;
	}

	var regexAsPass = /^[A-z]*[0-9]*[a-z]*[A-z]+[0-9]*[a-z]+[0-9]*@[A-z]*[a-z]*[0-9]+[A-z]*[a-z]*$/;
	if (!_psw.value.match(regexAsPass)) {

		window.alert("Password Should Contain One Caps, one Small letter, One @ and one digit (0-9)");
		_psw.focus();
		return false;
	}

	var phoneno = /^\d{10}$/;
	if (!_phn.value.match(phoneno)) {

		window.alert("Please enter Valid phone number");
		_phn.focus();
		return false;
	}

	if (_gender.selectedIndex < 1 || _gender.value == "--Select--") {
		window.alert("Please select your Gender...");
		_gender.focus();
		return false;
	}

	/*
	 * if (_email.value == "") { window.alert("Please enter a valid e-mail
	 * address..."); _email.focus(); return false; } if
	 * (_email.value.indexOf("@", 0) < 0) { window.alert("Please enter a valid
	 * e-mail address..."); _email.focus(); return false; } if
	 * (_email.value.lastIndexOf(".", 0) < 0) { window.alert("Please enter a
	 * valid e-mail address..."); _email.focus(); return false; }
	 */
	/*
	 * var posOfAtTheRate = _email.value.indexOf("@"); var posOfDot =
	 * _email.value.lastIndexOf(".");
	 * 
	 * if(posOfAtTheRate<3 || posOfAtTheRate+2>_email.value.length ||
	 * posOfDot+2>_email.value.length || posOfAtTheRate<0 || posOfDot<1 ||
	 * posOfDot<posOfAtTheRate ) { window.alert("Please enter a valid e-mail
	 * address..."); _email.focus(); return false; }
	 */
	if (_cname.selectedIndex < 1 || _cname.value == " ") {
		window.alert("Please Enter Course Name as you want ");
		_cname.focus();
		return false;
	}

	if (_country.selectedIndex < 1 || _country.value == "--Select--") {
		window.alert("Please select your Country...");
		_country.focus();
		return false;
	}

	return true;
}

function delivery(x) {

	var coursename = x.value;

	if (coursename === "Msc") {

		ContactForm.cid.value = "MSC101";
		ContactForm.fees.value = "30,000 (INR)";
		ContactForm.duration.value = "2 Years";
	} else if (coursename === "MCA") {
		ContactForm.cid.value = "MCA102";
		ContactForm.fees.value = "45,000 (INR)";
		ContactForm.duration.value = "3 Years";
	} else if (coursename === "M.Tech") {
		ContactForm.cid.value = "MT103";
		ContactForm.fees.value = "20,000 (INR)";
		ContactForm.duration.value = "2 Years";
	} else if (coursename === "Phd") {
		ContactForm.cid.value = "PHD104";
		ContactForm.fees.value = "50,000 (INR)";
		ContactForm.duration.value = "5 Years";
	} else {
		ContactForm.cid.value = "";
		ContactForm.fees.value = "";
		ContactForm.duration.value = "";
	}
}

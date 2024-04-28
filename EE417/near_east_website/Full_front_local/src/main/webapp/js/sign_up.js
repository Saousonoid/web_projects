// Force requirement of field 
function validateRequired(element) {
    if (!element.value) {
        showError(element);
        return false;
    }
    return true;
}

// for first and last names combined they should not be longer than 40 characters in total. also only letter characters are allowed (including non latin scripts)
function validateNames(fname,lname) {
    var fullname=fname.value.trim()+' '+lname.value.trim();
    if (fullname.length>40){return false;}
    var onlyLetters = /^[^\d!@#$%^&*()_+={}\[\]:;<>,.?~\\/-]+$/u;
    return (onlyLetters.test(fname.value) && onlyLetters.test(lname.value));
}
// Username cannot have special characters with the exception of _
function validateUsername(username) {
    var usernameRegex = /^[a-zA-Z0-9_]+$/;
    return usernameRegex.test(username.value);
}
// Password and confirmation must match. Also the password needs to contain a minimum of 1 uppercase letter , 1 lower case and 1 special character with min length of 8
function validatePassword(password, confirm) {
  if (password.value !== confirm.value) {
        displayMainError("Passwords don't match");
        return false;}
  else{
var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[\w@$!%*?&\s]*$/;
    if( !passwordRegex.test(password.value)){
    displayMainError("Your password is not strong enough. Make sure to use at least 1 upper-case character, 1 lower-case character, and 1 special character");
    return false;
  }
  }
  return true;

}
// phone number must have one of the accepted international formulas and be between 8 and 12 digits in length (+ is allowed)
function validatePhoneNo(phone)
{
  var phonegx = /^\+?([0-9]{2})\)?([0-9]{4})([0-9]{4,8})$/;
            return phonegx.test(phone.value);}


// Main error prompt function, for specific validation problems
function displayMainError(errorMessage) {
    var mainError = document.getElementById('mainError');
    mainError.textContent = errorMessage;
}

// Required field error function
function showError(element) {
    element.classList.add('error');
    var label = document.querySelector('#' + element.id + '_lbl');
    label.classList.add('error-required');
}
// reset all errors messages
function resetErrors() {
    displayMainError("");
    var elements = document.querySelectorAll('.error, .error-required');
    elements.forEach(function (element) {
        element.classList.remove('error', 'error-required');
    });
} 
 
 
//  the Main validation function that calls all others.
 function validateForm(event) {
            event.preventDefault(); // Prevents the form from submitting by default

            // Reset previous errors
            resetErrors();

            // Validation logic
            
            var fname = document.getElementById('firstName');
            var lname = document.getElementById('lastName');
            var username = document.getElementById('username');
            var email = document.getElementById('email');
            var password = document.getElementById('password');
            var confirmPassword = document.getElementById('confirmPassword');
            var role = document.getElementById('role');
            var phone = document.getElementById('phone');

            // Get required result
            var val_fname=validateRequired(fname);
            var val_lname=validateRequired(lname);
            var val_user=validateRequired(username);
            var val_email=validateRequired(email);
            var val_password=validateRequired(password);
            var val_confirm=validateRequired(confirmPassword);
            var val_role=validateRequired(role);
            var val_phone=validateRequired(phone);
            var isValid = val_fname && val_lname && val_user && val_email && val_password && val_confirm  && val_role && val_phone;

            // in case all required fields were successful perform field-specific validation
            if(isValid){
            isValid = validateNames(fname,lname);
                if (!isValid) {
                    displayMainError("Full Name too Long or Invalid Use of Non-Letters in First/Last Name");
                } }
            // Additional type-specific checks
            if (isValid) {
                isValid = validateUsername(username);
                if (!isValid) {
                    displayMainError("Invalid use of characters in Username");
                }
            }

            if (isValid) {
              
                isValid = validatePassword(password, confirmPassword);
            }

            if (isValid) {
                isValid=validatePhoneNo(phone);
                if (!isValid) {
                    displayMainError("Invalid Phone Number format!");
                }
            }
            if (!isValid) {
                return false;
            }
			// Create a request object with user data
			let request = {
			    fname: fname.value,
			    lname: lname.value,
			    username: username.value,
			    email: email.value,
			    password: password.value,
			    phone: phone.value,
			    roleId: role.value  // Assuming #role is an input element with the role ID
			};
			
			// Send a POST request to add a user
			fetch('http://localhost:8081/add/user', {
			    method: 'POST',
			    headers: {
			        'Content-Type': 'application/json',
			    },
			    body: JSON.stringify(request),
			})
			.then(response => {
			    // Check response status code
			    if (response.status === 200) {
			        console.log('User added successfully');
			        window.location.href="login.html"
			    } else {
			        throw new Error('Bad Request: Improper syntax was given');
			    }
			})
			.catch(error => {
			    console.error('Error:', error);
			});
		
			return true;
}
    






	

        
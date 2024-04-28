
$(document).ready(function() {
	//If use has a user token, redirect to home page
    if (localStorage.getItem('token-info')) {
      window.location.href = "index.html"
    }
    //Upon submission of user data, authenticate user information in the server, when passed, retrieve response user data and create user token
    $('#my_login').submit(function(e) {
     e.preventDefault();
     e.stopPropagation();
     success = do_login();
     if (success) {
      window.location.href="index.html";
     } else {
      alert("Invalid usernam/password")
     }
    });
   });
   
   function do_login() {
   
    var email = $("#email").val();
    var pass = $("#password").val();
    let result = false;
    if (email != "" && pass != "") {
    // $("#loading_spinner").css({"display": "block"});
     $.ajax({
      type: 'post',
      async: false,
      cache: false,
      url: 'http://localhost:8081/login',
      xhrFields: {
       withCredentials: true
      },
      headers: {
       'Accept': 'application/json, text/plain, */*',
       'Content-Type':'application/x-www-form-urlencoded',
       
      },
      data: {
       email: email,
       username: email,
       password: pass
      },
      crossOrigin: true,
      
      success: function(data){
       localStorage.setItem('token-info', JSON.stringify(data));
       result = true;
      },
       error: function (data) {
        result = false;
       }
     });
    }
    return result;
   }
   
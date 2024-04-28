$(document).ready(function() {
	//Generate options menu using loaded nav html
	Spring_url="http://localhost:8081" ;
          
        
    //Check for user credentials if logged in proceed otherwise return to login page, applies to all pages except login and signup
    if (!checkdLoggedInUser()) {
        window.location.href = "login.html"
        return;
    }
    
    else{
		
        //Generate header using loaded header html
    $.get("header.html", function(data){
        $("#header_placeholder").replaceWith(data);});
       //Generate footer using loaded footer 
    $.get("footer.html", function(data){
        $("#footer_placeholder").replaceWith(data);});  
        
        $.get("nav_menu.html", function(data){
        $("#menu_placeholder").replaceWith(data);
        
        user=localStorage.getItem('token-info');
    	if (user) {
        var userData = JSON.parse(user);
        var priv = userData.role.name;
        setRoleBasedVisibility(priv);
    }
        });
        
        
		
	}
    // Retrieve user information for validation and role access control
    

    function setRoleBasedVisibility(role) {
        // Mapping of roles per user type
        var roleDict = {
            "WRITER": ["#manage"],
            "PREMIUM": ["#add_article", "#article_list", "#manage"],
            "USER": ["#add_article", "#article_list", "#premium_content", "#manage"]
        };

        // Show elements based on role
        if (roleDict.hasOwnProperty(role)) {
			
            roleDict[role].forEach(function(element) {
                $(element).remove();
            });
        }
    }



	//Logout button triggers POST to authenticate logout in Server and remove user non-persistent tokens
$(document).on('click', '#logout', function(e) {
    e.preventDefault();
    $.ajax({
        url: "http://localhost:8081/logout",
        type: 'POST',
        xhrFields: {
            withCredentials: true
        },
        crossOrigin: true,
        success: function(){
            localStorage.removeItem('token-info');
            $('body').empty();
            window.location.href = "login.html";
        },
        error: function (data) {
            console.log(data);
        }
    });
});





});






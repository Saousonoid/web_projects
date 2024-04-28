window.getRole =function(blacklist) {
	
	$(document).ready(function() {

	 user=localStorage.getItem('token-info');
    	if (user) {
        var userData = JSON.parse(user);
        var priv = userData.role.name;
		if(blacklist.has(priv)){
		      window.location.href = "index.html";}

	}
	
	
	});
}


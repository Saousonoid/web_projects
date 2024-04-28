$(document).ready(function () {
    // Initialize accordion for the ArticleJSON element
    $("#ArticleJSON").accordion({ header: "h4", collapsible: true, active: false, autoHeight: true });

    // Handle form submission
    $("#ArticleForm").submit(function (event) {
        event.preventDefault(); // Prevent default form submission behavior
        $("#ArticleJSON").empty(); // Clear previous content from the ArticleJSON element
        // Fetch articles from the server
        fetch("http://localhost:8081/articles", {
            method: "GET",
        	credentials: 'include',
            headers: { 'Content-type': 'application/json' }
        })
        .then(response => {
            if (response.ok) {
                return response.json(); // Parse response body as JSON
            } else {
                throw new Error('Failed to fetch articles');
            }
        })
        .then(data => {
            // Create tags from retrieved articles data
            $.each(data, function (i, item) {
                // Generate unique div id for userAccordion
                var userAccordionId = 'UserJSON_' + (i + 1);

                // Append article information to the ArticleJSON element
                $("#ArticleJSON").append(
                    '<h4> Article #' + (i + 1) + '</h4>' +
                    '<div>' +
                    '	 <p>Title: ' + item.title +
                    '<br><p> Body: ' + item.body +
                    '<br><p> Tags: ' + item.tags +
                    '<br><p> Directory: ' + item.webpageId +
                    '<div id="' + userAccordionId + '" class="UserJSON">UserId: ' + item.userId + '</div>'
                );

                // Initialize accordion for this user
                $("#" + userAccordionId).accordion({ collapsible: true, active: false, autoHeight: true });
            });

            // Refresh the accordion for the ArticleJSON element
            $('#ArticleJSON').accordion("refresh");
        })
        .catch(error => {
            console.error('Error:', error); // Log any errors that occur during fetching
        });
    });


    // Add click event listener to elements with class "UserJSON"
    $(document).on("click", ".UserJSON", function() {
		var state=$(this).find(".userAccordion");
		//collapse accordion if it's open
		if(state.length>0){
        state.remove();
        $(this).accordion("refresh");
        $('#ArticleJSON').accordion("refresh");
		}
		else{
        var userIdValue = $(this).text().replace("UserId: ", "").trim();
        userIdValue = parseInt(userIdValue);
	//Pass userId as path parameter to get User data
        fetch(`http://localhost:8081/users/${userIdValue}`, {
            method: "GET",
            credentials: 'include',
            headers: {'Content-type': 'application/json'}
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Failed to fetch user data');
            }
        })
        .then(userData => {
            // Append user data to the accordion section
            $(this).append(
                '<div class="userAccordion">' +
                '<p> First Name: ' + userData.fname + '</p>' +
                '<br><p> Last Name: ' + userData.lname + '</p>' +
                '<br><p> Username: ' + userData.username + '</p>' +
                '<br><p> Email: ' + userData.email + '</p>' +
                '<br><p> Password: ' + userData.password + '</p>' +
                '<br><p> Phone: ' + userData.phone + '</p>' +
                '<br><p> Role:' + userData.role.name + '</p>' +
                '</div>'
            );

            // Refresh the accordion after appending the new content
            $(this).accordion("refresh");
            $('#ArticleJSON').accordion("refresh");
        })
        .catch(error => {
            console.error('Error:', error);
        });
        }
    });
});

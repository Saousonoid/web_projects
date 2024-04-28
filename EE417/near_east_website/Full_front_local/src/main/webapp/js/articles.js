document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("ArticleForm").addEventListener("submit", function (event) {
      event.preventDefault();
      var token = localStorage.getItem("token-info");
  // Sending a GET request to retrieve articles.json
  	fetch("http://localhost:8081/articles", {
		
                method: "GET",
                            credentials: 'include',

                headers: {'Content-type': 'application/json',
                
                }, })
   .then(response => {

	//Success return code
        if (response.status === 200) {
	        console.log('Loading Successful');
	        return response.json();
	    } 
	    else {
	//Failure return code
	        throw new Error('Bad Request, Improper syntax was given');
	    } 
        })
        
    //Add JSON data to table
   .then(data => {
        SetTableInfo(data); // Call SetTableInfo with the received data
    })
    .catch(error => {
        console.error('Error:', error);
    });

    // Function to display dynamic inputs in the table
    function SetTableInfo(articles) {
      var tableBody = document.getElementById("FormTable").getElementsByTagName("tbody")[0];
      tableBody.innerHTML = ""; // Clear existing rows
  
      // Iterate over stored articles and append rows to the table
      for (var i = 0; i < articles.length; i++) {
        var article = articles[i];
        var row = tableBody.insertRow(tableBody.rows.length);
        row.insertCell(0).innerText = article.title;
        row.insertCell(1).innerText = article.userId;
        row.insertCell(2).innerText = article.body;
        row.insertCell(3).innerText = article.tags;
        row.insertCell(4).innerText = article.webpageId;
      }
    }
 
     });
   
  });
  
  
  
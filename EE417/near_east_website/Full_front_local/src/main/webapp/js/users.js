document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("userForm").addEventListener("submit", function (event) {
      event.preventDefault();
  
  	fetch("http://localhost:8081/users", {
		
                method: "GET",
                credentials: 'include',
                headers: {'Content-type': 'application/json',}, })
   .then(response => {
        if (response.status === 200) {
	        console.log('Loading Successful');
	        return response.json();
	    } 
	    else  {
			
	        throw new Error('Bad Request, Improper syntax was given');
	    } 
        })
        
        
   .then(data => {
        SetTableInfo(data); // Call SetTableInfo with the received data
    })
    .catch(error => {
        console.error('Error:', error);
    });

    // Function to display dynamic inputs in the table
    function SetTableInfo(users) {
      var tableBody = document.getElementById("FormTable").getElementsByTagName("tbody")[0];
      tableBody.innerHTML = ""; // Clear existing rows
  
      // Iterate over stored users and append rows to the table
      Object.keys(users).forEach(key => {
        var row = tableBody.insertRow(tableBody.rows.length);
        var user = users[key];
        row.insertCell(0).innerText = user.id;
        row.insertCell(1).innerText = user.fname;
        row.insertCell(2).innerText = user.lname;
        row.insertCell(3).innerText = user.username;
        row.insertCell(4).innerText = user.email;
        row.insertCell(5).innerText = user.password;
        row.insertCell(6).innerText = user.phone;
        row.insertCell(7).innerText = user.roleId;

      }) }
  
    // Display initial dynamic inputs on page load
    SetTableInfo(JSON.parse(localStorage.getItem("users")) || []);
     });
   
  });
  
  
  
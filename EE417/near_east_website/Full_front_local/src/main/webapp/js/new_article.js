
// Dirval is a Global variable to get selected input from directory drop down list 
var Dirval="";
var isUser;
// Title validation where the number of characters should not be less than 1o or more than 150
function validateTitle() {
    var title = document.getElementById("title");
    var maxTitleLength = 150;

    if (title.value.length > maxTitleLength ||title.value.length<10 ) {
        // Change text box border to red for error
      title.style.border = "1px solid red";
      return false;
    } else {
      title.style.border = "1px solid #ccc";
      return true;
    }
  }

//   Count how many words are in the input text
  function Countwords(){

    var body = document.getElementById("body");
    // Split into list of words  and return number with space as the delimter
    var wordCount = body.value.split(/\s+/).filter(function(word) {
      return word.length > 0;
    }).length;
    return wordCount;

  }
//   Minimum words 20 and max is 100, display the number of words on the wordCountDisplay and return false when count is not adequate
  function validateWordCount(){
    var minWordCount = 20;
  var maxWordCount = 100;
  var wordCount=Countwords();
  if(wordCount>100){wordCount=100;}
  document.getElementById("wordCountDisplay").innerHTML = "Min: 20, Max: 100 (words)<br><br>" + wordCount + "/100";
  if (wordCount < minWordCount ) {
    // red border for too few words
    body.style.border = "2px solid red";
    return false;
  }  
    else if(wordCount >=maxWordCount){
            // green border for too many words

        body.style.border = "2px solid green";
    return false;

    }
    else{
    body.style.border = "1px solid #ccc";
    return true;
  }
  }


//Return a single string of hashtags, basically throw out any non tagged words
  function extractTags() {
    var tags = document.getElementById("tags");
    var tags = tags.value.match(/#\w+/g);
  
    var tags_lbl = document.getElementById("tags_lbl");
    if(tags!=null){
    var taglst = tags.join(', ');
    tags_lbl.innerText = taglst;
  
  }
    return tags;
  }
  
  
  function checkValue()
{
	isUser= $("#userId").val();
	
	
}
// Perform filtering of the available directories list by matching input with the list elements 
function filterFunction() {
  var input, filter, i;
  input = document.getElementById("webpage");
  filter = input.value.toUpperCase();
  div = document.getElementById("myDropdown");
  
  p  = div.getElementsByTagName("div");
  for (i = 0; i < p.length; i++) {
    txtValue = p[i].textContent || p[i].innerText;
    // show result of filtering when matching happens otherwise hide the element
    if (txtValue.toUpperCase().indexOf(filter) > -1 && filter!="") {
        p[i].style.display = "block";
    } else {
        p[i].style.display = "none";
    }
  }
} 
   



// Set the value of the input based on the clicked option from the dropdown list
function selectItem(item) {
    var input = document.getElementById("webpage");
    input.value = item.textContent || item.innerText;
    if(input.value!=null){
    // assign selected value to dirval for later validation and storage
    Dirval=input.value;}
    var dropdownContent = document.getElementById("myDropdown");
    var items = dropdownContent.getElementsByTagName("div");
    // After selection hide all options
    for (var i = 0; i < items.length; i++) {
        items[i].style.display = "none";
    }
}


// Validate all previous inputs
function validateForm() {
    var isFormValid = true;
//   Check that title and body have the right length, and that at least one tag was used and one option from the dropdown was selected
    var   title = validateTitle();
    var   paragraph = validateWordCount();

    if (isUser==null ||!title ||!paragraph|| extractTags()==null || Dirval.length==0){
      isFormValid = false;
  
  }
   return isFormValid;
}

  // this is a 2-listener function.
  //The first listener guarantees that the second listener embedded in it does not run before the complete loading of the DOM and HTHML elements of the webpage
//The second is a submit listener that awaits the submit button to validate the form and when successful, append the newly created article row to the JSON local storage file
  document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("ArticleForm").addEventListener("submit", function (event) {
      event.preventDefault();
  
      if (validateForm()) {
        // Retrieve all 4 values with the key being the title of the article
        var title = document.getElementById("title").value;
        var articleBody = document.getElementById("body").value;
        var tags = document.getElementById("tags").value;
        var directory = Dirval;
  
        // Parse form data as an object
        var formData = {
          title: title,
          body: articleBody,
          tags: tags,
          userId:isUser,
          webpageId: directory
        };
        // Sending a POST request to add an article
  		fetch('http://localhost:8081/add/article', {
         method: 'POST',
                     credentials: 'include',

            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData) , 
        })// Sending form data in JSON format


        .then(response => {
        if (response.ok) {
	        console.log('Article added to Server Successfully');
	        window.location.href="new_article.html";
	    } 
	    else  {
	        throw new Error('Bad Request, Improper syntax was given');
	    } 
        })
        .catch(error => {
            // Handle errors
            console.error('Error:', error);
        });
        } 
        else {
				        throw new Error("Form validation failed. Please correct errors before submitting.");
      }
    });
   
  });
  

  
  
  
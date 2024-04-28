function toggleMenu(el){
				localStorage.removeItem('token-info');

        // active reveals the menu and initiate the overlay animation
            document.getElementById('menu').classList.toggle('active');
            document.getElementById('overlay').classList.toggle('active');
                
                
            // animate rotates the arrow character for list expansion effect 
            el.classList.toggle("animate");

        }
        //   Function to expand dropdown option
        function unfold(el){
            var dropdown=el.parentNode;
            var dropdownContent = dropdown.querySelector('.dropdown-content');
            // toggle between visible and hidden based on the current state
                dropdownContent.style.display = (dropdownContent.style.display === 'block') ? 'none' : 'block';
                dropdownContent.classList.toggle('active');
        
            el.classList.toggle("unfolded");

        }
        



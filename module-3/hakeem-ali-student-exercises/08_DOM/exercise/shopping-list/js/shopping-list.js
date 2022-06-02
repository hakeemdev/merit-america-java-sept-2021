// add pageTitle
//pageTitle: {string} This should be set to 'My Shopping List'
let pageTitle = 'My Shopping List';
// add groceries
// groceries: {Array} This should be an array of 10 items for your shopping list. The items in the array can be strings.
let groceries = [
  'Milk', 'Eggs', 'Bread', 'Butter', 'Orange Juice', 'Sugar', 'Salt', 'Cheese', 'Cereal', 'Lemons'
];
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const heading = document.getElementById('title')
  heading.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {

  const ul = document.getElementById('groceries');

  for (i = 0; i < groceries.length; i++) {
    let li = document.createElement('li');
    li.innerText = groceries[i];
    ul.appendChild(li);
  }
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
 const allListItems = document.querySelectorAll('li');
 
 for (i = 0; i < allListItems.length; i++) {
   allListItems[i].classList.add('completed');
 }
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});

let currProblem = 1;  // problem being showed to player
let currScore = 0; // current score of player
let answer;

// function to update the score of user and get the next question
function updateScoreAndQuestion() {
  let problem = document.getElementsByClassName("currentProblem")[0];
  problem.innerText = currProblem.toString();
  let score = document.getElementsByClassName("currentScore")[0];
   // show current score of player
  score.innerText = currScore.toString();
  // if number of question currently being shown is less than or equal to 10
  if (currProblem <= 10) {
    // show next question by calling the newProblem function
    newProblem();
  } else {
    let hide = document.querySelectorAll(".show-hide")
    hide.forEach((element) => {
      element.style.display = "none";
      // set current problem number to 10
      currProblem = 10;
      problem.innerText = currProblem.toString();
    });
  }
}


// function to start the game
function start() {
  let answers = document.querySelectorAll("li");
  answers.forEach((element) => {
    // when any option of the questions are clicked
    element.addEventListener("click", (event) => {
      // get the clicked option
      let choice = element.innerText;
      // if clicked option's text matches the answer, increase the user score by 1
      if (choice.toString() === answer.toString()) {
        currScore++;
      }
      // after score update, increase the problem number by 1 (so that next question can be shown)
      currProblem++;
      // updates the question and score of user by calling the updateScoreAndQuestion function
      updateScoreAndQuestion();
    });
  });
}

// function to show a new question
function newProblem() {
  //picks a number between 1 and 10
  let left_operand = Math.floor(Math.random() * Math.floor(10));
  let right_operand = Math.floor(Math.random() * Math.floor(10));
  // calculate answer by multiplying both numbers
  answer = left_operand * right_operand;
  // passses both left and right operands within an array
  updateDisplayProblem([left_operand, right_operand]);
}

// function called updateDisplayProblem that takes an array having both numbers of the question
function updateDisplayProblem(operands) {
  let displayProblem = document.getElementsByClassName("expression show-hide")[0];
  displayProblem.innerText = operands[0] + " * " + operands[1];
  let answers = document.querySelectorAll("li");
  let possibleAnswers = [];
  possibleAnswers.push(operands[0] * operands[1]);
  // run a while loop to get the 4 options of a single question  
  while (possibleAnswers.length < 4) {
    let choice = Math.floor(Math.random() * Math.floor(81));
    if (!possibleAnswers.includes(choice)) {
      possibleAnswers.push(choice);
    }
  }
  possibleAnswers = possibleAnswers.sort(function (a, b) {
    return Math.random() - 0.5;
  });
  // place all the 4 options into the li 
  for (let i = 0; i < answers.length; i++) {
    answers[i].innerText = possibleAnswers[i];
  }
}

// Run the code on web page load
document.addEventListener("DOMContentLoaded", (event) => {
  start();
  newProblem();
  let startOver = document.getElementById("btnStartOver");
  // resets score and sets problem to 1
  startOver.addEventListener("click", (event) => {
    currProblem = 1;
    currScore = 0;

    // updates score and gives out new question
    // Call the updateScoreAndQuestion and newProblem functions
    updateScoreAndQuestion();
    newProblem();
    let show = document.querySelectorAll(".show-hide");
    show.forEach((element) => {
      element.style.display = "block";
    });
  });
});
export default Function;
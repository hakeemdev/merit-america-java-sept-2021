let clickedCorrectAnswer = false;
let x = 0;
let y = 0;
let correctAnswer = 0;
let answers = [correctAnswer, getRandomNumber(81), getRandomNumber(81), getRandomNumber(81)];

/**
* Utility function to generate a random number based on max
* @param {number} max
*/
 function getRandomNumber(max) {
    return Math.floor(Math.random() * Math.floor(max));
}

/**
* Utility function to shuffle the items in an array
* @param {object} arr
*/
function shuffleArray(arr) {
    return arr.sort(function (a, b) { return Math.random() - 0.5 })
}

/**
 * Generates the problem set
 */

function generateMathProblem() {
    x = getRandomNumber(9);
    y = getRandomNumber(9);
    correctAnswer = x * y;
    answers = [correctAnswer, getRandomNumber(81), getRandomNumber(81), getRandomNumber(81)];
    const currentProblem = document.querySelector(".expression")
    currentProblem.innerText = x + " * " + y;
    generateAnswers();
}

/**
* Generates answer array
*
*/
function generateAnswers() {
const ul = document.querySelector('ul')
    shuffleArray(answers);
    answers.forEach((answer) => {
        const li = document.querySelector('li')
        li.innerText = answer;
        ul.appendChild(li);
    })
}


/**
 * Captures an answer click and updates the score, problem number and generates a new problem set
 */

function clickAnswer(event) {
    const answerChoice = parseInt(event.target.textContent);

    const currentScore = document.querySelector('.currentScore')
    const problemNumber = document.querySelector('.currentProblem')
    const showHideContent = document.querySelectorAll('.show-hide')

    if (answerChoice == correctAnswer) {
        if (problemNumber.innerHTML < 10) {
            problemNumber.innerHTML = parseInt(problemNumber.textContent) + 1;
            currentScore.innerHTML = parseInt(currentScore.textContent) + 1;
            generateMathProblem();
        } else if (problemNumber.innerHTML = 10) {
            currentScore.innerHTML = parseInt(currentScore.textContent) + 1;
            toggle(showHideContent);
        }
    } else {
        if (problemNumber.innerHTML < 10) {
            problemNumber.innerHTML = parseInt(problemNumber.textContent) + 1;
            generateMathProblem();
        } else if (problemNumber.innerHTML = 10) {
            toggle(showHideContent);
        }
    }
}

/**
 * Toggles the visibility of a chosen section of elements
 * @param {*} elements 
 * @param {*} specifiedDisplay 
 */

function toggle (elements, specifiedDisplay) {
    let element, i;

    elements = elements.length ? elements : [elements];
    for (i = 0; i < elements.length; i++) {
        element = elements[i];
        if(isElementHidden(element)) {
            element.style.display = '';

            if (isElementHidden(element)) {
                element.style.display = specifiedDisplay || 'block';
            }
        } else {
            element.style.display = 'none';
        }
    }
    function isElementHidden (element) {
        return window.getComputedStyle(element, null).getPropertyValue('display') === "none";
    }
} 

/**
 * Functionality for the "Start Over" button
 */
function startOver() {
    const currentScore = document.querySelector('.currentScore')
    const problemNumber = document.querySelector('.currentProblem')
    const showHideContent = document.querySelectorAll('.show-hide')

    if (problemNumber.innerHTML == 10) {
        toggle(showHideContent)
    }

    generateMathProblem()
    currentScore.innerHTML = 0;
    problemNumber.innerHTML = 1;
}

document.addEventListener("DOMContentLoaded", () => {
    
    generateMathProblem()

    const answerSet = document.querySelectorAll('li')
 
    answerSet.forEach((answer) => {
        answer.addEventListener('click', (event) => {
            clickAnswer(event);
        })
    })

    const startOverbutton = document.getElementById('btnStartOver')

    startOverbutton.addEventListener('click', () => {
        startOver()
    })
})
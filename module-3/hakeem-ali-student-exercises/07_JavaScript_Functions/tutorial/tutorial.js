/**
 * Create a function called turnOn.
 *
 * This function should return the boolean true.
 *
 * @returns {boolean} true
 */

function turnOn() {
  return true;
}

/**
 * Create a function called returnsName.
 *
 * This function should return your name.
 *
 * @returns {string} your name
 */

function returnsName() {
  return "Hakeem";
}

/**
 * Create a function called returnGivenParameter that takes a
 * single parameter and then returns it.
 *
 * @param {any} thing any value
 * @returns {any} the parameter that we were given
 */

function returnGivenParameter(thing) {
  return thing;
}

/**
 * Now create a function called takeOptionalParameter
 * that takes a single parameter and
 * returns it again. But if a parameter is not given, default
 * the value to 0.
 *
 * @param {any} [thing=0] any value
 * @returns {any} the parameter given, or 0 if none is given
 */

function takeOptionalParameter(thing = 0) {
  return thing;
}

/**
 * Write an anonymous function in the filter that will
 * remove all numbers that are double digits.
 *
 * Remember that you want to write an anonymous function
 * that returns true if we want to keep the element and
 * false if we don't.
 *
 * @param {number[]} arrayToFilter the array that the user wants us to filter
 * @returns {number[]} the filtered array
 */
function filterArrayToOnlySingleDigitNumbers(arrayToFilter) {
  return arrayToFilter.filter(number => number < 10 && number > -10);
}

/**
 * Write an anonymous function in the map that will double each element.
 *
 * For map, you want to write a function that takes the array
 * element and then returns the new value that will be stored
 * in the new array.
 *
 * @param {number[]} arrayToDouble the array that the user wants doubled
 * @returns {number[]} a array that has each number doubled
 */
function mapArrayToDoubleAllNumbers(arrayToDouble) {
  return arrayToDouble.map(number => number * 2);
}

/**
 * Write an anonymous function in the reduce that will multiply all numbers
 * from arrayToMultiply together.
 *
 * For reduce, the anonymous function will take two parameters:
 * the "reducer" and the current element. It will then return
 * the new result.
 *
 * @param {number[]} arrayToMultiply the numbers the user wants multiplied
 * @returns {number} the product of the array
 */
function reduceArrayToFindProduct(arrayToMultiply) {
  return arrayToMultiply.reduce((currentResult, number) => currentResult * number);
}

/**
 * Write an anonymous function in the filter that will only keep names
 * that have 'son' in them.
 *
 * @param {string[]} arrayToFilter the array to filter
 * @returns {string[]} the filtered array
 */
function filterStringArrayForSon(arrayToFilter) {
  return arrayToFilter.filter(string => string.includes("son"));
}

/**
 * Write an anonymous function that converts the name passed in into all
 * capital letters.
 *
 * @param {string[]} arrayToCapitalize array to capitalize names of
 * @returns {string[]} names in all upper case
 */
function makeNamesAllCaps(arrayToCapitalize) {
  return arrayToCapitalize.map(string => string.toUpperCase());
}

/*
 * Document the following function. Be sure to describe the
 * parameters and what they are for and what they take. You should
 * be able to list out what values the function should handle for
 * each of the parameters. If the parameter
 * has a default value, be sure to enclose the name of the parameter
 * with `[]` and put the default value after an `=` sign.
 *
 * Also be sure to document the return type and what it's returning.
 */

/**
 * 
 * @param {number} temperature the converted temperature
 * @param {string} temperatureUnit the unit to convert to
 * @param {boolean} includeUnit true
 * @returns converted temperature + unit
 */

function convertTemperature(temperature, temperatureUnit, includeUnit = false) {
  let convertedTemp = 0;
  let convertedUnit = 'F';
  if (temperatureUnit === 'C' || temperatureUnit === 'c') {
    convertedTemp = (temperature * 9) / 5 + 32;
    convertedUnit = 'F';
  } else {
    convertedTemp = ((temperature - 32) * 5) / 9;
    convertedUnit = 'C';
  }

  return convertedTemp + (includeUnit ? convertedUnit : ''); // convert to string
}

/**
 * Created By Udesh Kumar
 * Filters
 * Date: 05/29/2015
 */

var primeDigitalFilters = angular.module('primeDigitalFilters', []);


primeDigitalFilters.filter('renderHTMLCorrectly', renderHTMLCorrectly);
primeDigitalFilters.filter('isEmpty', isEmpty);
primeDigitalFilters.filter('length', length);
primeDigitalFilters.filter('setDecimal', setDecimal);


/**
 * @ngdoc Filter
 * @name renderHTMLCorrectly
 * @description
 *
 * To render HTML in view
 * 
 * @param Html
 *
 */
function renderHTMLCorrectly($sce)
{
    return function (stringToParse)
    {
        return $sce.trustAsHtml(stringToParse);
    }
}

/**
 * @ngdoc Filter
 * @name isEmpty
 * @description
 *
 * To check if object empty
 * 
 * @param object
 * 
 * @return {boolean}
 *
 */
function isEmpty() {
    var bar;
    return function (obj) {
        for (bar in obj) {
            if (obj.hasOwnProperty(bar)) {
                return false;
            }
        }
        return true;
    };
}

/**
 * @ngdoc Filter
 * @name length
 * @description
 *
 * To check keys length of object
 * 
 * @param object
 * 
 * @return {number}
 *
 */
function length() {
    return function (obj) {
        return Object.keys(obj).length
    };
}

/**
 * @ngdoc Filter
 * @name setDecimal
 * @description
 *
 * To set decimal values
 * 
 * @param input
 * @param places
 * 
 * @return {number}
 *
 */


function setDecimal() {
  return function(input, places) {
    input = parseFloat(input);
    places = parseFloat(places);
    if (input > Math.floor(input)) { //check the decimal place
        input = input.toFixed(places);
    }
    else {
        input = input.toFixed();
    }
    return input;
    
  };
}
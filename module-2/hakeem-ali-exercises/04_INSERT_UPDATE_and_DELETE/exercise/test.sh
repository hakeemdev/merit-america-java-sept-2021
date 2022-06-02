#!/bin/bash

mvn test -e -B > output.txt
number_of_tests=$(grep -P -o "(?<=Tests run: )(\d+)" output.txt|head -1)

# The tests didn't run and something else is wrong
if [ -z $number_of_tests ]
then
    sed -n '/^\[ERROR\].*$/,$p' output.txt
    exit 1
fi

number_of_failures=$(grep -P -o "(?<=Failures: )(\d+)" output.txt|head -1)
number_of_errors=$(grep -P -o "(?<=Errors: )(\d+)" output.txt|head -1)

percent_failed=$(((number_of_failures+number_of_errors)*100 / number_of_tests))

sed -n '/T E S T S/,$p' output.txt

if [ $percent_failed -lt 50 ]
then
    exit 0
else
    exit 1
fi
#!/bin/bash

mvn test -e -B > output.txt

shopt -s globstar
number_of_tests=$(grep -o -i @Test src/test/**/*.java | wc -l)
number_of_run_tests=$(tac output.txt | grep -P -o "(?<=Tests run: )(\d+)" | head -1)

# The tests didn't run and something else is wrong
if [ -z $number_of_run_tests ]
then
    sed -n '/^\[ERROR\].*$/,$p' output.txt
    exit 1
fi

number_of_failures=$(tac output.txt | grep -P -o "(?<=Failures: )(\d+)" | head -1)
number_of_errors=$(tac output.txt | grep -P -o "(?<=Errors: )(\d+)" | head -1)
number_of_passing=$((number_of_run_tests-(number_of_failures+number_of_errors)))

percent_passed=$(((number_of_passing)*100 / number_of_tests))

sed -n '/T E S T S/,$p' output.txt

if [ $percent_passed -ge 50 ]
then
    exit 0
else
    exit 1
fi

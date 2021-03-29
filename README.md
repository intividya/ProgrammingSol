# Build Instructions

```bash
./mvnw clean package
```

## Problem 1: Detect Anagram
```bash
java -cp target/programming-test-0.0.1.jar com.test.AnagramFinder mary army
```

Command line arguments:
1. Two string inputs

## Problem 2: Find all links on a web page
```bash
 java -cp target/programming-test-0.0.1.jar com.test.PrintAllLinksOnAWebPageThroughSelenium http://www.google.com /Applications/Firefox.app/Contents/MacOS/firefox
```
Command line arguments:
1. Web Page Url. Ex. https://www.google.com
2. Path to the firefox browser installed on your mac

####Note: This works only on mac as firefox driver for mac has been used. To run this for other OS, we need to replace the driver with the driver for that OS.

# Calculator
## Problem 3: one operator, two parameters
```bash
java -cp target/programming-test-0.0.1.jar com.test.Program3 "2*90"
```
Command line arguments:
1. A Simple math expression with one operator (+,-,/,*) and two operands

## Problem 4: multiple operators of the same precedence
```bash
java -cp target/programming-test-0.0.1.jar com.test.Program4 "2 * 3 / 4 * 20"
```
Command line arguments:
1. Math expression with operators that have same precedence

## Problem 5: multiple operators of different precedence
```bash
java -cp target/programming-test-0.0.1.jar com.test.Program5 "2 / 3 + 4 - 1"
```
Command line arguments:
1. Math expression with operators that have different precedence

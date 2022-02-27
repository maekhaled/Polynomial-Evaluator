# Polynomial
Rutgers CS112: Assignment 1

This project implements polynomials and operations on them using a linked list. This polynomial calculator can perform arithmetic operations on two polynomials or evaluate a polynomial expression for a given value. 

## Description

A polynomial may be represented using a linked list as follows: for every term in the polynomial there is one entry in the linked list consisting of the term's coefficient and degree. The entries are ordered according to ASCENDING values of degree, i.e. lowest degree term first, then next lowest degree term and so on, all the way up to the highest degree term. IMPORTANT: Zero-coefficient terms are NOT stored.

For example, the following polynomial (the symbol '^' is used to mean 'raised to the power'):

      4x^5 - 2x^3 + 2x +3
can be represented as the linked list of terms:
      (3,0) -> (2,1) -> (-2,3) -> (4,5)
where each term is a (coefficient,degree) pair.

A polynomial is read from an input file in the format:

	 *     <coeff> <degree>
	 *     <coeff> <degree>
	 *     ...
	 *     <coeff> <degree>
	 * with the GUARENTEE that degrees will be in descending order. For example:
	 *      4 5
	 *     -2 3
	 *      2 1
	 *      3 0
	 * will represent the polynomial:
	 *      4*x^5 - 2*x^3 + 2*x + 3 

A user will provide polynomial input file(s) and select the operation they wish to perform (add/multiple two polynomials, or evaluate a polynomial at a specific value).

### Executing Program

A user must provide the name of the text file and then select the operation they wish to perform by entering the numeric value of the operation from the prompted list. The input must be a numeric value between 1 to 4.
1. ADD
2. MULTIPLY
3. EVALUATE
4. EXIT
	 
Some example textfiles are provided: ptest1.txt, ptest2.txt, ptest1opp.txt

### Sample Run

Here is a sample run of the driver, PolyTest.java:

```
Enter the name of the polynomial file => ptest1.txt
4.0x^5 + -2.0x^3 + 2.0x + 3.0
1. ADD polynomial
2. MULTIPLY polynomial
3. EVALUATE polynomial
4. QUIT
 Enter choice # => 1
Enter the file containing the polynomial to add => ptest2.txt
8.0x^4 + 4.0x^3 + -3.0x + 9.0
Sum: 4.0x^5 + 8.0x^4 + 2.0x^3 + -1.0x + 12.0
1. ADD polynomial
2. MULTIPLY polynomial
3. EVALUATE polynomial
4. QUIT
 Enter choice # => 1
Enter the file containing the polynomial to add => ptest1opp.txt
CS112 Spring 2019: Programming Assignment 1 - Polynomial 2019/2/10 上午11'52
https://www.cs.rutgers.edu/courses/112/classes/spring_2019_venugopal/progs/prog1/prog1.html 第 4 ⻚（共 5 ⻚）
-4.0x^5 + 2.0x^3 + -2.0x + -3.0
Sum: 0
1. ADD polynomial
2. MULTIPLY polynomial
3. EVALUATE polynomial
4. QUIT
 Enter choice # => 1
Enter the file containing the polynomial to add => ptestnull.txt
0
Sum: 4.0x^5 + -2.0x^3 + 2.0x + 3.0
1. ADD polynomial
2. MULTIPLY polynomial
3. EVALUATE polynomial
4. QUIT
 Enter choice # => 2
Enter the file containing the polynomial to multiply => ptest2
8.0x^4 + 4.0x^3 + -3.0x + 9.0
Product: 32.0x^9 + 16.0x^8 + -16.0x^7 + -20.0x^6 + 52.0x^5 + 38.0x^4 + -6.0x^3 + -6.0x^2 + 9.0x + 27.0
1. ADD polynomial
2. MULTIPLY polynomial
3. EVALUATE polynomial
4. QUIT
 Enter choice # => 3
Enter the evaluation point x => 2
Value at 2.0: 119.0
1. ADD polynomial
2. MULTIPLY polynomial
3. EVALUATE polynomial
4. QUIT
 Enter choice # => 4
 ```


All use of this code must comply with the [Rutgers University Code of Student Conduct](http://eden.rutgers.edu/%7Epmj34/media/AcademicIntegrity.pdf).

package poly;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class implements evaluate, add and multiply for polynomials.
 * 
 * @author runb-cs112
 *
 */
public class Polynomial {
	
	/**
	 * Reads a polynomial from an input stream (file or keyboard). The storage format
	 * of the polynomial is:
	 * <pre>
	 *     <coeff> <degree>
	 *     <coeff> <degree>
	 *     ...
	 *     <coeff> <degree>
	 * </pre>
	 * with the guarantee that degrees will be in descending order. For example:
	 * <pre>
	 *      4 5
	 *     -2 3
	 *      2 1
	 *      3 0
	 * </pre>
	 * which represents the polynomial:
	 * <pre>
	 *      4*x^5 - 2*x^3 + 2*x + 3 
	 * </pre>
	 * 
	 * @param sc Scanner from which a polynomial is to be read
	 * @throws IOException If there is any input error in reading the polynomial
	 * @return The polynomial linked list (front node) constructed from coefficients and
	 *         degrees read from scanner
	 */
	public static Node read(Scanner sc) 
	throws IOException {
		Node poly = null;
		while (sc.hasNextLine()) {
			Scanner scLine = new Scanner(sc.nextLine());
			poly = new Node(scLine.nextFloat(), scLine.nextInt(), poly);
			scLine.close();
		}
		return poly;
	}
	
	/**
	 * Returns the sum of two polynomials - DOES NOT change either of the input polynomials.
	 * The returned polynomial MUST have all new nodes. In other words, none of the nodes
	 * of the input polynomials can be in the result.
	 * 
	 * @param poly1 First input polynomial (front of polynomial linked list)
	 * @param poly2 Second input polynomial (front of polynomial linked list
	 * @return A new polynomial which is the sum of the input polynomials - the returned node
	 *         is the front of the result polynomial
	 */
	public static Node add(Node poly1, Node poly2) {
		/** COMPLETE THIS METHOD **/
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
		// CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		
		Node ptr1 = poly1;
		Node ptr2 = poly2;
		Node sum = null;
		Node sumreversed = null;
		
		if (poly1==null && poly2==null) {
			return null;
		}
		
		else if (poly1==null) {
			while (ptr2 != null) {
				sum = new Node (ptr2.term.coeff, ptr2.term.degree,sum);
				ptr2 = ptr2.next;
			}
		}
		
		else if (poly2==null) {
			while (ptr1 != null) {
				sum = new Node (ptr1.term.coeff, ptr1.term.degree,sum);
				ptr1 = ptr1.next;
			}
		}
		
		else if (poly1 != null && poly2 != null) {
			while (ptr1 != null || ptr2 != null){	
				if (ptr1 == null) {
					sum = new Node (ptr2.term.coeff, ptr2.term.degree, sum);
					ptr2 = ptr2.next;
				}
				else if (ptr2 == null) {
					sum = new Node (ptr1.term.coeff, ptr1.term.degree, sum);
					ptr1 = ptr1.next;
				}
				else if (ptr1.term.degree > ptr2.term.degree) {
					sum = new Node (ptr2.term.coeff, ptr2.term.degree, sum);
					ptr2 = ptr2.next;
				}
				else if (ptr1.term.degree < ptr2.term.degree) {
					sum = new Node (ptr1.term.coeff, ptr1.term.degree, sum);
					ptr1 = ptr1.next;
				}
				else if (ptr1.term.degree == ptr2.term.degree) {
					if (ptr1.term.coeff + ptr2.term.coeff !=0) {
					sum = new Node (ptr1.term.coeff + ptr2.term.coeff, ptr2.term.degree, sum);
					}
					ptr1 = ptr1.next;
					ptr2 = ptr2.next;
				}	
			}
		}
		
		while (sum !=null) {
			
			sumreversed = new Node (sum.term.coeff, sum.term.degree, sumreversed);
			sum=sum.next;
		}
			
			
		return sumreversed;
	}
	
	/**
	 * Returns the product of two polynomials - DOES NOT change either of the input polynomials.
	 * The returned polynomial MUST have all new nodes. In other words, none of the nodes
	 * of the input polynomials can be in the result.
	 * 
	 * @param poly1 First input polynomial (front of polynomial linked list)
	 * @param poly2 Second input polynomial (front of polynomial linked list)
	 * @return A new polynomial which is the product of the input polynomials - the returned node
	 *         is the front of the result polynomial
	 */
	public static Node multiply(Node poly1, Node poly2) {
		/** COMPLETE THIS METHOD **/
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
		// CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		
		if (poly1==null || poly2==null) {
			return null;
		}
		
		Node ptr1 = poly1;
		Node ptr2 = poly2;
		Node product = null;
		Node productsum = null;
		Node productreversed = null;
		
		while (ptr1 != null) {
			while (ptr2!=null) {
				product = new Node ((ptr1.term.coeff*ptr2.term.coeff),(ptr1.term.degree + ptr2.term.degree),product);
				ptr2 = ptr2.next;
			}
			while (product !=null) {
				productreversed = new Node (product.term.coeff, product.term.degree, productreversed);
				product=product.next;
			}
			productsum = add(productreversed,productsum);
			ptr1 = ptr1.next;
			ptr2 = poly2;
			product = null;
			productreversed = null;
		}
		
		
		return productsum;
	}
		
	/**
	 * Evaluates a polynomial at a given value.
	 * 
	 * @param poly Polynomial (front of linked list) to be evaluated
	 * @param x Value at which evaluation is to be done
	 * @return Value of polynomial p at x
	 */
	public static float evaluate(Node poly, float x) {
		/** COMPLETE THIS METHOD **/
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
		// CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		
		Node ptr = poly;
		float sumvalues = 0;
		
		while (ptr != null) {
			float value = (ptr.term.coeff)* (float)(Math.pow(x,ptr.term.degree));
			sumvalues += value;
			ptr=ptr.next;
		}
		return sumvalues;
	}
	
	/**
	 * Returns string representation of a polynomial
	 * 
	 * @param poly Polynomial (front of linked list)
	 * @return String representation, in descending order of degrees
	 */
	public static String toString(Node poly) {
		if (poly == null) {
			return "0";
		} 
		
		String retval = poly.term.toString();
		for (Node current = poly.next ; current != null ;
		current = current.next) {
			retval = current.term.toString() + " + " + retval;
		}
		return retval;
	}	
}

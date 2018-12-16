package assignment2;

import java.math.BigInteger;

public class MyTESTER {
	
	public static void main (String args[])

	{
		
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		
	//	Polynomial resultPolynomial = new Polynomial();
		
		p1.addTerm(new Term(1, new BigInteger("2")));
		p1.addTerm(new Term(3, new BigInteger("4")));
		
		p2.addTerm(new Term(5, new BigInteger("6")));
		p2.addTerm(new Term(8, new BigInteger("9")));
		
		System.out.println(Polynomial.add(p1, p2));
		
		
						
		// Lets test the multiply method
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(Polynomial.multiply(p1, p2));
		
		
		return;
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

import java.math.BigInteger;
import java.util.Iterator;

public class Polynomial 
{
	private SLinkedList<Term> polynomial;
	
	//Constructor
	public Polynomial()
	{
		polynomial = new SLinkedList<Term>();
	}
	
	
	public int size()
	{	
		return polynomial.size();
	}
	
	private Polynomial(SLinkedList<Term> p)
	{
		polynomial = p;
	}
	
	
	// Returns a deep copy of the object.
	public Polynomial deepClone()
	{	
		return new Polynomial(polynomial.deepClone());
	}
	
	/* 
	 * TODO: Add new term to the polynomial. Also ensure the polynomial is
	 * in decreasing order of exponent.
	 */
	public void addTerm(Term t)
	{	
		/**** ADD CODE HERE ****/
		
		//Below two ifs are checking for exceptions
		
		if (t.getExponent() < 0) 
		{
			throw new IllegalArgumentException("ERROR: Exponent is zero or less than zero");
		}
		
		String coefficientInString = t.getCoefficient().toString();
		double coefficientInDouble = Double.parseDouble(coefficientInString);
		
		if (coefficientInDouble == 0)
		{
		    throw new IllegalArgumentException("ERROR: Coefficient is zero");
		}
		
		//This is the flag that we'll use to check if none of the if statements executed
		boolean b = false;
		
		int i = 0;
		
		
		
		
		//I had four ifs - one to check if it needs to iterate through, 
		// second to check if exponents were equal, 
		// third to check if it needs to add the term,
		// and the last one was just an if to execute polynomial.addLast(t); (in case none of the other ifs executed)		

		
		
		//So we have "Term currentTerm"(iterator term) and "Term t" (i.e. the term we need to add)
		for (Term currentTerm: polynomial)
		{
			//****************PROBLEM IS THAT YOU NEED TO ASSIGN CURRENT TERM TO THE POSITION IN THE POLYNOMIAL*****************************
			
																	// Gets us the element of node(i) ---> Line 117 in SLinkedList.java
															// NOTE: The client can only access elements, and NOT Nodes
			
			
						
			//^^This method works because the element is a term, so it is returning a term in this instance. Now we need to change this to a node. (Or do we?)												
			
			int exponentOft = t.getExponent();
			int exponentOfcurrentTerm = currentTerm.getExponent();
			
			
//			System.out.println("Start of a new iteration (t term): " + t.toString());
//			System.out.println("Start of a new iteration (currentTerm): " + currentTerm.toString());
			
			//FIRST CONDITION
			if (exponentOfcurrentTerm > exponentOft)
			{
//				System.out.println("FIRST IF DEBUGGER (Current Term Exponent): " + currentTerm.getExponent());
//				System.out.println("MY TERM's Exponent                     : " + t.getExponent());
			}
			
			//SECOND IF!!!!  Instructions according to Professor Langer to ADD the two exponents if they are the same (from the Discussion Board)
			else if (exponentOft == exponentOfcurrentTerm)	
			{
				
				String coefficientInString2 = currentTerm.getCoefficient().toString();
				int coefficientOfcurrentTerm = Integer.parseInt(coefficientInString2);		//Get the coefficient of the current term in Int form
				
				String coefficientInString3 = t.getCoefficient().toString();
				int coefficientOft = Integer.parseInt(coefficientInString3);				//Get the coefficient of t (term to add) in Int form
				
				
//				System.out.println("Old Polynomial: " + polynomial);
//				
//				System.out.println("SECOND IF DEBUGGER (currenntTerm): "  + currentTerm.toString());
//				System.out.println("SECOND IF DEBUGGER (curretTerm_Coefficient): " + coefficientOfcurrentTerm);
//				System.out.println("SECOND IF DEBUGGER (curretTerm_Exponent): " + currentTerm.getExponent());
//
//				System.out.println("SECOND IF DEBUGGER (t term): "  + t.toString());
//				System.out.println("SECOND IF DEBUGGER (t_Coefficient): " + coefficientOft);
//				System.out.println("SECOND IF DEBUGGER (t_Exponent): " + t.getExponent());
//				
//				System.out.println("t_Term: " + t.toString());
//				System.out.println("currentTerm: " + currentTerm.toString());
				
				
				
				int addedCoefficients = coefficientOfcurrentTerm + coefficientOft;
				BigInteger addedCoefficientsAsBI = BigInteger.valueOf(addedCoefficients);
				
//				System.out.println("BIG INTEGER addedCoefficients: " + addedCoefficientsAsBI);
//				System.out.println("INT form of addedCoefficients: " + addedCoefficients);
				
				if (addedCoefficients == 0)
				{
					
					polynomial.remove(i);										//WHERE IS THE ADDED COEFFICIENT GOING?
												
//					System.out.println("Polynomial AFTER Removing Term: " + polynomial);
//					System.out.println("WE NEED TO BREAK HERE (ONCE WE FIGURE OUT HOW TO BREAK YEETTTTTT");
					
					//tester = 999;
					
												//Ideally, we SHOULD break the loop here, but I can't do it for some reason. USE WHILE LOOOPPPSSS???
				}
				
				else if (addedCoefficients != 0)
				{
					
					currentTerm.setCoefficient(addedCoefficientsAsBI);
				
//				System.out.println("LAST CHECK of t:" + t);
//				System.out.println("LAST CHECK of currentTerm: " + currentTerm);
//				System.out.println("New Polynomial: " + polynomial);

					//	System.out.println("*****************************************");
				
				}
				
				b = true;
				break;
			}
			
			//THIRD IF
			else if (exponentOfcurrentTerm < exponentOft)
			{
//				if (tester == 999) 
//				{
//					System.out.println("Polynomial before break: " + polynomial);
//					System.out.println("BREAK SUCCESSFUL" + System.lineSeparator());
//					break;
//				}
				
				//System.out.println("THIRD IF DEBUGGER (currentTerm_Exponent): " + currentTerm.getExponent());
				//System.out.println("t_Exponent: " + t.getExponent());
				
				polynomial.add(i, t);
				
//				System.out.println("Polynomial w/THIRD IF: " + polynomial);
				

//				System.out.println("*****************************************");
				b = true;
				break;
			}
			
			i++;			//IMPORTANT TO DO i++ here instead of after every conditional If statement, since that is bad code practice.
			
		}
		
		
		if(!b)
		{
			polynomial.addLast(t);
		}
		
		// Hint: Notice that the function SLinkedList.get(index) method is O(n), 
		// so if this method were to call the get(index) 
		// method n times then the method would be O(n^2).
		// Instead, use a Java enhanced for loop to iterate through 
		// the terms of an SLinkedList.
		
		/*
		for (Term currentTerm: polynomial)
		{
			// The for loop iterates over each term in the polynomial!!
			// Example: System.out.println(currentTerm.getExponent()) should print the exponents of each term in the polynomial when it is not empty.  
		}
		*/
	}
	
	public Term getTerm(int index)
	{
		return polynomial.get(index);
	}
	
	//TODO: Add two polynomial without modifying either
	//*********************Static means you can call WITHOUT the need of instance***************************************
	public static Polynomial add(Polynomial p1, Polynomial p2)
	{
		{
			//Clones of polynomials being used
			Polynomial _p1 =  p1.deepClone();
		    Polynomial _p2 =  p2.deepClone();
		    
		    //New Polynomial that is the result
		    Polynomial result = new Polynomial();
		    
		    //Iterators for the respective polynomials
		    Iterator<Term> iter_1 = _p1.polynomial.iterator();
		    Iterator<Term> iter_2 = _p2.polynomial.iterator();
		    
		    //Variables that will be used later
		    Term t1;
		    Term t2; 
		    Term resultantTerm;
		    
		    //Setting the variables from before (t1, t2, resultant_term as null first)
		    t1 = null;
		    t2 = null;
		    resultantTerm = null;
		    
		    //This is the flags we will use for this method. They will be useful as they will let us know whether to
		    //implement a certain condition or not.
		    boolean inc_t1, inc_t2;
		    inc_t1 = true;
		    inc_t2 = true;
		    
		    while(iter_1.hasNext() && iter_2.hasNext())
		    {
		      if(inc_t1) t1 = iter_1.next();
		      if(inc_t2) t2 = iter_2.next();
		      
		      //Checking if the exponents are equal and adding the Coefficients if they are.
		      if(t1.getExponent() == t2.getExponent())
		      {
		        resultantTerm = new Term(t1.getExponent(),t1.getCoefficient().add(t2.getCoefficient()));
		        result.addTermLast(resultantTerm);
		        
		        inc_t1 = true;
		        inc_t2 = true;
		      }
		      
		      //This is the else case in case the exponents are not equal and we need to add the Term in the case of
		      //t1s exponent being greater than t2
		      else
		      {
		        if(t1.getExponent() > t2.getExponent())
		        {
		          result.addTermLast(t1);
		          inc_t1 = true;
		          inc_t2 = false;
		        }
		        
		        
		        else
		        {
		          result.addTermLast(t2);
		          inc_t1 = false;
		          inc_t2 = true;
		        }
		      }
		    }
		    
		    //Below we have two ifs and whiles for t1 and t2 respectively
		    //We addtermLast since this is the most efficient way of adding terms,
		    //while adhering to Prof. Langer's Time Complexity restraints!
		    
		    if(!inc_t1)
		    {
		      result.addTermLast(t1);
		    }
		    
	        while(iter_1.hasNext())
	        {
	          result.addTermLast(iter_1.next());
	        }
		    
		    if(!inc_t2)
		    {
		      result.addTermLast(t2);
		    }
		    
	        while(iter_2.hasNext())
	        {
	          result.addTermLast(iter_2.next());
	        }
		        
		    //returning the result, which is the new polynomial of the two added Polynomials
			return result;
		}
	}

	/*public static void main(String args[])
	{
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		
		Polynomial resultPolynomial = new Polynomial();
		
		p1.addTerm(new Term(1, new BigInteger("2")));
		p2.addTerm(new Term(5, new BigInteger("6")));
		
		
		resultPolynomial = Polynomial.add(p1,p2);
		
		System.out.println(resultPolynomial);
		
		//Lets test the multipy method
		
		Term f = p2.getTerm(0);
		
		p1.this.polynomial.multiplyTerm(f);
		
		return;
	}*/
	//////////////////////////////////////////////////////////CHANGE BACK TO PRIVATE\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	//TODO: multiply this polynomial by a given term.
	private void multiplyTerm(Term t)
	{	
		/**** ADD CODE HERE ****/
		

		int myExponent = t.getExponent();
		BigInteger myCoefficient = t.getCoefficient();
		
		for (Term CurrentTerm: polynomial)
		{
			int currentTermExponent = CurrentTerm.getExponent();
				
			BigInteger currentTermCoefficient = CurrentTerm.getCoefficient();
			
			//I've tried to keep most of variables self-explanatory 
			int newExponent = currentTermExponent + myExponent;
			BigInteger newCoefficient = myCoefficient.multiply(currentTermCoefficient);

			CurrentTerm.setExponent(newExponent);
			CurrentTerm.setCoefficient(newCoefficient);	
		}
	}
	
	//TODO: multiply two polynomials
	public static Polynomial multiply(Polynomial p1, Polynomial p2)
	{
		/**** ADD CODE HERE ****/
		
		Polynomial firstPolynomial = p1.deepClone();
		Polynomial secondPolynomial = p2.deepClone();
		
		Polynomial finalPolynomial = new Polynomial();
		
		
		for (Term currentTerm: firstPolynomial.polynomial)
		{
			secondPolynomial.multiplyTerm(currentTerm);
			
			finalPolynomial = add(finalPolynomial, secondPolynomial);
			
			//Because secondPolynomial needs to stay the same every iteration
			secondPolynomial = p2.deepClone();
		}
		
		return finalPolynomial;
		
	}
	
	//TODO: evaluate this polynomial.
	// Hint:  The time complexity of eval() must be order O(m), 
	// where m is the largest degree of the polynomial. Notice 
	// that the function SLinkedList.get(index) method is O(m), 
	// so if your eval() method were to call the get(index) 
	// method m times then your eval method would be O(m^2).
	// Instead, use a Java enhanced for loop to iterate through 
	// the terms of an SLinkedList.

	
	public BigInteger eval(BigInteger x)
	{
		/**** ADD CODE HERE ****/
		
		BigInteger evaluatedTerm = new BigInteger("0");
		
//		System.out.println("My Polynomial (Outside): " + polynomial);
		
		for (Term currentTerm: polynomial)
		{
//			System.out.println("My Polynomial: " + polynomial);
//			System.out.println("My X Value: " + x);
			
			//String xAsString = x.toString();
			//int xInInteger = Integer.parseInt(xAsString);
			//Getting the x term in integer form
			
			
			int currentExponent = currentTerm.getExponent();
			//Getting the current term's Exponent in integer form
			
			BigInteger myBigInteger = currentTerm.getCoefficient();
			//Get the current term's Coefficient in BigInteger form

//			System.out.println("My Big Integer: " + myBigInteger.toString());
			
			BigInteger finalAnswer;
			BigInteger finalAnswer2;
			
			finalAnswer = x.pow(currentExponent);
			
			finalAnswer2 = myBigInteger.multiply(finalAnswer);
			
//			System.out.println("POW Calc for this Term:       " + finalAnswer2);
			
			evaluatedTerm = evaluatedTerm.add(finalAnswer2);
			
		}
		
//		System.out.println("Final Result:                 " + evaluatedTerm.toString());
		
//		System.out.println("*************END****************");
		
		return evaluatedTerm;
	
		
		//LANGERS DEFAULT RETURN STATEMENT// return new BigInteger("0");
	}
	
	// Checks if this polynomial is same as the polynomial in the argument.
	// Used for testing whether two polynomials have same content but occupy disjoint space in memory.
	// Do not change this code, doing so may result in incorrect grades.
	public boolean checkEqual(Polynomial p)
	{	
		// Test for null pointer exceptions!!
		// Clearly two polynomials are not same if they have different number of terms
		if (polynomial == null || p.polynomial == null || size() != p.size())
			return false;
		
		int index = 0;
		// Simultaneously traverse both this polynomial and argument. 
		for (Term term0 : polynomial)
		{
			// This is inefficient, ideally you'd use iterator for sequential access.
			Term term1 = p.getTerm(index);
			
			if (term0.getExponent() != term1.getExponent() || // Check if the exponents are not same
				term0.getCoefficient().compareTo(term1.getCoefficient()) != 0 || // Check if the coefficients are not same
				term1 == term0) // Check if the both term occupy same memory location.
					return false;
			
			index++;
		}
		return true;
	}
	
	// This method blindly adds a term to the end of LinkedList polynomial. 
	// Avoid using this method in your implementation as it is only used for testing.
	// Do not change this code, doing so may result in incorrect grades.
	public void addTermLast(Term t)
	{	
		polynomial.addLast(t);
	}
	
	// This is used for testing multiplyTerm.
	// Do not change this code, doing so may result in incorrect grades.
	public void multiplyTermTest(Term t)
	{
		multiplyTerm(t);
	}
	
	@Override
	public String toString()
	{	
		if (polynomial.size() == 0) return "0";
		return polynomial.toString();
	}
}

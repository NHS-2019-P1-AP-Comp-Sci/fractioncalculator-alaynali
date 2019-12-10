/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args)
    {
    	Scanner userInput = new Scanner(System.in);
    	boolean run = true;
    	while (run == true) {
    		String input = userInput.nextLine();
    		if ((input.toUpperCase()).equals("QUIT")) {
    			run = false;
    		} else {
            	System.out.println(produceAnswer(input));
    		}
        	
    	}
    	
        // TODO: Read the input from the user and call produceAnswer with an equation

    	userInput.close();
    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    {
        // TODO: Implement this function to produce the solution to the input
    	
    	String firstOperand = input.substring(0, input.indexOf(" "));
    	String secondOperand = input.substring(input.indexOf(" ")+3);
    	String operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
    	System.out.println(operator);
    	String firstParsed = parseFractions(firstOperand);
    	String secondParsed = parseFractions(secondOperand);
    	
    	// parse first value
    	int firstWhole = Integer.parseInt(firstParsed.substring(firstParsed.indexOf("w")+1, firstParsed.indexOf("n")));
    	int firstNum = Integer.parseInt(firstParsed.substring(firstParsed.indexOf("n")+1, firstParsed.indexOf("d")));
    	int firstDenom = Integer.parseInt(firstParsed.substring(firstParsed.indexOf("d")+1, firstParsed.length()));
    	// assign correct sign
    	if (firstWhole < 0) {
    		firstNum = 0 - firstNum;
    	}
    	
    	//parse second value
    	int secondWhole = Integer.parseInt(secondParsed.substring(secondParsed.indexOf("w")+1, secondParsed.indexOf("n")));
    	int secondNum = Integer.parseInt(secondParsed.substring(secondParsed.indexOf("n")+1, secondParsed.indexOf("d")));
    	int secondDenom = Integer.parseInt(secondParsed.substring(secondParsed.indexOf("d")+1, secondParsed.length()));
    	// assign correct sign
    	if (secondWhole < 0) {
    		secondNum = 0 - secondNum;
    	}
    	
    	// variables/initializing
    	int totalWhole = 0;
    	int totalNum = 0;
    	int totalDenom = 1;
    	String totalValue = "";
    	
    	
    	// addition
    	if (operator.equals("+")) {
    		totalWhole = firstWhole + secondWhole;
    		System.out.println("whole " + totalWhole);
    		
    		// something is wrong w/ numerator operation for negatives--fix
    		if (firstDenom != secondDenom) {
    			System.out.println("firstDenom does not equal secondDenom");
    			totalNum = (firstNum * secondDenom) + (secondNum * firstDenom);
            	totalDenom = firstDenom * secondDenom;
    		} else {
    			System.out.println("firstDenom equals secondDenom");
    			totalNum = firstNum + secondNum;
    			totalDenom = firstDenom;
    		}
    		System.out.println("num " + totalNum);
    		System.out.println("denom " + totalDenom);
    		
        	if (Math.abs(totalNum) > totalDenom || Math.abs(totalNum) == totalDenom) {
        		totalWhole += totalNum / totalDenom;
        		totalNum -= totalNum / totalDenom * totalDenom;
        	}
        	System.out.println("whole " + totalWhole);
        	System.out.println("num " + totalNum);
        	
	    	if (totalDenom == 1) {
	    		totalWhole += totalNum;
	    	}
        	System.out.println("whole " + totalWhole);

	    	if (totalNum < 0) {
	    		totalNum = 0 - totalNum;
	    	}

	    	
	    // subtraction
    	} else if (operator.equals("-")) {
    		totalWhole = firstWhole - secondWhole;
    		System.out.println("whole " + totalWhole);
    		
    		if (firstDenom != secondDenom) {
    			totalNum = (firstNum * secondDenom) - (secondNum * firstDenom);
            	totalDenom = firstDenom * secondDenom;
    		} else {
    			totalNum = firstNum - secondNum;
    			totalDenom = firstDenom;
    		}
    		System.out.println("num " + totalNum);
    		System.out.println("denom " + totalDenom);
    		
        	if (Math.abs(totalNum) > totalDenom || Math.abs(totalNum) == totalDenom) {
        		totalWhole += totalNum / totalDenom;
        		totalNum -= totalNum / totalDenom * totalDenom;
        	}
        	System.out.println("whole " + totalWhole);
        	System.out.println("num " + totalNum);
        	
	    	if (totalNum > 0 && totalWhole == -1) {
	    		System.out.println("totalNum > 0");
	    		totalWhole *= totalDenom;
	    		System.out.println(totalWhole);
	    		totalNum += totalWhole;
	    		System.out.println(totalNum);
	    		totalWhole = totalNum / totalDenom;
	    		System.out.println(totalWhole);
	    	} 
        	if (totalDenom == 1 && totalNum != 0) {
	    		totalWhole -= totalNum;
	    	}
	    	
	    	if (totalWhole != 0 && totalNum < 0) {
	    		totalNum = 0 - totalNum;
	    	}
	    	System.out.println("whole " + totalWhole);
	    	   		
	    	
	    // multiplication
    	} else if (operator.equals("*")) {
    		totalWhole = ((firstWhole * firstDenom + firstNum) * (secondWhole * secondDenom + secondNum)) / (firstDenom * secondDenom);
    		System.out.println("whole " + totalWhole);
    		totalNum = ((firstWhole * firstDenom + firstNum) * (secondWhole * secondDenom + secondNum)) % (firstDenom * secondDenom);
    		totalDenom = firstDenom * secondDenom;
    		System.out.println("num " + totalNum);
    		System.out.println("denom " + totalDenom);
    		
        	if (Math.abs(totalNum) > totalDenom || Math.abs(totalNum) == totalDenom) {
        		totalWhole += totalNum / totalDenom;
        		totalNum -= totalNum / totalDenom * totalDenom;
        	}
        	System.out.println("whole " + totalWhole);
        	System.out.println("num " + totalNum);
	    	
	    	if (totalNum < 0) {
	    		totalNum = 0 - totalNum;
	    	}

	    	
	    // division
    	} else if (operator.equals("/")) {
//    		if (secondWhole == 1 && secondNum == 1 && secondDenom == 1) {
//    			
//    		}
    		totalWhole = (((firstWhole * firstDenom) + firstNum) * secondDenom) / (firstDenom * ((secondWhole * secondDenom) + secondNum));
    		System.out.println("whole "+totalWhole);
    		totalNum = (((firstWhole * firstDenom) + firstNum) * secondDenom) % (firstDenom * ((secondWhole * secondDenom) + secondNum));
    		totalDenom = (firstDenom * ((secondWhole * secondDenom) + secondNum));
    		System.out.println("num " + totalNum);
        	System.out.println("denom " + totalDenom);
        		
    		System.out.println("whole " + totalWhole);
    		
    		
        	if (Math.abs(totalNum) > totalDenom || Math.abs(totalNum) == totalDenom) {
        		totalWhole += totalNum / totalDenom;
        		totalNum += Math.abs(totalNum / totalDenom) * totalDenom;
        	}
        	
	    	if (totalDenom < 0) {
	    		totalDenom = 0 - totalDenom;
	    		totalNum = 0 - totalNum;
	    	} else if (totalDenom == 1 && totalNum != 0) {
	    		totalWhole /= totalNum;
	    	}
	    	
	    	if (totalWhole != 0 && totalNum < 0) {
	    		totalNum = 0 - totalNum;
	    	}
	    
    	}
    	
    	
    	// fraction reduction
    	int gcd = findGCD(totalNum, totalDenom);
    	System.out.println("gcd " + gcd);
    	totalNum /= gcd;
    	totalDenom /= gcd;
    	
    	// building of totalWhole
    	if (totalNum == 0) {
    		totalValue += totalWhole;
    	} else if (totalWhole == 0){
    		totalValue += totalNum + "/" + totalDenom;
    	} else {
    		totalValue += totalWhole + "_" + totalNum + "/" + totalDenom; 
    	}
    	System.out.println("value " + totalValue);

    	
        return totalValue;
    }

    
    public static String parseFractions(String operand) {
    	// variables/initializing
    	String whole = "0";
    	String num = "0";
    	String denom = "1"; 
    	    	
    	if (operand.contains("/")) {
    		num = operand.substring(operand.indexOf("_")+1, operand.indexOf("/"));
			denom = operand.substring(operand.indexOf("/")+1, operand.length());
			
    		if (operand.contains("_")) {
    			whole = operand.substring(0, operand.indexOf("_"));
    		}
    		
    	} else {
    		whole = operand;
    	}
    	
    	String parsed = "w"+ whole +"n"+ num +"d"+ denom;
    	
    	return parsed;
    }
  
    // function to find greatest common denominator
    private static int findGCD(int num1, int num2) {
    	System.out.println("inside findGCD: " + num1 + ", " + num2);
    	int gcd = 1;
    	for (int i = 1; i <= Math.abs(num1) && i <= Math.abs(num2); i++) {
            if(Math.abs(num1) % i == 0 && Math.abs(num2) % i == 0) {
                gcd = i;
            }
        }
    	return gcd;
    }
    
    
    // TODO: Fill in the space below with any helper methods that you think you will need

}

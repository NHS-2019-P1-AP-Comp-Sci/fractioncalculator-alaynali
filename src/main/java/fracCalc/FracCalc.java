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
    	
    	int firstWhole = Integer.parseInt(firstParsed.substring(firstParsed.indexOf("w")+1, firstParsed.indexOf("n")));
    	int firstNum = Integer.parseInt(firstParsed.substring(firstParsed.indexOf("n")+1, firstParsed.indexOf("d")));
    	int firstDenom = Integer.parseInt(firstParsed.substring(firstParsed.indexOf("d")+1, firstParsed.length()));
    	if (firstWhole < 0) {
    		firstNum = 0 - firstNum;
    	}
    	int secondWhole = Integer.parseInt(secondParsed.substring(secondParsed.indexOf("w")+1, secondParsed.indexOf("n")));
    	int secondNum = Integer.parseInt(secondParsed.substring(secondParsed.indexOf("n")+1, secondParsed.indexOf("d")));
    	int secondDenom = Integer.parseInt(secondParsed.substring(secondParsed.indexOf("d")+1, secondParsed.length()));
    	if (secondWhole < 0) {
    		secondNum = 0 - secondNum;
    	}
    	int totalWhole;
    	int totalNum;
    	int totalDenom;
    	String totalValue = "";
    	
    	if (operator.equals("+")) {
    		totalWhole = firstWhole + secondWhole;
    		System.out.println("whole " + totalWhole);
    		
    		if (firstDenom != secondDenom) {
    			totalNum = (firstNum * secondDenom) + (secondNum * firstDenom);
            	totalDenom = firstDenom * secondDenom;
    		} else {
    			totalNum = firstNum + secondNum;
    			totalDenom = firstDenom;
    		}
    		System.out.println("num " + totalNum);
    		System.out.println("denom " + totalDenom);
    		
        	if (Math.abs(totalNum) > totalDenom || Math.abs(totalNum) == totalDenom) {
        		totalWhole += totalNum / totalDenom;
        		totalNum -= Math.abs(totalNum / totalDenom) * totalDenom;
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
	    	if (totalNum == 0) {
	    		totalValue += totalWhole;
	    	} else {
	    		totalValue += totalWhole + "_" + totalNum + "/" + totalDenom; 
	    	}
	    	
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
        		totalNum -= Math.abs(totalNum / totalDenom) * totalDenom;
        	}
        	System.out.println("whole " + totalWhole);
        	System.out.println("num " + totalNum);
        	
	    	if (totalDenom == 1) {
	    		totalWhole -= totalNum;
	    	}
	    	System.out.println("whole " + totalWhole);
	    	
	    	if (totalNum < 0) {
	    		totalNum = 0 - totalNum;
	    	}
	    	
	    	if (totalNum == 0) {
	    		totalValue += totalWhole;
	    	} else {
	    		totalValue += totalWhole + "_" + totalNum + "/" + totalDenom; 
	    	}
	    	
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
	    	
	    	if (totalNum == 0) {
	    		totalValue += totalWhole;
	    	} else if (totalWhole == 0){
	    		totalValue += totalNum + "/" + totalDenom;
	    	} else {
	    		totalValue += totalWhole + "_" + totalNum + "/" + totalDenom; 
	    	}
	    	System.out.println("value " + totalValue);
	    	
    	} else if (operator.equals("/")) {
    		
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
        	
	    	if (totalDenom == 1) {
	    		totalWhole /= totalNum;
	    	} else if (totalDenom < 0) {
	    		totalDenom = 0 - totalDenom;
	    	}
	    	
	    	if (totalNum < 0) {
	    		totalNum = 0 - totalNum;
	    	}
	    	
	    	if (totalNum == 0) {
	    		totalValue += totalWhole;
	    	} else if (totalWhole == 0){
	    		totalValue += totalNum + "/" + totalDenom;
	    	} else {
	    		totalValue += totalWhole + "_" + totalNum + "/" + totalDenom; 
	    	}
	    	System.out.println("value " + totalValue);
    	}
    	
        return totalValue;
    }

    public static String parseFractions(String operand) {
    	String whole = "0";
    	String num = "0";
    	String denom = "1"; 
    	    	
    	if (operand.contains("/")) {
    		num = operand.substring(operand.indexOf("_")+1, operand.indexOf("/"));
			denom = operand.substring(operand.indexOf("/")+1, operand.length());
			
    		if (operand.contains("_")) {
    			whole = operand.substring(0, operand.indexOf("_"));
    		}
    		
    	}else {
    		whole = operand;
    	}
    	
    	String parsed = "w"+ whole +"n"+ num +"d"+ denom;
    	
    	return parsed;
    }
    
    
    // TODO: Fill in the space below with any helper methods that you think you will need

}

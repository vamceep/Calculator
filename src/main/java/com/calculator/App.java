package com.calculator;

import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter an expression in the below defined format:\nvar1 operator var2\nWhere var1, var2 are numbers and operator is '+'  or '-'\nEnter stop to exit.");
        boolean stop = false;
        while(!stop) {
        	
            String exp = sc. nextLine();
            if(exp.equals("stop")) {
            	sc.close();
            	return;
            }
       		String[] str = exp.split("[-+*/]");

            char op = exp.charAt(str[0].length());
            int v1 = Integer.parseInt(str[0].trim());
            int v2 = Integer.parseInt(str[1].trim());
            if(op == '+')
                new Addition(v1, v2);
            else if(op == '-')
                new Substraction(v1,v2);
            else 
                System.out.println("wrong option");
	    }
        sc.close();
    }
}

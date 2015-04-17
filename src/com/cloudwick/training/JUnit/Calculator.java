package com.cloudwick.training.JUnit;

public class Calculator {
	public int calculate(int num1,int num2)
	{
		int result=0;
		/**/
		if(num1<10)
		{
			result=num1+num2;
		}
		else if(num1>10 && num1<100)
		{
			result=num1*num2;
		}
		else
		{
			result=num1-num2;
		}
		return result;
		
	}

}

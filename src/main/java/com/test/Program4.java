package com.test;

public class Program4 extends Calculator {

	public static void main(String[] args) {
		if (args == null || args.length == 0)
			throw new IllegalArgumentException("Excepted a math expression as command line argument, but none were provided");
		Program4 program = new Program4();
		System.out.println(program.test(args[0]));
	}

	public String test(String expression) {
		return evaluate(expression);
	}

}

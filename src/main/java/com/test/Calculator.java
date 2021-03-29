package com.test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

	private static final Map<Character, BiFunction<Number, Number, Number>> operatorFunctionMap = new HashMap<Character, BiFunction<Number, Number, Number>>();
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.getDefault()));

	static {
		operatorFunctionMap.put('+', (b, a) -> a.doubleValue() + b.doubleValue());
		operatorFunctionMap.put('-', (b, a) -> a.doubleValue() - b.doubleValue());
		operatorFunctionMap.put('*', (b, a) -> a.doubleValue() * b.doubleValue());
		operatorFunctionMap.put('/', (b, a) -> {
			if (b.doubleValue() == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return a.doubleValue() / b.doubleValue();
		});
	}

	public String evaluate(String expression) {
		DECIMAL_FORMAT.setMaximumFractionDigits(340);
		char[] tokens = expression.toCharArray();
		ArrayStack<Number> operandArrayStack = new ArrayStack<Number>();
		ArrayStack<Character> operatorArrayStack = new ArrayStack<Character>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == ' ')
				continue;
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuilder stringBuffer = new StringBuilder();
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					stringBuffer.append(tokens[i++]);
				operandArrayStack.push(Integer.parseInt(stringBuffer.toString()));
				i--;
			} else if (tokens[i] == '(')
				operatorArrayStack.push(tokens[i]);
			else if (tokens[i] == ')') {
				while (operatorArrayStack.peek() != '(')
					operandArrayStack.push(operatorFunctionMap.get(operatorArrayStack.pop()).apply(operandArrayStack.pop(), operandArrayStack.pop()));
				operatorArrayStack.pop();
			} else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				while (!operatorArrayStack.isEmpty() && hasPrecedence(tokens[i], operatorArrayStack.peek()))
					operandArrayStack.push(operatorFunctionMap.get(operatorArrayStack.pop()).apply(operandArrayStack.pop(), operandArrayStack.pop()));
				operatorArrayStack.push(tokens[i]);
			}
		}
		while (!operatorArrayStack.isEmpty())
			operandArrayStack.push(operatorFunctionMap.get(operatorArrayStack.pop()).apply(operandArrayStack.pop(), operandArrayStack.pop()));
		return DECIMAL_FORMAT.format(operandArrayStack.pop());
	}

	public boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
	}

	public static void main(String[] args) {
		if (args == null || args.length == 0)
			throw new IllegalArgumentException("No arguments were provided");
		Calculator calculator = new Calculator();
		System.out.println(calculator.evaluate(args[0]));
	}

}

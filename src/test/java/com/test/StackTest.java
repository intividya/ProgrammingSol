package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackTest {

	@Test
	public void test() {
		Stack<Integer> stack = new ArrayStack<>();
		stack.push(10);
		stack.push(20);
		stack.push(40);
		Assertions.assertEquals(stack.size(), 3);
		Assertions.assertEquals(stack.peek(), 40);
		Assertions.assertEquals(stack.pop(), 40);
		Assertions.assertEquals(stack.pop(), 20);
		Assertions.assertEquals(stack.pop(), 10);
		Assertions.assertEquals(stack.size(), 0);
		Assertions.assertTrue(stack.isEmpty());
	}

}

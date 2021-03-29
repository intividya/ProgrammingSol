package com.test;

public interface Stack<T> {

	T pop();

	void push(T t);

	T peek();

	boolean isEmpty();

	int size();

}

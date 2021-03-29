
package com.test;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {

	protected Object[] elements;
	protected int count;
	protected int incrementSizeBy = 10;

	public ArrayStack() {
		elements = new Object[20];
	}

	@Override
	public void push(T item) {
		ensureCapacityHelper(count + 1);
		elements[count++] = item;
	}

	private void ensureCapacityHelper(int minCapacity) {
		if (minCapacity - elements.length > 0)
			grow(minCapacity);
	}

	private void grow(int minSize) {
		int newSize = elements.length + incrementSizeBy;
		if (newSize - minSize < 0)
			newSize = minSize;
		elements = Arrays.copyOf(elements, newSize);
	}

	@Override
	public T pop() {
		T obj;
		int len = size();
		obj = peek();
		removeElementAt(len - 1);
		return obj;
	}

	@Override
	public T peek() {
		int len = size();
		if (len == 0)
			throw new EmptyStackException();
		return elementAt(len - 1);
	}

	@SuppressWarnings("unchecked")
	public T elementAt(int index) {
		if (index >= count) {
			throw new ArrayIndexOutOfBoundsException(index + " >= " + count);
		}
		return (T) elements[index];
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return count;
	}

	public void removeElementAt(int index) {
		if (index >= count)
			throw new ArrayIndexOutOfBoundsException(index + " >= " + count);
		else if (index < 0)
			throw new ArrayIndexOutOfBoundsException(index);
		int j = count - index - 1;
		if (j > 0)
			System.arraycopy(elements, index + 1, elements, index, j);
		count--;
		elements[count] = null;
	}

}

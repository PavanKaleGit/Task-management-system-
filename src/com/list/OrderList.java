package com.list;

import java.util.AbstractList;
import java.util.Arrays;

public class OrderList<E> extends AbstractList<E>{
	
	private Object[] elements;
	private int size =0;
	
	public OrderList()
	{
		elements = new Object[10];
	}

	@Override
	public E get(int index) {
	if (index >= size || index <0){
		throw new IndexOutOfBoundsException();
	}
		return (E) elements[index];
	}
	
	public boolean add(E e)
	{
		ensureCapacity(size + 1);
		elements[size++] = e;
		return true;
	}
	
	public E remove(int index)
	{
		if(index >= size || index <0)
		{
			throw new IndexOutOfBoundsException();
		}
		E oldValue = (E) elements[index];
		int numMoved = size - index -1;
		if(numMoved >0)
		{
			System.arraycopy(elements, index + 1, elements, index, numMoved);
			
		}
		elements[--size] =null;
		return oldValue;
		
	}
	
	

	@Override
	public int size() {
		
		return size;
	}
	
	private void ensureCapacity(int minCapacity)
	{
		if(minCapacity > elements.length)
		{
		
			int newCapacity = Math.max(minCapacity, elements.length * 2);
			
			elements = Arrays.copyOf(elements, newCapacity);
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

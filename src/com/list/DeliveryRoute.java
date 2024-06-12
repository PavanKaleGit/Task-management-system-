package com.list;

import java.util.AbstractSequentialList;
import java.util.LinkedList;
import java.util.ListIterator;

public class DeliveryRoute<E> extends AbstractSequentialList<E> {

	private LinkedList<E> list = new LinkedList<>();

	@Override
	public ListIterator<E> listIterator(int index) {
		
		return list.listIterator(index);
	}

	@Override
	public int size() {

		return list.size();
	}
	
	public boolean add( E e)
	{
		list.add(e);
		return true ;
		
	}
	public E remove (int index)
	{
		ListIterator<E> a= list.listIterator(index);
		
		E element = a.next();
	      a.remove();
	      return element ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.mgd.math;

import com.mgd.math.Rectangle;

import java.util.List;
import java.util.ArrayList;
/**
  *@author:michael dunleavy
  */

public class FibonacciSeq{
	//provide singleton access, keep thread safe
	private volatile static FibonacciSeq instance;

	public static FibonacciSeq getInstance(){
		if(instance == null){
			synchronized(FibonacciSeq.class){
				if(instance == null){
					instance = new FibonacciSeq();
				}
			}
		}
		return instance;
	}

	// Dont exceed 20 (values to big to use, possible wrapping error!)
	private static final int NUM_VALUES = 20;

	private List<Integer> sequenceList;

	private FibonacciSeq(){
		sequenceList = new ArrayList<>();
		sequenceList = getSequence(NUM_VALUES);
	}

	private List<Integer> getSequence(int numValues){
		List<Integer> list = new ArrayList<>();

		// fib seq: 1, 1, 2, 3, 5, 8, ...
		list.add(1); list.add(1);
		for(int i = 2; i < numValues; ++i){
			int sum = list.get(i-2) + list.get(i-1);
			list.add(sum);
		}

		return list;
	}

	public List<Integer> getSubList(int start, int end){
		List<Integer> newList = new ArrayList<>();
		int size = end - start;
		if(size <= 0) {
			System.out.println("invalid fib index");
			return newList;
		}
		if(start < 0 || start >= NUM_VALUES) {
			System.out.println("Invalid fib start index");
			return newList;
		}
		if(end <= 0 || end > NUM_VALUES){
			System.out.println("Invalid Fib end index");
			return newList;
		}

		for(int i = start; i < end; ++i){
			newList.add(sequenceList.get(i));
		}
		return newList;
	}

	public int getValueAt(int index) {
		// check bounds
		if(index < 0 || index >= NUM_VALUES){
			System.out.println("OUT OF BOUNDS FIB SEQ!");
			return 0;
		}
		return sequenceList.get(index);
	}
	public int getIndexOf(int val){
		int offset = 0;
		boolean found = false;
		for(Integer i : sequenceList){
			if(i == val) {
				found = true;
				break;
			}
			offset++;
		}
		if (!found){
			System.out.println(val + " is not in the "
					+ "defined fibonacci sequence");
		}
		return offset;
	}
	public int getSequenceSize() { return NUM_VALUES; }

	/**
	  *@param: value
	  *value to be returned is the closest number lower than 'value'
	  */
	public int getClosestLowerValue(int value){
		int index = 0;
		for(int i = 1; i < sequenceList.size(); ++i){
			if(value > sequenceList.get(i)){
				index = i;
			}
		}
		return sequenceList.get(index);

	}

	public boolean isInSequence(int number){
		for(Integer i : sequenceList){
			if(number == i) return true;
		}
		return false;
	}

	public boolean isGoldenRectangle(int width, int height){
		// make width the greatest value to keep algorithm similar
		if(width < height){
			// swap width and height...
			width += height; 
			height -= width;
			width -= height;
		}
		
		// check if they are in sequence!
		if(isInSequence(width)){
			int testHeight = getClosestLowerValue(width-1);
			if(height == testHeight) return true;
		}
		return false;
	}

	public void printSequence(){
		int charCount = 0;
		int charPerLine = 20;
		StringBuilder builder = new StringBuilder();
		builder.append("<---------FIBONACCI SEQUENCE----------->\n");
		for(Integer i : sequenceList){
			builder.append(i + ", ");
			charCount++;

			if(charCount >= charPerLine){
				builder.append("\n");
				charCount = 0;
			}
		}
		System.out.println(builder);
	}
}

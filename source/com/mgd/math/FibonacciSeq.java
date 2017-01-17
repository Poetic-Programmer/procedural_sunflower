package com.mgd.math;

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

	public int getValueAt(int index) {
		// check bounds
		if(index < 0 || index >= NUM_VALUES){
			System.out.println("OUT OF BOUNDS FIB SEQ!");
			return 0;
		}
		return sequenceList.get(index);
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

package own_problem_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import utill.Time.TimedAction;


public class array_compare 
{
	/*
	 * This class simply takes two arrays with numbers and determines the common
	 * numbers between them as well as their frequency.
	 */
	
	//This method returns the common values between the arrays in order of max frequency
	public static HashMap<Integer,Integer> determinArrays(int[] firstArray, int[] secondArray)
	{
		HashMap<Integer,Integer> returnedList = new HashMap<Integer,Integer>();
		for(int valueOne : firstArray)
		{
			for(int valueTwo : secondArray)
			{
				if( valueOne == valueTwo)
				{
					if(!returnedList.containsKey(valueOne))
					{
						returnedList.put(valueOne,1);
					}
					else
					{
						returnedList.replace(valueOne, returnedList.get(valueOne), (returnedList.get(valueOne))+1);
					}
				}
			}
		}
		return returnedList;
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> commonValues = determinArrays(new int[]{1,2,3,4,5}, new int[]{3,2,2,6,7});
		printoutMap_Slowly(commonValues);
	}

	public static void printoutMap_Slowly(HashMap<Integer,Integer> mapOfValues)
	{
		TimedAction.triggerTimedActionStart_Nano();
		System.out.println("Grabbing the results: ");
		Iterator<Integer> iteratorKeys = mapOfValues.values().iterator();
		Iterator<Integer> iteratorValues = mapOfValues.keySet().iterator();
		while(iteratorKeys.hasNext() && iteratorValues.hasNext())
		{
			
			int key = (int) iteratorKeys.next();
			int value = (int) iteratorValues.next();
			System.out.print(" Key: "+value+" Value: "+key);
		}
		System.out.println("\n"+TimedAction.formatLastTimedAction_Nano("The Slow Map Printer", System.nanoTime()));
	}
	
	public static void printoutMap_Fast(HashMap<Integer,Integer> mapOfValues)
	{
		TimedAction.triggerTimedActionStart_Nano();
		System.out.println("Grabbing the results: ");
		for(Entry entry : mapOfValues.entrySet())
		{
			System.out.print(" Key: "+entry.getKey()+" Value: "+entry.getValue());
		}
		System.out.println("\n"+TimedAction.formatLastTimedAction_Nano("The Fast Map Printer", System.nanoTime()));
	}
	/*
	 * public static void printoutMap(HashMap<Integer,Integer> mapOfValues)
	{
		
	}
	 */
	
	public static void printoutArray(Object[] arrayObject)
	{
		System.out.println("Object Array holds: "+arrayObject.length+" items!");
		for(Object item : arrayObject)
		{
			System.out.print(item.toString()+" ");
		}
	}
}

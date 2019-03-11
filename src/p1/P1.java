package p1;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class P1
{
	private ArrayList<Integer> numberslist = new ArrayList<>();
	
	
	private void readFile(String fileName) {
		try {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String n = reader.readLine();
		String numbers = reader.readLine();
		String[] splittedNumber = numbers.split(" ");
		for(int i = 0; i < splittedNumber.length; i++) {
			numberslist.add(Integer.parseInt(splittedNumber[i]));
		}
		
		
		reader.close();
		
		}catch (Exception e)
		{
			System.out.println("Error while reading the file");
		}
		
	}
	
	public void doAlgorithm() {
		ArrayList<Integer> finalList = new ArrayList<>();
		ArrayList<Integer> copy = (ArrayList<Integer>) numberslist.clone();
		Collections.sort(copy);
		Integer smallest = copy.get(0);
		Integer biggest = copy.get(numberslist.size()-1);
		
		numberslist.remove(smallest);
		numberslist.remove(biggest);
		ArrayList<Integer> copyAscending = (ArrayList<Integer>) numberslist.clone();
		ArrayList<Integer> copyDescending = (ArrayList<Integer>) numberslist.clone();
		Collections.sort(copyAscending);
		Collections.sort(copyDescending);
		Collections.reverse(copyDescending);
				
		finalList.add(smallest);
		finalList.add(biggest);
		
		while(!copyAscending.isEmpty() || !copyDescending.isEmpty())
		{
			if(!copyAscending.isEmpty())
			{
				finalList.add(copyAscending.get(0));
				copyDescending.remove(copyAscending.get(0));
				copyAscending.remove(copyAscending.get(0));
			}
			
			if(!copyDescending.isEmpty())
			{

				finalList.add(copyDescending.get(0));
				copyAscending.remove(copyDescending.get(0));
				copyDescending.remove(copyDescending.get(0));
			}
		}
		
		
	
		
		finalList.forEach((x)-> System.out.print(x + " "));
		System.out.println();
		
		
	}
	
	/*
	public static void main(String[] args) {
		P1 p1 = new P1();
		p1.readFile("input1.txt");
		p1.doAlgorithm();
	}*/
	
	
	
	

}

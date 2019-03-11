package p5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.Function;

public class P5 
{
	ArrayList<Integer> numbers = new ArrayList<>();
	ArrayList<Integer> solutions = new ArrayList<>();
	HashMap<String, Function<Integer[],Integer>> functions = new HashMap<>();
	
	public static void main(String[] args) 
	{
		P5 p5 = new P5();
		p5.readFile("input1.txt");
		p5.doAlgorithm();
		
		p5.getSolution();
		
	}
	
	
	private void getSolution() {
		Collections.sort(solutions);
		solutions.forEach((x)-> System.out.print(x + " "));
		System.out.println(" ");
		for(int i = 1; i< Integer.MAX_VALUE; i++) {
			if(!solutions.contains(i)) {
				System.out.println(i);
				break;
			}
		}
		
	}


	public void readFile(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			
			int n = Integer.parseInt(reader.readLine());
			String[] splitted  = reader.readLine().split(" ");
			for(String x : splitted)
			{
				numbers.add(Integer.parseInt(x));
				solutions.add(Integer.parseInt(x));
			}
			reader.close();	
		}catch(Exception e) {

			System.out.println("Error while reading the file");
		}
	}
	
	
	public void doAlgorithm()
	{
		functions.put("*", (x)-> {
			return x[0] * x[1];
		});
		functions.put("/", (x)-> {
			return ( x[0] % x[1] == 0)? x[0]/x[1]: -1;
		});
		functions.put("+", (x)-> {
			return x[0] + x[1];
		});
		functions.put("-", (x)-> {
			return x[0] - x[1];
		});
		
		ArrayList<String> operations = new ArrayList<>();
		operations.add("*");
		operations.add("+");
		operations.add("-");
		operations.add("/");
		
		for(int number : numbers) 
		{
			ArrayList<Integer> copy = (ArrayList<Integer>) numbers.clone();
			copy.remove(copy.indexOf(number));
			startGenerating(number, copy, operations );
			
		}
		
	}
	private void startGenerating(Integer number, ArrayList<Integer> copy, ArrayList<String> operations) 
	{
		
		Integer copyNumber = number.intValue();
		if(copy.size()== 0 || operations.size() == 0)
		{
			
		}
		for(int i= 0; i< copy.size(); i++)
		{
			int nextNum = copy.get(i);
			ArrayList<Integer> copyClone = (ArrayList<Integer>) copy.clone();
			copyClone.remove(copyClone.indexOf(nextNum));
			
			for(int j = 0; j<operations.size(); j++) 
			{
							copyNumber = functions.get(operations.get(j)).apply(new Integer[]{  number,  nextNum});
							if(copyNumber < 0)
								continue;
							ArrayList<String> copyOperations =(ArrayList<String>) operations.clone();
							copyOperations.remove(copyOperations.indexOf(operations.get(j)));
							solutions.add(copyNumber);
							startGenerating(copyNumber, copyClone, copyOperations);
							
			}
			copyNumber = number;
			
		}
		
		
		
	}
	

	
}

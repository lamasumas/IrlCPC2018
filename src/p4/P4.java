package p4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P4 
{
	int max= Integer.MIN_VALUE;
	public ArrayList<Integer> numberList = new ArrayList<>();
	
	/*public static void main(String[] args){
		P4 p4 = new P4();
		 
		p4.readFile("input1.txt");
		p4.doAlgorith(p4.numberList);
		System.out.println(p4.max);
		
		 
	}*/
	public void readFile(String inputFile) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			
			int n = Integer.parseInt(reader.readLine());
			String[] splitted  = reader.readLine().split(" ");
			for(String x : splitted)
				numberList.add(Integer.parseInt(x));
			reader.close();	
		}catch(Exception e) {

			System.out.println("Error while reading the file");
		}
	}
	
	
	public void doAlgorith(List<Integer> divideArray) {


		if(divideArray.size() == 1) 
		{
				max = divideArray.get(0) > max? divideArray.get(0): max ;
		}
		else {
			List<Integer> left =  divideArray.subList(0, divideArray.size()/2);
			List<Integer> right =  divideArray.subList( (divideArray.size()/2 ) , divideArray.size());
			
			
			
			Collections.reverse(left);
			int leftMax = Integer.MIN_VALUE;
			int sum = 0;
			for(int i = 0; i< left.size(); i++)
			{
				sum += left.get(i);
				if (leftMax < sum)
					leftMax = sum;
			}
			int rightMax = Integer.MIN_VALUE ;
			sum = 0;
			for(int i = 0; i< right.size(); i++)
			{
				sum += right.get(i);
				if (rightMax < sum)
					rightMax = sum;
			}
			
			
			if(rightMax+ leftMax > max)
				max = rightMax+leftMax;
			if(leftMax > max )
				max = leftMax;
			if(rightMax > max)
				max = rightMax;
			
			Collections.reverse(left);
			doAlgorith(left);
			doAlgorith(right);
		
		
		}
		
		
		
		
	}
	

}

package p3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class P3 
{
	

	private ArrayList<Integer> deck = new ArrayList<>();
	private int n;
	/*public static void main(String[] args) {
		P3 p3 = new P3();
		p3.readFile("input1.txt");
		p3.doAlgorithm();
		
	}*/
	
	public void readFile(String inputFile) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		
			n = Integer.parseInt(reader.readLine());
	
			for(int i= 0; i < n; i++)
				deck.add(-1);
			
			reader.close();
			
		}catch (Exception e)
	{
		System.out.println("Error while reading the file");
	}		
	}
	
	public void doAlgorithm() {
		int numbers = n;
		int numberToPut = 0;
		boolean put = true;
		while(numbers> 0) {
			if(numbers< n) {
				if ( n%2==0)
					put=true;
			}
			for(int i = 0;i< deck.size(); i++)
			{
				if(deck.get(i)==-1) {
					if(put) {
						deck.set(i, numberToPut);
						numberToPut++;
						numbers--;
						put=!put;
					}else
					{
						put = !put;
					}
					}
				}
				
			}
		
		
		deck.forEach(x -> System.out.print(x + " "));
		
	}
	

}

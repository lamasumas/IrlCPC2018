package p6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class P6 
{
	ArrayList<Integer> possinbleLength = new ArrayList<>();
	
	int min = -1;
	int max = -1;
	int solution = 0;
	public static void main(String[] args) {
		P6 p6 = new P6();
		p6.readFile("input1.txt");
		p6.doAlgorithm();
		System.out.println(p6.solution);
		
	}
	
	public void readFile(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			
			String[] splitted  = reader.readLine().split(" ");
			min = Integer.parseInt(splitted[0]);
			max = Integer.parseInt(splitted[1] );
			reader.close();	
		}catch(Exception e) {

			System.out.println("Error while reading the file");
		}
	}
	
	public void doAlgorithm() {

		if(min<3)
			min= 3;
		if(max < 3)
			max = 3;
		int bob= min+1;
		int lengthOfHouse = 0;
		while (lengthOfHouse< max ) {
				
			for(int adam = min; adam<bob; adam++)
			{
				
				int desiredSize = (adam*adam*adam)+(bob*bob*bob)-1;
				
				lengthOfHouse = (int) Math.cbrt(desiredSize);
				
				int volume = (int)Math.pow(lengthOfHouse, 3); 
			if(volume == desiredSize && lengthOfHouse>=3 && !possinbleLength.contains(lengthOfHouse))
				{
					solution++;
					possinbleLength.add(lengthOfHouse);
				}

			}
			bob++;
			
	}

	
	}
	

}

package p2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class P2 
{
	private ArrayList<Athlete> athletes = new ArrayList<>();
	
	/*public static void main(String[] args) {
		P2 p2 = new P2();
		p2.readFile("input1.txt");
		p2.doAlgorithm();
		
	}*/
	
	
	
	public void readFile(String inputFile) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		
			int n = Integer.parseInt(reader.readLine());
			
			for(int i = 0; i < n; i++) {
				String[] splittedLine  = reader.readLine().split(" ");
				ArrayList<Integer> disputes = new ArrayList<>();
				for(int j = 0; j < splittedLine.length; j++)
				{
					if(splittedLine[j].equals("1"))
						disputes.add(j);
						
				}
				Athlete athlete = new Athlete(i);
				athlete.disputes.addAll(disputes);
				athletes.add(athlete);
				
			}
			reader.close();
		
		}catch (Exception e)
	{
		System.out.println("Error while reading the file");
	}		
	}
	
	
	public void doAlgorithm() {
		ArrayList<Athlete> copy = (ArrayList<Athlete>) athletes.clone();
		
		for(int i=0; i< athletes.size();i++) {
			for(int x : athletes.get(i).disputes) {
				athletes.removeIf(y-> y.id==x);
			}
			
		}
		
		
		athletes.forEach(athlete -> copy.removeIf(copyAthlete -> athlete.id == copyAthlete.id));
		
		athletes.forEach((x)-> System.out.print(x.id +" "));
		System.out.println();
		copy.forEach((x)-> System.out.print(x.id+" "));
		
		
		
		
	}
	
	
	
}

class Athlete{
	public int id;
	public ArrayList<Integer> disputes;
	public Athlete(int id) 
	{
		this.id = id;
		this.disputes = new ArrayList<Integer>();
		
	}
}







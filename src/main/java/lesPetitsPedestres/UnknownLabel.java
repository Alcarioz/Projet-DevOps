package lesPetitsPedestres;

@SuppressWarnings("serial")
public class UnknownLabel extends Exception{

	
	public UnknownLabel(){
		
		System.out.println("Le label demandé n'existe pas.");
	}
}

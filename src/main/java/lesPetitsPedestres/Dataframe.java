package lesPetitsPedestres;

import java.util.ArrayList;

public class Dataframe{
	
	@SuppressWarnings("rawtypes")
	private ArrayList<Series> series;
	private ArrayList<Integer> indexes;
	private int maxSize;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Dataframe(ArrayList<Series> series){
		this.maxSize=0;
		this.series=series;
		for(int i=0;i<series.size();i++){
			if(series.get(i).getSize()>this.maxSize){
				this.maxSize=series.get(i).getSize();
			}
		}
		for(int i=0;i<this.maxSize;i++){
			this.indexes.add(i);
		}
		
		for(int i=0;i<series.size();i++){
			if(series.get(i).getSize()<this.maxSize){
				for(int j=this.series.get(i).getSize();j<this.maxSize;j++){
					series.get(i).addVal(null);
				}
			}
		}
	}
	
	public void printAll(){
		int nbS =this.series.size();
		String labels= "  ";
		for(int j=0;j<nbS;j++){
			labels+=this.series.get(j).getLabel()+ " ";
		}
		System.out.println(labels);
		for(int i=0;i<this.maxSize;i++){
			String ligne=indexes.get(i) + " ";			
			for(int j=0;j<nbS;j++){
				ligne+=this.series.get(j).getVal(i)+ " ";
			}
			System.out.println(ligne);
		}		
	}
	
	public void printFirst(){
		int nbS =this.series.size();
		String labels= "  ";
		for(int j=0;j<nbS;j++){
			labels+=this.series.get(j).getLabel()+ " ";
		}
		System.out.println(labels);
		for(int i=0;i<5;i++){
			String ligne=indexes.get(i) + " ";			
			for(int j=0;j<nbS;j++){
				ligne+=this.series.get(j).getVal(i)+ " ";
			}
			System.out.println(ligne);
		}		
		
	}
	
	public void printFirst(int nb) throws SizeException{
		int nbS =this.series.size();
		if (nb<this.maxSize){
			String labels= "  ";
			for(int j=0;j<nbS;j++){
				labels+=this.series.get(j).getLabel()+ " ";
			}
			System.out.println(labels);
			for(int i=0;i<nb;i++){
				String ligne=indexes.get(i) + " ";			
				for(int j=0;j<nbS;j++){
					ligne+=this.series.get(j).getVal(i)+ " ";
				}
				System.out.println(ligne);
			}
		}else{
			throw new SizeException();
		}
		
	}
	
	
	public void printLast(){
		int nbS =this.series.size();		
		String labels= "  ";
		for(int j=0;j<nbS;j++){
			labels+=this.series.get(j).getLabel()+ " ";
		}
		System.out.println(labels);
		for(int i=this.maxSize-5;i<this.maxSize;i++){
			String ligne=indexes.get(i) + " ";			
			for(int j=0;j<nbS;j++){
				ligne+=this.series.get(j).getVal(i)+ " ";
			}
			System.out.println(ligne);
		}		
	}
	
	public void printLast(int nb) throws SizeException{
		int nbS =this.series.size();
		if (nb<this.maxSize){
			String labels= "  ";
			for(int j=0;j<nbS;j++){
				labels+=this.series.get(j).getLabel()+ " ";
			}
			System.out.println(labels);
			for(int i=this.maxSize-nb;i<this.maxSize;i++){
				String ligne=indexes.get(i) + " ";			
				for(int j=0;j<nbS;j++){
					ligne+=this.series.get(j).getVal(i)+ " ";
				}
				System.out.println(ligne);
			}
		}else{
			throw new SizeException();
		}		
	}

}

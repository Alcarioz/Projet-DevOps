package lesPetitsPedestres;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		this.indexes=new ArrayList<Integer>();
		for(int i=0;i<series.size();i++){//On cherche la plus grande colonne
			if(series.get(i).getSize()>this.maxSize){
				this.maxSize=series.get(i).getSize();
			}
		}
		for(int i=0;i<this.maxSize;i++){//On met à jour les indexes avec la taille de la plus grande colonne
			this.indexes.add(i);
		}
		
		for(int i=0;i<series.size();i++){//On comble les colonnes plus petites
			if(series.get(i).getSize()<this.maxSize){
				for(int j=this.series.get(i).getSize();j<this.maxSize;j++){
					series.get(i).addVal(null);
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Dataframe(String fileName) throws IOException{		
		try		{	
		BufferedReader fichier_source = new BufferedReader(new FileReader(fileName));
		@SuppressWarnings("rawtypes")
		ArrayList<Series> series=new ArrayList<Series>();
		String[] labels = fichier_source.readLine().split(",");
		for (int j=0;j<labels.length;j++){
			@SuppressWarnings({ "rawtypes" })
			Series serie =new Series(labels[j], new ArrayList());
			series.add(serie);
		}		
		String chaine;		
		int i = 0;		
		while((chaine = fichier_source.readLine())!= null){		
			String[] tabChaine = chaine.split(",");	
			for (int j=0;j<labels.length;j++){				
				series.get(j).addVal(tabChaine[i]);		
			}
		i++;
		}			
			fichier_source.close();
			this.maxSize=i;
			this.series=series;
			this.indexes=new ArrayList<Integer>();
			for(int k=0;i<this.maxSize;k++){
				this.indexes.add(k);
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Le fichier est introuvable !");
		}
		
		
	}
	
	
	
	public void printAll(){
		int nbS =this.series.size();
		String labels= "  ";
		for(int j=0;j<nbS;j++){//Ligne de labels
			labels+=this.series.get(j).getLabel()+ " ";
		}
		System.out.println(labels);
		for(int i=0;i<this.maxSize;i++){//Création d'une ligne du dataframe
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
		for(int j=0;j<nbS;j++){//Ligne de labels
			labels+=this.series.get(j).getLabel()+ " ";
		}
		System.out.println(labels);
		for(int i=0;i<5;i++){
			String ligne=indexes.get(i) + " ";			
			for(int j=0;j<nbS;j++){//Création d'une ligne du dataframe
				ligne+=this.series.get(j).getVal(i)+ " ";
			}
			System.out.println(ligne);
		}		
		
	}
	
	public void printFirst(int nb) throws SizeException{
		int nbS =this.series.size();
		if (nb<this.maxSize){//Ligne de labels
			String labels= "  ";
			for(int j=0;j<nbS;j++){
				labels+=this.series.get(j).getLabel()+ " ";
			}
			System.out.println(labels);
			for(int i=0;i<nb;i++){//Création d'une ligne du dataframe
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
		for(int j=0;j<nbS;j++){//Ligne de labels
			labels+=this.series.get(j).getLabel()+ " ";
		}
		System.out.println(labels);
		for(int i=this.maxSize-5;i<this.maxSize;i++){
			String ligne=indexes.get(i) + " ";			
			for(int j=0;j<nbS;j++){//Création d'une ligne du dataframe
				ligne+=this.series.get(j).getVal(i)+ " ";
			}
			System.out.println(ligne);
		}		
	}
	
	
	
	public void printLast(int nb) throws SizeException{
		int nbS =this.series.size();
		if (nb<this.maxSize){//Ligne de labels
			String labels= "  ";
			for(int j=0;j<nbS;j++){
				labels+=this.series.get(j).getLabel()+ " ";
			}
			System.out.println(labels);
			for(int i=this.maxSize-nb;i<this.maxSize;i++){
				String ligne=indexes.get(i) + " ";			
				for(int j=0;j<nbS;j++){//Création d'une ligne du dataframe
					ligne+=this.series.get(j).getVal(i)+ " ";
				}
				System.out.println(ligne);
			}
		}else{
			throw new SizeException();
		}		
	}
	
	@SuppressWarnings("unchecked")
	public void addSerie(@SuppressWarnings("rawtypes") Series serie){
		int oldMaxSize=this.maxSize;
		if(serie.getSize()>this.maxSize){//La nouvelle colonne est la plus grande
			maxSize=serie.getSize();
			for(int i=oldMaxSize;i<this.maxSize;i++){//maj indexes
				this.indexes.add(i);
			}
			for(int i=0;i<series.size();i++){//On comble les colonnes plus petites
				if(series.get(i).getSize()<this.maxSize){
					for(int j=this.series.get(i).getSize();j<this.maxSize;j++){
						series.get(i).addVal(null);
					}
				}
			}
		}else{//La nouvelle colonne n'est pas la plus grande, on la comble
			for(int j=serie.getSize();j<this.maxSize;j++){
				serie.addVal(null);
			}
		}		
		this.series.add(serie);
		
	}
	
	@SuppressWarnings("rawtypes")
	public Series getSerie(String label) throws UnknownLabel{
		for(int i=0;i<this.series.size();i++){
			if(label.equals(this.series.get(i).getLabel())){
				return this.series.get(i);
			}
		}
		throw new UnknownLabel();		
	}
	
	@SuppressWarnings("rawtypes")
	public Dataframe selectByLabel(ArrayList<String> labels){		
		ArrayList<Series> series = new ArrayList<Series>();
		for(int i=0;i<this.series.size();i++){
			for(int j=0; j<labels.size();j++){
				if(labels.get(i).equals(this.series.get(i).getLabel())){
					series.add(this.series.get(i));
				}
			}
		}				
		return new Dataframe(series);
		
	}

}

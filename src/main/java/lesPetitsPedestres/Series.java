package lesPetitsPedestres;

import java.util.ArrayList;

public class Series<T> {
	
	private String label;
	private ArrayList<T> array;

	Series(String label, ArrayList<T> array){
		this.label=label;
		this.array=array;
	}
	
	public String getLabel(){
		return this.label;
	}
	
	public ArrayList<T> getArray(){
		return this.array;
	}
	
	public int getSize(){
		return this.array.size();
	}
	
	public void addVal(T val){
		this.array.add(val);
	}
	
	public T getVal(int index){
		return this.array.get(index);
	}
}

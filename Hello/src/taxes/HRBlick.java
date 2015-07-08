package taxes;

import java.util.ArrayList;
import java.util.List;

public class HRBlick {

	public static void computeTaxes(List<Taxable> lt) {
		
	}
	
	public static void computeTaxes(Taxable[] ta) {
		ta[0] = new Corporation();
	}
	
	public static void main(String[] args) {
		List<Taxable> lt = new ArrayList<>();
		lt.add(new Corporation());
		lt.add(new Individual());
		computeTaxes(lt);
		
		List<Individual> li = new ArrayList<>();
//		computeTaxes(li);
		
		Individual[] ia = {null, null};
		computeTaxes(ia);
	}

}

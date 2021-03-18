import java.util.ArrayList;
import java.util.List;

/**
 * this class is used to find degree of the multivariate polynomial
 * Using nested List
 * @author yash.porwal_metacube
 *
 */
public class Polynomial {

	List<ArrayList<LinkedList>> poly = 
									new ArrayList<ArrayList<LinkedList>>(); 
	
	int degree = 0;
	
	/**
	 * this is used to add element in the nested list
	 * @param powers this is an integer array containing powers
	 * @param coeff this is an integer coefficient of polynomial  
	 */
	public void addElement(int[] powers,int coeff ){
		ArrayList <LinkedList> exp = new ArrayList<LinkedList>(); 
		LinkedList newElement = new LinkedList();
		newElement.insert(coeff);
		int elementDegree = 0;
		for(int i=0;i<powers.length;i++){
			elementDegree += powers[i];
			newElement.insert(powers[i]);
		}
		this.degree = elementDegree > degree ? elementDegree : degree;
		exp.add(newElement);
		poly.add(exp);
	}
	
	/**
	 * getter of Degree (highest) of polynomial
	 * @return integer value of degree
	 */
	public int getDegree() {
		return degree;
	}
}

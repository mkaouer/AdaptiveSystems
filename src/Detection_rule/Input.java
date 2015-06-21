/**
 * 
 */
package Detection_rule;

import java.util.Vector;

/**
 * @author User
 *
 */
public class Input {

	/**
	 * @param args
	 * @return 
	 * @return 
	 */
	public static  String[] Context() {
		String [] Context= { "Age","Motivation","Education Level","User Experience","Interest"};
	
		
		return Context;

	}
	public static  String[] ValuesOfContext() {
		String [] Values= { "L","M","H"};
	
	
		return Values;

	}
	public static  String[] Metrics() {
		String [] Metrics= { "Regularity","Grouping","Sequence","Simplicity","Unity","Density","Symmetry","Homogeneity"};
	
		
		return Metrics;

	}
	public static  String[] Operator() {
		String [] Operator= { "<=",">="};
	
		
		return Operator;

	}

	public static  String[] Problem() {
		String [] Problem= { "Problem11","Problem12","Problem21","Problem22","Problem31","Problem32","Problem41","Problem42","Problem51","Problem52","Problem61","Problem62","Problem71","Problem72","Problem81","Problem82"};
	
		
		return Problem;

	}
	

}

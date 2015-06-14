package Detection_rule;
import java.lang.*;
import java.util.Random;

public class Rule
{ 
  
	public String src;
  public  String src0;
    public String src2;
    public String src3;
    public String trg;
    
    public String rule_text ;
    
    public Rule()
    { 
     
       rule_text = new String();
    }
    
    public void print_rule( )
    { Random number_generator = new Random();
    	double source_index = number_generator.nextDouble();
	
        String temp = new String("IF (");
        temp = temp.concat(src);
        temp = temp.concat("=");
        temp = temp.concat(src0);
        temp = temp.concat(") and ( ");
        temp = temp.concat(src2);
        temp = temp.concat(src3);
        temp = temp.concat(Double.toString(source_index));
        temp = temp.concat(" ) THEN ( ");
        temp = temp.concat(trg);
        temp = temp.concat(" )");
        rule_text = temp ;
    }}

    



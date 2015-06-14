
package Main;
import java.util.ArrayList;

import java.util.Random;

import Detection_rule.Input;

import Detection_rule.MetaModel;
import Detection_rule.Rule;
public class  RuleMain 
{   ArrayList<Rule> rules ;
     int max_rule_size = 1000;
	
   RuleMain()
	      {  
		 rules = new ArrayList<Rule>();
		
	        new ArrayList<MetaModel>();
	        
	      }
   
 
   
	
   void create_rules(Input r, int min_rules_size,int max_rules_size)
{ 
    int rules_size;
    int source_index;
    int source_index0;
    int source_index1;
 int   source_index2;
    int target_index;
    Random number_generator = new Random(); 
    rules_size = min_rules_size + (int)(Math.random() * ((max_rules_size - min_rules_size) + 1));
    //rules_size = number_generator.nextInt(max_rules_size);
    if (rules_size < min_rules_size) rules_size = min_rules_size ;
    
    //System.out.println("\n number of rules to create : "+rules_size);
    
    for (int i=0; i<rules_size;i++)
    {
        source_index = number_generator.nextInt(Input.Context().length);
        source_index0= number_generator.nextInt(Input.ValuesOfContext().length);
        source_index1 = number_generator.nextInt(Input.Metrics().length);
        source_index2 = number_generator.nextInt(Input.Operator().length);
        target_index = number_generator.nextInt(Input.Problem().length);
       // System.out.println(source_index1);
        Rule temp = new Rule();
        temp.src =  Input.Context()[source_index];
        temp.src0 = Input.ValuesOfContext()[source_index0];
        temp.src2 = Input.Metrics()[source_index1];
        temp.src3 = Input.Operator()[source_index2];
        temp.trg =  Input.Problem()[target_index];
    //    print_metamodel(temp.src,temp.src0,temp.src2,temp.trg);
        
        temp.print_rule();
        rules.add(temp);
       System.out.println(temp.rule_text);}
        
    }
 void print_rules()
  {
      System.out.println("\n Tree decomposition into leaves : ");
      for (int i=0; i<rules.size();i++)
      {
          System.out.println("\n leaf number "+(i+1)+" : "+rules.get(i).rule_text);
      }
  }
    
  public static void main (String[] args)  
  {
        int min_rules_size = 30;
        int max_rules_size = 100
        		;
        RuleMain R = new RuleMain();
        Input input = new Input();
       
        R.create_rules(input, min_rules_size, max_rules_size);}
}
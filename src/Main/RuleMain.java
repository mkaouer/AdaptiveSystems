
package Main;
import java.util.ArrayList;
import java.util.Random;

import Detection_rule.InputReader;
import Detection_rule.MetaModel;
import Detection_rule.Rule;
public class  RuleMain 
{   ArrayList<Rule> rules ;
     int max_rule_size = 1000;
	
   RuleMain()
	      {  
		 rules = new ArrayList<Rule>();
		
	        //perfect_rules = new ArrayList<Rule>();
	        //correct_rules = new ArrayList<Integer>();
	        ArrayList<MetaModel> output = new ArrayList<MetaModel>();
	        
	      }
	
   void create_rules(InputReader r, int min_rules_size,int max_rules_size)
{ 
    int rules_size;
    int source_index;
    int source_index1;
    int target_index;
    Random number_generator = new Random(); 
    rules_size = min_rules_size + (int)(Math.random() * ((max_rules_size - min_rules_size) + 1));
    //rules_size = number_generator.nextInt(max_rules_size);
    if (rules_size < min_rules_size) rules_size = min_rules_size ;
    
    //System.out.println("\n number of rules to create : "+rules_size);
    
    for (int i=0; i<rules_size;i++)
    {
        source_index = number_generator.nextInt(r.source.size());
        source_index1 = number_generator.nextInt(r.source2.size());
        target_index = number_generator.nextInt(r.target.size());
        
        Rule temp = new Rule();
        temp.src = r.source.get(source_index);
        temp.src2 = r.source2.get(source_index1);
        temp.trg = r.target.get(target_index);
        temp.src.print_metamodel();
        temp.src2.print_metamodel();
        temp.trg.print_metamodel();
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
        InputReader input = new InputReader();
        input.read_input_files();
        R.create_rules(input, min_rules_size, max_rules_size);}
}

package Main;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
 







import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import Detection_rule.Input;
import Detection_rule.MetaModel;
import Detection_rule.Rule;
public class  RuleMain 
{   ArrayList<Rule> rules ;
ArrayList<Rule> perfect_rules ;
     int max_rule_size = 1000;
	Input r;
	String Rule; 
	String[] Rules;
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
        System.out.println(temp.rule_text);
         
  }
   /* for (int i=0; i<rules.size();i++)
    { Rule= (String) rules.get(i).rule_text;
    Rules[i]=Rule;}*/
        
    }
 void print_rules()
  {
      System.out.println("\n Tree decomposition into leaves : ");
      for (int i=0; i<rules.size();i++)
      {
          System.out.println("\n leaf number "+(i+1)+" : "+rules.get(i).rule_text);
      }
  }

 @SuppressWarnings("null")
void evaluate_rules() throws FileNotFoundException, IOException{
	 int fit=0;
	 int k=1;
	 Workbook workbook = null;

		/* Récupération du classeur Excel (en lecture) */
		try {
			workbook = Workbook.getWorkbook(new File("Trace/Trace.xls"));
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* Un fichier excel est composé de plusieurs feuilles, on y accède de la manière suivante*/
		Sheet sheet =  workbook.getSheet(0);
	  for (int i=0; i<rules.size();i++){
		  String  Context =rules.get(i).src ;
		  String Problem=rules.get(i).trg ;
		  System.out.println("Context:"+Context);
		 
		  for(int j=0;j<5;j++){
		  jxl.Cell cell =  sheet.getCell(j, 0);
			String Cont =  cell.getContents();
			System.out.println(Cont);
			
          if((Context.equalsIgnoreCase(Cont))){
		 
			  String  Valeur =rules.get(i).src0 ;
			  System.out.println("la valeur:"+Valeur);
			  while (k<64){
				  jxl.Cell cell21 =  sheet.getCell(5, k);
				  String Pro1 =  cell21.getContents();
				  System.out.println(Pro1);
                	jxl.Cell Valeurs =  sheet.getCell(j, k);
                	String Val =  Valeurs.getContents();
                	System.out.println("val est:"+Val);
                	   if((Valeur.equalsIgnoreCase(Val)&&(Problem.equalsIgnoreCase(Pro1)))){
                		   System.out.println("la regle est :"+rules.get(i).rule_text );
                		//   String r=rules.get(i).rule_text;
                		   for (int l=0; l<i;l++){
                		   Rule temp = new Rule();
                		   temp.src = rules.get(i).src;
                	        temp.src0 = rules.get(i).src0;
                	        temp.src2 = rules.get(i).src2;
                	        temp.src3 =rules.get(i).src3;
                	        temp.trg =  rules.get(i).trg;
                	        temp.print_rule();
                		 perfect_rules.add(temp);
                		  System.out.println("la meilleur regle est :"+temp.rule_text ); }
                		 fit++;
                	   }
                	   k++;
                }
	}
	

		  }}	 
	
	  System.out.println(fit);
 }
 
    
  public static void main (String[] args) throws FileNotFoundException, IOException  
  {
        int min_rules_size = 30;
        int max_rules_size = 100
        		;
        RuleMain R = new RuleMain();
        Input input = new Input();
       
        R.create_rules(input, min_rules_size, max_rules_size);
     
        R.evaluate_rules();}
}
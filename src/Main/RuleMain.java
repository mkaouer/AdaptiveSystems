
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

 void evaluate_rules() throws FileNotFoundException, IOException{
	 
	 

	 
	 
	 
	 
	 
	 
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
		 
		/*final int FIN = 10; //Le nombre que tu souhaites ici
		for(int i = 0; i < FIN; i++){
		Cell cell = (Cell) sheet.getCell(0, i);
		String test = ((jxl.Cell) cell).getContents();
		System.out.println(test);*/
		
		// On accède aux cellules avec la méthode getCell(indiceColonne, indiceLigne) 
		jxl.Cell a1 = sheet.getCell(0,0); 
		
		/* On peut également le faire avec getCell(nomCellule)
		Cell c5 = sheet.getCell("C5"); */
		
		/* On peut récupérer le contenu d'une cellule en utilisant la méthode getContents() */
		String contenuA1= a1.getContents();
		//String contenuC5 = c5.getContents();
		
		System.out.println(contenuA1);
		//System.out.println(contenuC5);
	
 }
	
	
 
   /*  individual_quality = 0 ;
     individual_complexity = 0 ;
     tables_number = 0;
     columns_number = 0;
     primary_keys_number = 0;
     correct_rules = new ArrayList<Integer>();
     this.evaluation_empty_table();
     this.evaluation_primary_foreign_keys();
    
     
     // tables number :
     for (int i=0; i<output.size();i++)
             {
                 if(output.get(i).prefixes.get(0).getText().equals("Table"))
                 {
                     tables_number++;
                 }
             }
     // columns number :
     for (int i=0; i<output.size();i++)
             {
                 if(output.get(i).prefixes.get(0).getText().equals("Column"))
                 {
                     columns_number++;
                 }
             }
     // primary keys number :
     for (int i=0; i<output.size();i++)
             {
                 if(output.get(i).suffixes.size()>1)
                 {
                     if(output.get(i).suffixes.get(output.get(i).suffixes.size()-1).getText().equals("pk"))
                     {
                         primary_keys_number++;
                     }
                 }  
             }
     int max1 ;
     if(tables_number>(metrics.tables_lower_bound + (tables_number*this.rules.size()))) max1 = tables_number ; else max1 = metrics.tables_lower_bound + this.rules.size() ;
     int max2 ;
     if(columns_number>(metrics.columns_lower_bound + (columns_number*this.rules.size()))) max2 = columns_number ; else max2 = metrics.columns_lower_bound + this.rules.size() ;
     int max3 ;
     if(primary_keys_number>(metrics.primary_keys_lower_bound + (primary_keys_number*this.rules.size()))) max3 = primary_keys_number ; else max3 = metrics.primary_keys_lower_bound + this.rules.size() ;
     
     individual_quality = Math.abs(metrics.tables_lower_bound );
     individual_quality += Math.abs(metrics.columns_lower_bound );
     individual_quality +=Math.abs(metrics.primary_keys_lower_bound );
     individual_quality /= (double) (tables_number+columns_number+primary_keys_number) ;
     //System.out.print("\n number of detected tables : "+tables_number);
     //System.out.print("\n number of detected columns : "+columns_number);
     //System.out.print("\n number of expected tables : "+metrcis.tables_lower_bound);
     //System.out.print("\n number of expected columns : "+metrcis.columns_lower_bound);
     //System.out.print("\n Individual Quality : "+individual_quality);
     
     this.complexity_calc();
     
     // Checking rules unprecision :
     
      for (int i=0; i<rules.size();i++)
      {
         //System.out.println("\n checking correct rules number at iteration : "+(i+1)+" is "+correct_rules.size());
         if((rules.get(i).src.prefixes.get(0).getText().equals("Class"))&&rules.get(i).trg.prefixes.get(0).getText().equals("Table"))
         {
             correct_rules.add(i);
             //System.out.println("\n class - table working");
         }
         else if((rules.get(i).src.prefixes.get(0).getText().equals("Attribute"))&&(rules.get(i).src.suffixes.get(2).getText().equals("unique")))
         {
             if((rules.get(i).trg.prefixes.get(0).getText().equals("Column"))&&(rules.get(i).trg.suffixes.get(2).getText().equals("pk")))
             {
                 correct_rules.add(i);
                 //System.out.println("\n att unique working");
             }

         }
         else if((rules.get(i).src.prefixes.get(0).getText().equals("Attribute"))&&(rules.get(i).src.suffixes.get(2).getText().equals("notunique")))
         {
             if((rules.get(i).trg.prefixes.get(0).getText().equals("Column"))&&(rules.get(i).trg.suffixes.get(2).getText().equals("_")))
             {
                 correct_rules.add(i);
                 //System.out.println("\n att notunique working");
             }
         }
         else if((rules.get(i).src.prefixes.get(0).getText().equals("Association"))&&(rules.get(i).src.suffixes.get(1).getText().equals("1")))
         {
             if((rules.get(i).trg.prefixes.get(0).getText().equals("Column"))&&(rules.get(i).trg.suffixes.get(2).getText().equals("fk")))
             {
                 correct_rules.add(i);
                 //System.out.println("\n ass fk working");
             }

         }
         else if((rules.get(i).src.prefixes.get(0).getText().equals("Association"))&&(rules.get(i).src.suffixes.get(1).getText().equals("n")))
         {
             if((rules.get(i).trg.prefixes.get(0).getText().equals("Column"))&&(rules.get(i).trg.suffixes.size()==4))
             {
                 correct_rules.add(i);
                 //System.out.println("\n ass pfk working");
             }
         }
         else if((rules.get(i).src.prefixes.get(0).getText().equals("Generalization")))
         {
             if((rules.get(i).trg.prefixes.get(0).getText().equals("Column"))&&(rules.get(i).trg.suffixes.get(2).getText().equals("pfk")))
             {
                 correct_rules.add(i);
                 //System.out.println("\n generalization working");
             }
         }
      }
      this.correct_rules_ratio = (double)correct_rules.size()/rules.size();
      
      // calculating constraints
      
      double temp1 = 0 ;
      double temp2 = 0 ;
      
      if (this.total_tables != 0)
      {
          temp1 = (double)(this.not_empty_table/this.total_tables);
      }
      if (this.total_fkeys != 0)
      {
          temp2 = (double)(this.fk_is_pk/this.total_fkeys);
      }
      
      //System.out.println("\n not_empty_table/this.total_tables : "+temp1);
      //System.out.println("\n this.fk_is_pk/this.total_fkeys : "+temp2);
      
      this.metamodel_constraints_ratio = (double) (temp1 + temp2 + 1.0 + 1.0) / 4.0 ;
      
      // unprecision :
      
      individual_unprecision = 1 - (0.75*metamodel_constraints_ratio + correct_rules_ratio*0.25) ;
 }
 

 
*/
 
 
    
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
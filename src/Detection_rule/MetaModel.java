package Detection_rule;


import java.io.*;
import java.text.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author MWM
 */
public class MetaModel 
{
    String[] Context ;
    
    String[] Values ;
    String[] Metrics;
   String[] Problem;
    
    String metamodel_text ;
    String metamodel_text1 ;
    String metamodel_text2 ;
    
    MetaModel ()
    {
       
        metamodel_text = new String("");
        metamodel_text1 = new String("");
        metamodel_text2 = new String("");
    }
    
    MetaModel (MetaModel m)
    {
        this.Context = m.Context;
        this.Values = m.Values ;
        this.Metrics = m.Metrics ;
        this.Problem = m.Problem ;
        this.metamodel_text = m.metamodel_text;
        this.metamodel_text1 = m.metamodel_text1;
        this.metamodel_text2 = m.metamodel_text2;
    }
    
    public void print_metamodel()
    {
        String temp = new String("");
        String temp1 = new String("");
        String temp2 = new String("");
        int i = 0;
        
        //System.out.println("\n size of prefixes : "+prefixes.size());
        //System.out.println("\n size of suffixes : "+suffixes.size());
        
        i=0;
        while(i<Context.length)
        {
            temp = temp.concat(Context[i]);
            temp1 = temp1.concat(Context[i]);
            temp2 = temp2.concat(Context[i]);
          
            //System.out.println("\n"+prefixes.get(i).getText());
            //System.out.println("\n"+temp);
            i++;
        }
        temp = temp.concat("=");
        temp1 = temp1.concat("=>");
        temp2 = temp2.concat("");
        i=0;
        while(i<Values.length)
        {
            temp = temp.concat(Values[i]);
            temp1 = temp1.concat(Values[i]);
            temp2 = temp2.concat(Values[i]);
            
            i++;
            //if (i == suffixes.size()) temp = temp.concat(")");
            //else temp = temp.concat(",");
            
        }
        i=0;
        while(i<Metrics.length)
        {
            temp = temp.concat(Metrics[i]);
            temp1 = temp1.concat(Metrics[i]);
            temp2 = temp2.concat(Metrics[i]);
            
            i++;
            //if (i == suffixes.size()) temp = temp.concat(")");
            //else temp = temp.concat(",");
            
        }
        temp = temp.concat("=");
        temp1 = temp1.concat("=>");
        temp2 = temp2.concat("");
        i=0;
        while(i<Problem.length)
        {
            temp = temp.concat(Problem[i]);
            temp1 = temp1.concat(Problem[i]);
            temp2 = temp2.concat(Problem[i]);
            
            i++;
            //if (i == suffixes.size()) temp = temp.concat(")");
            //else temp = temp.concat(",");
            
        }
        metamodel_text = temp;
        metamodel_text1 = temp1;
        metamodel_text2 = temp2;
        
    }
    
}

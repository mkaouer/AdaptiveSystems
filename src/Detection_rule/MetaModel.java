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
    Element name ;
    
    List<Element> prefixes ;
    List<Element> suffixes ;
    
    String metamodel_text ;
    String metamodel_text1 ;
    String metamodel_text2 ;
    
    MetaModel ()
    {
        Element name = new Element("null");
        prefixes= new ArrayList<Element>() ;
        suffixes= new ArrayList<Element>() ;
        metamodel_text = new String("");
        metamodel_text1 = new String("");
        metamodel_text2 = new String("");
    }
    
    MetaModel (MetaModel m)
    {
        this.name = m.name;
        this.prefixes = m.prefixes ;
        this.suffixes = m.suffixes ;
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
        while(i<prefixes.size())
        {
            temp = temp.concat(prefixes.get(i).getText());
            temp1 = temp1.concat(prefixes.get(i).getText());
            temp2 = temp2.concat(prefixes.get(i).getText());
          
            //System.out.println("\n"+prefixes.get(i).getText());
            //System.out.println("\n"+temp);
            i++;
        }
        temp = temp.concat("=");
        temp1 = temp1.concat("=>");
        temp2 = temp2.concat("");
        i=0;
        while(i<suffixes.size())
        {
            temp = temp.concat(suffixes.get(i).getText());
            temp1 = temp1.concat(suffixes.get(i).getText());
            temp2 = temp2.concat(suffixes.get(i).getText());
            
            i++;
            //if (i == suffixes.size()) temp = temp.concat(")");
            //else temp = temp.concat(",");
            
        }
        metamodel_text = temp;
        metamodel_text1 = temp1;
        metamodel_text2 = temp2;
        
    }
    
}

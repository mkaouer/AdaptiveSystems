package Detection_rule;


// Class that will represent a system file name

import java.io.File;

// Used to write data to a file

import java.io.FileOutputStream;

// Triggered when an I/O error occurs

import java.io.IOException;

// Represents your XML document and contains useful methods

import org.jdom2.Document;

// Represents XML elements and contains useful methods

import org.jdom2.Element;

// Top level JDOM exception

import org.jdom2.JDOMException;

// Represents text used with JDOM

import org.jdom2.Text;

// Creates a JDOM document parsed using SAX Simple API for XML

import org.jdom2.input.SAXBuilder;

// Formats how the XML document will look

import org.jdom2.output.Format;

// Outputs the JDOM document to a file

import org.jdom2.output.XMLOutputter;

// for the lists

import java.util.*;
 
public class InputReader 
{
    Element root ;
    
    List<Element> elements ;
    
    List<Element> prefixes ;
    List<Element> suffixes ;
    
    String source_metamodel_path ;
    String source_metamodel_path1 ;
    String target_metamodel_path ;
    String source_model_path ;
    String quality_metrics_path ;
    
    MetaModel temp ;
    
    public ArrayList<MetaModel> source ;
    public ArrayList<MetaModel> source2 ;
    public ArrayList<MetaModel> target ;
    //ines
   ArrayList<MetaModel> source_metamodel_elements ;
   ArrayList<MetaModel> target_metamodel_elements ;
    
    ArrayList<MetaModel> model ;
    
    int tables_lower_bound ;
    int columns_lower_bound ;
    int primary_keys_lower_bound;
    
    int active_metrics ;

    
    
    public InputReader()
    {
        //source_metamodel_path = new String("./configuration/source_input.xml");
         //target_metamodel_path = new String("./configuration/target_input.xml");
        //ines (modifification du fichier source_input
        //ines (modifification du fichier target_input
        source_metamodel_path = new String("C:/Users/User/Desktop/Parsing_Interface/Input Files/input for detection rule/Source2.xml");
        source_metamodel_path1 = new String("C:/Users/User/Desktop/Parsing_Interface/Input Files/input for detection rule/Source3.xml");
        target_metamodel_path = new String("C:/Users/User/Desktop/Parsing_Interface/Input Files/input for detection rule/target2.xml");
        source_model_path = new String("./configuration/model_input.xml");
        source_model_path = new String("C:/Users/User/Desktop/Parsing_Interface/Input Files/input for detection rule/model2.xml");
        quality_metrics_path = new String("C:/Users/User/Desktop/Parsing_Interface/Input Files/input for detection rule/quality_metrics.xml");
        
        source = new ArrayList<MetaModel>();
        source2 = new ArrayList<MetaModel>();
        target = new ArrayList<MetaModel>();
        model = new ArrayList<MetaModel>();
        //ines
        source_metamodel_elements =new ArrayList<MetaModel>();
        target_metamodel_elements =new ArrayList<MetaModel>();
        
        tables_lower_bound =0 ;
        columns_lower_bound  =0 ;
        primary_keys_lower_bound = 0;
        
        active_metrics = 3 ;
        
    }
	  
    public void read_quality_metrics(String source_metamodel_path)
        {
		
		SAXBuilder builder = new SAXBuilder();
		try {
			Document readDoc = builder.build(new File(source_metamodel_path));
			root = readDoc.getRootElement();
                        elements = root.getChildren("element");
                        if (elements.size() ==0 ) System.out.println("\n No metrcis to extract from XML file");
                        else
                        {
                            int i = 0 ;
                            while (i<elements.size()) 
                            {    
                                switch(elements.get(i).getChildText("prefix"))
                                {
                                    case "tables_lower_bound" : tables_lower_bound = Integer.parseInt(elements.get(i).getChildText("suffix"));
                                    break;
                                    case "columns_lower_bound" : columns_lower_bound = Integer.parseInt(elements.get(i).getChildText("suffix"));
                                    break;
                                    case "primary_keys_lower_bound" : primary_keys_lower_bound = Integer.parseInt(elements.get(i).getChildText("suffix"));
                                    break;  
                                    /*case "primary_keys_lower_bound" : associations_lower_bound = Integer.parseInt(elements.get(i).getChildText("suffix"));
                                    break;
                                    case "generalization_lower_bound" : generalization_lower_bound = Integer.parseInt(elements.get(i).getChildText("suffix"));
                                    break;
                                    case "average_attributes_per_class" : average_attributes_per_class = Integer.parseInt(elements.get(i).getChildText("suffix"));
                                    break;
                                    case "average_associations_per_class" : average_associations_per_class = Integer.parseInt(elements.get(i).getChildText("suffix"));
                                    break;*/
                                }
                                i++;
                            }
                        }
                }
                
		catch (JDOMException e) {
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        }
    
    public void read_xml(ArrayList<MetaModel> st, String source_metamodel_path)
        {
		
		SAXBuilder builder = new SAXBuilder();
		try {
			Document readDoc = builder.build(new File(source_metamodel_path));
			root = readDoc.getRootElement();
                        elements = root.getChildren("element");
                        if (elements.size() ==0 ) System.out.println("\n No elements to extract from XML file");
                        else
                        {
                            int i = 0 ;
                            while (i<elements.size()) 
                            {                               
                                temp = new MetaModel() ;
                                temp.name = elements.get(i);
                                temp.prefixes = elements.get(i).getChildren("prefix");
                                temp.suffixes = elements.get(i).getChildren("suffix");
                                temp.print_metamodel();
                                
                                st.add(temp) ;

                                i++;
                            }
                            
                        }
                        			
			
			
		} 
		
		catch (JDOMException e) {
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
        
        public void print_elements(ArrayList<MetaModel> st)
        {
            int i = 0 ;
            while (i<st.size()) 
            {
                //System.out.println("\n the element number : "+i+" has "+st.get(i).prefixes.size()+" Prefixes and "+st.get(i).suffixes.size()+" suffixes");
                st.get(i).print_metamodel();
                System.out.println("\n the element number "+(i+1)+" is : "+st.get(i).metamodel_text);
                //String name = new String(st.get(i).prefixes.get(0).getName());
                //System.out.println("\n the element prefix : "+st.get(i).prefixes.get(0).getText());
                
                i++;
            }
        }
        
        public void writeXML(ArrayList<MetaModel> m){
	try{
		
		// Creates a JDOM document
		
		Document doc = new Document();
		
		// Creates a element named tvshows and makes it the root
		
		Element theRoot = new Element("Relational");
		doc.setRootElement(theRoot);
		
		for(int i=0;i<m.size();i++)
                {
                    Element temp = new Element("element");
                    Element test = new Element("test");
                    temp.addContent(test);
                    int j=0;
                    while(j<m.get(i).prefixes.size())
                    {
                        temp.addContent((Element)(m.get(j).prefixes.get(j)));
                        j++;
                    }
                    j=0;
                    while(j<m.get(i).suffixes.size())
                    {
                        temp.addContent((m.get(j).suffixes.get(j)));
                        j++;
                    }
                    theRoot.addContent(temp);
                }
		// Uses indenting with pretty format
		
		XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
		
		// Create a new file and write XML to it
		Calendar c= Calendar.getInstance();
                long l=c.getTimeInMillis();
                //String file_name = new String("./output/r"+l+".xml");
		xmlOutput.output(doc, new FileOutputStream(new File("./output/jdomMade.xml")));
		
		//System.out.println("Wrote to file");
		
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
       
    public void read_input_files()
    {
        this.read_xml(this.source,this.source_metamodel_path);
        this.read_xml(this.source2,this.source_metamodel_path1);
        this.read_xml(this.target,this.target_metamodel_path);
        this.read_xml(this.model,this.source_model_path);
        this.read_quality_metrics(this.quality_metrics_path);
        //ines
        this.read_xml(this.source_metamodel_elements, source_metamodel_path);
        this.read_xml(this.target_metamodel_elements, target_metamodel_path);
    }
    
    public static void main(String[] args) 
    {
        InputReader r = new InputReader();
        r.read_input_files();
        //System.out.println("\n source size :"+r.source.size());
        //r.read_xml(r.source,r.source_metamodel_path);
        //System.out.println("\n source size :"+r.source.size());
        r.print_elements(r.source);
        r.print_elements(r.source2);
        //r.read_xml(r.target,r.target_metamodel_path);
        r.print_elements(r.target);
        //ines
        InputReader input1 = new InputReader();
        input1.read_input_files();
         input1.print_elements(input1.source);
          input1.print_elements(input1.target);
          InputReader input2 = new InputReader();
        input2.read_input_files();
         input2.print_elements(input2.source);
          input2.print_elements(input2.target);
          InputReader input3 = new InputReader();
          input3.read_input_files();
           input3.print_elements(input2.source2);
            input3.print_elements(input2.target);
          
        
        //r.read_quality_metrics(r.quality_metrics_path);
        System.out.println("\n classes_lower_bound "+r.tables_lower_bound);
        
    }
	
}

/* Installing JDOM 
 * 
 * Download jdom.jar https://github.com/hunterhacker/jdom/downloads
 * Download jdom-2.0.2.zip
 * 
 * Right click default eclipse directory - Build Path
 * 
 * Click Java Build Path
 * 
 * Click Libraries tab - external libraries
 * 
 * Add the JDOM libraries
 * 
 * 
 * */
package Detection_rule;


import jxl.*;
import jxl.read.biff.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import jxl.write.WriteException;

import java.util.Locale;
import java.util.StringTokenizer;

public class Evaluate {
    public static void main(String[] args) throws IOException {
    	int[] H = new int[22];
    	int [] W = new int[22];
            		try {
                        String csvFile = "Trace/Trace.xlsx";
                        String delimiter = ";";
                        String line = null;
                        StringTokenizer strToken = null;
                        BufferedReader bufferReader;
                        int lineID = 0;
                        int fieldID = 0;
                        int i=0;
                        int j=0;
                        double somme =0;
                        int Interface = 540000;
                        double area=0.0;
                        //String[] T = new String[22];
            //Ouvrir le fichier CSV 
                        bufferReader = new BufferedReader(new FileReader(csvFile));
            //parcourir les lignes du fichier CSV
                        while ((line = bufferReader.readLine()) != null) {
                            lineID++;
            //Parcourir les champs séparés par delimiter
                            strToken = new StringTokenizer(line, delimiter);
                            while (strToken.hasMoreTokens()) {
                            	
                                fieldID++;
                                if (fieldID==4)
                                { System.out.println(strToken.nextToken()); 
                                  //T[i]= strToken.nextToken() ;


                                  System.out.println(H [i]);
                                  //i++;    
                                }
                                else
                                if (fieldID==5)
                                { //System.out.println(strToken.nextToken()); 
                                  W[j]= Integer.parseInt(strToken.nextToken()) ;
                                  System.out.println(W[j]);
                                  //j++;  
                                   area = H [i] * W [i];  
                                  System.out.println(area);
                                  
                                } 
                               
                                else
                                {System.out.println("Ligne " + lineID
                                        + " / champs " + fieldID
                                        + " : " + strToken.nextToken());}  
                                
                               
                            }
                            somme+=area;
                            System.out.println(" somme="+somme);
                            //double DM = (double)1 - 2* Math.abs(0.5-(somme/Interface));
                            //System.out.println("La densiter de l'interface est:"+DM);
                            fieldID = 0;          
                        }
                        double DM = (double)1 - 2* Math.abs(0.5-(somme/Interface));
                        System.out.println("La densiter de l'interface est:"+DM);
                       /*BufferedWriter out =  new BufferedWriter (new FileWriter ("fichier.txt")) ;
                        out.write(  DM);
                        out.close();*/
        } catch (IOException ex) {
        	System.out.println("Erreur");
        }           
    }
    
}



package measureMetrics;






import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import measureDimension.Dimension;

public class CMetrics {
	public static double Regularity ( String d) throws IOException{
		
			if ( Dimension.getHeightInterface(d) != null) { 
				 if (Dimension.getWidthInterface(d) != null) {
					   //******
					 double RM=0;
					 int Nbr_Sp = Dimension.getSapace(d);
					 int  nv= Dimension.getAlignementVertical(d);
					 int  nh= Dimension.getAlignementHorizontal(d);
					 int n = Dimension.getComponent(d);
					 double  RM_Alignment=0;
					 double  RM_Spacing=0;
					 if(n==1)
					 { RM_Alignment = 1;
					   RM_Spacing =1;}
					 else
					 { RM_Alignment = (double) 1-((nv-nh)/(2*n));
					 RM_Spacing=(double) 1-((Nbr_Sp-1)/(2*(n-1)));       }
					 RM = (double)(Math.abs(RM_Alignment)+Math.abs(RM_Spacing))/2;
					 
		        return RM;}}
			   
			else{
			return 0.0; }
			
			return 0;

	}
	public static double Density ( String d) throws IOException{
		
		if ( Dimension.getHeightInterface(d) != null) { 
			 if (Dimension.getWidthInterface(d) != null) {
		
		  int HI = Integer.parseInt( Dimension.getHeightInterface(d).get(0));
	int WI=Integer.parseInt(Dimension.getWidthInterface(d).get(0)) ;
	double AreaInterface= HI*WI;
		int somme=0;
		ArrayList<String> WC=new ArrayList<String>();
		WC=Dimension.getWidth(d) ;
		ArrayList<String> HC=new ArrayList<String>();
		HC=Dimension.getHeight(d) ;
	    for(int i=0; i<WC.size();i++)
	    {
	    int WCs=Integer.parseInt(WC.get(i)) ;
	    int HCs=Integer.parseInt(HC.get(i)) ;
	   int CArea= WCs*HCs;
	   somme= somme+CArea;
	    }
	    double DM = (double)1 - 2 * Math.abs(0.5-(somme/AreaInterface));
	    return DM;}}
		   
		else{
		return 0.0; }
		return 0;

 }
	public static double Unity ( String d) throws IOException{
		 ArrayList<Integer> List = new ArrayList<Integer>();
			if ( Dimension.getHeightInterface(d) != null) { 
				 if (Dimension.getWidthInterface(d) != null) {
			  int HI = Integer.parseInt( Dimension.getHeightInterface(d).get(0));
		int WI=Integer.parseInt(Dimension.getWidthInterface(d).get(0)) ;
		double AreaInterface= HI*WI;
		java.awt.Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();
	    double  a_screen = hauteur*largeur ;
			int somme=0;
			int N_Size=0;
			ArrayList<String> WC=new ArrayList<String>();
			WC=Dimension.getWidth(d) ;
			ArrayList<String> HC=new ArrayList<String>();
			HC=Dimension.getHeight(d) ;
		    for(int i=0; i<WC.size();i++)
		    {
		    int WCs=Integer.parseInt(WC.get(i)) ;
		    int HCs=Integer.parseInt(HC.get(i)) ;
		   int CArea= WCs*HCs;
		   List.add(CArea);
		   somme= somme+CArea;
		    }	  
			for(int h=0;h<List.size();h++)
	    	{for(int g=1;h<List.size();h++)
			   { if(List.get(h).compareTo(List.get(g))!=0)
			   { N_Size++;
			   //System.out.println(N_Size);
			   }	  }} 
		    double UM_Space = 1 - ((float)(AreaInterface-somme)/(float)(a_screen-somme)) ;
		    double UM_Form =1 - (float) (N_Size - 1) / List.size()  ;
		    //System.out.println("UM"+UM_Space);
		    //System.out.println("UM_form = "+UM_Form);
		    double UM =  1-  (float) (Math.abs(UM_Form)+Math.abs(UM_Space))/2;
		    return UM;}}
			   
			else{
			return 0.0; }
			return 0;
	 }
	public static double Symmetry (String d ) throws IOException{
		int sommeXUl=0;
		int sommeYUL=0;
		int sommeHUL=0;
		int sommeBUL=0;
		int sommeOUL=0;
		int sommeRUL=0;
		int sommeXUR=0;
		int sommeYUR=0;
		int sommeHUR=0;
		int sommeBUR=0;
		double sommeOUR=0;
		int sommeRUR=0;
		int sommeXLL=0;
		int sommeYLL=0;
		int sommeHLL=0;
		int sommeBLL=0;
		int sommeOLL=0;
		int sommeRLL=0;
		int sommeXLR=0;
		int sommeYLR=0;
		int sommeHLR=0;
		int sommeBLR=0;
		int sommeOLR=0;
		int sommeRLR=0;
		double SYMhorizontal = 0;
		double SYMvertical = 0;
		java.awt.Dimension  tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();
		int W= Integer.parseInt(Dimension.getWidthInterface(d).get(0));
		int H= Integer.parseInt(Dimension.getHeightInterface(d).get(0));
		int xc=largeur/2;
		int yc=hauteur/2;
		 System.out.println("xc:"+xc);
		 System.out.println("yc:"+yc);
		int c=Dimension.getComponent(d);
		for(int i=0;i<c;i++){
			for(int j=i+1;j<c;j++){
			String X1=(String) Dimension.getX(d).get(i);
			String Y1 =(String) Dimension.getY(d).get(i);
			String XX=(String) Dimension.getX(d).get(j);
			String YY =(String) Dimension.getY(d).get(j);
			String W1=(String) Dimension.getWidth(d).get(i);
			String H1=(String) Dimension.getHeight(d).get(i);
			String WW=(String) Dimension.getWidth(d).get(j);
			String HH=(String) Dimension.getHeight(d).get(j);
			 int X2=Integer.parseInt(X1);
			 int Y2=Integer.parseInt(Y1);
			 int W2=Integer.parseInt(W1);
			 int H2=Integer.parseInt(H1);
			 int XXX=Integer.parseInt(XX);
			 int YYY=Integer.parseInt(YY);
			 int WWW=Integer.parseInt(WW);
			 int HHH=Integer.parseInt(HH);
			 if((Y2==YYY) && (H2==HHH)){
		 if (Dimension.getLocation(X1,Y1,d)=="UL"){
			
			 sommeXUl=sommeXUl+Math.abs(X2-xc); 
			 sommeYUL=sommeYUL+Math.abs(Y2-yc);
			   sommeBUL=sommeBUL+W2; 
			   sommeHUL=sommeHUL+H2;
			   float s=(Y2-yc);
				 float q=(X2-xc);
				 float u=s/q;
			   sommeOUL=(int) (sommeOUL+(Math.abs(u)));
			   System.out.println(sommeOUL);
			   int t =(int) Math.pow((X2-xc),2);
			   int e=(int) Math.pow((Y2-yc),2);
			   sommeRUL=(int) (sommeRUL+(Math.sqrt(t+e)));
			    }
		 if (Dimension.getLocation(X1,Y1,d)=="UR"){ 
		
		 sommeXUR= sommeXUR +Math.abs(X2-xc); 
		 System.out.println("somme XUL:"+sommeXUR);
		 sommeYUR=sommeYUR+Math.abs(Y2-yc);
		 System.out.println("somme YUL:"+sommeYUR);
		   sommeBUR=sommeBUR+W2;
		   System.out.println("somme BUL:"+sommeBUR);
		   sommeHUR=sommeHUR+H2;
		   System.out.println("somme HUL:"+sommeHUR);
		  float s=(Y2-yc);
		 float q=(X2-xc);
		 float u=s/q;
		   sommeOUR=sommeOUR+(Math.abs(u));
		   System.out.println("somme OUL:"+sommeOUR);
		   int t =(int) Math.pow((X2-xc),2);
		   int e=(int) Math.pow((Y2-yc),2);
		   sommeRUR=(int) (sommeRUR+(Math.sqrt(t+e)));
		   System.out.println("somme RUL:"+sommeRUR);}
		 if (Dimension.getLocation(X1,Y1,d)=="LL"){ 
		
		 sommeXLL= sommeXLL +Math.abs(X2-xc); 
		 sommeYLL=sommeYLL+Math.abs(Y2-yc);
		   sommeBLL=sommeBLL+W2; 
		   sommeHLL=sommeHLL+H2; float s=(Y2-yc);
			 float q=(X2-xc);
			 float u=s/q;
		   sommeOLL=(int) (sommeOLL+(Math.abs(u)));
		   int t =(int) Math.pow((X2-xc),2);
		   int e=(int) Math.pow((Y2-yc),2);
		   sommeRLL=(int) (sommeRLL+(Math.sqrt(t+e)));}
		 if (Dimension.getLocation(X1,Y1,d)=="LR"){
	
		 sommeXLR= sommeXLR +Math.abs(X2-xc); 
		 sommeYLR=sommeYLR+Math.abs(Y2-yc);
		   sommeBLR=sommeBLR+W2; 
		   sommeHLR=sommeHLR+H2;
		   float s=(Y2-yc);
			 float q=(X2-xc);
			 float u=s/q;
		 
		   sommeOLR=(int) (sommeOLR+(Math.abs(u)));
		   int t =(int) Math.pow((X2-xc),2);
		   int e=(int) Math.pow((Y2-yc),2);
		   sommeRLR=(int) (sommeRLR+(Math.sqrt(t+e)));}	
			
		int  X3=Math.abs((sommeXUl-sommeXUR));
		System.out.println("X3:"+X3);
		int X4=Math.abs(sommeXLL-sommeXLR);
		int  Y3=Math.abs(sommeYUL-sommeYUR);
		int Y4=Math.abs(sommeYLL-sommeYLR);
		int  H3=Math.abs(sommeHUL-sommeHUR);
		int H4=Math.abs(sommeHLL-sommeHLR);
		int B3=Math.abs(sommeBUL-sommeBUR);
		int B4=Math.abs(sommeBLL-sommeBLR);
		double  O3=Math.abs(sommeOUL-sommeOUR);
		int O4=Math.abs(sommeOLL-sommeOLR);
		int  R3=Math.abs(sommeRUL-sommeRUR);
		int R4=Math.abs(sommeRLL-sommeRLR);
		 SYMvertical=(X3+X4+Y3+Y4+H3+H4+B3+B4+O3+O4+R3+R4)/12;}
			 if((X2==XXX) && (W2==WWW)){
			 if (Dimension.getLocation(X1,Y1,d)=="UL"){
					
				 sommeXUl=sommeXUl+Math.abs(X2-xc); 
				 sommeYUL=sommeYUL+Math.abs(Y2-yc);
				   sommeBUL=sommeBUL+W2; 
				   sommeHUL=sommeHUL+H2;
				   float s=(Y2-yc);
					 float q=(X2-xc);
					 float u=s/q;
				   sommeOUL=(int) (sommeOUL+(Math.abs(u)));
				   System.out.println(sommeOUL);
				   int t =(int) Math.pow((X2-xc),2);
				   int e=(int) Math.pow((Y2-yc),2);
				   sommeRUL=(int) (sommeRUL+(Math.sqrt(t+e)));
				    }
			 if (Dimension.getLocation(X1,Y1,d)=="UR"){ 
			
			 sommeXUR= sommeXUR +Math.abs(X2-xc); 
			 System.out.println("somme XUL:"+sommeXUR);
			 sommeYUR=sommeYUR+Math.abs(Y2-yc);
			 System.out.println("somme YUL:"+sommeYUR);
			   sommeBUR=sommeBUR+W2;
			   System.out.println("somme BUL:"+sommeBUR);
			   sommeHUR=sommeHUR+H2;
			   System.out.println("somme HUL:"+sommeHUR);
			  float s=(Y2-yc);
			 float q=(X2-xc);
			 float u=s/q;
			   sommeOUR=sommeOUR+(Math.abs(u));
			   System.out.println("somme OUL:"+sommeOUR);
			   int t =(int) Math.pow((X2-xc),2);
			   int e=(int) Math.pow((Y2-yc),2);
			   sommeRUR=(int) (sommeRUR+(Math.sqrt(t+e)));
			   System.out.println("somme RUL:"+sommeRUR);}
			 if (Dimension.getLocation(X1,Y1,d)=="LL"){ 
			
			 sommeXLL= sommeXLL +Math.abs(X2-xc); 
			 sommeYLL=sommeYLL+Math.abs(Y2-yc);
			   sommeBLL=sommeBLL+W2; 
			   sommeHLL=sommeHLL+H2; float s=(Y2-yc);
				 float q=(X2-xc);
				 float u=s/q;
			   sommeOLL=(int) (sommeOLL+(Math.abs(u)));
			   int t =(int) Math.pow((X2-xc),2);
			   int e=(int) Math.pow((Y2-yc),2);
			   sommeRLL=(int) (sommeRLL+(Math.sqrt(t+e)));}
			 if (Dimension.getLocation(X1,Y1,d)=="LR"){
		
			 sommeXLR= sommeXLR +Math.abs(X2-xc); 
			 sommeYLR=sommeYLR+Math.abs(Y2-yc);
			   sommeBLR=sommeBLR+W2; 
			   sommeHLR=sommeHLR+H2;
			   float s=(Y2-yc);
				 float q=(X2-xc);
				 float u=s/q;
			 
			   sommeOLR=(int) (sommeOLR+(Math.abs(u)));
			   int t =(int) Math.pow((X2-xc),2);
			   int e=(int) Math.pow((Y2-yc),2);
			   sommeRLR=(int) (sommeRLR+(Math.sqrt(t+e)));}	
			 
			int  X5=Math.abs((sommeXUl-sommeXUR));
			System.out.println("X3:"+X5);
			int X6=Math.abs(sommeXLL-sommeXLR);
			int  Y5=Math.abs(sommeYUL-sommeYUR);
			int Y6=Math.abs(sommeYLL-sommeYLR);
			int  H5=Math.abs(sommeHUL-sommeHUR);
			int H6=Math.abs(sommeHLL-sommeHLR);
			int B5=Math.abs(sommeBUL-sommeBUR);
			int B6=Math.abs(sommeBLL-sommeBLR);
			double  O5=Math.abs(sommeOUL-sommeOUR);
			int O6=Math.abs(sommeOLL-sommeOLR);
			int  R5=Math.abs(sommeRUL-sommeRUR);
			int R6=Math.abs(sommeRLL-sommeRLR);
		 SYMhorizontal=(X5+X6+Y5+Y6+H5+H6+B5+B6+O5+O6+R5+R6)/12;}}
}
		//double SYMradial=(X3+X4+Y3+Y4+H3+H4+B3+B4+O3+O4+R3+R4)/12;
		//System.out.println("Sym vetrical:"+SYMvetical);
		//System.out.println("sym horizontal:"+SYMhorizontal);
		//System.out.println("Symm radial:"+SYMradial);
		double SYM=Math.abs(1-(((Math.abs(SYMvertical)+Math.abs(SYMhorizontal)))/2));
		//double SYM=1-(((Math.abs(SYMvetical))));
		return SYM;
	}
	public static double Homogeneity ( String d) throws Exception{
		int NbUl = 0;
		int NbUr = 0;
		int NbLl = 0;
		int NbLr = 0;
		int c=Dimension.getComponent(d);
		
	System.out.println(c);
	for(int i=0;i<c;i++){
		String X1=(String) Dimension.getX(d).get(i);
		String Y1 =(String) Dimension.getY(d).get(i);
	 if (Dimension.getLocation(X1,Y1,d)=="UL"){ NbUl++;}
	 if (Dimension.getLocation(X1,Y1,d)=="UR"){NbUr++;}
	 if (Dimension.getLocation(X1,Y1,d)=="LL"){NbLl++;}
	 if (Dimension.getLocation(X1,Y1,d)=="LR"){NbLr++;}	
	}
	System.out.println( Factorielle(c));
	int X= Factorielle(c);
	int Y=Factorielle(NbUl);
	int Z=Factorielle(NbUr);
	int T=Factorielle(NbLl);
	int Q=Factorielle(NbLr);
	int som=Y+Z+T+Q;
	System.out.println("la somme est:"+som);
	double W=(double)(X)/(som);
	double Wmax= (double)( (Factorielle(c))/(Math.pow((Factorielle(c/4)), 4)));
	double HM=Math.abs(W/Wmax);
		return HM ;
		
	}
	
public static double Simplicity (String d ) throws IOException{
		int Nvap= Dimension.getAlignementVertical(d);
		System.out.println("Nvap="+Nvap);
		int Nhap= Dimension.getAlignementHorizontal(d);
		System.out.println("Nhap="+Nhap);
		int n= Dimension.getComponent(d);
		int som= Nvap+Nhap+n;
		double SMM=(double)(3)/(som);
		return SMM;
	}
public static double Sequence ( String d) throws IOException{
	double SQM=0;
	int c=Dimension.getComponent(d);
	 ArrayList<Integer> L1=new ArrayList<Integer>();
	    //L1= Dimension.getX(d);
	    ArrayList<String> m1=new ArrayList<String>();
	    ArrayList<String> m2=new ArrayList<String>();
	    ArrayList<String> m3=new ArrayList<String>();
	    ArrayList<String> m4=new ArrayList<String>();
	    ArrayList<String> m5=new ArrayList<String>();
	    ArrayList<String> m6=new ArrayList<String>();
	    ArrayList<Integer> L=new ArrayList<Integer>();
	    m1=Dimension.getX(d);
	    m2=Dimension.getY(d);
	    m3=Dimension.getWidth(d);
	    m4=Dimension.getHeight(d);
	    m5= Dimension.getHeightInterface(d);
	    m6=Dimension.getWidthInterface(d);
	    //System.out.println("la liste:"+m6);
	    int somme =0;
	    int W_UL =0;
	    int W_UR =0;
	    int W_LL =0;
	    int W_LR =0;
	    int V_UL =0;
	    int V_UR =0;
	    int V_LL =0;
	    int V_LR =0;
   for(int i=0;i<c;i++){ 	
	    int X= Integer.parseInt(m1.get(i));
   	    int Y=Integer.parseInt(m2.get(i));
    	int W= Integer.parseInt(m3.get(i));
    	int H=Integer.parseInt(m4.get(i)); 
       	int HI= Integer.parseInt(m5.get(0));
    	int WI= Integer.parseInt(m6.get(0));
	if((X<(WI/2)) && (Y>(HI/2)))
	{   somme+= H*W;
		 W_UL = 4* somme ;		
	}
	else
		if((X>(WI/2)) && (Y<(HI/2)))
		{   somme+= H*W;
			 W_UR = 3* somme ;		
		}
		else
			if((X<(WI/2)) && (Y<(HI/2)))
			{   somme+= H*W;
				 W_LL = 2* somme ;	
				 
			}
			else
				if((X>(WI/2)) && (Y>(HI/2)))
				{   somme+= H*W;
					 W_LR = 1* somme ;	
					
				}
	   //  System.out.println(W_UL+"******"+W_UR+"*********"+W_LL+"******"+W_LR);
	    
		
		}
    L1.add(W_UL);
    L1.add(W_UR);
    L1.add(W_LL);
    L1.add(W_LR);
     System.out.println(L1);
    Integer max =0;
    Integer min =0;
     for(int i=0; i<L1.size();i++){
      if (L1.get(0)  >= L1.get(i) )
      { V_UL =4;
      max = L1.get(0); } 
      else
    	  if(L1.get(1) >=L1.get(i))
    	  { V_UR =4;
    	  max = L1.get(1);}  
    	  if(L1.get(2)>=L1.get(i))
    	  { V_LL =4;
    	  max = L1.get(2);}
    	  else
        	  if(L1.get(3)>=L1.get(i))
        	  { V_LR =4;
        	  max = L1.get(3);}

         if (L1.get(0) <= L1.get(i) )
         { V_UL =1;
           min = L1.get(0);} 
         else
       	 if(L1.get(1)<=L1.get(i))
       	  { V_UR =1;
       	    min = L1.get(1);}
       	 else
       	  if(L1.get(2)<=L1.get(i))
       	  { V_LL =1;
        	min = L1.get(2);}
       	  else
           	  if(L1.get(3)<=L1.get(i))
           	  { V_LR =1;
            	min = L1.get(3);}}
          int pos1=0;
           	  for(int i=0;i<L1.size();i++)
           	  { if(L1.get(0)!=max &&L1.get(0)!=min && L1.get(0)< L1.get(i))
           	  { V_UL = 2;}
           	  else 
           		if(L1.get(1)!=max &&L1.get(1)!=min && L1.get(1) < L1.get(i))
           		{ V_UR = 2;}
           		else 
               		if(L1.get(2)!=max &&L1.get(2)!=min && L1.get(2)< L1.get(i))
                		   {V_LL = 2;}
               		else 
                   		if(L1.get(3)!=max &&L1.get(3)!=min && L1.get(3)< L1.get(i))
                   		{ V_LL = 2;}
           	  //*****
           	    if(L1.get(0)!=max &&L1.get(0)!=min && L1.get(0)>= L1.get(i) )
         	           { V_UL = 3;}
         	    else 
         		if(L1.get(1)!=max &&L1.get(1)!=min && L1.get(1)>= L1.get(i))
         		         { V_UR = 3;}
         		else 
                if(L1.get(2)!=max &&L1.get(2)!=min && L1.get(2)>= L1.get(i))
              		   {V_LL = 3;}
             	else 
                 		if(L1.get(3)!=max &&L1.get(3)!=min && L1.get(3)>= L1.get(i))
                 		{ V_LL = 3;}

           		  }
       		  System.out.println( V_UL +"/////"+ V_UR+"/////"+ V_LL+"////"+V_LR); 
     int som = Math.abs(4 - V_UL)+Math.abs(3-V_UR)+Math.abs(2-V_LL)+Math.abs(1-V_LR);
     //System.out.println("ttttt="+som);
    SQM =  1- (double) som/8 ;
	return SQM;
	
}
public static double Grouping ( String d) throws IOException{
	double GM=0;
    int gi=0;
    //String regex = "\\bnew\\(\\s\\)JPanel\\b\\([(]\\)\\([)]\\)\\([;]\\)";
    String regex = "\\bJPanel\\b(\\s)[a-zA-Z0-9_]*\\b(\\s)([=])(\\s)\\bnew\\b(\\s)\\bJPanel\\b([(])([)])([;])";
    String regex2 = "[a-zA-Z0-9_]*";
    
    ArrayList<String> L=new ArrayList<String>();
    ArrayList<String> L1=new ArrayList<String>();
    String tab [];
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher((CharSequence) d);
	while (matcher.find()){
	gi++;
	L.add(matcher.group());
	   //System.out.println("Le nobre de groupe:"+gi);
	}
	// JPanel
	for(int i=0;i<L.size();i++)
	{ 
		tab = L.get(i).split("\\s");
		L1.add(tab[1]);	
	}
	//nomrbre des conposant existe dans chaque groupe 
	int nbr=0;
	String regex3 ="([.])\\badd\\b";
	for (int i=0;i<L1.size();i++)
	{ Pattern pat2 = Pattern.compile("\\b"+L1.get(i)+"\\b([.])\\badd\\b");
    Matcher mat2 = pat2.matcher((CharSequence) d);
    while (mat2.find()){
    	nbr++;
      //System.out.println("le nombre de composants de  groupe" +i+":"+ nbr++ );
    }
    }
	 //System.out.println(L1);
    GM = (double) nbr/Dimension.getComponent(d);
	//System.out.println("Le nobre de groupe:"+gi);
	return GM;
	}
		 
	    public static int Factorielle(int nb) throws Exception {
	       
	        if (nb == 0) {
	            return 1;
	        } else {
	            return nb * Factorielle(Math.abs(nb - 1));
	        }
	    }
	}
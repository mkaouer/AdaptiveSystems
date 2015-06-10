package bean;

import java.util.ArrayList;

public class AnalyzedClass {
	
	public  double SMM ;
	public  double HO ;
	public  double DM ;
	public  double UM;
	public  double SQM;
	public  double SYM;
	public  double GM;
	public  double RM;
	public String classPath;
	public String X;
	public String L;
	public String  Y;
	public String  Width;
	public String  Height;
	public String  WidthInterface;
	public String   HeightInterface;
	public int Nombre_Composant;
	public String Nom_Interface;
	public String getX() {
		return X;
	}
	public void setX(String arrayList) {
		
		X=arrayList;
		
		}
	public String getL() {
		return L;
	}
	public void setL(String arrayList) {
		
		L=arrayList;
		
		}
	
	public String getY() {
		return Y;
	}
	public void setY(String pY) {
		Y = pY;
	}
	public String getWidth() {
		return Width;
	}
	public void setWidth(String pWidth) {
		Width=pWidth;
	}
	public String getHeight() {
		return Height;
	}
	public void setHeight(String pHeight) {
		Height = pHeight;
	}
	public String  getWidthInterface() {
		return WidthInterface;
	}
	public void setWidthInterface(String  pWidth) {
		WidthInterface=pWidth;
	}
	public String  getHeightInterface() {
		return HeightInterface;
	}
	public void setHeightInterface(String  pHeight) {
		HeightInterface = pHeight;
	}
	public String getNom_Interface() {
		return Nom_Interface;
	}
	public void setNom_Interface(String pni) {
		Nom_Interface = pni;
	}
	public int getNombre_Composant() {
		return Nombre_Composant;
	}
	public void setNombre_Composant(int pnc) {
		Nombre_Composant = pnc;
	}
	public double getDensity() {
		return DM;
	}
	public double getUnity() {
		return UM;
	}
	public void setUnity(double pnc) {
		UM = pnc;
	}
	public double getHomogeneity() {
		return HO;
	}
	public void setHomogeneity(double pnc) {
		HO = pnc;
	}
	public double getGrouping() {
		return GM;
	}
	public void setGrouping(double pnc) {
		GM = pnc;
	}
	public double getSimplicity() {
		return SMM;
	}
	public void setSimplicity(double pnc) {
		SMM = pnc;
	}
	public double getSequence() {
		return SQM;
	}
	public void setSequence(double pnc) {
		SQM = pnc;
	}
	public double getSymmetry() {
		return SYM;
	}
	public void setSymmetry(double pnc) {
		SYM = pnc;
	}
	public double getRegularity() {
		return RM;
	}
	public void setRegularity(double pnc) {
		RM = pnc;
	}
	public void setDensity(double pnc) {
		DM = pnc;
	}
	public String toString(){
		//return (this.getNom_Interface()+";"+this.getX()+";"+this.getY()+";"+this.getWidth()+";"+this.getHeight()+";"+this.getNombre_Composant());
		return(Nom_Interface+";"+X+";"+Y+";"+Width+";"+Height+";"+WidthInterface+";"+HeightInterface+";"+Nombre_Composant+";"+ DM+";"+L+";"+UM+";"+HO+";"+SMM+";"+SQM+";"+SYM+";"+GM+";"+RM);
	}
	
	public boolean equals(Object arg){
		return this.classPath.equals(((AnalyzedClass)arg).classPath);
	}
	
}

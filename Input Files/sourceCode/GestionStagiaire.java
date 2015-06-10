package interfaceGS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import org.jdesktop.swingx.JXSearchField;
import org.jdesktop.swingx.JXSearchField.LayoutStyle;







import boutonColor.ButtonColor;
import dataBase.Gestion_DB_Stagiaire;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class GestionStagiaire extends JFrame {
	
	Gestion_DB_Stagiaire stagiaire=new Gestion_DB_Stagiaire();
	private JPanel contentPane;

	private JTextField nomStagiaireField;
	private JTextField prenomStagiaireField;
	private JTextField CINField;
	private JTextField naissanceField;
	private JTextField universiteField;
	private JTextField specialtyField;
	private JTextField CINStagiaireRechField;
	private JTextField horloge;
	private JButton ajouter;
	private JButton supprimer;
	private JButton modifier;
	private JButton valider ;
	
	private JLabel nomStagiaire;
	private JLabel prenomStagiaire;
	private JLabel CIN; 
	private JLabel naissance;
	private JLabel Specialite;
	private JLabel CINStagiaireRech;
	private JLabel universite;
	
	private JXSearchField searchField;
	private JScrollPane scrollPane;
	private JTable table;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionStagiaire frame = new GestionStagiaire();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestionStagiaire() {
		setTitle("Gestion Stagiaire");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(802, 409);
		setLocationRelativeTo(null);
		contentPane = new Panneau();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		ajouter=new ButtonColor("Ajout",Color.BLACK);
		ajouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String cin,nom,prenom,naissance,universite,specialty;
				Object source=evt.getSource();
				if(source==ajouter){
					
					cin=CINField.getText();
					nom=nomStagiaireField.getText();
					prenom=prenomStagiaireField.getText();
					naissance=naissanceField.getText();
					universite=universiteField.getText();
					specialty=specialtyField.getText();
					CINField.setText("");
					nomStagiaireField.setText("");
					prenomStagiaireField.setText("");
					naissanceField.setText("");
					universiteField.setText("");
					specialtyField.setText("");
					stagiaire.ajouterStagiaire(cin,nom,prenom,naissance,universite,specialty);
					rechercher(cin);			
				
				}
			}});
		ajouter.setBounds(10, 336, 227, 23);
		getContentPane().add(ajouter);
		
		supprimer = new ButtonColor("Supprimer",Color.BLACK);
		supprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Object source=evt.getSource();
				if(source==supprimer){
					JOptionPane.showMessageDialog(null,"Vous voulez continuer","Message d’avertissement",JOptionPane.YES_NO_CANCEL_OPTION);
					String cin=CINStagiaireRechField.getText();
					stagiaire.supprimerStagiaire(cin);
					CINStagiaireRechField.setText("");
				}
			}
		});
		supprimer.setBounds(285, 39, 115, 23);
		getContentPane().add(supprimer);
		
		horloge = new JTextField();
		horloge.setForeground(Color.LIGHT_GRAY);
		horloge.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 34));
		horloge.setEditable(false);
		horloge.setBounds(10, 11, 156, 36);
		getContentPane().add(horloge);
		horloge.setColumns(5);
		
		nomStagiaire = new JLabel("Nom Stagiaire");
		nomStagiaire.setBounds(10, 90, 99, 23);
		getContentPane().add(nomStagiaire);
		
		prenomStagiaire = new JLabel("Prenom Stagiaire");
		prenomStagiaire.setBounds(10, 133, 99, 14);
		getContentPane().add(prenomStagiaire);
		
		CIN = new JLabel("CIN Stagiaire");
		CIN.setBounds(10, 179, 79, 14);
		getContentPane().add(CIN);
		
		naissance = new JLabel("Date Naissance");
		naissance.setBounds(10, 221, 89, 14);
		getContentPane().add(naissance);
		
		universite = new JLabel("Universit\u00E9");
		universite.setBounds(10, 263, 79, 14);
		getContentPane().add(universite);
		
		Specialite = new JLabel("Specialit\u00E9");
		Specialite.setBounds(11, 301, 78, 14);
		getContentPane().add(Specialite);
		
		nomStagiaireField = new JTextField();
		nomStagiaireField.setBounds(109, 91, 128, 20);
		getContentPane().add(nomStagiaireField);
		nomStagiaireField.setColumns(10);
		
		prenomStagiaireField = new JTextField();
		prenomStagiaireField.setBounds(109, 130, 128, 20);
		getContentPane().add(prenomStagiaireField);
		prenomStagiaireField.setColumns(10);
		
		CINField = new JTextField();
		CINField.setBounds(109, 176, 128, 20);
		getContentPane().add(CINField);
		CINField.setColumns(10);
		
		naissanceField = new JTextField();
		naissanceField.setBounds(109, 218, 128, 20);
		getContentPane().add(naissanceField);
		naissanceField.setColumns(10);
		
		universiteField = new JTextField();
		universiteField.setBounds(109, 260, 128, 20);
		getContentPane().add(universiteField);
		universiteField.setColumns(10);
		
		specialtyField = new JTextField();
		specialtyField.setBounds(109, 298, 128, 20);
		getContentPane().add(specialtyField);
		specialtyField.setColumns(10);
		
		CINStagiaireRech = new JLabel("CIN Stagiaire");
		CINStagiaireRech.setBounds(284, 14, 79, 14);
		getContentPane().add(CINStagiaireRech);
		
		CINStagiaireRechField = new JTextField();
		CINStagiaireRechField.setColumns(10);
		CINStagiaireRechField.setBounds(363, 11, 148, 20);
		getContentPane().add(CINStagiaireRechField);
		
		modifier = new ButtonColor("Modifier",Color.BLACK);
		modifier.setFont(new Font("Tahoma", Font.BOLD, 12));
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cin=CINStagiaireRechField.getText();
				rechercher(cin);
				valider.setVisible(true);
				CINStagiaireRechField.setText("");
				
			}
		});
		modifier.setBounds(412, 39, 99, 23);
		getContentPane().add(modifier);
		
		
		searchField = new JXSearchField("CIN ou Nom/Prenom");
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Object source=evt.getSource();
				if(source==searchField){
					String entree=searchField.getText();
					rechercher(entree);
				}
			}
		});
		searchField.setBounds(595, 11, 156, 23);
		searchField.setColumns(10);
		searchField.setLayoutStyle(LayoutStyle.MAC);
		getContentPane().add(searchField);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(247, 90, 539, 57);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(34);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CIN", "Nom", "Prenom", "Date naissance", "Université", "Specialité"
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		Dimension d = table.getPreferredSize();
		table.setPreferredScrollableViewportSize(d);
		
		valider = new ButtonColor("Valider",Color.BLACK);
		valider.setFont(new Font("Tahoma", Font.BOLD, 12));
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Object source=evt.getSource();
				if(source==valider){
					String []tabContenu=new String[6];
					for(int i=0;i<table.getColumnCount();i++){
						Object valeur=table.getValueAt(0,i) ;
						String contenu=valeur.toString();
						tabContenu[i]=contenu;	
					}
					stagiaire.modifierStagiaire(tabContenu);
				}
			}
		});
		valider.setBounds(383, 154, 227, 23);
		valider.setVisible(false);
		getContentPane().add(valider);
		
		Timer t = new Timer(1000, new ClockListener());
        t.start();
       	
	}
	 class ClockListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
             horloge.setText(df.format(Calendar.getInstance().getTime()));
         }
     }
	class Panneau extends JPanel{
		public void paintComponent(Graphics g){
			try {
				super.paintComponents(g);
				Graphics2D g2d = (Graphics2D)g;
				Image image_ecran = ImageIO.read(new File("backGround.jpg"));
				g2d.drawImage(image_ecran, 0, 0,this.getWidth(),this.getHeight(),this);
				Color Snow3 =new Color(205,201,201);
				g2d.setColor(Snow3);
				g2d.fillRoundRect(3,87,240,280,15,15);
				
				g2d.setColor(Snow3);
				g2d.fillRoundRect(280,7,240,60,15,15);
				
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public void rechercher(String entree){
		try{
			table.setModel(stagiaire.rechercher(entree));
			
		}
		catch(Exception e){
			e.printStackTrace();
		
		}
	}
}


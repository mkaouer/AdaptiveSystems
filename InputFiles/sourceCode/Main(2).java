
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.BorderFactory;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;



public class Main{

	private JFrame frame;
	 public ResultSet result=null;
		public ResultSet resultat=null;
		public ResultSet resultatActeur=null;
		public ResultSet resultatAutoInc=null;
		private JTextField txtFilm;
		private JTextField txtAnnee;
		JComboBox jComboBoxpossede;
		JComboBox jComboBoxVue;
		JComboBox jComboBoxRealisateur;
		JComboBox jComboBoxSociete;
		JList jListActeur;
		Methodes methodes;
		JTextArea jTResum;
	/**
	 * Launch the application.
	 */
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setResizable(false);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked"})
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 437, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 400, 37);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblJbasecreator = new JLabel("Gestion de film");
		lblJbasecreator.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJbasecreator.setForeground(new Color(51, 102, 153));
		lblJbasecreator.setBounds(10, 11, 321, 14);
		panel.add(lblJbasecreator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Donnee du Film", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 58, 400, 420);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		/* label */
		JLabel lblNom = new JLabel("Nom du Film");
		lblNom.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNom.setBounds(10, 25, 148, 14);
		panel_1.add(lblNom);
		
		JLabel lblAnnee = new JLabel("Annee");
		lblAnnee.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblAnnee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnnee.setBounds(10, 57, 148, 14);
		panel_1.add(lblAnnee);
		
		JLabel lblRealise = new JLabel("Réalisateur");
		lblRealise.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblRealise.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRealise.setBounds(10, 90, 148, 14);
		panel_1.add(lblRealise);
		
		JLabel lblSociete = new JLabel("Societe de production");
		lblSociete.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblSociete.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSociete.setBounds(10, 128, 148, 14);
		panel_1.add(lblSociete);
		
		JLabel lblPossede = new JLabel("Est ce que vous l'avez");
		lblPossede.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblPossede.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPossede.setBounds(10, 163, 148, 14);
		panel_1.add(lblPossede);
		
		JLabel lblVue = new JLabel("Est ce que vous l'avez vue");
		lblVue.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblVue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVue.setBounds(10, 196, 148, 14);
		panel_1.add(lblVue);
		
		JLabel lblActeur = new JLabel("Acteur");
		lblActeur.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblActeur.setHorizontalAlignment(SwingConstants.RIGHT);
		lblActeur.setBounds(10, 255, 148, 14);
		panel_1.add(lblActeur);
		
		JLabel lblResum = new JLabel("Resume");
		lblResum.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblResum.setHorizontalAlignment(SwingConstants.LEFT);
		lblResum.setBounds(20, 300, 100, 14);
		panel_1.add(lblResum);
		
		/*text combobox...
		 * contient les champs d'enregistrement
		 */
		txtFilm = new JTextField();
		txtFilm.setBounds(178, 19, 200, 27);
		panel_1.add(txtFilm);
			
		txtAnnee = new JTextField();
		txtAnnee.setBounds(178, 51, 200, 27);
		panel_1.add(txtAnnee);
		
		jComboBoxRealisateur = new JComboBox();
		JPanel jPanelRealisateur = new JPanel();
		jPanelRealisateur.add(jComboBoxRealisateur);
        jComboBoxRealisateur.setBounds(178, 85, 200, 27);
        jComboBoxRealisateur.setMaximumSize( jComboBoxRealisateur.getPreferredSize() );
        methodes= new Methodes();
        MonServeur ser=new MonServeur();     
        try {
        	result = methodes.SelectRealisateur(ser);
        	jComboBoxRealisateur.addItem("INCONNU");
			while(result.next()){
				jComboBoxRealisateur.addItem(result.getObject(2)+" "+result.getObject(3));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}      
        panel_1.add(jComboBoxRealisateur);

		jComboBoxSociete = new JComboBox();
		JPanel jPanelSociete = new JPanel();
		jPanelSociete.add(jComboBoxSociete);
        jComboBoxSociete.setBounds(178, 120, 200, 27);
        jComboBoxSociete.setMaximumSize(jComboBoxSociete.getPreferredSize());    
        try {
        	resultat = methodes.SelectSociete(ser);
        	jComboBoxSociete.addItem("INCONNU");
			while(resultat.next()){
				jComboBoxSociete.addItem(resultat.getObject(2));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        panel_1.add(jComboBoxSociete);
		
		jComboBoxpossede = new JComboBox();
		JPanel jPanelPossede = new JPanel();
		jPanelPossede.add(jComboBoxpossede);
        jComboBoxpossede.setBounds(178, 156, 200, 27);
        jComboBoxpossede.addItem("Non");
        jComboBoxpossede.addItem("Oui");
        panel_1.add(jComboBoxpossede);
		
        jComboBoxVue = new JComboBox();
		JPanel jPanelVue = new JPanel();
		jPanelVue.add(jComboBoxVue);
        jComboBoxVue.setBounds(178, 191, 200, 27);
        jComboBoxVue.addItem("Non");
        jComboBoxVue.addItem("Oui");
        panel_1.add(jComboBoxVue);
	
        jListActeur = new JList();
        jListActeur.setFont(new Font("Arial", 0, 12));
        Vector vectActor= new Vector();
        try {
        	resultatActeur = methodes.SelectActeur(ser);      	
        	while(resultatActeur.next()){
        		vectActor.addElement(resultatActeur.getObject(2).toString());
			}
        	jListActeur.setListData(vectActor);
        } catch (SQLException e1) {
        	// TODO Auto-generated catch block
        	e1.printStackTrace();
        }
        jListActeur.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                if(super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                }
                else {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
        JScrollPane jsp=new JScrollPane(jListActeur);
        jsp.setBounds(178, 231, 200, 70);
        panel_1.add(jsp);
             
        jTResum = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(jTResum);
        scrollPane.setBounds(20, 320, 358, 90);
        jTResum.setLineWrap(true);
        panel_1.add(scrollPane);
        
        
        
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panel_2.setBounds(10, 480, 400, 34);
		frame.getContentPane().add(panel_2);
		
		
		
		/* Recuperation des donnees 
		 * Execution de la requete
		 */
		
		JButton btnCrerLeChamp = new JButton("Creer le champ");
		btnCrerLeChamp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonServeur ser=new MonServeur();
				resultatAutoInc = methodes.SelectAutoInc(ser);
				ser.setNomFilm(txtFilm.getText());
				if(txtAnnee.getText().length()==0) ser.setAnnee(null);
				else ser.setAnnee(txtAnnee.getText());
				if(jComboBoxRealisateur.getSelectedIndex()==0)
					ser.setRealisateur(null);
				else{
					try {
						result.absolute(jComboBoxRealisateur.getSelectedIndex());
						ser.setRealisateur(result.getObject(1).toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(jComboBoxSociete.getSelectedIndex()==0)
					ser.setSociete(null);
				else{
					try {
						resultat.absolute(jComboBoxSociete.getSelectedIndex());
						ser.setSociete(resultat.getObject(1).toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		        ser.setPossede(jComboBoxpossede.getSelectedIndex());
		        ser.setEstVue(jComboBoxVue.getSelectedIndex());
		        ser.setResum(jTResum.getText());
		        
				Methodes met=new Methodes();
				
				if(met.CreerChamps(ser)){
					JOptionPane.showMessageDialog(null, "Votre le champ a été crée");
					
				}else {
					JOptionPane.showMessageDialog(null, "Création echoué : Nom de la base invalide ou existant");
				}
				
				int[] nbInd=null;
				nbInd= jListActeur.getSelectedIndices();
				int max=nbInd.length;
				try {
					resultatAutoInc.next();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				for(int i=0;i<max;i++)
	            {
					try {
						resultatActeur.absolute(nbInd[i]+1);
						met.ActeurJoue(resultatAutoInc.getObject(11).toString(),resultatActeur.getObject(1).toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
	            }
				
			}
		});
		btnCrerLeChamp.setBounds(260, 5, 121, 23);
		panel_2.add(btnCrerLeChamp);
		
	
		
	}
}

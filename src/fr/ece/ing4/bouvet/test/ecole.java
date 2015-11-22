package fr.ece.ing4.bouvet.test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.ScrollPane;
import java.awt.List;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import fr.ece.ing4.bouvet.beans.Eleve;
import fr.ece.ing4.bouvet.beans.Inscription;
import fr.ece.ing4.bouvet.beans.Module;
import fr.ece.ing4.bouvet.beans.Note;
import fr.ece.ing4.bouvet.beans.Professeur;
import fr.ece.ing4.bouvet.beans.Specialite;
import fr.ece.ing4.bouvet.beans.Utilisateur;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ecole {

	/*
	 * Socket + liste de récupération
	 * 
	 */
	Socket socket;
	String res;
	String resSplited;
	String[] resFull;
	ObjectInputStream ois = null;
	
	ArrayList<Utilisateur> listUser = new ArrayList<Utilisateur>();
	ArrayList<Eleve> listEleve = new ArrayList<Eleve>();
	ArrayList<Inscription> listInscriptions = new ArrayList<Inscription>();
	ArrayList<Module> listModule = new ArrayList<Module>();
	
	
	Specialite s1 = new Specialite(0, "SI");
	Specialite s2 = new Specialite(1, "OCRES");
	Specialite s3 = new Specialite(2, "Autres");

	Module m1 = new Module(0, "SQL", 0);
	Module m2 = new Module(1, "Reseau", 0);
	Module m3 = new Module(2, "Java", 0);
	Module m4 = new Module(3, "Web", 1);
	Module m5 = new Module(4, "Anglais", 1);

	Professeur p1 = new Professeur(0, "Darquier", 0, 0);
	Professeur p2 = new Professeur(1, "Hermant", 1, 1);
	Professeur p3 = new Professeur(2, "Lemon", 2, 1);
	Professeur p4 = new Professeur(3, "Leonidas", 3, 0);
	Professeur p5 = new Professeur(4, "Albukek", 4, 2);

	Eleve el1 = new Eleve(0, "Paul", 0, 0);
	Eleve el2 = new Eleve(1, "Alexis", 0, 1);
	Eleve el3 = new Eleve(2, "Nicolas", 2, 0);
	Eleve el4 = new Eleve(3, "Jean-Pierre", 3, 0);
	Eleve el5 = new Eleve(4, "Logan", 3, 0);
	Eleve el6 = new Eleve(5, "Roger", 2, 2);
	Eleve el7 = new Eleve(6, "Fred", 1, 1);

	Inscription in1 = new Inscription(0, 0, 0, "Etudiant", 1);
	Inscription in2 = new Inscription(1, 0, 1, "Assistant", 1);
	Inscription in3 = new Inscription(2, 0, 2, "Etudiant", 1);
	Inscription in4 = new Inscription(3, 1, 4, "Etudiant", 1);
	Inscription in5 = new Inscription(4, 2, 4, "Assistant", 1);
	Inscription in6 = new Inscription(5, 1, 3, "Etudiant", 1);

	// int id, int eleve, int module, int note, String type, float coefficient
	Note n1 = new Note(0, 0, 0, 10, "DS", 5);
	Note n2 = new Note(1, 0, 1, 14, "Partiel", 7);
	Note n3 = new Note(2, 2, 4, 7, "TP", 2);

	private ArrayList<Eleve> listeEleve = new ArrayList();
	private ArrayList<Professeur> listeProfesseur = new ArrayList();
	private ArrayList<Module> listeModule = new ArrayList();
	private ArrayList<Note> listeNote = new ArrayList();
	private ArrayList<Inscription> listeInscription = new ArrayList();
	private ArrayList<Specialite> listeSpecialite = new ArrayList();

	// GLOBAL CLICKED
	private Module clkdModule = null;
	private int clkdModuleEleve;
	private Specialite clkdSpec = null;
	private Eleve clkdEleve = null;

	private JFrame frame;
	JScrollPane spListEleve = new JScrollPane();
	JScrollPane spListModEle = new JScrollPane();
	JScrollPane spListMods = new JScrollPane();
	JScrollPane spListSpecialite = new JScrollPane();

	JList listEleves = new JList();
	JList listModulesSpec = new JList();
	JList listeModules = new JList();
	JList listSpecialites = new JList();

	// JLabel Module Panel
	JLabel lblNom = new JLabel("Nom :");
	JLabel lblEleves = new JLabel("Elèves :");
	JLabel lblProfesseur = new JLabel("Professeur :");
	JLabel lblSpcialit = new JLabel("Spécialité :");
	JLabel lblModules = new JLabel("Modules :");
	JLabel lblReponseNom = new JLabel();
	JLabel lblReponseProfesseur = new JLabel();
	JLabel lblReponseSpecialite = new JLabel();
	JLabel lblListeSpecialite = new JLabel("Liste Specialités :");
	JLabel lblListeModules = new JLabel("Liste Modules :");
	JButton btnRemoveModule = new JButton("--->");
	JButton btnAddModule = new JButton("<---");

	// JLabel Note Panel
	JLabel lblNomPNote = new JLabel("Nom :");
	JLabel lblProfesseurPNote = new JLabel("Professeur :");
	JLabel lblSpcialitPNote = new JLabel("Spécialité :");
	JLabel lblModulesPNote = new JLabel("Modules :");
	JScrollPane spModuleElevePNote = new JScrollPane();
	JList listModulesElevePNote = new JList();
	JLabel lblReponseNomPNote = new JLabel();
	JLabel lblReponseSpecialitePNote = new JLabel();
	private final JList listElevePNote = new JList();
	private final JScrollPane spListElevePNote = new JScrollPane();
	private final JLabel lblElevePNote = new JLabel("Elèves :");
	private final JLabel lblReponseProfPNote = new JLabel();
	private int indexEleve;

	JRadioButton rdbtnAssistant = new JRadioButton("Tuteur");
	JRadioButton rdbtnEleve = new JRadioButton("Eleve");
	private final JList list = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ecole window = new ecole();
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
	public ecole() {
		initialize();
		main();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		spListEleve.setBounds(6, 50, 181, 420);
		lblReponseProfesseur.setBackground(Color.WHITE);
		lblReponseProfesseur.setBounds(297, 75, 148, 16);
		lblEleves.setBounds(6, 22, 47, 16);
		lblProfesseur.setBackground(SystemColor.window);
		lblProfesseur.setBounds(217, 75, 74, 16);
		lblSpcialit.setBounds(217, 103, 68, 16);
		spListModEle.setBounds(692, 52, 155, 418);
		lblModules.setBounds(217, 131, 61, 16);
		listModulesSpec.setBackground(Color.WHITE);
		lblReponseNom.setBackground(Color.WHITE);
		lblReponseNom.setBounds(297, 52, 148, 16);
		lblReponseSpecialite.setBackground(Color.WHITE);
		lblReponseSpecialite.setBounds(297, 103, 148, 16);
		btnRemoveModule.setBounds(457, 344, 223, 29);
		spListMods.setBounds(290, 129, 155, 341);
		btnAddModule.setBounds(457, 303, 223, 29);
		spListSpecialite.setBounds(525, 52, 155, 171);
		lblListeSpecialite.setBounds(525, 34, 109, 16);
		lblListeModules.setBounds(692, 34, 95, 16);
		lblNom.setBounds(217, 52, 38, 16);
		lblNom.setBackground(SystemColor.window);
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setBounds(100, 100, 900, 550);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frame, 
		            "Êtes-vous sur de vouloir quitter l'application ?", "Quitter l'application", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        		exitFunction();
		            	System.exit(0);
		        	}
		    }
		});
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JPanel panelGestionNotes = new JPanel();
		final JPanel panelGestionModule = new JPanel();

		tabbedPane.setBounds(0, 0, 894, 522);
		frame.getContentPane().add(tabbedPane);

		panelGestionNotes.setLayout(null);
		spListElevePNote.setBounds(6, 54, 183, 416);
		spListElevePNote.setRowHeaderView(listElevePNote);
		lblElevePNote.setBounds(6, 20, 69, 22);
		lblNomPNote.setBounds(201, 54, 61, 16);
		lblProfesseurPNote.setBounds(201, 82, 74, 16);
		lblSpcialitPNote.setBounds(201, 110, 74, 16);
		lblModulesPNote.setBounds(201, 138, 74, 16);
		spModuleElevePNote.setBounds(283, 138, 143, 332);
		spModuleElevePNote.setViewportView(listModulesElevePNote);
		lblReponseNomPNote.setBounds(285, 54, 139, 16);
		lblReponseSpecialitePNote.setBounds(287, 110, 144, 16);
		lblReponseProfPNote.setBounds(287, 82, 139, 16);

		panelGestionNotes.add(spListElevePNote);
		panelGestionNotes.add(lblElevePNote);
		panelGestionNotes.add(lblNomPNote);
		panelGestionNotes.add(lblProfesseurPNote);
		panelGestionNotes.add(lblSpcialitPNote);
		panelGestionNotes.add(lblReponseSpecialitePNote);
		panelGestionNotes.add(spModuleElevePNote);
		panelGestionNotes.add(lblModulesPNote);
		panelGestionNotes.add(lblReponseNomPNote);
		panelGestionNotes.add(lblReponseProfPNote);
		panelGestionModule.setLayout(null);
		panelGestionModule.add(lblNom);
		panelGestionModule.add(spListEleve);
		panelGestionModule.add(lblEleves);
		panelGestionModule.add(lblProfesseur);
		panelGestionModule.add(lblSpcialit);
		panelGestionModule.add(lblModules);
		panelGestionModule.add(spListModEle);
		panelGestionModule.add(lblReponseNom);
		panelGestionModule.add(lblReponseProfesseur);
		panelGestionModule.add(lblReponseSpecialite);
		panelGestionModule.add(btnRemoveModule);
		panelGestionModule.add(btnAddModule);
		panelGestionModule.add(spListMods);
		panelGestionModule.add(spListSpecialite);
		panelGestionModule.add(lblListeSpecialite);
		panelGestionModule.add(lblListeModules);

		spListModEle.setViewportView(listModulesSpec);
		spListMods.setViewportView(listeModules);
		spListSpecialite.setViewportView(listSpecialites);
		spListEleve.setRowHeaderView(listEleves);

		btnRemoveModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (clkdModuleEleve >= 0) {
					removeInscription();
				}
			}
		});
		btnAddModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String radioText = "";
				if (clkdModule != null && clkdEleve != null) {
					if (rdbtnAssistant.isSelected()) {
						radioText = "Assistant";
						Inscription i1 = new Inscription(listeInscription.size(), clkdEleve.getId(), clkdModule.getId(),
								radioText, 1);
						addInscription(i1);
					} else if (rdbtnEleve.isSelected()) {
						radioText = "Eleve";
						Inscription i1 = new Inscription(listeInscription.size(), clkdEleve.getId(), clkdModule.getId(),
								radioText, 1);
						addInscription(i1);
					} else {
						radioText = "Non selectionné";
						javax.swing.JOptionPane.showMessageDialog(panelGestionModule,
								"Vous n'avez pas selectionné de fonction.", radioText, 1);
					}
				} else {
					javax.swing.JOptionPane.showMessageDialog(panelGestionModule,
							"Veuillez selectionner un élève et un module.", radioText, 1);
				}

			}
		});
		tabbedPane.addTab("Gestion Modules", null, panelGestionModule, null);

		rdbtnAssistant.setBounds(552, 235, 141, 23);
		panelGestionModule.add(rdbtnAssistant);

		rdbtnEleve.setBounds(552, 268, 141, 23);
		panelGestionModule.add(rdbtnEleve);
		tabbedPane.addTab("Gestion Notes", null, panelGestionNotes, null);

		ButtonGroup bg1 = new ButtonGroup();

		bg1.add(rdbtnAssistant);
		bg1.add(rdbtnEleve);
		list.setBounds(464, 156, 38, -39);

		panelGestionModule.add(list);

	}

	protected void exitFunction() {
		// TODO Auto-generated method stub
		// C'est là qu'on envoit les données au serveur
		System.out.println(this.s1.getNom());
	}

	private void removeInscription() {
		this.listeInscription.get(clkdModuleEleve).setState(-1);
		this.displayInfoModule(indexEleve);

	}

	private void addInscription(Inscription i1) {
		Boolean create = true;
		for (int i = 0; i < listeInscription.size(); i++) {
			if (listeInscription.get(i).getEleve() == this.clkdEleve.getId()) {
				if ((i1.getModule() == listeInscription.get(i).getModule()) && (listeInscription.get(i).getState() > 0))
					create = false;
			}
		}
		if (create)
			this.listeInscription.add(i1);
		this.displayInfoModule(indexEleve);
	}

	private void main() {
		getResources();
		setEleves();
		setModules();
		setSpecialites();
		createMouseAdapter();
	}

	private void createMouseAdapter() {
		MouseListener mLEleves = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				int index = theList.locationToIndex(mouseEvent.getPoint());
				if (index >= 0)
					displayInformations(index);
			}
		};
		MouseListener mLSpec = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				int index = theList.locationToIndex(mouseEvent.getPoint());
				if (index >= 0)
					displayModuleBySpe(index);
				// variable globale module cliqué
			}

		};
		MouseListener mLModule = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				int index = theList.locationToIndex(mouseEvent.getPoint());
				setVariableClkdModule(index);
				// variable globale module cliqué
			}
		};
		MouseListener mLModuleEleve = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				int index = theList.locationToIndex(mouseEvent.getPoint());
				setVariableClkdModuleEleve(index);
				// variable globale module cliqué
			}
		};

		this.listEleves.addMouseListener(mLEleves);
		this.listElevePNote.addMouseListener(mLEleves);
		this.listSpecialites.addMouseListener(mLSpec);
		this.listModulesSpec.addMouseListener(mLModule);
		this.listeModules.addMouseListener(mLModuleEleve);
	}

	private void setVariableClkdModule(int index) {
		int j = 0;
		for (int i = 0; i < listeModule.size(); i++) {
			if (listeModule.get(i).getSpecialite() == clkdSpec.getId()) {
				if (j == index)
					this.clkdModule = listeModule.get(i);
				j++;
			}
		}
	}

	private void setVariableClkdModuleEleve(int index) {
		int j = 0;
		for (int i = 0; i < listeInscription.size(); i++) {
			if (listeInscription.get(i).getEleve() == clkdEleve.getId()) {
				if (listeInscription.get(i).getState() >= 0) {
					if (j == index) {
						this.clkdModuleEleve = i;
					}
					j++;
				}
			}
		}
	}

	private void displayInformations(int index) {
		this.indexEleve = index;
		this.clkdEleve = listeEleve.get(index);
		// System.out.println(clkdEleve.getNom());
		displayInfoEleve(index);
		displayInfoModule(index);
	}

	private void displayModuleBySpe(int index) {
		this.clkdSpec = listeSpecialite.get(index);
		System.out.println(clkdSpec.getNom());
		DefaultListModel dlmModules = new DefaultListModel();
		int j = 0;
		for (int i = 0; i < listeModule.size(); i++) {
			if ((listeModule.get(i).getSpecialite() == listeSpecialite.get(index).getId())) {

				dlmModules.add(j, listeModule.get(i).getNom());
				j++;
			}
		}
		this.listModulesSpec.setModel(dlmModules);
	}

	private void displayInfoModule(int index) {
		// TODO Auto-generated method stub
		DefaultListModel dlmModules = new DefaultListModel();
		int j = 0;
		for (int i = 0; i < listeInscription.size(); i++) {
			if ((listeInscription.get(i).getEleve() == listeEleve.get(index).getId())) {
				if ((listeInscription.get(i).getState() >= 0)) {

					// System.out.println(this.listeInscription.toString());
					dlmModules.add(j, getNameById("module", listeInscription.get(i).getModule()));
					j++;
				}
			}
		}
		this.listeModules.setModel(dlmModules);
		this.listModulesElevePNote.setModel(dlmModules);
	}

	private void displayInfoEleve(int index) {
		this.lblReponseNom.setText(listeEleve.get(index).getNom());
		this.lblReponseNomPNote.setText(listeEleve.get(index).getNom());
		this.lblReponseProfesseur.setText(getNameById("prof", listeEleve.get(index).getProfesseur()));
		this.lblReponseProfPNote.setText(getNameById("prof", listeEleve.get(index).getProfesseur()));
		this.lblReponseSpecialite.setText(getNameById("spec", listeEleve.get(index).getSpecialite()));
		this.lblReponseSpecialitePNote.setText(getNameById("spec", listeEleve.get(index).getSpecialite()));
	}

	private String getNameById(String type, int id) {
		String res = "";
		switch (type) {
		case "prof":
			for (int i = 0; i < listeProfesseur.size(); i++)
				if (listeProfesseur.get(i).getId() == id)
					res = listeProfesseur.get(i).getNom();
			break;
		case "spec":
			for (int i = 0; i < listeSpecialite.size(); i++)
				if (listeSpecialite.get(i).getId() == id)
					res = listeSpecialite.get(i).getNom();
			break;
		case "eleve":
			for (int i = 0; i < listeEleve.size(); i++)
				if (listeEleve.get(i).getId() == id)
					res = listeEleve.get(i).getNom();
			break;
		case "module":
			for (int i = 0; i < listeModule.size(); i++)
				if (listeModule.get(i).getId() == id)
					res = listeModule.get(i).getNom();
			break;
		default:
		}
		return res;
	}

	private void getResources() {
		// TODO Auto-generated method stub
		try {
			socket = new Socket(InetAddress.getLocalHost(), 2009);
			InputStream is = socket.getInputStream();
			ois = new ObjectInputStream(is);
			try {
				res = (String) ois.readObject().toString();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(res);
			res = res.replaceAll("]", "");
			res = res.replaceAll("\\[", "");
			res = res.replaceAll(" ", "");
			resFull = res.split("[,_]");
			/*
			 * for (String resF : resFull) { System.out.println(resF); }
			 */
			for (int i = 0; i < resFull.length; i++) {
				if (resFull[i].equalsIgnoreCase("EleveClass")) {
					System.out.println(resFull[i + 1]);
					listEleve.add(new Eleve(Integer.parseInt(resFull[i + 1]), resFull[i + 2],
							Integer.parseInt(resFull[i + 3]), Integer.parseInt(resFull[i + 4])));
				} else if (resFull[i].equalsIgnoreCase("UtilisateurClass")) {
					System.out.println(resFull[i + 1]);
					listUser.add(new Utilisateur(Integer.parseInt(resFull[i + 1]), resFull[i + 2], resFull[i + 3],
							resFull[i + 4]));
				} else if (resFull[i].equalsIgnoreCase("UtilisateurClass")) {
					System.out.println(resFull[i + 1]);
					listUser.add(new Utilisateur(Integer.parseInt(resFull[i + 1]), resFull[i + 2], resFull[i + 3],
							resFull[i + 4]));
				} else if (resFull[i].equalsIgnoreCase("InscriptionClass")) {
					System.out.println(resFull[i + 1]);
					listUser.add(new Utilisateur(Integer.parseInt(resFull[i + 1]), resFull[i + 2], resFull[i + 3],
							resFull[i + 4]));
				} else if (resFull[i].equalsIgnoreCase("UtilisateurClass")) {
					System.out.println(resFull[i + 1]);
					listUser.add(new Utilisateur(Integer.parseInt(resFull[i + 1]), resFull[i + 2], resFull[i + 3],
							resFull[i + 4]));
				}
			}

			// Utilisateur user2 = new Utilisateur(Integer.parseInt(resFull[0]),
			// resFull[1], resFull[2], resFull[3]);

			// System.out.println((Utilisateur)ois.readObject());

			// ObjectInputStream ois = new ObjectInputStream(is);
			/*
			 * ois = new ObjectInputStream( new BufferedInputStream( new
			 * FileInputStream( new File("game.txt"))));
			 * 
			 * try { System.out.println("Affichage de l'user :");
			 * System.out.println("*************************\n");
			 * System.out.println(ois.readObject().toString());
			 * 
			 * } catch (ClassNotFoundException e) { e.printStackTrace(); }
			 * 
			 * ois.close();
			 */
			System.out.println("close socket");
			socket.close();

		} catch (UnknownHostException e) {
			// System.out.println("error 1");
			e.printStackTrace();
		} catch (IOException e) {
			// System.out.println("error 2");
			e.printStackTrace();
		}
		getEleves();
		getProfesseurs();
		getInscription();
		getModules();
		getSpecialites();
	}

	private void getSpecialites() {
		// TODO Auto-generated method stub
		this.listeSpecialite.add(this.s1);
		this.listeSpecialite.add(this.s2);
		this.listeSpecialite.add(this.s3);
	}

	private void getModules() {
		// TODO Auto-generated method stub
		this.listeModule.add(this.m1);
		this.listeModule.add(this.m2);
		this.listeModule.add(this.m3);
		this.listeModule.add(this.m4);
		this.listeModule.add(this.m5);
	}

	private void getInscription() {
		// TODO Auto-generated method stub
		this.listeInscription.add(this.in1);
		this.listeInscription.add(this.in2);
		this.listeInscription.add(this.in3);
		this.listeInscription.add(this.in4);
		this.listeInscription.add(this.in5);
		this.listeInscription.add(this.in6);
	}

	private void getProfesseurs() {
		// TODO Auto-generated method stub
		this.listeProfesseur.add(p1);
		this.listeProfesseur.add(p2);
		this.listeProfesseur.add(p3);
		this.listeProfesseur.add(p4);
		this.listeProfesseur.add(p5);
	}

	private void getEleves() {
		// TODO Auto-generated method stub
		this.listeEleve.add(el1);
		this.listeEleve.add(el2);
		this.listeEleve.add(el3);
		this.listeEleve.add(el4);
		this.listeEleve.add(el5);
		this.listeEleve.add(el6);
		this.listeEleve.add(el7);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setSpecialites() {
		// TODO Auto-generated method stub
		DefaultListModel dlmSpecialites = new DefaultListModel();
		for (int i = 0; i < this.listeSpecialite.size(); i++)
			dlmSpecialites.add(i, listeSpecialite.get(i).getNom());
		this.listSpecialites.setModel(dlmSpecialites);
		System.out.println("setSpecialites");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setEleves() {
		// TODO Auto-generated method stub
		DefaultListModel dlmEleves = new DefaultListModel();
		for (int i = 0; i < this.listeEleve.size(); i++) {
			dlmEleves.add(i, listeEleve.get(i).getNom());
		}
		this.listEleves.setModel(dlmEleves);
		this.listElevePNote.setModel(dlmEleves);
		System.out.println("setEleves");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setModules() {
		// TODO Auto-generated method stub

	}
}

package frontiere;

import controleur.ControlPrendreEtal;


public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		StringBuilder s = new StringBuilder();

		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			s.append("Je suis désolé ");
			s.append(nomVendeur);
			s.append(" mais il faut être un habitant de notre village pour commercer ici.");
			System.out.println(s.toString());
		}else {
			s.append("Bonjour ");
			s.append(nomVendeur);
			s.append(", je vais regarder si je peux vous trouver un étal.");
			
			if(!controlPrendreEtal.resteEtals()) {
				s.append("Désolé ");
				s.append(nomVendeur);
				s.append(" je n'ai plus d'étal qui ne soit pas déjà occupé.");
				System.out.println(s.toString());
				
			}else {
				System.out.println(s.toString());
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder s = new StringBuilder("C'est parfait, il me reste un étal pour vous !\n");
		s.append("Il me faudrait quelques renseignement.");
		System.out.println(s.toString());
		
		String produit;
		int nbProduit;
		int numeroEtal;
		
		StringBuilder question = new StringBuilder("quel produit souhaitez-vous vendre ?");
		produit = Clavier.entrerChaine(question.toString());
		
		question = new StringBuilder("Combien souhaitez-vous en vendre ?");
		nbProduit = Clavier.entrerEntier(question.toString());
		
		numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			s = new StringBuilder("Le vendeur ");
			s.append(nomVendeur);
			s.append(" s'est installé a l'étal n° ");
			s.append(numeroEtal);
			System.out.println(s.toString());
		}

	}
}

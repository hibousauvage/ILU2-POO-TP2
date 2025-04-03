package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		StringBuilder s = new StringBuilder();
		StringBuilder question = new StringBuilder();

		if(!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			s.append("Je suis désolé ");
			s.append(nomAcheteur);
			s.append(" mais il faut être un habitant de notre village pour commercer ici.");
			System.out.println(s.toString());
		}else {
			Gaulois[] vendeurs;
			question.append("Quel produit voulez-vous acheter ?");
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			vendeurs = controlAcheterProduit.trouverVendeurProduit(produit);
			if(vendeurs.length == 0) {
				s = new StringBuilder();
				s.append("Désolé, personne ne vend ce produit au marché.");
				System.out.println(s.toString());
			}else {
				s.append("Chez quel commerçant voulez-vous acheter des ");
				s.append(produit);
				s.append("\n");
				for(int i=0;i<vendeurs.length;i++) {
					s.append("1 - ");
					s.append(vendeurs[i].getNom());
					s.append("\n");
				}
				int numeroGaulois = Clavier.entrerEntier(s.toString());
				s = new StringBuilder();
				s.append(nomAcheteur);
				s.append(" se déplace jusqu'à l'étal du vendeur ");
				s.append(vendeurs[numeroGaulois-1].getNom());
				s.append("\nBonjour ");
				s.append(nomAcheteur);
				System.out.println(s.toString());
				s = new StringBuilder("Combien de ");
				s.append(produit);
				s.append(" voulez-vous acheter ?");
				int nbProduit = Clavier.entrerEntier(s.toString());
				int nbProduitAcheter = controlAcheterProduit.acheterProduit(vendeurs[numeroGaulois-1], nbProduit);
				s = new StringBuilder();
				if(nbProduitAcheter == 0) {
					s.append(nomAcheteur);
					s.append(" veut acheter ");
					s.append(nbProduit);
					s.append(" ");
					s.append(produit);
					s.append(", malheureusement il n'y en a plus !");
					
				}else if (nbProduit == nbProduitAcheter) {
					s.append(nomAcheteur);
					s.append(" achète ");
					s.append(nbProduitAcheter);
					s.append(" ");
					s.append(produit);
					s.append(" à ");
					s.append(vendeurs[numeroGaulois-1].getNom());
					
				}else {
					s.append(nomAcheteur);
					s.append(" veut acheter ");
					s.append(nbProduit);
					s.append(" ");
					s.append(produit);
					s.append(", malheureusement ");
					s.append(vendeurs[numeroGaulois-1].getNom());
					s.append(" n'en a plus que ");
					s.append(nbProduitAcheter);
					s.append(". ");
					s.append(nomAcheteur);
					s.append(" achète tout le stock de ");
					s.append(vendeurs[numeroGaulois-1].getNom());
					s.append(".");
				}
				System.out.println(s.toString());
				
			}
		}
	}
}

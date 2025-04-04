package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}

	public Gaulois[] trouverVendeurProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public int acheterProduit(Gaulois vendeur,int quantiteAcheter) {
		Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur.getNom());
		return etalVendeur.acheterProduit(quantiteAcheter);
	}
}

package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder acceuil = new StringBuilder("Binevenue villageois ");
					acceuil.append(nomVisiteur);
					acceuil.append("\nQuelle est votre force ?\n");
					controlEmmenager.ajouterGaulois(nomVisiteur, Clavier.entrerEntier(acceuil.toString()));
					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {

		int forceDruide;
		int effetPotionMin=0;
		int effetPotionMax=-1;
		StringBuilder acceuil = new StringBuilder("Bienvenue druide ");
		acceuil.append(nomVisiteur);
		acceuil.append("\nQuelle est votre force ?\n");
		forceDruide = Clavier.entrerEntier(acceuil.toString());
		
		for(;effetPotionMax<effetPotionMin;) {
			effetPotionMin = Clavier.entrerEntier( new StringBuilder("Quelle est la force de la potion la plus faible que vous produisez ?").toString());
		
			effetPotionMax = Clavier.entrerEntier(new StringBuilder("quelle est la force de la potion la plus forte que vous produisez ?").toString());
			if(effetPotionMax<effetPotionMin) {
				System.out.println(new StringBuilder("Attention Druide, vous vous êtes trompé entre le minimum et le maximum").toString());
			}
		}
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
		
	}
	
}

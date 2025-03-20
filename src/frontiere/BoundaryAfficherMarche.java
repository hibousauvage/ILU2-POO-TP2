package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length == 0) {
			System.out.println(new StringBuilder("Le marché est vide, revenez plus tard.").toString());
			
		}else {
			StringBuilder s = new StringBuilder();
			s.append(nomAcheteur);
			s.append(", vous touverez au marché :");
			for(int i=0;i<infosMarche.length;i++) {
				s.append(false);
				//TODO
			}
			
		}
	}
}

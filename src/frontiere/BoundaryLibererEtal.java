package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println(new StringBuilder("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !").toString());
			
		}else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(donneesEtal[0].contentEquals("true")) {
				StringBuilder s = new StringBuilder("vous avez vendu ");
				s.append(donneesEtal[4]);
				s.append(" sur ");
				s.append(donneesEtal[3]);
				s.append(" ");
				s.append(donneesEtal[2]);
				s.append("\nEn revoir ");
				s.append(nomVendeur);
				s.append(", passez une bonne journée");
				System.out.println(s.toString());
				
			}
		}
	}

}


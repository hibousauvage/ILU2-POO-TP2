package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;

	private ControlAfficherMarche controlafficher;
	
	@BeforeEach
	void initVillage() {
		Chef abraracourcix;
		village = new Village("le village des irrecuctible", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlafficher = new ControlAfficherMarche(village);
	}

	@Test
	void testControlAfficherMarche() {
		assertNotNull(controlafficher);
	}

	@Test
	void testDonnerInfosMarche() {
		fail("Not yet implemented");
		/*String[] infos = controlafficher.donnerInfosMarche();
		//assertEquals(infos, null);
		Gaulois asterix = new Gaulois("asterix", 5);
		Gaulois bonemine = new Gaulois("Bonemine", 3);
		Gaulois obelix = new Gaulois("Obelix",20);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "casque", 2);
		int i = 0;

		assertNotNull(infos[i]);
		i++;
		assertNotNull(infos[i]);
		i++;
		assertNotNull(infos[i]);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleur", 10);
		village.installerVendeur(obelix, "sanglier", 2);
		for(i=0;i<3;i++) {
			assertNotNull(infos[i]);
			i++;
			assertNotNull(infos[i]);
			i++;
			assertNotNull(infos[i]);
			i++;
		}*/
		
		
	}

}

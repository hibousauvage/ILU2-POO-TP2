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
		String[] infos = controlafficher.donnerInfosMarche();
		assertEquals(infos.length, 0);
		Gaulois asterix = new Gaulois("Asterix", 5);
		Gaulois bonemine = new Gaulois("Bonemine", 3);
		Gaulois obelix = new Gaulois("Obelix",20);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "casque", 2);
		infos = controlafficher.donnerInfosMarche();
		assertEquals(infos.length, 3);
		for(int i=0;i<infos.length;i=i+3) {
			assertEquals(infos[i], "Asterix");
			assertEquals(infos[i+1], "2");
			assertEquals(infos[i+2], "casque");
		}
		
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleur", 10);
		village.installerVendeur(obelix, "sanglier", 2);
		infos = controlafficher.donnerInfosMarche();
		assertEquals(infos.length, 9);
		for(int i=0;i<infos.length;i+=3) {
			assertNotNull(infos[i]);
			assertNotNull(infos[i+1]);
			assertNotNull(infos[i+2]);
		}
	}

}

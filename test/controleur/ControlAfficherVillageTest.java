package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	
	private ControlAfficherVillage controle;
	
	@BeforeEach
	void initVillage() {
		Chef abraracourcix;
		village = new Village("le village des irreductible", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controle = new ControlAfficherVillage(village);
	}

	@Test
	void testControlAfficherVillage() {
		assertNotNull(controle);
	}

	@Test
	void testDonnerNomsVillageois() {
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		String[] noms = controle.donnerNomsVillageois();
		assertEquals(noms.length, 1);
		assertEquals(noms[0], abraracourcix.getNom());
		Gaulois asterix = new Gaulois("Asterix", 5);
		village.ajouterHabitant(asterix);
		noms = controle.donnerNomsVillageois();
		assertEquals(noms.length, 2);
		assertEquals(noms[0], abraracourcix.getNom());
		assertEquals(noms[1], asterix.getNom());
		
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(controle.donnerNomVillage(), "le village des irreductible");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(controle.donnerNbEtals(), 5);
	}

}

package controleur;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	
	private ControlVerifierIdentite controlVerifierIdentite;

	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controlVerifierIdentite);
	}
	
	@BeforeEach
	void initVillage() {
		Chef abraracourcix;
		village = new Village("le village des irrecuctible", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testVerifierIdentite() {
		Gaulois asterix = new Gaulois("Asterix", 5)	;
		assertFalse(controlVerifierIdentite.verifierIdentite(asterix.getNom()));
		village.ajouterHabitant(asterix);
		assertTrue(controlVerifierIdentite.verifierIdentite(asterix.getNom()));
	}

}

package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private Village village;
	
	private ControlPrendreEtal controle;
	private ControlVerifierIdentite controleIdentite;
	
	@BeforeEach
	void initVillage() {
		Chef abraracourcix;
		village = new Village("le village des irreductible", 10, 4);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controleIdentite = new ControlVerifierIdentite(village);
		controle = new ControlPrendreEtal(controleIdentite,village);
	}
	
	@Test
	void testControlPrendreEtal() {
		assertNotNull(controle);
	}

	@Test
	void testResteEtals() {
		assertTrue(controle.resteEtals());
		
		Gaulois asterix = new Gaulois("Asterix",5);
		Gaulois obelix = new Gaulois("Obelix",5);
		Gaulois bonemine = new Gaulois("Bonemine",5);
		Gaulois assurancetourix = new Gaulois("Assurancetourix",5);
		
		assertTrue(controle.resteEtals());
		village.ajouterHabitant(asterix);
		assertTrue(controle.resteEtals());
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(bonemine);
		village.ajouterHabitant(assurancetourix);
		assertTrue(controle.resteEtals());
		
		village.installerVendeur(asterix, "casque", 5);
		assertTrue(controle.resteEtals());
		village.installerVendeur(obelix, "menir", 10);
		assertTrue(controle.resteEtals());
		village.installerVendeur(bonemine, "fleur", 10);
		assertTrue(controle.resteEtals());
		village.installerVendeur(assurancetourix, "harpe", 2);
		assertFalse(controle.resteEtals());
		village.partirVendeur(bonemine);
		assertTrue(controle.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		Gaulois asterix = new Gaulois("Asterix",5);
		Gaulois obelix = new Gaulois("Obelix",5);
		Gaulois bonemine = new Gaulois("Bonemine",5);
		Gaulois assurancetourix = new Gaulois("Assurancetourix",5);
		Gaulois falbala = new Gaulois("Falbala",1);
		village.ajouterHabitant(falbala);
		village.ajouterHabitant(assurancetourix);
		village.ajouterHabitant(bonemine);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(asterix);

		assertNotEquals(controle.prendreEtal(asterix.getNom(), "casque", 5), -1);
		assertNotEquals(controle.prendreEtal(obelix.getNom(), "menhir", 5), -1);
		assertNotEquals(controle.prendreEtal(bonemine.getNom(), "fleur", 5), -1);
		assertNotEquals(controle.prendreEtal(assurancetourix.getNom(), "harpe", 5), -1);

		assertEquals(controle.prendreEtal(falbala.getNom(), "fleur", 6), -1);
		village.partirVendeur(asterix);
		assertNotEquals(controle.prendreEtal(falbala.getNom(), "fleur", 6), -1);

	}

	@Test
	void testVerifierIdentite() {
		assertFalse(controle.verifierIdentite("cesar"));
		Gaulois asterix = new Gaulois("Asterix",5);
		assertFalse(controle.verifierIdentite(asterix.getNom()));
		village.ajouterHabitant(asterix);
		assertTrue(controle.verifierIdentite(asterix.getNom()));
		assertFalse(controle.verifierIdentite("cesar"));
	}

}

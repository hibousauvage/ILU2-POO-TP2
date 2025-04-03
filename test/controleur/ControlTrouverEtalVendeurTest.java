package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	
	private ControlTrouverEtalVendeur controle;
	
	@BeforeEach
	void initVillage() {
		Chef abraracourcix;
		village = new Village("le village des irrecuctible", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controle = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(controle);
	}

	@Test
	void testTrouverEtalVendeur() {
		Gaulois asterix = new Gaulois("Asterix", 5);
		Gaulois obelix = new Gaulois("Obelix", 20);
		Etal etal1 = controle.trouverEtalVendeur(asterix.getNom());
		Etal etal2 = controle.trouverEtalVendeur(obelix.getNom());
		assertNull(etal1);
		assertNull(etal2);
		village.ajouterHabitant(obelix);
		etal1 = controle.trouverEtalVendeur(asterix.getNom());
		etal2 = controle.trouverEtalVendeur(obelix.getNom());
		assertNull(etal1);
		assertNull(etal2);
		village.installerVendeur(obelix, "menir", 10);
		etal1 = controle.trouverEtalVendeur(asterix.getNom());
		etal2 = controle.trouverEtalVendeur(obelix.getNom());
		assertNull(etal1);
		assertNotNull(etal2);
		assertEquals(etal2, village.rechercherEtal(obelix));
		village.ajouterHabitant(asterix);
		etal1 = controle.trouverEtalVendeur(asterix.getNom());
		etal2 = controle.trouverEtalVendeur(obelix.getNom());
		assertNotNull(etal2);
		assertEquals(etal2, village.rechercherEtal(obelix));
		assertNull(etal1);
		village.installerVendeur(asterix, "casque", 5);
		etal1 = controle.trouverEtalVendeur(asterix.getNom());
		etal2 = controle.trouverEtalVendeur(obelix.getNom());
		assertNotNull(etal2);
		assertEquals(etal2, village.rechercherEtal(obelix));
		assertNotNull(etal1);
		assertEquals(etal1, village.rechercherEtal(asterix));

	}

}

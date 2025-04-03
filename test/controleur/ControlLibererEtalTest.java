package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest { 
	
	private Village village;

	private ControlLibererEtal controllibereretal;
	private ControlTrouverEtalVendeur controltrouveretalvendeur;
	
	
	@BeforeEach
	void initVillage() {
		Chef abraracourcix;
		village = new Village("le village des irrecuctible", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controltrouveretalvendeur = new ControlTrouverEtalVendeur(village);
		controllibereretal = new ControlLibererEtal(controltrouveretalvendeur);	}
	

	@Test
	void testControlLibererEtal() {
		assertNotNull(controllibereretal);
	}

	@Test
	void testIsVendeur() {
		    Gaulois asterix = new Gaulois("asterix",5);
			assertFalse(controllibereretal.isVendeur("asterix"));
			assertFalse(controllibereretal.isVendeur("obelix"));
			
			village.ajouterHabitant(asterix);
			assertFalse(controllibereretal.isVendeur("asterix"));
			village.installerVendeur(asterix, "epee", 2);
			assertTrue(controllibereretal.isVendeur("asterix"));
			assertFalse(controllibereretal.isVendeur("obelix"));
		
	}

	@Test
	void testLibererEtal() {
		fail("Not yet implemented");
	}

}

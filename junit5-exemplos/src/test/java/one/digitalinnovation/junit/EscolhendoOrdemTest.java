package one.digitalinnovation.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class EscolhendoOrdemTest {
	
	//@Order(4)
	@DisplayName("A")
	@Test
	void validaFluxoA() {
		Assertions.assertTrue(true);	
	}
	
	//@Order(3)
	@DisplayName("B")
	@Test
	void validaFluxoB() {
		Assertions.assertTrue(true);		
	}
	
	//@Order(2)
	@DisplayName("C")
	@Test
	void validaFluxoC() {
		Assertions.assertTrue(true);		
	}
	
	//@Order(1)
	@DisplayName("D")
	@Test
	void validaFluxoD() {
		Assertions.assertTrue(true);		
	}

}

package one.digitalinnovation.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class CondicionaisTest {
	
	@Test
	//@EnabledIfEnvironmentVariable(named = "USER", matches = "ronca")
	//@DisabledIfEnvironmentVariable(named = "USER", matches = "root")
	//@EnabledOnOs(OS.WINDOWS)
	@EnabledOnOs({OS.WINDOWS, OS.LINUX, OS.MAC})
	void validarAlgoSomenteEmUmUsuario() {
		Assertions.assertEquals(10, 5 + 5);
	}

}

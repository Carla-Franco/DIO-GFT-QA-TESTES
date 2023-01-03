package me.dio.mockito.exemplos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListaTeste {
	
	@Mock
	private List<String> letras;

	@Test
	void adicionarItemLista() {
		Mockito.when(letras.get(0)).thenReturn("B");
		
		assertEquals("B", letras.get(0));
		
	}

}

package me.dio.mockito.exemplos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GeradorNumeroTeste {

	@Test
	void testaGeracaoComTamanhoDefinido() {
		
		MockedStatic<GeradorNumero> mockedStatic = Mockito.mockStatic(GeradorNumero.class); 	
	
		List<Integer> integers = List.of(15, 13, 6, 27, 18);

        mockedStatic.when(() -> GeradorNumero.geraNumerosAleatorios(anyInt()))
                .thenReturn(integers);

        assertEquals(integers, GeradorNumero.geraNumerosAleatorios(5));
	}
	
	@Test
    void validaGeracaoListaDeNumeros() {
        MockedStatic<GeradorNumero> mockedStatic = Mockito.mockStatic(GeradorNumero.class);

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        mockedStatic.when(() -> GeradorNumero.geraNumerosAleatorios(anyInt()))
                .thenReturn(integers);

        assertEquals(integers, GeradorNumero.geraNumerosAleatorios(8));
    }

    @Test
    void validaGeracaoListaDeNumerosSemInformarTamanho() {

        MockedStatic<GeradorNumero> mockedStatic = Mockito.mockStatic(GeradorNumero.class);

        List<Integer> integers = List.of(10, 9, 8, 6);

        mockedStatic.when(GeradorNumero::geraNumerosAleatorios).thenReturn(integers);

        assertEquals(integers, GeradorNumero.geraNumerosAleatorios());
    }

}

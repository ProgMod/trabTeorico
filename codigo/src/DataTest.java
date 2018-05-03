import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DataTest {

	@Test
	public void testConstrutorData() throws ExcecaoDataInvalida {
		Data d = new Data(2018, 02, 24);
		assertEquals(2018, d.getAno());
		assertEquals(02, d.getMes());
		assertEquals(24, d.getDia());
	}
	
	@Test
	public void testDataDeHoje() {
		Data d = new Data();
		assertEquals(2018, d.getAno());
		assertEquals(03, d.getMes());
		assertEquals(07, d.getDia());
	}
	
	@Test
	public void testAdicionaDias_mesmoMes() throws ExcecaoDataInvalida {
		Data d = new Data(2018, 02, 24);
		d.adicionaDias(4);
		assertEquals(2018, d.getAno());
		assertEquals(02, d.getMes());
		assertEquals(28, d.getDia());
	}
	
	@Test
	public void testAdicionaDias_avancaMes() throws ExcecaoDataInvalida {
		Data d = new Data(2018, 02, 24);
		d.adicionaDias(10);
		assertEquals(2018, d.getAno());
		assertEquals(03, d.getMes());
		assertEquals(06, d.getDia());
	}
	
	@Test
	public void testAdicionaDias_avancaAno() throws ExcecaoDataInvalida {
		Data d = new Data(2018, 12, 21);
		d.adicionaDias(15);
		assertEquals(2019, d.getAno());
		assertEquals(01, d.getMes());
		assertEquals(05, d.getDia());
	}
	
	@Test
	public void testDiasNoMes() throws ExcecaoDataInvalida {
		Data d = new Data(2018, 02, 24);
		assertEquals(28, d.diasNoMes());
	}
	
	@Test
	public void testDiaDaSemana() throws ExcecaoDataInvalida {
		Data d = new Data(2018, 02, 23);
		assertEquals("Sexta-Feira", d.diaDaSemana());
	}
	
	@Test 
	public void testAnoBisexto() throws ExcecaoDataInvalida {
		Data d = new Data(2018, 02, 23);
		assertEquals(false, d.eAnoBisexto());
		Data d2 = new Data(2016, 02, 23);
		assertEquals(true, d2.eAnoBisexto());		
	}
	
	@Test
	public void testProximoDia() throws ExcecaoDataInvalida {
		Data d = new Data(2018, 04, 21);
		d.proximoDia();;
		assertEquals(2018, d.getAno());
		assertEquals(04, d.getMes());
		assertEquals(22, d.getDia());
	}
	
	@Test
	public void testPorExtenso() throws ExcecaoDataInvalida {
		Data d = new Data(2018, 03, 01);
		assertEquals("1 de Março de 2018",d.porExtenso());
	}

}

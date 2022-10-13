package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rrhh.Empleado;
import rrhh.Empleado.TipoEmpleado;

class EmpleadoTest {
	
	private TipoEmpleado tipo;
	private int ventasMes;
	private int horasExtra;
	private int nominaBruta;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		tipo = TipoEmpleado.Vendedor;
		ventasMes = 900;
		horasExtra = 0;
		nominaBruta = 2000;
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculoNominaBrutaEncargado() {
		tipo = TipoEmpleado.Encargado;
		float expected = 2500;
		float actual = Empleado.calculoNominaBruta(tipo, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBrutaVendedor() {
		float expected = 2000;
		float actual = Empleado.calculoNominaBruta(tipo, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBrutaVentasMenor1000() {
		float expected = 2000;
		float actual = Empleado.calculoNominaBruta(tipo, ventasMes, horasExtra);
		assertEquals(expected, actual);		
	}

	@Test
	void testCalculoNominaBrutaVentasMenor1500() {
		ventasMes = 1200;
		float expected = 2100;
		float actual = Empleado.calculoNominaBruta(tipo, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBrutaVentasMayor1500() {
		ventasMes = 1600;
		float expected = 2200;
		float actual = Empleado.calculoNominaBruta(tipo, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBrutaHorasExtra0() {
		float expected = 2000;
		float actual = Empleado.calculoNominaBruta(tipo, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBrutaHorasExtraMasDe0() {
		horasExtra = 20;
		float expected = 2600;
		float actual = Empleado.calculoNominaBruta(tipo, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaNeta1() {
		float expected = 2000;
		float actual = Empleado.calculoNominaNeta(nominaBruta);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNeta2() {
		nominaBruta = 2200;
		float expected = 1870;
		float actual = Empleado.calculoNominaNeta(nominaBruta);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNeta3() {
		nominaBruta = 2600;
		float expected = 2132;
		float actual = Empleado.calculoNominaNeta(nominaBruta);
		assertEquals(expected, actual);
	}

}

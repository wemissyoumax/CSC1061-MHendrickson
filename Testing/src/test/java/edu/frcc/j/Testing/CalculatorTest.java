package edu.frcc.j.Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CalculatorTest {
	
	Calculator calc;
	
	@BeforeEach
	void setup() {
		calc = new Calculator();
	}
	
	@Test
	@DisplayName("Simple addition")
	void testAdd() {
		assertEquals(10, calc.add(8, 2), "Addition didn't work.");
	}
	
	@Test
	@DisplayName("Simple multiplication")
	void testMult() {
		assertEquals(20, calc.multiply(5, 4), "Multiplication didn't work.");
		assertTrue(calc.multiply(3, 6) == 18, "Answer should be 18");
	}
	
	@Test
	@DisplayName("Simple division")
	@Disabled("Not ready for primetime")
	void testDivide() {
		assertEquals(3.0, calc.divide(6, 2), "Division no worky");
		
	}
	
	@Test
	void testDivideException() {
		ArithmeticException exception = 
				assertThrows(ArithmeticException.class, ()-> calc.divide(1, 0));
		assertEquals("Divide by 0", exception.getMessage());
	}
}

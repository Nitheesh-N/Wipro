package com.example.calc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculationTest {
	Calculation c = new Calculation();
	@Test
	void add_Test() {
		Assertions.assertEquals(9, c.add(3, 6));
	}
	@Test
	void sub_Test() {
		Assertions.assertEquals(3, c.sub(6, 3));
	}
	@Test
	void multiply_Test() {
		Assertions.assertEquals(18, c.multiply(3, 6));
	}

}

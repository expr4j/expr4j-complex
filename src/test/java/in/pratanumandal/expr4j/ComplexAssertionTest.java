/**
 * Copyright 2023 Pratanu Mandal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package in.pratanumandal.expr4j;

import in.pratanumandal.expr4j.expression.Expression;
import in.pratanumandal.expr4j.expression.ExpressionDictionary;
import in.pratanumandal.expr4j.impl.ComplexExpressionBuilder;
import in.pratanumandal.expr4j.token.Function;
import org.apache.commons.numbers.complex.Complex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ComplexAssertionTest {

	public static double DELTA = 0.00000000001;

	protected ComplexExpressionBuilder builder = new ComplexExpressionBuilder();

    protected ExpressionDictionary<Complex> expressionDictionary = builder.getExpressionDictionary();

	private void assertEquals(Complex expected, Complex actual) {
		Assertions.assertEquals(expected.getReal(), actual.getReal(), DELTA);
		Assertions.assertEquals(expected.getImaginary(), actual.getImaginary(), DELTA);
	}

	@Test
	public void test1() {
		Complex expected = Complex.ofCartesian(4.991100213217296, 0.003116608330456);
		String expectedString = "5 + (3 + 2i) / cos(sin(-6 + 4i)) ^ (0.25 - 0.32i)";

		Expression<Complex> expression = builder.build("5 + ((3 + 2i) / (cos(sin(-6 + 4i)) ^ (0.25 - 0.32i)))");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test2() {
		Complex expected = Complex.ofCartesian(4.991100213217296, 0.003116608330456);
		String expectedString = "5 + (3 + 2i) / cos(sin(-6 + 4 * i)) ^ (0.25 - 0.32 * i)";

		Expression<Complex> expression = builder.build("(5 + (((3 + (2i)) / (cos(sin(-(6) + 4(i))) ^ (0.25 - (0.32)i)))))");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test3() {
		Complex expected = Complex.ofCartesian(0.553615731145235, 0.270713553850944);
		String expectedString = "log(ln(2 + 3i) * (4 + 6i), 2.5i)";

		Expression<Complex> expression = builder.build("log(ln(2 + 3i) * (4 + 6i), 2.5i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test4() {
		Complex expected = Complex.ofCartesian(0.553615731145235, 0.270713553850944);
		String expectedString = "log(ln(2 + 3i) * (4 + 6i), 2.5i)";

		Expression<Complex> expression = builder.build("log(ln(2 + 3i) * (4 + 6i), 2.5i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test5() {
		Complex expected = Complex.ofCartesian(0.553615731145235, 0.270713553850944);
		String expectedString = "log(ln(2 + 3i) * (4 + 6i), 2.5i)";

		Expression<Complex> expression = builder.build("log(ln(2 + 3i) * (4 + 6i), 2.5i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test6() {
		Complex expected = Complex.ofCartesian(4.056437873240632, -2.940791310941815);
		String expectedString = "log(3 + 2i, max((5 - 7i) ^ (4 - 2i), 4 ^ (5 - i)))";

		Expression<Complex> expression = builder.build("log((3 + 2i), max((5 - 7i) ^ (4 - 2i), 4 ^ (5 - i)))");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test7() {
		Complex expected = Complex.ofCartesian(1.456060757276004, 0.554733341971647);
		String expectedString = "log(3 + i, min(5 + 3i, 2 + 4i))";

		Expression<Complex> expression = builder.build("log(3 + i, min(5 + 3i, 2 + 4i))");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test8() {
		Complex expected = Complex.ofCartesian(1.456060757276004, 0.554733341971647);
		String expectedString = "log(3 + i, max(log10(i - 10), 2 + 4i))";

		Expression<Complex> expression = builder.build("log((3) + (i), max((log10 (((i) - (10)))), (2 + 4 i)))");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test9() {
		Complex expected = Complex.ofCartesian(7.810249675906654, 0);
		String expectedString = "abs(5 + 6i)";

		Expression<Complex> expression = builder.build("abs(5 + 6i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test10() {
		Complex expected = Complex.ofCartesian(5.331351941759147, 0);
		String expectedString = "abs(log(max(ln 10, 4), 5 + 2 * 4) + 5i)";

		Expression<Complex> expression = builder.build("abs(log(max(ln(10), 4), 5 + (2) * 4) + 5i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test11() {
		Complex expected = Complex.ofCartesian(-3.0, 0);
		String expectedString = "2 + (3 - 4) * 5";

		Expression<Complex> expression = builder.build("2 + (3 - 4) * 5");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test12() {
		Complex expected = Complex.ofCartesian(3.0, 0);
		String expectedString = "abs(2 + (3 - 4) * 5)";

		Expression<Complex> expression = builder.build("abs(2 + ((3 - 4) * 5))");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test13() {
		expressionDictionary.addFunction(new Function<>("avg", (parameters) ->
				parameters.stream().map(e -> e.value())
						.collect(Collectors.reducing(Complex.ofCartesian(0, 0), Complex::add))
						.divide(parameters.size())));

		Complex expected = Complex.ofCartesian(11.64958140672138, -3.666666666666666);
		String expectedString = "avg(e + i, (5 - 2i) * 6 + pi, cos 9)";

		Expression<Complex> expression = builder.build("avg(e + i, (5 - 2i) * 6 + pi, cos 9)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);

		expressionDictionary.removeFunction("avg");
	}

	@Test
	public void test14() {
		expressionDictionary.addFunction(new Function<>("ee", (parameters) ->
				parameters.stream().map(e -> e.value())
						.collect(Collectors.reducing(Complex.ofCartesian(0, 0), Complex::add))
						.divide(parameters.size())));

		Complex expected = Complex.ofCartesian(11.64958140672138, -3.666666666666666);
		String expectedString = "ee(e + i, (5 - 2i) * 6 + pi, cos 9)";

		Expression<Complex> expression = builder.build("ee(e + i, (5 - 2i) * 6 + pi, cos 9)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);

		expressionDictionary.removeFunction("ee");
	}

	@Test
	public void test15() {
		expressionDictionary.addFunction(new Function<>("uminusFunc", (parameters) ->
				parameters.stream().map(e -> e.value())
						.collect(Collectors.reducing(Complex.ofCartesian(0, 0), Complex::add))
						.divide(parameters.size())));

		Complex expected = Complex.ofCartesian(11.64958140672138, -3.666666666666666);
		String expectedString = "uminusFunc(e + i, (5 - 2i) * 6 + pi, cos 9)";

		Expression<Complex> expression = builder.build("uminusFunc(e + i, (5 - 2i) * 6 + pi, cos 9)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);

		expressionDictionary.removeFunction("uminusFunc");
	}

	@Test
	public void test16() {
		expressionDictionary.addFunction(new Function<>("Funcuplus", (parameters) ->
				parameters.stream().map(e -> e.value())
						.collect(Collectors.reducing(Complex.ofCartesian(0, 0), Complex::add))
						.divide(parameters.size())));

		Complex expected = Complex.ofCartesian(11.64958140672138, -3.666666666666666);
		String expectedString = "Funcuplus(e + i, (5 - 2i) * 6 + pi, cos 9)";

		Expression<Complex> expression = builder.build("Funcuplus(e + i, (5 - 2i) * 6 + pi, cos 9)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);

		expressionDictionary.removeFunction("Funcuplus");
	}

	@Test
	public void test17() {
		Complex expected = Complex.ofCartesian(5.65035, 4.06653);
		String expectedString = "(4.02 + 2.001i) * (1.53 + 0.25i)";

		Expression<Complex> expression = builder.build("(4.02 + 2.001i)(1.53 + 0.25i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test18() {
		Complex expected = Complex.ofCartesian(5.65035, 4.06653);
		String expectedString = "(4.02 + 2.001i) * (1.53 + 0.25i)";

		Expression<Complex> expression = builder.build("(4.02 + 2.001i)((1.53 + 0.25i))");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test19() {
		Complex expected = Complex.ofCartesian(27.0, 38.5);
		String expectedString = "(5 + 6i) * max(1 - 2i, 2.1 + 0.8i, 0.5i + 6)";

		Expression<Complex> expression = builder.build("(5 + 6i) max((1 - 2i), (2.1 + 0.8i), (0.5i + 6))");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test20() {
		Map<String, Complex> variables = new HashMap<>();
		variables.put("x", Complex.ofCartesian(5, 2));

		Complex expected = Complex.ofCartesian(25, 10);
		String expectedString = "5 * x";

		Expression<Complex> expression = builder.build("5x");

		Complex actual = expression.evaluate(variables);
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test21() {
		Map<String, Complex> variables = new HashMap<>();
		variables.put("x5", Complex.ofCartesian(5, 2));

		Complex expected = Complex.ofCartesian(5, 2);
		String expectedString = "x5";

		Expression<Complex> expression = builder.build("x5");

		Complex actual = expression.evaluate(variables);
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test22() {
		Complex expected = Complex.ofCartesian(5, 12);
		String expectedString = "+5 + 6 * i * 2";

		Expression<Complex> expression = builder.build("+ 5 + 6 * i 2");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test23() {
		Complex expected = Complex.ofCartesian(-0.207228681605212, 0.977115593111102);
		String expectedString = "(0.8 + i) ^ ((1.4 - 0.5i) ^ (0.6 + 1.2i))";

		Expression<Complex> expression = builder.build("(0.8 + i) ^ ((1.4 - 0.5i) ^ (0.6 + 1.2i))");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test24() {
		Complex expected = Complex.ofCartesian(0.783967730086554, -0.060457852801796);
		String expectedString = "sin(cos(0.5 + 0.2i))";

		Expression<Complex> expression = builder.build("sin cos (0.5 + 0.2i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test25() {
		Complex expected = Complex.ofCartesian(1.983967730086554, -0.780457852801796);
		String expectedString = "sin(cos(0.5 + 0.2i)) + 1.2 - 0.72i";

		Expression<Complex> expression = builder.build("sin cos (0.5 + 0.2i) + (1.2 - 0.72i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test26() {
		Complex expected = Complex.ofCartesian(9.654125476854839, 2.841692295606351);
		String expectedString = "-sin(5 - 3i)";

		Expression<Complex> expression = builder.build("- sin (5 - 3i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test27() {
		Complex expected = Complex.ofCartesian(45.772495734557147, -20.844534799832821);
		String expectedString = "5 * sin(2 + 3i)";

		Expression<Complex> expression = builder.build("5 sin (2 + 3i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test28() {
		Complex expected = Complex.ofCartesian(-0.440788936509231, -0.6591404347821917);
		String expectedString = "(0.2 - 0.4i) ^ (0.5 + 0.3i) - (0.8 - 0.1i) ^ (-0.3 + 0.2i)";

		Expression<Complex> expression = builder.build("(0.2 - 0.4i) ^ (0.5 + 0.3i) - (0.8 - 0.1i) ^ (-0.3 + 0.2i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test29() {
		Complex expected = Complex.ofCartesian(-30, -1);
		String expectedString = "-5 * 6 - i";

		Expression<Complex> expression = builder.build("-5 6 - i");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test30() {
		Complex expected = Complex.ofCartesian(-30, -1);
		String expectedString = "-(5 * 6 + i)";

		Expression<Complex> expression = builder.build("-(5 6 + i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test31() {
		Complex expected = Complex.ofCartesian(1.968637925793096, 0.964658504407602);
		String expectedString = "asinh(2 + 3i)";

		Expression<Complex> expression = builder.build("asinh(2 + 3i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test32() {
		Complex expected = Complex.ofCartesian(1.983387029916535, 1.000143542473797);
		String expectedString = "acosh(2 + 3i)";

		Expression<Complex> expression = builder.build("acosh(2 + 3i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test33() {
		Complex expected = Complex.ofCartesian(0.146946666225529, 1.338972522294493);
		String expectedString = "atanh(2 + 3i)";

		Expression<Complex> expression = builder.build("atanh(2 + 3i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test34() {
		Complex expected = Complex.ofCartesian(2, 2);
		String expectedString = "average(1 + i, 2 + 3i, 3 + 2i)";

		Expression<Complex> expression = builder.build("average(1 + i, 2 + 3i, 3 + 2i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test35() {
		Complex expected = Complex.ofCartesian(1.77076747665, 0.32248154192);
		String expectedString = "cbrt(5 + 3i)";

		Expression<Complex> expression = builder.build("cbrt(5 + 3i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test36() {
		Complex expected = Complex.ofCartesian(286.47889756541, 171.88733853924);
		String expectedString = "deg(5 + 3i)";

		Expression<Complex> expression = builder.build("deg(5 + 3i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test37() {
		Complex expected = Complex.ofCartesian(0.08726646259, 0.05235987755);
		String expectedString = "rad(5 + 3i)";

		Expression<Complex> expression = builder.build("rad(5 + 3i)");

		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);
	}

	@Test
	public void test38() {
		expressionDictionary.addConstant("TestConst", Complex.ofCartesian(0.5, 0.4));

		Complex expected = Complex.ofCartesian(0.5, 0.4);
		String expectedString = "TestConst";

		Expression<Complex> expression = builder.build("TestConst");

		Complex fetched = expressionDictionary.getConstant("TestConst");
		Complex actual = expression.evaluate();
		String actualString = expression.toString();

		this.assertEquals(expected, fetched);
		this.assertEquals(expected, actual);
		Assertions.assertEquals(expectedString, actualString);

		expressionDictionary.removeConstant("TestConst");
	}

}

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

import in.pratanumandal.expr4j.exception.Expr4jException;
import in.pratanumandal.expr4j.expression.Expression;
import in.pratanumandal.expr4j.impl.ComplexExpressionBuilder;
import org.apache.commons.numbers.complex.Complex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComplexExceptionTest {
	
	protected ComplexExpressionBuilder builder = new ComplexExpressionBuilder();
	
	@Test
	public void test1() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("");
			expression.evaluate();
		});
	}
	
	@Test
	public void test2() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("()");
			expression.evaluate();
		});
	}
	
	@Test
	public void test3() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("5 +() 6");
			expression.evaluate();
		});
	}
	
	@Test
	public void test4() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("5() + 6");
			expression.evaluate();
		});
	}
	
	@Test
	public void test5() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("5 (+) 6");
			expression.evaluate();
		});
	}
	
	@Test
	public void test6() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("5 (+) 6");
			expression.evaluate();
		});
	}
	
	@Test
	public void test7() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("5 6 +");
			expression.evaluate();
		});
	}
	
	@Test
	public void test8() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("5 x +");
			expression.evaluate();
		});
	}
	
	@Test
	public void test9() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("+ 5 x");
			expression.evaluate();
		});
	}
	
	@Test
	public void test10() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("5 + x");
			expression.evaluate();
		});
	}
	
	@Test
	public void test11() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("6 sin 5 *");
			expression.evaluate();
		});
	}
	
	@Test
	public void test12() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("6 + * 5");
			expression.evaluate();
		});
	}
	
	@Test
	public void test13() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("5 max(6 *)");
			expression.evaluate();
		});
	}
	
	@Test
	public void test14() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("5 deg max(5) +");
			expression.evaluate();
		});
	}
	
	@Test
	public void test15() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("(5 *) max(5) +");
			expression.evaluate();
		});
	}
	
	@Test
	public void test16() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("(5,5)");
			expression.evaluate();
		});
	}
	
	@Test
	public void test17() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("(2 + (3)");
			expression.evaluate();
		});
	}
	
	@Test
	public void test18() {
		Assertions.assertThrows(Expr4jException.class, () -> {
			Expression<Complex> expression = builder.build("(2 + 3))");
			expression.evaluate();
		});
	}

}

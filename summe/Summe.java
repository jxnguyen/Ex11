
class Summe {

	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		double result = sum(n);
		System.out.println("Sum(" + n + ") = " + result);
		double limit = Math.pow(Math.PI,2)/6;
		System.out.format("Diff from limit: %.11f", (limit - result));
		// double result2 = sum2(n);
		// System.out.println("Sum2: " + result2);
		// System.out.println(result == result2);

	}

	static int multi(int n) {
		for (int i = 1; i <= n; i++) {
			if (i*i == 0) {
				return i;
			}
		}
		return 1;
	}

	static double sum(int n) {
		double s = 0.0;
		float one = 1;
		for (int i = 1; i <= n; i++) {
			s += 1.0/i/i;
		}
		return s;
	}

	static double sum2(int n) {
		double s = 0.0;
		float one = 1;
		for (int i = 1; i <= n; i++) {
			s += 1.0/i/i;
		}
		return s;
	}

}

/*
1) Result is always 1.0 regardless of n. The expression 1/i*i contains only ints, meaning 1/i is integer division. -> When n is 1, then 1/i is 1, which is multiplied by 1. For any n larger than 1 is 1/i = 0. -> s is always 1. The int result is auto type casted to a double.

2) This is the same as 1), except the multiplication is computed before the division. But otherwise it is the same, when n = 1 then s = 1, otherwise the result is 0. For n = 10^6, 10^8, 10^9 there is a divide by zero error, because when i = 2^16 = 65536, i*i = 2^32 = 0, since 2^32 mod 2^32 = 0.

3) Since the first operand of the expression is a double, the other operands (ints) get converted to a double before the expression is evaluated, resulting in a double. The expression is evaluated left to right.

4) the expression in the parenthesis is evaluated first, then the division. However for n = 10^6, 10^8, 10^9 the result is incorrect (infinity) because like in 2) when i = 2^16, i*i = 0. however 1.0/0 does not produce a division error, rather infinity, since it is not integer division.

5) produces the exact same results as 3). Here the first operand from i*i is casted into a double, and so the other i is automatically converted to a double to and the result is a double. Important to note, unlike in 2), since the result is a double it does not calculated with 2^32 modulo, meaning it does not evaluate to 0, and hence no div error or infinity.

6) caculates correctly for n = 100, 10000, but for the other n's its results in Inifinty, which is what happens when a double is divided by 0 or 0.0. Here when i = 2^16 the expression i*i is equal to 0, then converted to a double, causing the Inifinity.

7) Calculates for all values of n, however with a lower precision than the other ones, since the first operand of the division (eins) is of type float and a float uses only 32 bits whereas a double uses 64, thus resulting a more precise calculation.

8) Calculates all values of n and is exactly the same as 3), 5). Here (1.0*i*i) gets evaluated first, from left to right. the first i is converted to a double, to match 1.0. The result is a double, so then the next i is converted to a double, resulting in a double value after being multiplied. Since its a double, we avoid the 2^32 modulo error. Next we divide 1 with our result, meaning the 1 will be casted to a double, then the division will be evaluated.

*/

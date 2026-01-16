package h2;

public class H2_main {
	private static long[] cache = new long[100];

	public static void main(String[] args) {
		benchmark(3);
		benchmark(3);
	}

	public static long fibonacchi(int n) {
		if (n == 1 || n == 2)
			return 1;
		return fibonacchi(n - 2) + fibonacchi(n - 1);
	}

	public static long fibonacciCached(int n) {
		if (n == 1 || n == 2)
			return 1;
		if (cache[n] != 0) {
			return cache[n];
		} else {
			cache[n] = fibonacciCached(n - 1) + fibonacciCached(n - 2);
			return cache[n];
		}
	}

	public static long fibonacciIter(int n) {
		if (n == 1 || n == 2)
			return 1;
		long f1 = 1;
		long f2 = 1;
		long sum = 0;
		for (int i = 2; i < n; i++) {
			sum = f1 + f2;
			f1 = f2;
			f2 = sum;
		}
		return sum;
	}

	public static void benchmark(int n) {
		long start;
		long end;
		start = System.nanoTime();
		System.out.print("Ergebnis: " + fibonacchi(n));
		end = System.nanoTime();
		System.out.println(" , Elapsed nanoseconds (fibonacchi): " + (end - start));

		start = System.nanoTime();
		System.out.print("Ergebnis: " + fibonacciCached(n));
		end = System.nanoTime();
		System.out.println(" , Elapsed nanoseconds (fibonacchiCached): " + (end - start));

		start = System.nanoTime();
		System.out.print("Ergebnis: " + fibonacciIter(n));
		end = System.nanoTime();
		System.out.println(" , Elapsed nanoseconds (fibonacciIter): " + (end - start));
	}
}

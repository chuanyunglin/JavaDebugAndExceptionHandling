
public class PrintLog {

	private static int sum(int a, int b) {
		return a + b;
	}
	
	private static int sub(int a, int b) {
		return b - a;
	}
	
	public static void main(String[] args) {
		int a = 10;
		int b = 30;
		
		// a + b
		int sum = sum(a, b);
		System.out.println(a + " + " + b + " = " + sum);
	
		// a - b
		int sub = sub(a, b);
		System.out.println(a + " - " + b + " = " + sub);
	}
}
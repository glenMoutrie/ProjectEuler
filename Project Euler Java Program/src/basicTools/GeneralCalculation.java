package basicTools;

public class GeneralCalculation {
	public static double gcm(double a, double b) {
		return b == 0 ? a : gcm(b, a % b);
	}
	
	
	public static int gcm(int a, int b) {
		return b == 0 ? a : gcm(b, a % b);
	}
	
	public static void main(String[] args) {
		System.out.println(gcm(25, 5));
	}
}

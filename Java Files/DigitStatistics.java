package solutions;
import java.math.BigInteger;


public class DigitStatistics {
	public static void main(String[] args){
		BigInteger a = new BigInteger("2");
		BigInteger currentPower;
		char[] power;
		long zero = 0;
		long one = 0;
		long two = 0;
		long three = 0;
		long four = 0;
		long five = 0;
		long six = 0;
		long seven = 0;
		long eight = 0;
		long nine = 0;

		char[] comparison = "0123456789".toCharArray();
		
		for(int i = 1; i <= 1000000000; i++){
			currentPower = a.pow(i);
			power = currentPower.toString().toCharArray();

			for(int j = 0; j < power.length; j++){
				if(power[j] == comparison[0]){
					zero++;
				} else if (power[j] == comparison[1]) {
					one++;
				} else if (power[j] == comparison[2]) {
					two++;
				} else if (power[j] == comparison[3]) {
					three++;
				} else if (power[j] == comparison[4]) {
					four++;
				} else if (power[j] == comparison[5]) {
					five++;
				} else if (power[j] == comparison[6]) {
					six++;
				} else if (power[j] == comparison[7]) {
					seven++;
				} else if (power[j] == comparison[8]) {
					eight++;
				} else if (power[j] == comparison[9]) {
					nine++;
				} 
			}
		}
		
		System.out.println("0: " + zero +
				", 1:" + one +
				", 2:" + two +
				", 3:" + three +
				", 4:" + four + 
				", 5:" + five + 
				", 6:" + six + 
				", 7:" + seven + 
				", 8:" + eight + 
				", 9:" + nine);
	}
}

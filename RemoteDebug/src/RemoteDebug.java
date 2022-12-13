import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RemoteDebug {

	public static void main(String[] args) {
		Runnable r = () -> {
			int count = 0;
			boolean keep = true;
			while (keep) {
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
					keep = false;
				}
				System.out.println("count = " + (++count));
			}
			System.out.println("end runnable....");
		};
		
		Thread printCount = new Thread(r, "printCount");
		printCount.start();
		
		System.out.println("Enter any words, q to quit");
		try (Scanner scanner = new Scanner(System.in, "UTF-8")) {
			String input;
			do {
				input = scanner.nextLine();
				System.out.println(String.format("You enter: %s", input));
			} while (!input.equalsIgnoreCase("q"));
		}
		
		printCount.interrupt();
	}
}

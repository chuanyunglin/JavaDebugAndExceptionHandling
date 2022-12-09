import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.SocketHandler;

public class LogClient {
	private static final int PORT_NUM = 8100;
	private static Logger logger = Logger.getAnonymousLogger();

	public static void main(String argv[]) throws IOException {
		try {
			Handler handler = new SocketHandler("localhost", PORT_NUM);
			// handler.setFormatter(new SimpleFormatter());
			handler.setEncoding("UTF-8");
			logger.addHandler(handler);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Enter Q/q to exit...");

		// 使用 Scanner 輸入模擬 log 數據來源
		try (
		Scanner scanner = new Scanner(System.in, "UTF-8")) {
			String input;
			do {
				input = scanner.nextLine();
				System.out.println(String.format("You enter: %s", input));
				logger.info(input);
			} while (!input.equalsIgnoreCase("q"));
		}
		System.out.println("End...");
	}
}
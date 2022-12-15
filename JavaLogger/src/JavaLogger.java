import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 使用 Logger 打印 foo 方法花了多少時間
 * @author ChuanyungLin
 *
 */
public class JavaLogger {
	private static Logger logger = Logger.getLogger(JavaLogger.class.getName());
	
	public static void foo() {
		long time = System.currentTimeMillis();
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long costTime = System.currentTimeMillis() - time;
		logger.log(Level.INFO, "Foo costime = " + TimeUnit.SECONDS.convert(costTime, TimeUnit.MILLISECONDS) + " second(s)");
	}

	public static void main(String[] args) {
		foo();
	}

}
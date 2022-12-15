import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class OutOfMemory {

	private static class MyObject {
		private static final int MB = 1024 * 1024;
		private String[] strings;
		private int index;
		
		public MyObject(int index) {
			this.index = index;
			strings = new String[this.index * MB];
		}
	}
	
	public static void main(String[] args) {
		ArrayList<MyObject> list = new ArrayList<MyObject>();
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			System.out.println(i);
			list.add(new MyObject(i));
//			try {
//				TimeUnit.SECONDS.sleep(5);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

}

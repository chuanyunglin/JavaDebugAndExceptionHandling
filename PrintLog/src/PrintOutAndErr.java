
public class PrintOutAndErr {

	public static void main(String[] args) {
		// 實驗 System.out 及 System.err 打印的順序， 可以多跑幾次看看結果
		System.out.println("1");
		System.out.println("2"); // 改為使用 System.err 試試
		System.out.println("3");
		System.out.println("4"); // 改為使用 System.err 試試
		System.out.println("5");
		System.out.println("6");
	}

}

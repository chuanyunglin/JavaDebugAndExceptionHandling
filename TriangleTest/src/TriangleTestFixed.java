import java.util.ArrayList;

public class TriangleTestFixed {
	
	private static class Triangle {
		int sideA;
		int sideB;
		int sideC;
		
		public Triangle(int a, int b, int c) {
			sideA = a;
			sideB = b;
			// sideC = b;
			sideC = c;
		}
		
		public boolean isLegal() {
			/*
			if ((sideA + sideB > sideC) || (sideA + sideC > sideB)) {
				return true;
			} else {
				return false;
			}
			*/
			return (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA)
					&& (sideA > 0) && (sideB > 0) && (sideC > 0);
		}
		
		public boolean isRightAngle() {
			int max = Math.max(sideA, Math.max(sideB, sideC));
			// int min = Math.min(sideA, Math.max(sideB, sideC));
			int min = Math.min(sideA, Math.min(sideB, sideC));
			int median = sideA + sideB + sideC - max - min;
			// return max * max == min * min + median + median;
			return max * max == min * min + median * median;
		}
		
		public void show() {
			System.out.printf("(%d, %d, %d) is " + (isLegal() ? "legal\t" : "not legal\t"), sideA, sideB, sideC);
			// System.out.println(isLegal() ? "right" : "not right");
			System.out.println(isLegal() ? (isRightAngle() ? "right" : "not right") : "");
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Triangle> list = new ArrayList<Triangle>();
		list.add(new Triangle(6, 4, -1));
		list.add(new Triangle(1, 2, 3));
		list.add(new Triangle(4, 5, 6));
		list.add(new Triangle(3, 5, 4));
		list.add(new Triangle(12, 13, 5));
		list.add(new Triangle(7, 3, 8));

		for (Triangle tr : list) {
			tr.show();
		}
	}
}

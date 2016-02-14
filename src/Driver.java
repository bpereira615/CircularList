public class Driver {

	public static void main(String[] args) {
		CList<Integer> list = new CList<Integer>();

		for(int i = 0; i < 20; i++) {
			list.insert(i);
		}

		System.out.println(list);
	}
}
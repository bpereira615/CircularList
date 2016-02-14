public class Driver {

	public static void main(String[] args) {
		CList<Integer> list = new CList<Integer>();

		//System.out.println(list);	//empty list check

		//Remove
		list.insert(1);
		list.insert(2);
		System.out.println(list);
		list.insert(3);
		list.insert(4);
		System.out.println(list);
		list.moveToStart();
		list.remove();
		System.out.println(list);
		//System.out.println(list.getValue());
		list.remove();
		System.out.println(list);



/*	
		//Insert
		for(int i = 0; i < 20; i++) {
			list.insert(i);
		}
		System.out.println(list);
		
		list.clear();
		System.out.println(list);

		//Append
		for(int i = 0; i < 20; i++) {
			list.append(i);
			System.out.println(list.getSize() + "\t" + list);
		}
*/		
 
	}
}
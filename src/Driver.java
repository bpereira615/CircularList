public class Driver {

	public static void main(String[] args) {
		CList<Integer> list = new CList<Integer>();









		list.insert(1);
		System.out.println(list);
		list.moveToStart();		
		list.insert(2);
		System.out.println(list);
		list.moveToStart();
		System.out.println(list.getValue());

		
		list.insert(3);
		System.out.println(list);
		
		list.moveToStart();
		list.insert(4);
		System.out.println(list);
		list.moveToStart();
		list.insert(5);
		System.out.println(list);
		
		//list.moveToPos(2);
		
		
		//System.out.println(list.getValue());
		//list.insert(5);
		//System.out.println(list);
		//System.out.println(list.getValue());



		



/*	
		//Piazza example
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		System.out.println(list);
		list.moveToPos(2);
		System.out.println(list.getValue());
		list.remove();
		System.out.println(list);
		System.out.println(list.getValue());

		//insert(), length(), clear(), currentPos()
		for(int i = 0; i < 20; i++) {
			list.insert(i);
			System.out.println(list.length() + " " + list.currPos());
		}
		System.out.println(list);

	

		//next(), prev(), moveToEnd(), moveToStart(), isAtEnd()
		list.moveToStart();
		while(!list.isAtEnd()){
			System.out.print(list.getValue() + " ");
			list.next();
		}
		System.out.print(list.getValue() + "\n");

		list.prev();
		System.out.print(list.getValue() + " ");
		list.prev();
		System.out.print(list.getValue() + " ");
		list.prev();
		System.out.print(list.getValue() + " ");
		list.prev();
		System.out.print(list.getValue() + " \n");

		list.moveToEnd();
		System.out.print(list.getValue() + " ");
		list.next();
		System.out.print(list.getValue() + " ");

		list.moveToStart();
		list.prev();
		System.out.print(list.getValue() + " " + list.currPos());


		list.clear();
		System.out.println(list);


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
		list.remove();
		System.out.println(list);



		//Append
		for(int i = 0; i < 20; i++) {
			list.append(i);
			System.out.println(list.length() + "\t" + list);
		}
*/		
 
	}
}
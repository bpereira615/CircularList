public class Test {

	public static void main(String[] args) {
		CList<CookingStation> stations = new CList<CookingStation>();

		CookingStation g = new CookingStation("grill");
		//CookingItem i = new CookingItem("food", 1, 1, 1);
		

		g.addItem(new CookingItem("burger", 1, 1, 1));
		g.addItem(new CookingItem("hot dog", 2, 1, 1));

		CookingStation o = new CookingStation("oven");

		o.addItem(new CookingItem("ham", 10, 1, 1));



		System.out.println(g + " " + o);
		stations.insert(g);
		stations.insert(o);
		System.out.println(stations);

		//stations.insert();


		/*
		n.addItem(i);
		n.addItem(i);

		System.out.println(i);
		System.out.println(n);
		stations.insert(n);
		stations.insert(n);
		System.out.println(stations.length());
		System.out.println(stations);
		*/




		


		





		




		



/*	
//Piazza example
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);
		System.out.println(list);
		list.moveToPos(2);
		System.out.println(list.getValue());
		list.insert(5);
		System.out.println(list);
		list.append(6);
		System.out.println(list);
		list.insert(6);
		System.out.println(list);
		list.clear();
		list.prev();
		list.next();
		list.moveToStart();
		list.moveToEnd();
		System.out.println(list);



		//insert(), length(), clear(), currentPos()
		for(int i = 0; i < 20; i++) {
			list.insert(i);
			System.out.println(list.length() + " " + list.currPos());
		}
		System.out.println(list);

	//insert(), head node case
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
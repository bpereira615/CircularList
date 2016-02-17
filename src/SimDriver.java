import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
// import java.util.ArrayIndexOutOfBoundsException;

public class SimDriver {
	public static void main(String[] args) {
		/** Circular list of stations in kitchen */
		CList<CookingStation> stations = new CList<CookingStation>();


		//Reading file, taken from ReadFile.java on class site
		Scanner infile = null;
        boolean inerror = false;

        try {
            System.out.println("0 " + args[0] + " should be input filename");
            infile = new Scanner(new FileReader(args[0]));
        } catch (ArrayIndexOutOfBoundsException a) {
            System.err.println("must give input filename at command line");
            inerror = true;
        } catch (IOException f) {
            System.err.println("can't open that file, try again");
            inerror = true;
        }
        if (inerror) {
            System.err.println("exiting...");
            System.exit(1);
        }
        
        Scanner inline;
        String line;
        String name, item;
        int time, under, over;
        while (infile.hasNext()) {
            name = infile.nextLine();


            CookingStation c = new CookingStation(name);
            

            line = infile.nextLine();
            while (!line.equals("")) {
                inline = new Scanner(line);
                item = inline.next();
                time = inline.nextInt();
                under = inline.nextInt();
                over = inline.nextInt();
                
                c.addItem(new CookingItem(item, time, under, over));
                line = infile.nextLine();
            }
            //System.out.println(name);
            stations.append(c);
        }
        System.out.println(stations);



        int penalty = 0;
        int index = -1;
        // while there is still something cooking
        while (stations.length() != 0) {

        	index = stations.currPos(); // save the current position

        	CookingStation curr = stations.getValue();

        	//check if all of the stations are empty
        	if (!stations.toString().contains(")")) {
        		break;
        	}

        	CookingItem i = curr.tend(1, 0);


        	if (i != null) {
        		penalty += i.penalty();
        	}

        	//tick all stations

        	boolean exit = false;
        	stations.moveToStart();
        	while (!stations.isAtEnd()) {

        		stations.getValue().tick();
        		stations.next();
        	}
        	stations.getValue().tick();

        	//bring back to original position
        	stations.moveToPos(index);

        	index = -1;


        	
        	stations.circularNext();
        		
        	System.out.println(stations);

        }
        
        // print the total penalties
        System.out.println("Final penalty was: " + penalty);

        
        // tend the next station and decide whether to remove based on threshholds
        // keep running sum of penalties
        // print status of all stations



	}
	
}
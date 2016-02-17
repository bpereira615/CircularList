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
        int numItems = 0; // total number of dishes being cooked

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
                // count number of items going into kitchen
                numItems++;
                line = infile.nextLine();
            }
            //System.out.println(name);
            stations.append(c);
        }
        System.out.println(stations);
        System.out.println("number of items: " + numItems);

        // this is where our actual simulation starts
        int penalty = 0;
        int index = -1;
      
        // while there is still something cooking
        while (stations.length() != 0) {
            
            // index = current position in stations, ie at stove
        	index = stations.currPos();
            // what station are we currently at? stove? grill?
        	CookingStation curr = stations.getValue();
            // check if a station has no items
            // currently kills all stations after  one run
            //if (curr.getValue() == null) {
              //  stations.remove();
               // index = -1;
               // break;
           // }
        	//check if all of the stations are empty
        	if (!stations.toString().contains(")")) {
        		break;
        	}
            
            // tend the current item in the current station
            // ex: tend chicken on grill
        	CookingItem i = curr.tend(2, 1, numItems);

            // increment total penalties
            // TODO: change variable name to totPenalty
        	
            if (i != null) { // aka if item was removed
        		penalty += i.penalty();
                numItems--;
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
            System.out.println("number of items: " + numItems);
        }
        
        // print the total penalties
        System.out.println("Final penalty was: " + penalty);

        
        // tend the next station and decide whether to remove based on threshholds
        // keep running sum of penalties
        // print status of all stations



	}
	
}

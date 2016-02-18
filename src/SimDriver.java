import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
// import java.util.ArrayIndexOutOfBoundsException;

public class SimDriver {
	public static void main(String[] args) throws IOException {
		/** Circular list of stations in kitchen */
		CList<CookingStation> stations = new CList<CookingStation>();


		//Reading file, taken from ReadFile.java on class site
		Scanner infile = null;
        boolean inerror = false;

        //Writing file, specified by simulation
        Scanner outfile = null;

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


        //simulation(stations, 0, 0, numItems);
        simulation(stations, 1, 0, numItems);
        //simulation(stations, 2, 0, numItems);
        //simulation(stations, 1, 0, numItems);

    }



    static void simulation(CList<CookingStation> stations, int removeThreshold, 
        int penaltyThreshold, int numItems) throws IOException{

        //setting up output file
        String outfile = "sim" + removeThreshold + ".txt";

        if (penaltyThreshold != 0) {
            outfile = "simP.txt";
        }

        PrintWriter o = new PrintWriter(new FileWriter(outfile));


        // this is where our actual simulation starts
        int penalty = 0;

        //index of current station in list
        int index = -1;
      

        stations.moveToStart();
        System.out.println(stations);
        o.println(stations);

        //initially tick all stations
        index = stations.currPos();
        stations.moveToStart();
        while (!stations.isAtEnd()) {
            stations.getValue().tick();
            stations.next();
        }
        stations.getValue().tick();

        //bring back to original position
        stations.moveToPos(index);


        

        index = -1;

        // while there is still something cooking
        while (stations.length() != 0) {
            
            // index = current position in stations, ie at stove
        	index = stations.currPos();
            // what station are we currently at? stove? grill?
        	CookingStation curr = stations.getValue();
            

        	//check if all of the stations are empty
        	if (!stations.toString().contains(")")) {
        		break;
        	}
            
            // tend the current item in the current station
            CookingItem i = curr.tend(removeThreshold, penaltyThreshold);

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
            o.println(stations);
            //System.out.println("number of items: " + numItems);
        }
        
        // print the total penalties
        System.out.println("Final penalty was: " + penalty);
        o.println("Final penalty was: " + penalty);

        o.close();

        
        // tend the next station and decide whether to remove based on threshholds
        // keep running sum of penalties
        // print status of all stations



	}
	
}

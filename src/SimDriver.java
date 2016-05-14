import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
// import java.util.ArrayIndexOutOfBoundsException;

/**
 * The driver for Cutthroat Kitchen simulation.
 *
 * @author Benjamin Hoertnagl-Pereira
 * @author Lydia Carroll
 */

public final class SimDriver {

<<<<<<< HEAD
    /** Private empty constructor for utility class */
    private SimDriver() {}

	public static void main(String[] args) throws IOException {

    	/** Circular list of stations in kitchen */
    	CList<CookingStation> stations = new CList<CookingStation>();


    	//Reading file, taken from ReadFile.java on class site
        /** Text file to be read in from */
    	Scanner infile = null;
=======
    /** Private empty constructor for utility class. */
    private SimDriver() {
    }
   
    /**
     * Main method for simulation- reads in from file and 
     * runs simulation given respective thresholds.
     *
     * @param args the command line arguments
     *
     * @throws IOException from readion/writing files
     */
    public static void main(String[] args) throws IOException {
        /** Circular list of stations in kitchen */
        CList<CookingStation> stations = new CList<CookingStation>();


        //Reading file, taken from ReadFile.java on class site
        /** Text file to be read in from */
        Scanner infile = null;
>>>>>>> 8fc89760dcb890a966103021907404bc644a847e
        /** Error from reading in file */
        boolean inerror = false;

        /** Text file to be written out to */
        Scanner outfile = null;

        /** Total number of dishes to be cooked */
        int numItems = 0; 
<<<<<<< HEAD
=======

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
>>>>>>> 8fc89760dcb890a966103021907404bc644a847e

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

<<<<<<< HEAD

            CookingStation c = new CookingStation(name);
                

=======
            CookingStation c = new CookingStation(name);
                

>>>>>>> 8fc89760dcb890a966103021907404bc644a847e
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
            stations.append(c);
        }
<<<<<<< HEAD

=======
        
        //******************************************************
>>>>>>> 8fc89760dcb890a966103021907404bc644a847e

        //Choosing simulation to be run, comment all but one 
        //simulation(stations, 0, 0, numItems);
        //simulation(stations, 1, 0, numItems);
        //simulation(stations, 2, 0, numItems);
        simulation(stations, 1, 1, numItems);


        //******************************************************

    }


    /**
     * Helper method for the simulation.
     *
     * @param stations the list of cooking stations
     * @param removeThreshold used for tend, when to remove
     * @param penaltyThreshold used for tend, when to remove
     * @param numItems total number of items at all stations
     *
     * @throws IOException for reading/writing to files
     */
    static void simulation(CList<CookingStation> stations, int removeThreshold, 
        int penaltyThreshold, int numItems) throws IOException {

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
            CookingItem i;
            if (penaltyThreshold > 0) {
                i = curr.tend(removeThreshold, penaltyThreshold, numItems);
            } else {
                i = curr.tend(removeThreshold, penaltyThreshold);
            }

            // increment total penalties
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
        }
        
        // print the total penalties
        System.out.println("Final penalty was: " + penalty);
        o.println("Final penalty was: " + penalty);

        o.close();

    }
    
}

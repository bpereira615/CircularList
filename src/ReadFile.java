/********************************************************************
 * Benjamin Hoertnagl-Pereira bhoertn1 631-488-7197 bhoertn1@jhu.edu Lydia
 * Carroll lcarro12 240-994-8355 lcarro12@jhu.edu
 *
 * 600.226.02 CS226 Data Structures Project 1 - CircularList
 *
 * NOTE: this file was taken from the assignment page
 *******************************************************************/

import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
// import java.util.ArrayIndexOutOfBoundsException;

public class ReadFile {
    public static void main(String[] args) throws IOException {

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
            line = infile.nextLine();
            while (!line.equals("")) {
                inline = new Scanner(line);
                item = inline.next();
                time = inline.nextInt();
                under = inline.nextInt();
                over = inline.nextInt();
                name += " " + item + " " + time + " " + under + " " + over;
                line = infile.nextLine();
            }
            System.out.println(name);
        }

    }
}


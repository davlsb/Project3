import java.awt.Container;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ClockGUI extends JFrame {

    private JFrame myGUI;
    TextArea text;
    TextArea textArea2;
    private JMenuBar menuBar;
    private String chosenFileName;
    private SortedClockList Arr1 = new SortedClockList();
    private UnsortedClockList Arr2 = new UnsortedClockList();


    public ClockGUI() {
       setTitle("clocks");
	   setSize(400,400);
       setLocation  (400,200);
       this.text = new TextArea();      //unsorted array side, text area
       this.textArea2 = new TextArea(); //sorted array side, text area
       this.myGUI=new JFrame();
       createFileMenu(myGUI);
       myGUI.setTitle("Clocks");
       TheFile();
       myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       myGUI.setSize(400,400);//width, height;
       myGUI.setLocation(100,100);//x, y);
       myGUI.setLayout(new GridLayout(1,2));
       this.addText(Arr1,Arr2);
       myGUI.setVisible(true);
    }

    

    private void createFileMenu(JFrame myGUI) {
    	
       menuBar = new JMenuBar();

       JMenuItem   item1;
       JMenuItem   item2;
       JMenuBar    menuBar  = new JMenuBar();
       JMenu       fileMenu = new JMenu("Files");
       
       FileMenuHandler fmh  = new FileMenuHandler(myGUI);

       item1 = new JMenuItem("Open");    //Open...
       item1.addActionListener( fmh );
       fileMenu.add( item1 );
       fileMenu.addSeparator();
       item2 = new JMenuItem("Quit");       //Quit
       item2.addActionListener( fmh );
       fileMenu.add(item2);

       menuBar.add(fileMenu);
       myGUI.setJMenuBar(menuBar);


    } //createMenu

    public void TheFile() {
    	
         openFile();
        
    	 TextFileInput in;
    	 in = new TextFileInput(chosenFileName);
    	 String line = in.readLine(); // reading the first line
    	 
        // Arr1 = new UnsortedClockList(); //unsorted list of clocks
         //Arr2 = new SortedClockList(); //sorted list of clocks

         while(line!=null) { //as long as we didn't reach the end of the file

             StringTokenizer Str = new StringTokenizer(line,":"); //tokenize the line based on :

        	 try {
        		 
             if(Str.countTokens()==3){            //if there are all 3 parts of the clock (hours, minutes, seconds)

                 int hours=Integer.parseInt(Str.nextToken());   //first token is hours
                 int minutes=Integer.parseInt(Str.nextToken()); //second token is minutes
                 int seconds=Integer.parseInt(Str.nextToken()); //third token is seconds

                 Clock clock = new Clock(hours,minutes,seconds); //create the clock instance based on the line

                 Arr2.add(clock);
                 Arr1.add(clock);
            		 }
            	 } 
        	 
        	 catch (IllegalClockException ICE) {
            		System.out.println(line); 
        	 		} //if it didn't have all 3 parts, print line to console
        	 
             line = in.readLine();
         }


    }
    
    private void openFile() {
        JFileChooser chooser;
        int          status;
        chooser = new JFileChooser( );
        status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
        	chooser.getSelectedFile();
        	chosenFileName = chooser.getSelectedFile().getAbsolutePath(); 
        }
        
        else 
        	JOptionPane.showMessageDialog(null, "Open File dialog canceled");
     }
    
    
    public void addText(SortedClockList Arr1, UnsortedClockList Arr2) {

        myGUI.getContentPane().add(text);      //add unsorted text box to the GUI window

        text.setEditable(false);
        text.setText("Unsorted: " + "\n");


        myGUI.getContentPane().add(textArea2); //add sorted text box to the GUI window
        textArea2.setEditable(false);
        textArea2.setText("Sorted: " + "\n");

        for (ClockNode i = Arr2.first.next; i != null; i = i.next) {            //adds the clocks from the areas to each text area
            text.append(i.data + "\n");
       }

       for (ClockNode i = Arr1.first.next; i != null; i = i.next) {            //adds the clocks from the areas to each text area
            textArea2.append(i.data + "\n");
        }

    }
}
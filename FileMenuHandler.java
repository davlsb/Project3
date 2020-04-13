import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener {
   JFrame jframe;
   
   public FileMenuHandler (JFrame jf) {
      jframe = jf;
   }
   public void actionPerformed(ActionEvent event) {
      String  menuName;
      menuName = event.getActionCommand();
      if (menuName.equals("Open"))
         openFile(); 
      else if (menuName.equals("Quit"))
         System.exit(0);
   } //actionPerformed

   

   private void openFile( ) {
      JFileChooser chooser;
      int          status;
      chooser = new JFileChooser( );
      status = chooser.showOpenDialog(null);
      if (status == JFileChooser.APPROVE_OPTION) 
         readSource(chooser.getSelectedFile());
      else 
         JOptionPane.showMessageDialog(null, "Open File dialog canceled");
   } //openFile
 
   private void readSource(File chosenFile) {
	   SortedClockList sorted = new SortedClockList();
	   UnsortedClockList unsorted = new UnsortedClockList();
      String chosenFileName = chosenFile.getAbsolutePath();
      TextFileInput inFile = new TextFileInput(chosenFileName);
      String line;
      jframe.getContentPane().removeAll();
      Container myContentPane = jframe.getContentPane();
      TextArea myTextArea = new TextArea();
      TextArea Sorted = new TextArea();
      myContentPane.add(myTextArea);
      myContentPane.add(Sorted);
      line = inFile.readLine();
      
      while(line!=null) { //as long as we didn't reach the end of the file

          StringTokenizer Str = new StringTokenizer(line,":"); //tokenize the line based on :

          if(Str.countTokens()==3){            //if there are all 3 parts of the clock (hours, minutes, seconds)

              int hours=Integer.parseInt(Str.nextToken());   //first token is hours
              int minutes=Integer.parseInt(Str.nextToken()); //second token is minutes
              int seconds=Integer.parseInt(Str.nextToken()); //third token is seconds

              Clock clock = new Clock(hours,minutes,seconds); //create the clock instance based on the line

              unsorted.add(clock);
              sorted.add(clock);


          }
          
          else System.out.println(line); //if it didn't have all 3 parts, print line to console
          line = inFile.readLine();
      }
      
      Sorted.setText("Sorted: " + "\n");
      myTextArea.setText("Unsorted: " + "\n");

    	  for (ClockNode i = sorted.first.next; i != null; i = i.next) {            //adds the clocks from the areas to each text area
              Sorted.append(i.data + "\n");
         }

         for (ClockNode i = unsorted.first.next; i != null; i = i.next) {            //adds the clocks from the areas to each text area
              myTextArea.append(i.data + "\n");
          }
    jframe.setVisible(true);  
   }
}
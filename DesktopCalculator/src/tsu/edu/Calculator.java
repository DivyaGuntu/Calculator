package tsu.edu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    
	private static final long serialVersionUID = 1L;
	
    private JPanel panel1, panel2, panel3, panel4, panel5;
    private JLabel jl;
    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem menuitem;
    private JRadioButton jr[];
    private JCheckBox jc1,jc2, jc3, jc4;
    private JButton jb[];
    double result = 0 ;
    final int Maxlength = 20;
	boolean clearPrevious;
	double previousNumber;
	String operator;
	final int Inputmode = 0;
	final int Resultmode = 1;
	final int Errormode = 2;
	int displaymode;
    
    
    public static void main(String[] args) {
        Calculator frame = new Calculator();
        frame.setTitle("Calculator");
        frame.setVisible(true);
        frame.setResizable(false);
    }
    
    public Calculator() {                                                   // constructor
    	
        Container c = getContentPane();
        c.setLayout(new GridBagLayout());
        panel1 = new JPanel(new GridLayout(1, 1));                          //Creating panel for MenuBar
        menubar = new JMenuBar();
        panel1.add(menubar);                                                //Adding menubar to the panel
        menu = new JMenu("Edit");
        menubar.add(menu);
        menuitem = new JMenuItem("copy  Ctrl+C");                           
        menu.add(menuitem);
        menuitem = new JMenuItem("paste Ctrl+V");
        menu.add(menuitem);
        menu = new JMenu("View");
        menubar.add(menu);
        menu = new JMenu("Help");
        menubar.add(menu);
         
      //Creating new panel for label
        panel2 = new JPanel(new GridLayout(1,0));                         
      //Creating label which takes the calculator input and displays output
        jl = new JLabel("0");                                             
        jl.setHorizontalAlignment(JLabel.RIGHT);
        jl.setBackground(Color.white);
        jl.setOpaque(true);
        panel2.add(jl);                                                 
       
        
      //Creating new panel for Radio buttons
        panel3 = new JPanel(new GridLayout(1,2,2,2));                    
        jr = new JRadioButton[20];
        //Group of radio buttons is created to provide options to the user,
        //but only one option can be selected at a time.
        ButtonGroup group = new ButtonGroup();
        jr[1] = new JRadioButton("Hex");                                 
        jr[2] = new JRadioButton("Dec");
        jr[3] = new JRadioButton("Oct");
        jr[4] = new JRadioButton("Bin");
        for(int i =1;i<=4;i++){
     	   group.add(jr[i]);
     	   panel3.add(jr[i]);} 
        ButtonGroup group1 = new ButtonGroup();
        jr[5] = new JRadioButton("Degrees");
        jr[6] = new JRadioButton("Radians");
        jr[7] = new JRadioButton("Grads");
        for(int i =5;i<=7;i++){
        	   group1.add(jr[i]);
        	   panel3.add(jr[i]);}   
        
        
      //Creating new panel for check boxes
        panel4 = new JPanel(new GridLayout(1,0,5,5));                    
        jc1 = new JCheckBox("Inv");
        jc2 = new JCheckBox("Hyp");
        jc3 = new JCheckBox(" ");
        jc4 = new JCheckBox(" ");
        jb = new JButton[100];
        jb[56] = new JButton("Backspace");
        jb[57] = new JButton("CE");
        jb[58] = new JButton("c");
        panel4.add(jc1);
        panel4.add(jc2);
        panel4.add(jc3);
        panel4.add(jc4); 
        for(int i =56;i<=58;i++){
      	   panel4.add(jb[i]); } 
        
      
        //Creating new panel for all numeric and functional buttons
        panel5 = new JPanel(new GridLayout(5,11,5,5));                      
        jb[1] = new JButton("Sta");
        jb[2] = new JButton("F-E");
        jb[3] = new JButton("(");
        jb[4] = new JButton(")");
        jb[5] = new JButton("MC");
        jb[6] = new JButton("7");
        jb[7] = new JButton("8");
        jb[8] = new JButton("9");
        jb[9] = new JButton("/");
        jb[10] = new JButton("Mod");
        jb[11] = new JButton("And");   
        jb[12] = new JButton("Ave");
        jb[13] = new JButton("dms");
        jb[14] = new JButton("Exp");
        jb[15] = new JButton("ln");
        jb[16] = new JButton("MR");
        jb[17] = new JButton("4");
        jb[18] = new JButton("5");
        jb[19] = new JButton("6");
        jb[20] = new JButton("*");
        jb[21] = new JButton("Or");
        jb[22] = new JButton("Xor");
        jb[23] = new JButton("Sum");
        jb[24] = new JButton("sin");
        jb[25] = new JButton("x^y");
        jb[26] = new JButton("log");
        jb[27] = new JButton("MS");
        jb[28] = new JButton("1");
        jb[29] = new JButton("2");
        jb[30] = new JButton("3");
        jb[31] = new JButton("-");
        jb[32] = new JButton("Lsh");
        jb[33] = new JButton("Not");
        jb[34] = new JButton("s");
        jb[35] = new JButton("cos");
        jb[36] = new JButton("x^3");
        jb[37] = new JButton("n!");
        jb[38] = new JButton("M+");
        jb[39] = new JButton("0");
        jb[40] = new JButton("+/-");
        jb[41] = new JButton(".");
        jb[42] = new JButton("+");
        jb[43] = new JButton("=");
        jb[44] = new JButton("Int");
        jb[45] = new JButton("Dat");
        jb[46] = new JButton("tan");
        jb[47] = new JButton("x^2");
        jb[48] = new JButton("1/x");
        jb[49] = new JButton("Pi");
        jb[50] = new JButton("A");
        jb[51] = new JButton("B");
        jb[52] = new JButton("C");
        jb[53] = new JButton("D");
        jb[54] = new JButton("E");
        jb[55] = new JButton("F");     
        for(int i =1;i<=55;i++){
     	   panel5.add(jb[i]); } 
        

        //Sets color 
        for(int i =6;i<=8;i++)
        	jb[i].setForeground(Color.blue);
        for(int i =17;i<=19;i++)
        	jb[i].setForeground(Color.blue);
        for(int i =28;i<=30;i++)
        	jb[i].setForeground(Color.blue);
        jb[39].setForeground(Color.blue); 
        for(int i =11;i<=44;){
        	i=i+10;
        	jb[i].setForeground(Color.red);} 
        jb[5].setForeground(Color.red);
        jb[9].setForeground(Color.red); 
        jb[10].setForeground(Color.red);
        jb[16].setForeground(Color.red);
        jb[20].setForeground(Color.red);
        jb[21].setForeground(Color.red); 
        jb[27].setForeground(Color.red); 
        jb[32].setForeground(Color.red);
        jb[38].setForeground(Color.red);
        for(int i =41;i<=43;i++)
        	jb[i].setForeground(Color.red);
        for(int i =56;i<=58;i++)
        	jb[i].setForeground(Color.red);
        
        //Disable buttons
        jb[12].setEnabled(false);                                                
        jb[23].setEnabled(false);
        jb[34].setEnabled(false);
        jb[45].setEnabled(false);
        jb[50].setEnabled(false);
        jb[51].setEnabled(false);
        jb[52].setEnabled(false);
        jb[53].setEnabled(false);
        jb[54].setEnabled(false);
        jb[55].setEnabled(false);
        
        // Adding panels to the container and sets the spaces between them 
        GridBagConstraints gbc = new GridBagConstraints();                    
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy =0;
        c.add(panel1,gbc);
        gbc.gridy++;
        c.add(panel2,gbc);
        gbc.gridy++;
        c.add(panel3,gbc);
        gbc.gridy++;
        c.add(panel4,gbc);
        gbc.gridy++;
        c.add(panel5,gbc);
        gbc.gridy++;
        //c.add(panel6,gbc); 
        pack();
        setVisible(true);
 
        //Activate action listener for receiving action events
		jb[6].addActionListener(this);                                       
		jb[7].addActionListener(this);
		jb[8].addActionListener(this);
		jb[17].addActionListener(this);
		jb[18].addActionListener(this);
		jb[19].addActionListener(this);
		jb[28].addActionListener(this);
		jb[29].addActionListener(this);
		jb[30].addActionListener(this);
		jb[39].addActionListener(this);
		jb[9].addActionListener(this);
		jb[20].addActionListener(this);
		jb[24].addActionListener(this);
		jb[25].addActionListener(this);
		jb[31].addActionListener(this);
		jb[42].addActionListener(this);
		jb[43].addActionListener(this);
		jb[56].addActionListener(this);
		jb[57].addActionListener(this);
		jb[58].addActionListener(this);
		//jb[42].addActionListener(this);
		clearAll();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Invokes when an action occurs 
	public void actionPerformed(ActionEvent e) {   
	   // Retrieves value from the buttons
       String input = ((JButton)e.getSource()).getText(); 		                               
      //if input matches numbers then adds to the display
       if(input.matches("^[0-9]+$"))
       {
    	 int digit = Integer.parseInt(input);
    	 addToDisplay(digit);
       } 
       
       if(input.equals("."))
     	  addDecimal();
      //Check the input and perform specific operation
       if(input.equals("+"))                                                                                                                                
    	  dataOperator("+");
       if(input.equals("-"))
    	  dataOperator("-");
      if(input.equals("*"))
    	  dataOperator("*");
      if(input.equals("/"))
    	  dataOperator("/");
      if(input.equals("x^y"))
          dataOperator("x^y");
      if(input.equals("sin"))
          dataOperator("sin");
      
      
      if(input.equals("="))
    	  methodEquals();
      
      if(input.equals("Backspace"))
  	      clearDigit();
      if(input.equals("CE"))
		   clearExisting();
	  if(input.equals("c"))
				clearAll();
	}
	

	//Adds input to the display
	private void addToDisplay(int digit) {                                
		if (clearPrevious)
			setDisplayString("");

		String inputString = getDisplayString();

		if (inputString.indexOf("0") == 0) {
			inputString = inputString.substring(1);
		}

		if ((!inputString.equals("0") || digit > 0)
				&& inputString.length() < Maxlength) {
			setDisplayString(inputString + digit);
		}

		displaymode = Inputmode;
		clearPrevious = false;
	}

	  private String getDisplayString() {
			return jl.getText();
		}

      private void setDisplayString(String s) {
			jl.setText(s);
		}
  
	  private double getLabelInput() {
		String input = jl.getText();
		return Double.parseDouble(input);
	   }
	
	//finds the operator and get the value of inputs
	  private void dataOperator(String o) {                             
		if (displaymode != Errormode) {
			double displayNumber = getLabelInput();
			if (!operator.equals("0")) {
				try {
					double result = operations();
					displayResult(result);
					previousNumber = result;
				}

				catch (DivideByZeroException e) {
				}
			}

			else {
				previousNumber = displayNumber;
			}

			clearPrevious = true;
			operator = o;
		}
	}
	
	
	//Perform operations
	private double operations() throws DivideByZeroException {
		double result = 0;
		double displayNumber = getLabelInput();
		if (operator.equals("/")) {
			if (displayNumber == 0)
				throw (new DivideByZeroException());
			 result = previousNumber / displayNumber; }

		if (operator.equals("*"))
			result = previousNumber * displayNumber;

		if (operator.equals("-"))
			result = previousNumber - displayNumber;

		if (operator.equals("+"))
			result = previousNumber + displayNumber;
		
		if(operator.equals("x^y"))
			result = Math.pow(previousNumber, displayNumber);
		
		if(operator.equals("sin"))
			result = Math.sin(Math.toRadians(getLabelInput()));
		
		return result;
	}
	
   //If user clicks on Equals button,calls operations and displayResult methods
	private void methodEquals() {
		double result = 0;

		if (displaymode != Errormode) {
			try {
				result = operations();
				displayResult(result);
			}

			catch (DivideByZeroException e) {
				  setDisplayString("Cannot divide by zero");
			      previousNumber = 0;
			      displaymode = Errormode;
			       clearPrevious = true;
			}

			operator = "0";
		}
	}

	//Sets the result in the display                                                                       
	private void displayResult(double result) {
		  setDisplayString(Double.toString(result));
		  previousNumber = result;
		  displaymode = Resultmode;
		  clearPrevious = true;
	}

	//Adds decimal to the input
    private void addDecimal() {                                          
	displaymode = Inputmode;
	if (clearPrevious)
		setDisplayString("");

	String inputString = getDisplayString();
	if (inputString.indexOf(".") < 0)
		setDisplayString(new String(inputString + "."));
    } 

     private void clearDigit(){
	 if (displaymode != Errormode) {
			setDisplayString(getDisplayString().substring(0,getDisplayString().length() - 1));

			if (getDisplayString().length() < 1)
				setDisplayString("0");
		} 
     }

   //clears the data
     private void clearAll() {                                                 
	      setDisplayString("0");
	      operator = "0";
	      previousNumber = 0;
	      displaymode = Inputmode;
	      clearPrevious = true;
         }


  //Clears existing
   private void clearExisting() {                                           
	       setDisplayString("0");
	       clearPrevious = true;
	       displaymode = Inputmode;
          }

       }


   class DivideByZeroException extends Exception {

     	private static final long serialVersionUID = 1L;

	  public DivideByZeroException() {
		super();
	   }

	  public DivideByZeroException(String s) {
		super(s);
	  }
    } 

    

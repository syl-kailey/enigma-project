import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame implements ActionListener{

    JComboBox<Integer> inner;
    JComboBox<Integer> middle;
    JComboBox<Integer> outer;
    JTextField intPosition;
    JTextField input;
    JTextField output;
    JButton encrypt;
    JButton decrypt;

    String outputText;
    
    Integer[] position = {
        1,2,3,4,5
    };
    
    public EnigmaFrame(){
        inner = new JComboBox<Integer>(position);
        middle = new JComboBox<Integer>(position);
        outer = new JComboBox<Integer>(position);
        intPosition = new JTextField();
        intPosition.setPreferredSize(new Dimension(100,20));
        encrypt = new JButton("Encrypt");
        decrypt = new JButton("Decrypt");
        input = new JTextField();
        input.setPreferredSize(new Dimension(500,200));
        output = new JTextField();
        output.setPreferredSize(new Dimension(500,200));
        output.setEditable(false); //do not let the result be edited

        // Create panel with flow layout and add GUI elements
        JPanel panel1 = new JPanel(new FlowLayout()); 
        panel1.add(new JLabel("Inner "));
        panel1.add(inner);
        panel1.add(new JLabel("Middle "));
        panel1.add(middle);
        panel1.add(new JLabel("Outer "));
        panel1.add(outer);
        panel1.add(new JLabel("Initial Positions "));
        panel1.add(intPosition);
        panel1.add(encrypt);
        panel1.add(decrypt);
        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.add(new JLabel("Input "));
        panel2.add(input);
        JPanel panel3 = new JPanel(new FlowLayout());
        panel3.add(new JLabel("Output "));
        panel3.add(output);
        
        input.addActionListener(this);
        inner.addActionListener(this);
        middle.addActionListener(this); 
        outer.addActionListener(this);
        encrypt.addActionListener(this);
        decrypt.addActionListener(this);
            
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("ACTION PERFORMED");
        int innerE = inner.getSelectedIndex() +1;
        int middleE = middle.getSelectedIndex()+1;
        int outerE = outer.getSelectedIndex()+1;
        String text = intPosition.getText();
        String inputE = input.getText();
        System.out.println(innerE + " " + middleE + " " + outerE);


        Enigma enigma = new Enigma(innerE, middleE, outerE, text);

        if (e.getSource() == encrypt){
            System.out.println("ENCRYPT");
            outputText = enigma.encrypt(inputE);
        }
        if (e.getSource() == decrypt){
            outputText = enigma.decrypt(inputE);
        }
        output.setText(outputText);
    }
}


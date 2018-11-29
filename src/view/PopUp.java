package view;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*; 
import java.awt.event.*; 

public class PopUp extends JFrame implements ActionListener { 
    // popup 
    Popup po; 
    Color dark2 = new Color(60, 70, 90);
    // frame 
    JFrame f; 
  
    // panel 
    JPanel popWin; 
  
    // popupfactory 
    PopupFactory pf; 
  
    // constructor 
    public PopUp() 
    { 
        // create a frame 
        f = new JFrame("pop"); 
  
        f.setBounds(400, 200, 300, 200);
  
        pf = new PopupFactory(); 
  
        // create a label 
        JLabel l = new JLabel("This  is a popup menu"); 
  
        // create a new button 
        JButton b19 = new JButton("OK"); 
  
        // add action listener 
        b19.addActionListener(this); 
  
        try { 
            // set windows look and feel 
            UIManager.setLookAndFeel(UIManager. 
                  getSystemLookAndFeelClassName()); 
        } 
        catch (Exception e) { 
        } 
  
        // create a panel 
        popWin = new JPanel(); 
        popWin.setBackground(dark2);
        popWin.setBorder(new EmptyBorder(5, 5, 5, 5));
        popWin.setLayout(null);
  
        popWin.setBackground(Color.blue); 
  
        // create a font 
        Font fo = new Font("BOLD", 1, 14); 
  
        l.setFont(fo); 
  
        // add contents to panel 
        popWin.add(l); 
        popWin.add(b19); 
  
        popWin.setLayout(new GridLayout(2, 1)); 
  
        // create a popup 
        po = pf.getPopup(f, popWin, 180, 100); 
  
        // create a button 
        JButton b = new JButton("click"); 
  
        // add action listener 
        b.addActionListener(this); 
  
        // create a panel 
        JPanel p1 = new JPanel(); 
  
        p1.add(b); 
        f.add(p1); 
        f.show(); 
    } 
  
    // if the button is pressed 
    public void actionPerformed(ActionEvent e) 
    { 
        String d = e.getActionCommand(); 
        // if ok buton is pressed hide the popup 
        if (d.equals("OK")) { 
            po.hide(); 
  
            // create a popup 
            po = pf.getPopup(f, popWin, 180, 100); 
        } 
        else
            po.show(); 
    } 
}

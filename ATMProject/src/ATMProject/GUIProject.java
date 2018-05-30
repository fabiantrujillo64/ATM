package ATMProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GUIProject {
 
 JFrame ATM;
 JLabel label1;
 JLabel label2;
 JLabel label3;
 JButton balance;
 JButton withdraw;
 JButton deposit;
 int amount = 100;
 String UserInput;
 
 
 public static void main(String[] args) {
  new GUIProject();
 }
  
 public GUIProject(){
  ATM = new JFrame();
  ATM.setSize(600,500);
  ATM.setResizable(false);
  ATM.setLocationRelativeTo(null);
  ATM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  ATM.setTitle("ATM Project");
  ATM.setVisible(true);
  
  ListenForButton lForBalance = new ListenForButton();
  ListenForOpenItem lForOpenItem = new ListenForOpenItem();
  ListenForWithdraw lForWithdraw = new ListenForWithdraw();
  ListenForDeposit lForDeposit = new ListenForDeposit();
  ListenForSignOut lForSignOut = new ListenForSignOut();
  ListenForInfo lForInfo = new ListenForInfo();
  ListenForAbout lForAbout = new ListenForAbout();
  ListenForHelp lForHelp = new ListenForHelp();
  
  JPanel panel = new JPanel();
  Color bcolor = new Color(73,155,234);
  panel.setBackground(bcolor);
  panel.setLayout(null);
  
  label1 = new JLabel();
  label1.setText("FIRST FOUNDATION BANK");
  label1.setFont(new Font("Courier New", Font.BOLD, 30));
  label1.setForeground(Color.white);
  Color acolor = new Color(73,155,234);
  label1.setBackground(acolor);
  label1.setBounds(115,25,398,30);
  label1.setOpaque(true);
  
  label2 = new JLabel();
  Color ccolor = new Color(73,155,234);
  label2.setBackground(ccolor);
  label2.setBounds(25,70,398,30);
  label2.setOpaque(true);
  label2.setText("Hello, John!");
  label2.setFont(new Font(label2.getName(), Font.BOLD, 18));
  label2.setForeground(Color.white);
  
  label3 = new JLabel();
  Color dcolor = new Color(73,155,234);
  label3.setBackground(dcolor);
  label3.setBounds(25,100,398,30);
  label3.setOpaque(true);
  label3.setText("Transactions:");
  label3.setFont(new Font(label3.getName(),Font.BOLD, 12));
  label3.setForeground(Color.white);
  
  panel.add(label1);
  panel.add(label2);
  panel.add(label3);
  ATM.setVisible(true);
  ATM.add(panel);
  
  balance = new JButton("Check Balance");
  balance.setBounds(100,150,398,30);
  balance.addActionListener(lForBalance);
  panel.add(balance);
  
  withdraw = new JButton("Withdraw");
  withdraw.setBounds(100,200,398,30);
  withdraw.addActionListener(lForWithdraw);
  panel.add(withdraw);
  
  deposit = new JButton("Deposit");
  deposit.setBounds(100,250,398,30);
  deposit.addActionListener(lForDeposit);
  panel.add(deposit);
  
  JMenuBar menuBar = new JMenuBar();
  
  JMenu accountMenu = new JMenu("Account");
  JMenuItem openMenuItem = new JMenuItem("Info", KeyEvent.VK_O);
  openMenuItem.addActionListener(lForOpenItem);
  openMenuItem.addActionListener(lForInfo);
  accountMenu.add(openMenuItem);
  accountMenu.addSeparator();
  JMenuItem printMenuItem = new JMenuItem("Sign Out", KeyEvent.VK_P);
  printMenuItem.addActionListener(lForSignOut);
  accountMenu.add(printMenuItem);
  
  JMenu optionsMenu = new JMenu("Options");
  JMenuItem optionsMenuItem = new JMenuItem("About");
  optionsMenuItem.addActionListener(lForAbout);
  optionsMenu.add(optionsMenuItem);
  optionsMenu.addSeparator();
  JMenuItem helpMenuItem = new JMenuItem("Help");
  helpMenuItem.addActionListener(lForHelp);
  optionsMenu.add(helpMenuItem);
  
  menuBar.add(accountMenu);
  menuBar.add(optionsMenu);
  ATM.add(menuBar);
  ATM.setJMenuBar(menuBar);

  ATM.add(panel);
  ATM.setVisible(true);
 }
 
 //Add Action Listeners Here
 private class ListenForButton implements ActionListener{

  @Override
  public void actionPerformed(ActionEvent arg0) {
   // TODO Auto-generated method stub
   JOptionPane.showMessageDialog(ATM,"Current Balance: $" + Integer.toString(amount));
  }
  
 }
 
 private class ListenForInfo implements ActionListener{

  @Override
  public void actionPerformed(ActionEvent arg0) {
   // TODO Auto-generated method stub
   JOptionPane.showMessageDialog(ATM, "Name: John Doe\nAccount ID: 1234\nMember since: July 2, 1995" + "\nDate of Birth: June 22, 1975\nGender: Male");
   
  }
  
 }
 
 private class ListenForAbout implements ActionListener{

  @Override
  public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub
   JOptionPane.showMessageDialog(ATM, "Program created by:\nFabian Trujillo and Jayden Abril\nComputer Science Principles 2017-2018\nInstructor: Justin Landfried");
   System.out.println("User clicked on About");
  }
  
 }
 
 private class ListenForHelp implements ActionListener{

  @Override
  public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub
   JOptionPane.showMessageDialog(ATM, "To check your current balance, click the 'Check Balance' button.\nTo deposit money to your account, click the"
     + "'Deposit' button.\nTo withdraw money, click the 'Withdraw' button.");
   System.out.println("User clicked on Help");
  }
  
 }
 
 private class ListenForWithdraw implements ActionListener{

  @Override
  public void actionPerformed(ActionEvent arg0) {
   // TODO Auto-generated method stub
   withdraw();
   
  }

 }
 
 private class ListenForDeposit implements ActionListener{

  @Override
  public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub
   deposit();
   
  }
  
 }
 
 private class ListenForOpenItem implements ActionListener{

  @Override
  public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub
   System.out.println("User clicked on Info");
  }
 }
 private class ListenForSignOut implements ActionListener{
  
  @Override
  public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub
   
   if("Sign Out".equals(e.getActionCommand())) {
    
    int dialogButton = JOptionPane.YES_NO_OPTION;
    int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to sign out?","Warning", dialogButton);
    if(dialogResult == 0) {
       System.out.println("Signed Out");
       System.exit(0);
     } else {
       System.out.println("Cancled Sign Out");
     } 
     
    }
   }
   
  }
 private void withdraw() {
   String UserInput = JOptionPane.showInputDialog(null,"Enter amount to withdraw:");
   int input = Integer.valueOf(UserInput);
   if(input <= amount && input >= 0){
      amount = amount - input;
      System.out.println(amount);
   }
   else{
     JOptionPane.showMessageDialog(null,
    "Your current balance is either too low to make that transaction or you did not enter a positive integer.",
    "Transaction Error",
    JOptionPane.ERROR_MESSAGE);
   }
 }
 private void deposit() {
    String UserInput_2 = JOptionPane.showInputDialog(null,"Enter Amount to Deposit:");
    int input_2 = Integer.valueOf(UserInput_2);
    if(input_2 < 0){
      JOptionPane.showMessageDialog(null,
    "Please enter a positive integer.",
    "Transaction Error",
    JOptionPane.ERROR_MESSAGE);
    }
    else{
      amount = amount + input_2;
      System.out.println(amount);
    }
 }
}
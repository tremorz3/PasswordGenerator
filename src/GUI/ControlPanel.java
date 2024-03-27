package GUI;

import Listeners.ButtonListener;

import java.awt.*;

import javax.swing.*;

public class ControlPanel extends JPanel{
    //private final JTextArea passwordArea = new JTextArea(20,5);
    private final JTextField passwordTxtField = new JTextField(25);
    private final JButton okBt = new JButton("Ok");
    private final JButton refreshBt = new JButton("Refresh");
    private final JButton cleanBt = new JButton("Clean");
    private final JButton saveBt = new JButton("Save in a text file");
    private final JButton closeBt = new JButton("Close");

    private ButtonListener listener = new ButtonListener();

    private final Font currentFont = passwordTxtField.getFont();
    private final Font bigFont = new Font(currentFont.getFontName(),currentFont.getStyle(),30);
    
    public ControlPanel(){
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        passwordTxtField.setFont(bigFont);
        passwordTxtField.setBackground(Color.WHITE);
        passwordTxtField.setEditable(false);
        passwordTxtField.setForeground(Color.RED);

        /*JScrollPane scroll = new JScrollPane(passwordArea);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setBackground(Color.WHITE);
        scroll.getVerticalScrollBar().setForeground(Color.WHITE);
        scroll.getHorizontalScrollBar().setBackground(Color.WHITE);
        scroll.getHorizontalScrollBar().setForeground(Color.WHITE);*/

        refreshBt.setEnabled(false);
        cleanBt.setEnabled(false);
        saveBt.setEnabled(false);

        okBt.setActionCommand("OK");
        refreshBt.setActionCommand("REFRESH");
        cleanBt.setActionCommand("CLEAN");
        saveBt.setActionCommand("SAVE");
        closeBt.setActionCommand("CLOSE");

        okBt.addActionListener(listener);
        refreshBt.addActionListener(listener);
        cleanBt.addActionListener(listener);
        saveBt.addActionListener(listener);
        closeBt.addActionListener(listener);

        okBt.setBackground(Color.WHITE);
        refreshBt.setBackground(Color.WHITE);
        cleanBt.setBackground(Color.WHITE);
        saveBt.setBackground(Color.WHITE);
        closeBt.setBackground(Color.WHITE);        

        JPanel cx = new JPanel(new BorderLayout());
        cx.setBackground(Color.WHITE);
        cx.add(passwordTxtField,BorderLayout.CENTER);
        cx.setBorder(BorderFactory.createTitledBorder("password"));

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.WHITE);
        bottom.add(okBt);
        bottom.add(refreshBt);
        bottom.add(cleanBt);
        bottom.add(saveBt);
        bottom.add(closeBt);

        this.add(cx,BorderLayout.NORTH);
        this.add(bottom,BorderLayout.SOUTH);
    }

    //public JTextArea getPasswordTxtArea(){return passwordArea;}
    public JTextField getPasswordTxtField(){return passwordTxtField;}
    
    public JButton getOkBt(){return okBt;}
    public JButton getRefreshBt(){return refreshBt;}
    public JButton getCleanBt(){return cleanBt;}
    public JButton getSaveBt(){return saveBt;}
    public JButton getCloseBt(){return closeBt;}
    
}

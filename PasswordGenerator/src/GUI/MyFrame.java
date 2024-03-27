package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
    private static String directory = null;
    private static String fileName = "PasswordsList";

    private static final MyMenuBar menuBar = new MyMenuBar();
    private static final SettingsPanel nord = new SettingsPanel();
    private static final ControlPanel sud = new ControlPanel();

    public MyFrame(String title){
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);

        this.setJMenuBar(menuBar);
        this.getContentPane().add(nord,BorderLayout.NORTH);
        this.getContentPane().add(sud,BorderLayout.SOUTH);

        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void setDirectory(String d){directory = d;}
    public static void setFileName(String n){fileName = n;}
    public static String getDirectory(){return directory;}
    public static String getFileName(){return fileName;}

    public static MyMenuBar getMenu(){return menuBar;}
    public static SettingsPanel getSettingsPanel(){return nord;}
    public static ControlPanel getControlPanel(){return sud;}
    
}
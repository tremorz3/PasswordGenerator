package GUI;

import Listeners.*;

import java.awt.Color;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenuBar extends JMenuBar{
    private final JMenu fileMenu = new JMenu("File");
    private final JMenu editMenu = new JMenu("Edit");
    private final JMenuItem direcotryItem = new JMenuItem("Choose directory...");
    private final JMenuItem fileNameItem = new JMenuItem("Change file name");
    private final JCheckBoxMenuItem specialCharsCheckBox = new JCheckBoxMenuItem("Special Chars",true);
    private final JCheckBoxMenuItem duplicatesCheckBox = new JCheckBoxMenuItem("Duplicates",true);

    private MenuItemListener itemListener = new MenuItemListener();

    public MyMenuBar(){        
        this.setBackground(Color.WHITE);

        direcotryItem.setBackground(Color.WHITE);
        fileNameItem.setBackground(Color.WHITE);
        direcotryItem.addActionListener(itemListener);
        fileNameItem.addActionListener(itemListener);
        fileMenu.setBackground(Color.WHITE);
        fileMenu.add(direcotryItem);
        fileMenu.add(fileNameItem);
        this.add(fileMenu);

        specialCharsCheckBox.setBackground(Color.WHITE);
        duplicatesCheckBox.setBackground(Color.WHITE);
        editMenu.add(specialCharsCheckBox);
        editMenu.add(duplicatesCheckBox);
        editMenu.setBackground(Color.WHITE);
        this.add(editMenu);
    }

    public JMenuItem getDirecotryItem(){return direcotryItem;}
    public JMenuItem getFileNameItem(){return fileNameItem;}

    public JCheckBoxMenuItem getSpecialCharsBox(){return specialCharsCheckBox;}
    public JCheckBoxMenuItem getDuplicatesCheckBox(){return duplicatesCheckBox;}
    
}

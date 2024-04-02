package Listeners;

import GUI.MyFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        JMenuItem item = (JMenuItem) e.getSource();
        String newName;
        if(item == MyFrame.getMenu().getDirecotryItem()){
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Select a directory");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION){
                System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                MyFrame.setDirectory(chooser.getSelectedFile().getAbsolutePath());
            } else {
                System.out.println("No Selection ");
            }
        }
        if(item == MyFrame.getMenu().getFileNameItem()){
            newName = JOptionPane.showInputDialog(null,"Insert new name ");
            if(newName == null){
                JOptionPane.showMessageDialog(null,"you must select a name","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            MyFrame.setFileName(newName);
        }
    }
}

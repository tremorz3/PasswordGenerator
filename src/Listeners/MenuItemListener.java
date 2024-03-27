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
            chooser.setCurrentDirectory(new java.io.File("."));//imposta la directory corrente del selettore file sulla directory corrente del programma
            chooser.setDialogTitle("Select a directory");//imposta il titolo della finestra di dialogo del selettore file
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//imposta il selettore di file in modo che possa selezionare solo le directory e non i file
            chooser.setAcceptAllFileFilterUsed(false);//imposta il selettore file in modo che non accetti tutti i tipi di file
            if (chooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION){//mostra la finestra di dialogo del selettore file e controlla se l’utente ha selezionato un file o ha fatto clic sul pulsante “OK”
                System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());//stampa sulla console la directory corrente del selettore file
                System.out.println("getSelectedFile() : " + chooser.getSelectedFile());//stampa sulla console il file o la directory selezionata dall’utente
                MyFrame.setDirectory(chooser.getSelectedFile().getAbsolutePath());//aggiorna la directory del file delle password
            } else {//controlla se l’utente ha fatto clic sul pulsante “Annulla” e stampa sulla console “No Selection”
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

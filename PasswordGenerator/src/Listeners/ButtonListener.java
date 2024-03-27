package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import GUI.MyFrame;
import Generator.PasswordGenerator;

public class ButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        JButton b = (JButton)e.getSource();
        PasswordGenerator g = new PasswordGenerator((Integer) MyFrame.getSettingsPanel().getSpinner().getValue());
        String password;
        
        switch(b.getActionCommand()){
            case "OK":
                g.generatePassword();
                password = g.getPassword();
                //String testo = MyFrame.getControlPanel().getPasswordTxtArea().getText();
                MyFrame.getControlPanel().getPasswordTxtField().setText(password);
                MyFrame.getControlPanel().getOkBt().setEnabled(false);
                MyFrame.getControlPanel().getRefreshBt().setEnabled(true);
                MyFrame.getControlPanel().getCleanBt().setEnabled(true);
                MyFrame.getControlPanel().getSaveBt().setEnabled(true);
                break;
            case "REFRESH":
                g.generatePassword();
                password = g.getPassword();
                MyFrame.getControlPanel().getPasswordTxtField().setText(password);
                MyFrame.getControlPanel().getCleanBt().setEnabled(true);
                MyFrame.getControlPanel().getSaveBt().setEnabled(true);
                break;
            case "CLEAN":
                MyFrame.getSettingsPanel().getSpinner().setValue(1);
                MyFrame.getSettingsPanel().getInfo().setText("");
                MyFrame.getSettingsPanel().getUsername().setText("");
                MyFrame.getControlPanel().getPasswordTxtField().setText("");
                MyFrame.getControlPanel().getOkBt().setEnabled(true);
                MyFrame.getControlPanel().getRefreshBt().setEnabled(false);
                MyFrame.getControlPanel().getCleanBt().setEnabled(false);
                MyFrame.getControlPanel().getSaveBt().setEnabled(false);
                break;
            case "SAVE":
                boolean vuoto1 = MyFrame.getSettingsPanel().getInfo().getText().isEmpty();
                boolean vuoto2 = MyFrame.getSettingsPanel().getUsername().getText().isEmpty();
                if(MyFrame.getDirectory() == null){
                    JOptionPane.showMessageDialog(null,"you must select a directory first","ERROR",JOptionPane.ERROR_MESSAGE);
                }else if(!vuoto1 && !vuoto2) {
                    try {
                        LocalDateTime oraCorrente = LocalDateTime.now();
                        DateTimeFormatter formatoOra = DateTimeFormatter.ofPattern("HH:mm:ss");
                        DateTimeFormatter formatoGiorno = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        FileWriter file = new FileWriter(MyFrame.getDirectory() + "/" + MyFrame.getFileName() + ".txt", true);
                        file.write(oraCorrente.format(formatoGiorno) + " " +oraCorrente.format(formatoOra) + ":  domain = " +
                                MyFrame.getSettingsPanel().getInfo().getText() + "  User_Name/E-Mail = " + MyFrame.getSettingsPanel().getUsername().getText() +
                                "  password = " + MyFrame.getControlPanel().getPasswordTxtField().getText() + "\n\n");
                        file.close();
                        System.out.println("scrittura avvenuta");
                        JOptionPane.showMessageDialog(null,"Password saved",null,JOptionPane.INFORMATION_MESSAGE);
                        MyFrame.getControlPanel().getSaveBt().setEnabled(false);

                    } catch (IOException ecc) {
                        System.out.println("si è verificato un " + ecc.getMessage());
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"domain or username are not specified","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "CLOSE":
                System.exit(0);
                break;
        }

    }
    
}

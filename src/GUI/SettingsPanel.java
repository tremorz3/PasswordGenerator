package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class SettingsPanel extends JPanel{
    private final JLabel testo1 = new JLabel("info");
    private final JLabel testo2 = new JLabel("username/e-mail");
    
    private final JTextField infoTxtField = new JTextField(15);
    private final JTextField usernameTxtField = new JTextField(15);

    private final SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 30,1);
    private final JSpinner spinner = new JSpinner(model);

    //ingrandisco il font dei campi testo
    private final Font currentFont = testo1.getFont();
    private final Font bigFont = new Font(currentFont.getFontName(),currentFont.getStyle(),15);

    public SettingsPanel(){
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        infoTxtField.setFont(bigFont);
        usernameTxtField.setFont(bigFont);
        spinner.setFont(bigFont);

        JPanel sx = new JPanel(new BorderLayout());
        sx.setBackground(Color.WHITE);
        sx.add(testo1,BorderLayout.NORTH);
        sx.add(infoTxtField,BorderLayout.CENTER);
        this.add(sx,BorderLayout.WEST);
        
        JPanel cx = new JPanel(new FlowLayout());
        cx.setBackground(Color.WHITE);
        cx.add(spinner);
        this.add(cx,BorderLayout.CENTER);

        JPanel dx = new JPanel(new BorderLayout());
        dx.setBackground(Color.WHITE);
        dx.add(testo2,BorderLayout.NORTH);
        dx.add(usernameTxtField,BorderLayout.CENTER);
        this.add(dx,BorderLayout.EAST);

        this.setBorder(BorderFactory.createTitledBorder("settings"));
    }

    public JTextField getInfo(){return infoTxtField;}
    public JTextField getUsername(){return usernameTxtField;}

    public JSpinner getSpinner(){return spinner;}
}

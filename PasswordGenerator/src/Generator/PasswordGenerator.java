package Generator;

import GUI.MyFrame;

public class PasswordGenerator{
    private final String specialChars = "abcdefghilmnopqrstuvzxyjkwABCDEFGHILMNOPQRSTUVZXWYJK1234567890^?!_-&$£#@";
    private final String normalChars = "abcdefghilmnopqrstuvzxyjkwABCDEFGHILMNOPQRSTUVZXWYJK1234567890";
    String password = "";
    private int lunghezza;

    public PasswordGenerator(int l){this.lunghezza = l;}

    public String getPassword(){return this.password;}

    public void generatePassword(){
        int index;
        String source;

        if(MyFrame.getMenu().getSpecialCharsBox().getState()){source = specialChars;}
        else{source = normalChars;}

        for(int i = 0;i < lunghezza;i ++){
            index = (int)(Math.random() * source.length());
            char carattere = source.charAt(index);
            String passwordPiccolo = password.toLowerCase();
            char caratterePiccolo = Character.toLowerCase(carattere);
            if(MyFrame.getMenu().getDuplicatesCheckBox().getState() || !passwordPiccolo.contains(String.valueOf(caratterePiccolo)))
                this.password += carattere;
            else if(passwordPiccolo.contains(String.valueOf(caratterePiccolo)))
                continue;
        }
    }
    
}

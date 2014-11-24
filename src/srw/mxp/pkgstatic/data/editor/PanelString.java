/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelString.java
 *
 * Created on 08-ago-2014, 19:32:06
 */

package srw.mxp.pkgstatic.data.editor;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonatan
 */
public class PanelString extends javax.swing.JPanel {

    boolean sjis = true;
    String font_encoding = "MS932";

    /** Creates new form PanelString */
    public PanelString() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNumber = new javax.swing.JLabel();
        scrollText = new javax.swing.JScrollPane();
        textareaContent = new javax.swing.JTextArea();
        scrollText1 = new javax.swing.JScrollPane();
        textareaOriginal = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelNumber.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelNumber.setForeground(new java.awt.Color(51, 102, 255));
        labelNumber.setText("#000");

        textareaContent.setColumns(20);
        textareaContent.setRows(3);
        textareaContent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textareaContentKeyTyped(evt);
            }
        });
        scrollText.setViewportView(textareaContent);

        textareaOriginal.setColumns(20);
        textareaOriginal.setRows(3);
        textareaOriginal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textareaOriginalKeyTyped(evt);
            }
        });
        scrollText1.setViewportView(textareaOriginal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollText1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(scrollText, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollText1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textareaContentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textareaContentKeyTyped
        // TODO add your handling code here:
        if (sjis)
            filterKeys((javax.swing.JTextArea)evt.getComponent(), evt);
    }//GEN-LAST:event_textareaContentKeyTyped

    private void textareaOriginalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textareaOriginalKeyTyped
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_textareaOriginalKeyTyped

    public void setOriginalText(String text){
        textareaOriginal.setText(text);
    }

    public void setEditText(String text){
        textareaContent.setText(text);
    }


    public void setSJIS(boolean enabled){
        sjis = enabled;
    }


    public String getEditText(){
        return textareaContent.getText();
    }


    public void setID(int id){
        labelNumber.setText("#" + get3Digits(id));
    }


    private String get3Digits(int num){
        String result = "";

        if (num > 99){
            result += num;
        }
        else if (num > 9){
            result += "0" + num;
        }
        else{
            result += "00" + num;
        }

        return result;
    }


    // Changes your typed character in JTextArea t to its SJIS version
    public void filterKeys(javax.swing.JTextArea t, java.awt.event.KeyEvent e){
        char original_char = e.getKeyChar();
        boolean change = false;

        byte[] sjis_char = charToSJIS(original_char);
        if (sjis_char[0] != 0)
            change = true;

        if (change){
            try {
                t.replaceSelection(""); // Cleans the selected text
                e.consume();
                int pos = t.getCaretPosition();
                String text = t.getText();
                String new_char = new String(sjis_char, font_encoding);
                //System.out.println("caret: " + pos + " length: " + text.length());
                if (pos == 0)
                    text = new_char + t.getText();
                else if (pos == text.length())
                    text = t.getText() + new_char;
                else
                    text = text.substring(0, pos) + new_char + text.substring(pos, text.length());
                //String text = textfieldTest.getText() + new String(sjis_char, "Shift-JIS");
                t.setText(text);
                t.setCaretPosition(pos + 1);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(PanelString.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public byte[] charToSJIS(char c){
        /*
            0 = 48 -> 82 4f
            9 = 57 -> 82 58

            A = 65 -> 82 60
            Z = 90 -> 82 79

            a = 97 -> 82 81
            z = 122 -> 82 9a

            space -> 81 40
            , -> 81 41
            . -> 81 42
         */
        byte[] Jap_char = new byte[2];
        Jap_char[0] = (byte) 0x82;
        if (c >= 'a' && c <= 'z'){
            Jap_char[1] = (byte) 0x81;
            Jap_char[1] += c - 'a';
        }
        else if (c >= 'A' && c <= 'Z'){
            Jap_char[1] = (byte) 0x60;
            Jap_char[1] += c - 'A';
        }
        else if (c >= '0' && c <= '9'){
            Jap_char[1] = (byte) 0x4f;
            Jap_char[1] += c - '0';
        }
        else{ // Check if it's a special character
            int code = c;
            Jap_char[0] = (byte) 0x81;
            switch (code){
                case 32: // space = 32 -> 81 40
                    Jap_char[1] = (byte) 0x40;
                    break;
                case 33: // ! = 33 -> 81 49
                    Jap_char[1] = (byte) 0x49;
                    break;
                case 34: // " = 34 -> 81 8d
                    Jap_char[1] = (byte) 0x8d;
                    break;
                case 35: // # = 35 -> 81 94
                    Jap_char[1] = (byte) 0x94;
                    break;
                case 37: // % = 37 -> 81 93
                    Jap_char[1] = (byte) 0x93;
                    break;
                case 38: // & = 38 -> 81 95
                    Jap_char[1] = (byte) 0x95;
                    break;
                case 39: // ' = 39 -> 81 8c
                    Jap_char[1] = (byte) 0x8c;
                    break;
                case 40: // ( = 40 -> 81 7a
                    Jap_char[1] = (byte) 0x7a;
                    break;
                case 41: // ) = 41 -> 81 7b
                    Jap_char[1] = (byte) 0x7b;
                    break;
                case 42: // * = 42 -> 81 96
                    Jap_char[1] = (byte) 0x7b;
                    break;
                case 43: // + = 43 -> 81 7b
                    Jap_char[1] = (byte) 0x7b;
                    break;
                case 44: // , = 44 -> 81 43
                    Jap_char[1] = (byte) 0x43;
                    break;
                case 45: // - = 45 -> 81 7c
                    Jap_char[1] = (byte) 0x7c;
                    break;
                case 46: // . = 46 -> 81 44
                    Jap_char[1] = (byte) 0x44;
                    break;
                case 47: // / = 47 -> 81 5e
                    Jap_char[1] = (byte) 0x5e;
                    break;
                case 58: // : = 58 -> 81 46
                    Jap_char[1] = (byte) 0x46;
                    break;
                case 59: // ; = 59 -> 81 47
                    Jap_char[1] = (byte) 0x47;
                    break;
                case 60: // < = 60 -> 81 83
                    Jap_char[1] = (byte) 0x83;
                    break;
                case 61: // = = 61 -> 81 81
                    Jap_char[1] = (byte) 0x81;
                    break;
                case 62: // > = 62 -> 81 84
                    Jap_char[1] = (byte) 0x84;
                    break;
                case 63: // ? = 63 -> 81 48
                    Jap_char[1] = (byte) 0x48;
                    break;
                case 64: // @ = 64 -> 81 97
                    Jap_char[1] = (byte) 0x97;
                    break;
                default:
                    Jap_char[0] = 0;
                    Jap_char[1] = 0;
            }
        }
        return Jap_char;
    }


    public void convertToSJIS(){
        String text = textareaContent.getText();
        String newText = "";

        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            byte[] sjis_char = charToSJIS(c);

            if (sjis_char[0] != 0){
                try {
                    String new_char = new String(sjis_char, font_encoding);

                    newText += new_char;
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(PanelString.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                newText += c;
            }
        }

        textareaContent.setText(newText);
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelNumber;
    private javax.swing.JScrollPane scrollText;
    private javax.swing.JScrollPane scrollText1;
    private javax.swing.JTextArea textareaContent;
    private javax.swing.JTextArea textareaOriginal;
    // End of variables declaration//GEN-END:variables

}

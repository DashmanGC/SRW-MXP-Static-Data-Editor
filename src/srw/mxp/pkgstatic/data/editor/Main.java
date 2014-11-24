/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srw.mxp.pkgstatic.data.editor;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Jonatan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
        UserInterfaceSDE UI = new UserInterfaceSDE();
        UI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        UI.setLocation(50, 50);
        //UI.setPreferredSize(new java.awt.Dimension(568, 500));
        UI.setVisible(true);
    }
    
}

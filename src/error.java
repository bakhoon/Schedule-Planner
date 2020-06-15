
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class error {
    public static void getMessage(String message){
        JOptionPane.showMessageDialog(new JFrame(), message, "Error Message", JOptionPane.ERROR_MESSAGE);
    }
}

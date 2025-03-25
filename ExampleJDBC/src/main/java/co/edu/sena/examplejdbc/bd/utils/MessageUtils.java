
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.utils;

import javax.swing.JOptionPane;

/**
 * Date: 09/10/2024
 * @author Manuel Alejandro Ocampo Saya
 * Objetive: clase para utileria de mensajes en pantalla.
 */
public class MessageUtils {
    
    public static void showInfoMessage (String message)
    {
        JOptionPane.showMessageDialog(null, message, "mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showWarningMessage (String message)
    {
        JOptionPane.showMessageDialog(null, message, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void showErrorMessage (String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.util;

import javax.swing.JOptionPane;

/**
 *
 * @author Adrián
 */
public class Message {
    
    /**
     * Muestra un mensaje de alerta
     * @param message El mensaje a ser desplegado
     */
    public static void showInfoMessage(String message) {
        showMessage(message, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Muestra un mensaje de error
     * @param message El mensaje a ser desplegado
     */
    public static void showErrorMessage(String message) {
        showMessage(message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Muestra un mensaje
     * @param message
     * @param type
     * @param messageType 
     */
    private static void showMessage(String message, String type, int messageType) {
        JOptionPane.showMessageDialog(null, message, type, messageType);
    }
    
}

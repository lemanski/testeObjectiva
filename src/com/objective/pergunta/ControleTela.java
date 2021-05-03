package com.objective.pergunta;

import javax.swing.*;

public class ControleTela extends JOptionPane {

    // Classe  que cria a tela para perguntas do jogo, como é um jogo que demanda de apenas dois tipos de tela, fiz algo bem simples...

    public static int perguntaApenasSim(String msg, String titulo, int simboloMsg){
        return showInternalConfirmDialog(null,msg,titulo,JOptionPane.DEFAULT_OPTION,simboloMsg);
    }

    public static int perguntaSimNao(String msg, String titulo){
        String t = "O prato que você pensou é " + msg + " ?";
        return showInternalConfirmDialog(null,t,titulo, JOptionPane.OK_OPTION);
    }

    public static String perguntaEntradaTextoPrato(){
        return showInputDialog("Qual prato você pensou?");
    }

    public static String perguntaEntradaTextoQualidade(String pratoInformado, String pratoAnterior){
        return showInputDialog(pratoInformado +" é ________ mas " + pratoAnterior + " não.");
    }
}

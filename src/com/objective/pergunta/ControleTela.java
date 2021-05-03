package com.objective.pergunta;

import javax.swing.*;

public class ControleTela extends JOptionPane {

    // Classe  que cria a tela para perguntas do jogo, como � um jogo que demanda de apenas dois tipos de tela, fiz algo bem simples...

    public static int perguntaApenasSim(String msg, String titulo, int simboloMsg){
        return showInternalConfirmDialog(null,msg,titulo,JOptionPane.DEFAULT_OPTION,simboloMsg);
    }

    public static int perguntaSimNao(String msg, String titulo){
        String t = "O prato que voc� pensou � " + msg + " ?";
        return showInternalConfirmDialog(null,t,titulo, JOptionPane.OK_OPTION);
    }

    public static String perguntaEntradaTextoPrato(){
        return showInputDialog("Qual prato voc� pensou?");
    }

    public static String perguntaEntradaTextoQualidade(String pratoInformado, String pratoAnterior){
        return showInputDialog(pratoInformado +" � ________ mas " + pratoAnterior + " n�o.");
    }
}

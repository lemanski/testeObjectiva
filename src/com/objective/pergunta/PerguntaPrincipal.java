package com.objective.pergunta;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PerguntaPrincipal extends JOptionPane {

    private String gameTittle = "Jogo das Adivinhações";
    private String confirm = "confirm";
    private ArrayList<PerguntaModel> caminhoSimList = new ArrayList<PerguntaModel>();
    private ArrayList<PerguntaModel> caminhoNaoList = new ArrayList<PerguntaModel>();

    public void perguntar(){
        PerguntaModel caminhoSim = new PerguntaModel("massa","lasanha");
        PerguntaModel caminhoNao = new PerguntaModel("massa","Bolo de Chocolate");
        caminhoSimList.add(caminhoSim);
        caminhoNaoList.add(caminhoNao);
        realizaPerguntas(caminhoSim, caminhoNao);
    }

    // se apertar cancelar em tudo, vai ficar a qualidade e o prato com texto "null", o exemplo esta assim tmb deixei....
    private void realizaPerguntas(PerguntaModel caminhoSim, PerguntaModel caminhoNao) {
        while(true){
            ControleTela.perguntaApenasSim("Pense em um prato que gosta",gameTittle,JOptionPane.PLAIN_MESSAGE);
            int input = ControleTela.perguntaSimNao(caminhoSim.getPrato(),confirm);// é massa?
            int resposta = perguntaPrato(input);
            validaResposta(caminhoSim, caminhoNao, resposta, input);
        }
    }

    private void validaResposta(PerguntaModel caminhoSim, PerguntaModel caminhoNao, int resposta, int input) {
        if(resposta == 0){
            ControleTela.perguntaApenasSim("Acertei de novo!",gameTittle,JOptionPane.INFORMATION_MESSAGE);
        }else{
            String prato = ControleTela.perguntaEntradaTextoPrato();
            String qualidade = ControleTela.perguntaEntradaTextoQualidade(prato , input == 0 ? caminhoSim.getPrato() : caminhoNao.getPrato());
            PerguntaModel perguntaRespondida = new PerguntaModel(prato,qualidade);
            adicionaPerguntaLista(input, perguntaRespondida);
        }
    }

    private void adicionaPerguntaLista(int input, PerguntaModel perguntaRespondida) {
        if(input == 0){
           caminhoSimList.add(perguntaRespondida);
        }else{
            caminhoNaoList.add(perguntaRespondida);
        }
    }

    private int perguntaPrato( int input) {
        int retorno = -10;
        int primeiro = 0; //mostra se advinha de primeira o prato...
        if(input == 0){
            for(PerguntaModel perg : caminhoSimList){
                retorno = verificaSeSabePrato(perg,primeiro); //perg nunca vai ser null, é adicionado no inicio uma...
                primeiro++;
            }
        }else{
            for(PerguntaModel perg : caminhoNaoList) {
                retorno = verificaSeSabePrato(perg,primeiro); //perg nunca vai ser null, é adicionado no inicio uma...
                primeiro++;
            }
        }
        return retorno;
    }

    private int verificaSeSabePrato(PerguntaModel perg, int primeiro) {
        int resposta;
        resposta = ControleTela.perguntaSimNao(perg.getQualidade(),confirm);
        if(resposta == 0 && primeiro != 0) {
            resposta = ControleTela.perguntaSimNao(perg.getPrato(),confirm);
        }
        return resposta;
    }
}

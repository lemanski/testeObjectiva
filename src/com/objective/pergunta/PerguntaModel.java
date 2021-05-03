package com.objective.pergunta;

public class PerguntaModel {

    private String prato;

    private String qualidade;

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }

    public String getPrato() {
        return prato;
    }

    public void setPrato(String prato) {
        this.prato = prato;
    }

    public PerguntaModel(String prato, String qualidade) {
        this.prato = prato;
        this.qualidade = qualidade;
    }
}

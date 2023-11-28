package animals;

import enums.TipoDieta;

public class ReptilVenenoso extends Reptil {

    // Propriedades específicas de ReptilVenenoso
    private boolean venenoso;
    private String toxicidade;

    // Construtor que recebe informações básicas e as novas propriedades venenoso e toxicidade
    public ReptilVenenoso(String nome, String especie, TipoDieta tipoDieta, String tipoReproducao, boolean venenoso, String toxicidade) {
        super(nome, especie, tipoDieta, tipoReproducao);
        this.venenoso = venenoso;
        this.toxicidade = toxicidade;
    }

    // Getter para obter o valor atual de venenoso
    public boolean isVenenoso() {
        return venenoso;
    }

    // Getter para obter o valor atual de toxicidade
    public String getToxicidade() {
        return toxicidade;
    }

    // Setter para modificar o valor de toxicidade
    public void setToxicidade(String toxicidade) {
        this.toxicidade = toxicidade;
    }

    // Sobrescreve o método toString da classe pai (Reptil)
    @Override
    public String toString() {
        // Utiliza o toString da classe pai e adiciona informações específicas de ReptilVenenoso
        return super.toString() + "\nVenenoso: " + (venenoso ? "Sim" : "Não") + "\nToxicidade: " + toxicidade;
    }
}

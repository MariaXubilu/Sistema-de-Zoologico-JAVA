package animals;

import enums.TipoDieta;

public class AnfibioVenenoso extends Anfibio {

    // Propriedades específicas de AnfibioVenenoso
    private boolean venenoso;
    private String toxicidade;

    // Construtor que recebe informações básicas e as novas propriedades venenoso e toxicidade
    public AnfibioVenenoso(String nome, String especie, TipoDieta tipoDieta, String tipoPele, boolean venenoso, String toxicidade) {
        super(nome, especie, tipoDieta, tipoPele);
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

    // Sobrescreve o método toString da classe pai (Anfibio)
    @Override
    public String toString() {
        // Utiliza o toString da classe pai e adiciona informações específicas de AnfibioVenenoso
        return super.toString() + "\nVenenoso: " + (venenoso ? "Sim" : "Não") + "\nToxicidade: " + toxicidade;
    }
}

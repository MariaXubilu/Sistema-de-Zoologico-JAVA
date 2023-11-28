package animals;

import enums.TipoDieta;

public class Anfibio extends Animal {
    
    private String tipoPele;

    // Construtor que recebe informações básicas e a nova propriedade tipoPele
    public Anfibio(String nome, String especie, TipoDieta tipoDieta, String tipoPele) {
        super(nome, especie, tipoDieta);
        this.tipoPele = tipoPele;
    }

    // Getter para obter o valor atual de tipoPele
    public String getTipoPele() {
        return tipoPele;
    }

    // Setter para modificar o valor de tipoPele
    public void setTipoPele(String tipoPele) {
        this.tipoPele = tipoPele;
    }

    // Sobrescreve o método toString da classe pai 
    @Override
    public String toString() {
        // Utiliza o toString da classe pai e adiciona informações específicas da classe Anfibio
        return super.toString() + "\nTipo de Pele: " + tipoPele;
    }
}

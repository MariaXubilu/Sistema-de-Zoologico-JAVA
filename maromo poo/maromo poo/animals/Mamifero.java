package animals;

import enums.TipoDieta;

public class Mamifero extends Animal {

    // Propriedade específica de Mamifero
    private String corPelagem;

    // Construtor que recebe informações básicas e a nova propriedade corPelagem
    public Mamifero(String nome, String especie, TipoDieta tipoDieta, String corPelagem) {
        super(nome, especie, tipoDieta);
        this.corPelagem = corPelagem;
    }

    // Getter para obter o valor atual de corPelagem
    public String getCorPelagem() {
        return corPelagem;
    }

    // Setter para modificar o valor de corPelagem
    public void setCorPelagem(String corPelagem) {
        this.corPelagem = corPelagem;
    }

    // Sobrescreve o método toString da classe pai 
    @Override
    public String toString() {
        // Utiliza o toString da classe pai e adiciona informações específicas de Mamifero
        return super.toString() + "\nCor da Pelagem: " + corPelagem;
    }
}

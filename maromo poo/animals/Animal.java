package animals;

import enums.TipoDieta;
// Classe abstrata que representa um animal genérico
public abstract class Animal {
    private String nome;
    private String especie;
    private TipoDieta tipoDieta;
// Construtor que inicializa as características básicas do animal
    public Animal(String nome, String especie, TipoDieta tipoDieta) {
        
        this.nome = nome;
        this.especie = especie;
        this.tipoDieta = tipoDieta;
    }
// Getter para obter o nome do animal
    public String getNome() {
        return nome;
    }
     // Setter para modificar o nome do animal
    public void setNome(String nome) {
        this.nome = nome;
    }
// Getter para obter especie
    public String getEspecie() {
        return especie;
    }
    // Setter para modificar o tipo de dieta do animal
    public void setTipoDieta(TipoDieta tipoDieta) {
        this.tipoDieta = tipoDieta;
    }
// Getter para obter tipo de dieta
    public TipoDieta getTipoDieta() {
        return tipoDieta;
    }
 // Sobrescreve o método toString para fornecer uma representação textual do animal
    @Override
    public String toString() {
        return "Nome: " + nome + "\nEspecie: " + especie + "\nDieta: " + tipoDieta;
    }
}

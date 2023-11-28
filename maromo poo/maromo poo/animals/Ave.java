package animals;

import enums.TipoDieta;

public class Ave extends Animal {

    // Propriedade específica de Ave
    private double envergaduraAsas;

    // Construtor que recebe informações básicas e a nova propriedade envergaduraAsas
    public Ave(String nome, String especie, TipoDieta tipoDieta, double envergaduraAsas) {
        super(nome, especie, tipoDieta);
        this.envergaduraAsas = envergaduraAsas;
    }

    // Getter para obter o valor atual de envergaduraAsas
    public double getEnvergaduraAsas() {
        return envergaduraAsas;
    }

    // Setter para modificar o valor de envergaduraAsas
    public void setEnvergaduraAsas(double envergaduraAsas) {
        this.envergaduraAsas = envergaduraAsas;
    }

    // Sobrescreve o método toString da classe pai (Animal)
    @Override
    public String toString() {
        // Utiliza o toString da classe pai e adiciona informações específicas de Ave
        return super.toString() + "\nEnvergadura das Asas: " + envergaduraAsas + " cm";
    }
}

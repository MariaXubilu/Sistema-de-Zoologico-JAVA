package zoo;

import enums.TipoDieta;
import animals.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JTextArea;

public class Zoologico {
    private List<Animal> listaAnimais;
   
 // Construtor que inicializa a lista de animais
    public Zoologico() {
        listaAnimais = new ArrayList<>();
    }
 // Lista todos os animais na console
public void listarAnimais() {
        for (Animal animal : listaAnimais) {
            System.out.println(animal);
            System.out.println("------------------------------");
        }
    }
    // Adiciona um animal à lista se ele ainda não estiver presente
    public void adicionarAnimal(Animal animal) {
        if (!listaAnimais.contains(animal)) {
            listaAnimais.add(animal);
        }
    }
// Remove um animal da lista
    public void removerAnimal(Animal animal) {
        if (listaAnimais.contains(animal)) {
            listaAnimais.remove(animal);
        } else {
            System.out.println("Erro: O animal não está na lista.");
        }
    }
     // Cria um animal com base nas entradas do usuário
    public void criarAnimalDinamicamente() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o nome do animal: ");
            String nome = scanner.nextLine();
    
            System.out.println("Digite a espécie do animal: ");
            String especie = scanner.nextLine();
    
            System.out.println("Selecione o tipo de animal (1 - Mamífero, 2 - Ave, 3 - Réptil, 4 - Anfíbio): ");
            int tipoAnimal = scanner.nextInt();
    
            switch (tipoAnimal) {
                case 1:
                    System.out.println("Digite a cor da pelagem: ");
                    String corPelagem = scanner.next();
    
                    System.out.println("Escolha o tipo de dieta (1 - Carnívoro, 2 - Herbívoro, 3 - Insetívoro): ");
                    int tipoDietaMamifero = scanner.nextInt();
                    TipoDieta tipoDietaMamiferoEscolhido = obterTipoDieta(tipoDietaMamifero);
    
                    new Mamifero(nome, especie, tipoDietaMamiferoEscolhido, corPelagem);
                    break;
    
                case 2:
                    System.out.println("Digite a envergadura das asas: ");
                    double envergaduraAsas = scanner.nextDouble();
    
                    System.out.println("Escolha o tipo de dieta (1 - Carnívoro, 2 - Herbívoro, 3 - Insetívoro): ");
                    int tipoDietaAve = scanner.nextInt();
                    TipoDieta tipoDietaAveEscolhido = obterTipoDieta(tipoDietaAve);
    
                    new Ave(nome, especie, tipoDietaAveEscolhido, envergaduraAsas);
                    break;
    
                    case 3:

    System.out.println("Digite o tipo de reprodução: ");
    String tipoReproducaoReptil = scanner.next();

    System.out.println("Escolha o tipo de dieta (1 - Carnívoro, 2 - Herbívoro, 3 - Onívoro): ");
    int tipoDietaReptil = scanner.nextInt();
    TipoDieta tipoDietaReptilEscolhido = obterTipoDieta(tipoDietaReptil);

    System.out.println("O réptil é venenoso? (true/false): ");
    boolean venenoso = scanner.nextBoolean();

    if (venenoso) {
        System.out.println("Digite a toxicidade do veneno (baixa, média, alta): ");
        String toxicidade = scanner.next();

        ReptilVenenoso reptilVenenoso = new ReptilVenenoso(nome, especie, tipoDietaReptilEscolhido, tipoReproducaoReptil, venenoso, toxicidade);
        listaAnimais.add(reptilVenenoso); // Adiciona à lista
    } else {
        Reptil reptil = new Reptil(nome, especie, tipoDietaReptilEscolhido, tipoReproducaoReptil);
        listaAnimais.add(reptil); // Adiciona à lista
    }
    break;

case 4:
    System.out.println("Digite o tipo de pele: ");
    String tipoPele = scanner.next();

    System.out.println("Escolha o tipo de dieta (1 - Carnívoro, 2 - Herbívoro, 3 - Onívoro): ");
    int tipoDietaAnfibio = scanner.nextInt();
    TipoDieta tipoDietaAnfibioEscolhido = obterTipoDieta(tipoDietaAnfibio);

    System.out.println("O anfíbio é venenoso? (true/false): ");
    boolean venenosoAnfibio = scanner.nextBoolean();

    if (venenosoAnfibio) {
        System.out.println("Digite a toxicidade do veneno (baixa, média, alta): ");
        String toxicidade = scanner.next();

        AnfibioVenenoso anfibioVenenoso = new AnfibioVenenoso(nome, especie, tipoDietaAnfibioEscolhido, tipoPele, venenosoAnfibio, toxicidade);
        listaAnimais.add(anfibioVenenoso); // Adiciona à lista
    } else {
        Anfibio anfibio = new Anfibio(nome, especie, tipoDietaAnfibioEscolhido, tipoPele);
        listaAnimais.add(anfibio); // Adiciona à lista
    }
    break;

                default:
                    System.out.println("Tipo de animal inválido.");
                    break;
            }
        }
    }
    // Obtém o tipo de dieta com base na escolha do usuário
    private TipoDieta obterTipoDieta(int escolha) {
        switch (escolha) {
            case 1:
                return TipoDieta.CARNIVORO;
            case 2:
                return TipoDieta.HERBIVORO;
            case 3:
                return TipoDieta.ONIVORO;
            default:
                System.out.println("Escolha inválida. Usando Carnívoro como padrão.");
                return TipoDieta.CARNIVORO;
        }
    }
    // Remove um animal da lista com base no nome fornecido
    public boolean removerAnimal(String nomeAnimal) {
        for (Animal animal : listaAnimais) {
            if (animal.getNome().equalsIgnoreCase(nomeAnimal)) {
                listaAnimais.remove(animal);
                return true;
            }
        }
        return false;
    }
     // Verifica se um animal com o nome fornecido existe na lista
    public boolean animalExiste(String nome) {
        for (Animal animal : listaAnimais) {
            if (animal.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

     // Lista os animais ordenados por nome
   public void listarAnimaisPorNome(JTextArea areaTexto) {
    // Ordenar os animais por nome em ordem alfabética
    Collections.sort(listaAnimais, Comparator.comparing(Animal::getNome));

    for (Animal animal : listaAnimais) {
        // Adiciona as informações na interface em vez de imprimir no console
        areaTexto.append(animal.toString() + "\n------------------------------\n");
    }
}
}


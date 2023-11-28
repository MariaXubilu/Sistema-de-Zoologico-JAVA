package main;

import enums.TipoDieta;
import animals.Anfibio;
import animals.AnfibioVenenoso;
import animals.Ave;
import animals.Mamifero;
import animals.Reptil;
import animals.ReptilVenenoso;
import zoo.Zoologico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaZoologico extends JFrame {
    private Zoologico zoologico;

    // Construtor da classe que recebe um objeto Zoologico como parâmetro
    public JanelaZoologico(Zoologico zoologico) {
        this.zoologico = zoologico;

        // Configuração da janela principal
        setTitle("Zoológico");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Botões para realizar ações no zoológico
        JButton botaoListar = new JButton("Listar Animais");
        JButton botaoAdicionar = new JButton("Adicionar Animal");
        JButton botaoSair = new JButton("Sair");
        JButton botaoRemover = new JButton("Remover Animal");

        // Configuração do layout da janela
        setLayout(new FlowLayout());
        add(botaoListar);
        add(botaoAdicionar);
        add(botaoRemover);
        add(botaoSair);

        // Adiciona ação aos botões
        botaoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirListaAnimais();
            }
        });

        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarAnimalDinamicamente();
            }
        });

        botaoRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerAnimal();
            }
        });

        botaoSair.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Obrigado por visitar o Zoológico!", "Encerrando", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });
    }

    // Exibe uma lista de animais em uma nova janela
    private void exibirListaAnimais() {
        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        zoologico.listarAnimaisPorNome(areaTexto);

        if (zoologico != null) {
            JPanel panel = new JPanel(new BorderLayout());

            JScrollPane scrollPane = new JScrollPane(areaTexto);
            panel.add(scrollPane, BorderLayout.CENTER);

            JFrame frameListaAnimais = new JFrame("Lista de Animais");
            frameListaAnimais.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameListaAnimais.getContentPane().add(panel);
            frameListaAnimais.setSize(600, 300);
            frameListaAnimais.setLocationRelativeTo(null);
            frameListaAnimais.setVisible(true);
        }
    }

    // Cria um novo animal com base nas informações fornecidas pelo usuário
    private void criarAnimalDinamicamente() {
        try {
            String nome = JOptionPane.showInputDialog("Digite o nome comum do animal:");
            String especie = JOptionPane.showInputDialog("Digite a espécie do animal:");
            
            // Verifica se o animal já existe no zoológico
            if (zoologico.animalExiste(nome)) {
                JOptionPane.showMessageDialog(this, "Este animal já existe no zoológico.", "Erro", JOptionPane.ERROR_MESSAGE);
                return; // Sai do método se o animal já existe
            }
            
            String tipoAnimalStr = JOptionPane.showInputDialog("Selecione o tipo de animal (1 - Mamífero, 2 - Ave, 3 - Réptil, 4 - Anfíbio):");
            int tipoAnimal = Integer.parseInt(tipoAnimalStr);

            // Cria um novo animal com base no tipo escolhido
            switch (tipoAnimal) {
                case 1:
                    String corPelagem = JOptionPane.showInputDialog("Digite a cor da pelagem:");
                    String tipoDietaMamiferoStr = JOptionPane.showInputDialog("Escolha o tipo de dieta (1 - Carnívoro, 2 - Herbívoro, 3 - Onívoro):");
                    TipoDieta tipoDietaMamifero = obterTipoDieta(Integer.parseInt(tipoDietaMamiferoStr));

                    zoologico.adicionarAnimal(new Mamifero(nome, especie, tipoDietaMamifero, corPelagem));
                    break;
                case 2:
                    double envergaduraAsas;
                    do {
                        try {
                            String input = JOptionPane.showInputDialog("Digite a envergadura das asas:");
                            if (input == null) {
                                // O usuário pressionou Cancelar ou fechou a janela
                                return; // Sai do método ou encerra o programa, dependendo do contexto
                            }

                            envergaduraAsas = Double.parseDouble(input);

                            if (envergaduraAsas <= 0) {
                                JOptionPane.showMessageDialog(null, "A envergadura das asas deve ser um número positivo.", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Entrada inválida. Certifique-se de inserir um número.", "Erro", JOptionPane.ERROR_MESSAGE);
                            envergaduraAsas = -1; // Define um valor inválido para forçar a repetição do loop
                        }
                    } while (envergaduraAsas <= 0);
                    // O valor de envergaduraAsas agora é válido e pode ser usado

                    String tipoDietaAveStr = JOptionPane.showInputDialog("Escolha o tipo de dieta (1 - Carnívoro, 2 - Herbívoro, 3 - Onívoro):");
                    TipoDieta tipoDietaAve = obterTipoDieta(Integer.parseInt(tipoDietaAveStr));

                    zoologico.adicionarAnimal(new Ave(nome, especie, tipoDietaAve, envergaduraAsas));
                    break;

                case 3:

                    String tipoReproducaoReptil = JOptionPane.showInputDialog("Digite o tipo de reprodução:");
                    int tipoDietaReptil = Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo de dieta (1 - Carnívoro, 2 - Herbívoro, 3 - Onívoro):"));
                    TipoDieta tipoDietaReptilEscolhido = obterTipoDieta(tipoDietaReptil);

                    int opcaoVenenoso = JOptionPane.showConfirmDialog(null, "O réptil é venenoso?", "Selecione", JOptionPane.YES_NO_OPTION);
                    boolean venenoso = opcaoVenenoso == JOptionPane.YES_OPTION;

                    if (venenoso) {
                        String toxicidade = JOptionPane.showInputDialog("Digite a toxicidade do veneno (baixa, média, alta):");
                        zoologico.adicionarAnimal(new ReptilVenenoso(nome, especie, tipoDietaReptilEscolhido, tipoReproducaoReptil, venenoso, toxicidade));
                    } else {
                        zoologico.adicionarAnimal(new Reptil(nome, especie, tipoDietaReptilEscolhido, tipoReproducaoReptil));
                    }
                    break;

                case 4:

                    String tipoPele = JOptionPane.showInputDialog("Digite o tipo de pele:");
                    int tipoDietaAnfibio = Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo de dieta (1 - Carnívoro, 2 - Herbívoro, 3 - Onívoro):"));
                    TipoDieta tipoDietaAnfibioEscolhido = obterTipoDieta(tipoDietaAnfibio);

                    int opcaoVenenosoAnfibio = JOptionPane.showConfirmDialog(null, "O anfíbio é venenoso?", "Selecione", JOptionPane.YES_NO_OPTION);
                    boolean venenosoAnfibio = opcaoVenenosoAnfibio == JOptionPane.YES_OPTION;

                    if (venenosoAnfibio) {
                        String toxicidade = JOptionPane.showInputDialog("Digite a toxicidade do veneno (baixa, média, alta):");
                        zoologico.adicionarAnimal(new AnfibioVenenoso(nome, especie, tipoDietaAnfibioEscolhido, tipoPele, venenosoAnfibio, toxicidade));
                    } else {
                        zoologico.adicionarAnimal(new Anfibio(nome, especie, tipoDietaAnfibioEscolhido, tipoPele));
                    }
                    break;
            }

            JOptionPane.showMessageDialog(this, "Animal adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Entrada inválida. Certifique-se de inserir um animal.", "Erro", JOptionPane.ERROR_MESSAGE);
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
                throw new IllegalArgumentException("Escolha de dieta inválida.");
        }
    }

    // Remove um animal com base no nome fornecido pelo usuário
    private void removerAnimal() {
        String nomeAnimal = JOptionPane.showInputDialog(this, "Digite o nome do animal a ser removido:", "Remover Animal", JOptionPane.QUESTION_MESSAGE);

        if (nomeAnimal != null) {
            boolean removido = zoologico.removerAnimal(nomeAnimal);
            if (removido) {
                JOptionPane.showMessageDialog(this, "Animal removido com sucesso!", "Remover Animal", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Animal não encontrado na lista.", "Remover Animal", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    // Método principal que cria um Zoologico, adiciona alguns animais e exibe a janela principal
    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico();

        zoologico.adicionarAnimal(new Mamifero("Leão", "Panthera leo", TipoDieta.CARNIVORO, "Amarelo dourado"));
        zoologico.adicionarAnimal(new Ave("Harpia", "Harpia harpyja", TipoDieta.CARNIVORO, 105));
        zoologico.adicionarAnimal(new Reptil("Dragão Barbudo", "Pogona vitticeps", TipoDieta.ONIVORO, "Ovíparo"));
        zoologico.adicionarAnimal(new Anfibio("Axolote", "Ambystoma mexicanum", TipoDieta.CARNIVORO, "Lisa"));
        zoologico.adicionarAnimal(new ReptilVenenoso("Jararaca", "Bothrops jararaca", TipoDieta.CARNIVORO, "Vivípara", true, "Alta"));
        zoologico.adicionarAnimal(new AnfibioVenenoso("Rã flecha-dourada", "Phyllobates terribilis", TipoDieta.CARNIVORO, "Lisa", true, "Alta"));

        JanelaZoologico janelaZoologico = new JanelaZoologico(zoologico);
        janelaZoologico.setVisible(true);
    }
}

import java.util.ArrayList;
import java.util.Scanner;

class Disciplina {
    private String nomeDisciplina;
    private int periodo;
    private double[] medias;
    private double frequencia;

    // Construtor
    public Disciplina(String nomeDisciplina, int periodo, double[] medias, double frequencia) {
        if (medias.length > 2) {
            throw new IllegalArgumentException("O array 'medias' deve conter no máximo 2 elementos.");
        }
        if (frequencia < 0 || frequencia > 100) {
            throw new IllegalArgumentException("A frequência deve estar entre 0% e o 100%.");
        }
        this.nomeDisciplina = nomeDisciplina;
        this.periodo = periodo;
        this.medias = medias;
        this.frequencia = frequencia;
    }

    // Getters e Setters

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public int getPeriodo() {
        return periodo;
    }

    public double[] getMedias() {
        return medias;
    }

    public void setMedias(int bimestre, double novaMedia) {
        if (bimestre >= 0 && bimestre < medias.length) {
            medias[bimestre] = novaMedia;
        } else {
            System.out.println("Bimestre inválido.");
        }
    }

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }
}
    // Criando a classe Aluno
class Aluno {
    private int matricula;
    private String nome;
    private String telefone;
    private String email;
    private String nascimento;
    private ArrayList<Disciplina> disciplinas;
    

    // Construtor da classe Aluno, toda vez que houver uma alteração, passará por esse construtor, que irá atribuir o novo parâmetro
public Aluno(int matricula, String nome, String telefone, String email, String nascimento, ArrayList<Disciplina> disciplinas) {
    this.matricula = matricula;
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
    this.nascimento = nascimento;
    this.disciplinas = disciplinas;
}
    // Getters e Setters para cada atributo
public ArrayList<Disciplina> getDisciplinas() {
    return disciplinas;
}
public int getMatricula() {
    return matricula;
}

public String getNome() {
    return nome;
}

public String getTelefone() {
    return telefone;
}

public String getEmail() {
    return email;
}

public String getNascimento() {
    return nascimento;
}

}

public class App {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ArrayList<Aluno> alunos = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\nOlá, seja bem vindo ao Painel do Professor!" 
            + "\nPor gentileza, digite o número de uma das opções:"
            + "\n1 - Cadastrar Aluno e Disciplinas"
            + "\n2 - Pesquisa"
            + "\n3 - Alterar"
            + "\n4 - Excluir"
            + "\n-1 - Sair\n");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:

                    System.out.println("Informe os seguintes dados para efetuar o cadastro do Aluno:");
                    System.out.println("\n\tNome completo:\n");
                    input.nextLine();
                    String nome = input.nextLine();
                    System.out.println("\n\tMatrícula:\n");
                    int matricula = input.nextInt();
                    System.out.println("\n\tTelefone (xx) xxxxx-xxxx :\n");  
                    input.nextLine();                  
                    String telefone = input.nextLine();
                    System.out.println("\n\tEmail (exemplo@teste.com):\n");
                    String email = input.nextLine();
                    System.out.println("\n\tData de Nascimento (dd/mm/aaaa):\n");
                    String nascimento = input.nextLine();
                    System.out.println("\n\tQuantas disciplinas você deseja adicionar?");
                    int qtdDisciplinas = input.nextInt();

                    ArrayList<Disciplina> disciplinasAluno = new ArrayList<>();

                    for (int i = 0; i < qtdDisciplinas; i++) {
                        System.out.println("\nInforme os seguintes dados para efetuar o cadastro das Disciplinas deste Aluno:");
                        System.out.println("\n\tNome da disciplina:\n");
                        input.nextLine();
                        String nomeDisciplina = input.nextLine();
                        System.out.println("\n\tPeríodo:\n");
                        int periodo = input.nextInt();

                        System.out.println("\n\tMédia primeiro bimestre (0-10):");
                        double media1 = input.nextDouble();
                        boolean controleMedia1 = false;
                        while (!controleMedia1) {
                            if (media1 >= 0 && media1 <= 10) {
                                controleMedia1 = true;
                            } else {
                                System.out.println("\nFrequência inválida. Por favor, informe um número entre 0 e 100.");
                                media1 = Double.parseDouble(input.next());
                            }
                        }

                        System.out.println("\n\tMédia segundo bimestre (0-10):");
                        double media2 = input.nextDouble();
                        boolean controleMedia2 = false;
                        while (!controleMedia2) {
                            if (media2 >= 0 && media2 <= 10) {
                                controleMedia2 = true;
                            } else {
                                System.out.println("\nFrequência inválida. Por favor, informe um número entre 0 e 100.");
                                media2 = Double.parseDouble(input.next());
                            }
                        }

                        double[] medias = {media1, media2};

                        System.out.println("\n\tFrequência (Informe apenas os caracteres numéricos) (0-100):");
                        double frequencia = Double.parseDouble(input.next());
                        boolean controleFrequencia = false;
                        while (!controleFrequencia) {
                            if (frequencia >= 0 && frequencia <= 100) {
                                controleFrequencia = true;
                            } else {
                                System.out.println("\nFrequência inválida. Por favor, informe um número entre 0 e 100.");
                                frequencia = Double.parseDouble(input.next());
                            }
                        }

                        Disciplina disciplinaNova = new Disciplina(nomeDisciplina, periodo, medias, frequencia);
                        disciplinasAluno.add(disciplinaNova);
                    }

                    Aluno alunoNovo = new Aluno(matricula, nome, telefone, email, nascimento, disciplinasAluno);
                    alunos.add(alunoNovo);

                    break;
                case 2:

                    System.out.println("\n\tInforme a matricula do aluno que você gostaria de consultar o histórico:\n");
                    int matriculaPesquisar = input.nextInt();
                    boolean alunoEncontrado = false; // Variável de controle

                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula() == matriculaPesquisar) {
                            int idAluno = i;
                            alunoEncontrado = true; // Aluno encontrado
                            
                            System.out.printf("%-25s %-30s %-25s %-35s %-25s%n", "Matricula", "Nome", "Telefone", "E-mail", "Data de Nascimento"); 
                            // % => indica que terá uma formatação
                            // - =-> indica que estará alinhado a esquerda, sem isso, ficaria como padrão a direita
                            // 25 => indica o tamanho de caracteres pre-adicionados, se a string for menor, completa de espaço em branco, e se for maior, não corta a string
                            // s => indica que é uma string, d é para int e f é para float e double
                            // %n => quebra a linha
                            System.out.printf("%-25d %-30s %-25s %-35s %-25s%n%n", alunos.get(idAluno).getMatricula(), alunos.get(idAluno).getNome(), alunos.get(idAluno).getTelefone(), alunos.get(idAluno).getEmail(), alunos.get(idAluno).getNascimento()); 
                            StringBuilder tracos = new StringBuilder();
                            for (int k = 0; k < 140; k++) {
                                tracos.append("-");
                            }
                    
                            System.out.println(tracos.toString());

                            System.out.printf("%-20s %-20d %-20.2f %-20.2f %-20.2f %-20.2f %-20s%n%n", "Disciplina", "Periodo", "Média 1°B", "Média 2°", "Frequencia", "Média Final", "Situação"); 
                            for (int m = 0; m < alunos.get(idAluno).getDisciplinas().size(); m++) {
                                double mediaFinal = (alunos.get(idAluno).getDisciplinas().get(m).getMedias()[0] + alunos.get(idAluno).getDisciplinas().get(m).getMedias()[1]) / 2;
                                String situacao;
                                if (mediaFinal >= 6 && alunos.get(idAluno).getDisciplinas().get(m).getFrequencia() >= 75) {
                                    situacao = "Aprovado";
                                } else {
                                    situacao = "Reprovado";
                                }
                                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s%n%n", alunos.get(idAluno).getDisciplinas().get(m).getNomeDisciplina(), alunos.get(idAluno).getDisciplinas().get(m).getPeriodo(), alunos.get(idAluno).getDisciplinas().get(m).getMedias()[0], alunos.get(idAluno).getDisciplinas().get(m).getMedias()[1], alunos.get(idAluno).getDisciplinas().get(m).getFrequencia(), mediaFinal, situacao); 
                                System.out.println(tracos.toString());
                            }
                            break;
                        }
                    }
                    
                    if (!alunoEncontrado) {
                        alunoEncontrado = false;
                        System.out.println("\nAluno não encontrado.");
                    }
                    break; // Garante que saiu

                case 3:

                    System.out.println("\n\tInforme a matricula do aluno que você gostaria de alterar uma informação:\n");
                    int matriculaAlterar = input.nextInt();
                    alunoEncontrado = false; // Variável de controle

                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula() == matriculaAlterar) {
                            int idAluno = i;
                            alunoEncontrado = true; // Aluno encontrado
                            System.out.println("\n\tInforme qual dado do aluno " + alunos.get(idAluno).getNome() + " você gostaria de alterar:\n"
                                    + "1- Média do primeiro bimestre\n"
                                    + "2- Média do segundo bimestre\n"
                                    + "3- Frequência\n");
                            int opcaoAlterar = input.nextInt();
                            System.out.println("\n\tDisciplinas disponíveis:");
                            for (int j = 0; j < alunos.get(idAluno).getDisciplinas().size(); j++) {
                                System.out.println("\n\t" + j + " - " + alunos.get(idAluno).getDisciplinas().get(j).getNomeDisciplina());
                            }
                            System.out.println("\n\tInforme a disciplina desejada (digite o número da disciplina):");
                            int disciplinaAlterar = input.nextInt();
                    
                            // Realize as alterações com base na opção
                            switch (opcaoAlterar) {
                                case 1:
                                    System.out.println("Informe a nova média do primeiro bimestre:");
                                    double novaMedia1 = input.nextDouble();
                                    alunos.get(idAluno).getDisciplinas().get(disciplinaAlterar).setMedias(0, novaMedia1);
                                    break;
                                case 2:
                                    System.out.println("Informe a nova média do segundo bimestre:");
                                    double novaMedia2 = input.nextDouble();
                                    alunos.get(idAluno).getDisciplinas().get(disciplinaAlterar).setMedias(1, novaMedia2);
                                    break;
                                case 3:
                                    System.out.println("Informe a nova frequência:");
                                    double novaFrequencia = input.nextDouble();
                                    alunos.get(idAluno).getDisciplinas().get(disciplinaAlterar).setFrequencia(novaFrequencia); // Exemplo de alteração
                                    break;
                                default:
                                    System.out.println("Opção inválida.");
                            }
                            break; // Sai do loop ao encontrar o aluno e realizar a alteração
                        }
                    }
                    
                    if (!alunoEncontrado) {
                        alunoEncontrado = false;
                        System.out.println("\nAluno não encontrado.");
                    }

                    break; // Garante que saiu
                case 4:

                    System.out.println("\n\tInforme a matricula do aluno que você gostaria de alterar uma informação:\n");
                    int matriculaExcluir = input.nextInt();
                    alunoEncontrado = false; // Variável de controle

                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula() == matriculaExcluir) {
                            int idAluno = i;
                            alunoEncontrado = true; // Aluno encontrado
                            System.out.println("\n\tVocê está excluindo o cadastro do aluno: " + alunos.get(idAluno).getNome() + ". Selecione uma das seguintes opções para prosseguir:\n"
                                    + "1- Confirmar\n"
                                    + "2- Cancelar\n");
                            int opcaoExcluir = input.nextInt();
                            
                            switch (opcaoExcluir) {
                                case 1:
                                    System.out.println("Aluno excluido!");
                                    alunos.remove(idAluno);
                                    break;
                                case 2:
                                    System.out.println("Operação cancelada!");
                                    break;
                                default:
                                    System.out.println("Opção inválida.");
                            }
                            break;
                        }
                    }
                    
                    if (!alunoEncontrado) {
                        alunoEncontrado = false;
                        System.out.println("\nAluno não encontrado.");
                    }
                    break; // Garante que saiu

                case -1:

                    System.out.println("\nPrograma encerrado!");

                    break;
                default:

                    System.out.println("\nOpção inválida. Tente novamente.\n");
            }
        } while (opcao != -1);

        input.close();
    }
}

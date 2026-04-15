import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public void menu() {

        int escolha = 0;
        ArrayList<Cadastro> lista = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        do {

            System.out.println("\n1. Cadastro do usuario");
            System.out.println("2. Lista de usuarios cadastrados");
            System.out.println("3. Sair\n");

            escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha) {

                case 1:
                    ValidadorDeCpf validador = new ValidadorDeCpf();
                    Cadastro cadastro1 = new Cadastro();

                    System.out.println("Escreva o nome do usuario: ");
                    String nome = scan.nextLine();
                    cadastro1.setNome(nome);

                    System.out.println("Escreva o cpf do usuario: ");
                    String cpf = scan.nextLine();
                    if (ValidadorDeCpf.isCPFValido(cpf)) {
                        cadastro1.setCpf(cpf);
                    } else {
                        System.out.println("CPF inválido! Cadastro cancelado.");
                        break;
                    }

                    System.out.println("Escreva o numero de cadastro: ");

                    cadastro1.setNumeroDeCadastro(lista.size());

                    scan.nextLine();

                    System.out.println("\nTipo de usuario(vip ou normal)");
                    String tipo = scan.nextLine();
                    cadastro1.setTipo(tipo);


                    lista.add(cadastro1);

                    System.out.println(
                            "Usuário cadastrado: " +
                                    cadastro1.getNome() +
                                    " | CPF: " + cadastro1.getCpf() +
                                    " | Número: " + cadastro1.getNumeroDeCadastro() +
                                    " | Tipo: " + cadastro1.getTipo()
                    );

                    break;

                case 2:
                    System.out.println("\n--- LISTA DE USUÁRIOS ---");

                    if (lista.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        for (Cadastro usuario : lista) {
                            System.out.println(
                                    "Nome: " + usuario.getNome() +
                                            " | CPF: " + usuario.getCpf() +
                                            " | Número: " + usuario.getNumeroDeCadastro() +
                                            " | Tipo: " + usuario.getTipo()
                            );
                        }
                    }

                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        } while (escolha != 3);
    }
}
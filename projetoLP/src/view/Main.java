package view;

import model.FormaPagamento;
import model.TipoInternacao;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final String ARQUIVO = "hospital.ser";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Hospital hospital = Hospital.carregarHospital(ARQUIVO);

        if (hospital == null) {
            hospital = new Hospital();
            System.out.println("Novo sistema iniciado.");
        } else {
            System.out.println("Sistema carregado.");
        }

        int opcao;

        do {
            System.out.println("\n===== SISTEMA HOSPITALAR =====");
            System.out.println("1 - Cadastrar Paciente");
            System.out.println("2 - Listar Pacientes");
            System.out.println("3 - Cadastrar Médico");
            System.out.println("4 - Listar Médicos");
            System.out.println("5 - Registrar Internação");
            System.out.println("6 - Listar Internações");
            System.out.println("7 - Dar Alta (FINALIZAR INTERNAÇÃO)"); // NOVO
            System.out.println("8 - Registrar Pagamento");
            System.out.println("9 - Listar Pagamentos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();

                    if (hospital.cadastrarPaciente(nome, cpf, idade)) {
                        System.out.println("Paciente cadastrado!");
                    } else {
                        System.out.println("Paciente já existe.");
                    }
                    break;

                case 2:
                    hospital.listarPacientes();
                    break;

                case 3:
                    System.out.print("Nome do médico: \n");
                    String nomeMedico = scanner.nextLine();

                    System.out.println("Especialidade: ");
                    String especialidade = scanner.nextLine();

                    System.out.print("CRM: ");
                    String crm = scanner.nextLine();

                    if (hospital.cadastrarMedico(nomeMedico, especialidade, crm)) {
                        System.out.println("Médico cadastrado!");
                    } else {
                        System.out.println("Médico já existe.");
                    }
                    break;

                case 4:
                    hospital.listarMedicos();
                    break;

                case 5:
                    System.out.print("CPF do paciente: ");
                    String cpfInt = scanner.nextLine();

                    System.out.print("CRM do médico: ");
                    String crmInt = scanner.nextLine();

                    System.out.println("Tipo (1-ENFERMARIA, 2-APARTAMENTO, 3-UTI): ");
                    int tipoOp = scanner.nextInt();
                    scanner.nextLine();

                    TipoInternacao tipo = switch (tipoOp) {
                        case 1 -> TipoInternacao.ENFERMARIA;
                        case 2 -> TipoInternacao.APARTAMENTO;
                        case 3 -> TipoInternacao.UTI;
                        default -> null;
                    };

                    System.out.print("Local: ");
                    String local = scanner.nextLine();

                    if (tipo != null) {
                        hospital.registrarInternacao(cpfInt, crmInt, tipo, local);
                        System.out.println("Internação registrada!");
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 6:
                    hospital.listarInternacoes();
                    break;

                case 7:
                    System.out.print("ID da internação: ");
                    String idAlta = scanner.nextLine();

                    if (hospital.darAlta(idAlta, LocalDate.now())) {
                        System.out.println("Alta realizada com sucesso!");
                    } else {
                        System.out.println("Internação não encontrada.");
                    }
                    break;

                case 8:
                    System.out.print("ID da internação: ");
                    String idInternacao = scanner.nextLine();

                    System.out.println("Forma (1-PIX, 2-DINHEIRO, 3-CARTAO, 4-PARCELADO): ");
                    int formaOp = scanner.nextInt();
                    scanner.nextLine();

                    FormaPagamento forma = switch (formaOp) {
                        case 1 -> FormaPagamento.PIX;
                        case 2 -> FormaPagamento.DINHEIRO;
                        case 3 -> FormaPagamento.CARTAO;
                        case 4 -> FormaPagamento.PARCELADO;
                        default -> null;
                    };

                    if (forma != null) {
                        hospital.registrarPagamento(idInternacao, forma);
                        System.out.println("Pagamento registrado!");
                    } else {
                        System.out.println("Forma inválida.");
                    }
                    break;

                case 9:
                    hospital.listarPagamentos();
                    break;

                case 0:
                    hospital.salvarHospital(ARQUIVO);
                    System.out.println("Sistema salvo. Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
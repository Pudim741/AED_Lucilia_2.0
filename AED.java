import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class EAD {

    // ============================================================
    // [NOVO] RF1 - CADASTRO: salva um contato no arquivo cadastro.txt
    // ============================================================
    static void cadastrarContato(Scanner sc) {
        sc.nextLine(); // limpa buffer
        System.out.print("Digite o nome do contato: ");
        String nome = sc.nextLine().trim();
        System.out.print("Digite o telefone do contato: ");
        String telefone = sc.nextLine().trim();

        try {
            FileWriter fw = new FileWriter("cadastro.txt", true); // true = append
            fw.write(nome + ";" + telefone + "\n");
            fw.close();
            System.out.println("Contato cadastrado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar contato: " + e.getMessage());
        }
    }

    // ============================================================
    // [NOVO] RF2 - LISTAGEM: lê e exibe todos os contatos do arquivo
    // ============================================================
    static void listarContatos() {
        System.out.println("\n===== LISTA DE CONTATOS =====");
        try {
            BufferedReader br = new BufferedReader(new FileReader("cadastro.txt"));
            String linha;
            int count = 1;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 2) {
                    System.out.println(count + ". Nome: " + partes[0] + " | Telefone: " + partes[1]);
                    count++;
                }
            }
            br.close();
            if (count == 1) {
                System.out.println("Nenhum contato cadastrado.");
            }
        } catch (IOException e) {
            System.out.println("Nenhum contato encontrado ou erro ao ler arquivo.");
        }
        System.out.println("=============================\n");
    }

    // ============================================================
    // [NOVO] RF3 - BUSCA: procura contato pelo nome no arquivo
    // ============================================================
    static void buscarContato(Scanner sc) {
        sc.nextLine(); // limpa buffer
        System.out.print("Digite o nome para buscar: ");
        String busca = sc.nextLine().trim().toLowerCase();
        boolean encontrou = false;

        System.out.println("\n===== RESULTADO DA BUSCA =====");
        try {
            BufferedReader br = new BufferedReader(new FileReader("cadastro.txt"));
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 2 && partes[0].toLowerCase().contains(busca)) {
                    System.out.println("Nome: " + partes[0] + " | Telefone: " + partes[1]);
                    encontrou = true;
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao buscar contato: " + e.getMessage());
        }

        if (!encontrou) {
            System.out.println("Nenhum contato encontrado com o nome informado.");
        }
        System.out.println("==============================\n");
    }

    // ============================================================
    // MAIN - menu principal (original preservado + novo submenu)
    // ============================================================
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean verificarOpcao = true;
        String[][] matriz_trimestre1 = {
            {"Confraternizacao Universal", "(01 de janeiro)", "Feliz Confraternizacao Universal! Que a energia deste recomeco renove nossas esperancas e nos de forcas para construir um ano incrivel, "},
            {"Carnaval", "(16 e 17 de fevereiro)", "Feliz Carnaval! E tempo de espalhar alegria, recarregar as energias e celebrar a vida com leveza, "},
            {"Quarta-feira de Cinzas", "(18 de fevereiro)", "Feliz Quarta-feira de Cinzas! Um momento perfeito para silenciar a mente, refletir com gratidao e renovar os nossos propositos, "},
            {"Dia Internacional da Mulher", "(08 de marco)", "Feliz Dia Internacional da Mulher! Hoje celebramos a forca, a determinacao e o impacto de mulheres que transformam o mundo todos os dias, "},
        };
        String[][] matriz_trimestre2 = {
            {"Sexta-feira Santa", "(03 de abril)", "Feliz Sexta-feira Santa! Um dia de respeito, paz interior e profunda reflexao sobre o amor que nos une, "},
            {"Pascoa", "(05 de abril)", "Feliz Pascoa! Que o dia de hoje traga um sentimento real de renovacao, amor e esperanca para todos, "},
            {"Tiradentes", "(21 de abril)", "Feliz Tiradentes! Dia de lembrar que grandes ideais e a busca por liberdade sempre deixam um legado eterno, "},
            {"Dia do Trabalhador", "(01 de maio)", "Feliz Dia do Trabalhador! Nossa homenagem a quem dedica o seu melhor todos os dias para construir um futuro mais forte, "},
            {"Dia das Maes", "(10 de maio)", "Feliz Dia das Maes! Celebrando hoje o amor mais puro, protetor e inspirador que existe no mundo, "},
            {"Corpus Christi", "(04 de junho)", "Feliz Corpus Christi! Um momento de fortalecer a nossa fe, semear a paz e agradecer pelas bencaos do caminho, "},
            {"Dia dos Namorados", "(12 de junho)", "Feliz Dia dos Namorados! Que o respeito, a cumplicidade e o carinho guiem sempre as nossas melhores conexoes, "}
        };
        String[][] matriz_trimestre3 = {
            {"Dia do amigo", "(20 de julho)", "Feliz Dia do amigo! A vida fica muito mais bonita quando compartilhamos a jornada com quem caminha ao nosso lado, "},
            {"Dia dos Pais", "(09 de agosto)", "Feliz Dia dos Pais! Uma homenagem a quem e porto seguro, exemplo de dedicacao e base para toda a vida, "},
            {"Independencia do Brasil", "(07 de setembro)", "Feliz Independencia do Brasil! Dia de renovar o orgulho pela nossa terra e o compromisso de construir um futuro melhor juntos, "}
        };
        String[][] matriz_trimestre4 = {
            {"Dia das Criancas", "(12 de outubro)", "Feliz Dia das Criancas! Que a pureza, o sorriso sincero e a imaginacao das criancas nos lembrem de viver com mais leveza, "},
            {"Finados", "(02 de novembro)", "Feliz Finados! Dia de honrar a memoria e manter vivo no coracao o amor por quem sempre fara parte de nos, "},
            {"Proclamacao da Republica", "(15 de novembro)", "Feliz Proclamacao da Republica! Celebrando o poder da uniao e a nossa voz na construcao de um amanha mais justo, "},
            {"Dia da Consciencia Negra", "(20 de novembro)", "Feliz Dia da Consciencia Negra! Um momento essencial para valorizar a nossa historia, nossa cultura e a luta continua por igualdade, "},
            {"Natal", "(25 de dezembro)", "Feliz Natal! Que a luz desta data ilumine nossos lares e encha nossas vidas de paz, gratidao e harmonia, "},
            {"Vespera de Ano-Novo", "(31 de dezembro)", "Feliz ano novo! Olhamos para tras com gratidao e abrimos os bracos para as infinitas possibilidades que estao chegando, "}
        };
        String[] Vetor_mensagem_casual = {
            "Bom dia! Que seu dia seja cheio de energia positiva e realizacoes, ",
            "Boa tarde! Que sua tarde seja produtiva e cheia de boas surpresas, ",
            "Boa noite! Que sua noite seja tranquila e cheia de paz, "
        };
        String[] Vetor_segunda_mensagem = {
            "que a presenca do Criador guie nossos passos, trazendo discernimento para cada escolha e cobrindo nossa jornada com ricas bencaos de protecao.",
            "a verdadeira paz nasce de um coracao grato e cheio de fe. Que a nossa espiritualidade seja sempre o farol a iluminar os dias mais dificeis.",
            "unidos em proposito e oracao, fortalecemos nossos lacos e encontramos forcas na palavra divina para superar qualquer desafio que surja no caminho.",
            "que o amor ao proximo e a compaixao sejam a base de todas as nossas acoes, refletindo a luz e os ensinamentos sagrados em nossas vidas.",
            "em momentos de silencio e reflexao, conseguimos ouvir a voz da sabedoria divina que nos acalma, nos acolhe e direciona nossos pensamentos para o bem.",
            "a fe nao torna as coisas mais faceis, mas nos da a certeza de que nunca estamos sozinhos na caminhada. Que o Criador abencoe profundamente este grupo.",
            "cultivar pensamentos positivos e manter a confianca nos planos divinos e o segredo para viver com mais leveza, harmonia e serenidade no coracao.",
            "que a bondade, a paciencia e a caridade guiem nossa convivencia, transformando este espaco em um reflexo de paz e mutua edificacao espiritual.",
            "a espiritualidade nos lembra da importancia de desacelerar, agradecer pelo dom da vida e reconhecer os pequenos milagres que acontecem diariamente.",
            "que a luz da esperanca nunca se apague em nossos coracoes e que a confianca na providencia divina renove as nossas forcas a cada amanhecer."
        };
        int seg_mensagem_escolhida;
        String mensagem_final = null;

        while (verificarOpcao) {
            verificarOpcao = false;
            System.out.println("Bem vindo ao programa de mensagens de otimismo!\n" +
                "-----Escolha uma das Opcoes:----- \n" +
                "1 = Datas Especiais \n" +
                "2 = Mensagem Casual \n" +
                "3 = Aniversario De alguem\n" +
                // [NOVO] opcoes do menu de contatos
                "4 = Cadastrar Contato\n" +
                "5 = Listar Contatos\n" +
                "6 = Buscar Contato"
            );
            int opcao = sc.nextInt();

            if (opcao == 1) {
                int dia;
                System.out.println("-----Digite o numero do trimestre:-----\n" +
                    "1 = 1o Trimestre (Janeiro, Fevereiro e Marco) \n" +
                    "2 = 2o Trimestre (Abril, Maio e Junho) \n" +
                    "3 = 3o Trimestre (Julho, Agosto e Setembro) \n" +
                    "4 = 4o Trimestre (Outubro, Novembro e Dezembro)");
                int trimestre = sc.nextInt();
                switch (trimestre) {
                    case 1:
                        do {
                            System.out.println("<O trimestre escolhido foi o 1o Trimestre, composto pelos meses de Janeiro, Fevereiro e Marco.>");
                            System.out.println("-----Escolha a data:-----");
                            for (int i = 0; i < matriz_trimestre1.length; i++) {
                                System.out.println((i + 1) + " = " + matriz_trimestre1[i][0] + " " + matriz_trimestre1[i][1]);
                            }
                            dia = sc.nextInt();
                            switch (dia) {
                                case 1:
                                    System.out.println("A data escolhida e: Confraternizacao Universal (01 de janeiro)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre1[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 2:
                                    System.out.println("A data escolhida e: Carnaval (16 e 17 de fevereiro)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre1[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 3:
                                    System.out.println("A data escolhida e: Quarta-feira de Cinzas (18 de fevereiro)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre1[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 4:
                                    System.out.println("A data escolhida e: Dia Internacional da Mulher (08 de marco)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre1[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                default:
                                    System.out.println("Data invalida. Por favor, escolha um numero entre 1 e 4.");
                            }
                        } while (dia < 1 || dia > 4);
                        break;
                    case 2:
                        do {
                            System.out.print("<O trimestre escolhido foi o 2o Trimestre, composto pelos meses de Abril, Maio e Junho.>");
                            System.out.println("-----Escolha a data:-----");
                            for (int i = 0; i < matriz_trimestre2.length; i++) {
                                System.out.println((i + 1) + " = " + matriz_trimestre2[i][0] + " " + matriz_trimestre2[i][1]);
                            }
                            dia = sc.nextInt();
                            switch (dia) {
                                case 1:
                                    System.out.println("A data escolhida e: Sexta-feira Santa (03 de abril)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre2[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 2:
                                    System.out.println("A data escolhida e: Pascoa (05 de abril)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre2[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 3:
                                    System.out.println("A data escolhida e: Tiradentes (21 de abril)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre2[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 4:
                                    System.out.println("A data escolhida e: Dia do Trabalhador (01 de maio)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre2[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 5:
                                    System.out.println("A data escolhida e: Dia das Maes (10 de maio)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre2[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 6:
                                    System.out.println("A data escolhida e: Corpus Christi (04 de junho)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre2[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 7:
                                    System.out.println("A data escolhida e: Dia dos Namorados (12 de junho)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre2[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                default:
                                    System.out.println("Data invalida. Por favor, escolha um numero entre 1 a 7.");
                            }
                        } while (dia < 1 || dia > 7);
                        break;
                    case 3:
                        do {
                            System.out.print("<O trimestre escolhido foi o 3o Trimestre, composto pelos meses de Julho, Agosto e Setembro.>");
                            System.out.println("-----Escolha a data:-----");
                            for (int i = 0; i < matriz_trimestre3.length; i++) {
                                System.out.println((i + 1) + " = " + matriz_trimestre3[i][0] + " " + matriz_trimestre3[i][1]);
                            }
                            dia = sc.nextInt();
                            switch (dia) {
                                case 1:
                                    System.out.println("A data escolhida e: Dia do amigo (20 de julho)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre3[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 2:
                                    System.out.println("A data escolhida e: Dia dos Pais (09 de agosto)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre3[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 3:
                                    System.out.println("A data escolhida e: Independencia do Brasil (07 de setembro)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre3[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                default:
                                    System.out.println("Data invalida. Por favor, escolha um numero entre 1 a 3.");
                            }
                        } while (dia < 1 || dia > 3);
                        break;
                    case 4:
                        do {
                            System.out.print("<O trimestre escolhido foi o 4o Trimestre, composto pelos meses de Outubro, Novembro e Dezembro.>");
                            System.out.println("-----Escolha a data:-----");
                            for (int i = 0; i < matriz_trimestre4.length; i++) {
                                System.out.println((i + 1) + " = " + matriz_trimestre4[i][0] + " " + matriz_trimestre4[i][1]);
                            }
                            dia = sc.nextInt();
                            switch (dia) {
                                case 1:
                                    System.out.println("A data escolhida e: Dia das Criancas (12 de outubro)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre4[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 2:
                                    System.out.println("A data escolhida e: Finados (02 de novembro)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre4[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 3:
                                    System.out.println("A data escolhida e: Proclamacao da Republica (15 de novembro)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre4[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 4:
                                    System.out.println("A data escolhida e: Dia da Consciencia Negra (20 de novembro)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre4[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 5:
                                    System.out.println("A data escolhida e: Natal (25 de dezembro)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre4[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 6:
                                    System.out.println("A data escolhida e: Vespera de Ano-Novo (31 de dezembro)");
                                    do {
                                        System.out.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                                    mensagem_final = matriz_trimestre4[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                default:
                                    System.out.println("Data invalida. Por favor, escolha um numero entre 1 a 6.");
                            }
                        } while (dia < 1 || dia > 6);
                        break;
                    default:
                        System.out.println("Trimestre invalido. Por favor, escolha um numero entre 1 a 4.");
                }
            } else if (opcao == 2) {
                int parteDoDia;
                do {
                    System.out.println("A opcao escolhida e mensagem casual." +
                        "\n-----Escolha a parte do dia:-----" +
                        "\n1 = Manha" +
                        "\n2 = Tarde" +
                        "\n3 = Noite"
                    );
                    parteDoDia = sc.nextInt();
                    switch (parteDoDia) {
                        case 1:
                            System.out.println("A Parte do dia escolhida e: Manha");
                            do {
                                System.out.println("-----Escolha a continuacao da mensagem:-----");
                                for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                    System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                }
                                seg_mensagem_escolhida = sc.nextInt();
                            } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                            mensagem_final = Vetor_mensagem_casual[parteDoDia - 1] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                            break;
                        case 2:
                            System.out.println("A Parte do dia escolhida e: Tarde");
                            do {
                                System.out.println("-----Escolha a continuacao da mensagem:-----");
                                for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                    System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                }
                                seg_mensagem_escolhida = sc.nextInt();
                            } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                            mensagem_final = Vetor_mensagem_casual[parteDoDia - 1] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                            break;
                        case 3:
                            System.out.println("A Parte do dia escolhida e: Noite");
                            do {
                                System.out.println("-----Escolha a continuacao da mensagem:-----");
                                for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                    System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                }
                                seg_mensagem_escolhida = sc.nextInt();
                            } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                            mensagem_final = Vetor_mensagem_casual[parteDoDia - 1] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                            break;
                        default:
                            verificarOpcao = true;
                            System.out.println("Parte do dia invalida. Por favor, escolha um numero entre 1 a 3.");
                    }
                } while (parteDoDia < 1 || parteDoDia > 3);
            } else if (opcao == 3) {
                String Nome;
                do {
                    System.out.println("A opcao escolhida e mensagem de aniversario, Digite o nome do aniversariante:");
                    Nome = sc.next();
                } while (Nome.trim().isEmpty());
                System.out.println("A mensagem escolhida e: \"Feliz aniversario, " + Nome + "! Que seu dia seja repleto de alegria e amor.\"");
                do {
                    System.out.println("-----Escolha a continuacao da mensagem:-----");
                    for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                        System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                    }
                    seg_mensagem_escolhida = sc.nextInt();
                } while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10);
                mensagem_final = "Feliz aniversario, " + Nome + "! Que seu dia seja repleto de alegria e amor. " + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];

            // ============================================================
            // [NOVO] RF1 - opcao 4: Cadastrar Contato
            // ============================================================
            } else if (opcao == 4) {
                cadastrarContato(sc);
                verificarOpcao = true; // volta ao menu

            // ============================================================
            // [NOVO] RF2 - opcao 5: Listar Contatos
            // ============================================================
            } else if (opcao == 5) {
                listarContatos();
                verificarOpcao = true; // volta ao menu

            // ============================================================
            // [NOVO] RF3 - opcao 6: Buscar Contato
            // ============================================================
            } else if (opcao == 6) {
                buscarContato(sc);
                verificarOpcao = true; // volta ao menu

            } else {
                verificarOpcao = true;
                System.out.println("Opcao invalida. Por favor, escolha um numero entre 1 a 6.");
            }
        }

        // [NOVO] RF4 - alem de exibir, salva a mensagem final gerada em historico.txt
        if (mensagem_final != null) {
            System.out.println("Mensagem final: " + mensagem_final);
            try {
                FileWriter fw = new FileWriter("historico.txt", true);
                fw.write(mensagem_final + "\n");
                fw.close();
                System.out.println("[Mensagem salva em historico.txt]");
            } catch (IOException e) {
                System.out.println("Erro ao salvar historico: " + e.getMessage());
            }
        }
    }
}

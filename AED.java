import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AED {

    // Caminho do arquivo onde os dados serão armazenados
    static final String ARQUIVO_DADOS = "dados.txt";

    // Requisito 1: Cadastrar dados em arquivo .txt
    static void cadastrarDado(String dado) {
        try (FileWriter fw = new FileWriter(ARQUIVO_DADOS, true)) {
            fw.write(dado + System.lineSeparator());
            System.out.println("Dado cadastrado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao cadastrar dado: " + e.getMessage());
        }
    }

    // Requisito 2: Listar dados armazenados no arquivo .txt
    static void listarDados() {
        File arquivo = new File(ARQUIVO_DADOS);
        if (!arquivo.exists()) {
            System.out.println("Nenhum dado cadastrado ainda.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            int contador = 1;
            System.out.println("-----Lista de dados cadastrados:-----");
            boolean vazio = true;
            while ((linha = br.readLine()) != null) {
                System.out.println(contador + " - " + linha);
                contador++;
                vazio = false;
            }
            if (vazio) {
                System.out.println("Nenhum dado cadastrado ainda.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler dados: " + e.getMessage());
        }
    }

    // Requisito 3: Buscar dados no arquivo .txt
    static void buscarDados(String termo) {
        File arquivo = new File(ARQUIVO_DADOS);
        if (!arquivo.exists()) {
            System.out.println("Nenhum dado cadastrado ainda.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean encontrado = false;
            System.out.println("-----Resultado da busca por: \"" + termo + "\"-----");
            while ((linha = br.readLine()) != null) {
                if (linha.toLowerCase().contains(termo.toLowerCase())) {
                    System.out.println("Encontrado: " + linha);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Nenhum dado encontrado com o termo informado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao buscar dados: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean verificarOpcao = true;
        String[][] matriz_trimestre1 = {
            {"Confraternização Universal", "(01 de janeiro)", "Feliz Confraternização Universal! Que a energia deste recomeço renove nossas esperanças e nos dê forças para construir um ano incrível, "},
            {"Carnaval", "(16 e 17 de fevereiro)", "Feliz Carnaval! É tempo de espalhar alegria, recarregar as energias e celebrar a vida com leveza, "},
            {"Quarta-feira de Cinzas", "(18 de fevereiro)", "Feliz Quarta-feira de Cinzas! Um momento perfeito para silenciar a mente, refletir com gratidao e renovar os nossos propósitos, "},
            {"Dia Internacional da Mulher", "(08 de março)", "Feliz Dia Internacional da Mulher! Hoje celebramos a força, a determinação e o impacto de mulheres que transformam o mundo todos os dias, "},
        };
        String[][] matriz_trimestre2 = {
            {"Sexta-feira Santa", "(03 de abril)", "Feliz Sexta-feira Santa! Um dia de respeito, paz interior e profunda reflexão sobre o amor que nos une, "},
            {"Páscoa", "(05 de abril)", "Feliz Páscoa! Que o dia de hoje traga um sentimento real de renovaçao, amor e esperança para todos, "},
            {"Tiradentes", "(21 de abril)", "Feliz Tiradentes! Dia de lembrar que grandes ideais e a busca por liberdade sempre deixam um legado eterno, "},
            {"Dia do Trabalhador", "(01 de maio)", "Feliz Dia do Trabalhador! Nossa homenagem a quem dedica o seu melhor todos os dias para construir um futuro mais forte, "},
            {"Dia das Maes", "(10 de maio)", "Feliz Dia das Maes! Celebrando hoje o amor mais puro, protetor e inspirador que existe no mundo, "},
            {"Corpus Christi", "(04 de junho)", "Feliz Corpus Christi! Um momento de fortalecer a nossa fé, semear a paz e agradecer pelas bênçaos do caminho, "},
            {"Dia dos Namorados", "(12 de junho)", "Feliz Dia dos Namorados! Que o respeito, a cumplicidade e o carinho guiem sempre as nossas melhores conexoes, "}
        };
        String[][] matriz_trimestre3 = {
            {"Dia do amigo", "(20 de julho)", "Feliz Dia do amigo! A vida fica muito mais bonita quando compartilhamos a jornada com quem caminha ao nosso lado, "},
            {"Dia dos Pais", "(09 de agosto)", "Feliz Dia dos Pais! Uma homenagem a quem é porto seguro, exemplo de dedicaçao e base para toda a vida, "},
            {"Independência do Brasil", "(07 de setembro)", "Feliz Independência do Brasil! Dia de renovar o orgulho pela nossa terra e o compromisso de construir um futuro melhor juntos, "}
        };
        String[][] matriz_trimestre4 = {
            {"Dia das Criancas", "(12 de outubro)", "Feliz Dia das Criancas! Que a pureza, o sorriso sincero e a imaginaçao das crianças nos lembrem de viver com mais leveza, "},
            {"Finados", "(02 de novembro)", "Feliz Finados! Dia de honrar a memória e manter vivo no coraçao o amor por quem sempre fará parte de nós, "},
            {"Proclamação da Republica", "(15 de novembro)", "Feliz Proclamação da Republica! Celebrando o poder da uniao e a nossa voz na construção de um amanha mais justo, "},
            {"Dia da Consciencia Negra", "(20 de novembro)", "Feliz Dia da Consciencia Negra! Um momento essencial para valorizar a nossa história, nossa cultura e a luta contínua por igualdade, "},
            {"Natal", "(25 de dezembro)", "Feliz Natal! Que a luz desta data ilumine nossos lares e encha nossas vidas de paz, gratidao e harmonia, "},
            {"Vespera de Ano-Novo", "(31 de dezembro)", "Feliz ano novo! Olhamos para trás com gratidao e abrimos os braços para as infinitas possibilidades que estão chegando, "}
        };
        String[] Vetor_mensagem_casual = {
            "Bom dia! Que seu dia seja cheio de energia positiva e realizações, ",
            "Boa tarde! Que sua tarde seja produtiva e cheia de boas surpresas, ",
            "Boa noite! Que sua noite seja tranquila e cheia de paz, "
        };
        String[] Vetor_segunda_mensagem = {
            "que a presença do Criador guie nossos passos, trazendo discernimento para cada escolha e cobrindo nossa jornada com ricas bênçaos de proteçao.",
            "a verdadeira paz nasce de um coraçao grato e cheio de fé. Que a nossa espiritualidade seja sempre o farol a iluminar os dias mais difíceis.",
            "unidos em propósito e oraçao, fortalecemos nossos laços e encontramos forças na palavra divina para superar qualquer desafio que surja no caminho.",
            "que o amor ao próximo e a compaixão sejam a base de todas as nossas açoes, refletindo a luz e os ensinamentos sagrados em nossas vidas.",
            "em momentos de silêncio e reflexao, conseguimos ouvir a voz da sabedoria divina que nos acalma, nos acolhe e direciona nossos pensamentos para o bem.",
            "a fé nao torna as coisas mais fáceis, mas nos dá a certeza de que nunca estamos sozinhos na caminhada. Que o Criador abençoe profundamente este grupo.",
            "cultivar pensamentos positivos e manter a confiança nos planos divinos é o segredo para viver com mais leveza, harmonia e serenidade no coraçao.",
            "que a bondade, a paciência e a caridade guiem nossa convivência, transformando este espaço em um reflexo de paz e mútua edificação espiritual.",
            "a espiritualidade nos lembra da importância de desacelerar, agradecer pelo dom da vida e reconhecer os pequenos milagres que acontecem diariamente.",
            "que a luz da esperança nunca se apague em nossos coraçoes e que a confiança na providência divina renove as nossas forças a cada amanhecer."
        };
        int seg_mensagem_escolhida;
        String mensagem_final = null;
        while (verificarOpcao) {
            verificarOpcao = false; // Reinicia o loop para permitir que o usuário escolha novamente
            System.out.println("Bem vindo ao programa de mensagens de otimismo!\n" +
                "-----Escolha uma das Opcoes:----- \n" +
                "1 = Datas Especiais \n" +
                "2 = Mensagem Casual \n" +
                "3 = Aniversário De alguem \n" +
                "4 = Cadastrar dado \n" +
                "5 = Listar dados \n" +
                "6 = Buscar dado"
            );
            int opcao = sc.nextInt();
            
            // Exibe as opções de trimestres para o usuário
            if (opcao == 1) {
                // Exibe as opções de trimestres para o usuário
                int dia;
                System.out.println("-----Digite o numero do trimestre:-----\n" +
                    "1 = 1º Trimestre (Janeiro, Fevereiro e Marco) \n" +
                    "2 = 2º Trimestre (Abril, Maio e Junho) \n" +
                    "3 = 3º Trimestre (Julho, Agosto e Setembro) \n" +
                    "4 = 4º Trimestre (Outubro, Novembro e Dezembro)");
                int trimestre = sc.nextInt();
                switch (trimestre) {
                    case 1:
                        do {
                            System.out.println("<O trimestre escolhido foi o 1º Trimestre, composto pelos meses de Janeiro, Fevereiro e Março.>");
                            System.err.println("-----Escolha a data:-----");
                            for (int i = 0; i < matriz_trimestre1.length; i++) {
                                System.out.println((i + 1) + " = " + matriz_trimestre1[i][0] + " " + matriz_trimestre1[i][1]);
                            }
                            dia = sc.nextInt();
                            switch (dia) {
                                case 1:
                                    System.out.println("A data escolhida é: Confraternização Universal (01 de janeiro)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre1[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 2:
                                    System.out.println("A data escolhida é: Carnaval (16 e 17 de fevereiro)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre1[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 3:
                                    System.out.println("A data escolhida é: Quarta-feira de Cinzas (18 de fevereiro)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre1[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 4:
                                    System.out.println("A data escolhida é: Dia Internacional da Mulher (08 de março)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre1[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                default:
                                    System.out.println("Data inválida. Por favor, escolha um número entre 1 e 5.");
                            }
                        } while (dia < 1 || dia > 5); // Continua solicitando até que uma data válida seja escolhida
                        break;
                    case 2:
                        do{
                            System.out.print("<O trimestre escolhido foi o 2º Trimestre, composto pelos meses de Abril, Maio e Junho.>");
                            System.err.println("-----Escolha a data:-----");
                            for (int i = 0; i < matriz_trimestre2.length; i++) {
                                System.out.println((i + 1) + " = " + matriz_trimestre2[i][0] + " " + matriz_trimestre2[i][1]);
                            }
                            dia = sc.nextInt();
                            switch (dia) {
                                case 1:
                                    System.out.println("A data escolhida é: Sexta-feira Santa (03 de abril)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre2[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 2:
                                    System.out.println("A data escolhida é: Páscoa (05 de abril)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre2[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 3:
                                    System.out.println("A data escolhida é: Tiradentes (21 de abril)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre2[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 4:
                                    System.out.println("A data escolhida é: Dia do Trabalhador (01 de maio)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre2[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 5:
                                    System.out.println("A data escolhida é: Dia das Mães (10 de maio)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre2[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 6:
                                    System.out.println("A data escolhida é: Corpus Christi (04 de junho)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre2[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 7:
                                    System.out.println("A data escolhida é: Dia dos Namorados (12 de junho)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre2[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                default:
                                    System.out.println("Data inválida. Por favor, escolha um número entre 1 a 7.");
                            }
                        } while (dia < 1 || dia > 7); // Continua solicitando até que uma data válida seja escolhida
                        break;
                    case 3:
                        do {
                            System.out.print("<O trimestre escolhido foi o 3º Trimestre, composto pelos meses de Julho, Agosto e Setembro.>");
                            System.err.println("-----Escolha a data:-----");
                            for (int i = 0; i < matriz_trimestre3.length; i++) {
                                System.out.println((i + 1) + " = " + matriz_trimestre3[i][0] + " " + matriz_trimestre3[i][1]);
                            }
                            dia = sc.nextInt();
                            switch (dia) {
                                case 1:
                                    System.out.println("A data escolhida é: Dia do amigo (20 de julho)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre3[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 2:
                                    System.out.println("A data escolhida é: Dia dos Pais (09 de agosto)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre3[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 3:
                                    System.out.println("A data escolhida é: Independência do Brasil (07 de setembro)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre3[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                default:
                                    System.out.println("Data inválida. Por favor, escolha um número entre 1 a 3.");
                                    break;
                            }
                        } while (dia < 1 || dia > 4); // Continua solicitando até que uma data válida seja escolhida
                        break;
                    case 4:
                        do{
                            System.out.print("<O trimestre escolhido foi o 4º Trimestre, composto pelos meses de Outubro, Novembro e Dezembro.>");
                            System.err.println("-----Escolha a data:-----");
                            for (int i = 0; i < matriz_trimestre4.length; i++) {
                                System.out.println((i + 1) + " = " + matriz_trimestre4[i][0] + " " + matriz_trimestre4[i][1]);
                            }
                            dia = sc.nextInt();
                            switch (dia) {
                                case 1:
                                    System.out.println("A data escolhida é: Dia das Crianças (12 de outubro)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre4[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 2:
                                    System.out.println("A data escolhida é: Finados (02 de novembro)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida}
                                    mensagem_final = matriz_trimestre4[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 3:
                                    System.out.println("A data escolhida é: Proclamação da República (15 de novembro)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre4[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 4:
                                    System.out.println("A data escolhida é: Dia da Consciência Negra (20 de novembro)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre4[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 5:
                                    System.out.println("A data escolhida é: Natal (25 de dezembro)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre4[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                case 6:
                                    System.out.println("A data escolhida é: Véspera de Ano-Novo (31 de dezembro)");
                                    do{
                                        System.err.println("-----Escolha a continuacao da mensagem:-----");
                                        for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                            System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                        }
                                        seg_mensagem_escolhida = sc.nextInt();
                                    }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                                    mensagem_final = matriz_trimestre4[dia - 1][2] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                                    break;
                                default:
                                    System.out.println("Data inválida. Por favor, escolha um número entre 1 a 6.");
                            }
                        } while (dia < 1 || dia > 6); // Continua solicitando até que uma data válida seja escolhida
                        break;
                    default:
                        System.out.println("Trimestre inválido. Por favor, escolha um número entre 1 a 4.");
                }
            } else if (opcao == 2) {
                // Exibe as opções de partes do dia para o usuário
                int parteDoDia;
                do {
                    System.out.println("A opção escolhida é mensagem casual." + 
                    "\n-----Escolha a parte do dia:-----" +
                        "\n1 = Manhã" +
                        "\n2 = Tarde" +
                        "\n3 = Noite"
                    );
                    
                    parteDoDia = sc.nextInt();
                    switch (parteDoDia) {
                        case 1:
                            System.out.println("A Parte do dia escolhida é: Manhã");
                            do{
                                System.err.println("-----Escolha a continuacao da mensagem:-----");
                                for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                    System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                }
                                seg_mensagem_escolhida = sc.nextInt();
                            }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                            mensagem_final = Vetor_mensagem_casual[parteDoDia - 1] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                            break;
                        case 2:
                            System.out.println("A Parte do dia escolhida é: Tarde");
                            do{
                                System.err.println("-----Escolha a continuacao da mensagem:-----");
                                for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                    System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                }
                                seg_mensagem_escolhida = sc.nextInt();
                            }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                            mensagem_final = Vetor_mensagem_casual[parteDoDia - 1] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                            break;
                        case 3:
                            System.out.println("A Parte do dia escolhida é: Noite");
                            do{
                                System.err.println("-----Escolha a continuacao da mensagem:-----");
                                for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                                    System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                                }
                                seg_mensagem_escolhida = sc.nextInt();
                            }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                            mensagem_final = Vetor_mensagem_casual[parteDoDia - 1] + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
                            break;
                        default:
                            verificarOpcao = true; // Reinicia o loop para permitir que o usuário escolha novamente
                            System.out.println("Parte do dia inválida. Por favor, escolha um número entre 1 a 3.");
                    }
                } while (parteDoDia < 1 || parteDoDia > 3); // Continua solicitando até que uma parte do dia válida seja escolhida
            } else if (opcao == 3) {
                // Exibe a opção de mensagem de aniversário para o usuário
                String Nome;
                do{
                    System.out.println("A opção escolhida é mensagem de aniversário, Digite o nome do aniversariante:");
                    Nome = sc.next();
                } while (Nome.trim().isEmpty()); // Continua solicitando até que um nome válido seja digitado
                System.out.println("A mensagem escolhida é: \"Feliz aniversário, " + Nome + "! Que seu dia seja repleto de alegria e amor.\"");
                do{
                    System.err.println("-----Escolha a continuacao da mensagem:-----");
                    for (int i = 0; i < Vetor_segunda_mensagem.length; i++) {
                        System.out.println((i + 1) + " = " + Vetor_segunda_mensagem[i]);
                    }
                    seg_mensagem_escolhida = sc.nextInt();
                }while (seg_mensagem_escolhida < 1 || seg_mensagem_escolhida > 10); // Continua solicitando até que uma mensagem válida seja escolhida
                mensagem_final = "Feliz aniversário, " + Nome + "! Que seu dia seja repleto de alegria e amor. " + Vetor_segunda_mensagem[seg_mensagem_escolhida - 1];
            } else if (opcao == 4) {
                // Requisito 1: Cadastrar dado
                System.out.println("A opção escolhida é cadastrar dado.");
                System.out.println("Digite o dado que deseja cadastrar:");
                sc.nextLine(); // limpa o buffer
                String novoDado = sc.nextLine();
                cadastrarDado(novoDado);
                verificarOpcao = true;
            } else if (opcao == 5) {
                // Requisito 2: Listar dados
                listarDados();
                verificarOpcao = true;
            } else if (opcao == 6) {
                // Requisito 3: Buscar dados
                System.out.println("Digite o termo que deseja buscar:");
                sc.nextLine(); // limpa o buffer
                String termoBusca = sc.nextLine();
                buscarDados(termoBusca);
                verificarOpcao = true;
            } else {
                verificarOpcao = true; // Reinicia o loop para permitir que o usuário escolha novamente
                System.out.println("Opção inválida. Por favor, escolha um número entre 1 a 6.");
            }
        }
        if (mensagem_final != null) {
            System.out.println("Mensagem final: " + mensagem_final);
        }
    }
}
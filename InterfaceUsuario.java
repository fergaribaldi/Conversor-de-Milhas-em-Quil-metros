import java.util.Scanner;

public class InterfaceUsuario {
    
    /**
     * Scanner para leitura de entrada do usuário
     */
    private Scanner scanner;
    
    /**
     * Serviço de conversão para realizar os cálculos
     */
    private ConversorService conversor;
    
    /**
     * Construtor - inicializa os componentes necessários
     */
    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
        this.conversor = new ConversorService();
    }
    
    /**
     * Inicia a aplicação - método principal da interface
     */
    public void iniciar() {
        exibirCabecalho();
        executarMenuPrincipal();
    }
    
    /**
     * Exibe o cabeçalho da aplicação
     */
    private void exibirCabecalho() {
        System.out.println("=========================================");
        System.out.println("   🚀 CONVERSOR MILHAS ⇄ QUILÔMETROS");
        System.out.println("=========================================");
        System.out.println("📍 1 milha = " + conversor.getFatorConversao() + " quilômetros");
    }
    
    /**
     * Controla o loop principal do menu
     */
    private void executarMenuPrincipal() {
        int opcao;
        
        do {
            exibirMenu();
            opcao = lerOpcaoMenu();
            processarOpcaoMenu(opcao);
        } while (opcao != 3);
        
        encerrarAplicacao();
    }
    
    /**
     * Exibe as opções do menu principal
     */
    private void exibirMenu() {
        System.out.println("\n📋 MENU PRINCIPAL:");
        System.out.println("1. Milhas → Quilômetros");
        System.out.println("2. Quilômetros → Milhas");
        System.out.println("3. Sair");
        System.out.print("➡️  Escolha uma opção: ");
    }
    
    /**
     * Lê e valida a opção do menu
     * @return Opção selecionada pelo usuário
     */
    private int lerOpcaoMenu() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            return opcao;
        } catch (Exception e) {
            scanner.nextLine(); // Limpa entrada inválida
            return -1; // Retorna valor inválido
        }
    }
    
    /**
     * Processa a opção selecionada no menu
     * @param opcao Opção a ser processada
     */
    private void processarOpcaoMenu(int opcao) {
        switch (opcao) {
            case 1:
                converterMilhasParaKm();
                break;
            case 2:
                converterKmParaMilhas();
                break;
            case 3:
                System.out.println("👋 Encerrando aplicação...");
                break;
            default:
                System.out.println("❌ Opção inválida! Por favor, escolha 1, 2 ou 3.");
        }
    }
    
    /**
     * Realiza conversão de milhas para quilômetros
     */
    private void converterMilhasParaKm() {
        System.out.println("\n🔄 CONVERSÃO: MILHAS → QUILÔMETROS");
        double milhas = lerValorNumerico();
        double km = conversor.converterMilhasParaKm(milhas);
        exibirResultado(milhas, "milhas", km, "quilômetros");
    }
    
    /**
     * Realiza conversão de quilômetros para milhas
     */
    private void converterKmParaMilhas() {
        System.out.println("\n🔄 CONVERSÃO: QUILÔMETROS → MILHAS");
        double km = lerValorNumerico();
        double milhas = conversor.converterKmParaMilhas(km);
        exibirResultado(km, "quilômetros", milhas, "milhas");
    }
    
    /**
     * Lê e valida um valor numérico do usuário
     * @return Valor numérico válido
     */
    private double lerValorNumerico() {
        while (true) {
            try {
                System.out.print("📏 Digite a distância: ");
                double valor = scanner.nextDouble();
                scanner.nextLine(); // Limpa o buffer
                
                if (valor < 0) {
                    System.out.println("❌ Erro: A distância não pode ser negativa!");
                    continue;
                }
                
                return valor;
                
            } catch (Exception e) {
                System.out.println("❌ Erro: Por favor, digite um número válido!");
                scanner.nextLine(); // Limpa entrada inválida
            }
        }
    }
    
    /**
     * Exibe o resultado da conversão formatado
     * @param origem Valor original
     * @param unidadeOrigem Unidade de origem
     * @param destino Valor convertido
     * @param unidadeDestino Unidade de destino
     */
    private void exibirResultado(double origem, String unidadeOrigem, 
                               double destino, String unidadeDestino) {
        System.out.println("\n✅ RESULTADO DA CONVERSÃO:");
        System.out.printf("📍 %.2f %s = %.2f %s%n", 
                         origem, unidadeOrigem, destino, unidadeDestino);
        System.out.printf("📊 Fator de conversão: 1 milha = %.5f km%n", 
                         conversor.getFatorConversao());
    }
    
    /**
     * Encerra a aplicação e libera recursos
     */
    private void encerrarAplicacao() {
        scanner.close();
        System.out.println("\n✨ Obrigado por usar o Conversor!");
        System.out.println("🎯 Programa desenvolvido com princípios SOLID");
    }
}
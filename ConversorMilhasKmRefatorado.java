public class ConversorMilhasKmRefatorado {
    
    public static void main(String[] args) {
        try {
            System.out.println("🚀 Iniciando Conversor de Milhas para Km...");
            
            // Cria e inicia a interface do usuário
            InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
            interfaceUsuario.iniciar();
            
        } catch (Exception e) {
            System.err.println("❌ Erro inesperado: " + e.getMessage());
        }
    }
}
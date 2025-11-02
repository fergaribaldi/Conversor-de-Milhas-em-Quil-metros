public class ConversorService {
    
    /**
     * Fator de conversão padrão: 1 milha = 1.60934 quilômetros
     * Declarado como final para garantir imutabilidade
     */
    
    private static final double FATOR_CONVERSAO = 1.60934;
    
    /**
     * Converte milhas para quilômetros
     * @param milhas Valor em milhas a ser convertido
     * @return Valor equivalente em quilômetros
     * @throws IllegalArgumentException Se o valor for negativo
     */
    public double converterMilhasParaKm(double milhas) {
        validarEntrada(milhas);
        return milhas * FATOR_CONVERSAO;
    }
    
    /**
     * Converte quilômetros para milhas
     * @param km Valor em quilômetros a ser convertido
     * @return Valor equivalente em milhas
     * @throws IllegalArgumentException Se o valor for negativo
     */
    public double converterKmParaMilhas(double km) {
        validarEntrada(km);
        return km / FATOR_CONVERSAO;
    }
    
    /**
     * Valida se o valor de entrada é válido (não negativo)
     * @param valor Valor a ser validado
     * @throws IllegalArgumentException Se o valor for negativo
     */
    private void validarEntrada(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo: " + valor);
        }
    }
    
    /**
     * Retorna o fator de conversão utilizado
     * @return Fator de conversão (milhas para km)
     */
    public double getFatorConversao() {
        return FATOR_CONVERSAO;
    }
} 

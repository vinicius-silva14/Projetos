public class SistemaDeCadastro {
         public static void main(String[] args) {
        Cliente cliente = new Cliente("Maria Silva", "12345678901", "Rua das Flores, 123", 3500.00);
        Data dataInicio = new Data(1, 7, 2025); // supondo que a classe Data já está corretamente implementada   
        Emprestimo emprestimo = new Emprestimo(cliente, 15000.00, 13, dataInicio);
        
        cliente.setNome("Vinicius");
        emprestimo.exibirRelatorio();
    }
        
    }
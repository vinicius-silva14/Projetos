import java.text.NumberFormat;
import java.util.Locale;
public class Cliente{
    private String nome;
    private String cpf;
    private String endereco;
    private double rendaMensal;
    /**
     * Construtor que inicializa os atributos e valida
     * 
     * @param nome Nome inserido
     * @param cpf CPF inserido
     * @param endereco Endereço inserido 
     * @param rendaMensal Renda Mensal inserida
     */
    public Cliente(String nome,String cpf,String endereco,double rendaMensal){
        if(!verificadorCPF(cpf)) throw new IllegalArgumentException("Digite somente 11 números");
        if(!verificadorString(nome)) throw new IllegalArgumentException("Digite um nome completo e válido");
        if(rendaMensal <= 0) throw new IllegalArgumentException("Renda Mensal inválida");
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.rendaMensal = rendaMensal;
    }
    /**
     * Método de cópia
     * 
     * @param outroCliente Atributos que serão copiados
     */
    public void cliente(Cliente outroCliente){
        if(!verificadorCPF(outroCliente.cpf)) throw new IllegalArgumentException("Digite somente 11 números");
        if(!verificadorString(outroCliente.nome)) throw new IllegalArgumentException("Digite um nome completo e válido");
        if(outroCliente.rendaMensal <= 0) throw new IllegalArgumentException("Renda Mensal inválida");
        this.nome = outroCliente.nome;
        this.cpf = outroCliente.cpf;
        this.endereco = outroCliente.endereco;
        this.rendaMensal = outroCliente.rendaMensal;
    }
    private ClienteListener listener;

    public void setClienteListener(ClienteListener listener) {
        this.listener = listener;
    }

    private void notificarAtualizacao() {
        if(listener != null) {
            listener.clienteAtualizado(this);
        }
    }
    /**
     * 
     * @param nome
     * @return true se for um nome com os caracteres atribuitos, false se tiver algum caracter não permitido
     * 
     */
    private boolean verificadorString(String nome){
        return nome.matches("[A-Za-zÀ-ÿ ]+");
    }
    /**
     * 
     * @param cpf
     * @return true se forem 11 números, false caso não sejam números ou não tenha exatamente 11
     */
    private boolean verificadorCPF(String cpf){
        return cpf.matches("\\d{11}");
    }
    /**
     * Método que retorna o atributo privado para outro 
     * @return nome 
     */
    public String getNome(){
        return nome;
    }
    /**
     * 
     * @return cpf
     */
    public String getCpf(){
        return cpf;
    }
    /* */
    public String getEndereco(){
        return endereco;
    }
    public double getRendaMensal(){
        return rendaMensal;
    }
    
    public void setNome(String nome){
        if(verificadorString(nome)){ 
            this.nome = nome;
            notificarAtualizacao();
        }
    }
    
    public void setCpf(String cpf){
        if(verificadorCPF(cpf)){
            this.cpf = cpf;
            notificarAtualizacao();
        }else throw new IllegalArgumentException("CPF digitado é inválido");
    }
    public void setEndereco(String endereco){  
            this.endereco = endereco; 
            notificarAtualizacao();
    }
    public void setRendaMensal(double rendaMensal){
        if(rendaMensal>0){
            this.rendaMensal = rendaMensal;
            notificarAtualizacao();
        }
    }

    public void exibirDados(){
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("Dados do Cliente.");
        System.out.println("Nome: "+getNome());
        System.out.println("CPF: "+getCpf());
        System.out.println("Endereço: "+getEndereco());
        System.out.println("Renda Mensal: "+formatador.format(getRendaMensal()));
    }
}
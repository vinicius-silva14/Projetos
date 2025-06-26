import java.text.NumberFormat;
import java.util.Locale;
public class Emprestimo implements ClienteListener{
    private Cliente cliente;
    private static final double taxaJuros = 1.02;
    private double valor;
    private double valorEmprestado;
    private double valorParcela;
    private int prazoMeses;
    private String status;
    private Data dataInicio;
    private Data dataFim;

    public Emprestimo(Cliente cliente, double valor, int prazoMeses,Data dataInicio) {
        if(valor<=0) throw new IllegalArgumentException ("Valor inválido");
        if(prazoMeses<=0) throw new IllegalArgumentException ("Prazo inválido");
        if(!dataInicio.verificaData()) throw new IllegalArgumentException ("Data inválida");
        this.cliente = cliente;
        this.cliente.setClienteListener(this);
        this.status = "Pendente";
        this.valor = valor;
        this.valorEmprestado = valor;
        this.prazoMeses = prazoMeses;
        this.dataInicio = dataInicio;
        setValor(valor);
        dataFinal();
    }
     public void clienteAtualizado(Cliente cliente) {
        avaliarStatus(); 
    }
    public Cliente getCliente() {
        return cliente;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }
    public double getValorEmprestado(){
        return valorEmprestado;
    }
    public double getValor() {
        return  valor;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public int getPrazoMeses() {
        return prazoMeses;
    }

    public String getStatus() {
        avaliarStatus();
        return status;
    }

    public Data getDataInicio() {
        return dataInicio;
    }

    public Data getDataFim() {
        return dataFim;
    }
    
    private void JurosComposto(double valor,double valorParcela,int prazoMeses){
        this.valor = valor * Math.pow(taxaJuros,prazoMeses);
        this.valorParcela = this.valor/prazoMeses;
        this.prazoMeses = prazoMeses;
    }
    public void setValor(double valor) {
        if(valor>0){
            this.valorEmprestado = valor;
            JurosComposto(valor, this.valorParcela, this.prazoMeses);
        }
    }

    public void setValorParcela(double valorParcela) {
        if(valorParcela>0) {
            JurosComposto(this.valorEmprestado, valorParcela,this.prazoMeses);
            dataFinal();
        }
    }

    public void setPrazoMeses(int prazoMeses) {
        if(prazoMeses>0) {
            JurosComposto(this.valorEmprestado,this.valorParcela, prazoMeses);
            dataFinal();
        }

    }
    public void avaliarStatus(){
        if(valorParcela<this.cliente.getRendaMensal()* 0.6) aprovarStatus();
        else rejeitarStatus();
    }
    private void aprovarStatus(){
        this.status = "Aprovado";
    }
    private void rejeitarStatus(){
        this.status = "Rejeitado";
    }
    public void setDataInicio(Data dataInicio) {
        if(dataInicio.verificaData()){
             this.dataInicio = dataInicio;
        }dataFinal();
    }

    private void dataFinal(){
        Data novaData = new Data(this.dataInicio);
        novaData.adicionarMeses(this.prazoMeses);
        this.dataFim = novaData;
    }
    public void exibirRelatorio(){
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("Dados do Cliente.");
        cliente.exibirDados();
        System.out.println("Situação do Empréstimo");
        System.out.println("Status: "+getStatus());
        if(getStatus().equals("Aprovado")){
            System.out.println("Valor Emprestado: "+formatador.format(getValorEmprestado()));
            System.out.println("Valor Total: "+formatador.format(getValor()));
            System.out.println("Valor Mensal: "+formatador.format(getValorParcela()));
            System.out.println("Data Inicio: "+getDataInicio());
            System.out.println("Data Final:  "+getDataFim());
            System.out.println("Total de meses: "+getPrazoMeses());
        }
    }
}

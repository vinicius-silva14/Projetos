public class Data {
    private int dia;
    private int mes;
    private int ano;

    /**
     * Construtor que inicializa os atributos verificando se são válidos.
     * Caso inválidos, define como 01/01/1900
     * @param dia dia inserido
     * @param mes mês inserido
     * @param ano ano inserido
     * @throws IllegalArgumentException se for uma data inválida.
     */
    public Data(int dia,int mes,int ano){
        if(verificaData(dia,mes,ano)){
            this.dia = dia;
            this.mes = mes;    
            this.ano = ano;
        }else{
            throw new IllegalArgumentException("Data inválida!");
        }
    }
    /**
     * Construtor de cópia.
     * Cria uma nova instância de Data com os mesmos valores da instância fornecida.
     * @throws IllegalArgumentException se for uma data inválida.
     */
    public Data(Data outraData){
        if(outraData == null){
        throw new IllegalArgumentException("A data fornecida não pode ser nula.");
        }
        if(!verificaData(outraData.dia,outraData.mes,outraData.ano)){
            throw new IllegalArgumentException("Data inválida!");
        }else{
            this.dia = outraData.dia;
            this.mes = outraData.mes;
            this.ano = outraData.ano;
        }
    }
    /**
     * Verifica se o ano é bissexto.
     * @param ano ano consultado.
     * @return true se o ano for bissexto, senão false.
     */
    private boolean ehBissexto(int ano){
        return(ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
    /**
     * Verifica o dia máximo de cada mês.
     * 
     * @param mes mes consultado.
     * @param ano ano consultado.
     * @return número máximo de dias do mês consultado.
     */
    private int diasNoMes(int mes,int ano){
        int dias[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(mes==2){
            if(ehBissexto(ano)){
                return 29;
            }
        }
        return dias[mes];
    }
    /**
     * Retorna o valor do atributo dia.
     * 
     * @return valor do dia.
     */
    public int getDia(){
        return this.dia;
    }
    /**
     * Retorna o valor do atributo mes.
     * 
     * @return valor do mes.
     */
    public int getMes(){
        return this.mes;
    }
   /**
     * Retorna o valor do atributo ano.
     * 
     * @return valor do ano.
     */
    public int getAno(){
        return this.ano;
    }
    /**
     * Modifica o valor do dia, se for válido.
     * 
     * @param dia novo valor de dia.
     * @throws IllegalArgumentException se o dia for inválido para o mês e ano.
     */
    public void setDia(int dia){
        if(verificaData(dia, this.mes, this.ano)) this.dia = dia;
        else throw new IllegalArgumentException("Dia inválido");
    }
    /**
     * Modifica o valor do mes, se for válido.
     * 
     * @param mes novo valor de mes.
     * @throws IllegalArgumentException se o mês for inválido.
     */
    public void setMes(int mes){
        if(verificaData(this.dia,mes, this.ano)) this.mes = mes;
        else throw new IllegalArgumentException("Mês inválido");
    }
    /**
     * Modifica o valor do ano, se for válido.
     * 
     * @param ano novo valor de ano.
     * @throws IllegalArgumentException se o ano for inválido.
     */
    public void setAno(int ano){
        if(verificaData(this.dia, this.mes,ano)) this.ano = ano;
        else throw new IllegalArgumentException("Ano inválido");
    }
     /**
     * Adiciona uma quantidade de dias a data atual.
     * Ajustando dias,meses e ano quando necessário.
     * @param dias quantidade de dias a adicionar.
     */
    public void adicionarDias(int dias){
        this.dia+= dias;
        while(this.dia > diasNoMes(this.mes,this.ano)){
            this.dia -= diasNoMes(this.mes, this.ano);
            this.mes++;
            if(this.mes > 12){ 
                this.mes = 1;
                this.ano++;
            }
        }   

    }
    /**
     * Adiciona uma quantidade de meses a data atual.
     * Ajustando dias,meses e ano quando necessário.
     * @param meses quantidade de meses a adicionar.
     * @throws IllegalArgumentException se após a adição dos meses o limite de ano(2050) for atingido.
     */
    public void adicionarMeses(int meses){
        this.mes+= meses;
        while(this.mes>12){
            this.mes-= 12;
            this.ano++;
        }
        if(this.ano>2050){
            this.ano = 2050;
            this.mes = 12;
            this.dia = 31;
            throw new IllegalArgumentException("Ano máximo atingido: 2050");
        }
        int max = diasNoMes(this.mes,this.ano);
        if(this.dia > max){
            this.dia = max;
        }
        
    }
    /**
     * Adiciona uma quantidade de anos a data atual.
     * Ajustando dias,meses e ano quando necessário.
     * @param anos quantidade de ano(s) a adicionar.
     * @throws IllegalArgumentException se após a adição dos anos o limite de ano(2050) for atingido.
     */
    public void adicionarAno(int anos){
        if(this.ano+anos>2050){
            throw new IllegalArgumentException("Ano máximo atingido: 2050");
        }
        this.ano+= anos;
        if(this.mes==2 && this.dia==29 && !ehBissexto(this.ano)){
            this.dia=28;
        }
        int max = diasNoMes(this.mes,this.ano);
        if(this.dia > max){
            this.dia = max;
        }
        
    }
    /**
     * Verifica se a data inserida é válida.
     * @param dia dia consultado.
     * @param mes mês consultado.
     * @param ano ano consultado.
     * @return true se a data for válida, senão false.
     */
    public boolean verificaData(int dia,int mes,int ano){
        if(ano>=1900 && ano<=2050 && mes>=1 && mes<=12){
            if(dia>=1 && dia<=diasNoMes(mes,ano)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    /**
     * Verifica se a data atual é válida.
     * @return true se a data for válida, senão false.
     */
    public boolean verificaData(){
        return verificaData(dia, mes, ano);
        
    }
    /**
     * Retorna a representação formatada da data.
     * @return data no formato "dd/mm/aaaa" ou mensagem de erro.
     */
    public String toString(){
        if(verificaData()){ 
            return String.format("%02d/%02d/%04d",dia,mes,ano);
        }else{
            return "Data inserida não existe";
        }
    }
}


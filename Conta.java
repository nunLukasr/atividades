public class Conta {
    private int numero;
    private double saldo;
    private double limite = 100.00;
    private double[] extrato;
    private int operacoes;
    
    public Conta(int numero, double saldoinicial){
        this.numero = numero;
        this.saldo = saldoinicial;
        this.extrato = new double[10];  
    }
    public int getNumero(){
        return numero;
    }
    public double getSaldo(){
        return (saldo + limite);
    }
    public double getLimite(){
        return limite;
    }
    
    public boolean depositar(double valor){
        if (valor > 0){
            if (limite == 100){
            saldo += valor;
            }else{
                limite += valor;
                if (limite > 100){
                    saldo = limite - 100;
                    limite = 100;
                }
            }  
            if (operacoes < extrato.length) {
                extrato[operacoes] = valor;
                operacoes++;
            }
            return true;
        } 
        return false;
    }
    
    public boolean sacar(double valor){
        if (valor > 0 && valor <= saldo + limite){
            saldo -= valor;
            if (saldo < 0){
            limite += saldo;
            saldo = 0;
            }
            if (operacoes < extrato.length) {
                extrato[operacoes] = -valor;
                operacoes++;
            }
            return true;
        }
        return false;
    }
    public boolean transferir(Conta contaDestino, double valor) {

        if (valor > 0 && valor <= saldo + limite){
            saldo -= valor;
            if (saldo < 0){
                limite += saldo;
                saldo = 0;
            }
            contaDestino.depositar(valor); 
            if (operacoes < extrato.length) {
                extrato[operacoes] = -valor;
                operacoes++;
            }
            return true;
        }
        return false;
        
}
    public double[] verExtrato(){
        for (int i = 0; i < operacoes; i++) {
        System.out.println(extrato[i]);
        }
        return extrato;
    }
    @Override
    public String toString(){
        return "Conta{numero = " + numero + ", saldo = " + saldo +", limite = " + limite +  "}" ;
    }
}

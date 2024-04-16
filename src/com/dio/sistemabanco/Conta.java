package com.dio.sistemabanco;

public abstract class Conta implements IConta {
    protected static final int AGENCI_PADRAO = 1;
    private static int sequencial = 1;


    protected int agencia;
    protected int numero;
    protected double saldo;
    protected double limiteChequeEspecial;
    protected double valorEmprestimo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCI_PADRAO;
        this.numero = sequencial++;
        this.cliente = cliente;
        this.limiteChequeEspecial = 250d;

    }

    @Override
    public void sacar(double valor) {
        if (this.saldo < valor){
            valorEmprestimo = valor - this.saldo;
            this.saldo = 0;
            if(this.limiteChequeEspecial <= 0 && this.limiteChequeEspecial < valorEmprestimo){
                System.out.println("Não tem limiti");
            }else{
                this.limiteChequeEspecial = this.limiteChequeEspecial - valorEmprestimo;
            }
        }else {
            this.saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void extrato() {
        System.out.printf("Agencia: %d", this.agencia);
        System.out.printf(" Conta: %d%n" , this.numero);
        System.out.printf("Saldo: %.2f%n" , this.saldo);
        System.out.printf("Limite do Cheque: %.2f%n" , limiteChequeEspecial);
    }
}

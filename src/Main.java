import com.dio.sistemabanco.Cliente;
import com.dio.sistemabanco.Conta;
import com.dio.sistemabanco.ContaCorrente;
import com.dio.sistemabanco.ContaPoupaca;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Michell Arantes");
        cliente.setCpf("06956948630");

        Conta cc = new ContaCorrente(cliente);
        Conta cp = new ContaPoupaca(cliente);
        //cp.depositar(150);
        cc.depositar(0);
        cc.sacar(150);
        //cc.transferir(123.50, cp);
        //cc.extrato();
        System.out.println("-------------");
        cc.extrato();
    }
}
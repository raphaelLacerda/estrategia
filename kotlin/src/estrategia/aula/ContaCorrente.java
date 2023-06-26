package estrategia.aula;

public class ContaCorrente extends Conta {

    @Override
    public void extrato() {
        System.out.println("Conta Corrente saldo é " + getSaldo());
    }
}

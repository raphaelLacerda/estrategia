package estrategia.banco;

public class ContaCorrente extends Conta {

    @Override
    public void extrato() {
        System.out.println("Conta Corrente extrato "+ super.getSaldo());
    }
}

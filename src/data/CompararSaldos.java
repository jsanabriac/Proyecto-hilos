package data;

import java.util.Comparator;

public class CompararSaldos implements Comparator<Cliente> {

    @Override
    public int compare(Cliente cliente1, Cliente cliente2) {
        if (cliente1.getSaldo() > cliente2.getSaldo()) {
            return -1;
        } else if (cliente1.getSaldo() > cliente2.getSaldo()) {
            return 0;
        } else {
            return 1;
        }
    }

}

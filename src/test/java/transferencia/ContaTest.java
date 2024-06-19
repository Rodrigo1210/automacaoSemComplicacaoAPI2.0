package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    Cliente rodrigo;
    Cliente ana;
    Conta contaRodrigo;
    Conta contaAna;

    @BeforeEach
    void setUp() {
        rodrigo = new Cliente("Rodrigo", "12345678900", "987654321");
        ana = new Cliente("Ana", "09876543210", "123456789");

        contaRodrigo = new Conta("0001", "123450", 0.00, rodrigo);
        contaAna = new Conta("1000", "543210", 2500.00, ana);
    }

    @Test
    public void realizarTransacao(){
        contaAna.realizarTransferencia(500.00, contaRodrigo);
        assertEquals(500.00, contaRodrigo.getSaldo());
        assertEquals(2000.00, contaAna.getSaldo());
    }

    @Test
    public void transacaoInvalida(){
        boolean resultado =  contaAna.realizarTransferencia(3000.00, contaRodrigo);
        assertFalse(resultado);
    }

    @Test
    public void validarInfoBancarias(){
        assertEquals("0001", contaRodrigo.getAgencia());
        assertEquals("123450", contaRodrigo.getNumeroConta());
        assertEquals(rodrigo, contaRodrigo.getProprietario());
    }

    @Test
    public void validarInfoCliente(){
        assertEquals("Rodrigo", rodrigo.getNome());
        assertEquals("12345678900", rodrigo.getCpf());
        assertEquals("987654321", rodrigo.getRg());
    }
}

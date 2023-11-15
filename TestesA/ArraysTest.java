import org.junit.*;
import org.junit.experimental.theories.suppliers.TestedOn;

import javax.management.InvalidApplicationException;
import java.util.ArrayList;
import java.util.List;

public class ArraysTest {

    private List<String> lista;

    @Before
    public void iniciarLista(){
        lista = new ArrayList<String>();
    }
    @After
    public void limparLista(){
        lista = null;
    }

    // para fazer bons testes devemos testar os 2 caminhos que o usuario pode tomar, o que o usuário acerta, o que o usuário erra.

    @Test
    public void listaEstaVaziaTeste(){
        Assert.assertTrue(lista.isEmpty());
    }

    @Test
    public void comprimentoTeste(){
        Assert.assertEquals(0, lista.size());
        lista.add("a");
        Assert.assertEquals(1, lista.size());
        lista.remove("a");
        Assert.assertEquals(0, lista.size());
    }



    @Test(expected=IndexOutOfBoundsException.class)
    public void tipoDeExceptionTeste() {
        lista.get(0);
    }

    @Test
    public void listaVerficandoMensagemErroTeste(){

        Exception t = Assert.assertThrows(IndexOutOfBoundsException.class, ()->lista.get(0));
        Assert.assertTrue(t.getMessage().contains(""));
    }

    @Test
    public void listaComparandoMensagemErroTeste(){
        Exception t = Assert.assertThrows(RuntimeException.class, ()-> lista.remove(1));
        Assert.assertEquals("Index 1 out of bounds for length 0", t.getMessage());
    }



}

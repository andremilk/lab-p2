package lp2.lab09;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
    
    private Usuario userUm;
    private Livro l;

    @Before
    public void setUp() throws Exception {
        userUm = new Usuario("Fulano", 123, 20);
        l = new Livro("Teste", true, null, null, null, 0, 100);
        l.setDataDeLocacao(new GregorianCalendar());
        userUm.alugarLivro(l);
    }

    @Test
    public void testGetNome() {
        assertEquals("Fulano", userUm.getNome());
    }

    @Test
    public void testSetNome() {
        userUm.setNome("Cicrano");
        assertEquals("Cicrano", userUm.getNome());
    }

    @Test
    public void testGetMatricula() {
        assertEquals(123, userUm.getMatricula());
    }

    @Test
    public void testSetMatricula() {
        userUm.setMatricula(45);
        assertEquals(45, userUm.getMatricula());
    }

    @Test
    public void testGetTempoMaximo() {
        assertEquals(25, userUm.getTempoMaximo());
    }

    @Test
    public void testSetTempoMaximo() {
        userUm.setTempoMaximo(60);
        assertEquals(60, userUm.getTempoMaximo());
    }

    @Test
    public void testGetMaxLivros() {
        assertEquals(3, userUm.getMaxLivros());
    }

    @Test
    public void testTemAtrasados() {
        assertTrue(userUm.temAtrasados());
        
    }

    @Test
    public void testAlugarLivro() {
        userUm.alugarLivro(l);
        Livro l2 = new Livro(l, new GregorianCalendar());
        userUm.alugarLivro(l2);
        assertEquals(2, userUm.getListaLivros().size());
    }

}

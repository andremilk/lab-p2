package lp2.lab09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import lp2.lab09.Livro.Status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LivroTest {

    private Livro livro, livroUm, livroDois;
    private ArrayList<String> autores;
    private String editora;
    private String edicao;
    
    @Before
    public void setUp() throws Exception {
        autores = new ArrayList<String>();
        autores.add("Autor um");
        autores.add("Autor dois");
        
        editora = "Editora lulz";
        edicao = "Edicao feliz";

        livro = new Livro("Livro um", true, autores, editora, edicao, 1989, 50);
        livroUm = new Livro(livro, new GregorianCalendar());
        livroDois = new Livro("Livro um", false, autores, editora, edicao, 1989, 50);
    }

    @Test
    public void testLivroLivroCalendar() {
        assertNotSame(livro, livroUm);
        assertNotSame(livroUm, livroDois);
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Nome de livro incompativel", "Livro um", livro.getTitulo());
    }

    @Test
    public void testSetTitulo() {
        livro.setTitulo("Livro");
        assertEquals("Nome de livro incompativel", "Livro", livro.getTitulo());
    }

    @Test
    public void testIsAlugavel() {
        assertTrue(!livroDois.isAlugavel());
        assertTrue(livro.isAlugavel());
    }

    @Test
    public void testSetAlugavel() {
        livroDois.setAlugavel(true);
        assertTrue(livroDois.isAlugavel());
    }

    @Test
    public void testGetAutores() {
        assertEquals("Teste de autores com problemas", autores, livro.getAutores());
    }

    @Test
    public void testSetAutores() {
        ArrayList<String> novosAutores = new ArrayList<String>();
        novosAutores.add("Novo autor um");
        novosAutores.add("Novo autor dois");
        livro.setAutores(novosAutores);
        assertEquals("Teste de autores com problemas", novosAutores, livro.getAutores());
    }

    @Test
    public void testGetEditora() {
        assertEquals(editora, livro.getEditora());
    }

    @Test
    public void testSetEditora() {
        livro.setEditora("Nova Editora");
        assertEquals("Nova Editora", livro.getEditora());
    }

    @Test
    public void testGetEdicao() {
        assertEquals(edicao, livro.getEdicao());
    }

    @Test
    public void testSetEdicao() {
        livro.setEdicao("Nova Edicao");
        assertEquals("Nova Edicao", livro.getEdicao());
    }

    @Test
    public void testGetAnoDePublicacao() {
        assertEquals(1989, livro.getAnoDePublicacao());
    }

    @Test
    public void testSetAnoDePublicacao() {
        livro.setAnoDePublicacao(2000);
        assertEquals(2000, livro.getAnoDePublicacao());
    }

    @Test
    public void testGetExemplares() {
        assertEquals(50, livro.getExemplares());
        
    }

    @Test
    public void testSetExemplares() {
        livro.setExemplares(30);
        assertEquals(30, livro.getExemplares());
    }

    @Test
    public void testGetDisponiveis() {
        assertEquals(50, livro.getDisponiveis());
    }

    @Test
    public void testSetDisponiveis() {
        Livro.setDisponiveis(30);
        assertEquals(30, livro.getDisponiveis());
    }

    @Test
    public void testGetStatus() {
        livro.setStatus(Status.DISPONIVEL);
        assertEquals(Status.DISPONIVEL, livro.getStatus());
    }

    @Test
    public void testGetDataDeLocacao() {
        assertNotSame(new GregorianCalendar(), livro.getDataDeLocacao());
    }

    @Test
    public void testSetDataDeLocacao() {
        Calendar novoCalendario = new GregorianCalendar();
        assertNotSame(novoCalendario, livro.getDataDeLocacao());
    }

    @Test
    public void testSerAlugado() {
        livro.setAlugavel(true);
        long disp = livro.getExemplares();
        assertTrue(livro.serAlugado());
        assertEquals(disp - 1, livro.getExemplares());
    }

    @Test
    public void testSerDevolvido() {
        long disp = livro.getExemplares();
        assertTrue(livro.serDevolvido());
        assertEquals(disp + 1, livro.getExemplares());
    }

    @Test
    public void testEqualsObject() {
        assertNotSame(livro, livroUm);
        Livro l = new Livro("Teste", true, autores, editora, edicao, 2000, 50);
        Livro l1 = new Livro("Teste", true, autores, editora, edicao, 2000, 20);
        assertEquals(l, l1);
    }

}

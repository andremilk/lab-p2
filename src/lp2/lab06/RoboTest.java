package lp2.lab06;

/* Aluno: André Luiz Guimarães de Souza Leite 
 * Aluno: Marcus Antonio Rocha Tenório
 */

import junit.framework.TestCase;


public class RoboTest extends TestCase {

    private Robo bot;
    
    public RoboTest(String name) {
        super(name);
        bot = new Robo(5, new Sala(5, 5));
    }

   public void testRobo() {
        assertNotNull(bot);
    }

   public void testSubir() {
        bot.linha = 4;
        assertTrue(bot.subir());
    }

   public void testDescer() {
         assertTrue(bot.descer());
    }

   public void testDireita() {
        assertTrue(bot.direita());
    }

   public void testEsquerda() {
        bot.coluna = 3;
        assertTrue(bot.esquerda());
    }

   public void testPossuiEnergia() {
         
        
        assertTrue(bot.possuiEnergia());
    }

   public void testGetEnergia() {
        Robo botEnergia = new Robo(10, new Sala(5, 5));
        assertEquals(botEnergia.getEnergia(), 10);
        assertNotSame(botEnergia.getEnergia(), 5);
    }

   public void testGetPassos() {
        Robo crawler = new Robo(5, new Sala(5, 5));
        crawler.descer();
        crawler.subir();
        crawler.descer();
        crawler.subir();
        assertEquals(crawler.getPassos(), 4);
        
    }

}

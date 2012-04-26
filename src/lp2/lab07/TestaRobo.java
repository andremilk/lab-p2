package lp2.lab07;
/* André Luiz Guimarães de Souza Leite 21121393 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaRobo {
	private Robo robo;
    private Sala sala;


    @Before
    public void criaSala() throws Exception{
            sala = new Sala(10, 10);
    }

    @Test
    public void testaCriaRobo(){
    	try{
    		robo = new Robo(-1, sala);
    		Assert.fail("Esperava excecao energia errada");
    	}catch(Exception e){
    		Assert.assertEquals("Mensagem errada", "A energia deve ser positiva.", e.getMessage());
    	}
    	
    	try{
    		robo = new Robo(0, sala);
    		Assert.fail("Esperava excecao energia errada");
    	}catch(Exception e){
    		Assert.assertEquals("Mensagem errada", "A energia deve ser positiva.", e.getMessage());
    	}
    }
    
    @Test
    public void testaMovimentacaoSemObstaculos(){
   		try{
   			robo = new Robo(10,sala);
   		}catch(Exception e){
        }
    		
   		Assert.assertFalse(sala.verificarPosicaoLivre(0, 0));
    		
        Assert.assertFalse(robo.subir());
        Assert.assertFalse(robo.esquerda());
        Assert.assertEquals(10, robo.getEnergia());
            
        Assert.assertTrue(robo.descer());
        Assert.assertTrue(robo.direita());
        Assert.assertEquals(1,robo.getLinhaAtual());
        Assert.assertEquals(1,robo.getColunaAtual());
            
        Assert.assertTrue(robo.subir());
        Assert.assertTrue(robo.esquerda());
        Assert.assertEquals(0,robo.getLinhaAtual());
        Assert.assertEquals(0,robo.getColunaAtual());            
    }
    
    @Test
    public void testaMovimentacaoComObstaculos(){
		try{
			robo = new Robo(50,sala);
		}catch(Exception e){
        }
		
		sala.inserirObstaculo(1, 0);
		sala.inserirObstaculo(0, 2);
                
        Assert.assertFalse(robo.descer());
        Assert.assertTrue(robo.direita());
        Assert.assertEquals(1, robo.getPassos());
        
        Assert.assertFalse(robo.direita());
        Assert.assertTrue(robo.descer());
        Assert.assertEquals(2, robo.getPassos());
        
        Assert.assertFalse(robo.esquerda());
        Assert.assertTrue(robo.descer());
        Assert.assertEquals(3, robo.getPassos());
        
        Assert.assertTrue(robo.esquerda());
        Assert.assertFalse(robo.subir());
        Assert.assertEquals(4, robo.getPassos());
        Assert.assertEquals(2,robo.getLinhaAtual());
        Assert.assertEquals(0,robo.getColunaAtual());
    }
    
    @Test
    public void testaPassos(){
        try{
        	robo = new Robo(10,sala);
        }catch(Exception e){
        }
        
    	Assert.assertEquals(0, robo.getPassos());
    	
    	Assert.assertTrue(robo.descer());
    	Assert.assertEquals(1, robo.getPassos());
    	
    	Assert.assertTrue(robo.direita());
    	Assert.assertEquals(2, robo.getPassos());
    	
    	Assert.assertTrue(robo.subir());
    	Assert.assertEquals(3, robo.getPassos());
    	
    	Assert.assertTrue(robo.esquerda());
    	Assert.assertEquals(4, robo.getPassos());
    }
    	
    @Test
    public void testaEnergia(){
    	try{
    		robo = new Robo(4,sala);
    	}catch(Exception e){
        }
		
        Assert.assertTrue(robo.possuiEnergia());
        
        Assert.assertTrue(robo.descer());
        Assert.assertEquals(3, robo.getEnergia());
        
        Assert.assertTrue(robo.direita());
        Assert.assertEquals(2, robo.getEnergia());
             
        Assert.assertTrue(robo.subir());
        Assert.assertEquals(1, robo.getEnergia());
        
        Assert.assertTrue(robo.esquerda());
        Assert.assertEquals(0, robo.getEnergia());
        
        Assert.assertFalse(robo.possuiEnergia());
        Assert.assertFalse(robo.descer());
    }

}
package lp2.lab10;

/**
 * Classe que modela uma prova.
 * Esta classe sera utilizada no momento de adicionar notas e calcular as medias das disciplinas
 * @author dekozo
 *
 */
public class Prova {
    
    /**
     * Atributo que da o peso da prova
     */
    private double peso;
    
    /**
     * Atributo que da nota a prova
     */
    private double nota;
    
    /**
     * Construtor da classe Prova
     * @param peso peso da prova
     * @param nota nota da prova
     * @throws Exception Exception lançada a ser tratada
     */
    Prova(double peso, double nota) throws Exception {
        this.setPeso(peso);
        this.setNota(nota);
    }

    /**
     * 
     * @return o peso da prova
     */
    public double getPeso() {
        return peso;
    }

    /**
     * 
     * @param peso peso a ser usado
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * 
     * @return retorna a nota obtida na prova
     */
    public double getNota() {
        return nota;
    }

    /**
     * 
     * @param nota nota a ser atribuida a prova, este valor nao deve ser menor que 0 ou maior que 10
     * @throws Exception Exception lançada caso a nota seja invalida
     */
    public void setNota(double nota) throws Exception {
        if(nota > 10 || nota < 0)
            throw new Exception("Nota inválida");
        this.nota = nota;
    }

    
}

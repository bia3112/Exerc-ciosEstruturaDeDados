
package fila_ex2.models;

/**
 *
 * @author Beatr
 */
public class FilaPrioritaria {
    
    private final Cliente[] vetorPrioritario;
    private int frente;
    private int fim;
    private int qtdCliente;

    public FilaPrioritaria(int tamanho) {
        vetorPrioritario = new Cliente[tamanho];
        frente = 0;
        fim = -1;
        qtdCliente = 0;
    }
    
    public void enqueue(Cliente numero){
        if(fim == vetorPrioritario.length -1){
            fim = -1;
        }
        vetorPrioritario[++fim] = numero;
        qtdCliente++;
    }
    
    public Cliente dequeue(){
        Cliente aux = vetorPrioritario[frente++];
        if(frente == vetorPrioritario.length){
            frente = 0;
        }
        qtdCliente--;
        return aux;
    }
    
    public boolean isEmpty(){
        return qtdCliente == 0;
    }
    
    public boolean isFull(){
        return qtdCliente == vetorPrioritario.length;
    }
    
}

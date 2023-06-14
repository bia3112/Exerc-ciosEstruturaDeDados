
package fila_ex2.models;

/**
 *
 * @author Beatr
 */
public class FilaNormal {
    
    private Cliente[] vetorNormal;
    private int frente;
    private int fim;
    private int qtdCliente;

    public FilaNormal(int tamanho) {
        vetorNormal = new Cliente[tamanho];
        frente = 0;
        fim = -1;
        qtdCliente = 0;
    }
    
    public void enqueue(Cliente numero){
        if(fim == vetorNormal.length -1){
            fim = -1;
        }
        vetorNormal[++fim] = numero;
        qtdCliente++;
    }
    
    public Cliente dequeue(){
        Cliente aux = vetorNormal[frente++];
        if(frente == vetorNormal.length){
            frente = 0;
        }
        qtdCliente--;
        return aux;
    }
    
    public boolean isEmpty(){
        return qtdCliente == 0;
    }
    
    public boolean isFull(){
        return qtdCliente == vetorNormal.length;
    }
    
}

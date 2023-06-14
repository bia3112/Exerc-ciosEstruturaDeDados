
package fila_ex2;

import fila_ex2.models.Cliente;
import fila_ex2.models.FilaNormal;
import fila_ex2.models.FilaPrioritaria;
import javax.swing.JOptionPane;

public class Fila_ex2 {

    public static void main(String[] args) {
        
        FilaNormal normal = new FilaNormal(40);
        FilaPrioritaria prioritaria = new FilaPrioritaria(40);
        int opcao;
        int contadorPrioritario = 0;
        
        do{
            String inputMenu = JOptionPane.showInputDialog("1 - Adicionar cliente \n2 - Chamar próximo cliente");
            opcao = Integer.parseInt(inputMenu);
            
            switch(opcao){
                case 1:
                    String inputSenha = JOptionPane.showInputDialog("Informe a senha: ");
                    int controle = Integer.parseInt(inputSenha);
                    String inputNome = JOptionPane.showInputDialog("Informe o nome do cliente:");
                    String inputAno = JOptionPane.showInputDialog("Informe o ano de nascimento do cliente:");
                    int anoNasci = Integer.parseInt(inputAno);
                    
                    Cliente cliente = new Cliente(controle,inputNome, anoNasci);
                        if(anoNasci <=1958){
                            prioritaria.enqueue(cliente);
                        }else{
                            normal.enqueue(cliente);
                        }
                    break;
                case 2:

                    if (contadorPrioritario < 2 && !prioritaria.isEmpty()) {
                        System.out.println("Atendimento prioritário: " + prioritaria.dequeue());
                        contadorPrioritario++;
                    } else if (!normal.isEmpty()) { 
                        System.out.println("Atendimento normal: " + normal.dequeue());
                        contadorPrioritario = 0;
                    } else {
                        System.out.println("Sem clientes");
                    }
                        break;    
                    } 
        }while(!normal.isFull());      
    }   
}

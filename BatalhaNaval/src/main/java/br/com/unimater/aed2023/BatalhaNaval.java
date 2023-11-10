package br.com.unimater.aed2023;

import java.util.Random;
import java.util.Scanner;


public class BatalhaNaval {

    public static void main(String[] args) {
        Scanner ms = new Scanner (System.in);
        Random rn = new Random();
        
        System.out.println("Quantas vezes você irá jogar?");
        int jogadas = ms.nextInt();
 
        int qntdPartidas = 0;//contador das partidas
        int contador2 = 0;//contador para a matriz das pontuações
        double[] calcPontuacao = new double[jogadas];
        
        do{
            int[][] batalhaNaval1 = new int[10][11];
            int[][] batalhaNaval2 = new int[10][11];
            int[][] batalhaNaval3 = new int[10][11];
            
            System.out.println("");
            System.out.println((qntdPartidas+1)+"° partida");
            System.out.println("  1 2 3 4 5 6 7 8 9 10");
            //imprimir a matriz com todos os valores zerados
            int i = 0; 
            do{
                int j = 0;
                do{
                    if(j == 0){
                            System.out.print((i)+" ");            
                    }else{
                    batalhaNaval1[i][j] = 0;
                    System.out.print(batalhaNaval1[i][j]+" "); 
                    }
                    j++;
                }while(j < 11);
                System.out.println("");
                i++;
            }while(i < 10);
            
            System.out.println("");
            
            //barcos são gerados aleatoriamente
            int contadorAleatorio = 0;
            int num1 = 0;
            int num2 = 0;
            //gerar barcos de 1x1
            do{
                num1 = 1+rn.nextInt(8);
                num2 = 1+rn.nextInt(9);
                if (batalhaNaval2[num1][num2] != 7){    
                    batalhaNaval2[num1][num2] = 7;                     
                    contadorAleatorio++;
                }    
            }while(contadorAleatorio < 6);
                
            //gerar barcos de 2x1
            contadorAleatorio = 0;
            do{
                //Gerar os números aleatórios
                num1 = 1+rn.nextInt(8);
                num2 = 1+rn.nextInt(9);
                //Verifica se o número já não há um barco sobre ele
                if (batalhaNaval2[num1][num2] != 7){
                    //Verifica se é a última coluna
                    if(num2 == 10){
                        //Verifica se a coluna ao lado está vazia
                        if (batalhaNaval2[num1][num2-1] != 7){
                          batalhaNaval2[num1][num2] = 7;
                          batalhaNaval2[num1][num2-1] = 7;
                          contadorAleatorio++;
                        }
                    //Verifica se não é a última coluna    
                    }else if(num2 != 10){
                        //Verifica se a posição ao lado está vazia se tiver insere o barco
                        if (batalhaNaval2[num1][num2+1] != 7){
                          batalhaNaval2[num1][num2] = 7;
                          batalhaNaval2[num1][num2+1] = 7;
                          contadorAleatorio++;
                        }
                    }
                }
            }while(contadorAleatorio < 2);
            
            //jogadas do jogador
            double pontuacao = 0;
            int contadorJogadas = 0;
            int linha;
            int coluna;
            do{
                //digitação da linha
                do{
                    System.out.println("Digite a linha que você deseja jogar: ");
                    linha = ms.nextInt();
                    if((linha < 0) || (linha > 9)){
                        System.out.println("Valor inválido, digite a linha novamente:");
                        linha = ms.nextInt();
                    }
                }while((linha < 0) || (linha > 9));
                //digitação da coluna
                do{
                    System.out.println("Digite a coluna que você deseja jogar: ");
                    coluna = ms.nextInt();
                    if((coluna < 1) || (coluna > 10)){
                        System.out.println("Valor inválido, digite a coluna novamente:");
                        coluna = ms.nextInt();
                    }
                }while((coluna < 1) || (coluna > 10));
                
                //verificando se errou
                if(batalhaNaval2[linha][coluna] == 0){
                    if((batalhaNaval3[linha][coluna] == 4) || (batalhaNaval3[linha][coluna] == 7)){//caso já tenha sido digitado nesse lugar
                        System.out.println("Já foi jogado nesta posição!");                       
                    }else{
                        System.out.println("**********Errou!**********");
                        batalhaNaval3[linha][coluna] = 4;
                        i = 0;
                        System.out.println("  1 2 3 4 5 6 7 8 9 10");
                        do{
                            int j = 0;
                            do{
                                if(j == 0){
                                    System.out.print((i)+" ");
                                }else{
                                    System.out.print(batalhaNaval3[i][j]+" "); 
                                }

                                j++;
                            }while(j < 11);
                            System.out.println("");
                            i++;
                        }while(i < 10);
                        contadorJogadas++;
                    }
                //verificando se acertou
                }else{
                    System.out.println("**********Acertou**********!");
                    batalhaNaval3[linha][coluna] = 7;
                    i = 0;
                    System.out.println("  1 2 3 4 5 6 7 8 9 10");
                    do{
                        int j = 0;
                            do{
                                if(j == 0){
                                    System.out.print((i)+" ");
                                }else{
                                    System.out.print(batalhaNaval3[i][j]+" "); 
                                }
 
                                j++;
                            }while(j < 11);
                        System.out.println("");
                    i++;
                }while(i < 10);
                    pontuacao++;
                    contadorJogadas++;
                }
            }while((contadorJogadas < 100) && (pontuacao < 10));
            
            //pontuações
            calcPontuacao[contador2] = (pontuacao / contadorJogadas) * 100;
            contador2++;
            
            //imprimir a matriz com os barcos
            System.out.println("Tabela com as posições corretas dos barcos:");
            i = 0; 
            System.out.println("  1 2 3 4 5 6 7 8 9 10");
            do{
                int j = 0;
                do{
                    if(j == 0){
                        System.out.print((i)+" ");
                    }else{
                        System.out.print(batalhaNaval2[i][j]+" "); 
                    }
 
                    j++;
                }while(j < 11);
                System.out.println("");
                i++;
            }while(i < 10);
            
            qntdPartidas++;
        }while(qntdPartidas < jogadas);
        
        //pontuações
        int i = 0;
        int j = i + 1;
        do{
            if(jogadas == 1){//se a pessoa jogar apenas uma vez
                break;
            }
            if(j == jogadas){
                break;
            }
                do{
                   if(calcPontuacao[i] > calcPontuacao[j]){//ordenar matriz
                    double troca = calcPontuacao[i];
                    calcPontuacao[i] = calcPontuacao[j];
                    calcPontuacao[j] = troca;
                    }
                   j++;
                }while(j < (jogadas - 1));
            i++;
        }while(i < calcPontuacao.length);
        
        //somando os valores
        i = 0;
        double soma = 0;
        do{
            soma += calcPontuacao[i];
            i++;
        }while(i < calcPontuacao.length);
        
        //cálculo da média
        double media;
        if(jogadas == 1){//se a pessoa jogar só uma vez
            media = calcPontuacao[0];
        }else{
           media = soma/3; 
        }
        
        System.out.println("Foram jogadas "+jogadas+" partidas");
        System.out.printf("Pontuação miníma: %.2f",calcPontuacao[0]);
        System.out.printf("Pontuação máxima: %.2f",calcPontuacao[jogadas - 1]);
        System.out.printf("Pontuação média: %.2f",media);
    }
       
}

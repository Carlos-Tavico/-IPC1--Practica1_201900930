/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ipc1.practica1_201900930;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Carlos
 */
public class PacMan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Variables
        boolean q = true, ga = true;
        Scanner scan = new Scanner(System.in);
        String mat[][];
        String hist[][];
        String sup, op, nombre, mov;
        int carnet, row, col, puntaje, mult, movimientos, i, j;
        // Menu
        while(q){
            System.out.println("Elija una opcion:\n1. JUGAR\n2. HISTORIAL\n3. SALIR\n");
            op = scan.next();
            if(op.equals("1")){
                ga = true;
                System.out.println("Ingresar Nombre:");
                nombre = scan.next();
                System.out.println("Ingresar Carnet:");
                carnet = scan.nextInt();
                System.out.println("Dimensiones del tablero\nFILAS:");
                row = scan.nextInt();
                System.out.println("COLUMNAS");
                col = scan.nextInt();
                //Dimensiones del tablero
                mat= new String[row][col];
                //Posición del jugador
                i = new Random().nextInt(row);
                j = new Random().nextInt(col);
                //Item #
                for(int c = 0; c<9;c++){
                    int i1 = new Random().nextInt(row);
                    int j1 = new Random().nextInt(row);
                    mat[i1][j1] = "[#]";
                }
                //Item $
                for(int d = 0; d<9;d++){
                    int i1 = new Random().nextInt(row);
                    int j1 = new Random().nextInt(row);
                    mat[i1][j1] = "[$]";
                }
                //Item @
                for(int e = 0; e<9;e++){
                    int i1 = new Random().nextInt(row);
                    int j1 = new Random().nextInt(row);
                    mat[i1][j1] = "[@]";
                }
                //Item +
                for(int f = 0; f<3;f++){
                    int i1 = new Random().nextInt(row);
                    int j1 = new Random().nextInt(row);
                    mat[i1][j1] = "[+]";
                }
                //Estatus
                puntaje = 10;
                movimientos = 0;
                mult = 1;
                //Datos
                sup = "---------------------------------------------\n"
                        +nombre + " - " + carnet + " - IPC1 A\n" + "---------------------------------------------";
                while(ga){
                    //Items
                    if(mat[i][j] == "[#]"){
                        puntaje = puntaje - mult*10;
                    }
                    else if(mat[i][j] == "[$]"){
                        puntaje = puntaje + mult*15;
                    }
                    else if(mat[i][j] == "[@]"){
                        puntaje = puntaje + mult*10;
                    }
                    else if(mat[i][j] == "[+]"){
                        mult = mult * 2;
                    }
                    else{
                    }
                    //Posición actual
                    mat[i][j] = "[V]";
                    //Tablero
                    System.out.println(sup);
                    for(int a = 0; a<mat.length; a++){
                        for(int b = 0; b<mat[a].length; b++){
                            if(mat[a][b] == null){
                                mat[a][b] = "[ ]";
                            }
                            System.out.print(mat[a][b]);
                        }
                        System.out.println("");
                    }
                    //Estado
                    System.out.println("Puntaje: " + puntaje + " - Movimientos: " + movimientos);
                    System.out.println("Multiplicador: " + mult);
                    mov = scan.next();
                    //Movimiento
                    switch(mov){
                        //arriba
                        case "w":
                            mat[i][j] = "[ ]";
                            if(i == 0){
                                i = row - 1;
                            }
                            else{
                                i = i - 1;
                            }
                            break;
                        //izquierda
                        case "a":
                            mat[i][j] = "[ ]";
                            if(j == 0){
                                j = col - 1;
                            }
                            else{
                                j = j - 1;
                            }
                            break;
                        //abajo
                        case "s":
                            mat[i][j] = "[ ]";
                            if(i == row - 1){
                                i = 0;
                            }
                            else{
                                i = i + 1;
                            }
                            break;
                        //derecha
                        case "d":
                            mat[i][j] = "[ ]";
                            if(j == col - 1){
                                j = 0;
                            }
                            else{
                                j = j + 1;
                            }
                            break;
                        case "m":
                            ga = false;
                        default:
                            System.out.println("no valido");
                            break;
                    }
                    //Contador
                    movimientos = movimientos + 1;
                }
                
            } else if(op.equals("2")){
                
            } else if(op.equals("3")){
                q = false;
            } else {
                System.out.println("Ingresar valor valido, Por favor.\n");
            }
        }
    }
    
}

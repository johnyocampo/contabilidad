/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

/**
 *
 * @author practi10
 */
import java.util.Scanner;
public class Contabilidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Scanner entrada=new Scanner(System.in);
        producto[] productos = new producto[100];
        menu menu_principal= new menu();
        
        
        int num_menu=0;
        int i=0;
        int num_producto=0;
        int productos_ingresados=0;
        
   
        
        
        do{
        
            
        menu_principal.mostrar_menu();
        num_menu =entrada.nextInt();
        
        
        switch(num_menu){
            case 1: 
                productos_ingresados=num_producto;
                productos[num_producto]= new producto();
                productos[num_producto].cargar_datos();
                num_producto++;                
                break;
            case 2:
                
                menu_principal.buscar_producto(productos, num_producto);
                
                break;
            case 3:
                menu_principal.eliminar_producto(productos, num_producto);
                break;
            case 4:
                menu_principal.mostrar_inventario(productos, num_producto);
                break;
            case 5:
                menu_principal.realizar_venta(productos, num_producto);
                break;
                
            case 6:
                  menu_principal.mostrar_ganancias(productos, num_producto);
                break;
            default:
                System.out.println("El valor ingresado es incorrecto ");
        
            }
        }
        while(num_menu!=7);
        
        
    }
    
}

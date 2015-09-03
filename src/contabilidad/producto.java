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
public class producto {
    Scanner entrada= new Scanner(System.in);
    
    String nombre;
    int cantidad;
    int precio_unidad;
    int unidades_vendidas;
    /*String num_cedula;
    String fecha_nacimiento;
    String direccion;
    String telefono;*/
    
    public void  cargar_datos(){
    
        System.out.println("Ingrese el nombre del producto ");
        nombre= entrada.nextLine();
        
        System.out.println("Ingrese la cantidad ");
        cantidad= entrada.nextInt();
        System.out.println("Ingrese el precio de cada unidad ");
        precio_unidad= entrada.nextInt();
        //entrada.nextLine();
      
    }
    
    
    public void mostrar_datos(){
    
        System.out.println("producto: "+nombre);
        System.out.println("cnatidad: "+cantidad);
        System.out.println("precio de cada unidad: "+precio_unidad);
       
        
    }
    
    
    
}

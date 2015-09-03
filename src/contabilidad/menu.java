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
public class menu {
 
    public void mostrar_menu()
    {
      
    producto[] copia =new producto[100];    
        
    System.out.println("\nBienvenido al programa de contabilidad \n"
            + "Ingrese el numero de la acción que corresponde a la acción que"
            + "desea realizar \n");    
    System.out.println("1.agregar producto            2.buscar producto");
    System.out.println("3.eliminar producto           4.mostrar inventario");
    System.out.println("5.realizar venta              6.Mostrar ganancias");
    System.out.println("7.salir         ");
    
    }
    
    public void mostrar_inventario(producto[] productos,int num_productos){
        
        int i;
        
        for(i=0;i<num_productos;i++){
        productos[i].mostrar_datos();
            
        }
    }
    
    public void buscar_producto(producto[] productos,int num_productos){
       
        Scanner entrada=new Scanner(System.in);
        String nombre;
        
        
        int i;
        
        
        System.out.println("Por favor ingrese solo el nombre del producto "
                + "del cual quiere informacion ");
        nombre=entrada.nextLine();
        for(i=0;i<num_productos;i++){
            if(productos[i].nombre.equals(nombre))
            productos[i].mostrar_datos();
          
        }
        
        
    
    }
    
    public void eliminar_producto(producto[] productos,int num_productos){
       
        Scanner entrada=new Scanner(System.in);
        String nombre;
        
        
        int i;
        boolean verificacion=false;
        
        System.out.println("Por favor ingrese solo el nombre del producto que "
                + "desea eliminar ");
        nombre=entrada.nextLine();
        for(i=0;i<num_productos;i++){
            if(productos[i].nombre.equals(nombre)){
            verificacion=true;
            productos[i].nombre="";
            productos[i].cantidad=0;
            productos[i].precio_unidad=0;
            
            
            }
          
        }
        if(verificacion==false){
            System.out.println("el producto ingresado es incorrecto ");
            }
        
        
    }
    
    
    public void realizar_venta(producto[] productos,int num_productos){
       
        Scanner entrada=new Scanner(System.in);
        String nombre;
        
        
        int i;
        int cantidad_venta;
        int resta=0;
        boolean verificacion=false;
        System.out.println("Por favor ingrese solo el nombre del producto que "
                + "desea vender ");
        nombre=entrada.nextLine();
        System.out.println("Por favor ingrese la cantidad que desea vender ");
        cantidad_venta=entrada.nextInt();
        
        for(i=0;i<num_productos;i++){
            if(productos[i].nombre.equals(nombre)){
            resta=productos[i].cantidad-cantidad_venta;
            productos[i].unidades_vendidas+=cantidad_venta;
            productos[i].cantidad-=resta;
            verificacion=true;
            
            }
            
            if(verificacion==false){
            System.out.println("el producto ingresado es incorrecto o no existe");
            }
                
            
          
        }
        
    }
    
    
    public void mostrar_ganancias(producto[] productos,int num_productos){
       
       
        
        
        int i;
        int total=0;
        
        for(i=0;i<num_productos;i++){
            System.out.println("Se vendieron  "+productos[i].unidades_vendidas+
                    "de "+productos[i].nombre);
            System.out.println("con una ganancia de "+productos[i].precio_unidad*productos[i].unidades_vendidas);
            total+=productos[i].precio_unidad*productos[i].unidades_vendidas;
            System.out.println("El total de lo vendido es de "+total);
            
        }
        
        
    
    }
    
}
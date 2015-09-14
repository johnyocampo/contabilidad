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
import java.sql.*;
public class Contabilidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Scanner entrada=new Scanner(System.in);
        //producto[] productos = new producto[100];
        menu menu_principal= new menu();
        
        
        int num_menu=0;
        int i=0;
        int num_producto=0;
        int productos_ingresados=0;
        boolean verificacion=false;
        
        Scanner lector = new Scanner(System.in);
        String user = "root";
        String password = "12345";
        String url = "jdbc:mysql://localhost/inventario";
        String user2 = "ocampojohny";
        String password2 = "123456789";
        String url2 = "jdbc:mysql://db4free.net/base_ocampo";
        String nombre, apellido, tel;
   
        try {
            //Prueba de conexion
            System.out.println("Conectando a base de datos...");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url2,user2,password2);
            System.out.println("Conexión exitosa...");
            
            
            
            
         } catch (SQLException ex) {
            System.out.println("Error de mysql");
          } catch (Exception e) {
            System.out.println("Se ha encontrado un error de tipo: "
                    + e.getMessage());
            
         }   
        
        do{
        
        
            
        menu_principal.mostrar_menu();
        num_menu =entrada.nextInt();
        
        
        switch(num_menu){
            case 1: 
                  menu_principal.ingresar_producto();
                //productos[num_producto]= new producto();
                //productos[num_producto].cargar_datos();
                              
                break;
            case 2:
                
                menu_principal.buscar_producto();
                
                break;
            case 3:
                menu_principal.eliminar_producto();
                
                break;
            case 4:
                menu_principal.mostrar_inventario();
                break;
            case 5:
                menu_principal.realizar_venta();
                break;
                
            case 6:
                  menu_principal.mostrar_ganancias();
                break;
            default:
                System.out.println("El valor ingresado es incorrecto ");
        
            }
        }
        while(num_menu!=7);
        
        
    }
    
}

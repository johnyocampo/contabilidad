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


public class menu {
      
    
    
    Scanner lector = new Scanner(System.in);
        String user = "root";
        String password = "12345";
        String url = "jdbc:mysql://localhost/inventario";
        String user2 = "ocampojohny";
        String password2 = "cangrejo.1";
        String url2 = "jdbc:mysql://db4free.net/inventario";
        String nombre;
        int cantidad, valor;
        String comparador;
        int ganancias=0;
        
        
    public void mostrar_menu()
    {
      
    
        
    System.out.println("\nBienvenido al programa de contabilidad \n"
            + "Ingrese el numero de la acción que corresponde a la acción que"
            + "desea realizar \n");    
    System.out.println("1.agregar producto            2.buscar producto");
    System.out.println("3.eliminar producto           4.mostrar inventario");
    System.out.println("5.realizar venta              6.Mostrar ganancias");
    System.out.println("7.salir         ");
    
    }
    
    public void mostrar_inventario(){
        
    try {
            //Prueba de conexion
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);
               
            
            ResultSet resultado;           
            Statement estado = con.createStatement();
            resultado = estado.executeQuery("SELECT * FROM `productos`");
            
            while (resultado.next()){
                System.out.println(resultado.getString("nombre") +"\t"+ resultado.getString("cantidad")
                        +"\t"+ resultado.getString("valor") +"\t");
            
                   
           }   
            
         } catch (SQLException ex) {
            System.out.println("Error de mysql");
          } catch (Exception e) {
            System.out.println("Se ha encontrado un error de tipo: "
                    + e.getMessage());
            
         }   
           
        
        
    }
    
    public void buscar_producto(){
       int bandera=0;
       try {
            
           
            System.out.println("Digite el nombre del producto que quiere buscar: ");
            nombre = lector.nextLine();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);
               
            
            ResultSet resultado;           
            Statement estado = con.createStatement();
            resultado = estado.executeQuery("SELECT * FROM `productos` WHERE `nombre` LIKE '"+nombre+"'");
            while (resultado.next()){
                comparador=resultado.getString("nombre");
                
                System.out.println(resultado.getString("nombre") +"\t"+ resultado.getString("cantidad")
                        +"\t"+ resultado.getString("valor") +"\t");
                
                if(nombre.equals(comparador)){
                    bandera=bandera+1;}
                //System.out.println(bandera);    
                    
            }
            if(bandera==0){System.out.println("el producto ingresado no existe");}
            
         } catch (SQLException ex) {
            System.out.println("Error de mysql");
          } catch (Exception e) {
            System.out.println("Se ha encontrado un error de tipo: "
                    + e.getMessage());
            
         } 
        
        
    
    }
    
    public void eliminar_producto(){
       
    try {
            
        
        
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);
            ResultSet resultado;           
            Statement estado = con.createStatement();
            
            System.out.println("Digite un nombre para eliminar: ");
            nombre = lector.nextLine();
            estado.executeUpdate("DELETE FROM `productos` WHERE `nombre` LIKE '"+nombre+"'");
            
            
            
         } catch (SQLException ex) {
            System.out.println("Error de mysql");
          } catch (Exception e) {
            System.out.println("Se ha encontrado un error de tipo: "
                    + e.getMessage());
            
         } 
          
       
        
    }
    
    
    public void realizar_venta(){
       
               
        int i;
        int cantidad_venta=0;
        int num_productosRestantes=0;
        int bandera=0;
        int cantidad_producto=0;
        int valor_venta=0;
        int precio=0;
         try {
                        
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);
            ResultSet resultado;           
            Statement estado = con.createStatement();
            System.out.println("Digite el nombre del producto que desea vender: ");
            nombre = lector.nextLine();
                      
            resultado = estado.executeQuery("SELECT * FROM `productos` WHERE `nombre` LIKE '"+nombre+"'");
            while (resultado.next()){
                
                comparador=resultado.getString("nombre");
                System.out.println(resultado.getString("nombre") +"\t"+ resultado.getString("cantidad")
                        +"\t"+ resultado.getString("valor") +"\t");
                
                if(nombre.equals(comparador)){
                    cantidad_producto=resultado.getInt("cantidad");
                    precio=resultado.getInt("valor");
                    bandera=bandera+1;}
                //System.out.println(bandera);    
                    
            }
            if(bandera==0){System.out.println("el producto ingresado no existe");}
            else{System.out.println("Ingrese la cantidad del producto a vender");
            cantidad_venta=lector.nextInt();
            lector.nextLine();
            valor_venta=cantidad_venta*precio;
            num_productosRestantes=cantidad_producto-cantidad_venta;
            if(num_productosRestantes==0){estado.executeUpdate("DELETE FROM `productos` WHERE `nombre` LIKE '"+nombre+"'");}
            if(num_productosRestantes<0){System.out.println("no hay tantos productos");}
            else
            {estado.executeUpdate("UPDATE productos SET cantidad = '"+num_productosRestantes+"' WHERE nombre='"+nombre+"'");
            ganancias+=valor_venta;
            
            }
            }
            
            
            
            
            
            
            
            
         } catch (SQLException ex) {
            System.out.println("Error de mysql");
          } catch (Exception e) {
            System.out.println("Se ha encontrado un error de tipo: "
                    + e.getMessage());
            
         } 
                    
          
        
        
    }
    
    
    public void mostrar_ganancias(){
       
       System.out.println("El total de ganancias es: "+ganancias);
             
                        
        
        
    }    
    public void ingresar_producto(){
        
        int bandera=0;
        int cantidad_producto=0;
       try {
                        
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);
            ResultSet resultado;           
            Statement estado = con.createStatement();
            System.out.println("Digite un nombre: ");
            nombre = lector.nextLine();
            resultado = estado.executeQuery("SELECT * FROM `productos` WHERE `nombre` LIKE '"+nombre+"'");
            while (resultado.next()){
                comparador=resultado.getString("nombre");
                
                System.out.println(resultado.getString("nombre") +"\t"+ resultado.getString("cantidad")
                        +"\t"+ resultado.getString("valor") +"\t");
                
                if(nombre.equals(comparador)){
                    cantidad_producto=resultado.getInt("cantidad");
                    bandera=bandera+1;}
                //System.out.println(bandera);    
                    
            }
            if(bandera==1){
            System.out.println("El producto ya existe ingrese la cantidad a agregar de productos: ");
            cantidad = lector.nextInt();
            lector.nextLine();
            estado.executeUpdate("UPDATE productos SET cantidad = '"+(cantidad_producto+cantidad)+"' WHERE nombre='"+nombre+"'");
            }
            else{
            System.out.println("Digite la cantidad: ");
            cantidad=lector.nextInt();
            lector.nextLine();
            System.out.println("Digite el valor del producto individual: ");
            valor=lector.nextInt();
            lector.nextLine();
            estado.executeUpdate("INSERT INTO `productos` VALUES ('"+nombre+"', '"+cantidad+"', '"+valor+"')");};
            
            
            
         } catch (SQLException ex) {
            System.out.println("Error de mysql");
          } catch (Exception e) {
            System.out.println("Se ha encontrado un error de tipo: "
                    + e.getMessage());
            
         } 
            
        
    
    }
    
}
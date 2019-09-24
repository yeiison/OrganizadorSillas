
package organizadorsillas;

import java.lang.reflect.Array;
import java.util.Scanner;
/**
 *
 * @author yeisonfernando
 */
public class OrganizadorSillas {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Ingrese en el arreglo el número de hijos de cada familias");
        String [] a = sc.nextLine().split(",");
        int familia []= new int[a.length];
        
        for (int i = 0; i < a.length; i++) {
            familia[i]=Integer.parseInt(a[i]);
        }
        
        System.out.println("Ingrese el numero de mesas disponibles");
        int k = Integer.parseInt(sc.nextLine());
        k = validarRestriccion(k);  
        
        System.out.println("Hay : "+contarFormas(familia, k) +" formas diferentes en las que la familia se pueden sentar");
        
    }
    public static int contarFormas(int[] a, int k){
         int mult=1, b=1, c=1, j=0, aux2=1;

         while (j < a.length){
             int aux= (int) Math.pow(2, (int) Array.get(a, j));
             mult=mult*aux;
             j++;
         }
 
         if(a.length>k){
             b=a.length;
             c=b-k;
             int fn=1, fr=1;
             while(b!=0){
                 fn=fn*b;
                 b--;
             }
             while(c!=0){
                 fr=fr*c;
                 c--;
             }
             aux2=fn/fr;
             mult=(mult*2)+aux2;
         }
         else{
             aux2=a.length-1;
             mult =(mult+aux2)*k;
         }
         return mult;
     }
    
    public static int validarRestriccion (int num){
        
        Scanner sc = new Scanner(System.in);
        do{
                       
            if (num < 1 || num > 1000){
                System.out.println("El tamaño debe ser entre 1 y 1000 inclusive");
                System.out.println("VUELVA A DIGITAR El DATO:");
                num = sc.nextInt();                
                }             
                       
        } while(num < 0 || num > 1000);
        return num;
    }
 
    
}



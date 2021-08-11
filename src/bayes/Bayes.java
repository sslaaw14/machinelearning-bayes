/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayes;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Bayes {

    /**
     * @param args the command line arguments
     */
    static double umursama = 0;
    static double umurtidaksama = 0;
    static double gemuksama = 0;
    static double gemuktidak = 0;
    static double hipertensi = 0;
    static double hipertensitidak = 0;
   
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner inumur = new Scanner(System.in);
        Scanner ingemuk = new Scanner(System.in);
        Scanner inhipertensi = new Scanner(System.in);
        String[] input = new String[2];
        String data[][] = new String[5][3];
        data[0] = new String[] {"muda","gemuk","tidak"};
        data[1] = new String[] {"muda","sangat gemuk","tidak"};
        data[2] = new String[] {"paruh baya","gemuk","tidak"};
        data[3] = new String[] {"paruh baya","terlalu gemuk","ya"};
        data[4] = new String[] {"tua","terlalu gemuk","ya"};
        
        System.out.println("Input Data Umur :");
        input[0] = inumur.nextLine();
        System.out.println("Input Data Kegemukan : ");
        input[1] = ingemuk.nextLine();
        
        boolean cekumur = input[0].isEmpty();
        boolean cekgemuk = input[1].isEmpty();
        
        if(cekumur==false && cekgemuk==false) {
            String x1 = input[0];
            String x2 = input[1];
            double px1ya=0, px1tidak=0, px2ya=0, px2tidak=0;
            double px1x2ya=0, px1x2tidak;
            px1x2tidak = 0;
            int i=0;
            
            while(i<5) {
                if(data[i][0].equals(x1) && data[i][2].equals("ya")) {
                    umursama++;
                }
                
                if(data[i][0].equals(x1) && data[i][2].equals("tidak")) {
                    umurtidaksama++;
                }
                i++;
            }
            
            int l=0;
            while(l<5) {
                 if(data[l][1].equals(x2) && data[l][2].equals("ya")) {
                    gemuksama++;
                }
                
                if(data[l][1].equals(x2) && data[l][2].equals("tidak")) {
                    gemuktidak++;
                }
                l++;
            }
            int j=0;
            while(j<5){
                if("ya".equals(data[j][2])){
                    hipertensi++;
                }else {
                    hipertensitidak++;
                }
                j++;
            }
            
            px1ya = hitungp(umursama, hipertensi);
            px1tidak = hitungp(umurtidaksama, hipertensitidak);
            px2ya = hitungp(gemuksama, hipertensi);
            px2tidak = hitungp(gemuktidak, hipertensitidak);

            System.out.println("---------------------------------------");
            px1x2ya = ( px1ya * px2ya * hipertensi ) / 5;
            px1x2tidak = ( px1tidak * px2tidak * hipertensitidak) / 5;
            
            if(px1x2ya > px1x2tidak) {
                System.out.println("Kemungkinan :"+px1x2ya);
                System.out.println("Hipertensi YA");
            }else if (px1x2ya < px1x2tidak){
                System.out.println("Kemungkinan :"+px1x2tidak);
                System.out.println("Hipertensi TIDAK");
            }else {
                System.out.println("BISA KEDUANYA");
            }  
        }
        
        if(cekumur==false && cekgemuk==true){
            String x1 = input[0];
           
            double p1=0,p2=0,pya=0,ptidak=0;
            int i=0;
            
            while(i<5) {
               if(data[i][0].equals(x1)&&data[i][2].equals("ya")){
                   umursama++;
               }
               
               if(data[i][0].equals(x1)&&data[i][2].equals("tidak")){
                   umurtidaksama++;
               }
               
               i++;
            }
            
            int j=0;
            while(j<5){
                if("ya".equals(data[j][2])){
                    hipertensi++;
                }else {
                    hipertensitidak++;
                }
                j++;
            }
           
            p1 = hitungp(umursama,hipertensi);
            p2 = hitungp(umurtidaksama, hipertensitidak);
            System.out.println(p1);
            System.out.println(p2);
            
            pya = (p1 * hipertensi) / 5;
            ptidak = (p2 * hipertensitidak) / 5;
                       
            if(pya > ptidak) {
                System.out.println("Hipertensi YA");
            }else{
                System.out.println("Hipertensi TIDAK");
            }
        }
        
        if(cekgemuk==false && cekumur==true) {
            String x1=input[1];

            double p1=0,p2=0,pya=0,ptidak=0;
            int i=0;
            
            while(i<5) {
               if(data[i][1].equals(x1)&&data[i][2].equals("ya")){
                   gemuksama++;
               }
               
               if(data[i][1].equals(x1)&&data[i][2].equals("tidak")){
                   gemuktidak++;
               }
         
               i++;
            }
            
            int j=0;
            while(j<5){
                if("ya".equals(data[j][2])){
                    hipertensi++;
                }else {
                    hipertensitidak++;
                }
                j++;
            }
            
            p1 = hitungp(gemuksama,hipertensi);
            p2 = hitungp(gemuktidak, hipertensitidak);
            System.out.println(p1);
            System.out.println(p2);
            
            pya = (p1 * hipertensi) / 5;
            ptidak = (p2 * hipertensitidak) / 5;
           
            if(pya > ptidak) {
                System.out.println("Hipertensi YA");
            }else{
                System.out.println("Hipertensi TIDAK");
            }
        }  
    }
    
    public static double hitungp(double x, double y) {
        double hasilxy;
        double hasily;
        double p;
        hasilxy = x / 5;
        hasily = y / 5;
        p = hasilxy / hasily;
        
        return p;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smc.View;

/**
 *
 * @author Ali
 */
public class ScreenPage {
    
   public static void main(String[] args){
       Splash splash =new Splash();
       splash.setVisible(true);
       Login log=new Login();
       Dashboard dash =new Dashboard();
       try {
           
           for (int i = 0; i <= 100; i++) {
              
               Thread.sleep(40);
         splash.Loadingnum.setText(Integer.toString(i)+"%");
         splash.Loadingbar.setValue(i);
         
         if(i==100){
              splash.setVisible(false);
              log.setVisible(true);
         }
           }
         
           
           
       } catch (Exception e) {
       }
       
       
   }
    
    
}

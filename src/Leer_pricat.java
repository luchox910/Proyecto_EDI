
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LX-SYSTEMS
 */
public class Leer_pricat {
    public static String ruta,  cadena,np2,np,sret;
    
    //public static Object datospS[] = new Object[1000];
    public String snov, sret1, smod,gln,npricat,descl,pricat,sreference,np13x,producto,NLIN;
    public static int np13, np13e,NLINS;
    public static Object datosp[];
    public static Object Vean[], Vdescl[],Vdescc[];
    
 ///////////////////////////////////////////////////////   
    
    
    //////////////////////////////////////////////////
    
    
    
    public void leer_archivo(){
        
        
        Class_regex reg = new Class_regex();
         Frm_Pricat fp = new Frm_Pricat();
         ruta= fp.ruta;
         
         
         
         
         
         
        //reg.open_pricat();
         if (ruta == null)
        {
            
            JOptionPane.showMessageDialog(null,"Debe seleccionar un archivo primero");
        }
        else
        {
            
           
        
        
        
            try {
                reg.expresiones();
                
                //JOptionPane.showMessageDialog(null,"Esta es la ruta correcta"+ ruta);
                FileReader f = null;
            f = new FileReader(ruta);
            try (BufferedReader b = new BufferedReader(f)) {
                while ((cadena = b.readLine())!=null) {
                    System.out.println(cadena);
                    
                     
                    //aqui va
                    
                    
                    
                    Pattern PLIN = Pattern.compile(reg.LIN);
                    Matcher MLIN = PLIN.matcher(cadena);
                    
                    
                    Pattern MY_PATTERN = Pattern.compile(reg.GLN);
                    Matcher m = MY_PATTERN.matcher(cadena);
                    Pattern MY_PATTERN8 = Pattern.compile(reg.SEND);
                    Matcher m8 = MY_PATTERN8.matcher(cadena);
                    
                    Pattern MY_PATTERN2 = Pattern.compile(reg.DESCL);
                    Pattern PDESCC = Pattern.compile(reg.DESCC);
                    
                    Matcher m2 = MY_PATTERN2.matcher(cadena);
                    Pattern MY_PATTERN3 = Pattern.compile(reg.BGM);
                    Matcher m3 = MY_PATTERN3.matcher(cadena);
                    Pattern MY_PATTERN4 = Pattern.compile(reg.EAN13);
                    Pattern MY_PATTERN5 = Pattern.compile(reg.EAN14);
                    Pattern MY_PATTERN6 = Pattern.compile(reg.UPC);
                    Pattern MY_PATTERN7 = Pattern.compile(reg.RET);
                    Matcher m4 = MY_PATTERN4.matcher(cadena);
                    Matcher m5 = MY_PATTERN5.matcher(cadena);
                    Matcher m6 = MY_PATTERN6.matcher(cadena);
                    Matcher m7 = MY_PATTERN7.matcher(cadena);
                    Pattern MY_PATTERN9 = Pattern.compile(reg.NADICION);
                    
                    Matcher m9 = MY_PATTERN9.matcher(cadena);
                     np13=0;
                     np13e=0;
                    Frm_productos p = new Frm_productos();
                    //////////////////////////////////////
                    //JOptionPane.showMessageDialog(null,cadena);
                    //StringTokenizer st = new StringTokenizer(cadena,"DX",true);
                    //JOptionPane.showMessageDialog(null,"hay un total de " + st.countTokens()+ "token");
                    
                    
                    
                    
                    
                    
                    StringBuilder devolver = new StringBuilder();
                    while(m9.find())
                    {
                        String np= m9.group(1);
                        
                        
                        devolver.append("palabra  ").append(m9.group()).append("encontrada  ").append(m9.start());
                        np13++;
                       // JOptionPane.showMessageDialog(null,"productos  : " + np);//np contiene las barras encontradas por regex
                        
                    }
                    devolver.insert(0,np13);
                    //JOptionPane.showMessageDialog(null,"son : " + np13);//variable np13 es un contador de las barras
                    System.out.append(devolver.toString());
                    np13x= (String.valueOf(np13));
                      datosp = new Object[np13+1];
                      Vean = new Object[np13+1];
                      Vdescl = new Object[np13+1];
                      Vdescc= new Object[np13+1];
                    
                    //fp.lbl_narticulos.setText(String.valueOf(np13));
                    
                 
                    
                    ////////////////////////////////////////////
                    
                     StringBuilder detalle = new StringBuilder();
                     int i = 1;
                    while(MLIN.find())
                    {
                        NLIN= MLIN.group();
                        
                        
                        devolver.append("palabra  ").append(MLIN.group()).append("encontrada  ").append(MLIN.start());
                        NLINS++;
                        //JOptionPane.showMessageDialog(null,"numero de lin : " + NLIN);
                        i++;
                        datosp[NLINS]=NLIN;
                    }
                    devolver.insert(0,NLINS);
                    //JOptionPane.showMessageDialog(null,"numero de lin : " + NLINS);
                    System.out.append(devolver.toString());
                    //np13x= (String.valueOf(np13));
                    //JOptionPane.showMessageDialog(null,"numero de lin : " + datosp[5]);
                   
                    Pattern PEANADICION = Pattern.compile(reg.ean);
                    
                    
                    
                    ////////////////////////////////////////////////
                     for(int x=1;x<=np13;x++)
                     {
                     
                    
                        Matcher mean = PEANADICION.matcher(String.valueOf(datosp[x]));
                        if(mean.find())
                        {
                            //JOptionPane.showMessageDialog(null,"la barra numero" +x+ "corresponde a "+ datosp[x] );
                            ///////////prueba
                            Matcher madi = MY_PATTERN9.matcher(datosp[x].toString());
                            Matcher descl= MY_PATTERN2.matcher(datosp[x].toString());
                            Matcher MDESCC = PDESCC.matcher(datosp[x].toString());
                            String ean, dl, dc;
                            ean="";
                            dl="";
                            dc="";
                            
                            
                           if(madi.find())
                           {
                               ean=madi.group(1);
                               Vean[x]= ean;
                               
                           }
                           
                           else
                           {
                           Vean[x]= "NA";
                           
                           }
                           
                           
                            if(descl.find())
                            {
                                
                                dl= descl.group(1);
                                
                                Vdescl[x]=dl;
                                
                            }
                            else
                            {
                                Vdescl[x]="NA";
                            }
                            
                            
                            

                        if(MDESCC.find())
                            
                            {
                                dc= MDESCC.group(1);
                                Vdescc[x]=dc;
                            }
                            else
                            {
                             Vdescc[x]="NA";   
                            }       
                            
                            
                            
                                 
                            //JOptionPane.showMessageDialog(null,"pruebaaa"+ ean+ " "+dl  ); 
                            
                            
                           
                        }
                             
                        
                    }//for
                     
                     
                
                    
                    
                    
                    ////////////////////////////////////////////////777
                    
                    
                    
                    
                    if(m4.find() || m6.find())
                    {
                         snov = "ADICION";
                        
                        //fp.lbl_novedad.setText("ADICION");
                        //fp.lbl_novedad.setForeground(Color.green);
                        
                        
                        
                    }
                    else
                        if(m7.find())
                        {
                             sret= "RETIRO" ;
                             Frm_Pricat.lbl_segmentos.setText("prueba");
                            //fp.lbl_novedad.setText("RETIRO");
                            //fp.lbl_novedad.setForeground(Color.red);
                            //fp.txt_descl.setText("N/A");
                            
                        }
                        else
                        {
                            smod="MODIFICACION";
                           // fp.lbl_novedad.setText("MODIFICACION");
                            //fp.lbl_novedad.setForeground(Color.blue);
                        }
                    
                    if (m.find() )
                    {
                        
                        gln = m.group(1);
                        
                        //System.out.print(s);
                        //fp.lbl_gln.setText(s);
                        
                        
                        
                        
                    }
                    if (m2.find()  )
                    {
                        
                        
                         descl = m2.group(1);
                        
                        
                        //fp.txt_descl.setText(descl);
                        
                        
                    }
                    if (m3.find()  )
                    {
                        
                        
                        pricat = m3.group(1);
                        
                        
                        //fp.txt_bgm.setText(s3);
                        
                    }
                    if(m8.find())
                    {
                         sreference= m8.group(1);
                        //fp.lbl_sendrefenrence.setText(s8);
                        
                    }
                   
                      
                }
                           
                
            } catch (IOException ex) {
                Logger.getLogger(Leer_pricat.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer_pricat.class.getName()).log(Level.SEVERE, null, ex);
        }
 
           
        }

        //ruta= "C:\\Users\\LX-SYSTEMS\\Desktop\\pricat\\PRICAT_EDIFACT_7702088092054_921610_7701008100015-ADICION-1940.edi";
        
    }
    
}

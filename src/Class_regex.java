

import javax.swing.JFileChooser;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LX-SYSTEMS
 */
public class Class_regex {
    String GLN, DESCL,DESCC,BGM,NOVEDAD,EAN13,EAN14,UPC,AD,RET,SEND,NADICION,ruta,ruta2,ean,divisor,LIN;//variables que almacenan las ER
    
    public void expresiones(){//Defino las expresiones regulares para tomar la info del producto del archivo Edi
        
        
         
            //GLN = ("^(NAD+).(SU+).([0-9])");
            
            //GLN=(" *\\+(\\d{13})::\\d");
            GLN=("NAD\\+SU\\+(\\d{13})::9");
            //GLN =("\\+SU.(.*?).(::9')");
            //DESCL= ("\\+F+(.*?).(')");
            //DESCL=("IMD\\+F\\+DSC\\+:::(.{1,40})\\'");
            DESCL=("IMD\\+F\\+DSC\\+:::(([a-bA-Z0-9 :.]{1,41})|)'IMD\\+");
            DESCC=("IMD\\+D\\+DSC\\+:::(([a-bA-Z0-9 :.]{1,41})|)'IMD\\+");
            BGM= ("BGM\\+9\\+(.*)\\+4'");
            EAN13=("LIN\\+1\\+1\\+(\\d{13}):UP'");
            EAN14=("LIN\\+1\\+1\\+(\\d{14}):EN'");
            UPC=("LIN\\+1\\+1\\+(\\d{8}):UP'");
            NADICION=("LIN\\+\\d{1,3}\\+1\\+(\\d{8,14}):(UP|EN)'");
            
            RET=("LIN\\+1\\+2\\+(\\d{8,14}):EN|UP'");
            SEND=("\\+(\\d{6})\\+        \\+PRICAT'UNH");
            ean="LIN\\+\\d{1,3}\\+1\\+(\\d{8,14}):(EN|UP)'";
            divisor=("PAC\\+\\+\\d{1,2}");
            LIN=("LIN\\+\\d{1,3}\\+1\\+\\d{8,14}:\\S{2}'+PIA\\+1\\+\\S{1,90}:+(GB'|SA'|GN')+((IMD\\+(D|F)\\+DSC\\+:::.[A-Z0-9 +.,%-:]{1,40}'){1,2})+((IMD\\+C\\+\\+((CU')|(DU')|(TU'))){1,3})+((IMD\\+F\\+((1)|(35)|(79)|(BRN)|(MNF)|(TDS))\\+:::[A-Z0-9 +.,%-:]{1,37}'){1,6})+((MEA\\+((PD)|(AAE))\\+((HT)|(TC::[0-9]{1,3})|(WD)|(AAF)|(DP)|(T)|(AAB)|(ABJ)|(LAY)|(ULY))\\+((CMT)|(KGM)|(GRM)|(MMT)|(CMQ)|(CEL)|(NAR)):[0-9.]{1,8}'){1,7})+((QTY\\+((129:)|(52:)|(53:))([0-9.]{1,5}|\\+)((:NAR')|(:PCE'|:GRM'|[0-9]{2}))){1,3})");
            
            
            
            
    }
    
    
    
    
    public void open_pricat()
    
    {//abro filechoser y guardo la ruta en variable ruta
        Frm_Pricat fp = new Frm_Pricat();
        Leer_pricat lp = new Leer_pricat();
         FileFilter filtro = new FileNameExtensionFilter("EDI","Edi");
        fp.Jfile_edi.setFileFilter(filtro);
            if(fp.Jfile_edi.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){ 
ruta = fp.Jfile_edi.getSelectedFile().getAbsolutePath(); 
//lp.ruta= ruta;

       
//fp.jLabel13.setText("dsds");


} 
            
        
        

    }
    
    
    
    public void compila()
    {
        
        
    }

    String ruta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

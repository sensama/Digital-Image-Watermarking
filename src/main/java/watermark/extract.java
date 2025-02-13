package watermark;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Jama.Matrix;
import Jama.SingularValueDecomposition;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import static watermark.embed.makeGray;


/**
 *
 * @author Kush
 */
public class extract extends javax.swing.JFrame {

    long startTime;
     double hostred[][];
    double hostgreen[][];
    double hostblue[][];
    double host[][];
    double watermark[][];
    double watermarkgray[][];
    double watermarkgrayoriginal[][];
    double hostgray[][];
    double watermarkedgray[][];
    double watermarkred[][];
    double watermarkgreen[][];
    double watermarkblue[][];
    File hostimage;
    File watermarkimage;
    File watermarkedimage;
    double alpha=0.1;
    /**
     * Creates new form extract
     */
    public extract() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Host Image");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Watermark Image");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Watermarked Image");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Extract");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setText("...");

        jLabel2.setText("...");

        jLabel3.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(24, 24, 24)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton5)
                .addGap(30, 30, 30)
                .addComponent(jButton4)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
JFileChooser chooser=new JFileChooser();
       chooser.showOpenDialog(null);
        hostimage=chooser.getSelectedFile();
        String hostname= hostimage.getAbsolutePath();
        String mimetype= new MimetypesFileTypeMap().getContentType(hostimage);
        String type = mimetype.split("/")[0];
        if(type.equals("image"))
        {System.out.println("It's an image");
            jLabel1.setText(hostname);}
        else 
        {jLabel1.setText("Invalid file format");
        JOptionPane.showMessageDialog(null,"Please select an image file for host");
        } 
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       JFileChooser chooser1=new JFileChooser();
       chooser1.showOpenDialog(null);
        watermarkimage=chooser1.getSelectedFile();
       String watermarkname= watermarkimage.getAbsolutePath();
       String mimetype= new MimetypesFileTypeMap().getContentType(watermarkimage);
        String type = mimetype.split("/")[0];
        if(type.equals("image"))
        {System.out.println("It's an image");
            jLabel2.setText(watermarkname);}
        else 
        {jLabel2.setText("Invalid file format");
        JOptionPane.showMessageDialog(null,"Please select an image file for watermark");
        } 
        //jLabel2.setText("...");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser chooser1=new JFileChooser();
       chooser1.showOpenDialog(null);
        watermarkedimage=chooser1.getSelectedFile();
       String watermarkedname= watermarkedimage.getAbsolutePath();
       String mimetype= new MimetypesFileTypeMap().getContentType(watermarkimage);
        String type = mimetype.split("/")[0];
        if(type.equals("image"))
        {System.out.println("It's an image");
            jLabel3.setText(watermarkedname);}
        else 
        {jLabel3.setText("Invalid file format");
        JOptionPane.showMessageDialog(null,"Please select an image file for watermark");
        } 
        //jLabel2.setText("...");
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
             startTime = System.nanoTime();

            jLabel3.setText("Extracting. Please wait");
        extracting();
        
        
           jLabel3.setText("Done"); 
// TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(embed.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(extract.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(extract.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(extract.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(extract.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new extract().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    private void extracting() throws IOException {
        //reading watermarkimage
          //reading watermarkimage
         wavelet dwt=new wavelet();
         dct dctt=new dct();
        
        BufferedImage watermarksample=ImageIO.read(watermarkimage);
        String watername=watermarkimage.getName();
        watermarkgrayoriginal=makeGray(watermarksample);
        //separating r,g and b bands
         //watermarkred=getRed(watermarksample);
        //watermarkgreen=getGreen(watermarksample);
        //watermarkblue=getBlue(watermarksample);
        
      
       // for holding one half of watermark. The other will be held in the original
        
//       double watermarkred1[][]=new double[watermarkred.length][watermarkred[0].length];
   //    double watermarkgreen1[][]=new double[watermarkgreen.length][watermarkgreen[0].length];
     //  double watermarkblue1[][]=new double[watermarkgreen.length][watermarkgreen[0].length];
     //  double watermarkgray1[][]=new double[watermarkgray.length][watermarkgray[0].length];
       
         BufferedImage cover=ImageIO.read(hostimage);
         String hostname=hostimage.getName();
         hostgray=makeGray(cover);
         
         
         BufferedImage watermarked=ImageIO.read(watermarkedimage);
         watermarkedgray=makeGray(watermarked);
         String watermarkedname=watermarkedimage.getName();
         System.out.println("Extracting");
        
         
         
         hostgray=dwt.forwardwavlet(hostgray);
         
         watermarkedgray=dwt.forwardwavlet(watermarkedgray);
         
         watermarkgray=dwt.forwardwavlet(watermarkgrayoriginal);
         
            matrixopn obj=new matrixopn();
        double[][] hHL = obj.getHL(hostgray);
        double[][] hLH = obj.getLH(hostgray);
        double[][] hLL = obj.getLL(hostgray);
        double[][] hHH = obj.getHH(hostgray);
        
        
                    double [][]hostHL=dct.DCT2(hHL);
                    double [][]hostHH=dct.DCT2(hHH);
                    double [][]hostLH=dct.DCT2(hLH);
                    double [][]hostLL=dct.DCT2(hLL);
        
                    
        double[][] wHL = obj.getHL(watermarkgray);
        double[][] wLH = obj.getLH(watermarkgray);
        double[][] wLL = obj.getLL(watermarkgray);
        double[][] wHH = obj.getHH(watermarkgray);
        
           
                    double [][]waterHL=dct.DCT2(wHL);
                    double [][]waterHH=dct.DCT2(wHH);
                    double [][]waterLH=dct.DCT2(wLH);
                    double [][]waterLL=dct.DCT2(wLL);
                    
                    
                    
        double[][] fHL = obj.getHL(watermarkedgray);
        double[][] fLH = obj.getLH(watermarkedgray);
        double[][] fLL = obj.getLL(watermarkedgray);
        double[][] fHH = obj.getHH(watermarkedgray);
        
        
                    double [][]finalHL=dct.DCT2(fHL);
                    double [][]finalHH=dct.DCT2(fHH);
                    double [][]finalLH=dct.DCT2(fLH);
                    double [][]finalLL=dct.DCT2(fLL);            
                    
         Matrix jamafinalHL=new Matrix(finalHL);
         Matrix jamafinalHH=new Matrix(finalHH);
         Matrix jamafinalLH=new Matrix(finalLH);
         Matrix jamafinalLL=new Matrix(finalLL);
                              
         Matrix jamahostHL=new Matrix(hostHL);
         Matrix jamahostHH=new Matrix(hostHH);
         Matrix jamahostLH=new Matrix(hostLH);
         Matrix jamahostLL=new Matrix(hostLL);
         
         Matrix jamawaterHL=new Matrix(waterHL);
         Matrix jamawaterHH=new Matrix(waterHH);
         Matrix jamawaterLH=new Matrix(waterLH);
         Matrix jamawaterLL=new Matrix(waterLL);
         
         SingularValueDecomposition svdfinalHL = jamafinalHL.svd();
         SingularValueDecomposition svdfinalLH = jamafinalLH.svd();
         SingularValueDecomposition svdfinalHH = jamafinalHH.svd();
         SingularValueDecomposition svdfinalLL = jamafinalLL.svd();
         
         SingularValueDecomposition svdhostHL = jamahostHL.svd();
         SingularValueDecomposition svdhostLH = jamahostLH.svd();
         SingularValueDecomposition svdhostHH = jamahostHH.svd();
         SingularValueDecomposition svdhostLL = jamahostLL.svd();
         
         SingularValueDecomposition svdwaterHL = jamawaterHL .svd();
         SingularValueDecomposition svdwaterLH = jamawaterLH.svd();
         SingularValueDecomposition svdwaterHH = jamawaterHH .svd();
         SingularValueDecomposition svdwaterLL = jamawaterLL.svd();
         
         Matrix S_hostHL=svdhostHL.getS();
         Matrix S_hostLH=svdhostLH.getS();
         Matrix S_hostHH=svdhostHH.getS();
         Matrix S_hostLL=svdhostLL.getS();
         
         Matrix S_finalHL=svdfinalHL.getS();
         Matrix S_finalLH=svdfinalLH.getS();
         Matrix S_finalHH=svdfinalHH.getS();
         Matrix S_finalLL=svdfinalLL.getS();
         
      
        
         Matrix S_extrHL=S_finalHL.minus(S_hostHL);
         Matrix S_extrLH=S_finalLH.minus(S_hostLH);
         Matrix S_extrHH=S_finalHH.minus(S_hostHH);
         Matrix S_extrLL=S_finalLL.minus(S_hostLL);
         
        Matrix S_extractedHL=S_extrHL.times((1/alpha));
        Matrix S_extractedLH=S_extrLH.times((1/alpha));
        Matrix S_extractedHH=S_extrHH.times((1/alpha));
        Matrix S_extractedLL=S_extrLL.times((1/alpha));
         
         
         Matrix HLextrhalf=svdwaterHL.getU().times(S_extractedHL);
         Matrix HLextrfull=HLextrhalf.times(svdwaterHL.getV().transpose());
         
         
         Matrix LHextrhalf=svdwaterLH.getU().times(S_extractedLH);
         Matrix LHextrfull=LHextrhalf.times(svdwaterLH.getV().transpose());
         
         
         Matrix HHextrhalf=svdwaterHH.getU().times(S_extractedHH);
         Matrix HHextrfull=HHextrhalf.times(svdwaterHH.getV().transpose());
         
         
         Matrix LLextrhalf=svdwaterLL.getU().times(S_extractedLL);
         Matrix LLextrfull=LLextrhalf.times(svdwaterLL.getV().transpose());
         
         double[][]HLextr=HLextrfull.getArray();
         double[][]HHextr=HHextrfull.getArray();
         double[][]LHextr=LHextrfull.getArray();
         double[][]LLextr=LLextrfull.getArray();
         
         
    
         
                    double [][]waterextHL=dct.IDCT2(HLextr);
                    double [][]waterextHH=dct.IDCT2(HHextr);
                    double [][]waterextLH=dct.IDCT2(LHextr);
                    double [][]waterextLL=dct.IDCT2(LLextr);
         
                    
                    
         double newwater[][]=obj.getoriginal(waterextLL, waterextHL, waterextLH, waterextHH);
                    
         newwater=dwt.inversewavlet(newwater);
         
         double nc=parameters.nc(watermarkgrayoriginal,newwater);
         
         
         
                    
        int ff=0;
           BufferedImage image2 = new BufferedImage(newwater.length, newwater[0].length, BufferedImage.TYPE_INT_RGB);
      BufferedImage image3 = new BufferedImage(watermarkgrayoriginal.length, watermarkgrayoriginal[0].length, BufferedImage.TYPE_INT_RGB);
      
           for(int i=0; i<newwater.length; i++) {
          
        for(int j=0; j<newwater[0].length; j++) {
            int a = (int)newwater[i][j];
            int b=  (int)newwater[i][j];
            int c=  (int)newwater[i][j];
            if(a>255)
               
                a=255;
            if(a<0)
                a=0;
            if(b>255)
                b=255;
            if(b<0)
                b=0;
            if(c>255)
                c=255;
            if(c<0)
                c=0;
            Color newColor = new Color(a,b,c);
            image2.setRGB(i,j,newColor.getRGB());
            
        
    }
       }
   File  output1 = new File("C:\\Users\\kush\\Documents\\Aaatesting\\extracted"+watername+" with nc="+nc+" from '"+watermarkedname+"'.jpg");
    ImageIO.write(image2, "jpg", output1);
    
    
       for(int i=0; i<newwater.length; i++) {
          
        for(int j=0; j<newwater[0].length; j++) {
            int a = (int)watermarkgrayoriginal[i][j];
            int b=  (int)watermarkgrayoriginal[i][j];
            int c=  (int)watermarkgrayoriginal[i][j];
            if(a>255)
               
                a=255;
            if(a<0)
                a=0;
            if(b>255)
                b=255;
            if(b<0)
                b=0;
            if(c>255)
                c=255;
            if(c<0)
                c=0;
            Color newColor = new Color(a,b,c);
            image3.setRGB(i,j,newColor.getRGB());
            
        
    }
       }
   File  output11 = new File("C:\\Users\\kush\\Documents\\Aaatesting\\original"+watername+" watermark.jpg");
    ImageIO.write(image3, "jpg", output11);
    long endTime = System.nanoTime();

        long duration = (endTime - startTime)/1000000000;
        
        System.out.println(" hello "+duration+" seconds lagyo extract garna");

    JOptionPane.showMessageDialog(null,"The waterwater has been extracted with a NC of "+nc);

    
       
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

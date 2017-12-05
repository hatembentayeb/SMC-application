import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**

 */
public class Pdfgen {

    public static void main(String[] args) throws IOException {
     String h ="hatem";
        Document document = new Document();
        

        try {
          PdfWriter w=   PdfWriter.getInstance(document,
                new FileOutputStream("HelloWorld.pdf"));
            
            
            
            document.open();
           
           PdfWriter.getInstance(document,
          new FileOutputStream("Paragraph.pdf"));

            document.open();
            
            //-------------------------
            Font font1 = new Font(Font.FontFamily.COURIER  , 12, Font.BOLD);
            Font font2 = new Font(Font.FontFamily.COURIER  , 9, Font.BOLD);
            Font font3 = new Font(Font.FontFamily.HELVETICA  , 27, Font.BOLD);
            //-------------------------
            // ajout de l'image logo
            Image image =  Image.getInstance("/home/hatembt/pdfgen/smc.png");
            image.scalePercent(60f);
            image.setAbsolutePosition(110, 780);
            document.add(image);
            
            //ajout de présentation de société
            Paragraph sp = new Paragraph();
            Phrase ph = new Phrase();
            Phrase ph1 = new Phrase();
            Phrase ph2 = new Phrase();
            Phrase ph3 = new Phrase();
            Chunk t1 = new Chunk("Société Maamoun de Commerce suarl",font1);
            Chunk t2 = new Chunk("\n       av. Ibn kaldoun 5080 téboulba",font2);
            Chunk t3 = new Chunk("\n   M.F 1434385A/P/M/000 -R.C. B155812016 \n             Tel:96 631 572 \n",font2);
            Chunk t4 = new Chunk("              FACTURE",font3);
            Chunk t5 = new Chunk("N° Facture   : ............ ",font1);
            Chunk t6 = new Chunk("Date Facture : ............ ",font1);
            
            Chunk t7 = new Chunk("                                 "+""
                    + "          Client  : ...........",font1);
            Chunk t8 = new Chunk("               Adresse : ...........",font1);
            Chunk t9 = new Chunk("               M.F     : ...........",font1);
            
            ph.add(t1);
            ph.add(t4);
            sp.add(ph); 
            sp.add(t2);
            
            ph1.add(t3);
            sp.add(ph1);
            
             sp.add(t7);
            sp.add(Chunk.NEWLINE);
            ph2.add(t5);
            ph2.add(t8);
            sp.add(ph2);
            sp.add(Chunk.NEWLINE);
            
            ph3.add(t6);
            ph3.add(t9);
            sp.add(ph3);
            sp.add(Chunk.NEWLINE);
            
            
            sp.setSpacingAfter(25);
            sp.setSpacingBefore(25);

            
           
            //-------------------------
            //creation des tableaux
 
          // table 3
          PdfPTable table3 = new PdfPTable(5);
            table3.setTotalWidth(523f);
            table3.setLockedWidth(true);
            table3.setWidths(new float[]{ 2, 2,2,2,2});
            table3.setSpacingBefore(10);
            PdfPCell cell3;
            cell3 = new PdfPCell(new Phrase("Quantité"));
            cell3.setPadding(10);
            table3.addCell(cell3);
            table3.addCell("désignation");
            table3.addCell("Prix Unitaire HT");
            table3.addCell("TVA");
            table3.addCell("Prix Total HT");
            
            for(int i=0;i<16;i++){
                cell3 = new PdfPCell(new Phrase(""));
                cell3.setPadding(10);
            table3.addCell(cell3);
            table3.addCell("");
            table3.addCell("");
            table3.addCell("");
            table3.addCell("");
            }
             
            
            Paragraph p = new Paragraph();
            Phrase pp1 = new Phrase();
            Phrase pp2 = new Phrase();
            Phrase pp3 = new Phrase();
            Chunk x1 = new Chunk("\n\nBase HT  : .............",font1);
            Chunk x2 = new Chunk("Taux TVA : .............",font1);
            Chunk x3 = new Chunk("TVA      : .............",font1);
            
            Chunk x4= new Chunk("              Total HT        : .............\n",font1);
            Chunk x5 = new Chunk("              TVA             : ............. \n",font1);
            Chunk x6 = new Chunk("              Doit de Timpbre : .............\n",font1);
            pp1.add(x1);
            pp1.add(x4);
            p.add(pp1);
            pp2.add(x2);
            pp2.add(x5);
            p.add(pp2);
            pp3.add(x3);
            pp3.add(x6);
            p.add(pp3);
            
            Phrase pp4 = new Phrase();
            Chunk y1 = new Chunk("\n\nLa présente Facture arrête a la somme de:",font2);
            Chunk y2 = new Chunk("       TTC : ......................... ",font1);
            Chunk y3 = new Chunk("\n............. ............. .............\n ............. ............. .............",font2);
            pp4.add(y1);
            pp4.add(y2);
            pp4.add(y3);
            p.add(pp4);
            // ecriture sur le document
             document.add(sp);
   
             document.add(table3);
             document.add(p);
            


                    
            document.close(); // no need to close PDFwriter?

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
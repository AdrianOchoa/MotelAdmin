/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.modelos;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.me.util.Message;

/**
 *
 * @author Adrián
 */
public class PDFHelper {

    private Document doc;
    private String tituloPDF;
    private String ruta;
    private final Font fuenteNormal = FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK);
    private final Font fuenteTabla = FontFactory.getFont("arial", 13, Font.BOLD, BaseColor.BLACK);
    private final String dbUser;
    private final String dbPassword;

    public PDFHelper(String dbUser, String dbPassword) {
        doc = null;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public boolean generarReporteEmpleados() throws DocumentException,
            SQLException, FileNotFoundException,
            BadElementException, IOException, ClassNotFoundException {
        DataBaseHelper dbh = new DataBaseHelper(dbUser, dbPassword);
        tituloPDF = "REPORTE MENSUAL DE EMPLEADOS";
        //Con esto se comprueba que hay registros
        dbh.iniciarConexion();
//        String columnas = dbh.executeQueryRS("select * from empleado;");
        dbh.cerrarConexion();
//        if (columnas.length() > 0) {
//            doc = inicializarDocumento();
//            doc.open();
//            //Se añaden los datos de cajón
//            Paragraph parrafo = setDatos(doc, tituloPDF);
//            parrafoNormal(parrafo);
//            //Tabla de empleados por estado
//            addParrafo(parrafo, doc, "Relación de empleados por estado");
//            addLineaVacia(parrafo, doc);
//        }
        return false;
    }

    private Document inicializarDocumento() throws DocumentException, FileNotFoundException {
        Document documento = new Document(PageSize.LETTER);
        documento.setMargins(100, 100, 50, 100);
        ruta = obtenerRuta();
        PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(ruta));
        return documento;
    }

    public Paragraph setDatos(Document doc, String nombreReporte) throws
            BadElementException, DocumentException, IOException {
        //Cosillas del logo
        Image imagenLogo = Image.getInstance("G:\\NetBeansProjects\\GeneracionPDFS\\logo.jpg");
        //ancho alto
        imagenLogo.scaleToFit(60, 120);
        imagenLogo.setAbsolutePosition(80, doc.getPageSize().getHeight() - 100);
        doc.add(imagenLogo);
        //agregar titulo
        Paragraph parrafo = new Paragraph();
        parrafo.setSpacingBefore(1);
        parrafo.setIndentationLeft(60);
        final Font fuenteTitulos = FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK);
        parrafo.setFont(fuenteTitulos);
        addParrafo(parrafo, doc, "LORD ORDO S.A. DE C.V.");
        parrafo.setFont(fuenteNormal);
        addParrafo(parrafo, doc, "Av. Constituyentes #42, Veracruz, ver.");
        addParrafo(parrafo, doc, "RFC GORO285849HV3");
        parrafo.setIndentationLeft(0);
        parrafo.setFont(fuenteTitulos);
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        addLineaVacia(parrafo, doc);
        addLineaVacia(parrafo, doc);
        addParrafo(parrafo, doc, nombreReporte);
        addParrafo(parrafo, doc, "-------------------------------------------------------------------------------------------------------");
        parrafo.add(new Paragraph(""));
        doc.add(parrafo);
        return parrafo;
    }

    private void addParrafo(Paragraph parrafo, Document doc, String texto)
            throws DocumentException {
        parrafo.add(texto);
        doc.add(parrafo);
        parrafo.clear();
    }

    private void addLineaVacia(Paragraph parrafo, Document doc)
            throws DocumentException {
        parrafo.add(new Paragraph(""));
        doc.add(parrafo);
        parrafo.clear();
    }

    private void parrafoNormal(Paragraph parrafo) {
        parrafo.setFont(fuenteNormal);
        parrafo.setAlignment(Paragraph.ALIGN_LEFT);
        parrafo.setSpacingBefore(10);
    }

    private String obtenerRuta() {
        String url;
        JFileChooser chooser = new JFileChooser();
        int c = chooser.showSaveDialog(null);
        while (c != JFileChooser.APPROVE_OPTION) {
            c = chooser.showSaveDialog(null);
        }
        url = chooser.getSelectedFile().getAbsolutePath();
        return url + ".pdf";
    }

}

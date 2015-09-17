package co.edu.sena.report;

import co.edu.sena.procedure.Conexion;
import java.io.File;
import java.io.IOException;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;


@Named(value = "exportarReportar")
@RequestScoped
public class ExportReport {

    public void exportPDF(ActionEvent actionEvent,String NomReporte) throws JRException, IOException {
        Conexion conn = new Conexion();
        conn.conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/MostrarReportes/"+NomReporte+".jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null, conn.getCon());

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename="+NomReporte+".pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
        stream.flush();
        stream.close();

        FacesContext.getCurrentInstance().responseComplete();
    }

    public void viewPDF(ActionEvent actionEvent,String NomReporte) throws Exception {
        Conexion conn = new Conexion();
        conn.conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/MostrarReportes/"+NomReporte+".jasper"));

        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, conn.getCon());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream outStream = response.getOutputStream();
        outStream.write(bytes, 0, bytes.length);
        outStream.flush();
        outStream.close();

        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportExcel(ActionEvent actionEvent,String NomReporte) throws JRException, IOException {
        Conexion conn = new Conexion();
        conn.conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/MostrarReportes/"+NomReporte+".jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null, conn.getCon());

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.xls");
        ServletOutputStream outStream = response.getOutputStream();

        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
        exporter.exportReport();

        outStream.flush();
        outStream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportDOC(ActionEvent actionEvent,String NomReporte) throws JRException, IOException {
        Conexion conn = new Conexion();
        conn.conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/MostrarReportes/"+NomReporte+".jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null, conn.getCon());

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.doc");
        ServletOutputStream outStream = response.getOutputStream();

        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
        exporter.exportReport();

        outStream.flush();
        outStream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportPPT(ActionEvent actionEvent,String NomReporte) throws JRException, IOException {
        Conexion conn = new Conexion();
        conn.conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/MostrarReportes/"+NomReporte+".jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null, conn.getCon());

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.ppt");
        ServletOutputStream outStream = response.getOutputStream();

        JRPptxExporter exporter = new JRPptxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
        exporter.exportReport();

        outStream.flush();
        outStream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

}

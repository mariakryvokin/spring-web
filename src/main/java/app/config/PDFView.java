package app.config;

import com.lowagie.text.Table;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class PDFView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> map, com.lowagie.text.Document document, com.lowagie.text.pdf.PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
   /*     Table table = new Table(2);
        table.addCell("Month");
        table.addCell("Revenue");

        for (Map.Entry<String, String> entry : revenueData.entrySet()) {
            table.addCell(entry.getKey());
            table.addCell(entry.getValue());
        }

        document.add(table);*/
    }
}

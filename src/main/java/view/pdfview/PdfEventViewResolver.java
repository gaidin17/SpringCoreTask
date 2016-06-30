package view.pdfview;

import com.lowagie.text.*;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfWriter;
import domain.Event;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.Font;
import java.util.Map;

/**
 * Created by Evgeny_Akulenko on 6/28/2016.
 */
public class PdfEventViewResolver extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {
        Paragraph title = new Paragraph("Event",
                FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD,
                new CMYKColor(0, 255, 255, 17)));

        title.setAlignment(Element.ALIGN_CENTER);

        @SuppressWarnings("unchecked")
        Event event = (Event) model.get("event");
        Table table = new Table(2);
        table.setBorderWidth(1);
        table.setBorderColor(new Color(0, 0, 255));
        table.setPadding(5);
        table.setSpacing(2);

        Cell cell = new Cell("Event name:");
        cell.setBorderColor(new Color(255, 0, 0));
        table.addCell(cell);
        cell = new Cell(event.getName());
        cell.setBorderColor(new Color(255, 0, 0));
        table.addCell(cell);

        cell = new Cell("Event date:");
        cell.setBorderColor(new Color(255, 0, 0));
        table.addCell(cell);
        cell = new Cell(event.getDate().toString());
        cell.setBorderColor(new Color(255, 0, 0));
        table.addCell(cell);

        cell = new Cell("Event time:");
        cell.setBorderColor(new Color(255, 0, 0));
        table.addCell(cell);
        cell = new Cell(event.getTime().toString());
        cell.setBorderColor(new Color(255, 0, 0));
        table.addCell(cell);

        cell = new Cell("Event base price:");
        cell.setBorderColor(new Color(255, 0, 0));
        table.addCell(cell);
        cell = new Cell(event.getBasePrice().toString());
        cell.setBorderColor(new Color(255, 0, 0));
        table.addCell(cell);

        cell = new Cell("Event auditorium:");
        cell.setBorderColor(new Color(255, 0, 0));
        table.addCell(cell);
        cell = new Cell(event.getAuditorium().getName());
        cell.setBorderColor(new Color(255, 0, 0));
        table.addCell(cell);

        document.add(title);
        document.add(table);
        document.close();
    }
}

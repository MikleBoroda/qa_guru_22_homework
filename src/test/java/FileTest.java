import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;


public class FileTest {
    ClassLoader cl = FileTest.class.getClassLoader();

    @Test
    void xmlFromZipTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("zipTest.zip");
             ZipInputStream zis = new ZipInputStream(stream)) {

            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains(".xlsx")) {
                    XLS xls = new XLS(zis);
                    assertThat("Прайс-лист").isEqualTo(xls.excel.getSheetAt(0)
                            .getRow(0)
                            .getCell(1)
                            .getStringCellValue());
                    break;
                }
            }
        }
    }

    @Test
    void pdfFromZipTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("zipTest.zip");
             ZipInputStream zis = new ZipInputStream(stream)) {

            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains(".pdf")) {
                    PDF pdf = new PDF(zis);
                    assertThat("Java_questions.indd").isEqualTo(pdf.title);
                    break;
                }
            }
        }
    }

    @Test
    void csvTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("zipTest.zip");
             ZipInputStream zis = new ZipInputStream(stream)) {

            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> content = csvReader.readAll();

                    final String[] firstRow = content.get(0);
                    final String[] secondRow = content.get(1);
                    assertThat(new String[]{"City", "vladimir"}).isEqualTo(firstRow);
                    assertThat(new String[]{"Street", "Mira"}).isEqualTo(secondRow);
                    break;
                }
            }
        }
    }
}

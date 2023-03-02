import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

public class PicToPdf {
    public static void toPdf(String imageFolderPath, String pdfPath) {
        try {
            String imagePath = null;
            FileOutputStream fos = new FileOutputStream(pdfPath);
            Document doc = new Document(null, 0, 0, 0, 0);
            //doc.open();
            PdfWriter.getInstance(doc, fos);
            BufferedImage img = null;
            Image image = null;
            File file = new File(imageFolderPath);
            File[] files = FileOperate.sort(file.listFiles());
            for (File file1 : files) {
                if (file1.getName().endsWith(".png")
                        || file1.getName().endsWith(".jpg")
                        || file1.getName().endsWith(".gif")
                        || file1.getName().endsWith(".jpeg")
                        || file1.getName().endsWith(".tif")) {
                    // System.out.println(file1.getName());
                    imagePath = imageFolderPath + file1.getName();
                    System.out.println(imagePath);
                    img = ImageIO.read(new File(imagePath));
                    doc.setPageSize(new Rectangle(img.getWidth(), img
                            .getHeight()));
                    image = Image.getInstance(imagePath);
                    doc.open();
                    doc.add(image);
                }
            }
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

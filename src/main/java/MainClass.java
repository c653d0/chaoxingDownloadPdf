import java.io.File;

public class MainClass {
    public static void main(String[] args) {
        String url = "https://pan-yz.xueyinonline.com/screen/file_dc7a0531343e021f687aa467049e681d";
        String pdfName = "干涉.pdf";

        saveAsPdf(pdfName,url,0,0);
    }

    private static void saveAsPdf(String pdfName, String url, int start, int end){
        // 设置路径
        String picFolderPath = "D:\\downloadPdf\\pic\\";
        String pdfFolderPath = "D:\\downLoadPdf\\pdf\\";


        //操作前检查文件夹是否存在，若不存在则创建该文件夹
        File picFolder = new File(picFolderPath);
        File pdfFolder = new File(pdfFolderPath);
        if (!picFolder.exists()) {
            picFolder.mkdirs();
        }
        if (!pdfFolder.exists()) {
            pdfFolder.mkdirs();
        }

        if(start+end<=0){
            //
            GetPic.getPicFromHtml(url,picFolderPath);
        }else{
            //
            GetPic.getPicByNumber(start, end, ".png", picFolderPath,url);
        }


        //
        PicToPdf.toPdf(picFolderPath, pdfFolderPath + pdfName);

        //
        FileOperate.deleteFile(new File(picFolderPath));
    }
}

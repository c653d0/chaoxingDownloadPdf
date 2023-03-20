import java.io.File;

public class MainClass {
    public static void main(String[] args) {
        //将连接粘贴到url里边
        //注意:
        //     需要将链接最后一个斜杠后面的内容删除
        //示例：
        //     复制的链接为：https://s3.ananas.chaoxing.com/doc/be/0a/ea/e506a185e985d2bcb62d04b2459c3c3b/thumb/1.png
        //     粘贴的链接为：https://s3.ananas.chaoxing.com/doc/be/0a/ea/e506a185e985d2bcb62d04b2459c3c3b/thumb/

        String url = "https://s3.ananas.chaoxing.com/doc/be/0a/ea/e506a185e985d2bcb62d04b2459c3c3b/thumb/";

        //这个设置pdf的名字
        String pdfName = "test.pdf";

        //设置要下载的页数，第一个数字为起始页最小为1，第二个数字为结束也最多不超过pdf的总页数
        saveAsPdf(pdfName,url,1,11);
    }

    private static void saveAsPdf(String pdfName, String url, int start, int end){
        // 设置pdf保存的路径
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

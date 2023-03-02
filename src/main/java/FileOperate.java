import java.io.File;

public class FileOperate {

    //删除文件夹下所有文件，包括子文件夹的文件
    public static void deleteFile(File file){
        //防止文件不存在
        if(file==null || !file.exists()){
            System.out.println("file is not exist,delete failed");
            return;
        }
        try{
            //获取到文件夹下的所有文件
            File[] files = file.listFiles();
            for(File f : files){
                //如果是文件则进行删除
                if(f.isFile()){
                    if(f.delete())
                        System.out.println(f.getName()+" has been destroyed");
                    else{
                        System.out.println("delete failed");
                        return;
                    }
                }
                //如果试文件夹，则继续调用删除
                if(f.isDirectory()){
                    deleteFile(f);
                }
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        //删除这个文件夹，按需使用
        //file.delete();
    }

    //对文件列表按名称进行排序
    public static File[] sort(File[] s){
        //中间值
        File temp =null;
        //外循环:我认为最小的数,从0~长度-1
        for(int j = 0; j<s.length-1;j++){
            //最小值:假设第一个数就是最小的
            String min = s[j].getName();
            //记录最小数的下标的
            int minIndex=j;
            //内循环:拿我认为的最小的数和后面的数一个个进行比较
            for(int k=j+1;k<s.length;k++){
                //找到最小值
                if (Integer.parseInt(min.substring(0,min.indexOf(".")))>Integer.parseInt(s[k].getName().substring(0,s[k].getName().indexOf(".")))){
                    //修改最小
                    min=s[k].getName();
                    minIndex=k;
                }
            }
            //当退出内层循环就找到这次的最小值
            //交换位置
            temp = s[j];
            s[j]=s[minIndex];
            s[minIndex]=temp;
        }
        return s;
    }
}

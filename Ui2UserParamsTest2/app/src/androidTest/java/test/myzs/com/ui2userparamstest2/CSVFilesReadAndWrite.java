package test.myzs.com.ui2userparamstest2;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by gongru on 2018/5/28.
 */

public class CSVFilesReadAndWrite {

    public static  List<String[]> readCSV() throws Exception {
////读取csv文件
     //   FileToAndroid fto=new FileToAndroid();
     //   fto.pushfile();
       File csv1 = new File("/mnt/sdcard/test/docs/ui2UserParaIndexData.csv");
        /*
      //  try
        {
            FileInputStream in =openFileInput("/mnt/sdcard/test/docs/ui2UserParaIndexData.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */

        StringBuilder content = new StringBuilder();
        System.out.println("csv1.path"+csv1.getAbsolutePath());
        Log.d(TAG,csv1.getPath());

        BufferedReader br1 = new BufferedReader(new FileReader(csv1));
        br1.readLine();
        System.out.println("br1：" + br1);
        String line1 = null;
        List<String[]> allstring = new ArrayList<String[]>();



        while ((line1 = br1.readLine()) != null) {

            String everyLine1[] = line1.split(",");//以逗号为分隔符
            allstring.add(everyLine1);
            System.out.println("allstring:"+allstring);
        }


        //关闭文件对象
        br1.close();
//将list转换成String数组
        /*
        String[][] results=new String[allstring.size()][];
        for(int i=0; i<allstring.size(); i++){







            results[i]=allstring.get(i);

            System.out.println(" results:"+i+ results[i]);


        }
        //   System.out.println("allstring:"+allstring);
        Assert.assertTrue( true );
        return results;
*/
        return allstring;

    }



}



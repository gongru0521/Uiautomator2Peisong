package test.myzs.com.ui2userparamstest2;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/5/29.
 */

public class AndroidCSVRW {



    public List<String[]> ReadAnd(String url) throws Exception {
        FileInputStream in ;



        List<String[]> allstring =  new ArrayList<String[]>();

        try {

          //  File file = new File("/mnt/sdcard/test/docs/ui2UserParaIndexData.csv");
            File file = new File(url);

            in = new FileInputStream(file);




            //读取文件
          BufferedReader  br = new BufferedReader(new InputStreamReader(in,"GBK"));
         //   br.readLine();
            Log.v(TAG,"br.readLine:"+br.readLine());


            String line=null ;

            Log.v("1","开始读取系统中文件");
            while ((line = br.readLine()) != null) {
                //这条与语句很重要
              //  Log.v(TAG,"开始执行：");



                String everyLine1[] = line.split(",");//以逗号为分隔符

                allstring.add(everyLine1);

               // System.out.println("allstring:" + allstring);




            }
            in.close();
            br.close();


        } catch (IOException e) {
            e.printStackTrace();
        }



        return allstring;


    }
    //写入csv文件（andrid系统中）
    public void wricsv(String url,String fromurl) throws Exception {
        Log.v(TAG, "开始写入测试结果:");
        ParasGot pg=new ParasGot();
        //获得测试结果数据
        List<String>  ss=pg.paragot(fromurl);



      //  String url = "/mnt/sdcard/test/docs/ui2UserTestResult.csv";

        try {
            File file2 = new File(url);
            FileOutputStream fos = new FileOutputStream(file2,false);
            OutputStreamWriter osw=new OutputStreamWriter(fos,"GBK");
            BufferedWriter bw=new BufferedWriter(osw);







            bw.write("Test Result:");
            bw.write("\n");
            Log.v(TAG,"ss.size():"+ss.size());
            for(int i=0;i<ss.size();i++) {

                bw.write(ss.get(i));
                bw.write("\n");
            }


            bw.close();



        }catch(IOException e){
            e.printStackTrace();
        } finally{



        }



        }
    }

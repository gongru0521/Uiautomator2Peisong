package test.myzs.com.ui2userparamstest2;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/5/29.
 */

public class ParasGot {

    AndroidCSVRW anto = new AndroidCSVRW();
    AllActions ac = new AllActions();
    //读取csv中的每行信息存放在list中
    public  List<String[]> returnPub(String url) throws Exception {
        System.out.println("从csv中获得参数:");


        List<String[]> listtest=anto.ReadAnd(url);

        return listtest;
    }





    public ParasGot() throws IOException {
    }

    //获得所有的测试结果存储到List中

    public List<String> paragot(String url) throws Exception {
        List<String[]> listparas = returnPub(url);
        //将list<String[]>转换为二维数组

        String[][] arrays = ConversionType.strssToliststr(listparas);
        List<String> llstr = ConversionType.arrayToList(arrays);
        Collections.reverse(llstr);
         List<String>  newlistresult=new ArrayList<>();
        String strline[]=new String[6];
        String ss;
        String ll;
    //    String ls[]=new String[arrays.length];

//从list中对字符串进行处理
        Log.v(TAG, "arrays.size():" + arrays.length);
        for (int ii = 0; ii < arrays.length; ii++) {
            Log.v(TAG, "开始读取第ii次:" + ii);
            ss=llstr.get(ii);

            //将字符串中字符进行分割成数组
            strline= ss.split(";");
            Log.v(TAG, " llstr.get(ii):" + llstr.get(ii));


            ll=actionresult( strline);

            newlistresult.add(ll);

        }
        return newlistresult;

    }

    //返回测试结果，每行包括时间、用例名称、测试结果
    public String actionresult(String srgs[]) throws Exception {
        String result=null;
        for (int l = 0; l < srgs.length; l++) {
            Log.v(TAG, "开始读取第l次:" + l);

            Log.v(TAG, "srgs[:" + l + "]" + srgs[l]);

        }
        if (srgs[2].equals("scroll")) {

            result=  ac.scrolllist(srgs[0], srgs[1], srgs[2], srgs[3], srgs[4], srgs[5]);


        }
        if (srgs[2].equals("click")) {

            result=  ac.clickResult(srgs[0], srgs[1], srgs[2], srgs[3], srgs[4], srgs[5]);


        }
        if (srgs[2].equals("edit")) {

            result=  ac.editResult(srgs[0], srgs[1], srgs[2], srgs[3], srgs[4], srgs[5],srgs[6]);


        }
        if(srgs[2].equals("backpress")){
            ac.backResult();
            result=srgs[0]+":"+"返回成功！";

        }

        return  result;

    }
}












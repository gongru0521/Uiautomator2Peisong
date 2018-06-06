package test.myzs.com.ui2userparamstest2;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class ConversionType {
    //将List字符串转换为字符串数组
    public static String[] converType(List<String> list){

        String args[]=new String[list.size()];
        for(int i=0;i<list.size();i++){
            args[i]=list.get(i);

        }
        return args;

    }

    //将字符串数组转换为list
    public static List<String> listoarray(String arrayss[]){

        List<String> listarray=new ArrayList<String>();
        for(int i=0;i<arrayss.length;i++)
        {

            listarray.add(arrayss[i]);
        }
        return listarray;


    }

    //将字符串数组转换为字符串
    public static StringBuffer strsToStr(String Arrays[],Boolean sstr){
        //先将字符串数组转换为list->转换为buffer->转换为String
        //Boolean sstr确定是不是添加&符号
        String str = null;

        List<String> list=new ArrayList<String>();
        StringBuffer sb=new StringBuffer();
        if(sstr==true){
            for(int i=0;i<Arrays.length;i++){

                list.add(Arrays[i]);
                list.add("&");


            }
        }
        else{
            for(int i=0;i<Arrays.length;i++){

                list.add(Arrays[i]);

            }


        }
        //list转换为String buffer
        for(int k=0;k<list.size();k++){
            sb.append(list.get(k));


        }
        //返回buffer
        //str=sb.toString();

        return sb;


    }
    //将list<String[]>转为以二维数组
    public static String[][] strssToliststr(List<String[]> liststrss){

        //先转换为二维数组
        String[][] str1=new String[liststrss.size()][];
        for(int i=0;i<liststrss.size();i++){

            str1[i]=liststrss.get(i);
            Log.v(TAG,"str1[i]:"+str1[i]);


        }
        return str1;
    }
    //将二维数组转换为list类型
    public static List<String> arrayToList(String[][] strarray){
        List<String>  reback=new ArrayList<String>();
        //再转换为list<String>
        for(int j=0;j<strarray.length;j++){
            for(int k=0;k<strarray[j].length;k++){
                reback.add(k,strarray[j][k]);
                Log.v(TAG,"strarray[j][k]:"+strarray[j][k]);

            }


        }
        return reback;

    }
}

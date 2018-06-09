package test.myzs.com.ui2userparamstest2;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/5/28.
 */

public class AllActions extends UiAutomatorInstrumentationTestRunner{
    //点击
    public Instrumentation instrument = InstrumentationRegistry.getInstrumentation();
    public UiDevice ud = UiDevice.getInstance(instrument);
  //  AndroidCSVRW ac=new AndroidCSVRW();
  //  TestResultEdit td=new TestResultEdit();
    public static String getType(Object o) {
        return o.getClass().toString();
    }
//获取当前系统时间
    public String getTime(){

        String stime=null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        stime=df.format(new Date()).toString();

        return stime;
    }
    String gotnoewtime = getTime();
    //判断结果对错方法封装并返回结果值
    public String resultjuide(String mess,String name){
        String  allback;
        String  allgot;
        UiObject2 uu=null;
        if(mess.equals("null")) {
            allback = "Test Result:" + name + ":" + "pass" + ":" + gotnoewtime;
        }
        else{
            uu=ud.findObject(By.text(mess));

            if (uu != null) {
                Assert.assertTrue(true);
                allgot = "pass";

                Log.v(TAG, "结果pass！");

                allback = "Test Result:" + name + ":" + allgot + ":" + gotnoewtime;
                Log.v(TAG, " allresult！" + allback);


            } else {
                allgot = "fail";
                Log.v(TAG, "结果fail！" + uu + "不存在");
                allback = "Test Result:" + name + ":" + allgot + ":" + gotnoewtime;

                Log.v(TAG, " allresult！" + allback);


            }
        }






        return allback;


    }
//封装text,resourceid,className等方法
    public UiObject2 getelement(String res, String btest){
          UiObject2 ugot=null;
          switch(btest){
              case "text":
                  ugot=ud.findObject(By.text(res));
                  break;
              case "resourceid":
                  ugot=ud.findObject(By.res(res));
                  break;


          }

        return ugot;

    }
    //滑动且测试结果获取
    public String scrolllist(String res, String btest,String actions,String mess,String times,String name) throws Exception {
        Log.v(TAG, "res;" + res);



        UiScrollable list = new UiScrollable(new UiSelector().resourceId(res));


        Log.v(TAG, "list;" + list);

   //     String resultgot = null;
        String allresult = null;
        int y = ud.getDisplayHeight();
        int x = ud.getDisplayWidth();

        if (list != null) {
            Log.v(TAG, "开始滑动列表！");

            Thread.sleep(3000);
            list.flingToEnd(10);


            Thread.sleep(3000);
            Log.v(TAG,"判断准则:"+mess);

            allresult=resultjuide(mess,name);


        }
         else {

            Log.v(TAG, "没有滑动列表！");
            allresult=name+":结果fail";

        }
        return allresult;


    }


    //如果是点击事件（click），点击并获取结果字符串
    public String clickResult(String res, String btest,String actions,String mess,String times,String name) throws Exception{
        String allresult = null;
        //获取对象
        UiObject2 umoresetting = getelement(res,btest);

        if(umoresetting!=null){
            Thread.sleep(1000);
            umoresetting.click();
            Thread.sleep(3000);
            allresult=resultjuide(mess,name);


        }
        else {

            Log.v(TAG, umoresetting+":不存在");
            allresult=name+":结果fail";


        }
        return allresult;



    }
    //Edit事件，往文本框中输入信息
    public String editResult(String res, String btest,String actions,String mess,String times,String name,String editstring) throws Exception{
        String allresult=null;
       UiObject2 uedit=getelement(res,btest);

        if(uedit!=null){
            Thread.sleep(3000);
            uedit.setText(editstring);
            Thread.sleep(3000);
            allresult=resultjuide(mess,name);


        }
        else{
            Log.v(TAG, uedit+":不存在");
            allresult=name+":结果fail";


        }

        return allresult;

    }
    //点击返回按钮，将键盘收起
    public void backResult() throws Exception{
        Thread.sleep(1000);
        ud.pressBack();
        Thread.sleep(1000);




    }


}



package test.myzs.com.ui2userparamstest2;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest extends UiAutomatorInstrumentationTestRunner{


    public Instrumentation instrument= InstrumentationRegistry.getInstrumentation();
    public UiDevice ud= UiDevice.getInstance(instrument);
    AndroidCSVRW acs=new AndroidCSVRW();
    Context context = InstrumentationRegistry.getInstrumentation().getContext();


    @Before
     //清除app缓存
    //进入设置页面
            public void clearAll()throws Exception{

        //进入设置页面方法1
        //    ud.executeShellCommand("am start -n com.android.settings/.MainSettings ");



    }
    BaseWatcher bw=new BaseWatcher();

    //清空蚂蚁配送员应用的缓存
    @Test
    public void testcase001() throws Exception {
       // bw.testlocationwatcher();
       // ud.runWatchers();

        //进入设置页面方法2

        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.android.settings");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//starts the app
        context.startActivity(intent);

        Thread.sleep(3000);
        String url1="/mnt/sdcard/test/docs/ui2UserTestResultSettingClear.csv";
        String url2="/mnt/sdcard/test/docs/ui2UserParaIndexDataSettingClear.csv";
        acs.wricsv(url1,url2);
        Thread.sleep(3000);


    }

    //启动蚂蚁配送员app
    @Test
    public void testcase002() throws Exception {
     //  bw.testlocationwatcher();
      // ud.runWatchers();

        Thread.sleep(3000);
        ud.executeShellCommand("am start -n com.itsenpupulai.courierport/.activity.BeforeWelcomeActivity ");
        Thread.sleep(10000);


    }


    //对蚂蚁配送员app进行处理
    @Test
    public void testcase003() throws Exception{
       // bw.testlocationwatcher();
       // ud.runWatchers();

        Thread.sleep(5000);
        String url1="/mnt/sdcard/test/docs/ui2UserTestResultSettingPeisongApps.csv";
        String url2="/mnt/sdcard/test/docs/ui2UserParaIndexDataPeisongApps.csv";
         acs.wricsv(url1,url2);
        Thread.sleep(3000);

    }

    @After
    public void pullresult() throws IOException {

      //  ud.executeShellCommand("db pull /mnt/sdcard/test/docs/ui2UserTestResult.csv  F:\\AndroidStudio\\Ui2UserParamsTest2\\testResult");

    }
}

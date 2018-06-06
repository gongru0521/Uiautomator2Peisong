package test.myzs.com.ui2userparamstest2;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/5/29.
 */

public class FileToAndroid extends UiAutomatorInstrumentationTestRunner {
    public Instrumentation instrument= InstrumentationRegistry.getInstrumentation();
    public UiDevice ud= UiDevice.getInstance(instrument);

    public void pushfile()throws Exception{
        Log.v(TAG,"先push csv文件到sdcard目录下！!!");
     //  ud.executeShellCommand("push F:\\AndroidStudio\\Ui2UserParamsTest2\\CSVdocs  /mnt/sdcard/test/docs");
        Runtime.getRuntime().exec("adb push F:\\AndroidStudio\\Ui2UserParamsTest2\\CSVdocs\\ui2UserParaIndexData.csv  /mnt/sdcard/test/docs");
  }

}

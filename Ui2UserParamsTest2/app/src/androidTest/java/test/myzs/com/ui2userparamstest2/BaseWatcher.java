package test.myzs.com.ui2userparamstest2;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/6/5.
 */

public class BaseWatcher extends UiAutomatorInstrumentationTestRunner {
    public Instrumentation instrument= InstrumentationRegistry.getInstrumentation();
    public UiDevice ud= UiDevice.getInstance(instrument);
    //Uiwatcher注册监听器，放在所有用例之前
    public void testlocationwatcher()throws InterruptedException{
        final UiObject2 uyunxubutton=ud.findObject(By.res("android:id/button1"));
        ud.registerWatcher("testwatcher", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                Log.v(TAG,"开始进入监听器!");

                if(uyunxubutton!=null){


                    //  uyunxubutton.click();
                    ud.click(794,1780);
                    Log.v(TAG,"监听器触发了!");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


                return true;


            }
        });
    }




}

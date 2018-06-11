package test.myzs.com.ui2userparamstest2;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/6/5.
 */

public  class BaseWatcher implements UiWatcher {
    public Instrumentation instrument= InstrumentationRegistry.getInstrumentation();
    public UiDevice ud= UiDevice.getInstance(instrument);
    //Uiwatcher注册监听器，放在所有用例之前
    public void testlocationwatcher()throws InterruptedException{

        ud.registerWatcher("testwatcher", new UiWatcher() {
            UiObject2 uyunxubutton=ud.findObject(By.res("android:id/button1").text("允许"));
            @Override
            public boolean checkForCondition() {
                Log.v(TAG,"开始进入监听器!");

                if(uyunxubutton!=null){


                    //  uyunxubutton.click();
                //    Log.v(TAG,"uyunxubutton="+uyunxubutton+";");
                 //   ud.click(794,1780);
                    uyunxubutton.click();
                    Log.v(TAG,"监听器触发了!");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                else{

                    Log.v(TAG,"uyunxubutton=null;触发监听失败！");

                }


                return true;


            }
        });
    }
    //更新版本监听
    public void updateversion()throws InterruptedException{

        ud.registerWatcher("update", new UiWatcher() {
            UiObject2 canclebutton=ud.findObject(By.res("com.itsenpupulai.courierport:id/tv_dialog_cancle"));
            @Override
            public boolean checkForCondition() {
                Log.v(TAG,"开始进入监听器!");

                if(canclebutton!=null){


                    //  uyunxubutton.click();
                    //    Log.v(TAG,"uyunxubutton="+uyunxubutton+";");
                //    ud.click(794,1780);
                    canclebutton.click();
                    Log.v(TAG,"监听器触发了!");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                else{

                    Log.v(TAG,"canclebutton=null;触发监听失败！");

                }


                return true;


            }
        });


    }


    @Override
    public boolean checkForCondition() {
        return false;
    }
}

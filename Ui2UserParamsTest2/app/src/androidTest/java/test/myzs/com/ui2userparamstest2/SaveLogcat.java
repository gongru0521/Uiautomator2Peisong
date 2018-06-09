package test.myzs.com.ui2userparamstest2;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/6/9.
 */

public class SaveLogcat extends Thread{
    public Instrumentation instrument= InstrumentationRegistry.getInstrumentation();
    public UiDevice ud= UiDevice.getInstance(instrument);
    public static Boolean LogKey=false;
    AllActions ac=new AllActions();
   // Thread thread;
    boolean readlog = true;
      String nowtime=ac.getTime().replace("","").replace(":","").replace("-","");
    @Override
    public void run() {
       // execCmdAdb("adb logcat -c");
        getlogs();
    }


    //保存日志文件
    public void writetosave(String logs) {
        String content = logs + "\r\n";
        //
        String logname=nowtime+"log.txt";
        String url = "/mnt/sdcard/test/logs/"+logname;
        File file = new File(url);
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(content);
            bw.write("\n");
            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
        //获得log日志

//执行adb 命令
        public void getlogs() {
          //   String cmd = " cmd/c adb logcat *:D >/mnt/sdcard/test/logs/Logs.txt";
          //  String cmd[]={"cmd","/c","adb logcat *:D >/mnt/sdcard/test/logs/Logs.txt"};

          // String cmd = "logcat *:D >/mnt/sdcard/test/logs/Logs.txt";
            String cmd = "logcat ";

            BufferedReader reader = null;
          //  Log.d("test", "log start:");
            try {
                Process p ;

                p = Runtime.getRuntime().exec(cmd);
                Log.v(TAG, "process:" + p);
                //    p=ud.executeShellCommand(cmd);
                reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if (LogKey) {
                        p.destroy();

                        reader.close();
                    }
                    else{

                      writetosave(line);
                     //   Log.v(TAG,"save logs");
                    }

                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
            /**
             * 停止logcat线程
             */

            public void stopLoacat() {
               LogKey = true;
            }





}

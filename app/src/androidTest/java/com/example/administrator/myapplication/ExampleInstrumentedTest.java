package com.example.administrator.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Environment;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;
import android.support.test.uiautomator.Until;
import android.util.Log;
import android.widget.TextView;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import static android.os.SystemClock.sleep;
import static java.lang.System.in;
import static javax.xml.transform.OutputKeys.ENCODING;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private String path;
    private String phoneNumber;
    private int num = 0;
    private String name;
    //用于统计最大测试时间和最小测试时间所需要的变量
    private float max = 0;
    private float min = 10000;
    //用于循环时候次数统计方便break
    private int k = 0;
    //s为成功次数，f为失败次数
    private int s = 0;
    private int f = 0;
    private   int x = 0;
    private int y = 0;
    private String SDPATH =  Environment.getExternalStorageDirectory().getPath() ;



    private void init() {
        Context context = InstrumentationRegistry.getTargetContext();
        path = context.getExternalCacheDir().getPath();


    }

    private File createFile(String path, String fileName) {
        File file = new File(path, fileName);

        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return file;
    }

    private UiDevice mUIDevice = null;
    private Context mContext = null;
    private String APP = "XXX";

    @Before
    public void setUp() throws RemoteException {

        mUIDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());  //获得device对象
        mContext = InstrumentationRegistry.getContext();

        if (!mUIDevice.isScreenOn()) {  //唤醒屏幕
            mUIDevice.wakeUp();
        }
        mUIDevice.swipe(500, 1700, 500, 700, 20);
        mUIDevice.pressHome();  //按home键


    }

    @After
    //测试结束资源释放，垃圾回收。
    public void tearDown() {
        mUIDevice.removeWatcher("testWatcher");
        mUIDevice = null;
        mContext = null;

        System.gc();
    }

    @Test
    //测试浏览器上网
    public void testSurfInternet() throws InterruptedException, FileNotFoundException {
        init();
        File file1= createFile(path,"1.txt");

        FileOutputStream fs = new FileOutputStream(file1);
        PrintStream p = new PrintStream(fs);
        try{
         watcher();
       lianwang();

        mUIDevice.pressHome();
        sleep(2000);
            String bbb1=this.getCall1();
            String[] sArray=bbb1.split("=");
            String a11=sArray[5];
            int a22 = Integer.parseInt(a11);
        for (int i = 1; i <= a22; i++) {
      try{   num=num+1;
            checkWeb();}catch (Exception e){
          Date a=new Date();
          SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String str=sdf.format(a);
          sleep(2000);
          // p.println(e.toString());

          String z="\n第"+num+"次测试失败"+"\n"+str;
          p.println(e.toString()+z);
          sleep(2000);

      }
      s=num-f;
        }
        Log.e("联网成功",s+"次");
        Log.e("联网失败",f+"次");
        Log.e("报告地址",path);
        String c="总共运行"+num+"次"+"\n";
        String a="联网成功"+s+"次"+"\n";
        String b="联网失败"+f+"次";

        p.println(c+a+b);}catch (Exception e){
            Date a=new Date();
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str=sdf.format(a);
         sleep(2000);
         // p.println(e.toString());
         String z="\n控件没找到停止测试"+"\n"+str;
         p.println(e.toString()+z);
         sleep(2000);

     }

       // p.write(\n);


    }


    @Test
    public void testTest1() throws IOException {

        Point p1 = new Point(247,960);
        Point p2 = new Point(888,960);
        Point p3 = new Point(888,1620);
        Point[] p = { p1, p2, p3 };
        mUIDevice.swipe(p,20);
        //executeShellCommand(String cmd)
        mUIDevice.executeShellCommand("touch data/local/tmp/aac.txt");
        sleep(2000);
   //  mUIDevice.executeShellCommand("rm 1.txt ");//uiautomator2.0可以使用shell语言进行编程了。。


      /*  String bbb=this.getCall1();
        Log.e("读取的数据",bbb);
         init();
        File file1= createFile("/sdcard/","2.txt");

        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintStream p = new PrintStream(fs);
       p.println("qwsadadada");*/


    }


    @Test
    //测试短信
    public void testSendMessage() {
      init();
        File file1= createFile(path,"2.txt");

        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintStream p = new PrintStream(fs);



       watcher();
try{
        sleep(2000);
        mUIDevice.findObject(By.text("Messaging")).clickAndWait(Until.newWindow(), 2000);
        sleep(2000);
        while (mUIDevice.hasObject(By.desc("Navigate up"))) {

           mUIDevice.findObject(By.desc("Navigate up")).clickAndWait(Until.newWindow(), 2000);
            sleep(2000);


        }
        sleep(2000);
        mUIDevice.findObject(By.desc("More options")).clickAndWait(Until.newWindow(), 2000);
        sleep(2000);
        mUIDevice.findObject(By.text("Delete all threads")).clickAndWait(Until.newWindow(), 2000);
        sleep(2000);
        mUIDevice.findObject(By.text("DELETE")).clickAndWait(Until.newWindow(), 2000);
        sleep(2000);
        mUIDevice.findObject(By.res("com.android.mms:id/action_compose_new")).clickAndWait(Until.newWindow(), 2000);
        UiObject obj=new UiObject(new UiSelector().resourceId("com.android.mms:id/recipients_editor"));
        obj.waitForExists(20000);
        mUIDevice.waitForIdle();

        try {
            obj.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        mUIDevice.waitForIdle();
        try {
            //输入电话号码
            String a=this.getCall1();
            String[] sArray=a.split("=");
            // for (int i = 0 ; i <sArray.length ; i++ )
            System.out.println("--"+sArray[1]);
            String abc=sArray[1];
            obj.setText(abc);
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }


        // mUIDevice.findObject(By.res("com.android.mms:id/from")).clickAndWait(Until.newWindow(), 2000);
        //15968487302
        sleep(2000);
    String bbb=this.getCall1();
    String[] sArray=bbb.split("=");
    String a1=sArray[3];
    int a2 = Integer.parseInt(a1);

        for (int a = 1; a <= a2; a++) {
           try{ num=num+1;
            String b = getRandomString(10);
            mUIDevice.findObject(By.res("com.android.mms:id/embedded_text_editor")).click();
            sleep(2000);
            mUIDevice.findObject(By.res("com.android.mms:id/embedded_text_editor")).setText(b + a);
           sleep(2000);
            mUIDevice.findObject(By.res("com.android.mms:id/send_button_sms")).clickAndWait(Until.newWindow(), 2000);

            //判断输入的短信是否成功

            UiCollection counts = new UiCollection(new UiSelector().className("android.widget.ListView"));
            int count = counts.getChildCount(new UiSelector().text(b + a));
            while (count != 2) {
                count = counts.getChildCount(new UiSelector().text(b + a));
                sleep(2000);
                k=k+1;
                if(k==10){
                    Date date=new Date();
                    SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String str=sdf.format(date);
                    p.println("手机号码设置不正确，测试失败"+"\n"+str);
                    break;
                }
                Log.e("等待短信发送成功", String.valueOf(count));


            }
            sleep(2000);
            if (count == 2) {
                Log.e("sendMessage", "第" + a + "次发送成功");

            } else {
                Log.e("sendMessage", "第" + a + "次发送失败");
                y = y + 1;
            }
            Log.e("count的值为", String.valueOf(count));}
            catch (Exception e){
                Date date=new Date();
                SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String str=sdf.format(date);
                p.println(e.toString()+"\n"+str);
               y=y+1;
               return ;
            }
        }



        sleep(2000);
        x=num-y;
        Log.e("发送成功次数", String.valueOf(x));
        Log.e("发送失败次数", String.valueOf(y));
        mUIDevice.pressBack();
        String c="总共运行"+num+"次"+"\n";
        String a="发送成功"+x+"次"+"\n";
        String b="发送失败"+y+"次";

        p.println(c+a+b);} catch (Exception e){
    Date date=new Date();
    SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String str=sdf.format(date);
    sleep(2000);
   // p.println(e.toString());
    String z="\n发送失败停止测试"+"\n"+str;
    p.println(e.toString()+z);
    sleep(2000);
}




    }

    @Test
    //浏览器上网强度测试wifi强度开关
    public void testWifi() throws InterruptedException {
        Date began = new Date();
        init();
        File file3= createFile(path,"3.txt");

        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(file3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintStream p = new PrintStream(fs);
try{
        watcher();


        /**long startTime = System.currentTimeMillis();
         long endTime = System.currentTimeMillis();//记录结束时间
         float excTime = (float) (endTime - startTime) / 1000;
         System.out.println("执行时间：" + excTime + "s");*/

        lianwang();
    String bbb11=this.getCall1();
    String[] sArray=bbb11.split("=");
    String a111=sArray[7];
    int a22 = Integer.parseInt(a111);
        for (int i = 1; i <= a22; i++) {
         try{   num=num+1;
            long startTime = System.currentTimeMillis();
            while (mUIDevice.hasObject(By.text("On"))) {
                mUIDevice.findObject(By.text("On")).clickAndWait(Until.newWindow(), 2000);//切换到关闭状态

            }
            mUIDevice.pressHome();
            checkWeb();
            backWlan();
            while (mUIDevice.hasObject(By.text("Off"))) {
                mUIDevice.findObject(By.text("Off")).clickAndWait(Until.newWindow(), 2000);//切换到开启状态
            }
            while (!mUIDevice.hasObject(By.text("Connected"))) {

                sleep(2000);
                num = num++;
                if (num == 10) {
                    num = 0;
                    break;
                }
            }
            mUIDevice.pressHome();
            checkWeb();
            backWlan();

            long endTime = System.currentTimeMillis();
            float excTime = (float) (endTime - startTime) / 1000;
            //统计运行次数最大运行时间和最快的运行时间
            if (excTime > max) {
                max = excTime;
            } else if (excTime < min) {
                min = excTime;


            }
            s=s+1;
            Log.e("checkWeb", "第"+String.valueOf(i)+"次运行成功");}catch (Exception e){
             String z="\n"+"第"+num+"次运行失败"+"\r";
             p.println(e.toString()+z);

         }
        }

        Date end = new Date();
        Log.e("开始时间", String.valueOf(began));
        Log.e("结束时间", String.valueOf(end));
        Log.e("最大运行时间", String.valueOf(max));
        Log.e("最小运行时间", String.valueOf(min));
        s=num-f;
        String c="总共运行"+num+"次"+"\n";
        String a="联网成功"+s+"次"+"\n";
        String b="联网失败"+f+"次";

        p.println(c+a+b);}catch (Exception e){
    Date date=new Date();
    SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String str=sdf.format(date);
    sleep(2000);
    // p.println(e.toString());
    String z="\n控件没找到停止测试"+"\n"+str;
    p.println(e.toString()+z);
    sleep(2000);

}
    }


    //封装的maidu-wifi联网方法
    public void lianwang() {
        mUIDevice.findObject(By.desc("Apps")).clickAndWait(Until.newWindow(), 2000);
        sleep(2000);
        mUIDevice.findObject(By.text("Settings")).clickAndWait(Until.newWindow(), 2000);
        sleep(2000);
        while (!mUIDevice.hasObject(By.text("Wi‑Fi"))) {

            mUIDevice.swipe(540, 400, 540, 1500, 20);
            sleep(2000);
            num = num++;
            if (num == 5) {
                num = 0;
                break;


            }
        }
        mUIDevice.findObject(By.text("Wi‑Fi")).clickAndWait(Until.newWindow(), 2000);
        sleep(2000);
        while (mUIDevice.hasObject(By.text("Off"))) {
            mUIDevice.findObject(By.text("Off")).clickAndWait(Until.newWindow(), 2000);
        }
        sleep(10000);
        while (!mUIDevice.hasObject(By.text("Connected"))) {
            sleep(2000);
            num = num + 1;
            Log.i("等待次数", String.valueOf(num));
            if (num == 10) {
                num = 0;

                break;
            }
        }
        while (!mUIDevice.hasObject(By.text("Connected"))) {
            sleep(2000);
            while (!mUIDevice.hasObject(By.text("TP-LINK_5G_D96D_maidu"))) {

                sleep(2000);
                mUIDevice.swipe(540, 1000, 540, 400, 20);
                sleep(2000);
            }
            //   mUIDevice.findObject(By.text("移动网络")).clickAndWait(Until.newWindow(),2000);
            // sleep(2000);
            mUIDevice.findObject(By.text("TP-LINK_5G_D96D_maidu")).clickAndWait(Until.newWindow(), 2000);
            sleep(2000);
            UiObject2 editText = mUIDevice.findObject(By.res("com.android.settings:id/password"));

            sleep(2000);
            editText.setText("13586516329");

            //  mUIDevice.findObject(By.desc("com.android.settings:id/password")).setText("13586516329");
            sleep(2000);
            mUIDevice.findObject(By.text("CONNECT")).clickAndWait(Until.newWindow(), 2000);
            sleep(2000);
            break;
        }

    }

    //封装的监听器方法
    public void watcher() {
        mUIDevice.registerWatcher("testWatcher", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                if (mUIDevice.hasObject(By.res("android:id/alertTitle"))) {
                    init();
                    File file = createFile(path, name);
                    try {
                        mUIDevice.executeShellCommand("adb reboot");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (file != null) {
                        Log.i("TestCase1: file path = ", file.getPath());
                    }

                    mUIDevice.takeScreenshot(file, 1.0f, 30);

                    Log.i("testWatcher", "监听器被触发了");
                    mUIDevice.resetWatcherTriggers();
                    return true;
                }
                //  Log.i("testWatcher", "监听器未被触发");
                mUIDevice.resetWatcherTriggers();
                return false;
            }

        });
        mUIDevice.registerWatcher("testJurisdiction", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                if (mUIDevice.hasObject(By.res("com.android.packageinstaller:id/perm_desc_root"))) {

                    sleep(2000);
                    mUIDevice.findObject(By.text("ALLOW")).click();
                    sleep(3000);
                    Log.i("testWatcher", "监听器被触发了");
                    mUIDevice.resetWatcherTriggers();
                    return false;
                }
                //  Log.i("testWatcher", "监听器未被触发");
                return false;
            }

        });
      /*  mUIDevice.registerWatcher("testJurisdiction1", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                if (mUIDevice.hasObject(By.res("com.android.packageinstaller:id/perm_desc_root"))) {

                    sleep(2000);
                    mUIDevice.findObject(By.text("ALLOW")).click();
                    sleep(3000);
                    Log.i("testWatcher", "监听器被触发了");
                    return true;
                }
                //  Log.i("testWatcher", "监听器未被触发");
                return false;
            }
        });*/

    }

    //封装一个简单的百度上网是否成功的方法
    public void checkWeb() throws InterruptedException {

        mUIDevice.findObject(By.text("Browser")).clickAndWait(Until.newWindow(), 2000);

        sleep(2000);
      // mUIDevice.findObject(By.res("com.android.browser:id/url")).wait(10000);
        UiObject obj=new UiObject(new UiSelector().resourceId("com.android.browser:id/url"));
        obj.waitForExists(20000);

        //明天来看。
        mUIDevice.waitForIdle();
        mUIDevice.findObject(By.res("com.android.browser:id/url")).clickAndWait(Until.newWindow(), 2000);
        // UiObject2 editText = mUIDevice.findObject(By.text("搜索或输入网址"));
        mUIDevice.findObject(By.res("com.android.browser:id/url")).setText("www.baidu.com");

        sleep(1000);
        //editText.setText("www.baidu.com");
        mUIDevice.pressEnter();
        sleep(3000);

        if (mUIDevice.hasObject(By.desc("百度一下,你就知道"))) {


            while (!mUIDevice.hasObject(By.desc("Contacts"))) {
                mUIDevice.pressHome();


            }
        } else {
            f = f + 1;
            Log.e("五秒内没网", "联网失败");
            Date date=new Date();

            while (!mUIDevice.hasObject(By.desc("Contacts"))) {
                mUIDevice.pressHome();


            }
        }

    }

    //从桌面返回WLAN界面
    public void backWlan() {
        mUIDevice.findObject(By.desc("Apps")).clickAndWait(Until.newWindow(), 2000);
        sleep(1000);
        mUIDevice.findObject(By.text("Settings")).clickAndWait(Until.newWindow(), 2000);
        sleep(1000);
        mUIDevice.findObject(By.text("Wi‑Fi")).clickAndWait(Until.newWindow(), 2000);
        sleep(1000);
    }

    //封住一个生成文件并可以write的文件   未完成。
    public void writeFile() throws IOException {
        init();

        File a = createFile(path, "1.txt");
        FileOutputStream fos = new FileOutputStream(a);
        String info ="111\n111";
        fos.write(info.getBytes());
        fos.write(info.getBytes());

    }

    //随机获取任意长度的字符串
    public static String getRandomString(int length) {
        StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int range = buffer.length();
        for (int i = 0; i < length; i++) {
            sb.append(buffer.charAt(random.nextInt(range)));
        }
        return sb.toString();
    }

    //长按时间
    public void longPress1(UiObject2 object) {
        sleep(2000);
        Rect r = object.getVisibleBounds();
        sleep(2000);
        int a = (int) r.exactCenterX();
        int b = (int) r.exactCenterY();
        Log.e("x的植", String.valueOf(a));
        Log.e("y的植", String.valueOf(b));
        sleep(2000);
        mUIDevice.swipe(a, b, a, b, 500);

    }
    public static String getPropertiesURL(Context c, String s) {
        String url = null;
        Properties properties = new Properties();
        try {
           properties.load(c.getAssets().open("Test.properties"));

            url = properties.getProperty(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
    //读取配置文件
    public static Properties loadConfig( String file) {
        Properties properties = new Properties();
        try {
            FileInputStream s = new FileInputStream(file);
            properties.load(s);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return properties;
    }
    //保存修改设置配置文件
    public static boolean saveConfig(Context context, String file,
                                     Properties properties) {
        try {
            File fil = new File(file);
            if (!fil.exists())
                fil.createNewFile();
            FileOutputStream s = new FileOutputStream(fil);
            properties.store(s, "");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //读取TXT
    public String readSDFile(String fileName) {
        StringBuffer sb = new StringBuffer();
        File file = new File(SDPATH + "//" + fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            int c;
            while ((c = fis.read()) != -1) {
                if(Character.isWhitespace(c) ){//判断是否是空格
                    continue;
                }
                sb.append((char) c);
                Log.e("222", String.valueOf(sb));
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(sb.toString());
        return  m.replaceAll("");
    }
    public String getTime1(String str){
        Date date=new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         str=sdf.format(date);
        return str;
    }
    public String getCall1() throws IOException {
        File file = new File("/data/local/tmp/config.txt");
     //   File file = new File("/storage/self/primary/2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String readline = "";
        StringBuffer   sb = new StringBuffer();
        while ((readline = br.readLine()) != null) {
            System.out.println("readline:" + readline);
            sb.append(readline);
        }
        br.close();
        Log.e("122", String.valueOf(sb));
        String callNumber=String.valueOf(sb);
        System.out.println("读取成功：" + sb.toString());
return callNumber;
    }












}












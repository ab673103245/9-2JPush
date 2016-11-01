package qianfeng.a9_2jpush;

import android.app.Application;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2016/10/25 0025.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        // 一个用户可以设置多个标签
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("android");
        set.add("123");
        JPushInterface.setTags(this,set,null);


        // 一个用户只能设置一个别名
        JPushInterface.setAlias(this,"user1",null);

        // 设备的ID需要一个广播来获取，而且还需要点时间


    }
}

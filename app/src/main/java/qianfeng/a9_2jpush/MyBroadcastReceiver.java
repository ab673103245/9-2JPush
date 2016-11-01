package qianfeng.a9_2jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2016/10/25 0025.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction()))
        {
            // 收到通知时，立即接收到广播
            Log.d("google-my:", "onReceive: 收到消息啦！");

        }else if(JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction()))
        {
            // 点击通知栏触发的操作

            // 记住静态注册的广播的context是 Application，Application的上下文和Activity上下文最大的不同就是Activity的上下文有任务栈，而Application的没有
            Intent intent1 = new Intent(context, Main2Activity.class);
            // 解决的方案就是：在intent里面添加一个flag，设置启动模式为能产生一个任务栈的模式，即 NEW_TASK
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent1);

        }else if(JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction()))
        {
            // 这个只会在应用第一次启动的时候发送这个广播,得到用户注册的id
            Bundle bundle = intent.getExtras();
            String title = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
            Log.d("google-my:", "onReceive: title:registeation_id::" + title);

        }else if(JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction()))
        {
            Bundle bundle = intent.getExtras();
            // 服务器上的title一般是没有的。
            String title = bundle.getString(JPushInterface.EXTRA_TITLE);
            // message:就是你在服务器上推送的消息的内容
            String message = bundle.getString(JPushInterface.EXTRA_MESSAGE);
            Log.d("google-my:", "onReceive: title:" + title);
            Log.d("google-my:", "onReceive:  message:" + message);
        }


    }
}

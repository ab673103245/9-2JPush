package qianfeng.a9_2jpush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 1.下载JPush SDKhttp://docs.jiguang.cn/jpush/resources/
 * 2.解压缩下载的SDK文件，将..\jpush-android-release-2.2.0\jpush-android-release\libs文件夹中的文件拷贝到项目中
 * 3.创建jniLibs文件夹，并修改gradle文件
 * 4.复制..\jpush-android-release-2.2.0\jpush-android-release\res目录下的文件到项目的res目录下
 * 5.参考..\jpush-android-release-2.2.0\jpush-android-release\AndroidManifest_androidstudio_example.xml文件来配置项目清单文件
 * 6.在JPush上注册应用https://www.jiguang.cn/app/form，获取appkey并替换清单文件中的appkey
 * 7.自定义Application,并在onCreate方法中初始化JPush
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

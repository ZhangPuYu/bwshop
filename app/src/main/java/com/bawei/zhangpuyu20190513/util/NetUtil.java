package com.bawei.zhangpuyu20190513.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.google.common.io.CharStreams;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetUtil {
    private static final NetUtil ourInstance = new NetUtil();

    public static NetUtil getInstance() {
        return ourInstance;
    }

    private NetUtil() {
    }

    public static boolean getTime(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if(activeNetworkInfo != null && activeNetworkInfo.isConnected()){
            return true;
        }else{
            return false;
        }
    }

    public void getAcyncTask(String url, final CallBackTask callBackTask){
        new AsyncTask<String,Void,String>(){

            @Override
            protected void onPostExecute(String s) {
                if(TextUtils.isEmpty(s)){
                    callBackTask.onError(2002,"数据有误");
                }else{
                    callBackTask.onSuccess(s);
                }
            }

            @Override
            protected String doInBackground(String... strings) {
                return NetUtil.getData(strings[0]);
            }
        }.execute(url);
    }

    public interface CallBackTask{
        void onError(int code,String msg);
        void onSuccess(String s);
    }

    public static String getData(String url){
        try {
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                return CharStreams.toString(new InputStreamReader(connection.getInputStream()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

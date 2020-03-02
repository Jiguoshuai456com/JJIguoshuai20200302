package com.bw.jjiguoshuai20200302.utiuls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bw.jjiguoshuai20200302.base.App;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 季国帅
 * 20200302
 */
public class VolleyUtiuls {

     RequestQueue queue;

    private VolleyUtiuls() {
        this.queue = Volley.newRequestQueue(App.getApplicon());
        RequestQueue queue = this.queue;
    }
    private static class SingInstance{
        private static final VolleyUtiuls IBANER=new VolleyUtiuls();
    }
    public static VolleyUtiuls getInstance(){
        return SingInstance.IBANER;
    }
//    ⑤　封装Volley的get和post
    public boolean getNet(Context context){
       ConnectivityManager com= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = com.getActiveNetworkInfo();
        if (info!=null){
            return true;
        }
        return false;

    }
    public void doGet(String url, final ICallBack iCallBack){
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                iCallBack.onSuccess(response);

            }
        }, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {

            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String a;
                try {
                    a= new String(response.data,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    a=new String(response.data);
                }
                return Response.success(a, HttpHeaderParser.parseCacheHeaders(response));
            }
        };
        queue.add(request);

    }
    public void doPost(String url, final HashMap<String,String> map, final ICallBack iCallBack){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                iCallBack.onSuccess(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams(){
                return map;
            }
        };
        queue.add(stringRequest);

    }
    public interface ICallBack{
        void onSuccess(String json);
        void onError(String msg);
    }
}

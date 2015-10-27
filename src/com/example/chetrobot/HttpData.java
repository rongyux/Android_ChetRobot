package com.example.chetrobot;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class HttpData extends AsyncTask<String,Void,String>{

	private HttpClient mHttpClient;
	private HttpGet mHttpGet;
	private HttpResponse mHttpResponse;
	private HttpEntity mEntity;
	private InputStream in;
	private HttpGetDataListener listener;
	
	private String urlString;
	
	public HttpData(String url,HttpGetDataListener listener) {
		this.urlString=url;
		this.listener = listener;
	}
	
	@Override
	protected String doInBackground(String... params) {
		try {
			mHttpClient = new DefaultHttpClient();
			mHttpGet = new HttpGet(urlString);
			mHttpResponse = mHttpClient.execute(mHttpGet);
			mEntity = mHttpResponse.getEntity();
			in = mEntity.getContent();
			
			BufferedReader bReader =  new BufferedReader(new InputStreamReader(in));
			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = bReader.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		listener.getDataUrl(result);//回调接口实现了的方法getDataUrl，相似于C中的函数指针
		super.onPostExecute(result);
	}
	
	
}

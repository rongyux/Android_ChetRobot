package com.example.chetrobot;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity implements
		HttpGetDataListener {

	private HttpData httpData;
	final String KEY = "a32eb6d7c03dbc28290b11da12e55412";


	private List<ListData> lists;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		httpData = (HttpData) new HttpData(
				"http://www.tuling123.com/openapi/api?key=a32eb6d7c03dbc28290b11da12e55412&info=%E4%BD%A0%E5%A5%BD",
				this).execute();
	}

	private void initView() {
		lists = new ArrayList<ListData>();
	}

	@Override
	public void getDataUrl(String data) {
		// System.out.println(data);
		// Log.i("rock", data);
		parseText(data);
	}

	void parseText(String str) {
		try {
			JSONObject jb = new JSONObject(str);
			System.out.println(jb.getString("code"));
			System.out.println(jb.getString("text"));

			ListData listData = new ListData(jb.getString("text"),2);
			lists.add(listData);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}
}

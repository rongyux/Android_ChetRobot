package com.example.chetrobot;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;

public class MainActivity extends Activity implements
		OnClickListener,HttpGetDataListener {

	private HttpData httpData;
	private List<ListData> lists;
	private ListView lv;
	private EditText sendtext;
	private Button send_btn;
	private String content_str;
	private TextAdapter adapter;
	final String KEY = "a32eb6d7c03dbc28290b11da12e55412";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		lists = new ArrayList<ListData>();
		lv = (ListView) findViewById(R.id.lv);
		sendtext = (EditText) findViewById(R.id.sendText);
		send_btn = (Button) findViewById(R.id.send_btn);
 		send_btn.setOnClickListener(this);
		adapter = new TextAdapter(lists, this);
		lv.setAdapter(adapter);
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

			ListData listData = new ListData(jb.getString("text"),ListData.RECEIVER );
			lists.add(listData);
			adapter.notifyDataSetChanged();
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}


	@Override
	public void onClick(View v) {
		content_str = sendtext.getText().toString();
		ListData listData = new ListData(content_str, ListData.SEND);
		lists.add(listData);
		adapter.notifyDataSetChanged();
		httpData = (HttpData) new HttpData(
				"http://www.tuling123.com/openapi/api?key=a32eb6d7c03dbc28290b11da12e55412&info="
						+ content_str, this).execute();		
	}
}

package com.tools;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.yunix.models.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class Tools {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u = new User();
		String s = ObjectToJsonString(u);
		System.out.print(s);
		String str = "{\"a\":\"b\", \"c\":\"d\"}";
		JSONObject jsonObject = JSONObject.fromObject(str);
		Map map = jsonObject;
		System.out.print(map.get("a"));
	}

	/**
	 * java实体转json字符串
	 * 
	 * @return
	 */
	public static String ObjectToJsonString(Object obj) {
		try {
			JSONObject json = JSONObject.fromObject(obj);// 将java对象转换为json对象
			String str = json.toString();// 将json对象转换为字符串
			return str;
		} catch (JSONException e) {
			return "{}";
		}
	}

	/**
	 * json字符串转实体
	 * 
	 * @return
	 */
	public static User JsonStringToObject(String str) {
		try {
			JSONObject obj = new JSONObject().fromObject(str);// 将json字符串转换为json对象
			// 将json对象转换为java对象
			User jb = (User) JSONObject.toBean(obj, User.class);// 将建json对象转换为Person对象
			return jb;
		} catch (JSONException e) {
			return new User();
		}
	}

	/**
	 * 获取当前时间
	 */
	public static String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间
	}

}

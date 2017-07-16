package com.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yunix.models.User;

import net.sf.json.JSONObject;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testMap();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	}
	
	public static void testMap(){
		Map<String,Object> m=new HashMap<String,Object>();
		User u1=new User();
		User u2=new User();
		m.put("list",u1);
		List<User> l=new ArrayList<User>();
		l.add(u1);
		l.add(u2);
		m.put("lists", l);
		
	}

	public static void testJson() {
		String jsonStr = "{\"name\":\"test\"}";
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		String name = jsonObject.getString("name");
		System.out.println(name);
		User user = new User();
		user.setName("1111");
		user.setId(1);
		JSONObject json = JSONObject.fromObject(user);// 将java对象转换为json对象
		String str = json.toString();// 将json对象转换为字符串
		System.out.println(str);

		// 同样先将json字符串转换为json对象，再将json对象转换为java对象，如下所示。
		JSONObject obj = new JSONObject().fromObject(str);// 将json字符串转换为json对象
		// 将json对象转换为java对象
		User jb = (User) JSONObject.toBean(obj, User.class);// 将建json对象转换为Person对象
		System.out.println(jb.toString());
	}

}

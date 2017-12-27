package tools;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class SplitTool {
		public static JSONArray  splitExam(String  exams) {
	
				JSONArray jsonarray=new JSONArray();
			
				String[] topic = exams.split("[0-9]、");
				for(int i=0;i<topic.length;i++) {
				JSONObject json=new JSONObject();
				
				//此处可以使用一个clone 原型模式避免 出现此问题
				 json.put("number",i );					
				 String[] opnius= topic[i].split("[A-Z]、");
				 for(int j=0;j<opnius.length;j++) {
					 if(j==0) {
						 json.put("context", opnius[j]);
					 }else {
						 json.put("option"+j,opnius[j]);
					 }
					  jsonarray.add(json);
				 }
				 
				// 保存
			 }
			
			 System.out.println("json :" +jsonarray);
			 return jsonarray;
		}
}

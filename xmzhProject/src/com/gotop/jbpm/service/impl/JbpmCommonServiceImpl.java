package com.gotop.jbpm.service.impl;

import java.util.Iterator;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.gotop.jbpm.service.JbpmCommonService;

public class JbpmCommonServiceImpl implements JbpmCommonService {

	@Override
	public String makeJbpmJsonByData(String data, String processName)
			throws JSONException {
		JSONObject jsonObject = new JSONObject(data);
		JSONObject propsPJson = jsonObject.getJSONObject("props");
		JSONObject statesJson = jsonObject.getJSONObject("states");
		JSONObject pathsJson = jsonObject.getJSONObject("paths");

		String str = "";
		// String pName =
		// propsPJson.getJSONObject("props").getJSONObject("name").getString("value");
		String pName = getPYIndexStr(processName, false);
		
		str += "<process name=\"" + pName
				+ "\" xmlns=\"http://jbpm.org/4.4/jpdl\">";
		Iterator it = statesJson.keys();
		while (it.hasNext()) {
			String key = (String) it.next();
			JSONObject j = statesJson.getJSONObject(key);
			String type = (String) j.get("type");
			if ("start".equals(type)) {
				// 开始节点
				str += "<start";
				if (j.getJSONObject("text") != null) {
					JSONObject textJson = j.getJSONObject("text");
					if (textJson.getString("text") != null) {
						String name = textJson.getString("text");
						str += " name=" + "\"" + name + "\"";
					}
				}
				if (j.getJSONObject("attr") != null) {
					JSONObject attrJson = j.getJSONObject("attr");
					str += " g=\"";
					if (attrJson.getString("x") != null) {
						str += attrJson.getString("x");
						str += ",";
					}
					if (attrJson.getString("y") != null) {
						str += attrJson.getString("y");
						str += ",";
					}
					if (attrJson.getString("width") != null) {
						str += attrJson.getString("width");
						str += ",";
					}
					if (attrJson.getString("height") != null) {
						str += attrJson.getString("height");
					}
					str += "\">";
					str = makePath(key, str, statesJson, pathsJson);
					str += "</start>";
				}
			} else if ("task".equals(type)) {
				// 任务节点
				str += "<task";
				if (j.getJSONObject("text") != null) {
					JSONObject textJson = j.getJSONObject("text");
					if (textJson.getString("text") != null
							&& !"".equals(textJson.getString("text"))) {
						String name = textJson.getString("text");
						str += " name=" + "\"" + name + "\"";
					}
				}
				if (j.getJSONObject("attr") != null) {
					JSONObject attrJson = j.getJSONObject("attr");
					str += " g=\"";
					if (attrJson.getString("x") != null
							&& !"".equals(attrJson.getString("x"))) {
						str += attrJson.getString("x");
						str += ",";
					}
					if (attrJson.getString("y") != null
							&& !"".equals(attrJson.getString("y"))) {
						str += attrJson.getString("y");
						str += ",";
					}
					if (attrJson.getString("width") != null
							&& !"".equals(attrJson.getString("width"))) {
						str += attrJson.getString("width");
						str += ",";
					}
					if (attrJson.getString("height") != null
							&& !"".equals(attrJson.getString("height"))) {
						str += attrJson.getString("height");
					}
					str += "\"";
				}
				if (j.getJSONObject("props") != null) {
					JSONObject propsJson = j.getJSONObject("props");
					/*
					 * if(propsJson.getJSONObject("desc") != null &&
					 * !"".equals(propsJson
					 * .getJSONObject("desc").getString("value"))){ //拼接desc描述内容
					 * str += " desc=\""
					 * +propsJson.getJSONObject("desc").getString("value") +
					 * "\""; }
					 */
					if (propsJson.getJSONObject("form") != null) {
						if (!"".equals(propsJson.getJSONObject("form")
								.getString("value"))) {
							// 拼接form表单内容
							str += " form=\""
									+ propsJson.getJSONObject("form")
											.getString("value") + "\"";
						} else {
							str += " form=\""
									+ "/commonProcess/tCommonProcessAction_getCommonProcessForapprove.action"
									+ "\"";
						}
					}
					if (propsJson.getJSONObject("assignee") != null
							&& !"".equals(propsJson.getJSONObject("assignee")
									.getString("value"))) {
						// 拼接assignee内容
						str += " assignee=\""
								+ propsJson.getJSONObject("assignee")
										.getString("value") + "\"";
					}
				}
				str += " >";
				str = makePath(key, str, statesJson, pathsJson);
				str += "</task>";
			} else if ("end".equals(type)) {
				// 结束节点
				str += "<end";
				if (j.getJSONObject("text") != null) {
					JSONObject textJson = j.getJSONObject("text");
					if (textJson.getString("text") != null) {
						String name = textJson.getString("text");
						str += " name=" + "\"" + name + "\"";
					}
				}
				if (j.getJSONObject("attr") != null) {
					JSONObject attrJson = j.getJSONObject("attr");
					str += " g=\"";
					if (attrJson.getString("x") != null) {
						str += attrJson.getString("x");
						str += ",";
					}
					if (attrJson.getString("y") != null) {
						str += attrJson.getString("y");
						str += ",";
					}
					if (attrJson.getString("width") != null) {
						str += attrJson.getString("width");
						str += ",";
					}
					if (attrJson.getString("height") != null) {
						str += attrJson.getString("height");
					}
					str += "\">";
					str = makePath(key, str, statesJson, pathsJson);
					str += "</end>";
				}
			}
		}
		str += "</process>";
		System.out.println(str);
		return str;
	}

	/**
	 * 根据页面的在线编辑器和节点的json构造线条的xml信息
	 * 
	 * @param key
	 * @param str
	 * @param statesJson
	 * @param pathsJson
	 * @return
	 * @throws JSONException
	 */
	public String makePath(String key, String str, JSONObject statesJson,
			JSONObject pathsJson) throws JSONException {
		Iterator it2 = pathsJson.keys();
		while (it2.hasNext()) {
			String key2 = (String) it2.next();
			JSONObject j2 = pathsJson.getJSONObject(key2);
			String from = j2.getString("from");
			if (from.equals(key)) {
				String to = j2.getString("to");
				if (to != null && !"".equals(to)) {
					str += "<transition";
					String toName = statesJson.getJSONObject(to)
							.getJSONObject("text").getString("text");
					str += " to=\"" + toName + "\"";
				}
				str += " g=\"";
				if (j2.getJSONArray("dots") != null
						&& j2.getJSONArray("dots").length() > 0) {
					JSONArray dotsJson = j2.getJSONArray("dots");
					if (dotsJson.getJSONObject(0) != null) {
						if (!"".equals(dotsJson.getJSONObject(0).getString("x"))) {
							str += dotsJson.getJSONObject(0).getString("x");
							str += ",";
						}
						if (!"".equals(dotsJson.getJSONObject(0).getString("y"))) {
							str += dotsJson.getJSONObject(0).getString("y");
						}
					}
					str += ":";
				}
				if (j2.getJSONObject("textPos") != null) {
					JSONObject textPosJson = j2.getJSONObject("textPos");
					if (textPosJson.getString("x") != null
							&& !"".equals(textPosJson.getString("x"))) {
						str += textPosJson.getString("x");
						str += ",";
					}
					if (textPosJson.getString("y") != null
							&& !"".equals(textPosJson.getString("y"))) {
						str += textPosJson.getString("y");
					}
				}
				str += "\"";
				if (j2.getJSONObject("text") != null
						&& !"".equals(j2.getJSONObject("text")
								.getString("text"))) {
					str += " name=\""
							+ j2.getJSONObject("text").getString("text") + "\"";
				}
				str += "/>";
			}
		}
		return str;
	}

	/**
	 * 
	 * 返回首字母
	 * 
	 * @param strChinese
	 * 
	 * @param bUpCase
	 * 
	 * @return
	 */

	public static String getPYIndexStr(String strChinese, boolean bUpCase) {

		try {

			StringBuffer buffer = new StringBuffer();

			byte b[] = strChinese.getBytes("GBK");// 把中文转化成byte数组

			for (int i = 0; i < b.length; i++) {

				if ((b[i] & 255) > 128) {

					int char1 = b[i++] & 255;

					char1 <<= 8;// 左移运算符用“<<”表示，是将运算符左边的对象，向左移动运算符右边指定的位数，并且在低位补零。其实，向左移n位，就相当于乘上2的n次方

					int chart = char1 + (b[i] & 255);

					buffer.append(getPYIndexChar((char) chart, bUpCase));

					continue;

				}

				char c = (char) b[i];

				if (!Character.isJavaIdentifierPart(c))// 确定指定字符是否可以是 Java
														// 标识符中首字符以外的部分。

					c = 'A';

				buffer.append(c);

			}

			return buffer.toString();

		} catch (Exception e) {

			System.out.println((new StringBuilder())
					.append("\u53D6\u4E2D\u6587\u62FC\u97F3\u6709\u9519")
					.append(e.getMessage()).toString());

		}

		return null;

	}

	/**
	 * 
	 * 得到首字母
	 * 
	 * @param strChinese
	 * 
	 * @param bUpCase
	 * 
	 * @return
	 */

	private static char getPYIndexChar(char strChinese, boolean bUpCase) {

		int charGBK = strChinese;

		char result;

		if (charGBK >= 45217 && charGBK <= 45252)

			result = 'A';

		else

		if (charGBK >= 45253 && charGBK <= 45760)

			result = 'B';

		else

		if (charGBK >= 45761 && charGBK <= 46317)

			result = 'C';

		else

		if (charGBK >= 46318 && charGBK <= 46825)

			result = 'D';

		else

		if (charGBK >= 46826 && charGBK <= 47009)

			result = 'E';

		else

		if (charGBK >= 47010 && charGBK <= 47296)

			result = 'F';

		else

		if (charGBK >= 47297 && charGBK <= 47613)

			result = 'G';

		else

		if (charGBK >= 47614 && charGBK <= 48118)

			result = 'H';

		else

		if (charGBK >= 48119 && charGBK <= 49061)

			result = 'J';

		else

		if (charGBK >= 49062 && charGBK <= 49323)

			result = 'K';

		else

		if (charGBK >= 49324 && charGBK <= 49895)

			result = 'L';

		else

		if (charGBK >= 49896 && charGBK <= 50370)

			result = 'M';

		else

		if (charGBK >= 50371 && charGBK <= 50613)

			result = 'N';

		else

		if (charGBK >= 50614 && charGBK <= 50621)

			result = 'O';

		else

		if (charGBK >= 50622 && charGBK <= 50905)

			result = 'P';

		else

		if (charGBK >= 50906 && charGBK <= 51386)

			result = 'Q';

		else

		if (charGBK >= 51387 && charGBK <= 51445)

			result = 'R';

		else

		if (charGBK >= 51446 && charGBK <= 52217)

			result = 'S';

		else

		if (charGBK >= 52218 && charGBK <= 52697)

			result = 'T';

		else

		if (charGBK >= 52698 && charGBK <= 52979)

			result = 'W';

		else

		if (charGBK >= 52980 && charGBK <= 53688)

			result = 'X';

		else

		if (charGBK >= 53689 && charGBK <= 54480)

			result = 'Y';

		else

		if (charGBK >= 54481 && charGBK <= 55289)

			result = 'Z';

		else

			result = (char) (65 + (new Random()).nextInt(25));

		if (!bUpCase)

			result = Character.toLowerCase(result);

		return result;

	}

}

package com.gotop.jbpm.model;

import java.util.Comparator;
import java.util.Map;

public class TestComparator implements Comparator<Map<String,String>> {

	@Override
	public int compare(Map<String, String> o1, Map<String, String> o2) {
		
		String b1 = o1.get("model_name");
        String b2 = o2.get("model_name");
        int a = 0;
        if (b2 != null) {
            a = b1.compareTo(b2);
        }
        return a;
		
	}

}

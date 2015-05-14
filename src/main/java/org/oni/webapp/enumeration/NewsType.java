package org.oni.webapp.enumeration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public enum NewsType {
	
    INTRO(1,"Giới Thiệu"),
   
    PROMOS(2,"Khuyến mại và Tin tức"),
    
    USER_GUIDE(3,"Hướng dẫn sử dụng"),
    
    CONTACT(4,"Liên Hệ");    

    
    private static final Map<Integer, NewsType> ALL_ITEMS_MAP;
    static {
        Map<Integer, NewsType> map = new HashMap<Integer, NewsType>();
        for (NewsType item : values()) {
            map.put(item.getValue(), item);
        }
        ALL_ITEMS_MAP = Collections.unmodifiableMap(map);
    }

   

    /** DB Value */
    private final int value;
    
    private final String content;

    /*
     * コンストラクタです。
     */
    private NewsType(int value, String content) {
        this.value = value;
        this.content = content;
    }

    
    public int getValue() {
        return this.value;
    }

    public String getContent() {
		return content;
	}
    
    public static NewsType getInstance(int value) {
        return ALL_ITEMS_MAP.get(value);
    }

    
    public static List<String> getContents() {
        List<String> contents = new ArrayList<String>();
        for (NewsType item : ALL_ITEMS_MAP.values()) {
        	contents.add(item.getContent());
        }
        return contents;
    }

    
}

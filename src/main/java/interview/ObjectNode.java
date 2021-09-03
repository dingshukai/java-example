package interview;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: dingshukai
 * @date: 2021/8/27
 */

public class ObjectNode {
    ArrayList<String> fields = new ArrayList<>();
    ArrayList<Object> values = new ArrayList<>();

    public String toString() {
        String s = "{";
        for(int i=0; i<fields.size(); i++) {
            s+="\"" + fields.get(i) + "\"" + ":";
            Object value = values.get(i);
            if(value instanceof String)
                s+= "\"" + value + "\"";
            else
                s+= value;
            if(i<fields.size()-1)
                s+=",";
        }
        s+="}";
        return s;
    }


    public static ObjectNode fromString(String str) {
        return readObject(str, 0);
    }

    private static ObjectNode readObject(String str, int from) {
        if(str.length()<from+2 || str.charAt(from)!='{')
            return null;
        if(str.charAt(from+1)=='}')
            return new ObjectNode();
        int cur = from+1;
        ObjectNode obj = new ObjectNode();
        while(true) {
            String key = readString(str, cur);
            if(key==null)
                return null;
            cur = cur+key.length()+2;
            if(cur>=str.length())
                return null;
            if(str.charAt(cur)!=':')
                return null;

            Object value = readString(str, cur+1);
            if(value==null)
                value = readObject(str, cur+1);
            if(value==null)
                return null;
            cur++;
            if(cur>=str.length())
                return null;
            obj.fields.add(key);
            obj.values.add(value);
            if(cur=='}')
                return obj;
            if(cur!=',')
                return null;
        }
    }



    private static String readString(String str, int from) {
        if(from+2>=str.length())
            return null;
        if(str.charAt(from)!='"')
            return null;
        int cur = from+1;
        while(cur < str.length()) {
            if(str.charAt(cur)=='"') {
                if(str.charAt(cur-1)!='\\')
                    return str.substring(from+1, cur);
            }
            cur++;
        }
        return null;
    }
}



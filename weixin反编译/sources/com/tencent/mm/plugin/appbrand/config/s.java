package com.tencent.mm.plugin.appbrand.config;

import java.util.LinkedList;
import org.json.JSONArray;

final class s {
    static LinkedList<String> f(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            linkedList.add(jSONArray.optString(i));
        }
        return linkedList;
    }
}

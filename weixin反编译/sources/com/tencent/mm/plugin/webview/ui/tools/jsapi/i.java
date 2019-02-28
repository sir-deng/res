package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.a.m;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i {
    public Map<String, Object> pug;
    public String tQe;
    Map<String, Object> tQf = new HashMap();
    public String tQg;
    public String type;

    public static class a {
        public static String a(String str, JSONObject jSONObject, boolean z, String str2) {
            return a("event", str, null, jSONObject, z, str2);
        }

        public static String a(String str, Map<String, Object> map, boolean z, String str2) {
            return a("event", str, map, null, z, str2);
        }

        static String a(String str, String str2, Map<String, Object> map, JSONObject jSONObject, boolean z, String str3) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("__msg_type", str);
                if (str.equals("callback")) {
                    jSONObject2.put("__callback_id", str2);
                } else if (str.equals("event")) {
                    jSONObject2.put("__event_id", str2);
                }
                if (jSONObject == null) {
                    jSONObject2.put("__params", U(map));
                } else {
                    jSONObject2.put("__params", jSONObject);
                }
                if (z) {
                    return g(jSONObject2, str3);
                }
                return jSONObject2.toString();
            } catch (Exception e) {
                x.e("MicroMsg.MsgWrapper", "build fail, exception = " + e.getMessage());
                return null;
            }
        }

        private static String g(JSONObject jSONObject, String str) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("__json_message", jSONObject);
                x.i("MicroMsg.MsgWrapper", "js digest verification contentStr = ", jSONObject.toString().replaceAll("\\\\/", "/"));
                x.i("MicroMsg.MsgWrapper", "js digest verification shaStr = ", m.bX(r1 + str));
                jSONObject2.put("__sha_key", r1);
                return jSONObject2.toString();
            } catch (Exception e) {
                x.e("MicroMsg.MsgWrapper", "build fail, exception = " + e.getMessage());
                return null;
            }
        }

        public static JSONObject U(Map<String, Object> map) {
            if (map == null || map.size() == 0) {
                return new JSONObject();
            }
            try {
                String str = (String) map.get("jsapi_callback_json_special_key");
                JSONObject jSONObject = new JSONObject();
                for (String str2 : map.keySet()) {
                    if (!(str2 == null || str2.equals("jsapi_callback_json_special_key"))) {
                        if (str == null || !str2.equals(str)) {
                            jSONObject.put(str2, map.get(str2));
                        } else {
                            jSONObject.put(str, new JSONArray((String) map.get(str)));
                        }
                    }
                }
                return jSONObject;
            } catch (Exception e) {
                x.e("MicroMsg.MsgWrapper", "convertMapToJSON fail, exception = " + e.getMessage());
                return null;
            }
        }

        private static i Qq(String str) {
            if (str == null || str.length() == 0) {
                x.e("MicroMsg.MsgWrapper", "fromString fail, src is null");
                return null;
            }
            i iVar = new i();
            JSONObject jSONObject = new JSONObject(str);
            iVar.type = jSONObject.getString("__msg_type");
            iVar.tQe = jSONObject.getString("__callback_id");
            iVar.tQg = jSONObject.getString("func");
            iVar.pug = new HashMap();
            JSONObject jSONObject2 = jSONObject.getJSONObject("params");
            if (jSONObject2 != null) {
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    String string = jSONObject2.getString(str2);
                    if (string == null) {
                        string = "";
                    }
                    if ("urls".equalsIgnoreCase(str2)) {
                        x.v("MicroMsg.MsgWrapper", "key is JSONArray, %s", str2);
                        try {
                            JSONArray jSONArray = new JSONArray(string);
                            Object obj = new String[jSONArray.length()];
                            for (int i = 0; i < obj.length; i++) {
                                obj[i] = jSONArray.getString(i);
                            }
                            iVar.pug.put(str2, obj);
                        } catch (Exception e) {
                            try {
                                x.e("MicroMsg.MsgWrapper", "parse JSONArray fail, ex = %s", e.getMessage());
                            } catch (Exception e2) {
                                x.e("MicroMsg.MsgWrapper", "fromString fail, exception = " + e2.getMessage());
                                return null;
                            }
                        }
                    }
                    iVar.pug.put(str2, string);
                }
            }
            return iVar;
        }

        static List<i> d(String str, boolean z, String str2) {
            if (str == null || str.length() == 0) {
                x.e("MicroMsg.MsgWrapper", "getMsgList fail, src is null");
                return null;
            }
            JSONArray jSONArray;
            if (z) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONArray jSONArray2 = jSONObject.getJSONArray("__json_message");
                    if (jSONObject.getString("__sha_key").equals(m.bX(jSONArray2.toString().replaceAll("\\\\/", "/") + str2))) {
                        jSONArray = jSONArray2;
                    } else {
                        x.e("MicroMsg.MsgWrapper", "fromString SHA1 verification failed, sha1Str = %s, calSha1Str = %s, jsonList = %s", jSONObject.getString("__sha_key"), m.bX(jSONArray2.toString().replaceAll("\\\\/", "/") + str2), jSONArray2.toString().replaceAll("\\\\/", "/"));
                        return null;
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MsgWrapper", "dealMsgQueue fail, exception = " + e.getMessage());
                    return null;
                }
            }
            jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return null;
            }
            List<i> linkedList = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(Qq(jSONArray.getString(i)));
            }
            return linkedList;
        }
    }

    public final Map<String, Object> bVA() {
        return this.tQf;
    }

    public static Bundle ap(Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof String[]) {
                bundle.putStringArray(str, (String[]) obj);
            } else if (obj instanceof Bundle) {
                bundle.putBundle(str, (Bundle) obj);
            } else {
                bundle.putString(str, String.valueOf(obj));
            }
        }
        return bundle;
    }

    public static Map<String, Object> aa(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        Set<String> keySet = bundle.keySet();
        if (keySet == null) {
            return null;
        }
        Map<String, Object> hashMap = new HashMap();
        for (String str : keySet) {
            hashMap.put(str, bundle.get(str));
        }
        return hashMap;
    }
}

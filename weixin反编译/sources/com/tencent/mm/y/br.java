package com.tencent.mm.y;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class br {
    public static br hju = new br();
    private SharedPreferences hjv = ad.getContext().getSharedPreferences(ad.cgf() + "_account_history", 0);
    private SharedPreferences hjw = ad.getContext().getSharedPreferences(ad.cgf() + "_account_switch", 0);

    private br() {
    }

    public final void j(String str, String str2, String str3) {
        try {
            JSONObject jSONObject;
            if (this.hjv.contains(str)) {
                String string = this.hjv.getString(str, "");
                if (bi.oN(string)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(new String(Base64.decode(string, 0)));
                }
            } else {
                jSONObject = new JSONObject();
            }
            if (!bi.G(str2, str3)) {
                jSONObject.put(str2, str3);
                x.i("MicroMsg.SwitchAccountInfo", "put key %s, jsonStr %s", str2, jSONObject.toString());
                this.hjv.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SwitchAccountInfo", "save account info %s about %s failed, error: %s", str2, str, e.getMessage());
        }
    }

    public final void c(String str, Map<String, String> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    JSONObject jSONObject;
                    if (this.hjv.contains(str)) {
                        String string = this.hjv.getString(str, "");
                        if (bi.oN(string)) {
                            jSONObject = new JSONObject();
                        } else {
                            jSONObject = new JSONObject(new String(Base64.decode(string, 0)));
                        }
                    } else {
                        jSONObject = new JSONObject();
                    }
                    for (String str2 : map.keySet()) {
                        jSONObject.put(str2, map.get(str2));
                    }
                    x.i("MicroMsg.SwitchAccountInfo", "put json str %s", jSONObject.toString());
                    this.hjv.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
                    return;
                }
            } catch (Exception e) {
                x.e("MicroMsg.SwitchAccountInfo", "save account info about %s failed, error: %s", str, e.getMessage());
                return;
            }
        }
        x.i("MicroMsg.SwitchAccountInfo", "kv map is null or empty!");
    }

    public final String getString(String str, String str2) {
        try {
            x.i("MicroMsg.SwitchAccountInfo", "get %s, %s", str, str2);
            if (this.hjv.contains(str)) {
                String str3 = new String(Base64.decode(this.hjv.getString(str, ""), 0));
                if (!bi.oN(str3)) {
                    x.i("MicroMsg.SwitchAccountInfo", "get json str %s", str3);
                    JSONObject jSONObject = new JSONObject(str3);
                    if (jSONObject.has(str2)) {
                        return jSONObject.getString(str2);
                    }
                }
            }
            x.w("MicroMsg.SwitchAccountInfo", "account info about %s is not found!", str);
        } catch (Exception e) {
            x.e("MicroMsg.SwitchAccountInfo", "get account info %s about %s failed, error: %s", str2, str, e.getMessage());
        }
        return "";
    }

    public final void ic(String str) {
        if (ie(str)) {
            Set stringSet = this.hjw.getStringSet("first_switch_group", null);
            if (stringSet != null) {
                stringSet.remove(str);
                this.hjw.edit().remove("first_switch_group").apply();
                this.hjw.edit().putStringSet("first_switch_group", stringSet).commit();
            }
        }
        if (if(str) && this.hjv.contains(str)) {
            this.hjv.edit().remove(str).commit();
        }
    }

    public final void V(String str, String str2) {
        if (!bi.G(str, str2) && !str.equals(str2)) {
            Set stringSet = this.hjw.getStringSet("first_switch_group", null);
            if (stringSet == null) {
                stringSet = new HashSet();
            }
            if (!stringSet.contains(str) || stringSet.size() >= 2) {
                stringSet.clear();
                stringSet.add(str);
                stringSet.add(str2);
            } else {
                stringSet.add(str2);
            }
            this.hjw.edit().remove("first_switch_group").apply();
            this.hjw.edit().putStringSet("first_switch_group", stringSet).commit();
        }
    }

    public final boolean ie(String str) {
        Set stringSet = this.hjw.getStringSet("first_switch_group", null);
        if (stringSet == null) {
            return false;
        }
        return stringSet.contains(str);
    }

    public final boolean if(String str) {
        return this.hjv.contains(str);
    }

    public final Set<String> Ib() {
        Set<String> hashSet = new HashSet();
        Collection stringSet = this.hjw.getStringSet("first_switch_group", null);
        if (!(stringSet == null || stringSet.isEmpty())) {
            hashSet.addAll(stringSet);
        }
        return hashSet;
    }
}

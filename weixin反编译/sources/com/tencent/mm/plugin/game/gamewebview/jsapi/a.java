package com.tencent.mm.plugin.game.gamewebview.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a extends c {
    public Bundle nbJ;

    public static class a {
        private int jgb;
        private d nbK;

        public a(d dVar, int i) {
            this.nbK = dVar;
            this.jgb = i;
        }

        public final void sE(String str) {
            if (this.nbK != null) {
                this.nbK.E(this.jgb, str);
            }
            this.nbK = null;
        }
    }

    public void a(d dVar, JSONObject jSONObject, int i) {
    }

    public void a(Context context, String str, com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask.a aVar) {
    }

    public static String e(String str, Map<String, ? extends Object> map) {
        Map hashMap = new HashMap();
        hashMap.put("err_msg", str);
        if (map != null) {
            hashMap.putAll(map);
        }
        com.tencent.mm.plugin.game.gamewebview.a.d.m(hashMap);
        return new JSONObject(hashMap).toString();
    }
}

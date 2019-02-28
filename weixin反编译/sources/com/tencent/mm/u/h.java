package com.tencent.mm.u;

import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends JSONObject implements c {
    private final c gQN;

    public final /* synthetic */ c C(String str, int i) {
        return D(str, i);
    }

    public final /* synthetic */ c a(String str, double d) {
        return b(str, d);
    }

    public final /* synthetic */ a fw(String str) {
        return fD(str);
    }

    public final /* synthetic */ a fx(String str) {
        return fE(str);
    }

    public final /* synthetic */ c fy(String str) {
        return fF(str);
    }

    public final /* synthetic */ c fz(String str) {
        return fG(str);
    }

    public final /* synthetic */ JSONArray getJSONArray(String str) {
        return fD(str);
    }

    public final /* synthetic */ JSONObject getJSONObject(String str) {
        return fF(str);
    }

    public final /* synthetic */ c i(String str, long j) {
        return j(str, j);
    }

    public final /* synthetic */ c k(String str, Object obj) {
        return m(str, obj);
    }

    public final /* synthetic */ c l(String str, Object obj) {
        return n(str, obj);
    }

    public final /* synthetic */ c n(String str, boolean z) {
        return o(str, z);
    }

    public final /* synthetic */ JSONArray optJSONArray(String str) {
        return fE(str);
    }

    public final /* synthetic */ JSONObject optJSONObject(String str) {
        return fG(str);
    }

    public final /* synthetic */ JSONObject put(String str, double d) {
        return b(str, d);
    }

    public final /* synthetic */ JSONObject put(String str, int i) {
        return D(str, i);
    }

    public final /* synthetic */ JSONObject put(String str, long j) {
        return j(str, j);
    }

    public final /* synthetic */ JSONObject put(String str, Object obj) {
        return m(str, obj);
    }

    public final /* synthetic */ JSONObject put(String str, boolean z) {
        return o(str, z);
    }

    public final /* synthetic */ JSONObject putOpt(String str, Object obj) {
        return n(str, obj);
    }

    public h() {
        this.gQN = g.Ck();
    }

    public h(c cVar) {
        Assert.assertNotNull(cVar);
        this.gQN = cVar;
    }

    public h(Map map) {
        this.gQN = g.n(map);
    }

    public h(String str) {
        this.gQN = g.fB(str);
    }

    public final int length() {
        return this.gQN.length();
    }

    private h o(String str, boolean z) {
        this.gQN.n(str, z);
        return this;
    }

    private h b(String str, double d) {
        this.gQN.a(fv(str), d);
        return this;
    }

    private h D(String str, int i) {
        this.gQN.C(fv(str), i);
        return this;
    }

    private h j(String str, long j) {
        this.gQN.i(fv(str), j);
        return this;
    }

    private h m(String str, Object obj) {
        this.gQN.k(str, obj);
        return this;
    }

    private h n(String str, Object obj) {
        this.gQN.l(str, obj);
        return this;
    }

    public final String fv(String str) {
        return this.gQN.fv(str);
    }

    public final Object remove(String str) {
        return this.gQN.remove(str);
    }

    public final boolean isNull(String str) {
        return this.gQN.isNull(str);
    }

    public final boolean has(String str) {
        return this.gQN.has(str);
    }

    public final Object get(String str) {
        return this.gQN.get(str);
    }

    public final Object opt(String str) {
        return this.gQN.opt(str);
    }

    public final boolean getBoolean(String str) {
        return this.gQN.getBoolean(str);
    }

    public final boolean optBoolean(String str) {
        return this.gQN.optBoolean(str, false);
    }

    public final boolean optBoolean(String str, boolean z) {
        return this.gQN.optBoolean(str, z);
    }

    public final double getDouble(String str) {
        return this.gQN.getDouble(str);
    }

    public final double optDouble(String str) {
        return this.gQN.optDouble(str, Double.NaN);
    }

    public final double optDouble(String str, double d) {
        return this.gQN.optDouble(str, d);
    }

    public final int getInt(String str) {
        return this.gQN.getInt(str);
    }

    public final int optInt(String str) {
        return this.gQN.optInt(str, 0);
    }

    public final int optInt(String str, int i) {
        return this.gQN.optInt(str, i);
    }

    public final long getLong(String str) {
        return this.gQN.getLong(str);
    }

    public final long optLong(String str) {
        return this.gQN.optLong(str, 0);
    }

    public final long optLong(String str, long j) {
        return this.gQN.optLong(str, j);
    }

    public final String getString(String str) {
        return this.gQN.getString(str);
    }

    public final String optString(String str) {
        return this.gQN.optString(str, "");
    }

    public final String optString(String str, String str2) {
        return this.gQN.optString(str);
    }

    private e fD(String str) {
        a fw = this.gQN.fw(str);
        if (fw == null) {
            return null;
        }
        return new e(fw);
    }

    private e fE(String str) {
        a fx = this.gQN.fx(str);
        if (fx == null) {
            return null;
        }
        return new e(fx);
    }

    private h fF(String str) {
        c fy = this.gQN.fy(str);
        if (fy == null) {
            return null;
        }
        return new h(fy);
    }

    private h fG(String str) {
        c fz = this.gQN.fz(str);
        if (fz == null) {
            return null;
        }
        return new h(fz);
    }

    public final Iterator<String> keys() {
        return this.gQN.keys();
    }

    public final String toString() {
        return this.gQN.toString();
    }
}

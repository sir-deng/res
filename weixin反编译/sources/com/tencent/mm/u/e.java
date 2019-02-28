package com.tencent.mm.u;

import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends JSONArray implements a {
    private final a gQK;

    public final /* synthetic */ a aF(long j) {
        return aG(j);
    }

    public final /* synthetic */ a ax(Object obj) {
        return ay(obj);
    }

    public final /* synthetic */ a bv(boolean z) {
        return bw(z);
    }

    public final /* synthetic */ a g(double d) {
        return h(d);
    }

    public final /* synthetic */ JSONArray getJSONArray(int i) {
        return gv(i);
    }

    public final /* synthetic */ JSONObject getJSONObject(int i) {
        return gx(i);
    }

    public final /* synthetic */ a gp(int i) {
        return gu(i);
    }

    public final /* synthetic */ a gq(int i) {
        return gv(i);
    }

    public final /* synthetic */ a gr(int i) {
        return gw(i);
    }

    public final /* synthetic */ c gs(int i) {
        return gx(i);
    }

    public final /* synthetic */ c gt(int i) {
        return gy(i);
    }

    public final /* synthetic */ JSONArray optJSONArray(int i) {
        return gw(i);
    }

    public final /* synthetic */ JSONObject optJSONObject(int i) {
        return gy(i);
    }

    public final /* synthetic */ JSONArray put(double d) {
        return h(d);
    }

    public final /* synthetic */ JSONArray put(int i) {
        return gu(i);
    }

    public final /* synthetic */ JSONArray put(int i, double d) {
        this.gQK.g(d);
        return this;
    }

    public final /* synthetic */ JSONArray put(int i, int i2) {
        this.gQK.gp(i2);
        return this;
    }

    public final /* synthetic */ JSONArray put(int i, long j) {
        this.gQK.aF(j);
        return this;
    }

    public final /* synthetic */ JSONArray put(int i, Object obj) {
        this.gQK.ax(obj);
        return this;
    }

    public final /* synthetic */ JSONArray put(int i, boolean z) {
        this.gQK.bv(z);
        return this;
    }

    public final /* synthetic */ JSONArray put(long j) {
        return aG(j);
    }

    public final /* synthetic */ JSONArray put(Object obj) {
        return ay(obj);
    }

    public final /* synthetic */ JSONArray put(boolean z) {
        return bw(z);
    }

    public e() {
        this.gQK = g.Cl();
    }

    e(a aVar) {
        Assert.assertNotNull(aVar);
        this.gQK = aVar;
    }

    public final int length() {
        return this.gQK.length();
    }

    private e bw(boolean z) {
        this.gQK.bv(z);
        return this;
    }

    private e h(double d) {
        this.gQK.g(d);
        return this;
    }

    private e gu(int i) {
        this.gQK.gp(i);
        return this;
    }

    private e aG(long j) {
        this.gQK.aF(j);
        return this;
    }

    private e ay(Object obj) {
        this.gQK.ax(obj);
        return this;
    }

    public final boolean isNull(int i) {
        return this.gQK.isNull(i);
    }

    public final Object get(int i) {
        return this.gQK.get(i);
    }

    public final Object opt(int i) {
        return this.gQK.opt(i);
    }

    public final Object remove(int i) {
        return this.gQK.remove(i);
    }

    public final boolean getBoolean(int i) {
        return this.gQK.getBoolean(i);
    }

    public final boolean optBoolean(int i) {
        return this.gQK.optBoolean(i);
    }

    public final boolean optBoolean(int i, boolean z) {
        return this.gQK.optBoolean(i, z);
    }

    public final double getDouble(int i) {
        return this.gQK.getDouble(i);
    }

    public final double optDouble(int i) {
        return this.gQK.optDouble(i);
    }

    public final double optDouble(int i, double d) {
        return this.gQK.optDouble(i, d);
    }

    public final int getInt(int i) {
        return this.gQK.getInt(i);
    }

    public final int optInt(int i) {
        return this.gQK.optInt(i);
    }

    public final int optInt(int i, int i2) {
        return this.gQK.optInt(i, i2);
    }

    public final long getLong(int i) {
        return this.gQK.getLong(i);
    }

    public final long optLong(int i) {
        return this.gQK.optLong(i);
    }

    public final long optLong(int i, long j) {
        return this.gQK.optLong(i, j);
    }

    public final String getString(int i) {
        return this.gQK.getString(i);
    }

    public final String optString(int i) {
        return this.gQK.optString(i);
    }

    public final String optString(int i, String str) {
        return this.gQK.optString(i, str);
    }

    private e gv(int i) {
        return new e(this.gQK.gq(i));
    }

    private e gw(int i) {
        return new e(this.gQK.gr(i));
    }

    private h gx(int i) {
        return new h(this.gQK.gs(i));
    }

    private h gy(int i) {
        return new h(this.gQK.gt(i));
    }
}

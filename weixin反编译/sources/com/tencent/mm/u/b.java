package com.tencent.mm.u;

import android.annotation.TargetApi;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements a {
    private JSONArray gQI;

    public b() {
        this.gQI = new JSONArray();
    }

    public b(String str) {
        try {
            this.gQI = new JSONArray(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    b(JSONArray jSONArray) {
        Assert.assertNotNull(jSONArray);
        this.gQI = jSONArray;
    }

    public final int length() {
        return this.gQI.length();
    }

    public final a bv(boolean z) {
        this.gQI.put(z);
        return this;
    }

    public final a g(double d) {
        try {
            this.gQI.put(d);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final a gp(int i) {
        this.gQI.put(i);
        return this;
    }

    public final a aF(long j) {
        this.gQI.put(j);
        return this;
    }

    public final a ax(Object obj) {
        this.gQI.put(obj);
        return this;
    }

    public final boolean isNull(int i) {
        return this.gQI.isNull(i);
    }

    public final Object get(int i) {
        try {
            Object obj = this.gQI.get(i);
            if (obj instanceof JSONObject) {
                return new d((JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                return new b((JSONArray) obj);
            }
            return obj;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final Object opt(int i) {
        Object opt = this.gQI.opt(i);
        if (opt instanceof JSONObject) {
            return new d((JSONObject) opt);
        }
        if (opt instanceof JSONArray) {
            return new b((JSONArray) opt);
        }
        return opt;
    }

    @TargetApi(19)
    public final Object remove(int i) {
        Object remove = this.gQI.remove(i);
        if (remove instanceof JSONObject) {
            return new d((JSONObject) remove);
        }
        if (remove instanceof JSONArray) {
            return new b((JSONArray) remove);
        }
        return remove;
    }

    public final boolean getBoolean(int i) {
        try {
            return this.gQI.getBoolean(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final boolean optBoolean(int i) {
        return this.gQI.optBoolean(i);
    }

    public final boolean optBoolean(int i, boolean z) {
        return this.gQI.optBoolean(i, z);
    }

    public final double getDouble(int i) {
        try {
            return this.gQI.getDouble(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final double optDouble(int i) {
        return this.gQI.optDouble(i);
    }

    public final double optDouble(int i, double d) {
        return this.gQI.optDouble(i, d);
    }

    public final int getInt(int i) {
        try {
            return this.gQI.getInt(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final int optInt(int i) {
        return this.gQI.optInt(i);
    }

    public final int optInt(int i, int i2) {
        return this.gQI.optInt(i, i2);
    }

    public final long getLong(int i) {
        try {
            return this.gQI.getLong(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final long optLong(int i) {
        return this.gQI.optLong(i);
    }

    public final long optLong(int i, long j) {
        return this.gQI.optLong(i, j);
    }

    public final String getString(int i) {
        try {
            return this.gQI.getString(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final String optString(int i) {
        return this.gQI.optString(i);
    }

    public final String optString(int i, String str) {
        return this.gQI.optString(i, str);
    }

    public final a gq(int i) {
        try {
            JSONArray jSONArray = this.gQI.getJSONArray(i);
            if (jSONArray == null) {
                return null;
            }
            return new b(jSONArray);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final a gr(int i) {
        JSONArray optJSONArray = this.gQI.optJSONArray(i);
        if (optJSONArray == null) {
            return null;
        }
        return new b(optJSONArray);
    }

    public final c gs(int i) {
        try {
            JSONObject jSONObject = this.gQI.getJSONObject(i);
            if (jSONObject == null) {
                return null;
            }
            return new d(jSONObject);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c gt(int i) {
        JSONObject optJSONObject = this.gQI.optJSONObject(i);
        if (optJSONObject == null) {
            return null;
        }
        return new d(optJSONObject);
    }
}

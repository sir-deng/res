package com.tencent.mm.u;

import com.eclipsesource.a.a;
import com.eclipsesource.a.b;
import com.eclipsesource.a.h;
import junit.framework.Assert;

public final class j implements a {
    private b gQO;

    public j() {
        this.gQO = new b();
    }

    public j(String str) {
        this.gQO = a.A(str).hp();
        if (this.gQO == null) {
            throw new f(String.format("JSONArray string(%s) parse error.", new Object[]{str}));
        }
    }

    j(b bVar) {
        Assert.assertNotNull(bVar);
        this.gQO = bVar;
    }

    public final int length() {
        return this.gQO.abw.size();
    }

    public final a bv(boolean z) {
        this.gQO.ad(z);
        return this;
    }

    public final a g(double d) {
        this.gQO.e(d);
        return this;
    }

    public final a gp(int i) {
        this.gQO.bT(i);
        return this;
    }

    public final a aF(long j) {
        this.gQO.h(j);
        return this;
    }

    public final a ax(Object obj) {
        i.a(this.gQO, obj);
        return this;
    }

    public final boolean isNull(int i) {
        return i < 0 || i >= length() || this.gQO.bU(i) == null;
    }

    public final Object get(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        h bU = this.gQO.bU(i);
        if (bU == null) {
            return null;
        }
        if (bU.isNumber()) {
            return bU.toString();
        }
        if (bU.isBoolean()) {
            return Boolean.valueOf(bU.hq());
        }
        if (bU.isArray()) {
            return new j(bU.hp());
        }
        if (bU.isObject()) {
            return new k(bU.hu());
        }
        if (bU.isString()) {
            return bU.hD();
        }
        return null;
    }

    public final Object opt(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            return null;
        }
        h bU = this.gQO.bU(i);
        if (bU == null) {
            return null;
        }
        if (bU.isNumber()) {
            return bU.toString();
        }
        if (bU.isBoolean()) {
            return Boolean.valueOf(bU.hq());
        }
        if (bU.isArray()) {
            return new j(bU.hp());
        }
        if (bU.isObject()) {
            return new k(bU.hu());
        }
        if (bU.isString()) {
            return bU.hD();
        }
        return null;
    }

    public final Object remove(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            return null;
        }
        h hVar = this.gQO;
        hVar.abw.remove(i);
        if (hVar == null) {
            return null;
        }
        if (hVar.isNumber()) {
            return hVar.toString();
        }
        if (hVar.isBoolean()) {
            return Boolean.valueOf(hVar.hq());
        }
        if (hVar.isArray()) {
            return new j(hVar.hp());
        }
        if (hVar.isObject()) {
            return new k(hVar.hu());
        }
        if (hVar.isString()) {
            return hVar.hD();
        }
        return null;
    }

    public final boolean getBoolean(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        h bU = this.gQO.bU(i);
        if (bU == null) {
            throw new f(String.format("getBoolean(%d) return null.", new Object[]{Integer.valueOf(i)}));
        } else if (bU.isBoolean()) {
            return bU.hq();
        } else {
            if (bU.isString()) {
                String hD = bU.hD();
                if ("true".equals(hD)) {
                    return true;
                }
                if ("false".equals(hD)) {
                    return false;
                }
            }
            throw new f(String.format("getBoolean(%d) error, value : %s.", new Object[]{Integer.valueOf(i), bU}));
        }
    }

    public final boolean optBoolean(int i) {
        return optBoolean(i, false);
    }

    public final boolean optBoolean(int i, boolean z) {
        int length = length();
        if (i < 0 || i >= length) {
            return z;
        }
        h bU = this.gQO.bU(i);
        if (bU == null) {
            return z;
        }
        if (bU.isBoolean()) {
            return bU.hq();
        }
        if (!bU.isString()) {
            return z;
        }
        String hD = bU.hD();
        if ("true".equals(hD)) {
            return true;
        }
        if ("false".equals(hD)) {
            return false;
        }
        return z;
    }

    public final double getDouble(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        h bU = this.gQO.bU(i);
        if (bU == null) {
            throw new f(String.format("getDouble(%d) return null.", new Object[]{Integer.valueOf(i)}));
        }
        try {
            if (bU.isNumber()) {
                return bU.ht();
            }
            if (bU.isString()) {
                return Double.parseDouble(bU.hD());
            }
            throw new f(String.format("getDouble(%d) error, value : %s.", new Object[]{Integer.valueOf(i), bU}));
        } catch (Exception e) {
        }
    }

    public final double optDouble(int i) {
        return optDouble(i, 0.0d);
    }

    public final double optDouble(int i, double d) {
        int length = length();
        if (i < 0 || i >= length) {
            return d;
        }
        h bU = this.gQO.bU(i);
        if (bU == null) {
            return d;
        }
        try {
            if (bU.isNumber()) {
                return bU.ht();
            }
            if (bU.isString()) {
                return Double.parseDouble(bU.hD());
            }
            return d;
        } catch (Exception e) {
            return d;
        }
    }

    public final int getInt(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        Object bU = this.gQO.bU(i);
        if (bU == null) {
            throw new f(String.format("getInteger(%d) return null.", new Object[]{Integer.valueOf(i)}));
        }
        try {
            if (bU.isNumber()) {
                try {
                    return bU.hr();
                } catch (Exception e) {
                    return (int) bU.ht();
                }
            }
            if (bU.isString()) {
                return (int) Double.parseDouble(bU.hD());
            }
            throw new f(String.format("getInt(%d) error, value : %s.", new Object[]{Integer.valueOf(i), bU}));
        } catch (Exception e2) {
        }
    }

    public final int optInt(int i) {
        return optInt(i, 0);
    }

    public final int optInt(int i, int i2) {
        int length = length();
        if (i < 0 || i >= length) {
            return i2;
        }
        h bU = this.gQO.bU(i);
        if (bU == null) {
            return i2;
        }
        try {
            if (bU.isNumber()) {
                try {
                    return bU.hr();
                } catch (Exception e) {
                    return (int) bU.ht();
                }
            } else if (bU.isString()) {
                return (int) Double.parseDouble(bU.hD());
            } else {
                return i2;
            }
        } catch (Exception e2) {
            return i2;
        }
    }

    public final long getLong(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        Object bU = this.gQO.bU(i);
        if (bU == null) {
            throw new f(String.format("getLong(%d) return null.", new Object[]{Integer.valueOf(i)}));
        }
        try {
            if (bU.isNumber()) {
                try {
                    return bU.hs();
                } catch (Exception e) {
                    return (long) bU.ht();
                }
            }
            if (bU.isString()) {
                return (long) Double.parseDouble(bU.hD());
            }
            throw new f(String.format("getLong(%d) error, value : %s.", new Object[]{Integer.valueOf(i), bU}));
        } catch (Exception e2) {
        }
    }

    public final long optLong(int i) {
        return optLong(i, 0);
    }

    public final long optLong(int i, long j) {
        int length = length();
        if (i < 0 || i >= length) {
            return j;
        }
        h bU = this.gQO.bU(i);
        if (bU == null) {
            return j;
        }
        try {
            if (bU.isNumber()) {
                try {
                    return bU.hs();
                } catch (Exception e) {
                    return (long) bU.ht();
                }
            } else if (bU.isString()) {
                return (long) Double.parseDouble(bU.hD());
            } else {
                return j;
            }
        } catch (Exception e2) {
            return j;
        }
    }

    public final String getString(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        h bU = this.gQO.bU(i);
        if (bU == null) {
            throw new f(String.format("getString(%d) return null.", new Object[]{Integer.valueOf(i)}));
        } else if (bU.isString()) {
            return bU.hD();
        } else {
            return bU.toString();
        }
    }

    public final String optString(int i) {
        return optString(i, null);
    }

    public final String optString(int i, String str) {
        int length = length();
        if (i < 0 || i >= length) {
            return str;
        }
        h bU = this.gQO.bU(i);
        if (bU == null) {
            return str;
        }
        if (bU.isString()) {
            return bU.hD();
        }
        return bU.toString();
    }

    public final a gq(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        h bU = this.gQO.bU(i);
        if (bU != null) {
            return new j(bU.hp());
        }
        throw new f(String.format("getJSONArray(%d) return null.", new Object[]{Integer.valueOf(i)}));
    }

    public final a gr(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            return null;
        }
        h bU = this.gQO.bU(i);
        if (bU != null) {
            return new j(bU.hp());
        }
        return null;
    }

    public final c gs(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            throw new f(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
        }
        h bU = this.gQO.bU(i);
        if (bU != null) {
            return new k(bU.hu());
        }
        throw new f(String.format("getJSONObject(%d) return null.", new Object[]{Integer.valueOf(i)}));
    }

    public final c gt(int i) {
        int length = length();
        if (i < 0 || i >= length) {
            return null;
        }
        h bU = this.gQO.bU(i);
        if (bU != null) {
            return new k(bU.hu());
        }
        return null;
    }

    public final String toString() {
        return this.gQO.toString();
    }
}

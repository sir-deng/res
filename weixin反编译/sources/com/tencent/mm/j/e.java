package com.tencent.mm.j;

import com.tencent.mm.f.a.cl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e {
    private HashMap<String, String> gJT = new HashMap();
    public boolean gJU = false;

    public final synchronized String getValue(String str) {
        if (!this.gJU) {
            x.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            kt();
        }
        x.d("MicroMsg.DynamicConfig", "get configs.get(config) %s %s", str.trim(), this.gJT.get(str));
        return (String) this.gJT.get(str);
    }

    public final int getInt(String str, int i) {
        try {
            return Integer.parseInt(getValue(str));
        } catch (Exception e) {
            x.e("MicroMsg.DynamicConfig", "parseInt failed, val: " + str);
            return i;
        }
    }

    public final synchronized List<String> eS(String str) {
        List<String> arrayList;
        if (!this.gJU) {
            x.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            kt();
        }
        arrayList = new ArrayList();
        if (!bi.oN(str)) {
            for (String str2 : this.gJT.keySet()) {
                if (str2.matches(str)) {
                    arrayList.add(this.gJT.get(str2));
                }
            }
        }
        x.d("MicroMsg.DynamicConfig", "searchValues, entry:%s, size:%d", str, Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    @Deprecated
    public final synchronized void put(String str, String str2) {
        if (!(str == null || str2 == null)) {
            x.d("MicroMsg.DynamicConfig", "put configs.put(key,value) %s %s", str.trim(), str2);
            this.gJT.put(str, str2);
        }
    }

    public synchronized void kt() {
        g.Dr();
        if (g.Dq() != null) {
            g.Dr();
            if (g.Dq().Db() != null) {
                this.gJU = true;
                g.Dr();
                l((String) g.Dq().Db().get(278529, null), false);
            }
        }
        g.Dr();
        if (g.Dq() != null) {
            g.Dr();
            if (g.Dq().Db() != null) {
                this.gJU = true;
                g.Dr();
                l((String) g.Dq().Db().get(278530, null), true);
            }
        }
    }

    public final synchronized void a(String str, Map<String, String> map, boolean z) {
        if (!bi.oN(str)) {
            x.i("MicroMsg.DynamicConfig", "update dynacfg. increment:%b, md5:%s", Boolean.valueOf(z), com.tencent.mm.a.g.bV(str));
            if (z) {
                g.Dr();
                g.Dq().Db().set(278530, str);
            } else {
                g.Dr();
                g.Dq().Db().set(278529, str);
                g.Dr();
                g.Dq().Db().set(278530, "");
            }
            if (map != null) {
                a(map, z);
            } else {
                l(str, z);
            }
            a.xmy.m(new cl());
        }
    }

    public final void l(String str, boolean z) {
        a(bj.y(str, "sysmsg"), z);
    }

    private void a(Map<String, String> map, boolean z) {
        if (map != null) {
            if (!z) {
                this.gJT.clear();
            }
            int i = 0;
            while (i < 10000) {
                String str;
                if (z) {
                    str = ".sysmsg.dynacfg_split.Item" + (i == 0 ? "" : Integer.valueOf(i));
                } else {
                    str = ".sysmsg.dynacfg.Item" + (i == 0 ? "" : Integer.valueOf(i));
                }
                String str2 = str + ".$key";
                str = (String) map.get(str);
                str2 = (String) map.get(str2);
                if (str2 == null || bi.oN(str2.trim())) {
                    break;
                }
                this.gJT.put(str2.trim(), str != null ? str : "");
                x.d("MicroMsg.DynamicConfig", "put %s %s", str2.trim(), str);
                i++;
            }
            x.d("MicroMsg.DynamicConfig", "All dynamicConfig:%s", this.gJT.toString());
        }
    }
}

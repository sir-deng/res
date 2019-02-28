package com.tencent.mm.y.a;

import java.util.HashMap;

public final class b {
    public String hjL;
    public String hjM;
    public String hjN;
    public String hjO;
    public HashMap<String, e> hjP = new HashMap();

    public final e ih(String str) {
        if (this.hjP == null || !this.hjP.containsKey(str)) {
            return null;
        }
        return (e) this.hjP.get(str);
    }
}

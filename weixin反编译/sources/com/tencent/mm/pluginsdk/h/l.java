package com.tencent.mm.pluginsdk.h;

import com.tencent.mm.sdk.a.b;
import java.util.concurrent.ConcurrentHashMap;

public final class l {
    public static l vmz = new l("default");
    private boolean mGx = false;
    private ConcurrentHashMap<String, Integer> vmw = new ConcurrentHashMap();
    private ConcurrentHashMap<String, Long> vmx = new ConcurrentHashMap();
    private String vmy = "";

    public l(String str) {
        if (b.cfx()) {
            this.mGx = true;
        }
        this.vmy = str;
    }

    public final void St(String str) {
        if (this.mGx) {
            int intValue;
            long longValue;
            if (this.vmw.containsKey(str)) {
                intValue = ((Integer) this.vmw.get(str)).intValue();
            } else {
                intValue = 0;
            }
            int i = intValue + 1;
            this.vmw.put(str, Integer.valueOf(i));
            if (this.vmx.containsKey(str)) {
                longValue = ((Long) this.vmx.get(str)).longValue();
            } else {
                longValue = 0;
            }
            if (System.currentTimeMillis() - longValue > 1000) {
                new StringBuilder().append(this.vmy).append("user get fps ").append(i).append(" fpswraper: ").append(str);
                this.vmw.put(str, Integer.valueOf(0));
                this.vmx.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }
}

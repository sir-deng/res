package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.a.g;
import com.tencent.mm.f.b.dy;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class k extends i<g> {
    public static final String[] gLy = new String[]{i.a(g.gKN, "VoiceRemindInfo")};
    private static long hXG = 0;
    e gLA;
    Map<String, c> scL = new HashMap();

    public k(e eVar) {
        super(eVar, g.gKN, "VoiceRemindInfo", dy.fNF);
        this.gLA = eVar;
    }

    public static String nw(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(currentTimeMillis));
        if (str != null && str.length() > 1) {
            format = format + g.s(str.getBytes()).substring(0, 7);
        }
        StringBuilder append = new StringBuilder().append(format + (currentTimeMillis % 10000));
        currentTimeMillis = hXG;
        hXG = 1 + currentTimeMillis;
        return append.append(currentTimeMillis).toString();
    }

    public final boolean iI(String str) {
        Assert.assertTrue(str.length() > 0);
        if (this.gLA.delete("VoiceRemindInfo", "filename= ?", new String[]{str}) <= 0) {
            x.w("MicroMsg.VoiceRemindStorage", "delete failed, no such file:" + str);
        }
        return true;
    }

    public final void nY(String str) {
        c cVar = (c) this.scL.get(str);
        if (cVar != null) {
            cVar.UB();
            this.scL.remove(str);
        }
    }
}

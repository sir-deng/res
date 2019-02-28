package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.w;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public static d rjE = new d();
    public s gAD;
    public int gNG = 0;
    public HashMap<String, Integer> rjF;
    public HashMap<String, String> rjG;
    public int rjH = 200;
    public int rjI = 86400;

    private d() {
        c fp = com.tencent.mm.y.c.c.IL().fp("100077");
        if (fp.isValid()) {
            Map civ = fp.civ();
            this.rjH = bi.getInt((String) civ.get("maxCacheFeedCount"), 200);
            this.rjI = bi.getInt((String) civ.get("maxCacheSeconds"), 86400);
            this.gNG = bi.getInt((String) civ.get("needUploadData"), 0);
        }
        x.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", Integer.valueOf(this.rjH), Integer.valueOf(this.rjI), Integer.valueOf(this.gNG));
        this.gAD = new s(w.hbv + "snsreport.cfg");
        Object obj = this.gAD.get(3, new HashMap());
        Object obj2 = this.gAD.get(4, new HashMap());
        if ((obj instanceof HashMap) && (obj2 instanceof HashMap)) {
            this.rjF = (HashMap) obj;
            this.rjG = (HashMap) obj2;
            return;
        }
        FileOp.deleteFile(w.hbv + "snsreport.cfg");
        this.rjF = new HashMap();
        this.rjG = new HashMap();
    }

    public final void Lz(String str) {
        if (this.gNG != 0) {
            this.rjF.put(str, Integer.valueOf(this.rjF.containsKey(str) ? ((Integer) this.rjF.get(str)).intValue() + 1 : 1));
        }
    }

    public final void en(String str, String str2) {
        if (this.gNG != 0 && !bi.oN(str) && !bi.oN(str2)) {
            this.rjG.put(str, str2);
        }
    }
}

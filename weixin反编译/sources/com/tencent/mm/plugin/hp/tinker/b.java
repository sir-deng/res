package com.tencent.mm.plugin.hp.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mm.app.n;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.tinker.lib.b.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public final class b extends a {
    private final int nGN;

    public b(Context context) {
        super(context);
        this.nGN = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "application maxMemory:" + this.nGN, new Object[0]);
    }

    public final int db(String str, String str2) {
        boolean z = false;
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "receive a patch file: %s, file size:%d", str, Long.valueOf(SharePatchFileUtil.af(new File(str))));
        int db = super.db(str, str2);
        if (db == 0) {
            db = this.nGN < 45 ? -23 : !c.dy(83886080) ? -21 : 0;
        }
        if (db == 0) {
            com.tencent.tinker.lib.e.a.ir(this.context);
            if (db == 0) {
                Properties al = ShareTinkerInternals.al(r3);
                if (al == null) {
                    db = -24;
                } else {
                    String property = al.getProperty("patch.basepack.client.ver");
                    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "get BASE_CLIENT_VERSION:" + property, new Object[0]);
                    if (property == null || !property.equalsIgnoreCase(BaseBuildInfo.CLIENT_VERSION)) {
                        db = -25;
                    }
                }
            }
        }
        if (db == 0 && ShareTinkerInternals.cHZ() && n.a(new Throwable().getStackTrace())) {
            db = -26;
        }
        if (db == 0) {
            z = true;
        }
        com.tencent.mm.plugin.hp.b.b.fQ(z);
        return db;
    }
}

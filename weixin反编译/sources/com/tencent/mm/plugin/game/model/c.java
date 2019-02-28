package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c {
    LinkedList<String> ngw = new LinkedList();
    LinkedList<f> ngx = new LinkedList();

    public final void init(Context context) {
        if (this.ngx == null) {
            this.ngx = new LinkedList();
        } else {
            this.ngx.clear();
        }
        if (this.ngw == null) {
            this.ngw = new LinkedList();
        } else {
            this.ngw.clear();
        }
        long currentTimeMillis = System.currentTimeMillis();
        cK(context);
        long currentTimeMillis2 = System.currentTimeMillis();
        aQz();
        long currentTimeMillis3 = System.currentTimeMillis();
        x.i("MicroMsg.GameAppCacheService", "Init time: %d, %d, %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis));
    }

    private void cK(Context context) {
        Cursor bZw = an.biT().bZw();
        LinkedList linkedList = new LinkedList();
        if (bZw == null) {
            x.e("MicroMsg.GameAppCacheService", "getInstalledGame faild: curosr is null");
            return;
        }
        if (bZw.moveToFirst()) {
            do {
                f fVar = new f();
                fVar.b(bZw);
                if (g.a(context, fVar) && !this.ngw.contains(fVar.field_appId)) {
                    x.i("MicroMsg.GameAppCacheService", "installed game:[%s][%s]", fVar.field_appName, fVar.field_appId);
                    this.ngx.add(fVar);
                    this.ngw.add(fVar.field_appId);
                }
            } while (bZw.moveToNext());
        }
        bZw.close();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            this.ngx.add(fVar2);
            this.ngw.add(fVar2.field_appId);
        }
    }

    private void aQz() {
        List<String> arrayList = new ArrayList();
        as.Hm();
        Cursor rawQuery = com.tencent.mm.y.c.Fl().rawQuery("select * from FileDownloadInfo where status=3", new String[0]);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                a aVar = new a();
                aVar.b(rawQuery);
                if (!bi.oN(aVar.field_appId) && aVar.field_appId.startsWith("wx") && aVar.field_status == 3 && !aVar.field_autoDownload && e.bO(aVar.field_filePath) && !arrayList.contains(aVar.field_appId)) {
                    arrayList.add(aVar.field_appId);
                }
            }
            rawQuery.close();
        }
        if (!arrayList.isEmpty()) {
            for (String str : arrayList) {
                if (!(bi.oN(str) || this.ngw.contains(str))) {
                    f aZ = g.aZ(str, false);
                    if (!(aZ == null || this.ngx.contains(aZ))) {
                        this.ngx.add(aZ);
                        this.ngw.add(str);
                    }
                }
            }
        }
    }

    public final void clearCache() {
        x.i("MicroMsg.GameAppCacheService", "clear cached apppinfos");
        if (this.ngx != null) {
            this.ngx.clear();
        }
        if (this.ngw != null) {
            this.ngw.clear();
        }
    }
}

package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ab.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class h implements e, t, b {
    Map<String, Integer> iYc;
    private List<String> qqZ;
    private List<String> vkK;
    private al vkL;
    private List<String> vkU;
    private List<String> vkV;
    private volatile boolean vkW;

    public h() {
        this.vkK = null;
        this.qqZ = null;
        this.iYc = null;
        this.vkW = false;
        this.vkL = new al(Looper.getMainLooper(), new a() {
            public final boolean uG() {
                h.this.iYc.clear();
                return false;
            }
        }, false);
        this.vkK = new ArrayList();
        this.qqZ = new ArrayList();
        this.iYc = new HashMap();
        this.vkU = new Vector();
        this.vkV = new ArrayList();
        this.vkL.K(600000, 600000);
        g.Dp().gRu.a(231, (e) this);
        com.tencent.mm.plugin.y.a.aRP().a(7, (t) this);
    }

    public final String l(Context context, String str) {
        return g.l(context, str);
    }

    public final void au(LinkedList<String> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.AppInfoService", "batch push appinfo err: null or nil applist");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            Sh((String) it.next());
        }
        bZu();
    }

    private synchronized void Sh(String str) {
        if (bi.oN(str) || this.vkU.contains(str)) {
            x.i("MicroMsg.AppInfoService", "should not add this appid:[%s], it is already runing", str);
        } else if (Sj(str)) {
            x.i("MicroMsg.AppInfoService", "add appid:[%s]", str);
            this.vkU.add(str);
        } else {
            x.e("MicroMsg.AppInfoService", "this app has reach the max retry count, appid is %s", str);
        }
    }

    public final void Si(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppInfoService", "push fail, appId is null");
            return;
        }
        x.i("MicroMsg.AppInfoService", "push appid : " + str);
        Sh(str);
        bZu();
    }

    private void bZu() {
        int i = 20;
        if (this.vkW) {
            x.d("MicroMsg.AppInfoService", " batch get appinfo doing now");
        } else if (this.vkU == null || this.vkU.isEmpty()) {
            x.d("MicroMsg.AppInfoService", "batchwaitinglist is empty, no need to doscene");
        } else {
            int size = this.vkU.size();
            if (size <= 20) {
                i = size;
            }
            synchronized (this) {
                this.vkV.addAll(this.vkU.subList(0, i));
            }
            if (this.vkV != null && !this.vkV.isEmpty()) {
                this.vkW = true;
                g.Dp().gRu.a(new x(7, new ad(this.vkV)), 0);
            }
        }
    }

    private boolean Sj(String str) {
        if (str == null) {
            x.e("MicroMsg.AppInfoService", "increaseCounter fail, appId is null");
            return false;
        }
        Integer valueOf = Integer.valueOf(bi.a((Integer) this.iYc.get(str), 0));
        if (valueOf.intValue() >= 5) {
            x.e("MicroMsg.AppInfoService", "increaseCounter fail, has reached the max try count");
            return false;
        }
        this.iYc.put(str, Integer.valueOf(valueOf.intValue() + 1));
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int type = kVar.getType();
        switch (type) {
            case 231:
                String str2 = ((ac) kVar).appId;
                if (this.vkK.contains(str2)) {
                    this.vkK.remove(str2);
                }
                while (this.qqZ.size() > 0) {
                    boolean z;
                    str2 = (String) this.qqZ.remove(0);
                    if (str2 == null || str2.length() == 0) {
                        x.e("MicroMsg.AppInfoService", "startDownload fail, appId is null");
                        z = false;
                        continue;
                    } else if (Sj(str2)) {
                        g.Dp().gRu.a(new ac(str2), 0);
                        z = true;
                        continue;
                    } else {
                        x.e("MicroMsg.AppInfoService", "increaseCounter fail");
                        z = false;
                        continue;
                    }
                    if (z) {
                        this.vkK.add(str2);
                        return;
                    }
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.voicejoint.a.CTRL_INDEX /*451*/:
                synchronized (this) {
                    if (!(this.vkV == null || this.vkV.isEmpty())) {
                        this.vkU.removeAll(this.vkV);
                        this.vkV.clear();
                    }
                }
                this.vkW = false;
                bZu();
                return;
            default:
                x.e("MicroMsg.AppInfoService", "error type: " + type);
                return;
        }
    }

    public final void a(int i, int i2, String str, w wVar) {
        if (wVar.getType() != 7) {
            x.d("MicroMsg.AppInfoService", "not the getappinfolist scene, ignore");
            return;
        }
        synchronized (this) {
            if (!(this.vkV == null || this.vkV.isEmpty())) {
                this.vkU.removeAll(this.vkV);
                this.vkV.clear();
            }
        }
        this.vkW = false;
        bZu();
    }
}

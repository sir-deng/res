package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.f.b.cg;
import com.tencent.mm.j.g;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import java.util.Map;

public final class a {
    public String desc;
    public String frM;
    public int fzk;
    public long hSg;
    public int size;
    public String url;
    public long vkJ;

    public static a bZm() {
        as.Hm();
        String str = (String) c.Db().get(352273, (Object) "");
        if (bi.oN(str)) {
            return null;
        }
        a aVar = new a(str);
        if (aVar.isValid() && !aVar.bPW()) {
            return aVar;
        }
        bZn();
        return null;
    }

    public a(String str) {
        Map y = bj.y(str, "msg");
        this.desc = (String) y.get(".msg.appmsg.des");
        this.fzk = bi.getInt((String) y.get(".msg.alphainfo.clientVersion"), 0);
        this.url = (String) y.get(".msg.alphainfo.url");
        this.size = bi.getInt((String) y.get(".msg.alphainfo.size"), 0);
        this.frM = (String) y.get(".msg.alphainfo.md5");
        this.vkJ = bi.getLong((String) y.get(".msg.alphainfo.maxAge"), 0);
        this.hSg = bi.getLong((String) y.get(".msg.alphainfo.expireTime"), 0);
        x.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", str, Integer.valueOf(this.fzk), this.url, Integer.valueOf(this.size), this.frM, this.desc, Long.valueOf(this.vkJ), Long.valueOf(this.hSg));
    }

    private boolean isValid() {
        boolean z;
        if (this.fzk <= d.vHl || bi.oN(this.url) || bi.oN(this.frM) || bi.oN(this.desc)) {
            z = false;
        } else {
            z = true;
        }
        x.i("MicroMsg.AlphaUpdateInfo", "isValid %b", Boolean.valueOf(z));
        return z;
    }

    private boolean bPW() {
        boolean z;
        as.Hm();
        if (System.currentTimeMillis() - ((Long) c.Db().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue() > this.vkJ || System.currentTimeMillis() > this.hSg) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", Boolean.valueOf(z));
        return z;
    }

    public static void bZn() {
        as.Hm();
        c.Db().set(352273, null);
        as.Hm();
        c.Db().set(352274, null);
    }

    public final void bZo() {
        cg auVar = new au();
        auVar.aq(bb.n("weixin", bi.Wx()));
        auVar.setType(1);
        auVar.setContent(this.desc);
        x.d("MicroMsg.AlphaUpdateInfo", auVar.field_content);
        auVar.eS(0);
        auVar.dU("weixin");
        auVar.eR(3);
        bb.i(auVar);
        x.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
        bZn();
    }

    public final void bZp() {
        x.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
        if (isValid() && !bPW()) {
            int i;
            if (bi.Wo(g.Af().getValue("SilentDownloadApkAtWiFi")) != 0) {
                i = 0;
            } else {
                as.Hm();
                i = (!ao.isWifi(ad.getContext()) || ((((Integer) c.Db().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0 ? 1 : 0) == 0) ? 0 : 1;
                if ((f.fek & 1) != 0) {
                    x.d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
                    i = 0;
                } else {
                    x.d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
                }
            }
            if (i == 0) {
                bZo();
                return;
            }
            x.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", this.frM, Integer.valueOf(this.size), this.desc, this.url);
            q.x.bYQ().c(this.frM, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
        }
    }
}

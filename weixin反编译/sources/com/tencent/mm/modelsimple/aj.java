package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bnf;
import com.tencent.mm.protocal.c.bng;
import com.tencent.mm.protocal.c.bnh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.HashSet;

public final class aj extends k implements com.tencent.mm.network.k {
    private static HashSet<Long> hPW = new HashSet();
    private final b gLB;
    private e gLE;
    private final String toUserName;

    public static void S(String str, int i) {
        if (bi.oN(str) || !g.Do().CF()) {
            return;
        }
        if (!s.hq(str) || s.gM(str)) {
            g.Dp().gRu.a(new aj(str, i), 0);
        }
    }

    public static void t(au auVar) {
        g.Dr();
        if (!((Boolean) g.Dq().Db().get(a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.valueOf(true))).booleanValue()) {
            x.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
        } else if (hPW.contains(Long.valueOf(auVar.field_msgId))) {
            x.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgId));
        } else {
            hPW.add(Long.valueOf(auVar.field_msgId));
            if (g.Do().CF()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<![CDATA[<downloadList>");
                stringBuilder.append("<downloadItem>");
                stringBuilder.append("<username>");
                stringBuilder.append(auVar.field_talker);
                stringBuilder.append("</username>");
                stringBuilder.append("<msgsvrid>");
                stringBuilder.append(auVar.field_msgSvrId);
                stringBuilder.append("</msgsvrid>");
                stringBuilder.append("</downloadItem>");
                stringBuilder.append("</downloadList>]]>");
                String stringBuilder2 = stringBuilder.toString();
                x.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd:msgID:%d,  %s", Long.valueOf(auVar.field_msgId), stringBuilder);
                g.Dp().gRu.a(new aj(q.FY(), 11, "DownloadFile", stringBuilder2), 0);
            }
        }
    }

    public static void a(String str, int i, String str2, String str3) {
        if (!bi.oN(str) && !s.hq(str) && g.Do().CF()) {
            g.Dp().gRu.a(new aj(str, i, str2, str3), 0);
        }
    }

    public aj(String str, int i) {
        this.toUserName = str;
        b.a aVar = new b.a();
        aVar.hnT = new bng();
        aVar.hnU = new bnh();
        aVar.uri = "/cgi-bin/micromsg-bin/statusnotify";
        this.gLB = aVar.Kf();
        bng bng = (bng) this.gLB.hnQ.hnY;
        bng.npW = q.FY();
        bng.wXj = i;
        bng.npV = str;
        bng.vOL = System.currentTimeMillis();
        x.d("MicroMsg.NetSceneStatusNotify", "toUserName = " + str);
    }

    private aj(String str, int i, String str2, String str3) {
        this.toUserName = str;
        b.a aVar = new b.a();
        aVar.hnT = new bng();
        aVar.hnU = new bnh();
        aVar.uri = "/cgi-bin/micromsg-bin/statusnotify";
        this.gLB = aVar.Kf();
        bng bng = (bng) this.gLB.hnQ.hnY;
        bng.npW = q.FY();
        bng.wXj = i;
        bng.npV = str;
        bng.vOL = System.currentTimeMillis();
        bng.wXm = new bnf();
        bng.wXm.nkW = str2;
        bng.wXm.wXi = str3;
    }

    public final int getType() {
        return 251;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            x.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.toUserName);
        }
        this.gLE.a(i2, i3, str, this);
    }
}

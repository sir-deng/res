package com.tencent.mm.plugin.hp.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.protocal.c.bpd;
import com.tencent.mm.protocal.c.bph;
import com.tencent.mm.protocal.c.nv;
import com.tencent.mm.protocal.c.nw;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    String nGD;
    String nGE;
    private LinkedList<bpd> nGF;
    private boolean nGG;
    com.tencent.mm.plugin.hp.d.b nGH;

    public a() {
        this("", "", null, false);
    }

    public a(String str, String str2, List<bpd> list) {
        this(str, str2, list, true);
    }

    private a(String str, String str2, List<bpd> list, boolean z) {
        String str3;
        Collection list2;
        int i = 3;
        this.nGF = new LinkedList();
        this.nGG = true;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new nv();
        aVar.hnU = new nw();
        aVar.uri = "/cgi-bin/micromsg-bin/checktinkerupdate";
        aVar.hnS = 922;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        if (z) {
            str3 = str2;
        } else {
            int i2;
            str = "tinker_id_" + BaseBuildInfo.baseRevision();
            str3 = BaseBuildInfo.PATCH_REV == null ? "" : "tinker_id_" + BaseBuildInfo.PATCH_REV;
            list2 = new LinkedList();
            long j = 0;
            try {
                j = ((long) com.tencent.mm.kernel.a.CH()) & 4294967295L;
                x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "uin is %s", bi.Wz(String.valueOf(j)));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", e, "tinker patch manager get uin failed.", new Object[0]);
            }
            list2.add(da("code-version", com.tencent.mm.sdk.platformtools.e.CLIENT_VERSION));
            list2.add(da("code-reversion", com.tencent.mm.sdk.platformtools.e.REV));
            String str4 = TencentLocation.NETWORK_PROVIDER;
            if (ao.isWifi(ad.getContext())) {
                i2 = 3;
            } else {
                i2 = 2;
            }
            list2.add(da(str4, String.valueOf(i2)));
            list2.add(da("sdk", String.valueOf(VERSION.SDK_INT)));
            list2.add(da("os-name", d.vHh));
            list2.add(da("device-brand", d.vHe));
            list2.add(da("device-name", d.vHj));
            list2.add(da(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j)));
            String str5 = TencentLocation.NETWORK_PROVIDER;
            if (!ao.isWifi(ad.getContext())) {
                i = 2;
            }
            list2.add(da(str5, String.valueOf(i)));
        }
        this.nGD = str;
        this.nGE = str3;
        this.nGF.addAll(list2);
        this.nGG = z;
    }

    public final int getType() {
        return 922;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "doScene");
        this.gLE = eVar2;
        final nv nvVar = (nv) this.gLB.hnQ.hnY;
        nvVar.wdw = this.nGD;
        nvVar.wdx = this.nGE;
        nvVar.wdy = this.nGF;
        c.a(new com.tencent.mm.plugin.hp.d.c.a() {
            public final void a(boolean z, com.tencent.mm.plugin.hp.d.b bVar) {
                if (!z || bVar == null) {
                    Context context = ad.getContext();
                    context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_base_id", a.this.nGD).apply();
                    g.ai(ad.getContext(), "");
                    return;
                }
                a.this.nGH = bVar;
                nvVar.wdx = a.this.nGH.nGX;
                x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "Use last response patchId %s instead of current patchId %s", a.this.nGH.nGX, a.this.nGE);
                com.tencent.mm.plugin.report.service.g.pWK.a(614, 71, 1, false);
            }
        });
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            nw nwVar = (nw) ((b) qVar).hnR.hnY;
            bph bph = nwVar.wdz;
            if (bph == null) {
                if (str.equalsIgnoreCase("no baseid matched")) {
                    com.tencent.mm.plugin.hp.b.a.cL(1, 0);
                } else if (str.equalsIgnoreCase("no update for this patch")) {
                    com.tencent.mm.plugin.hp.b.a.cL(2, 0);
                } else if (str.equalsIgnoreCase("no sutable patch available")) {
                    com.tencent.mm.plugin.hp.b.a.cL(3, 0);
                } else {
                    com.tencent.mm.plugin.hp.b.a.cL(5, 0);
                }
                if (this.nGH != null) {
                    String str2 = BaseBuildInfo.PATCH_REV == null ? "" : "tinker_id_" + BaseBuildInfo.PATCH_REV;
                    if (!(bi.oN(this.nGH.nGX) || this.nGH.nGX.equalsIgnoreCase(str2))) {
                        int i4 = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4).getInt("tinker_node_retry_time", 0);
                        if (i4 >= 4) {
                            g.ai(ad.getContext(), "");
                            g.E(ad.getContext(), 0);
                            x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "retry time over %d time, then clear node and count", Integer.valueOf(i4));
                            com.tencent.mm.plugin.report.service.g.pWK.a(614, 74, 1, false);
                        } else {
                            new com.tencent.mm.plugin.hp.b.e(this.nGH).fR(true);
                            com.tencent.mm.plugin.report.service.g.pWK.a(614, 70, 1, false);
                            g.E(ad.getContext(), i4 + 1);
                            x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "add retry time %d", Integer.valueOf(i4));
                        }
                    }
                }
            } else if (this.nGG) {
                try {
                    g.ai(ad.getContext(), new String(Base64.encode(nwVar.toByteArray(), 0)));
                    g.E(ad.getContext(), 0);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", e, "save node failed.", new Object[0]);
                    com.tencent.mm.plugin.report.service.g.pWK.a(614, 72, 1, false);
                }
                x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
                com.tencent.mm.plugin.hp.d.b bVar = new com.tencent.mm.plugin.hp.d.b(bph);
                x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
                new com.tencent.mm.plugin.hp.b.e(bVar).fR(false);
                x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
                com.tencent.mm.plugin.hp.b.a.cL(4, 0);
            } else {
                x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui. ");
            }
        } else {
            x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
            com.tencent.mm.plugin.hp.b.a.cL(5, i2);
        }
        this.gLE.a(i2, i3, str, this);
    }

    private static bpd da(String str, String str2) {
        bpd bpd = new bpd();
        bpd.aAM = str;
        bpd.value = str2;
        return bpd;
    }
}

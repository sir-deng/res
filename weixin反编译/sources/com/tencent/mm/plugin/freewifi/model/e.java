package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.ad.k;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.d.d;
import com.tencent.mm.plugin.freewifi.e.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.protocal.c.nj;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e {
    public String mJR = "";

    /* renamed from: com.tencent.mm.plugin.freewifi.model.e$1 */
    class AnonymousClass1 implements com.tencent.mm.ad.e {
        final /* synthetic */ bx kBh;

        AnonymousClass1(bx bxVar) {
            this.kBh = bxVar;
        }

        public final void a(int i, int i2, String str, k kVar) {
            x.i("MicroMsg.FreeWifi.FreeWifiMessageService", "desc=net request [NetSceneCheckIfCallUp] returns. errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (m.cD(i, i2)) {
                long j = ((d) kVar).aMK().wcY;
                if (j == 0) {
                    x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "It cannot get time from server.");
                    return;
                }
                e eVar = e.this;
                bx bxVar = this.kBh;
                nj aMK = ((d) kVar).aMK();
                if (bxVar == null || bxVar.vNO == null) {
                    x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
                    return;
                }
                String a = n.a(bxVar.vNO);
                x.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", Long.valueOf(bxVar.vNT), a);
                if (m.Bf(a)) {
                    x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
                    return;
                }
                a Bm = a.Bm(a);
                if (Bm == null) {
                    x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
                    return;
                }
                Matcher matcher;
                com.tencent.mm.plugin.freewifi.f.a aVar = new com.tencent.mm.plugin.freewifi.f.a();
                aVar.mLw = Bm.mJB;
                aVar.mLy = Bm.mJC;
                aVar.mLx = Bm.bssid;
                aVar.mLC = Bm.ssid;
                aVar.mLG = Bm.mJE;
                aVar.mLA = Bm.mJA;
                aVar.mLz = Bm.mJD;
                String Bk = m.Bk("MicroMsg.FreeWifi.FreeWifiMessageService");
                aVar.fqv = Bk;
                aVar.mLB = Bk.equals(Bm.mJA) ? 0 : 1;
                String Bi = m.Bi("MicroMsg.FreeWifi.FreeWifiMessageService");
                aVar.mLD = Bi;
                aVar.mLE = Bi.equals(Bm.ssid) ? 0 : 1;
                aVar.mLF = j;
                aVar.mLG = Bm.mJE;
                int i3 = j > Bm.mJE ? 1 : 0;
                aVar.mLH = i3 == 1 ? 1 : 0;
                aVar.mLL = aMK.wcP;
                aVar.mLM = Bi;
                boolean equals = Bi.equals(aMK.wcP);
                aVar.mLN = equals ? 1 : 0;
                aVar.mLI = 1;
                aVar.mLJ = aMK.wcX;
                CharSequence charSequence = Bm.mJD;
                if (!m.Bf(charSequence)) {
                    matcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(charSequence);
                    if (matcher.find()) {
                        aVar.mLK = matcher.group(2);
                    }
                }
                e.a(aVar);
                if (!equals) {
                    x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "ssid has changed ! svr back ssid is not equal client ssid. ");
                    return;
                } else if (i3 != 0) {
                    x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "Msg time expired. return.");
                    return;
                } else if (aMK.wcX == 0 && !m.Bf(charSequence)) {
                    matcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(charSequence);
                    if (matcher.find()) {
                        Object group = matcher.group(1);
                        try {
                            a = URLDecoder.decode(group, "utf8");
                            Bk = matcher.group(2);
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_ap_key", a);
                            intent.putExtra("free_wifi_source", 5);
                            intent.putExtra("free_wifi_threeone_startup_type", 3);
                            intent.putExtra("free_wifi_schema_ticket", Bk);
                            intent.putExtra("free_wifi_sessionkey", Bk);
                            if (!eVar.mJR.equals(Bk)) {
                                eVar.mJR = Bk;
                                b.aMR();
                                b.I(intent);
                                return;
                            }
                            return;
                        } catch (UnsupportedEncodingException e) {
                            x.i("MicroMsg.FreeWifi.FreeWifiMessageService", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=Exception happens when decoding apkey. schemaUrl=%s, apkey=%s, e.getMessage()=%s", "", Integer.valueOf(0), charSequence, group, e.getMessage());
                            return;
                        }
                    }
                    return;
                } else {
                    return;
                }
            }
            com.tencent.mm.plugin.freewifi.f.a aVar2 = new com.tencent.mm.plugin.freewifi.f.a();
            aVar2.mLv = i2;
            aVar2.mLu = i;
            e.a(aVar2);
        }
    }

    static void a(com.tencent.mm.plugin.freewifi.f.a aVar) {
        g.pWK.h(13493, Integer.valueOf(aVar.mLu), Integer.valueOf(aVar.mLv), m.Bh(aVar.mLw), m.Bh(aVar.mLx), Long.valueOf(aVar.mLy), m.Bh(aVar.mLz), m.Bh(aVar.mLA), m.Bh(aVar.fqv), Integer.valueOf(aVar.mLB), m.Bh(aVar.mLC), m.Bh(aVar.mLD), Integer.valueOf(aVar.mLE), Long.valueOf(aVar.mLF), Long.valueOf(aVar.mLG), Integer.valueOf(aVar.mLH), Integer.valueOf(aVar.mLI), Integer.valueOf(aVar.mLJ), m.Bh(aVar.mLK), m.Bh(aVar.mLL), m.Bh(aVar.mLM), Integer.valueOf(aVar.mLN));
    }
}

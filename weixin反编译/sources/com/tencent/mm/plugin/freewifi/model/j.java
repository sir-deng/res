package com.tencent.mm.plugin.freewifi.model;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.RemoteException;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.ad;
import com.tencent.mm.f.a.ae;
import com.tencent.mm.f.a.bh;
import com.tencent.mm.f.a.eu;
import com.tencent.mm.f.a.ex;
import com.tencent.mm.f.a.gh;
import com.tencent.mm.f.a.gi;
import com.tencent.mm.f.a.oi;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.freewifi.d.g;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.a;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.protocal.c.cq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.bt;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class j implements ap {
    private static HashMap<Integer, d> gyG;
    private c bannerOnInitListener = new c<ad>() {
        {
            this.xmG = ad.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            b aeVar = new ae();
            aeVar.foO.foQ = new a(com.tencent.mm.sdk.platformtools.ad.getContext());
            com.tencent.mm.sdk.b.a.xmy.m(aeVar);
            return false;
        }
    };
    private bt.a lTH = new bt.a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            e aMB = j.aMB();
            bx bxVar = aVar.hoa;
            if (1 != a.mIc.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
                a.mIc.bo("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
            }
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
            com.tencent.mm.plugin.freewifi.c.a Bm = com.tencent.mm.plugin.freewifi.c.a.Bm(a);
            if (Bm == null) {
                x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
                return;
            }
            new com.tencent.mm.plugin.freewifi.d.d(m.Bi("MicroMsg.FreeWifi.FreeWifiMessageService"), m.Bj("MicroMsg.FreeWifi.FreeWifiMessageService"), m.Bk("MicroMsg.FreeWifi.FreeWifiMessageService"), Bm.mJD, Bm.mJA, Bm.mJE, Bm.ssid, Bm.bssid).b(new com.tencent.mm.plugin.freewifi.model.e.AnonymousClass1(bxVar));
        }
    };
    private volatile d mKk;
    private volatile com.tencent.mm.plugin.freewifi.g.d mKl;
    private volatile com.tencent.mm.plugin.freewifi.g.b mKm;
    private volatile f mKn;
    private volatile c mKo;
    private volatile c mKp;
    private volatile a mKq;
    private volatile e mKr;
    private com.tencent.mm.network.n mKs = new com.tencent.mm.network.n.a() {
        private byte[] gzU = new byte[0];

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void eq(int r9) {
            /*
            r8 = this;
            r1 = r8.gzU;
            monitor-enter(r1);
            r0 = com.tencent.mm.y.as.Hp();	 Catch:{ all -> 0x00ea }
            if (r0 != 0) goto L_0x0014;
        L_0x0009:
            r0 = "MicroMsg.FreeWifi.SubCoreFreeWifi";
            r2 = "account not ready";
            com.tencent.mm.sdk.platformtools.x.e(r0, r2);	 Catch:{ all -> 0x00ea }
            monitor-exit(r1);	 Catch:{ all -> 0x00ea }
        L_0x0013:
            return;
        L_0x0014:
            r0 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ea }
            r3 = "onNetworkChange state=";
            r2.<init>(r3);	 Catch:{ all -> 0x00ea }
            r2 = r2.append(r9);	 Catch:{ all -> 0x00ea }
            r3 = ".(-1=NETWORK_UNKNOWN; 0=NETWORK_UNAVAILABLE; 1=NETWORK_CONNECTED; 2=GATEWAY_FAILED; 3=SERVER_FAILED; 4=CONNECTTING; 5=CONNECTED; 6=SERVER_DOWN)";
            r2 = r2.append(r3);	 Catch:{ all -> 0x00ea }
            r2 = r2.toString();	 Catch:{ all -> 0x00ea }
            com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x00ea }
            r0 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00ea }
            r2 = "connectivity";
            r0 = r0.getSystemService(r2);	 Catch:{ all -> 0x00ea }
            r0 = (android.net.ConnectivityManager) r0;	 Catch:{ all -> 0x00ea }
            r2 = 1;
            r2 = r0.getNetworkInfo(r2);	 Catch:{ all -> 0x00ea }
            if (r2 == 0) goto L_0x0088;
        L_0x0045:
            r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ea }
            r5 = "wifiNetwork:";
            r4.<init>(r5);	 Catch:{ all -> 0x00ea }
            r4 = r4.append(r2);	 Catch:{ all -> 0x00ea }
            r4 = r4.toString();	 Catch:{ all -> 0x00ea }
            com.tencent.mm.sdk.platformtools.x.i(r3, r4);	 Catch:{ all -> 0x00ea }
            r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r4 = " wifiNetwork.isAvailable()=%b,wifiNetwork.isConnected()=%b,wifiNetwork.isConnectedOrConnecting()=%b";
            r5 = 3;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00ea }
            r6 = 0;
            r7 = r2.isAvailable();	 Catch:{ all -> 0x00ea }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
            r5[r6] = r7;	 Catch:{ all -> 0x00ea }
            r6 = 1;
            r7 = r2.isConnected();	 Catch:{ all -> 0x00ea }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
            r5[r6] = r7;	 Catch:{ all -> 0x00ea }
            r6 = 2;
            r7 = r2.isConnectedOrConnecting();	 Catch:{ all -> 0x00ea }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
            r5[r6] = r7;	 Catch:{ all -> 0x00ea }
            com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ all -> 0x00ea }
        L_0x0088:
            r3 = 0;
            r0 = r0.getNetworkInfo(r3);	 Catch:{ all -> 0x00ea }
            if (r0 == 0) goto L_0x00cb;
        L_0x008f:
            r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r4 = "mobileNetworkInfo";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00ea }
            r6 = 0;
            r5[r6] = r0;	 Catch:{ all -> 0x00ea }
            com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ all -> 0x00ea }
            r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r4 = " mobileNetworkInfo.isAvailable()=%b,mobileNetworkInfo.isConnected()=%b,mobileNetworkInfo.isConnectedOrConnecting()=%b";
            r5 = 3;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00ea }
            r6 = 0;
            r7 = r0.isAvailable();	 Catch:{ all -> 0x00ea }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
            r5[r6] = r7;	 Catch:{ all -> 0x00ea }
            r6 = 1;
            r7 = r0.isConnected();	 Catch:{ all -> 0x00ea }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
            r5[r6] = r7;	 Catch:{ all -> 0x00ea }
            r6 = 2;
            r0 = r0.isConnectedOrConnecting();	 Catch:{ all -> 0x00ea }
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x00ea }
            r5[r6] = r0;	 Catch:{ all -> 0x00ea }
            com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ all -> 0x00ea }
        L_0x00cb:
            r0 = 6;
            if (r0 == r9) goto L_0x00da;
        L_0x00ce:
            r0 = 4;
            if (r0 == r9) goto L_0x00da;
        L_0x00d1:
            if (r9 == 0) goto L_0x00da;
        L_0x00d3:
            r0 = -1;
            if (r0 == r9) goto L_0x00da;
        L_0x00d6:
            r0 = -9;
            if (r0 != r9) goto L_0x0115;
        L_0x00da:
            r0 = r2.isConnected();	 Catch:{ all -> 0x00ea }
            if (r0 != 0) goto L_0x00ed;
        L_0x00e0:
            r0 = com.tencent.mm.plugin.freewifi.model.f.a.mJU;	 Catch:{ all -> 0x00ea }
            r0.aMo();	 Catch:{ all -> 0x00ea }
            monitor-exit(r1);	 Catch:{ all -> 0x00ea }
            goto L_0x0013;
        L_0x00ea:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00ea }
            throw r0;
        L_0x00ed:
            r0 = com.tencent.mm.plugin.freewifi.model.f.a.mJU;	 Catch:{ all -> 0x00ea }
            r2 = com.tencent.mm.plugin.freewifi.model.d.aMl();	 Catch:{ all -> 0x00ea }
            r0 = r0.a(r2);	 Catch:{ all -> 0x00ea }
            r2 = "MicroMsg.FreeWifi.SubCoreFreeWifi";
            r3 = "isWifiIndeedChanged=%b";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00ea }
            r5 = 0;
            r6 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x00ea }
            r4[r5] = r6;	 Catch:{ all -> 0x00ea }
            com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ all -> 0x00ea }
            if (r0 == 0) goto L_0x0115;
        L_0x010e:
            r0 = com.tencent.mm.plugin.freewifi.model.j.aMA();	 Catch:{ all -> 0x00ea }
            r0.aMd();	 Catch:{ all -> 0x00ea }
        L_0x0115:
            monitor-exit(r1);	 Catch:{ all -> 0x00ea }
            goto L_0x0013;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.model.j.7.eq(int):void");
        }
    };
    private c mKt = new c<bh>() {
        {
            this.xmG = bh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bh bhVar = (bh) bVar;
            x.d("MicroMsg.FreeWifi.SubCoreFreeWifi", "receive CheckWechatFreeWifiEvent");
            if (d.getNetworkType() != 0) {
                x.d("MicroMsg.FreeWifi.SubCoreFreeWifi", "not wifi");
            } else {
                j.aMu();
                bhVar.fqr.fqt = b.mIb.aLH();
                bhVar.fqr.fqs = b.mIb.aLG();
                String aMk = d.aMk();
                String aMi = d.aMi();
                if (!(bi.oN(aMk) || bi.oN(aMi))) {
                    com.tencent.mm.plugin.freewifi.g.c Bw = j.aMv().Bw(aMk);
                    if (Bw != null) {
                        bhVar.fqr.fqu = Bw.field_url;
                    }
                    bhVar.fqr.ssid = aMk;
                    bhVar.fqr.bssid = m.Bj("MicroMsg.FreeWifi.FreeWifiManager");
                    bhVar.fqr.fqv = m.Bk("MicroMsg.FreeWifi.FreeWifiManager");
                    if (Bw != null && aMk.equalsIgnoreCase(Bw.field_ssid) && aMi.equalsIgnoreCase(Bw.field_mac)) {
                        bh.a aVar = bhVar.fqr;
                        if (Bw == null) {
                            x.e("MicroMsg.FreeWifi.FreeWifiManager", "filterLang, freewifi info is null");
                            aMk = null;
                        } else {
                            aMk = w.cfV();
                            aMk = aMk.equals("zh_CN") ? Bw.field_showWordCn : (aMk.equals("zh_TW") || aMk.equals("zh_HK")) ? Bw.field_showWordTw : Bw.field_showWordEn;
                        }
                        aVar.fqw = aMk;
                        if (!(m.Bf(bhVar.fqr.fqw) || a.mIc.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1)) {
                            a.mIc.bo("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 1);
                        }
                        if (Bw.field_expiredTime - bi.Wx() < 0) {
                            j.aMA().aMd();
                        }
                    }
                }
            }
            return false;
        }
    };
    private c mKu = new c<oi>() {
        {
            this.xmG = oi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            oi oiVar = (oi) bVar;
            int networkType = d.getNetworkType();
            if (!(networkType == 0 || networkType == -1)) {
                x.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "networkType is " + networkType + ", start to scan and report near field wifi, to get a pushed message for connecting wifi.");
                final String str = oiVar.fHa.userName;
                b.mKj.a(new h.a() {
                    public final void aS(List<ScanResult> list) {
                        if (list != null && list.size() != 0) {
                            bfc bfc = new bfc();
                            bfc.wRv = new LinkedList();
                            for (ScanResult scanResult : list) {
                                if (scanResult != null) {
                                    cq cqVar = new cq();
                                    cqVar.mac = scanResult.BSSID;
                                    cqVar.vOr = scanResult.level;
                                    cqVar.ssid = scanResult.SSID;
                                    bfc.wRv.add(cqVar);
                                }
                            }
                            String aLP = m.aLP();
                            k.a aLL = k.aLL();
                            aLL.mIi = aLP;
                            aLL.mIk = k.b.ScanNearFieldWifiAndReport.mIW;
                            aLL.mIl = k.b.ScanNearFieldWifiAndReport.name;
                            aLL.fDM = 8;
                            aLL.aLN().aLM();
                            new com.tencent.mm.plugin.freewifi.d.k(str, bfc, 8, aLP).b(null);
                        }
                    }
                });
            }
            return false;
        }
    };
    private c mKv = new c<gh>() {
        {
            this.xmG = gh.class.getName().hashCode();
        }

        private static boolean a(gh ghVar) {
            if (ghVar.fxm.data == "MAIN_UI_EVENT_UPDATE_VIEW" && m.aLO()) {
                String str = "InterruptedProtocol31-" + System.currentTimeMillis();
                f.b aMp = a.mJU.aMp();
                if (!(aMp == null || aMp.mJY || System.currentTimeMillis() - aMp.mJL > 180000 || m.Bf(aMp.mJW) || m.Bf(aMp.mJV) || m.Bf(aMp.mJX))) {
                    x.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", str, Integer.valueOf(1), aMp.mJV, aMp.mJW, aMp.mJX, Long.valueOf(aMp.mJL));
                    WifiInfo aMl = d.aMl();
                    x.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. wifiinfo = %s", str, Integer.valueOf(2), aMl);
                    if (aMl != null) {
                        String Bg = m.Bg(aMl.getSSID());
                        if (m.Bg(aMp.mJV).equals(Bg)) {
                            String bssid = aMl.getBSSID();
                            String macAddress = aMl.getMacAddress();
                            if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                                macAddress = m.aLQ();
                            }
                            synchronized (a.mJU) {
                                if (aMp != a.mJU.aMp()) {
                                } else {
                                    x.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", str, Integer.valueOf(3), Bg, bssid, macAddress);
                                    new g(Bg, bssid, macAddress).b(new com.tencent.mm.plugin.freewifi.e.c.AnonymousClass1(str, aMp));
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
    };
    private c mKw = new c<ex>() {
        {
            this.xmG = ex.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            com.tencent.mm.plugin.freewifi.b.c.aLY().a((ex) bVar);
            return false;
        }
    };
    private c mKx = new c<eu>() {
        {
            this.xmG = eu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            a.mJp.a((eu) bVar);
            return false;
        }
    };
    private c mKy = new c<gi>() {
        {
            this.xmG = gi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            gi giVar = (gi) bVar;
            com.tencent.mm.plugin.freewifi.e.b.aMR();
            com.tencent.mm.plugin.freewifi.e.b.I(giVar.fxn.intent);
            return false;
        }
    };

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("FREEWIFIINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.freewifi.g.d.gLy;
            }
        });
        gyG.put(Integer.valueOf("FREEWIFICONFIG_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.freewifi.g.b.gLy;
            }
        });
        gyG.put(Integer.valueOf("FREEWIFILOG_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return f.gLy;
            }
        });
    }

    public static j aMt() {
        as.Hg();
        j jVar = (j) bq.ib("plugin.freewifi");
        if (jVar != null) {
            return jVar;
        }
        x.w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
        Object jVar2 = new j();
        as.Hg().a("plugin.freewifi", jVar2);
        return jVar2;
    }

    public static d aMu() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aMt().mKk == null) {
            aMt().mKk = new d();
        }
        return aMt().mKk;
    }

    public static com.tencent.mm.plugin.freewifi.g.d aMv() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aMt().mKl == null) {
            j aMt = aMt();
            as.Hm();
            aMt.mKl = new com.tencent.mm.plugin.freewifi.g.d(com.tencent.mm.y.c.Fc());
        }
        return aMt().mKl;
    }

    public static com.tencent.mm.plugin.freewifi.g.b aMw() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aMt().mKm == null) {
            j aMt = aMt();
            as.Hm();
            aMt.mKm = new com.tencent.mm.plugin.freewifi.g.b(com.tencent.mm.y.c.Fc());
        }
        return aMt().mKm;
    }

    public static f aMx() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aMt().mKn == null) {
            j aMt = aMt();
            as.Hm();
            aMt.mKn = new f(com.tencent.mm.y.c.Fc());
        }
        return aMt().mKn;
    }

    public static c aMy() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aMt().mKo == null) {
            aMt().mKo = new c();
        }
        return aMt().mKo;
    }

    public static c aMz() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aMt().mKp == null) {
            aMt().mKp = new c();
        }
        return aMt().mKp;
    }

    public static synchronized a aMA() {
        a aVar;
        synchronized (j.class) {
            com.tencent.mm.kernel.g.Do().CA();
            if (aMt().mKq == null) {
                aMt().mKq = new a();
            }
            aVar = aMt().mKq;
        }
        return aVar;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        as.getSysCmdMsgExtension().a("freewifi", this.lTH, true);
        as.a(this.mKs);
        com.tencent.mm.sdk.b.a.xmy.b(this.mKt);
        com.tencent.mm.sdk.b.a.xmy.b(this.mKu);
        com.tencent.mm.sdk.b.a.xmy.b(this.mKv);
        com.tencent.mm.sdk.b.a.xmy.b(this.mKw);
        com.tencent.mm.sdk.b.a.xmy.b(this.mKx);
        com.tencent.mm.sdk.b.a.xmy.b(this.mKy);
        com.tencent.mm.sdk.b.a.xmy.b(this.bannerOnInitListener);
        try {
            this.mKs.eq(-9);
        } catch (RemoteException e) {
            x.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "netChanged.onNetworkChange(NETWORK_ACCOUNT_POST_RESET) error. e.getMessage()=" + e.getMessage());
        }
        b aMf = b.mJN;
        x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) com.tencent.mm.sdk.platformtools.ad.getContext().getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", networkInfo.toString());
            IntentFilter intentFilter;
            if (networkInfo == null || !networkInfo.isConnected()) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoMobile=%s", networkInfo2.toString());
                if (networkInfo2 != null && networkInfo2.isConnected()) {
                    a aVar = new a();
                    aVar.mJL = System.currentTimeMillis();
                    aVar.type = 0;
                    aVar.ssid = "";
                    aVar.bssid = "";
                    aVar.mJM = m.Bh(networkInfo2.getExtraInfo());
                    b.a(aMf.mJI.aMe(), aVar);
                    aMf.mJI = aVar;
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                aMf.aLz();
                com.tencent.mm.sdk.platformtools.ad.getContext().registerReceiver(aMf.mJJ, intentFilter);
            }
            WifiInfo connectionInfo = ((WifiManager) com.tencent.mm.sdk.platformtools.ad.getContext().getSystemService("wifi")).getConnectionInfo();
            String Bg = m.Bg(connectionInfo.getSSID());
            String toLowerCase = m.Bh(connectionInfo.getBSSID()).toLowerCase();
            a aVar2 = new a();
            aVar2.mJL = System.currentTimeMillis();
            aVar2.type = 1;
            aVar2.ssid = Bg;
            aVar2.bssid = toLowerCase;
            aVar2.mJM = "";
            b.b(aMf.mJI.aMe(), aVar2);
            aMf.mJI = aVar2;
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            aMf.aLz();
            com.tencent.mm.sdk.platformtools.ad.getContext().registerReceiver(aMf.mJJ, intentFilter);
        } catch (Exception e2) {
            k.a aLL = k.aLL();
            aLL.fqu = "UnExpectedException";
            aLL.result = -1;
            aLL.lfa = m.e(e2);
            aLL.aLN().aLM();
            x.e("MicroMsg.FreeWifi.UnExcepctedException", m.f(e2));
        }
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        as.getSysCmdMsgExtension().b("freewifi", this.lTH, true);
        aMu();
        d.release();
        aMy().release();
        as.b(this.mKs);
        com.tencent.mm.sdk.b.a.xmy.c(this.mKt);
        com.tencent.mm.sdk.b.a.xmy.c(this.mKu);
        com.tencent.mm.sdk.b.a.xmy.c(this.mKv);
        com.tencent.mm.sdk.b.a.xmy.c(this.mKw);
        com.tencent.mm.sdk.b.a.xmy.c(this.mKx);
        com.tencent.mm.sdk.b.a.xmy.c(this.mKy);
        com.tencent.mm.sdk.b.a.xmy.c(this.bannerOnInitListener);
        b.mJN.aLz();
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public static e aMB() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aMt().mKr == null) {
            aMt().mKr = new e();
        }
        return aMt().mKr;
    }
}

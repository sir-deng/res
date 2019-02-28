package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.g.AnonymousClass2;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    SparseArray<Long> mJF = new SparseArray();
    private g mJG = new g();

    public final void a(String str, b bVar, int i, Intent intent) {
        j.aMy().aMg().post(new com.tencent.mm.plugin.freewifi.model.g.AnonymousClass1(str, intent, bVar, i));
    }

    public final void a(String str, String str2, Intent intent) {
        j.aMy().aMg().post(new AnonymousClass2(str2, str, intent, null));
    }

    public final synchronized void aMd() {
        x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "ap check for bar.");
        String aMk = d.aMk();
        x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "autuApAuth, get ssid is %s ", aMk);
        if (!bi.oN(aMk)) {
            if (j.aMv().Bv(aMk) == null) {
                int i;
                String aMi = d.aMi();
                String str = "MicroMsg.FreeWifi.FreeWifiAuthManager";
                String str2 = "freewifi info is null, now try to check is the wechat wifi fromserver, ssid is : %s, mac is : %s, nowmac hashcode : %d";
                Object[] objArr = new Object[3];
                objArr[0] = aMk;
                objArr[1] = aMi;
                if (aMi == null) {
                    i = 0;
                } else {
                    i = aMi.hashCode();
                }
                objArr[2] = Integer.valueOf(i);
                x.i(str, str2, objArr);
                if (!bi.oN(aMi)) {
                    boolean z;
                    c Bw = j.aMv().Bw(aMk);
                    str2 = "MicroMsg.FreeWifi.FreeWifiAuthManager";
                    String str3 = "now mac is : %s, loacal mac is : %s";
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = aMi;
                    objArr2[1] = Bw == null ? "null free wifiinfo" : Bw.field_mac;
                    x.i(str2, str3, objArr2);
                    if (Bw != null) {
                        x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "freewifi is not null, expired time = %d", Long.valueOf(Bw.field_expiredTime));
                        if (!aMi.equalsIgnoreCase(Bw.field_mac) || Bw.field_expiredTime - bi.Wx() < 0) {
                            x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has expierd time or mac has changed");
                            z = true;
                        }
                        z = false;
                    } else if (this.mJF.indexOfKey(aMi.hashCode()) >= 0) {
                        x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has checked this mac, now time - last check time = %d", Long.valueOf(bi.Wy() - ((Long) this.mJF.get(aMi.hashCode())).longValue()));
                        if (bi.Wy() - ((Long) this.mJF.get(aMi.hashCode())).longValue() > 43200000) {
                            z = true;
                        }
                        z = false;
                    } else {
                        x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has not checked this mac, try to check from server");
                        z = true;
                    }
                    x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "Should request bar from back end = %b", Boolean.valueOf(z));
                    if (z) {
                        x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "now should do ap check, rssi is :  %d, mac : %s, mac hashcode : %d", Integer.valueOf(d.aMj()), aMi, Integer.valueOf(aMi.hashCode()));
                        if (System.currentTimeMillis() - a.mIc.oO("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS") > ((long) ((((a.mIc.getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7) * 24) * 60) * 60) * 1000))) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (a.mIc.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1) {
                            i |= 2;
                        }
                        if (a.mIc.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0) == 1) {
                            i |= 4;
                        }
                        if (a.mIc.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0) == 1) {
                            i |= 8;
                        }
                        x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "features : " + i);
                        new com.tencent.mm.plugin.freewifi.d.b(aMi, aMk, r5, i).b(new e() {
                            public final void a(int i, int i2, String str, k kVar) {
                                String str2 = ((com.tencent.mm.plugin.freewifi.d.b) kVar).mac;
                                if (!m.Bf(str2)) {
                                    if (i2 == -30011) {
                                        a.this.mJF.put(str2.hashCode(), Long.valueOf(bi.Wy()));
                                    } else {
                                        a.this.mJF.remove(str2.hashCode());
                                    }
                                }
                            }
                        });
                    }
                }
            }
        }
    }
}

package com.tencent.mm.plugin.wallet_core.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Base64;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.y.q;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i {
    private static c odA;
    private static a sTi;
    private static i sTj;
    private static av sTk = null;
    public JSONArray sTl;

    private static class a implements com.tencent.mm.modelgeo.a.a {
        int hmE = 0;
        WeakReference<Activity> sTm;

        public a(Activity activity) {
            this.sTm = new WeakReference(activity);
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (z) {
                if (i.sTk == null) {
                    i.sTk = new av();
                }
                String FY = q.FY();
                g.Dr();
                x Xv = ((h) g.h(h.class)).Ff().Xv(FY);
                i.sTk.fXl = Xv.getCityCode();
                i.sTk.fXk = Xv.ciR();
                long j = i.OV().hzD;
                WifiInfo wifiInfo = ao.getWifiInfo(ad.getContext());
                String str = "";
                FY = "";
                String str2 = "";
                if (wifiInfo != null) {
                    str = wifiInfo.getSSID();
                    FY = System.currentTimeMillis();
                    str2 = wifiInfo.getBSSID();
                }
                str2 = String.format("latitude=%.6f&longitude=%.6f&location_timestamp=%s&wifissid=%s&wifibssid=%s&ssid_timestamp=%s", new Object[]{Float.valueOf(f2), Float.valueOf(f), Long.valueOf(j), i.wo(str), i.wo(str2), FY});
                i.Nw(str2 + i.bLQ());
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GpsReportHelper", "fLongitude=" + f + ";fLatitude=" + f2 + " tryCount: " + this.hmE);
                this.hmE++;
                if (this.hmE > 3) {
                    i.odA.c(this);
                }
                return true;
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GpsReportHelper", "get Location fail;isOk=" + z);
            i.odA.c(this);
            if (!(this.sTm == null || this.sTm.get() == null || com.tencent.mm.plugin.wallet_core.a.a.ihN == null)) {
                com.tencent.mm.plugin.wallet_core.a.a.ihN.as((Context) this.sTm.get());
            }
            return false;
        }
    }

    private i() {
        init();
    }

    private void init() {
        g.Dr();
        String str = (String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_LBS_REPORT_CONFIG_STRING_SYNC, (Object) "");
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GpsReportHelper", "GpsReportHelper " + str);
        if (!bi.oN(str)) {
            try {
                this.sTl = new JSONArray(str);
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GpsReportHelper", "parse lbs config error", e);
            }
        }
    }

    public static i bLP() {
        if (sTj == null) {
            sTj = new i();
        }
        return sTj;
    }

    protected static String bLQ() {
        String str = "&scan_ssid%d=%s&scan_bssid%d=%s";
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Context context = ad.getContext();
            if (context == null) {
                return "";
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            wifiManager.getConnectionInfo();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            int i = 0;
            for (ScanResult scanResult : wifiManager.getScanResults()) {
                stringBuffer.append(String.format(str, new Object[]{Integer.valueOf(i), wo(scanResult.SSID), Integer.valueOf(i), wo(scanResult.BSSID)}));
                int i2 = i + 1;
                if (i2 >= 5) {
                    break;
                }
                i = i2;
            }
            return stringBuffer.toString();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
        }
    }

    protected static String wo(String str) {
        try {
            return p.encode(str, "UTF-8");
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
            return str;
        }
    }

    protected static void Nw(String str) {
        if (sTk == null) {
            sTk = new av();
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GpsReportHelper", "encrpydata %s", str);
        byte[] bArr = new byte[16];
        byte[] bytes = n.cCi().getBytes();
        if (bytes == null || bytes.length <= 0) {
            bytes = (System.currentTimeMillis()).getBytes();
        }
        int i = 0;
        int i2 = 0;
        do {
            bArr[i2] = bytes[i];
            i2++;
            i++;
            if (i >= bytes.length) {
                i = 0;
                continue;
            }
        } while (i2 < 16);
        bytes = Base64.encode(bArr, 0);
        av avVar = sTk;
        if (l.sTn == null) {
            l.sTn = new l();
        }
        avVar.vMH = l.sTn.aT(bytes);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GpsReportHelper", "mLocationInfo.encrypt_key %s", sTk.vMH);
        bytes = Base64.encode(AesEcb.aesCryptEcb(str.getBytes(), bArr, true, true), 0);
        sTk.vMG = new String(bytes);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GpsReportHelper", "mLocationInfo.encrypt_userinfo %s", new String(bytes));
    }

    private static c OV() {
        if (odA == null) {
            odA = c.OV();
        }
        return odA;
    }

    public static void i(final Activity activity, final int i) {
        int i2 = 1;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GpsReportHelper", "reflashLocationInfo " + i);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", Boolean.valueOf((o.bMc().bMC().sWf & 8192) > 0), Integer.valueOf(o.bMc().bMC().sWf));
        String str;
        if (!((o.bMc().bMC().sWf & 8192) > 0)) {
            sTi = null;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", Boolean.valueOf((o.bMc().bMC().sWf & 262144) > 0), Integer.valueOf(o.bMc().bMC().sWf));
            if ((o.bMc().bMC().sWf & 262144) > 0) {
                WifiInfo wifiInfo = ao.getWifiInfo(ad.getContext());
                String str2 = "";
                str = "";
                String str3 = "";
                if (wifiInfo != null) {
                    str2 = wifiInfo.getSSID();
                    str = System.currentTimeMillis();
                    str3 = wifiInfo.getBSSID();
                }
                Nw(String.format("wifissid=%s&wifibssid=%s&ssid_timestamp=%s", new Object[]{wo(str2), wo(str3), str}) + bLQ());
            }
        } else if (c.OW() || c.OX()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GpsReportHelper", "reflashLocationInfo scene:%d", Integer.valueOf(i));
            if (activity != null) {
                c OV = OV();
                if (sTi == null) {
                    sTi = new a(activity);
                } else {
                    a aVar = sTi;
                    if (activity == null || aVar.sTm == null || !activity.equals(aVar.sTm.get())) {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        sTi = new a(activity);
                    }
                }
                if (sTi != null) {
                    sTi.hmE = 0;
                }
                OV.a(sTi, false);
                return;
            }
            sTi = null;
        } else if (bLP().zz(i)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GpsReportHelper", "should show lbs dialog,scene:%d", Integer.valueOf(i));
            g.Dr();
            str = (String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_LBS_REPORT_DIALOG_TITLE_STRING_SYNC, activity.getString(com.tencent.mm.plugin.wxpay.a.i.vcP));
            g.Dr();
            String str4 = (String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_LBS_REPORT_DIALOG_CONTENT_STRING_SYNC, activity.getString(com.tencent.mm.plugin.wxpay.a.i.vcO));
            g.Dr();
            g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_WALLET_LBS_REPORT_DIALOG_SHOW_TIME_LONG_SYNC, Long.valueOf(bi.Wx()));
            com.tencent.mm.ui.base.h.a((Context) activity, str4, str, activity.getString(com.tencent.mm.plugin.wxpay.a.i.esG), activity.getString(com.tencent.mm.plugin.wxpay.a.i.dEy), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    com.tencent.mm.plugin.report.service.g.pWK.h(13446, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(bi.Wx()));
                    dialogInterface.dismiss();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }, com.tencent.mm.plugin.wxpay.a.c.buj);
        } else {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GpsReportHelper", "should'n show lbs dialog,scene:%d", Integer.valueOf(i));
        }
    }

    public static av bLR() {
        return sTk;
    }

    private boolean zz(int i) {
        if (i == 5 || i == 6) {
            return false;
        }
        boolean z;
        g.Dr();
        long longValue = ((Long) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_LBS_REPORT_DIALOG_SHOW_TIME_LONG_SYNC, Long.valueOf(0))).longValue();
        if (this.sTl == null) {
            init();
        }
        if (this.sTl != null) {
            z = false;
            for (int i2 = 0; i2 < this.sTl.length(); i2++) {
                JSONObject optJSONObject = this.sTl.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.optInt("scene") == i) {
                    int i3;
                    if (optJSONObject.optInt("is_show_tips", 0) == 1) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    int optInt = optJSONObject.optInt("show_interval", 0);
                    long Wx = bi.Wx();
                    if (i3 != 0 && Wx - longValue > ((long) optInt)) {
                        z = true;
                    }
                }
            }
        } else {
            z = false;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GpsReportHelper", "shouldShow? %s mLbsConfig: %s ", Boolean.valueOf(z), this.sTl);
        return z;
    }
}

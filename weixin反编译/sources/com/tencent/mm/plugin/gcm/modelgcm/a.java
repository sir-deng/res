package com.tencent.mm.plugin.gcm.modelgcm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class a implements e {
    private static a nDT;
    private Context context;
    private int nDQ = 3;
    private int nDR = 0;
    private String nDS = "";
    private com.google.android.gms.gcm.a nDU;

    class a extends AsyncTask<Void, Void, String> {
        a() {
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aSQ();
        }

        protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        }

        private String aSQ() {
            Object obj = null;
            d.pVE.a(452, 5, 1, false);
            String b;
            String str;
            try {
                x.i("GcmRegister", "RegisterAsyncTask doInBackground.");
                if (a.this.nDU == null) {
                    a.this.nDU = com.google.android.gms.gcm.a.J(a.this.context);
                }
                b = a.this.nDU.b("546136561403");
                str = "Device registered, registration ID=" + b;
                if (b == null || b.length() <= 0) {
                    g.pWK.k(11250, new StringBuilder("2,1").toString());
                    d.pVE.a(452, 7, 1, false);
                    b = str;
                    x.i("GcmRegister", b);
                    if (obj == null && a.this.nDQ > 0) {
                        a.this.nDQ = a.this.nDQ - 1;
                        a.this.aSI();
                    }
                    return b;
                }
                a.this.af(a.this.context, b);
                a.this.aSN();
                obj = 1;
                d.pVE.a(452, 6, 1, false);
                b = str;
                x.i("GcmRegister", b);
                a.this.nDQ = a.this.nDQ - 1;
                a.this.aSI();
                return b;
            } catch (Throwable e) {
                str = "Device register Error :" + e.getMessage();
                x.printErrStackTrace("GcmRegister", e, "", new Object[0]);
                g.pWK.k(11250, new StringBuilder("2,1").toString());
                d.pVE.a(452, 8, 1, false);
                b = str;
            } catch (Throwable e2) {
                a.this.nDQ = 0;
                str = "Device register Error :" + e2.getMessage();
                x.printErrStackTrace("GcmRegister", e2, "", new Object[0]);
                g.pWK.k(11250, new StringBuilder("2,1").toString());
                d.pVE.a(452, 9, 1, false);
                b = str;
            } catch (Throwable e22) {
                str = "Device register Error :" + e22.getMessage();
                x.printErrStackTrace("GcmRegister", e22, "", new Object[0]);
                g.pWK.k(11250, new StringBuilder("2,1").toString());
                d.pVE.a(452, 10, 1, false);
                b = str;
            }
        }
    }

    private a(Context context) {
        this.context = context;
    }

    public static a aSH() {
        x.i("GcmRegister", "GCM getInstance");
        if (nDT != null) {
            return nDT;
        }
        Context context = ad.getContext();
        if (context == null) {
            x.e("GcmRegister", "GCM appcontext null");
            return null;
        }
        a aVar = new a(context);
        nDT = aVar;
        return aVar;
    }

    public final void aSI() {
        x.i("GcmRegister", "checkregister");
        aa.VV().postDelayed(new Runnable() {
            public final void run() {
                x.e("GcmRegister", "onCreate~~~threadID:" + Thread.currentThread());
                a aSH = a.aSH();
                if (aSH != null) {
                    aSH.aSJ();
                }
            }
        }, 5000);
    }

    public final void aSJ() {
        x.i("GcmRegister", "doRegist old regid[%s]", aSK());
        if (cU(this.context)) {
            this.nDU = com.google.android.gms.gcm.a.J(this.context);
            if (bi.oN(r0) || aSL()) {
                x.i("GcmRegister", "doRegist registerInBackground as regid[%s] is null or expired", r0);
                new a().execute(new Void[]{null, null, null});
                return;
            }
            aSN();
            return;
        }
        x.i("GcmRegister", "Google Play Services Unavailable.");
        g.pWK.k(11250, new StringBuilder("2,0").toString());
        d.pVE.a(452, 0, 1, false);
        if (aSP()) {
            aSK();
            aSO();
        }
    }

    @SuppressLint({"NewApi"})
    public final String aSK() {
        SharedPreferences aSM = aSM();
        String string = aSM.getString("registration_id", "");
        if (string.length() == 0) {
            x.i("GcmRegister", "registrationId not found.");
            d.pVE.a(452, 1, 1, false);
            return "";
        } else if (aSM.getInt("appVersion", Integer.MIN_VALUE) != cT(this.context)) {
            x.i("GcmRegister", "App version changed.");
            d.pVE.a(452, 2, 1, false);
            return "";
        } else {
            d.pVE.a(452, 4, 1, false);
            return string;
        }
    }

    final boolean aSL() {
        if (bi.bz(aSM().getLong("regtime", 0)) <= 259200) {
            return false;
        }
        x.i("GcmRegister", "gcm regid timeout[%d, %d]", Long.valueOf(bi.bz(aSM().getLong("regtime", 0))), Integer.valueOf(259200));
        d.pVE.a(452, 3, 1, false);
        return true;
    }

    private SharedPreferences aSM() {
        return this.context.getSharedPreferences(a.class.getSimpleName(), 0);
    }

    private static int cT(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            x.e("GcmRegister", "Could not get package name.");
            return i;
        }
    }

    public final void aSN() {
        d.pVE.a(452, 11, 1, false);
        int Cn = aa.VX().iby.Cn();
        String aSK = aSK();
        if (bi.oN(aSK)) {
            x.i("GcmRegister", "sendRegistrationIdToBackend regid is empty.");
            d.pVE.a(452, 13, 1, false);
        } else if (this.nDR != 0 && Cn == this.nDR && aSK.equals(this.nDS)) {
            x.i("GcmRegister", "uin[%s][%s] already reg to weixin svr", Integer.valueOf(this.nDR), bi.Wz(aSK));
            d.pVE.a(452, 12, 1, false);
        } else {
            this.nDS = aSK;
            x.i("GcmRegister", "regToWeixinServer [%s]", bi.Wz(this.nDS));
            try {
                new e(aSK, Cn).a(aa.VX(), this);
                d.pVE.a(452, 14, 1, false);
            } catch (Throwable th) {
                d.pVE.a(452, 15, 1, false);
                x.e("GcmRegister", "NetScenePushReg doScene error:" + th.toString());
            }
        }
    }

    public final void aSO() {
        x.i("GcmRegister", "unregToWeixinServer");
        d.pVE.a(452, 18, 1, false);
        String aSK = aSK();
        if (bi.oN(aSK)) {
            x.e("GcmRegister", "unregToWeixinServer regid is empty.");
            d.pVE.a(452, 19, 1, false);
        } else if (aSP()) {
            fM(false);
            try {
                new f(aSK, aa.VX().iby.Cn()).a(aa.VX(), this);
                d.pVE.a(452, 21, 1, false);
            } catch (Throwable th) {
                x.e("GcmRegister", "NetScenePushUnReg doScene error:" + th.toString());
                d.pVE.a(452, 22, 1, false);
            }
        } else {
            x.e("GcmRegister", "is not reg to Svr. no need unreg.");
            d.pVE.a(452, 20, 1, false);
        }
    }

    public final void af(Context context, String str) {
        SharedPreferences aSM = aSM();
        int cT = cT(context);
        String string = aSM.getString("registration_id", "");
        x.i("GcmRegister", "Saving regId on app version[%s] regid[%s to %s] same[%b]", Integer.valueOf(cT), bi.Wz(string), bi.Wz(str), Boolean.valueOf(string.equals(str)));
        if (bi.oN(string)) {
            d.pVE.a(452, 37, 1, false);
        }
        if (bi.oN(str)) {
            d.pVE.a(452, 38, 1, false);
        }
        d.pVE.a(452, string.equals(str) ? 39 : 40, 1, false);
        Editor edit = aSM.edit();
        edit.putString("registration_id", str);
        edit.putInt("appVersion", cT);
        edit.putLong("regtime", bi.Wx());
        edit.commit();
    }

    private void fM(boolean z) {
        SharedPreferences aSM = aSM();
        x.i("GcmRegister", "Saving regSvrResult: " + z);
        Editor edit = aSM.edit();
        edit.putBoolean("isRegToSvr", z);
        edit.commit();
        if (z) {
            this.nDR = aa.VX().iby.Cn();
        } else {
            this.nDR = 0;
        }
    }

    public final boolean aSP() {
        return aSM().getBoolean("isRegToSvr", false);
    }

    private static boolean cU(Context context) {
        try {
            if (Integer.valueOf(VERSION.SDK_INT).intValue() < 8) {
                return false;
            }
            int C = com.google.android.gms.common.e.C(context);
            if (C == 0) {
                return true;
            }
            x.w("GcmRegister", "device not support GCM reason = " + C);
            return false;
        } catch (Throwable th) {
            x.e("GcmRegister", th.toString());
            return false;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = false;
        x.i("GcmRegister", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        kVar.hop = true;
        if (kVar != null) {
            if (kVar instanceof e) {
                if (i == 0 && i2 == 0) {
                    x.i("GcmRegister", "NetScenePushReg success.");
                    d.pVE.a(452, 16, 1, false);
                    z = true;
                } else {
                    x.i("GcmRegister", "NetScenePushReg faild.");
                    d.pVE.a(452, 17, 1, false);
                }
                fM(z);
            } else if (kVar instanceof f) {
                if (i == 0 && i2 == 0) {
                    x.i("GcmRegister", "NetScenePushUnReg success.");
                    d.pVE.a(452, 23, 1, false);
                } else {
                    x.e("GcmRegister", "NetScenePushUnReg faild.");
                    d.pVE.a(452, 24, 1, false);
                }
                fM(false);
            }
        }
    }
}

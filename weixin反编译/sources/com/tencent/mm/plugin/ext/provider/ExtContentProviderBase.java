package com.tencent.mm.plugin.ext.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.e.a.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;
import com.tencent.mm.y.be.a;
import java.util.HashMap;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtContentProviderBase extends ContentProvider {
    protected static boolean kAO = false;
    private static HashMap<String, Long> mfV = new HashMap();
    public MatrixCursor kAL = new MatrixCursor(new String[0]);
    private long mfQ = bi.Wz();
    private String mfR;
    public String mfS = "";
    private String[] mfT;
    private int mfU = 0;

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public final void pI(int i) {
        x.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", aGt(), this.mfS, Integer.valueOf(this.mfU), Integer.valueOf(i), Integer.valueOf(aGs()));
        g.pWK.h(10505, aGt(), this.mfS, Integer.valueOf(this.mfU), Integer.valueOf(i), Integer.valueOf(aGs()));
    }

    public final void cw(int i, int i2) {
        x.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", aGt(), this.mfS, Integer.valueOf(this.mfU), Integer.valueOf(i), Integer.valueOf(aGs()));
        g.pWK.h(10505, aGt(), this.mfS, Integer.valueOf(this.mfU), Integer.valueOf(i), Integer.valueOf(aGs()), Integer.valueOf(i2));
    }

    public final void J(int i, int i2, int i3) {
        x.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", aGt(), this.mfS, Integer.valueOf(this.mfU), Integer.valueOf(i2), Integer.valueOf(aGs()));
        g.pWK.h(10505, aGt(), this.mfS, Integer.valueOf(this.mfU), Integer.valueOf(i2), Integer.valueOf(aGs()), Integer.valueOf(i3));
        g.pWK.a(300, (long) i, 1, false);
    }

    private int aGs() {
        return (int) bi.bB(this.mfQ);
    }

    protected final void a(Uri uri, Context context, UriMatcher uriMatcher) {
        this.mfS = g(uri);
        cB(context);
        if (uriMatcher != null) {
            this.mfU = uriMatcher.match(uri);
            if (this.mfU < 0) {
                this.mfU = 0;
            }
        }
        this.mfQ = bi.Wz();
    }

    protected final void a(Uri uri, Context context, int i) {
        this.mfS = g(uri);
        cB(context);
        this.mfU = i;
        this.mfQ = bi.Wz();
    }

    public final void a(Uri uri, Context context, int i, String[] strArr) {
        this.mfS = g(uri);
        if (strArr == null) {
            cB(context);
        } else {
            this.mfT = strArr;
        }
        this.mfU = i;
        this.mfQ = bi.Wz();
    }

    public final String aGt() {
        if (!bi.oN(this.mfR)) {
            return this.mfR;
        }
        if (this.mfT == null || this.mfT.length <= 0) {
            return "";
        }
        return this.mfT[0];
    }

    public final boolean arF() {
        try {
            x.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
            if (!kAO) {
                final b bVar = new b();
                bVar.b(4000, new Runnable() {
                    public final void run() {
                        try {
                            if (as.Hp()) {
                                as.CN().a(new be(new a() {
                                    public final void a(e eVar) {
                                        x.i("MicroMsg.ExtContentProviderBase", "checkIsLogin() onSceneEnd()");
                                        bVar.countDown();
                                    }
                                }), 0);
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
                            bVar.countDown();
                        }
                    }
                });
            }
            if (as.Hp() && as.Ho() && !as.Cz()) {
                kAO = true;
            } else {
                kAO = false;
            }
            x.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + kAO);
            return kAO;
        } catch (Throwable e) {
            x.w("MicroMsg.ExtContentProviderBase", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
            return false;
        }
    }

    private static String g(Uri uri) {
        if (uri == null) {
            return "";
        }
        return bi.oM(uri.getQueryParameter("appid"));
    }

    public final boolean cA(Context context) {
        Throwable th;
        boolean z;
        if (context == null) {
            x.w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
            return false;
        } else if (bi.oN(this.mfS)) {
            x.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
            return false;
        } else if (this.mfT == null || this.mfT.length <= 0) {
            x.e("MicroMsg.ExtContentProviderBase", "packageList is null");
            return false;
        } else {
            try {
                f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(this.mfS, true);
                if (aZ == null) {
                    x.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
                    return false;
                }
                boolean z2;
                if (aZ.field_status == 3) {
                    x.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", aZ.field_packageName);
                    z2 = false;
                } else {
                    for (String str : this.mfT) {
                        if (str.equals(aZ.field_packageName) && p.b(ad.getContext(), aZ, str)) {
                            x.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", str);
                            try {
                                this.mfR = str;
                                z2 = true;
                                break;
                            } catch (Throwable e) {
                                th = e;
                                z = true;
                                x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                                x.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                                return z;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        Integer num = (Integer) com.tencent.mm.pluginsdk.b.b.viL.get(Integer.valueOf(this.mfU));
                        if (num == null) {
                            num = Integer.valueOf(64);
                        }
                        if (com.tencent.mm.pluginsdk.model.app.g.a(aZ, num.intValue())) {
                            x.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
                        } else {
                            z2 = false;
                        }
                    }
                }
                try {
                    x.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", Long.valueOf(bi.a((Long) mfV.get(this.mfS), 0)), Long.valueOf(System.currentTimeMillis()));
                    if (System.currentTimeMillis() - Long.valueOf(bi.a((Long) mfV.get(this.mfS), 0)).longValue() > 3600000) {
                        x.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", this.mfS);
                        com.tencent.mm.plugin.y.a.a.a.biY().HM(this.mfS);
                        mfV.put(this.mfS, Long.valueOf(System.currentTimeMillis()));
                    }
                    return z2;
                } catch (Throwable e2) {
                    Throwable th2 = e2;
                    z = z2;
                    th = th2;
                    x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                    return z;
                }
            } catch (Throwable e22) {
                th = e22;
                z = false;
                x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                x.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                return z;
            }
        }
    }

    public final int aGu() {
        Throwable th;
        if (bi.oN(this.mfS)) {
            x.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
            return 7;
        } else if (this.mfT == null || this.mfT.length <= 0) {
            x.e("MicroMsg.ExtContentProviderBase", "packageList is null");
            return 6;
        } else {
            int i;
            try {
                f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(this.mfS, true);
                if (aZ == null) {
                    x.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
                    return 13;
                }
                int i2;
                if (aZ.field_status == 3) {
                    x.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", aZ.field_packageName);
                    i2 = 10;
                } else {
                    for (String str : this.mfT) {
                        if (str.equals(aZ.field_packageName) && p.b(ad.getContext(), aZ, str)) {
                            x.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", str);
                            try {
                                this.mfR = str;
                                i2 = 1;
                                break;
                            } catch (Throwable e) {
                                th = e;
                                i = 1;
                                x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                                x.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                                return i;
                            }
                        }
                    }
                    i2 = 0;
                    if (i2 == 1) {
                        Integer num = (Integer) com.tencent.mm.pluginsdk.b.b.viL.get(Integer.valueOf(this.mfU));
                        if (num == null) {
                            cw(5, 16);
                            x.i("MicroMsg.ExtContentProviderBase", "api flag = null");
                            num = Integer.valueOf(64);
                        }
                        if (com.tencent.mm.pluginsdk.model.app.g.a(aZ, num.intValue())) {
                            x.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
                        } else {
                            i2 = 11;
                        }
                    }
                }
                try {
                    x.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", Long.valueOf(bi.a((Long) mfV.get(this.mfS), 0)), Long.valueOf(System.currentTimeMillis()));
                    if (System.currentTimeMillis() - Long.valueOf(bi.a((Long) mfV.get(this.mfS), 0)).longValue() > 3600000) {
                        x.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", this.mfS);
                        com.tencent.mm.plugin.y.a.a.a.biY().HM(this.mfS);
                        mfV.put(this.mfS, Long.valueOf(System.currentTimeMillis()));
                    }
                    return i2;
                } catch (Throwable e2) {
                    Throwable th2 = e2;
                    i = i2;
                    th = th2;
                    x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                    return i;
                }
            } catch (Throwable e22) {
                th = e22;
                i = 0;
                x.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                x.printErrStackTrace("MicroMsg.ExtContentProviderBase", th, "", new Object[0]);
                return i;
            }
        }
    }

    private void cB(Context context) {
        if (context == null) {
            x.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
            return;
        }
        x.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
        this.mfT = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (this.mfT == null) {
            x.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
        }
    }
}

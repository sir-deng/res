package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.f.a.ev;
import com.tencent.mm.f.a.ew;
import com.tencent.mm.f.a.fe;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.e.a.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public final class ExtControlProviderSNS extends ExtContentProviderBase {
    private static final UriMatcher mfY;
    private static final String[] mgA = new String[]{"feedId", "desc", SlookSmartClipMetaTag.TAG_TYPE_URL, "nickname", "avatar", "timestamp", "mediaCount", Columns.TYPE, "bigImgUrl", "firstImgWidth", "firstImgHeight"};
    private static boolean mgx = false;
    private static al mgy = new al(new a() {
        public final boolean uG() {
            ExtControlProviderSNS.mgx = false;
            return false;
        }
    }, false);
    private boolean fuZ = false;
    private boolean fva = false;
    private int fvb = 0;
    private String mgB = "";

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        mfY = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.SNS", "snsInfo", 17);
    }

    private static void cw(boolean z) {
        if (z) {
            mgx = true;
            mgy.K(15000, 15000);
            return;
        }
        mgy.K(0, 0);
    }

    public final boolean onCreate() {
        return false;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlProviderSNS", "query() " + uri);
        a(uri, getContext(), mfY);
        if (uri == null) {
            pI(3);
            return null;
        } else if (bi.oN(this.mfS) || bi.oN(aGt())) {
            pI(3);
            return null;
        } else if (mgx) {
            x.w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
            pI(5);
            return null;
        } else {
            cw(true);
            if (!arF()) {
                cw(false);
                pI(1);
                return this.kAL;
            } else if (!cA(getContext())) {
                x.w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
                cw(false);
                pI(2);
                return null;
            } else if (strArr2 == null || strArr2.length == 0) {
                x.e("MicroMsg.ExtControlProviderSNS", "invaild selections");
                cw(false);
                pI(3);
                return null;
            } else {
                String str3 = strArr2[0];
                if (bi.oN(str3)) {
                    x.e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
                    cw(false);
                    pI(3);
                    return null;
                }
                try {
                    long j;
                    Cursor cQ;
                    if ("0".equals(str3.trim())) {
                        j = 0;
                    } else {
                        j = Long.valueOf(com.tencent.mm.plugin.ext.a.a.Ad(str3.trim())).longValue();
                    }
                    switch (mfY.match(uri)) {
                        case 17:
                            cQ = cQ(j);
                            break;
                        default:
                            cQ = null;
                            break;
                    }
                    if (cQ != null) {
                        pI(0);
                    } else {
                        pI(4);
                    }
                    cw(false);
                    return cQ;
                } catch (Throwable e) {
                    x.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
                    cw(false);
                    pI(4);
                    return null;
                }
            }
        }
    }

    private Cursor cQ(long j) {
        int i = 1;
        x.i("MicroMsg.ExtControlProviderSNS", "handleGetSnsInfo() userId = " + j);
        try {
            ag Xt;
            x.i("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo, userId=[%s]", Long.valueOf(j));
            if (j == 0) {
                as.Hm();
                Xt = c.Ff().Xt(q.FY());
            } else {
                as.Hm();
                Xt = c.Ff().fP(j);
            }
            if (Xt == null || ((int) Xt.gKO) <= 0) {
                x.e("MicroMsg.ExtControlProviderSNS", "ct == null");
                i = 0;
            } else {
                this.fuZ = com.tencent.mm.k.a.ga(Xt.field_type);
                this.fva = q.gt(Xt.field_username);
                x.d("MicroMsg.ExtControlProviderSNS", "ct.getUsername()=[%s], isFriend=[%s], isSelf=[%s]", Xt.field_username, Boolean.valueOf(this.fuZ), Boolean.valueOf(this.fva));
                final b bVar = new b();
                bVar.b(10000, new Runnable() {
                    public final void run() {
                        com.tencent.mm.sdk.b.b feVar = new fe();
                        feVar.fuY.type = 1;
                        feVar.fuY.username = Xt.field_username;
                        feVar.fuY.fuZ = ExtControlProviderSNS.this.fuZ;
                        feVar.fuY.fva = ExtControlProviderSNS.this.fva;
                        feVar.fuY.fvb = ExtControlProviderSNS.this.fvb;
                        feVar.fuY.fvc = new be.a() {
                            public final void a(e eVar) {
                                bVar.countDown();
                            }
                        };
                        com.tencent.mm.sdk.b.a.xmy.m(feVar);
                    }
                });
            }
            if (i == 0) {
                x.w("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo() return false");
                return null;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
        }
        return aGy();
    }

    private Cursor aGy() {
        x.i("MicroMsg.ExtControlProviderSNS", new StringBuilder("getSnsCursor() , needDownload = true").toString());
        com.tencent.mm.bx.e eVar = new com.tencent.mm.bx.e(mgA, (byte) 0);
        com.tencent.mm.sdk.b.b evVar = new ev();
        evVar.fup.fur = this.mgB;
        if (com.tencent.mm.sdk.b.a.xmy.m(evVar)) {
            Cursor cursor = evVar.fuq.fui;
            if (cursor != null) {
                try {
                    int count = cursor.getCount();
                    x.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), snsCount = " + count);
                    if (count <= 0 || !cursor.moveToFirst()) {
                        x.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + eVar.getCount());
                        cursor.close();
                    } else {
                        do {
                            if (cursor != null) {
                                com.tencent.mm.sdk.b.b ewVar = new ew();
                                ewVar.fus.fuu = cursor;
                                if (com.tencent.mm.sdk.b.a.xmy.m(ewVar)) {
                                    as.Hm();
                                    com.tencent.mm.k.a Xt = c.Ff().Xt(ewVar.fut.fuv);
                                    if (Xt != null && ((int) Xt.gKO) > 0) {
                                        int i;
                                        Object obj;
                                        Object[] objArr;
                                        String str = "";
                                        String str2 = "";
                                        switch (ewVar.fut.fuz) {
                                            case 1:
                                            case 7:
                                            case 8:
                                                i = 2;
                                                break;
                                            case 2:
                                                i = 1;
                                                break;
                                            case 3:
                                                i = 6;
                                                break;
                                            case 4:
                                                i = 3;
                                                break;
                                            case 5:
                                                i = 4;
                                                break;
                                            default:
                                                i = 5;
                                                break;
                                        }
                                        if (!(ewVar.fut.fuB == null || ewVar.fut.fuB.size() <= 0 || getContext() == null)) {
                                            x.d("MicroMsg.ExtControlProviderSNS", "uris.size() = [%s]", Integer.valueOf(ewVar.fut.fuB.size()));
                                            if (i == 2 || i == 6 || i == 3 || i == 4) {
                                                obj = (String) ewVar.fut.fuB.get(0);
                                                if (!(ewVar.fut.fuC == null || ewVar.fut.fuC.size() <= 0 || getContext() == null)) {
                                                    x.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", Integer.valueOf(ewVar.fut.fuC.size()), Integer.valueOf(ewVar.fut.fuD), Integer.valueOf(ewVar.fut.fuE));
                                                    if (i == 2 || i == 6 || i == 3 || i == 4) {
                                                        str2 = (String) ewVar.fut.fuC.get(0);
                                                    }
                                                }
                                                str = com.tencent.mm.ac.b.iZ(ewVar.fut.fuv);
                                                objArr = new Object[11];
                                                objArr[0] = com.tencent.mm.plugin.ext.a.a.cP((long) ewVar.fut.fuw);
                                                objArr[1] = ewVar.fut.fux;
                                                objArr[2] = obj;
                                                objArr[3] = Xt.AX();
                                                if (str == null) {
                                                    str = "";
                                                }
                                                objArr[4] = str;
                                                objArr[5] = Long.valueOf(ewVar.fut.fuy);
                                                objArr[6] = Integer.valueOf(ewVar.fut.fuA);
                                                objArr[7] = Integer.valueOf(i);
                                                objArr[8] = str2;
                                                objArr[9] = Integer.valueOf(ewVar.fut.fuD);
                                                objArr[10] = Integer.valueOf(ewVar.fut.fuE);
                                                eVar.addRow(objArr);
                                            }
                                        }
                                        String obj2 = str;
                                        x.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", Integer.valueOf(ewVar.fut.fuC.size()), Integer.valueOf(ewVar.fut.fuD), Integer.valueOf(ewVar.fut.fuE));
                                        str2 = (String) ewVar.fut.fuC.get(0);
                                        str = com.tencent.mm.ac.b.iZ(ewVar.fut.fuv);
                                        try {
                                            objArr = new Object[11];
                                            objArr[0] = com.tencent.mm.plugin.ext.a.a.cP((long) ewVar.fut.fuw);
                                            objArr[1] = ewVar.fut.fux;
                                            objArr[2] = obj2;
                                            objArr[3] = Xt.AX();
                                            if (str == null) {
                                                str = "";
                                            }
                                            objArr[4] = str;
                                            objArr[5] = Long.valueOf(ewVar.fut.fuy);
                                            objArr[6] = Integer.valueOf(ewVar.fut.fuA);
                                            objArr[7] = Integer.valueOf(i);
                                            objArr[8] = str2;
                                            objArr[9] = Integer.valueOf(ewVar.fut.fuD);
                                            objArr[10] = Integer.valueOf(ewVar.fut.fuE);
                                            eVar.addRow(objArr);
                                        } catch (Throwable e) {
                                            x.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
                                            x.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
                                        }
                                    }
                                } else {
                                    x.w("MicroMsg.ExtControlProviderSNS", "ExtGetSnsDataEvent publish error");
                                }
                            }
                        } while (cursor.moveToNext());
                        x.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + eVar.getCount());
                        cursor.close();
                    }
                } catch (Throwable e2) {
                    x.e("MicroMsg.ExtControlProviderSNS", e2.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e2, "", new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                    eVar.close();
                    return null;
                }
            }
            return eVar;
        }
        eVar.close();
        return null;
    }

    public final String getType(Uri uri) {
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}

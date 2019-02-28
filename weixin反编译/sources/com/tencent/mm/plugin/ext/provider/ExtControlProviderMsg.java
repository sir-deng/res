package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ey;
import com.tencent.mm.f.a.fa;
import com.tencent.mm.f.a.fb;
import com.tencent.mm.f.a.fh;
import com.tencent.mm.f.a.fi;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.pluginsdk.e.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bj;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderMsg extends ExtContentProviderBase {
    private static final UriMatcher mfY;
    private static final String[] mgb = new String[]{"msgId", "fromUserId", "fromUserNickName", "msgType", DownloadInfo.CONTENTTYPE, "content", DownloadInfo.STATUS, "createTime"};
    private static final String[] mgc = new String[]{"userId", "unReadCount"};
    private static final String[] mgd = new String[]{"userId", "unReadCount"};
    private static final String[] mge = new String[]{"userId", "retCode", "msgId"};
    private static final String[] mgf = new String[]{"msgId", "retCode"};
    private static final String[] mgg = new String[]{"msgId", "retCode"};
    private String[] mfJ;
    private int mfK;
    private boolean mfZ;
    private Context mga;
    private MatrixCursor mgh;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        mfY = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.message", "oneMsg", 7);
        mfY.addURI("com.tencent.mm.plugin.ext.message", "unReadCount", 8);
        mfY.addURI("com.tencent.mm.plugin.ext.message", "unReadMsgs", 9);
        mfY.addURI("com.tencent.mm.plugin.ext.message", "unReadUserList", 10);
        mfY.addURI("com.tencent.mm.plugin.ext.message", "recordMsg", 11);
        mfY.addURI("com.tencent.mm.plugin.ext.message", JsApiStartPlayVoice.NAME, 12);
        mfY.addURI("com.tencent.mm.plugin.ext.message", "setReaded", 13);
        mfY.addURI("com.tencent.mm.plugin.ext.message", "sendTextMsg", 14);
    }

    public ExtControlProviderMsg() {
        this.mgh = null;
        this.mfZ = false;
        this.mfJ = null;
        this.mfK = -1;
    }

    public ExtControlProviderMsg(String[] strArr, int i, Context context) {
        this.mgh = null;
        this.mfZ = false;
        this.mfJ = null;
        this.mfK = -1;
        this.mfZ = true;
        this.mfJ = strArr;
        this.mfK = i;
        this.mga = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.mfZ);
        if (this.mfZ) {
            a(uri, this.mga, this.mfK, this.mfJ);
            if (bi.oN(this.mfS)) {
                x.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
                cw(3, 7);
                return a.BQ(7);
            } else if (bi.oN(aGt())) {
                x.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
                cw(3, 6);
                return a.BQ(6);
            } else {
                int aGu = aGu();
                if (aGu != 1) {
                    x.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = " + aGu);
                    cw(2, aGu);
                    return a.BQ(aGu);
                }
            }
        }
        this.mga = getContext();
        a(uri, this.mga, mfY);
        if (uri == null) {
            pI(3);
            return null;
        } else if (bi.oN(this.mfS) || bi.oN(aGt())) {
            pI(3);
            return null;
        } else if (!arF()) {
            pI(1);
            return this.kAL;
        } else if (!cA(this.mga)) {
            x.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
            pI(2);
            return null;
        }
        String oM = bi.oM(uri.getQueryParameter("source"));
        String oM2 = bi.oM(uri.getQueryParameter("count"));
        if (!this.mfZ) {
            this.mfK = mfY.match(uri);
        }
        switch (this.mfK) {
            case 7:
                return c(strArr2, oM);
            case 8:
                return o(strArr2);
            case 9:
                return a(strArr2, oM, oM2);
            case 10:
                return aGv();
            case 11:
                return p(strArr2);
            case 12:
                return q(strArr2);
            case 13:
                return r(strArr2);
            case 14:
                return s(strArr2);
            default:
                cw(3, 15);
                return null;
        }
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

    private Cursor o(String[] strArr) {
        x.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            pI(3);
            return null;
        }
        Cursor matrixCursor = new MatrixCursor(mgc);
        try {
            int hy;
            if ("*".equals(strArr[0])) {
                as.Hm();
                hy = c.Fk().hy("");
                matrixCursor.addRow(new Object[]{"0", Integer.valueOf(hy)});
            } else {
                for (String Ad : strArr) {
                    long Ad2 = com.tencent.mm.plugin.ext.a.a.Ad(Ad);
                    as.Hm();
                    ag fP = c.Ff().fP(Ad2);
                    if (fP != null && ((int) fP.gKO) > 0) {
                        as.Hm();
                        int hy2 = c.Fk().hy(" and ( rconversation.username='" + fP.field_username + "' );");
                        matrixCursor.addRow(new Object[]{Long.valueOf(Ad2), Integer.valueOf(hy2)});
                    }
                }
            }
            pI(0);
            return matrixCursor;
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            matrixCursor.close();
            pI(4);
            return null;
        }
    }

    private Cursor a(String[] strArr, String str, String str2) {
        Throwable e;
        MatrixCursor matrixCursor;
        x.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
        x.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", str, str2);
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            cw(3, 3701);
            return a.BQ(3701);
        } else if (bi.oN(str)) {
            x.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
            cw(3, 3702);
            return a.BQ(3702);
        } else if (bi.oN(str2)) {
            x.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
            cw(3, 3703);
            return a.BQ(3703);
        } else {
            ag Xv;
            boolean z = str != null && str.equalsIgnoreCase("openapi");
            if (z) {
                try {
                    bj Yt = b.aGj().Yt(strArr[0]);
                    if (Yt == null || bi.oN(Yt.field_openId) || bi.oN(Yt.field_username)) {
                        x.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
                        cw(3, 3704);
                        return a.BQ(3704);
                    }
                    as.Hm();
                    Xv = c.Ff().Xv(Yt.field_username);
                } catch (Exception e2) {
                    e = e2;
                    matrixCursor = null;
                    x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                    if (matrixCursor != null) {
                        matrixCursor.close();
                    }
                    J(3, 4, 12);
                    return a.BQ(12);
                }
            }
            long Ad = com.tencent.mm.plugin.ext.a.a.Ad(strArr[0]);
            as.Hm();
            Xv = c.Ff().fP(Ad);
            if (Xv == null || Xv.field_username == null || Xv.field_username.length() <= 0) {
                x.e("MicroMsg.ExtControlProviderMsg", "contact is null");
                cw(3, 3705);
                return a.BQ(3705);
            }
            boolean z2;
            Cursor bE;
            String AX = Xv.AX();
            if (Xv.field_username.endsWith("@chatroom")) {
                AX = r.gw(Xv.field_username);
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                int i;
                try {
                    i = bi.getInt(str2, 0);
                } catch (Exception e3) {
                    x.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", str2);
                    i = 0;
                }
                if (i <= 0 || i >= 15) {
                    as.Hm();
                    bE = c.Fh().bE(Xv.field_username, 15);
                } else {
                    as.Hm();
                    bE = c.Fh().bE(Xv.field_username, i);
                }
            } else {
                as.Hm();
                bE = c.Fh().bE(Xv.field_username, 3);
            }
            if (bE == null) {
                x.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                J(3, 4, 3706);
                return a.BQ(3706);
            }
            matrixCursor = new MatrixCursor(mgb);
            try {
                if (bE.getCount() <= 0 || !bE.moveToFirst()) {
                    bE.close();
                    J(2, 0, 1);
                    return matrixCursor;
                }
                au auVar = new au();
                do {
                    auVar.b(bE);
                    a(matrixCursor, auVar, Xv, z2, AX, z, strArr[0]);
                } while (bE.moveToNext());
                bE.close();
                J(2, 0, 1);
                return matrixCursor;
            } catch (Exception e4) {
                e = e4;
                x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                J(3, 4, 12);
                return a.BQ(12);
            }
        }
    }

    private Cursor aGv() {
        x.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
        Object matrixCursor = new MatrixCursor(mgd);
        try {
            as.Hm();
            Cursor aZX = c.Fh().aZX();
            if (aZX != null) {
                if (aZX.moveToFirst()) {
                    do {
                        String string = aZX.getString(aZX.getColumnIndex("talker"));
                        as.Hm();
                        ag Xv = c.Ff().Xv(string);
                        if (!s.eX(string)) {
                            int i = (s.hq(Xv.field_username) || s.ho(Xv.field_username) || com.tencent.mm.storage.x.DG(Xv.field_verifyFlag) || s.hg(Xv.field_username) || s.hh(Xv.field_username)) ? 0 : 1;
                            if (i == 0) {
                                long j = (long) ((int) Xv.gKO);
                                matrixCursor.addRow(new Object[]{com.tencent.mm.plugin.ext.a.a.cP(j), Integer.valueOf(aZX.getInt(aZX.getColumnIndex("unReadCount")))});
                            }
                        }
                    } while (aZX.moveToNext());
                }
                aZX.close();
            }
            pI(0);
            return matrixCursor;
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            matrixCursor.close();
            pI(4);
            return null;
        }
    }

    private Cursor c(String[] strArr, String str) {
        Throwable e;
        boolean z = true;
        x.d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            pI(3);
            return null;
        }
        MatrixCursor matrixCursor;
        try {
            long Ad = com.tencent.mm.plugin.ext.a.a.Ad(strArr[0]);
            as.Hm();
            cg dI = c.Fh().dI(Ad);
            as.Hm();
            ag Xv = c.Ff().Xv(dI.field_talker);
            if (Xv == null || ((int) Xv.gKO) <= 0) {
                pI(3);
                return null;
            }
            boolean z2;
            String AX = Xv.AX();
            if (Xv.field_username.endsWith("@chatroom")) {
                AX = r.gw(Xv.field_username);
                z2 = true;
            } else {
                z2 = false;
            }
            if (str == null || !str.equalsIgnoreCase("openapi")) {
                z = false;
            }
            matrixCursor = new MatrixCursor(mgb);
            try {
                a(matrixCursor, dI, Xv, z2, AX, z, strArr[0]);
                pI(0);
                return matrixCursor;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            matrixCursor = null;
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            pI(4);
            return null;
        }
    }

    private Cursor p(String[] strArr) {
        Cursor cursor = null;
        x.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
        if (strArr == null || strArr.length < 2) {
            x.w("MicroMsg.ExtControlProviderMsg", "wrong args");
            pI(3);
            return cursor;
        }
        try {
            final int intValue = Integer.valueOf(strArr[0]).intValue();
            final long Ad = com.tencent.mm.plugin.ext.a.a.Ad(strArr[1]);
            if (Ad <= 0) {
                pI(3);
                return cursor;
            }
            final com.tencent.mm.pluginsdk.e.a.b bVar = new com.tencent.mm.pluginsdk.e.a.b();
            final String[] strArr2 = strArr;
            bVar.b(4000, new Runnable() {
                public final void run() {
                    if (intValue == 1) {
                        b.aGg();
                        ag cN = b.cN(Ad);
                        if (cN == null || ((int) cN.gKO) <= 0) {
                            ExtControlProviderMsg.this.pI(3);
                            bVar.countDown();
                            return;
                        }
                        com.tencent.mm.sdk.b.b fbVar = new fb();
                        fbVar.fuT.op = 1;
                        fbVar.fuT.username = cN.field_username;
                        if (com.tencent.mm.sdk.b.a.xmy.m(fbVar)) {
                            ExtControlProviderMsg.this.mgh = new MatrixCursor(ExtControlProviderMsg.mge);
                            if (cN == null || ((int) cN.gKO) <= 0 || !fbVar.fuU.fqR) {
                                ExtControlProviderMsg.this.mgh.addRow(new Object[]{strArr2[1], Integer.valueOf(2), "0"});
                                ExtControlProviderMsg.this.pI(3);
                            } else {
                                ExtControlProviderMsg.this.mgh.addRow(new Object[]{strArr2[1], Integer.valueOf(1), "0"});
                                ExtControlProviderMsg.this.pI(0);
                            }
                            x.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", Boolean.valueOf(fbVar.fuU.fqR), fbVar.fuU.fileName);
                        } else {
                            ExtControlProviderMsg.this.pI(4);
                            bVar.countDown();
                            return;
                        }
                    } else if (intValue == 2) {
                        com.tencent.mm.sdk.b.b fbVar2 = new fb();
                        fbVar2.fuT.op = 2;
                        if (com.tencent.mm.sdk.b.a.xmy.m(fbVar2)) {
                            String str = fbVar2.fuU.fileName;
                            ExtControlProviderMsg.this.mgh = new MatrixCursor(ExtControlProviderMsg.mge);
                            com.tencent.mm.sdk.b.b fhVar = new fh();
                            fhVar.fvq.fileName = str;
                            if (com.tencent.mm.sdk.b.a.xmy.m(fhVar)) {
                                x.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", Long.valueOf(fhVar.fvr.frh));
                                if (fhVar.fvr.frh > 0) {
                                    try {
                                        if (!fbVar2.fuU.fqR) {
                                            ExtControlProviderMsg.this.mgh.addRow(new Object[]{strArr2[1], Integer.valueOf(4), com.tencent.mm.plugin.ext.a.a.cP(r2)});
                                            ExtControlProviderMsg.this.pI(4);
                                        } else if (ad.getContext() == null || !ao.isConnected(ad.getContext())) {
                                            ExtControlProviderMsg.this.mgh.addRow(new Object[]{strArr2[1], Integer.valueOf(6), com.tencent.mm.plugin.ext.a.a.cP(r2)});
                                            ExtControlProviderMsg.this.pI(4);
                                        } else {
                                            ExtControlProviderMsg.this.mgh.addRow(new Object[]{strArr2[1], Integer.valueOf(1), com.tencent.mm.plugin.ext.a.a.cP(r2)});
                                            ExtControlProviderMsg.this.pI(0);
                                        }
                                    } catch (Throwable e) {
                                        x.w("MicroMsg.ExtControlProviderMsg", e.getMessage());
                                        x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                                        ExtControlProviderMsg.this.pI(4);
                                    }
                                } else {
                                    ExtControlProviderMsg.this.pI(3);
                                }
                            } else {
                                ExtControlProviderMsg.this.pI(4);
                                ExtControlProviderMsg.this.mgh.close();
                                bVar.countDown();
                                return;
                            }
                        }
                        ExtControlProviderMsg.this.pI(4);
                        bVar.countDown();
                        return;
                    }
                    bVar.countDown();
                }
            });
            return this.mgh;
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (this.mgh != null) {
                this.mgh.close();
            }
            pI(4);
            return cursor;
        }
    }

    private Cursor q(String[] strArr) {
        MatrixCursor matrixCursor;
        Throwable e;
        x.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
        if (strArr == null || strArr.length < 2) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            pI(3);
            return null;
        }
        try {
            int intValue = Integer.valueOf(strArr[0]).intValue();
            long Ad = com.tencent.mm.plugin.ext.a.a.Ad(strArr[1]);
            if (Ad <= 0) {
                pI(3);
                return null;
            } else if (intValue == 3) {
                MatrixCursor matrixCursor2 = new MatrixCursor(mgf);
                try {
                    com.tencent.mm.sdk.b.b fiVar = new fi();
                    fiVar.fvs.frh = Ad;
                    com.tencent.mm.sdk.b.a.xmy.m(fiVar);
                    if (fiVar.fvt.fileName == null || fiVar.fvt.fileName.length() <= 0) {
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(2)});
                        pI(4);
                        return matrixCursor2;
                    }
                    com.tencent.mm.sdk.b.b faVar = new fa();
                    faVar.fuO.op = 1;
                    faVar.fuO.fileName = fiVar.fvt.fileName;
                    if (com.tencent.mm.sdk.b.a.xmy.m(faVar)) {
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(1)});
                        pI(0);
                    } else {
                        x.e("MicroMsg.ExtControlProviderMsg", "play failed");
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(2)});
                        pI(4);
                    }
                    b.aGg();
                    b.cO(Ad);
                    return matrixCursor2;
                } catch (Throwable e2) {
                    Throwable th = e2;
                    matrixCursor = matrixCursor2;
                    e = th;
                    x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                    if (matrixCursor != null) {
                        matrixCursor.close();
                    }
                    pI(4);
                    return null;
                }
            } else if (intValue != 4) {
                return null;
            } else {
                com.tencent.mm.sdk.b.b faVar2 = new fa();
                faVar2.fuO.op = 2;
                if (com.tencent.mm.sdk.b.a.xmy.m(faVar2)) {
                    x.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
                    pI(0);
                    return null;
                }
                x.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
                pI(4);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            matrixCursor = null;
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            pI(4);
            return null;
        }
    }

    private Cursor r(String[] strArr) {
        x.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            cw(3, 3801);
            return a.BQ(3801);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                if (strArr[i] == null || strArr[i].length() <= 0) {
                    x.w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = " + i);
                } else {
                    long Ad = com.tencent.mm.plugin.ext.a.a.Ad(strArr[i]);
                    b.aGg();
                    b.cO(Ad);
                }
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                cw(4, 12);
                return a.BQ(12);
            }
        }
        cw(0, 1);
        return a.BQ(1);
    }

    private Cursor s(final String[] strArr) {
        x.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            pI(3);
            return null;
        }
        try {
            long Ad = com.tencent.mm.plugin.ext.a.a.Ad(strArr[0]);
            if (Ad <= 0) {
                pI(3);
                return null;
            }
            b.aGg();
            final com.tencent.mm.k.a cN = b.cN(Ad);
            if (cN == null || ((int) cN.gKO) <= 0) {
                x.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
                pI(3);
                return null;
            }
            this.mgh = new MatrixCursor(mgg);
            final com.tencent.mm.pluginsdk.e.a.b bVar = new com.tencent.mm.pluginsdk.e.a.b();
            bVar.b(15000, new Runnable() {
                public final void run() {
                    com.tencent.mm.sdk.b.b eyVar = new ey();
                    eyVar.fuJ.toUserName = cN.field_username;
                    eyVar.fuJ.content = strArr[1];
                    eyVar.fuJ.type = s.hs(cN.field_username);
                    eyVar.fuJ.flags = 0;
                    if (com.tencent.mm.sdk.b.a.xmy.m(eyVar)) {
                        k kVar = eyVar.fuK.fuL;
                        try {
                            final String cP = com.tencent.mm.plugin.ext.a.a.cP(eyVar.fuK.frh);
                            as.CN().a(522, new e() {
                                /* JADX WARNING: inconsistent code. */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final void a(int r10, int r11, java.lang.String r12, com.tencent.mm.ad.k r13) {
                                    /*
                                    r9 = this;
                                    r8 = 522; // 0x20a float:7.31E-43 double:2.58E-321;
                                    r7 = 4;
                                    r6 = 2;
                                    r5 = 1;
                                    r4 = 0;
                                    r0 = "MicroMsg.ExtControlProviderMsg";
                                    r1 = "onSceneEnd errType=%s, errCode=%s";
                                    r2 = new java.lang.Object[r6];
                                    r3 = java.lang.Integer.valueOf(r10);
                                    r2[r4] = r3;
                                    r3 = java.lang.Integer.valueOf(r11);
                                    r2[r5] = r3;
                                    com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);
                                    if (r13 != 0) goto L_0x003e;
                                L_0x001f:
                                    r0 = "MicroMsg.ExtControlProviderMsg";
                                    r1 = "scene == null";
                                    com.tencent.mm.sdk.platformtools.x.e(r0, r1);
                                    r0 = com.tencent.mm.y.as.CN();
                                    r0.b(r8, r9);
                                    r0 = com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.AnonymousClass2.this;
                                    r0 = com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.this;
                                    r0.pI(r7);
                                    r0 = com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.AnonymousClass2.this;
                                    r0 = r2;
                                    r0.countDown();
                                L_0x003d:
                                    return;
                                L_0x003e:
                                    r0 = r13.getType();
                                    switch(r0) {
                                        case 522: goto L_0x005b;
                                        default: goto L_0x0045;
                                    };
                                L_0x0045:
                                    r0 = com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.AnonymousClass2.this;
                                    r0 = com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.this;
                                    r0.pI(r4);
                                L_0x004c:
                                    r0 = com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.AnonymousClass2.this;
                                    r0 = r2;
                                    r0.countDown();
                                    r0 = com.tencent.mm.y.as.CN();
                                    r0.b(r8, r9);
                                    goto L_0x003d;
                                L_0x005b:
                                    if (r10 != 0) goto L_0x0080;
                                L_0x005d:
                                    if (r11 != 0) goto L_0x0080;
                                L_0x005f:
                                    r0 = "MicroMsg.ExtControlProviderMsg";
                                    r1 = "rtSENDMSG onSceneEnd ok, ";
                                    com.tencent.mm.sdk.platformtools.x.d(r0, r1);
                                    r0 = com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.AnonymousClass2.this;
                                    r0 = com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.this;
                                    r0 = r0.mgh;
                                    r1 = new java.lang.Object[r6];
                                    r2 = r0;
                                    r1[r4] = r2;
                                    r2 = java.lang.Integer.valueOf(r5);
                                    r1[r5] = r2;
                                    r0.addRow(r1);
                                    goto L_0x0045;
                                L_0x0080:
                                    r0 = "MicroMsg.ExtControlProviderMsg";
                                    r1 = new java.lang.StringBuilder;
                                    r2 = "rtSENDMSG onSceneEnd err, errType = ";
                                    r1.<init>(r2);
                                    r1 = r1.append(r10);
                                    r2 = ", errCode = ";
                                    r1 = r1.append(r2);
                                    r1 = r1.append(r11);
                                    r1 = r1.toString();
                                    com.tencent.mm.sdk.platformtools.x.e(r0, r1);
                                    r0 = com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.AnonymousClass2.this;
                                    r0 = com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.this;
                                    r0 = r0.mgh;
                                    r1 = new java.lang.Object[r6];
                                    r2 = r0;
                                    r1[r4] = r2;
                                    r2 = java.lang.Integer.valueOf(r6);
                                    r1[r5] = r2;
                                    r0.addRow(r1);
                                    r0 = com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.AnonymousClass2.this;
                                    r0 = com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.this;
                                    r0.pI(r7);
                                    goto L_0x004c;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.2.1.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
                                }
                            });
                            as.CN().a(kVar, 0);
                            return;
                        } catch (Throwable e) {
                            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                            ExtControlProviderMsg.this.pI(4);
                            bVar.countDown();
                            return;
                        }
                    }
                    ExtControlProviderMsg.this.pI(4);
                    bVar.countDown();
                }
            });
            return this.mgh;
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (this.mgh != null) {
                this.mgh.close();
            }
            pI(4);
            return null;
        }
    }

    private void a(MatrixCursor matrixCursor, au auVar, com.tencent.mm.storage.x xVar, boolean z, String str, boolean z2, String str2) {
        if (auVar != null) {
            if (bi.oN(str2)) {
                x.d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
            } else if (auVar.getType() != 9999 && auVar.getType() != 10000) {
                String str3 = "";
                String str4 = "";
                if (z) {
                    int hR = bb.hR(auVar.field_content);
                    if (hR != -1 && auVar.field_content.length() > hR) {
                        String trim = auVar.field_content.substring(0, hR).trim();
                        if (trim != null && trim.length() > 0 && auVar.field_content.length() >= hR + 2) {
                            str3 = r.gw(trim);
                            str4 = auVar.field_content.substring(hR + 2);
                        }
                    }
                }
                String str5 = "";
                int M = com.tencent.mm.plugin.ext.b.b.M(auVar);
                if (M == 1) {
                    if (z) {
                        str3 = str3 + "!]" + str4;
                    } else {
                        str3 = auVar.field_content;
                    }
                } else if (M == 2) {
                    p iP = m.UK().iP((int) auVar.field_msgId);
                    if (iP == null || iP.fileName == null) {
                        str4 = str5;
                    } else {
                        str4 = q.getFullPath(iP.fileName);
                        x.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", str4);
                    }
                    str3 = str4;
                } else if (!z) {
                    if (this.mga != null) {
                        str3 = this.mga.getString(R.l.eek);
                    } else {
                        str3 = "";
                    }
                }
                if (!z2) {
                    str2 = com.tencent.mm.plugin.ext.a.a.cP((long) ((int) xVar.gKO));
                }
                try {
                    if (bi.oN(str2)) {
                        x.w("MicroMsg.ExtControlProviderMsg", "userId is null");
                        return;
                    }
                    Object[] objArr = new Object[8];
                    objArr[0] = com.tencent.mm.plugin.ext.a.a.cP(auVar.field_msgId);
                    objArr[1] = str2;
                    objArr[2] = str;
                    objArr[3] = Integer.valueOf(auVar.field_isSend == 0 ? 1 : 2);
                    objArr[4] = Integer.valueOf(M);
                    objArr[5] = str3;
                    objArr[6] = Integer.valueOf(auVar.field_status == 4 ? 1 : 2);
                    objArr[7] = Long.valueOf(auVar.field_createTime);
                    matrixCursor.addRow(objArr);
                } catch (Throwable e) {
                    x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                }
            }
        }
    }
}

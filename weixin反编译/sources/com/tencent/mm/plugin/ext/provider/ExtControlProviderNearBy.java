package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.ac.d.a;
import com.tencent.mm.ac.n;
import com.tencent.mm.bx.e;
import com.tencent.mm.f.a.jz;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.protocal.c.aor;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public final class ExtControlProviderNearBy extends ExtContentProviderBase implements a {
    private static final UriMatcher mgv;
    private static boolean mgx = false;
    private static al mgy = new al(new al.a() {
        public final boolean uG() {
            ExtControlProviderNearBy.mgx = false;
            return false;
        }
    }, false);
    private static final String[] tv = new String[]{"nickname", "avatar", "distance", "signature", "sex"};
    private boolean bgN;
    private com.tencent.mm.modelgeo.a.a gAn = new com.tencent.mm.modelgeo.a.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!ExtControlProviderNearBy.this.mgw) {
                ExtControlProviderNearBy.this.mgw = true;
                if (z) {
                    b jzVar = new jz();
                    jzVar.fBV.fvo = ExtControlProviderNearBy.this.mgo;
                    jzVar.fBV.fBX = f;
                    jzVar.fBV.fAo = f2;
                    jzVar.fBV.fBY = (int) d2;
                    jzVar.fBV.fBZ = i;
                    jzVar.fBV.fCa = "";
                    jzVar.fBV.fCb = "";
                    if (com.tencent.mm.sdk.b.a.xmy.m(jzVar)) {
                        x.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
                    }
                } else {
                    x.e("MicroMsg.ExtControlProviderNearBy", "get location failed");
                    ExtControlProviderNearBy.f(ExtControlProviderNearBy.this);
                    ExtControlProviderNearBy.this.mgs.countDown();
                }
            }
            return false;
        }
    };
    private c hry;
    private com.tencent.mm.pluginsdk.d.b lfW = new com.tencent.mm.pluginsdk.d.b() {
        public final void a(int i, int i2, String str, b bVar) {
            if ((bVar instanceof jz) && ExtControlProviderNearBy.this.mgs != null) {
                jz jzVar = (jz) bVar;
                x.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + i2 + ", errType: " + i);
                if (i == 0 && i2 == 0) {
                    ExtControlProviderNearBy.this.mgp = jzVar.fBW.fCd;
                    if (ExtControlProviderNearBy.this.mgp == null || ExtControlProviderNearBy.this.mgp.size() == 0) {
                        x.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend list size:0");
                        ExtControlProviderNearBy.this.mgs.countDown();
                    } else {
                        if (ExtControlProviderNearBy.this.mgp.size() > 10) {
                            x.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend size > 10," + ExtControlProviderNearBy.this.mgp.size());
                            ExtControlProviderNearBy.this.mgp.subList(10, ExtControlProviderNearBy.this.mgp.size()).clear();
                        }
                        ExtControlProviderNearBy.this.mgt = new CountDownLatch(ExtControlProviderNearBy.this.mgp.size());
                        ExtControlProviderNearBy.this.mgs.countDown();
                        ExtControlProviderNearBy.e(ExtControlProviderNearBy.this);
                    }
                } else {
                    x.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend failed: errCode = " + i2 + ", errType=" + i);
                    ExtControlProviderNearBy.this.mgs.countDown();
                }
                ExtControlProviderNearBy.f(ExtControlProviderNearBy.this);
            }
        }
    };
    private int mgo;
    private List<aor> mgp;
    private e mgq;
    private Set<String> mgr;
    private CountDownLatch mgs;
    private CountDownLatch mgt;
    private aor mgu;
    private boolean mgw = false;

    static /* synthetic */ void e(ExtControlProviderNearBy extControlProviderNearBy) {
        n.JF().a((a) extControlProviderNearBy);
        if (extControlProviderNearBy.mgq == null) {
            extControlProviderNearBy.mgq = new e(tv, (byte) 0);
        }
        for (aor a : extControlProviderNearBy.mgp) {
            extControlProviderNearBy.a(a);
        }
        extControlProviderNearBy.mgt.countDown();
    }

    static /* synthetic */ void f(ExtControlProviderNearBy extControlProviderNearBy) {
        boolean z = true;
        x.v("MicroMsg.ExtControlProviderNearBy", "stop()");
        if (as.Hp()) {
            com.tencent.mm.pluginsdk.d.b.b(jz.class.getName(), extControlProviderNearBy.lfW);
            String str = "MicroMsg.ExtControlProviderNearBy";
            String str2 = "releaseLbsManager(), lbsManager == null ? [%s]";
            Object[] objArr = new Object[1];
            if (extControlProviderNearBy.hry != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.v(str, str2, objArr);
            if (extControlProviderNearBy.hry != null) {
                extControlProviderNearBy.hry.c(extControlProviderNearBy.gAn);
                return;
            }
            return;
        }
        x.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        mgv = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.NearBy", "male", 1);
        mgv.addURI("com.tencent.mm.plugin.ext.NearBy", "female", 2);
        mgv.addURI("com.tencent.mm.plugin.ext.NearBy", "all", 0);
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
        return true;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlProviderNearBy", "query() " + uri);
        a(uri, getContext(), 15);
        if (uri == null) {
            pI(3);
            return null;
        } else if (bi.oN(this.mfS) || bi.oN(aGt())) {
            pI(3);
            return null;
        } else if (mgx) {
            x.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
            pI(5);
            return null;
        } else {
            cw(true);
            if (!arF()) {
                cw(false);
                pI(1);
                return this.kAL;
            } else if (cA(getContext())) {
                x.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.mgo);
                getType(uri);
                if (this.mgo < 0) {
                    x.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
                    cw(false);
                    pI(3);
                    return null;
                }
                try {
                    this.mgp = new ArrayList();
                    this.mgq = new e(tv, (byte) 0);
                    this.mgs = new CountDownLatch(1);
                    this.mgt = null;
                    this.mgr = new HashSet();
                    this.mgp = new ArrayList();
                    this.bgN = false;
                    x.v("MicroMsg.ExtControlProviderNearBy", "start()");
                    if (as.Hp()) {
                        com.tencent.mm.pluginsdk.d.b.a(jz.class.getName(), this.lfW);
                        ah.y(new Runnable() {
                            public final void run() {
                                if (ExtControlProviderNearBy.this.hry == null) {
                                    ExtControlProviderNearBy.this.hry = c.OV();
                                }
                                ExtControlProviderNearBy.this.hry.a(ExtControlProviderNearBy.this.gAn, true);
                            }
                        });
                    } else {
                        x.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
                    }
                    x.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
                    if (!this.mgs.await(15000, TimeUnit.MILLISECONDS)) {
                        x.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
                    }
                    if (this.mgt != null) {
                        x.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
                        if (!this.mgt.await(15000, TimeUnit.MILLISECONDS)) {
                            x.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
                        }
                    } else {
                        x.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
                    }
                } catch (Throwable e) {
                    x.w("MicroMsg.ExtControlProviderNearBy", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", e, "", new Object[0]);
                    pI(4);
                }
                cw(false);
                n.JF().b(this);
                this.bgN = true;
                aGx();
                if (this.mgq == null || this.mgq.getCount() <= 0) {
                    pI(4);
                } else {
                    pI(0);
                }
                x.i("MicroMsg.ExtControlProviderNearBy", "return now");
                return this.mgq;
            } else {
                x.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
                cw(false);
                pI(2);
                return null;
            }
        }
    }

    private aor Af(String str) {
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
            return null;
        }
        for (aor aor : this.mgp) {
            if (aor.kyG.equals(str)) {
                return aor;
            }
        }
        return null;
    }

    private void a(aor aor) {
        if (aor == null || aor.kyG == null) {
            x.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
            return;
        }
        this.mgr.add(aor.kyG);
        Bitmap a = com.tencent.mm.ac.b.a(aor.kyG, false, -1);
        x.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.mgt.getCount());
        if (a != null) {
            x.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[0];
            if (a.compress(CompressFormat.PNG, 100, byteArrayOutputStream)) {
                bArr = byteArrayOutputStream.toByteArray();
            }
            this.mgr.remove(aor.kyG);
            this.mgq.addRow(new Object[]{aor.kzN, bArr, aor.wCp, aor.hxh, Integer.valueOf(aor.hxe)});
            x.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", a);
            a.recycle();
        }
    }

    public final void jk(String str) {
        x.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: " + str);
        if (this.bgN) {
            x.i("MicroMsg.ExtControlProviderNearBy", "has finished");
            return;
        }
        a(Af(str));
        this.mgt.countDown();
    }

    private void aGx() {
        if (this.mgr.size() > 0) {
            for (String str : this.mgr) {
                x.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: " + str);
                this.mgu = Af(str);
                if (!(this.mgu == null || this.mgu.kyG == null)) {
                    this.mgq.addRow(new Object[]{this.mgu.kzN, null, this.mgu.wCp, this.mgu.hxh, Integer.valueOf(this.mgu.hxe)});
                }
            }
            return;
        }
        x.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
    }

    public final String getType(Uri uri) {
        this.mgo = -1;
        switch (mgv.match(uri)) {
            case 0:
                this.mgo = 1;
                break;
            case 1:
                this.mgo = 3;
                break;
            case 2:
                this.mgo = 4;
                break;
            default:
                this.mgo = -1;
                break;
        }
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

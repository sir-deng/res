package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.ac.n;
import com.tencent.mm.bx.e;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.ext.a.a;
import com.tencent.mm.pluginsdk.e.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderSearchContact extends ExtContentProviderBase {
    private static List<String> koG = new ArrayList();
    private static final String[] mgA = new String[]{"userId", "nickname", "avatar", "content", "msgId", "msgType"};
    private Cursor mgE = null;

    static {
        int i = 0;
        String[] strArr = s.hhb;
        int length = strArr.length;
        while (i < length) {
            koG.add(strArr[i]);
            i++;
        }
        koG.add("officialaccounts");
        koG.add("helper_entry");
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.d("MicroMsg.ExtControlProviderSearchContact", "query()");
        a(uri, getContext(), 16);
        if (uri == null) {
            pI(3);
            return null;
        } else if (bi.oN(this.mfS) || bi.oN(aGt())) {
            pI(3);
            return null;
        } else if (!arF()) {
            pI(1);
            return this.kAL;
        } else if (!cA(getContext())) {
            x.w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
            pI(2);
            return null;
        } else if (strArr2 == null || strArr2.length == 0) {
            x.e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
            pI(3);
            return null;
        } else {
            String trim = strArr2[0].trim();
            if (bi.oN(trim)) {
                x.e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
                pI(3);
                return null;
            }
            final Cursor a = as.Hm().hgl.a(trim, "@micromsg.no.verify.biz.qq.com", null, koG, false, false, false, 1, null);
            if (a == null) {
                x.e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
                pI(3);
                return null;
            }
            final b bVar = new b();
            bVar.b(4000, new Runnable() {
                public final void run() {
                    ExtControlProviderSearchContact.this.mgE = ExtControlProviderSearchContact.e(a);
                    bVar.countDown();
                }
            });
            if (this.mgE != null) {
                pI(0);
            } else {
                pI(4);
            }
            return this.mgE;
        }
    }

    public static Cursor e(Cursor cursor) {
        Object eVar = new e(mgA, (byte) 0);
        try {
            if (cursor.moveToFirst()) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    ag xVar = new com.tencent.mm.storage.x();
                    xVar.b(cursor);
                    if (!s.eX(xVar.field_username)) {
                        ByteArrayOutputStream byteArrayOutputStream;
                        Bitmap b = n.JY().b(xVar.field_username, true, 0);
                        if (b != null) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            b.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        } else {
                            x.w("MicroMsg.ExtControlProviderSearchContact", "get useravatar is null");
                            byteArrayOutputStream = null;
                        }
                        as.Hm();
                        au[] bH = c.Fh().bH(xVar.field_username, 1);
                        byte[] bArr;
                        if (bH == null || bH.length != 1) {
                            x.w("MicroMsg.ExtControlProviderSearchContact", "get msginfo failed");
                            Object[] objArr = new Object[6];
                            objArr[0] = a.cP((long) ((int) xVar.gKO));
                            objArr[1] = xVar.AX();
                            if (byteArrayOutputStream == null) {
                                bArr = null;
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                            }
                            objArr[2] = bArr;
                            objArr[3] = "";
                            objArr[4] = "0";
                            objArr[5] = Integer.valueOf(0);
                            eVar.addRow(objArr);
                        } else {
                            Object[] objArr2 = new Object[6];
                            objArr2[0] = a.cP((long) ((int) xVar.gKO));
                            objArr2[1] = xVar.AX();
                            if (byteArrayOutputStream == null) {
                                bArr = null;
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                            }
                            objArr2[2] = bArr;
                            objArr2[3] = bH[0].getType() == 1 ? bH[0].field_content : "";
                            objArr2[4] = a.cP(bH[0].field_msgId);
                            objArr2[5] = Integer.valueOf(com.tencent.mm.plugin.ext.b.b.M(bH[0]));
                            eVar.addRow(objArr2);
                        }
                    }
                    if (!cursor.moveToNext() || i2 >= 15) {
                        break;
                    }
                    i = i2;
                }
            }
            cursor.close();
            return eVar;
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderSearchContact", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderSearchContact", e, "", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
            eVar.close();
            return null;
        }
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
}

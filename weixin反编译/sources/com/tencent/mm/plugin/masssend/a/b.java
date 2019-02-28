package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.bx.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class b extends j {
    public static final String[] gLy = new String[]{"CREATE TABLE IF NOT EXISTS massendinfo ( clientid text  PRIMARY KEY , status int  , createtime long  , lastmodifytime long  , filename text  , thumbfilename text  , tolist text  , tolistcount int  , msgtype int  , mediatime int  , datanetoffset int  , datalen int  , thumbnetoffset int  , thumbtotallen int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  massendinfostatus_index ON massendinfo ( status )"};
    public h hiZ;

    public b(h hVar) {
        this.hiZ = hVar;
    }

    public static Bitmap a(String str, float f) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        Bitmap b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(stringBuilder.append(c.Fp()).append(trim).toString(), f);
        if (b != null) {
            return Bitmap.createScaledBitmap(b, (int) (((float) b.getWidth()) * f), (int) (((float) b.getHeight()) * f), true);
        }
        return b;
    }

    public static Bitmap EJ(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return com.tencent.mm.platformtools.j.oH(stringBuilder.append(c.Fp()).append(trim).toString());
    }

    public static a j(String str, String str2, int i, int i2) {
        if (!e.bO(str)) {
            return null;
        }
        as.Hm();
        String Fp = c.Fp();
        int Vo = ExifHelper.Vo(str);
        String s = g.s((str + System.currentTimeMillis()).getBytes());
        x.d("MicroMsg.MasSendInfoStorage", "insert : original img path = " + str);
        Options Vq = d.Vq(str);
        if (i2 != 0 || (e.bN(str) <= 204800 && (Vq == null || (Vq.outHeight <= 960 && Vq.outWidth <= 960)))) {
            e.a(Fp, s, ".jpg", e.d(str, 0, e.bN(str)));
        } else {
            if (!d.a(str, 960, 960, CompressFormat.JPEG, 70, Fp, s)) {
                return null;
            }
            e.g(Fp, s, s + ".jpg");
        }
        String str3 = s + ".jpg";
        x.d("MicroMsg.MasSendInfoStorage", "insert: compressed bigImgPath = " + str3);
        if (i2 == 0 && Vo != 0 && !d.a(Fp + str3, Vo, CompressFormat.JPEG, Fp, s + ".jpg")) {
            return null;
        }
        s = g.s((str3 + System.currentTimeMillis()).getBytes());
        if (!d.a(Fp + str3, 120, 120, CompressFormat.JPEG, 90, Fp, s)) {
            return null;
        }
        x.d("MicroMsg.MasSendInfoStorage", "insert: thumbName = " + s);
        a aVar = new a();
        aVar.msgType = 3;
        aVar.oss = str2;
        aVar.ost = i;
        aVar.osr = s;
        aVar.filename = str3;
        return aVar;
    }

    public static String a(a aVar) {
        switch (aVar.msgType) {
            case 1:
                return aVar.aZc();
            case 3:
                return ad.getContext().getResources().getString(R.l.dGu);
            case 34:
                return ad.getContext().getResources().getString(R.l.dHj);
            case org.xwalk.core.R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                return ad.getContext().getResources().getString(R.l.dHi);
            default:
                return ad.getContext().getResources().getString(R.l.dVM);
        }
    }

    public final a EK(String str) {
        a aVar = null;
        Cursor a = this.hiZ.a("select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   where massendinfo.clientid = \"" + bi.oL(str) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                aVar = new a();
                aVar.b(a);
            }
            a.close();
        }
        return aVar;
    }
}

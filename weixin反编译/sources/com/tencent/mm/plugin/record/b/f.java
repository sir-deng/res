package com.tencent.mm.plugin.record.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class f {
    private HashMap<String, String[]> mxf = new HashMap();
    public com.tencent.mm.a.f<String, Bitmap> mxh = new com.tencent.mm.a.f(10);
    public g pKZ = new g() {
        protected final i i(String str, String str2, int i, int i2) {
            return new j(str, str2, i, i2);
        }
    };
    private HashSet<String> pLa = new HashSet();
    private HashMap<String, a> pLb = new HashMap();

    public final void destory() {
        this.pKZ.destory();
        this.mxf.clear();
        this.pLa.clear();
        this.pKZ = null;
        this.mxf = null;
        this.pLa = null;
    }

    public final boolean a(uz uzVar, long j) {
        String d = h.d(uzVar.mBr, j, true);
        a aVar = (a) this.pLb.get(d);
        if (aVar == null) {
            this.pLb.put(d, new a());
            return true;
        } else if (aVar.zp() <= 30000) {
            return false;
        } else {
            aVar.gJu = SystemClock.elapsedRealtime();
            return true;
        }
    }

    public final Bitmap a(uz uzVar, long j, boolean z, boolean z2) {
        if (!com.tencent.mm.compatible.util.f.zl()) {
            return BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.bEj);
        }
        String f;
        if (z) {
            f = h.f(uzVar, j);
        } else {
            f = h.c(uzVar, j);
        }
        if (bi.oN(f) || !e.bO(f)) {
            x.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", Boolean.valueOf(z), f);
            return null;
        }
        Bitmap bitmap = (Bitmap) this.mxh.get(f);
        if (bitmap != null) {
            return bitmap;
        }
        int i;
        int i2;
        x.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", f);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        bitmap = BitmapFactory.decodeFile(f, options);
        if (bitmap != null) {
            x.i("MicroMsg.RecordMsgImgService", "bitmap recycled %s", bitmap);
            bitmap.recycle();
        }
        Object obj = (!z.bt(options.outWidth, options.outHeight) || options.outWidth <= 480) ? null : 1;
        Object obj2 = (!z.bs(options.outWidth, options.outHeight) || options.outHeight <= 480) ? null : 1;
        if (obj == null && obj2 == null) {
            i = 960;
            i2 = 960;
        } else {
            i = options.outHeight;
            i2 = options.outWidth;
        }
        int Vo = ExifHelper.Vo(f);
        if (Vo == 90 || Vo == 270) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        bitmap = d.d(f, i, i2, false);
        if (bitmap == null) {
            x.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = " + f);
            return null;
        }
        bitmap = d.b(bitmap, (float) Vo);
        this.mxh.put(f, bitmap);
        return bitmap;
    }

    public final Bitmap b(uz uzVar, long j) {
        Bitmap a = a(uzVar, j, true, false);
        if (a == null) {
            x.d("MicroMsg.RecordMsgImgService", "get thumb fail, try download, can retry:%B", Boolean.valueOf(a(uzVar, j)));
            h.b(uzVar, j, r1);
        }
        return a;
    }

    public final void a(ImageView imageView, uz uzVar, long j, String str, int i, int i2, int i3) {
        String str2 = h.AH(uzVar.mBr) + "@" + String.valueOf(j);
        if (uzVar.mBr != null) {
            String[] strArr;
            String[] strArr2 = (String[]) this.mxf.get(str2);
            if (strArr2 == null || strArr2.length <= 0) {
                strArr = new String[]{h.f(uzVar, j)};
                this.mxf.put(str2, strArr);
            } else {
                strArr = strArr2;
            }
            this.pKZ.a(imageView, strArr, str, i, i2, i3);
            if (!this.pLa.contains(str2)) {
                this.pLa.add(str2);
                if (!new File(strArr[0]).exists() && !bi.oN(uzVar.hcU)) {
                    h.b(uzVar, j, a(uzVar, j));
                }
            }
        }
    }
}

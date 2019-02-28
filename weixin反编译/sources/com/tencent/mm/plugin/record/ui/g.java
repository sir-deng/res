package com.tencent.mm.plugin.record.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends f implements a {
    public final void a(a.a aVar) {
        String str = null;
        ImageView imageView = aVar.fwa;
        uz uzVar = aVar.fvZ;
        long j = aVar.pLM;
        int i = aVar.fwb;
        int i2 = aVar.width;
        int i3 = aVar.height;
        if (imageView != null) {
            if (!com.tencent.mm.compatible.util.f.zl()) {
                imageView.setImageResource(R.g.bEj);
            } else if (uzVar == null) {
                imageView.setImageResource(i);
            } else {
                vm vmVar;
                switch (uzVar.bjS) {
                    case 4:
                    case 15:
                        super.a(imageView, uzVar, j, uzVar.fra, i, i2, i3);
                        return;
                    case 5:
                        wc wcVar;
                        if (uzVar.wkH != null) {
                            wcVar = uzVar.wkH.wlf;
                        } else {
                            x.w("MicroMsg.RecordMsgImgService", "webpage: get data proto item null, dataid[%s]", uzVar.mBr);
                            wcVar = null;
                        }
                        if (wcVar != null) {
                            str = wcVar.thumbUrl;
                        }
                        super.a(imageView, uzVar, j, bi.oN(str) ? uzVar.fra : str, i, i2, i3);
                        return;
                    case 7:
                        super.a(imageView, uzVar, j, uzVar.fra, i, i2, i3);
                        return;
                    case 10:
                        if (uzVar.wkH == null) {
                            x.w("MicroMsg.RecordMsgImgService", "good: get data proto item null, dataid[%s]", uzVar.mBr);
                            return;
                        }
                        vmVar = uzVar.wkH.wlh;
                        if (vmVar != null) {
                            this.pKZ.a(imageView, null, vmVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 11:
                        if (uzVar.wkH == null) {
                            x.w("MicroMsg.RecordMsgImgService", "product: get data proto item null, dataid[%s]", uzVar.mBr);
                            return;
                        }
                        vmVar = uzVar.wkH.wlh;
                        if (vmVar != null) {
                            this.pKZ.a(imageView, null, vmVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 14:
                        if (uzVar.wkH == null) {
                            x.w("MicroMsg.RecordMsgImgService", "tv: get data proto item null, dataid[%s]", uzVar.mBr);
                            return;
                        }
                        vw vwVar = uzVar.wkH.wlj;
                        if (vwVar != null) {
                            this.pKZ.a(imageView, null, vwVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    default:
                        x.w("MicroMsg.RecordMsgImgService", "attach thumb, pass data type is %d", Integer.valueOf(uzVar.bjS));
                        return;
                }
            }
        }
    }

    public final Bitmap a(c cVar) {
        return super.b(cVar.fvZ, cVar.pLM);
    }

    public final Bitmap a(b bVar) {
        Bitmap bitmap;
        uz uzVar = bVar.fvZ;
        long j = bVar.pLM;
        boolean z = bVar.fwc;
        int i = bVar.maxWidth;
        if (com.tencent.mm.compatible.util.f.zl()) {
            String c = h.c(uzVar, j);
            if (bi.oN(c) || !e.bO(c)) {
                x.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", Boolean.valueOf(false), c);
                bitmap = null;
            } else {
                bitmap = (Bitmap) this.mxh.get(c);
                if (bitmap != null) {
                    x.d("MicroMsg.RecordMsgImgService", "get bm from cache %s", c);
                } else if (z) {
                    bitmap = null;
                } else {
                    x.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", c);
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    bitmap = BitmapFactory.decodeFile(c, options);
                    if (bitmap != null) {
                        x.i("MicroMsg.RecordMsgImgService", "bitmap recycle %s", bitmap);
                        bitmap.recycle();
                    }
                    int i2 = options.outHeight;
                    int i3 = options.outWidth;
                    x.d("MicroMsg.RecordMsgImgService", "width: %s, height: %s", Integer.valueOf(i3), Integer.valueOf(i2));
                    if (i3 > i) {
                        i2 = (options.outHeight * i) / options.outWidth;
                        i3 = i;
                    }
                    i3 = Math.max(1, i3);
                    i2 = Math.max(1, i2);
                    if (i3 > i) {
                        i2 = (options.outHeight * i) / options.outWidth;
                    } else {
                        i = i3;
                    }
                    i3 = ExifHelper.Vo(c);
                    if (i3 == 90 || i3 == 270) {
                        int i4 = i;
                        i = i2;
                        i2 = i4;
                    }
                    bitmap = d.d(c, i2, i, false);
                    if (bitmap == null) {
                        x.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = " + c);
                        bitmap = null;
                    } else {
                        bitmap = d.b(bitmap, (float) i3);
                        this.mxh.put(c, bitmap);
                    }
                }
            }
        } else {
            bitmap = BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.bEj);
        }
        if (bitmap == null && !z) {
            x.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", Boolean.valueOf(super.a(uzVar, j)));
            h.a(uzVar, j, r3);
        }
        return bitmap;
    }

    public final void bnB() {
        super.destory();
    }
}

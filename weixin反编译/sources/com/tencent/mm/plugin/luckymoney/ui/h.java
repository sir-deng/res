package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class h {
    private static final Drawable opr = new ColorDrawable();
    private Activity activity;
    private String imagePath;
    private q opq;
    private GetHdHeadImageGalleryView ops;
    private int opt;
    private int opu;
    private String username;

    public enum a {
        ;

        static {
            opw = 1;
            opx = 2;
            opy = 3;
            opz = new int[]{opw, opx, opy};
        }
    }

    static /* synthetic */ void a(h hVar) {
        List arrayList = new ArrayList();
        arrayList.add(hVar.activity.getString(i.eET));
        arrayList.add(hVar.activity.getString(i.eHt));
        arrayList.add(hVar.activity.getString(i.eAq));
        com.tencent.mm.ui.base.h.a(hVar.activity, null, (String[]) arrayList.toArray(new String[arrayList.size()]), "", new c() {
            public final void jo(int i) {
                String b;
                switch (i) {
                    case 0:
                        x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "shareImgToFriend");
                        b = h.this.imagePath;
                        Context c = h.this.activity;
                        if (bi.oN(b)) {
                            x.w("MicroMsg.LuckyMoneyApplication", "share image to friend fail, imgPath is null");
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("Retr_File_Name", b);
                            intent.putExtra("Retr_Compress_Type", 0);
                            intent.putExtra("Retr_Msg_Type", 0);
                            com.tencent.mm.plugin.luckymoney.a.ihN.l(intent, c);
                        }
                        if (h.this.opu == 1) {
                            g.pWK.h(13079, Integer.valueOf(8), Integer.valueOf(1));
                            return;
                        }
                        g.pWK.h(13079, Integer.valueOf(8), Integer.valueOf(2));
                        return;
                    case 1:
                        x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "saveImg");
                        b = h.this.imagePath;
                        CharSequence string = h.this.activity.getString(i.uRl);
                        Context c2 = h.this.activity;
                        if (bi.oN(b)) {
                            x.w("MicroMsg.LuckyMoneyApplication", "save image fail, path is null");
                        } else if (!d.a(b, c2, i.uXH)) {
                            Toast.makeText(c2, string, 1).show();
                        }
                        if (h.this.opu == 1) {
                            g.pWK.h(13079, Integer.valueOf(9), Integer.valueOf(1));
                            return;
                        }
                        g.pWK.h(13079, Integer.valueOf(9), Integer.valueOf(2));
                        return;
                    case 2:
                        x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "doFav");
                        h.e(h.this);
                        if (h.this.opu == 1) {
                            g.pWK.h(13079, Integer.valueOf(10), Integer.valueOf(1));
                            return;
                        }
                        g.pWK.h(13079, Integer.valueOf(10), Integer.valueOf(2));
                        return;
                    default:
                        return;
                }
            }
        });
    }

    static /* synthetic */ void e(h hVar) {
        b cgVar = new cg();
        vn vnVar = new vn();
        uz uzVar = new uz();
        uzVar.Dc(2);
        uzVar.Uj(hVar.imagePath);
        LinkedList linkedList = new LinkedList();
        linkedList.add(uzVar);
        vnVar.aw(linkedList);
        cgVar.frk.frm = vnVar;
        cgVar.frk.type = 2;
        cgVar.frk.activity = hVar.activity;
        cgVar.frk.frr = 2;
        com.tencent.mm.sdk.b.a.xmy.m(cgVar);
    }

    public h(Activity activity, String str, String str2) {
        this(activity, str, str2, a.opw);
    }

    private h(Activity activity, String str, String str2, int i) {
        this.opu = 1;
        this.activity = activity;
        this.username = str;
        this.imagePath = str2;
        this.opt = i;
    }

    public final void n(boolean z, int i) {
        x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "previewImg readImgFromCache:" + z + ", sceneFromUI:" + i);
        View inflate = LayoutInflater.from(this.activity).inflate(com.tencent.mm.plugin.wxpay.a.g.uLA, null);
        this.opq = new q(inflate, -1, -1);
        this.opq.setFocusable(true);
        this.opq.setOutsideTouchable(true);
        this.opq.setBackgroundDrawable(opr);
        this.opq.showAtLocation(this.activity.getWindow().getDecorView(), 49, 0, 0);
        this.ops = (GetHdHeadImageGalleryView) inflate.findViewById(f.ckv);
        this.ops.vqp = this.opq;
        this.ops.username = this.username;
        this.ops.qnu = this.imagePath;
        this.opu = i;
        com.tencent.mm.kernel.g.Dr();
        Bitmap aq;
        if (com.tencent.mm.kernel.g.Dq().isSDCardAvailable()) {
            aq = n.aq(this.imagePath, z);
            if (aq == null || aq.isRecycled()) {
                x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "The image of %s is not in the cache, use default avatar", this.username);
            } else {
                x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "The image of %s is in the cache", this.username);
                this.ops.N(aq);
            }
            this.ops.zuk = new MMGestureGallery.c() {
                public final void aJP() {
                    h.a(h.this);
                }
            };
            return;
        }
        x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "previewImg sdcard is not available!");
        u.fJ(this.activity);
        aq = BitmapFactory.decodeResource(ad.getContext().getResources(), e.bEj);
        try {
            Bitmap bitmap;
            if (aq.getWidth() >= 480 || aq.getWidth() <= 0) {
                bitmap = aq;
            } else {
                float width = 480.0f / ((float) aq.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                bitmap = Bitmap.createBitmap(aq, 0, 0, aq.getWidth(), aq.getHeight(), matrix, true);
            }
            x.d("MicroMsg.LuckyMoneyPreviewImgGallaryView", "dkhdbm old[%d %d] new[%d %d]", Integer.valueOf(aq.getWidth()), Integer.valueOf(aq.getHeight()), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            this.ops.N(bitmap);
            this.ops.qnu = null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LuckyMoneyPreviewImgGallaryView", e, "", new Object[0]);
        }
    }
}

package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.q;

public final class c implements h {
    private Bitmap bitmap = null;
    private View contentView = null;
    private Context context;
    private ImageView fzb = null;
    private ProgressBar fzd = null;
    private View oaV;
    private TextView rLK = null;
    private TextView rLL = null;
    private View rts;
    q vyf;
    public boolean vyg = true;
    private long yel = 10000;
    private ImageView yem = null;
    private String yen = null;
    private boolean yeo = false;
    private boolean yep = false;
    public a yeq;
    ag yer = null;

    public interface a {
        void cpr();
    }

    static /* synthetic */ void a(c cVar) {
        if (cVar.fzb == null || cVar.vyf == null || cVar.rts == null || cVar.oaV == null) {
            x.e("MicroMsg.AppBrandServiceImageBubble", "these references include null reference");
            return;
        }
        int i;
        if (cVar.bitmap != null) {
            x.d("MicroMsg.AppBrandServiceImageBubble", "bitmap is null,return");
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 == 0) {
            cVar.Js();
        } else {
            cVar.j(cVar.bitmap);
        }
        i2 = cVar.vyg ? 83 : 85;
        int i3 = cVar.vyg ? 0 : 10;
        int aQ = j.aQ(cVar.context);
        int height = cVar.oaV.getHeight();
        if (cVar.yep && height < aQ) {
            height += aQ;
        }
        if (VERSION.SDK_INT >= 21) {
            Rect cot = ae.cot();
            i3 = cVar.vyg ? 0 : i3 + cot.right;
            height += cot.bottom;
            x.i("MicroMsg.AppBrandServiceImageBubble", "bubble navbar height %s %s", Integer.valueOf(cot.right), Integer.valueOf(cot.bottom));
        }
        cVar.vyf.showAtLocation(cVar.rts, i2, i3, height);
        if (cVar.yel > 0) {
            al alVar = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    c cVar = c.this;
                    x.d("MicroMsg.AppBrandServiceImageBubble", "hide");
                    if (cVar.vyf != null) {
                        cVar.vyf.dismiss();
                    }
                    return false;
                }
            }, false);
            long j = cVar.yel;
            alVar.K(j, j);
        }
    }

    public final void Js() {
        x.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
        this.fzd.setVisibility(0);
        this.fzb.setVisibility(8);
        this.yem.setVisibility(8);
    }

    public final void j(Bitmap bitmap) {
        x.d("MicroMsg.AppBrandServiceImageBubble", "onBitmapLoaded");
        if (bitmap == null) {
            x.w("MicroMsg.AppBrandServiceImageBubble", "bitmap is null");
            return;
        }
        this.bitmap = bitmap;
        this.fzd.setVisibility(8);
        if (bitmap == null || bitmap.isRecycled()) {
            this.yem.setVisibility(0);
            this.fzb.setVisibility(8);
            return;
        }
        this.fzb.setVisibility(0);
        this.fzb.setImageBitmap(bitmap);
        this.yem.setVisibility(8);
    }

    public final void Jt() {
        x.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
        this.yem.setVisibility(0);
        this.fzd.setVisibility(8);
        this.fzb.setVisibility(8);
    }

    public final String Ju() {
        return k.bj(this);
    }

    public c(Context context, View view, View view2, boolean z) {
        this.context = context;
        this.rts = view;
        this.oaV = view2;
        this.yep = z;
        this.contentView = View.inflate(this.context, R.i.ddf, null);
        this.rLK = (TextView) this.contentView.findViewById(R.h.cpA);
        this.rLL = (TextView) this.contentView.findViewById(R.h.cpB);
        this.fzb = (ImageView) this.contentView.findViewById(R.h.cpm);
        this.yem = (ImageView) this.contentView.findViewById(R.h.ceP);
        this.fzd = (ProgressBar) this.contentView.findViewById(R.h.cpw);
        this.vyf = new q(this.contentView, -2, -2, true);
        this.vyf.setBackgroundDrawable(new ColorDrawable(0));
        this.vyf.setOutsideTouchable(true);
        this.vyf.setFocusable(false);
        this.contentView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (c.this.yeq != null) {
                    c.this.yeq.cpr();
                }
                c.this.vyf.dismiss();
            }
        });
        this.yer = new ag(this.context.getMainLooper()) {
            public final void handleMessage(Message message) {
                c.a(c.this);
            }
        };
    }
}

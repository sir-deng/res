package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a.a;
import com.tencent.mm.y.bb;
import java.lang.ref.WeakReference;

public class m extends ClickableSpan implements a {
    private WeakReference<View> fq = null;
    String iNG;
    private int jmw;
    boolean mEnable = true;
    public boolean oFf = false;
    private Context vBM = null;
    private int vBR;
    g vBS = null;
    private k vBT = null;

    public m(int i, k kVar) {
        int i2;
        int i3 = 0;
        if (kVar != null) {
            i2 = kVar.linkColor;
            i3 = kVar.backgroundColor;
        } else {
            i2 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            zJ(i);
        } else {
            eD(i2, i3);
        }
        this.vBS = new g();
        this.vBT = kVar;
    }

    public void zJ(int i) {
        Context context = ad.getContext();
        switch (i) {
            case 1:
                eD(context.getResources().getColor(b.lts), -5908174);
                return;
            case 2:
                eD(context.getResources().getColor(b.btd), context.getResources().getColor(b.ltt));
                return;
            case 3:
                eD(context.getResources().getColor(b.ltu), context.getResources().getColor(b.ltt));
                return;
            default:
                return;
        }
    }

    public final void eD(int i, int i2) {
        this.vBR = i;
        this.jmw = i2;
    }

    public final void lv(boolean z) {
        this.oFf = z;
    }

    public final int getType() {
        return this.vBT == null ? Integer.MAX_VALUE : this.vBT.type;
    }

    public void onClick(View view) {
        if (this.vBS != null && this.vBT != null && this.mEnable) {
            this.vBS.mContext = this.vBM != null ? this.vBM : view.getContext();
            g gVar = this.vBS;
            k kVar = this.vBT;
            if (System.currentTimeMillis() - gVar.sPv <= ((long) gVar.sPu)) {
                x.e("MicroMsg.MMSpanClickListener", "process pass");
            } else {
                gVar.sPv = System.currentTimeMillis();
                if (kVar == null) {
                    x.e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
                } else {
                    x.d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", Integer.valueOf(kVar.type));
                    if (gVar.mContext == null) {
                        x.e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
                    } else {
                        f fVar;
                        String str;
                        if (i.vBt == null || i.vBt.size() <= 0) {
                            fVar = null;
                        } else {
                            int size = i.vBt.size();
                            f fVar2 = (f) i.vBt.getLast();
                            x.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", Integer.valueOf(size));
                            fVar = fVar2;
                        }
                        if (view != null && (view.getTag() instanceof c)) {
                            cg cgVar = ((c) view.getTag()).fFE;
                            if (cgVar != null) {
                                str = cgVar.field_talker;
                                if (str.endsWith("@chatroom")) {
                                    str = bb.hS(cgVar.field_content);
                                }
                                kVar.username = str;
                                if (!TextUtils.isEmpty(gVar.iNG)) {
                                    kVar.iNG = gVar.iNG;
                                }
                                b.a.vAZ.a(gVar.mContext, kVar, fVar);
                                kVar.iNG = null;
                            }
                        }
                        str = null;
                        kVar.username = str;
                        if (TextUtils.isEmpty(gVar.iNG)) {
                            kVar.iNG = gVar.iNG;
                        }
                        b.a.vAZ.a(gVar.mContext, kVar, fVar);
                        kVar.iNG = null;
                    }
                }
            }
            this.vBS.mContext = null;
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.vBR);
        textPaint.setUnderlineText(false);
        textPaint.linkColor = this.vBR;
        if (this.oFf) {
            textPaint.bgColor = this.jmw;
        } else {
            textPaint.bgColor = 0;
        }
    }

    public final void setContext(Context context) {
        this.vBM = context;
        this.vBS.mContext = context;
    }
}

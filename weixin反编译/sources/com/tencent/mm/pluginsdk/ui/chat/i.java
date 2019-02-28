package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;

public final class i {
    Bitmap bitmap = null;
    private View contentView = null;
    Context context;
    ImageView fzb = null;
    SharedPreferences hbz;
    View oaV;
    View rts;
    private h vyd;
    g vye;
    q vyf;
    boolean vyg = true;
    com.tencent.mm.pluginsdk.ui.chat.h.a vyh;
    a vyi;

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.i$2 */
    class AnonymousClass2 extends ag {
        AnonymousClass2(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            i iVar = i.this;
            if (iVar.fzb != null && iVar.vye != null && iVar.bitmap != null && iVar.vyf != null && iVar.rts != null && iVar.oaV != null) {
                iVar.fzb.setImageBitmap(iVar.bitmap);
                int i = iVar.vyg ? 83 : 85;
                int i2 = iVar.vyg ? 0 : 10;
                int ccJ = iVar.vyh != null ? iVar.vyh.ccJ() : iVar.oaV.getHeight();
                if (VERSION.SDK_INT >= 21) {
                    Rect cot = ae.cot();
                    i2 = iVar.vyg ? 0 : i2 + cot.right;
                    ccJ += cot.bottom;
                    x.i("MicroMsg.RecentImageBubble", "recent bubble navbar height %s %s", Integer.valueOf(cot.right), Integer.valueOf(cot.bottom));
                }
                iVar.vyf.showAtLocation(iVar.rts, i, i2, ccJ);
                new al(new com.tencent.mm.sdk.platformtools.al.a() {
                    public final boolean uG() {
                        i iVar = i.this;
                        if (iVar.vyf != null) {
                            iVar.vyf.dismiss();
                        }
                        return false;
                    }
                }, false).K(10000, 10000);
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.i$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ag vyk;

        AnonymousClass3(ag agVar) {
            this.vyk = agVar;
        }

        public final void run() {
            boolean z = true;
            i iVar = i.this;
            String ccN = iVar.ccN();
            if (ccN == null) {
                z = false;
            } else {
                int CI = (int) iVar.CI(70);
                int CI2 = (int) iVar.CI(120);
                int Vo = ExifHelper.Vo(ccN);
                if (Vo == 90 || Vo == 270) {
                    int i = CI;
                    CI = CI2;
                    CI2 = i;
                }
                int CI3 = (int) iVar.CI(4);
                Bitmap a = d.a(ccN, CI2, CI, true, null, 0);
                if (a != null) {
                    iVar.bitmap = d.a(d.b(a, (float) Vo), true, (float) CI3);
                    iVar.hbz.edit().putString("chattingui_recent_shown_image_path", iVar.vye.vyc).commit();
                    x.d("MicroMsg.RecentImageBubble", "check ok");
                } else {
                    x.e("MicroMsg.RecentImageBubble", "image hits hole.");
                    z = false;
                }
            }
            if (z) {
                this.vyk.sendEmptyMessage(0);
            } else {
                x.d("MicroMsg.RecentImageBubble", "check false");
            }
        }

        public final String toString() {
            return super.toString() + "|checkIfShow";
        }
    }

    public interface a {
        void Tg(String str);
    }

    public i(Context context, View view, View view2, a aVar) {
        this.context = context;
        this.rts = view;
        this.oaV = view2;
        this.vyd = new h(this.context);
        this.hbz = context.getSharedPreferences(ad.cgf(), 0);
        this.vyi = aVar;
        this.contentView = View.inflate(this.context, R.i.ddg, null);
        this.fzb = (ImageView) this.contentView.findViewById(R.h.cGr);
        this.vyf = new q(this.contentView, -2, -2, true);
        this.vyf.setBackgroundDrawable(new ColorDrawable(0));
        this.vyf.setOutsideTouchable(true);
        this.contentView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!(i.this.vyi == null || i.this.vye == null)) {
                    i.this.vyi.Tg(i.this.vye.vyc);
                }
                i.this.vyf.dismiss();
            }
        });
    }

    public final synchronized String ccN() {
        String str;
        g gVar;
        if (this.vyd == null) {
            x.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
            gVar = null;
        } else {
            ArrayList ccM = this.vyd.ccM();
            if (ccM == null || ccM.size() == 0) {
                x.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
                gVar = null;
            } else {
                gVar = (g) ccM.get(0);
                if (gVar != null) {
                    if ((bi.bz(gVar.mWS) < 0 ? 1 : null) != null) {
                        x.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", gVar.vyc);
                        gVar = null;
                    }
                }
                if (gVar == null || gVar.vyc == null || !gVar.vyc.contains(e.bnE)) {
                    if (gVar != null) {
                        if ((bi.bz(gVar.mWS) <= 30 ? 1 : null) != null) {
                            if (this.hbz.getString("chattingui_recent_shown_image_path", "").equals(gVar.vyc)) {
                                x.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
                                gVar = null;
                            }
                        }
                    }
                    String str2 = "MicroMsg.RecentImageBubble";
                    String str3 = "because of checkAddDate(addDate) == false, or imageItem == null : %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(gVar == null);
                    x.d(str2, str3, objArr);
                    gVar = null;
                } else {
                    gVar = null;
                }
            }
        }
        this.vye = gVar;
        if (this.vye == null) {
            str = null;
        } else {
            str = this.vye.fwx;
            if (this.vye.fwx == null) {
                str = this.vye.vyc;
            }
        }
        return str;
    }

    final float CI(int i) {
        return TypedValue.applyDimension(1, (float) i, this.context.getResources().getDisplayMetrics());
    }
}

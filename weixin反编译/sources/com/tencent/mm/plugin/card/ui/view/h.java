package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.d.a.a.t;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.card.a.j;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.p;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.pb.common.c.g;

public abstract class h implements ab {
    protected MMActivity kgL;
    protected g lci;

    public abstract boolean axE();

    public abstract boolean axF();

    public h(g gVar, MMActivity mMActivity) {
        this.lci = gVar;
        this.kgL = mMActivity;
    }

    public void c(ViewGroup viewGroup, final b bVar) {
        if (axE()) {
            TextView textView = (TextView) viewGroup.findViewById(R.h.bWE);
            String str = this.lci.code;
            if (bVar.auc() || (!g.Bf(str) && str.length() <= 40)) {
                textView.setText(m.xC(str));
                if (bVar.atX()) {
                    textView.setVisibility(0);
                    textView.setOnLongClickListener(new OnLongClickListener() {
                        public final boolean onLongClick(View view) {
                            if (view.getId() == R.h.bWE) {
                                p.I(h.this.kgL, bVar.auj().code);
                                com.tencent.mm.ui.base.h.bu(h.this.kgL, o.getString(R.l.dEE));
                            }
                            return false;
                        }
                    });
                    this.lci.d(c.CARDCODEREFRESHACTION_ENTERCHANGE);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
        if (axF()) {
            RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.h.bWs);
            if (bVar == null || bVar.aui() == null || bVar.aui().vZq == null || bi.oN(bVar.aui().vZq.title)) {
                relativeLayout.setVisibility(8);
                return;
            }
            viewGroup.findViewById(R.h.bWq).setVisibility(8);
            relativeLayout.setVisibility(0);
            oy oyVar = bVar.aui().vZq;
            TextView textView2 = (TextView) viewGroup.findViewById(R.h.bWu);
            textView2.setText(oyVar.title);
            String str2 = bVar.aui().hdx;
            if (!g.Bf(str2)) {
                textView2.setTextColor(l.xu(str2));
            }
            textView2 = (TextView) viewGroup.findViewById(R.h.bWt);
            CharSequence charSequence = oyVar.kPC;
            if (TextUtils.isEmpty(charSequence)) {
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            } else if (textView2 != null) {
                textView2.setText(charSequence);
                textView2.setVisibility(0);
            }
            relativeLayout.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (bVar.aub()) {
                        j.b bVar = new j.b();
                        com.tencent.mm.plugin.card.b.b.a(h.this.lci.kgL, bVar.kPo, bVar.kPp, false, bVar);
                    } else {
                        oy oyVar = bVar.aui().vZq;
                        if (oyVar != null && !g.Bf(oyVar.vYC) && !g.Bf(oyVar.vYB)) {
                            int intExtra;
                            int intExtra2;
                            if (h.this.kgL.getIntent() != null) {
                                intExtra = h.this.kgL.getIntent().getIntExtra("key_from_scene", 3);
                            } else {
                                intExtra = 3;
                            }
                            if (h.this.kgL.getIntent() != null) {
                                intExtra2 = h.this.kgL.getIntent().getIntExtra("key_from_appbrand_type", 0);
                            } else {
                                intExtra2 = 0;
                            }
                            com.tencent.mm.plugin.card.b.b.a(bVar.aum(), oyVar, intExtra, intExtra2);
                            com.tencent.mm.plugin.report.service.g.pWK.h(11941, Integer.valueOf(20), bVar.aum(), bVar.aun(), "", oyVar.title);
                        } else if (!(oyVar == null || TextUtils.isEmpty(oyVar.url))) {
                            com.tencent.mm.plugin.card.b.b.a(h.this.lci.kgL, l.w(oyVar.url, oyVar.vZQ), 1);
                            com.tencent.mm.plugin.report.service.g.pWK.h(11941, Integer.valueOf(9), bVar.aum(), bVar.aun(), "", oyVar.title);
                            if (l.a(oyVar, bVar.aum())) {
                                String aum = bVar.aum();
                                String str = oyVar.title;
                                l.xA(aum);
                                com.tencent.mm.plugin.card.b.b.a(h.this.lci.kgL, bVar.aui().kQL);
                            }
                        }
                    }
                    t.finish();
                }
            });
        }
    }

    public boolean i(b bVar) {
        return true;
    }

    public void d(ViewGroup viewGroup) {
    }
}

package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.d;

public class BankRemitSortView extends BaseSortView {
    private final String TAG = "MicroMsg.BankcardSortView";
    private ListView kMW;

    private class a {
        CdnImageView pNq;
        TextView pNs;
        TextView pPI;

        private a() {
        }

        /* synthetic */ a(BankRemitSortView bankRemitSortView, byte b) {
            this();
        }
    }

    public BankRemitSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View inflate() {
        return View.inflate(getContext(), g.uHN, this);
    }

    public final VerticalScrollBar atd() {
        return (VerticalScrollBar) findViewById(f.cOu);
    }

    public final ListView getListView() {
        this.kMW = (ListView) findViewById(f.ctk);
        return this.kMW;
    }

    public final View ate() {
        return null;
    }

    public final boolean a(String str, d dVar) {
        return false;
    }

    public final com.tencent.mm.ui.base.sortview.c.a atf() {
        return new com.tencent.mm.ui.base.sortview.c.a() {
            public final View a(d dVar, View view, int i, boolean z, boolean z2) {
                Context context = BankRemitSortView.this.getContext();
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(g.uHM, null);
                    a aVar = new a(BankRemitSortView.this, (byte) 0);
                    aVar.pPI = (TextView) view.findViewById(f.bSx);
                    aVar.pNs = (TextView) view.findViewById(f.unl);
                    aVar.pNq = (CdnImageView) view.findViewById(f.unk);
                    view.setTag(aVar);
                }
                a aVar2 = (a) view.getTag();
                fd fdVar = (fd) dVar.data;
                if (fdVar != null) {
                    if (BankRemitSortView.this.ysJ && z) {
                        if (dVar.ysR.equals("☆")) {
                            aVar2.pPI.setText(i.uOu);
                        } else {
                            aVar2.pPI.setText(dVar.ysR);
                        }
                        aVar2.pPI.setVisibility(0);
                    } else {
                        aVar2.pPI.setVisibility(8);
                    }
                    aVar2.pNq.setUrl(fdVar.pMZ);
                    aVar2.pNs.setText(fdVar.nHt);
                } else {
                    x.w("MicroMsg.BankcardSortView", "elem is null: %s", Integer.valueOf(i));
                }
                return view;
            }
        };
    }
}

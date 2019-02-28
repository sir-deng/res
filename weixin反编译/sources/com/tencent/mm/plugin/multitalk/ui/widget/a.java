package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.d.b;

public final class a extends d {
    private a oNx = new a();

    public class a extends b {
        public a() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.doC, viewGroup, false);
            com.tencent.mm.ui.contact.a.d.a aVar = (com.tencent.mm.ui.contact.a.d.a) a.this.Xa();
            aVar.ikK = (ImageView) inflate.findViewById(R.h.bLM);
            aVar.ikL = (TextView) inflate.findViewById(R.h.cSB);
            aVar.ikM = (TextView) inflate.findViewById(R.h.caU);
            aVar.contentView = inflate.findViewById(R.h.cKY);
            aVar.ikN = (CheckBox) inflate.findViewById(R.h.cKP);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            com.tencent.mm.ui.contact.a.d.a aVar3 = (com.tencent.mm.ui.contact.a.d.a) aVar;
            d dVar = (d) aVar2;
            if (dVar.username == null || dVar.username.length() <= 0) {
                aVar3.ikK.setImageResource(R.g.bBC);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ikK, dVar.username);
            }
            e.a(dVar.ikG, aVar3.ikL);
            if (a.this.zbR) {
                if (z) {
                    aVar3.ikN.setChecked(true);
                    aVar3.ikN.setEnabled(false);
                } else {
                    aVar3.ikN.setChecked(z2);
                    aVar3.ikN.setEnabled(true);
                }
                aVar3.ikN.setVisibility(0);
                return;
            }
            aVar3.ikN.setVisibility(8);
        }
    }

    public a(int i) {
        super(i);
    }

    public final com.tencent.mm.ui.contact.a.a.b WZ() {
        return this.oNx;
    }
}

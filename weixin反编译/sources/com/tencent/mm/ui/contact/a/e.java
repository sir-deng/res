package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.pluginsdk.ui.d.i;

public class e extends a {
    public CharSequence ikG;
    public String username;
    public CharSequence zeq;
    public int zer = 0;
    private b zes = new b();
    a zet = new a();

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public ImageView ikK;
        public TextView ikM;
        public CheckBox ikN;
        public TextView kHt;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            if (com.tencent.mm.bu.a.ez(context)) {
                inflate = LayoutInflater.from(context).inflate(f.qlz, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(f.qly, viewGroup, false);
            }
            a aVar = e.this.zet;
            aVar.ikK = (ImageView) inflate.findViewById(com.tencent.mm.plugin.selectcontact.a.e.bLM);
            aVar.kHt = (TextView) inflate.findViewById(com.tencent.mm.plugin.selectcontact.a.e.cSB);
            aVar.ikM = (TextView) inflate.findViewById(com.tencent.mm.plugin.selectcontact.a.e.caU);
            aVar.ikM.setVisibility(8);
            aVar.ikN = (CheckBox) inflate.findViewById(com.tencent.mm.plugin.selectcontact.a.e.cKP);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            e eVar = (e) aVar2;
            a aVar3 = (a) aVar;
            if (e.this.zer == 0 || e.this.zeq == null) {
                com.tencent.mm.plugin.fts.d.e.a(eVar.ikG, aVar3.kHt);
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ikK, eVar.username);
                if (e.this.zbR) {
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
                return;
            }
            aVar3.ikK.setImageResource(e.this.zer);
            aVar3.kHt.setText(e.this.zeq);
        }

        public final boolean Xb() {
            return false;
        }
    }

    public e(int i) {
        super(4, i);
    }

    public void bH(Context context) {
        if (this.zer != 0 && this.zeq != null) {
            return;
        }
        if (this.jQP == null) {
            this.ikG = "";
            this.username = "";
            return;
        }
        this.ikG = i.c(context, ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).c(this.jQP), com.tencent.mm.bu.a.aa(context, c.bvL));
        this.username = this.jQP.field_username;
    }

    public final com.tencent.mm.ui.contact.a.a.b WZ() {
        return this.zes;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Xa() {
        return this.zet;
    }
}

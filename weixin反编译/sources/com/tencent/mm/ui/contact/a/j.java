package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;

public final class j extends a {
    private a zeG = new a();
    b zeH = new b();

    public class b extends com.tencent.mm.ui.contact.a.a.a {
        public View contentView;
        public TextView ikL;
        public CheckBox ikN;

        public b() {
            super();
        }
    }

    public class a extends com.tencent.mm.ui.contact.a.a.b {
        public a() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(f.qlE, viewGroup, false);
            b bVar = j.this.zeH;
            bVar.ikL = (TextView) inflate.findViewById(e.cSB);
            bVar.contentView = inflate.findViewById(e.cKY);
            bVar.ikN = (CheckBox) inflate.findViewById(e.cKP);
            inflate.setTag(bVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            b bVar = (b) aVar;
            bVar.ikL.setText(h.qlO);
            bVar.ikN.setBackgroundResource(d.qlm);
            bVar.ikN.setChecked(z2);
            bVar.ikN.setEnabled(true);
            bVar.ikN.setVisibility(0);
            bVar.contentView.setBackgroundResource(d.bBz);
        }

        public final boolean Xb() {
            return false;
        }
    }

    public j(int i) {
        super(7, i);
    }

    public final void bH(Context context) {
    }

    public final com.tencent.mm.ui.contact.a.a.b WZ() {
        return this.zeG;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Xa() {
        return this.zeH;
    }
}

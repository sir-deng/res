package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.util.HashSet;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    BackupMoveChooseUI krM;
    HashSet<Integer> krN;
    boolean krO = false;

    class a {
        ImageView ikK;
        TextView ikL;
        CheckBox ikN;
        RelativeLayout krQ;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return mY(i);
    }

    public a(BackupMoveChooseUI backupMoveChooseUI) {
        this.krM = backupMoveChooseUI;
        this.krN = new HashSet();
        this.krO = false;
    }

    public final int getCount() {
        LinkedList apu = b.apy().apC().apu();
        if (apu != null) {
            return apu.size();
        }
        return 0;
    }

    private static f.b mY(int i) {
        return (f.b) b.apy().apC().apu().get(i);
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.krM.getLayoutInflater().inflate(R.i.daY, viewGroup, false);
            a aVar2 = new a();
            aVar2.ikK = (ImageView) view.findViewById(R.h.bLM);
            aVar2.ikL = (TextView) view.findViewById(R.h.cSB);
            aVar2.ikN = (CheckBox) view.findViewById(R.h.cKP);
            aVar2.krQ = (RelativeLayout) view.findViewById(R.h.cKQ);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.krQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (a.this.krN.contains(Integer.valueOf(i))) {
                    a.this.krN.remove(Integer.valueOf(i));
                } else {
                    a.this.krN.add(Integer.valueOf(i));
                }
                a.this.notifyDataSetChanged();
                a.this.krM.a(a.this.krN);
            }
        });
        f.b mY = mY(i);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.ikK, mY.koB);
        if (s.eX(mY.koB)) {
            aVar.ikL.setText(i.b(this.krM, r.L(mY.koB, mY.koB), aVar.ikL.getTextSize()));
        } else {
            aVar.ikL.setText(i.b(this.krM, r.gw(mY.koB), aVar.ikL.getTextSize()));
        }
        if (this.krN.contains(Integer.valueOf(i))) {
            aVar.ikN.setChecked(true);
        } else {
            aVar.ikN.setChecked(false);
        }
        return view;
    }
}

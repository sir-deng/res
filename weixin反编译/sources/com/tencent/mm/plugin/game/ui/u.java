package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.wz;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Iterator;
import java.util.LinkedList;

public final class u extends BaseAdapter {
    private Context context;
    private String foW = "";
    private LinkedList<a> hfI = new LinkedList();

    public static class a {
        public int actionType;
        public String appId;
        public String description;
        public String nAY;
        public String text;
        public int type;
    }

    private static class b {
        TextView jtn;
        ViewGroup nAZ;
        TextView nBa;
        TextView nBb;
        ViewGroup nBc;
        TextView nBd;
        ViewGroup nBe;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return rt(i);
    }

    public u(Context context) {
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        a rt = rt(i);
        if (view == null) {
            view = View.inflate(this.context, R.i.dlq, null);
            b bVar2 = new b();
            bVar2.jtn = (TextView) view.findViewById(R.h.cnk);
            bVar2.nAZ = (ViewGroup) bVar2.jtn.getParent();
            bVar2.nBa = (TextView) view.findViewById(R.h.cnj);
            bVar2.nBb = (TextView) view.findViewById(R.h.cnh);
            bVar2.nBc = (ViewGroup) bVar2.nBa.getParent();
            bVar2.nBd = (TextView) view.findViewById(R.h.cni);
            bVar2.nBe = (ViewGroup) bVar2.nBd.getParent().getParent();
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        switch (rt.type) {
            case 1:
                bVar.nAZ.setVisibility(0);
                bVar.nBc.setVisibility(8);
                bVar.nBe.setVisibility(8);
                bVar.nAZ.setOnClickListener(null);
                bVar.jtn.setText(rt.text);
                break;
            case 2:
                bVar.nAZ.setVisibility(8);
                bVar.nBc.setVisibility(0);
                bVar.nBe.setVisibility(8);
                bVar.nBa.setText(rt.text);
                bVar.nBb.setText(rt.description);
                break;
            case 3:
                bVar.nAZ.setVisibility(8);
                bVar.nBc.setVisibility(8);
                bVar.nBe.setVisibility(0);
                bVar.nBd.setTextColor(this.context.getResources().getColor(R.e.btv));
                int color = this.context.getResources().getColor(R.e.bsC);
                int indexOf = rt.text.indexOf(this.foW);
                if (indexOf < 0) {
                    bVar.nBd.setText(rt.text);
                    break;
                }
                CharSequence spannableString = new SpannableString(rt.text);
                spannableString.setSpan(new ForegroundColorSpan(color), indexOf, this.foW.length() + indexOf, 33);
                bVar.nBd.setText(spannableString);
                break;
        }
        return view;
    }

    public final int getCount() {
        return this.hfI.size();
    }

    public final a rt(int i) {
        return (a) this.hfI.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void a(String str, String str2, LinkedList<wz> linkedList) {
        if (!bi.cC(linkedList)) {
            this.foW = str;
            this.hfI.clear();
            if (bi.oN(str)) {
                a aVar = new a();
                aVar.type = 1;
                if (bi.oN(str2)) {
                    aVar.text = this.context.getString(R.l.cnk);
                } else {
                    aVar.text = str2;
                }
                this.hfI.add(aVar);
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                wz wzVar = (wz) it.next();
                a aVar2 = new a();
                aVar2.type = bi.oN(str) ? 2 : 3;
                aVar2.appId = wzVar.nkU;
                aVar2.text = wzVar.woe;
                aVar2.description = wzVar.vPF;
                aVar2.actionType = wzVar.wnV;
                aVar2.nAY = wzVar.wnW;
                this.hfI.add(aVar2);
            }
            notifyDataSetChanged();
        }
    }
}

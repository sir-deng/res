package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.xe;
import com.tencent.mm.protocal.c.xf;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class t extends BaseAdapter {
    Context context;
    boolean fpa = false;
    ArrayList<b> lkR;
    boolean nAA = false;
    private ArrayList<d> nAB;
    boolean nAt = false;
    int nAu = 0;
    int nAv = 0;
    int nAw = 0;
    int nAx = 0;
    private int nAy;
    boolean nAz = false;
    int nja = 0;
    int nxC = 0;

    private static class a {
        public View contentView;
        ImageView nAF;
        TextView nAG;
        TextView nAH;
        TextView nAI;
        TextView nAJ;
        View nAK;
        TextView nAL;
        TextView nAM;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public static class c {
        public int actionType;
        String appId;
        int fGe;
        int nAR;
        int nAS;
        String nAW;
        String nAX;
        int position;
        int type;

        public c(String str) {
            this.actionType = 2;
            this.nAW = str;
        }

        public c(String str, byte b) {
            this.actionType = 2;
            this.type = 3;
            this.nAW = str;
        }

        public c(int i, int i2, String str, String str2) {
            this.actionType = i;
            this.type = i2;
            this.appId = str;
            if (i == 2) {
                this.nAW = str2;
            }
        }
    }

    public static class b {
        public int actionType;
        public String appId;
        public String foW;
        public long hXs;
        public String hiS;
        public String iLo;
        public String iconUrl;
        public String nAN;
        public xf nAO;
        public String nAP;
        public LinkedList<String> nAQ;
        public int nAR;
        public int nAS;
        public boolean nAT = false;
        public boolean nAU = false;
        public c nAV;
        public String name;
        public int type;

        public static b at(int i, String str) {
            b bVar = new b();
            bVar.type = i;
            bVar.name = str;
            bVar.nAV = new c();
            return bVar;
        }

        public static b a(xe xeVar) {
            b bVar = new b();
            bVar.type = 2;
            bVar.name = xeVar.fpg;
            bVar.iLo = xeVar.nkL;
            bVar.iconUrl = xeVar.phv;
            bVar.nAP = xeVar.wnW;
            bVar.nAR = xeVar.wor;
            bVar.nAS = xeVar.wos;
            bVar.appId = xeVar.nlV;
            bVar.hiS = xeVar.noG;
            bVar.hXs = (long) xeVar.bZP;
            bVar.nAV = new c(xeVar.wnW, (byte) 0);
            return bVar;
        }
    }

    private class d {
        int end;
        int start;

        private d() {
            this.start = -1;
            this.end = -1;
        }

        /* synthetic */ d(t tVar, byte b) {
            this();
        }
    }

    public t(Context context) {
        this.context = context;
        this.lkR = null;
        this.nAy = context.getResources().getColor(R.e.bsC);
    }

    public final int getCount() {
        return this.lkR == null ? 0 : this.lkR.size();
    }

    public final Object getItem(int i) {
        return this.lkR.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        return ((b) getItem(i)).type;
    }

    public final int getViewTypeCount() {
        return 7;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        b bVar = (b) getItem(i);
        if (view == null) {
            int i2;
            aVar = new a();
            Context context = this.context;
            switch (bVar.type) {
                case 0:
                    i2 = R.i.dls;
                    break;
                case 1:
                    i2 = R.i.dlm;
                    break;
                case 2:
                    i2 = R.i.dlt;
                    break;
                case 3:
                    i2 = R.i.dlr;
                    break;
                case 5:
                    i2 = R.i.dlo;
                    break;
                case 6:
                    i2 = R.i.dlp;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            view = View.inflate(context, i2, null);
            aVar.contentView = view.findViewById(R.h.cmw);
            aVar.nAF = (ImageView) view.findViewById(R.h.cmz);
            aVar.nAG = (TextView) view.findViewById(R.h.cmA);
            aVar.nAH = (TextView) view.findViewById(R.h.cmu);
            aVar.nAI = (TextView) view.findViewById(R.h.cmx);
            aVar.nAJ = (TextView) view.findViewById(R.h.cmB);
            aVar.nAK = view.findViewById(R.h.cmy);
            aVar.nAL = (TextView) view.findViewById(R.h.cPi);
            aVar.nAM = (TextView) view.findViewById(R.h.bZP);
            view.setTag(aVar);
            if (!(aVar.nAG == null || aVar.nAI == null)) {
                final TextView textView = aVar.nAG;
                final TextView textView2 = aVar.nAI;
                textView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                    public final void onGlobalLayout() {
                        if (textView.getLineCount() > 1) {
                            textView.setMaxLines(2);
                            textView2.setMaxLines(1);
                            return;
                        }
                        textView2.setMaxLines(2);
                    }
                });
            }
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.game.d.e.a.a aVar2;
        switch (bVar.type) {
            case 0:
                aVar.nAI.setText(bVar.name);
                break;
            case 1:
                if (!bi.oN(bVar.iconUrl)) {
                    aVar2 = new com.tencent.mm.plugin.game.d.e.a.a();
                    aVar2.hFj = false;
                    aVar2.hFl = false;
                    e.aSC().a(aVar.nAF, bVar.iconUrl, aVar2.aSD());
                }
                a(aVar.nAG, bVar.name);
                a(aVar.nAH, bVar.nAN);
                a(aVar.nAI, bVar.iLo);
                break;
            case 2:
                if (bi.oN(bVar.iconUrl)) {
                    aVar.nAF.setVisibility(8);
                } else {
                    aVar2 = new com.tencent.mm.plugin.game.d.e.a.a();
                    aVar2.hFj = false;
                    aVar2.hFl = false;
                    aVar2.nDa = true;
                    e.aSC().a(aVar.nAF, bVar.iconUrl, aVar2.aSD());
                    aVar.nAF.setVisibility(0);
                }
                a(aVar.nAG, bVar.name);
                a(aVar.nAI, bVar.iLo);
                if (bi.oN(bVar.hiS)) {
                    aVar.nAL.setVisibility(8);
                } else {
                    aVar.nAL.setText(i.a(this.context, bVar.hiS));
                    aVar.nAL.setVisibility(0);
                }
                if (bVar.hXs <= 0) {
                    aVar.nAM.setVisibility(8);
                    break;
                }
                aVar.nAM.setText(com.tencent.mm.plugin.game.d.b.f(this.context, bVar.hXs * 1000));
                aVar.nAM.setVisibility(0);
                break;
            case 3:
                if (!bi.oN(bVar.iconUrl)) {
                    aVar2 = new com.tencent.mm.plugin.game.d.e.a.a();
                    aVar2.hFj = false;
                    aVar2.hFl = false;
                    e.aSC().a(aVar.nAF, bVar.iconUrl, aVar2.aSD());
                }
                a(aVar.nAG, bVar.name);
                a(aVar.nAH, bVar.nAN);
                a(aVar.nAI, bVar.iLo);
                TextView textView3 = aVar.nAJ;
                LinkedList linkedList = bVar.nAQ;
                StringBuilder stringBuilder = new StringBuilder();
                if (!bi.cC(linkedList)) {
                    int size = linkedList.size();
                    for (int i3 = 0; i3 < size - 1; i3++) {
                        stringBuilder.append(((String) linkedList.get(i3)) + "\n");
                    }
                    stringBuilder.append((String) linkedList.get(size - 1));
                    textView3.setVisibility(0);
                    textView3.setText(stringBuilder.toString());
                    break;
                }
                textView3.setVisibility(8);
                break;
            case 5:
                aVar.nAF.setImageResource(R.k.dAK);
                break;
            case 6:
                break;
        }
        aVar.nAG.setText(bVar.name);
        switch (bVar.type) {
            case 0:
                if (!bVar.nAT) {
                    aVar.nAK.setVisibility(0);
                    break;
                }
                aVar.nAK.setVisibility(8);
                break;
            case 1:
            case 2:
            case 3:
            case 5:
                if (bVar.nAU) {
                    aVar.contentView.setBackgroundResource(R.g.bBz);
                } else {
                    aVar.contentView.setBackgroundResource(R.g.bBy);
                }
                int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.f.bvP);
                aVar.contentView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                break;
        }
        return view;
    }

    private void a(TextView textView, String str) {
        if (bi.oN(str)) {
            textView.setVisibility(8);
            return;
        }
        if (this.nAB == null) {
            this.nAB = new ArrayList();
        } else {
            this.nAB.clear();
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        d dVar = new d();
        for (int indexOf = stringBuilder.indexOf("<em>"); indexOf >= 0; indexOf = stringBuilder.indexOf("<em>")) {
            dVar.start = indexOf;
            stringBuilder.delete(indexOf, indexOf + 4);
            indexOf = stringBuilder.indexOf("</em>");
            if (indexOf < 0) {
                break;
            }
            dVar.end = indexOf;
            stringBuilder.delete(indexOf, indexOf + 5);
            this.nAB.add(dVar);
        }
        CharSequence spannableString = new SpannableString(stringBuilder.toString());
        Iterator it = this.nAB.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            if (dVar2.start < dVar2.end) {
                spannableString.setSpan(new ForegroundColorSpan(this.nAy), dVar2.start, dVar2.end, 33);
            }
        }
        textView.setText(spannableString);
        textView.setVisibility(0);
    }
}

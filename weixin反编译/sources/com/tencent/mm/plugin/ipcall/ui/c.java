package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.n;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class c extends o<com.tencent.mm.plugin.ipcall.a.g.c> implements com.tencent.mm.ac.d.a {
    static HashMap<String, com.tencent.mm.plugin.ipcall.a.g.c> nMn = null;
    private String inJ;
    boolean kLF = false;
    HashMap<String, Integer> ljE = new HashMap();
    private Context mContext;
    ap nMS = new ap();
    private d nNq;
    private HashMap<Long, com.tencent.mm.plugin.ipcall.a.g.c> nNr = new HashMap();
    private HashSet<String> nNs = new HashSet();
    private boolean nNt = false;
    private OnClickListener nNu = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() instanceof Integer) {
                com.tencent.mm.plugin.ipcall.a.g.c rO = c.this.rO(((Integer) view.getTag()).intValue());
                Intent intent = new Intent(c.this.context, IPCallUserProfileUI.class);
                intent.putExtra("IPCallProfileUI_contactid", rO.field_contactId);
                intent.putExtra("IPCallProfileUI_systemUsername", rO.field_systemAddressBookUsername);
                intent.putExtra("IPCallProfileUI_wechatUsername", rO.field_wechatUsername);
                c.this.context.startActivity(intent);
            }
        }
    };

    private class b {
        ImageView ikl;
        TextView jQN;
        TextView nNA;
        TextView nNB;
        TextView nNC;
        TextView nND;
        ImageView nNE;
        View nNF;
        View nNG;
        View nNH;
        ImageView nNI;
        TextView nNy;
        LinearLayout nNz;

        private b() {
        }

        /* synthetic */ b(c cVar, byte b) {
            this();
        }
    }

    class a {
        String nNw;
        String nNx;

        public a(String str, String str2) {
            this.nNx = str2;
            this.nNw = str;
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        com.tencent.mm.plugin.ipcall.a.g.c cVar = (com.tencent.mm.plugin.ipcall.a.g.c) obj;
        if (cVar == null) {
            cVar = new com.tencent.mm.plugin.ipcall.a.g.c();
        }
        cVar.b(cursor);
        return cVar;
    }

    public final /* synthetic */ Object getItem(int i) {
        return rO(i);
    }

    public c(Context context) {
        super(context, null);
        mb(true);
        this.mContext = context;
        this.nNq = new d(context);
        n.JF().a((com.tencent.mm.ac.d.a) this);
    }

    public final int getCount() {
        return super.getCount();
    }

    public final int aUT() {
        return super.getCount();
    }

    public final com.tencent.mm.plugin.ipcall.a.g.c rO(int i) {
        return (com.tencent.mm.plugin.ipcall.a.g.c) super.getItem(i);
    }

    public final void Ds(String str) {
        this.inJ = str;
        if (bi.oN(this.inJ)) {
            this.nNt = false;
        } else {
            this.nNt = true;
        }
        this.xQM.clear();
        XH();
        notifyDataSetChanged();
    }

    public final void XH() {
        Cursor Dk;
        Object obj = null;
        if (this.nNt) {
            this.kLF = true;
            Dk = i.aUk().Dk(this.inJ);
            this.kLF = false;
        } else {
            Dk = i.aUk().gLA.query("IPCallAddressItem", d.nMp, null, null, null, null, "upper(sortKey) asc");
        }
        if (Dk != null) {
            Dk.moveToFirst();
        }
        setCursor(Dk);
        if (getCursor() != null) {
            Cursor cursor = getCursor();
            try {
                if (cursor.moveToFirst()) {
                    int i = 0;
                    while (!cursor.isAfterLast()) {
                        com.tencent.mm.plugin.ipcall.a.g.c cVar = new com.tencent.mm.plugin.ipcall.a.g.c();
                        cVar.b(cursor);
                        String Dt = Dt(cVar.field_sortKey);
                        if (i == 0) {
                            this.ljE.put(Dt, Integer.valueOf(i));
                        } else if (obj != null) {
                            if (!Dt.equals(obj)) {
                                this.ljE.put(Dt, Integer.valueOf(i));
                            }
                        }
                        i++;
                        cursor.moveToNext();
                        String obj2 = Dt;
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", e.getMessage());
            }
        }
    }

    public final void aUU() {
        super.aUU();
    }

    protected final void XI() {
        super.aUU();
        XH();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.i.dmn, viewGroup, false);
            b bVar = new b();
            bVar.nNG = view.findViewById(R.h.crB);
            bVar.nNH = view.findViewById(R.h.ccn);
            bVar.ikl = (ImageView) view.findViewById(R.h.bLM);
            bVar.jQN = (TextView) view.findViewById(R.h.cAs);
            bVar.nNy = (TextView) view.findViewById(R.h.cCB);
            bVar.nNz = (LinearLayout) view.findViewById(R.h.cGs);
            bVar.nNA = (TextView) view.findViewById(R.h.cGt);
            bVar.nNB = (TextView) view.findViewById(R.h.cGu);
            bVar.nNC = (TextView) view.findViewById(R.h.bJp);
            bVar.nND = (TextView) view.findViewById(R.h.bJj);
            bVar.nNE = (ImageView) view.findViewById(R.h.bJk);
            bVar.nNF = view.findViewById(R.h.crD);
            bVar.nNF.setClickable(true);
            bVar.nNI = (ImageView) view.findViewById(R.h.divider);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        bVar2.nNF.setClickable(true);
        bVar2.nNF.setTag(Integer.valueOf(i));
        bVar2.nNI.setVisibility(8);
        if (rq(i)) {
            bVar2.jQN.setVisibility(8);
            bVar2.nNy.setVisibility(8);
            bVar2.nNz.setVisibility(8);
            bVar2.ikl.setVisibility(8);
            bVar2.ikl.setTag(null);
            bVar2.nND.setVisibility(8);
            bVar2.nNC.setVisibility(8);
            bVar2.nNE.setVisibility(8);
        } else {
            com.tencent.mm.plugin.ipcall.a.g.c rO = rO(i);
            if (rO != null) {
                CharSequence charSequence;
                if (bi.oN(rO.field_systemAddressBookUsername)) {
                    bVar2.jQN.setVisibility(8);
                    bVar2.nNy.setVisibility(8);
                } else {
                    bVar2.jQN.setVisibility(0);
                    LayoutParams layoutParams;
                    RelativeLayout.LayoutParams layoutParams2;
                    if (this.nNt) {
                        bVar2.nNy.setVisibility(0);
                        layoutParams = (LayoutParams) bVar2.nNG.getLayoutParams();
                        layoutParams.height = (int) bVar2.nNy.getContext().getResources().getDimension(R.f.bwc);
                        bVar2.nNG.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) bVar2.ikl.getLayoutParams();
                        layoutParams2.height = (int) bVar2.ikl.getContext().getResources().getDimension(R.f.bvZ);
                        layoutParams2.width = (int) bVar2.ikl.getContext().getResources().getDimension(R.f.bvZ);
                        bVar2.ikl.setLayoutParams(layoutParams2);
                    } else {
                        bVar2.nNy.setVisibility(8);
                        layoutParams = (LayoutParams) bVar2.nNG.getLayoutParams();
                        layoutParams.height = (int) bVar2.nNy.getContext().getResources().getDimension(R.f.bwb);
                        bVar2.nNG.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) bVar2.ikl.getLayoutParams();
                        layoutParams2.height = (int) bVar2.ikl.getContext().getResources().getDimension(R.f.bwa);
                        layoutParams2.width = (int) bVar2.ikl.getContext().getResources().getDimension(R.f.bwa);
                        bVar2.ikl.setLayoutParams(layoutParams2);
                    }
                    if (this.nNt && rO.nMo == null && nMn != null && nMn.containsKey(rO.field_contactId)) {
                        rO.nMo = ((com.tencent.mm.plugin.ipcall.a.g.c) nMn.get(rO.field_contactId)).nMo;
                    } else if (this.nNt && rO.nMo == null && (nMn == null || nMn.containsKey(rO.field_contactId))) {
                        rO.nMo = com.tencent.mm.plugin.ipcall.a.g.b.Dh(rO.field_contactId);
                    }
                    if (!bi.oN(this.inJ) && (bi.p(this.inJ.charAt(0)) || this.inJ.startsWith("+"))) {
                        bVar2.nNy.setText(com.tencent.mm.bb.b.a(a(rO, this.inJ), ap.VP(this.inJ)));
                        bVar2.jQN.setText(com.tencent.mm.bb.b.a(rO.field_systemAddressBookUsername, this.inJ));
                    } else if (!bi.oN(this.inJ) && !bi.p(this.inJ.charAt(0))) {
                        String charSequence2;
                        CharSequence charSequence3 = rO.field_systemAddressBookUsername;
                        String str = rO.field_systemAddressBookUsername;
                        CharSequence charSequence4 = this.inJ;
                        if (bi.oN(charSequence4) || bi.oN(str)) {
                            charSequence2 = "";
                        } else {
                            if (!bi.VW(charSequence4) && bi.VX(charSequence4)) {
                                int i2;
                                int i3;
                                List arrayList = new ArrayList();
                                for (i2 = 0; i2 < str.length(); i2++) {
                                    String substring = str.substring(i2, i2 + 1);
                                    arrayList.add(new a(com.tencent.mm.platformtools.c.oD(substring), substring));
                                }
                                for (i2 = 2; i2 <= str.length(); i2++) {
                                    for (i3 = 0; i3 <= str.length() - i2; i3++) {
                                        String substring2 = str.substring(i3, i3 + i2);
                                        arrayList.add(new a(com.tencent.mm.platformtools.c.oD(substring2), substring2));
                                    }
                                }
                                i2 = 0;
                                while (true) {
                                    i3 = i2;
                                    if (i3 >= arrayList.size()) {
                                        break;
                                    }
                                    a aVar = (a) arrayList.get(i3);
                                    if (aVar.nNw.contains(charSequence4)) {
                                        charSequence2 = aVar.nNx;
                                        break;
                                    }
                                    i2 = i3 + 1;
                                }
                            }
                            charSequence2 = charSequence4;
                        }
                        bVar2.jQN.setText(com.tencent.mm.bb.b.a(charSequence3, charSequence2));
                        bVar2.nNy.setText(a(rO, this.inJ));
                    } else if (bi.oN(this.inJ)) {
                        bVar2.jQN.setText(rO.field_systemAddressBookUsername);
                    }
                }
                ImageView imageView = bVar2.ikl;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(R.g.bDi);
                    if (rO != null) {
                        if (!bi.oN(rO.field_contactId) && !bi.oN(rO.field_wechatUsername)) {
                            this.nNq.a(rO.field_contactId, rO.field_wechatUsername, imageView);
                        } else if (!bi.oN(rO.field_contactId)) {
                            this.nNq.b(rO.field_contactId, imageView);
                        } else if (!bi.oN(rO.field_wechatUsername)) {
                            this.nNq.c(rO.field_wechatUsername, imageView);
                        }
                        if (!bi.oN(rO.field_wechatUsername)) {
                            this.nNs.add(rO.field_wechatUsername);
                        }
                    }
                }
                bVar2.nNz.setVisibility(8);
                charSequence2 = Dt(rO.field_sortKey);
                if (i == 0) {
                    bVar2.nNC.setVisibility(0);
                    bVar2.nNC.setText(charSequence2);
                    bVar2.nND.setVisibility(8);
                } else if (Dt(rO(i - 1).field_sortKey).equals(charSequence2)) {
                    bVar2.nNC.setVisibility(8);
                    bVar2.nNC.setText("");
                    bVar2.nND.setVisibility(8);
                } else {
                    bVar2.nNC.setVisibility(0);
                    bVar2.nNC.setText(charSequence2);
                    bVar2.nND.setVisibility(8);
                }
            }
            bVar2.nNF.setVisibility(8);
            bVar2.nNE.setVisibility(8);
            bVar2.nNE.setOnClickListener(this.nNu);
        }
        Object obj = 1;
        if (!(rO(i + 1) == null || rO(i) == null || Dt(rO(i + 1).field_sortKey).equals(Dt(rO(i).field_sortKey)))) {
            obj = null;
        }
        if (i + 1 == getCount() || obj == null) {
            bVar2.nNH.setVisibility(8);
        } else {
            bVar2.nNH.setVisibility(0);
        }
        return view;
    }

    private static String a(com.tencent.mm.plugin.ipcall.a.g.c cVar, String str) {
        if (!(cVar == null || cVar.nMo == null)) {
            Iterator it = cVar.nMo.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.contains(str)) {
                    return str2;
                }
            }
        }
        return null;
    }

    private static String Dt(String str) {
        if (bi.oN(str)) {
            return "";
        }
        if (str.startsWith(com.tencent.mm.plugin.ipcall.a.g.b.ljD)) {
            return "#";
        }
        return str.toUpperCase().substring(0, 1);
    }

    public final int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public final int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    public final void jk(String str) {
        if (this.nNs.contains(str)) {
            ah.y(new Runnable() {
                public final void run() {
                    c.this.notifyDataSetChanged();
                }
            });
        }
    }

    public final void notifyDataSetChanged() {
        this.nNr.clear();
        super.notifyDataSetChanged();
    }
}

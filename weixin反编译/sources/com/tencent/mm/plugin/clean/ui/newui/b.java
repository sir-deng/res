package com.tencent.mm.plugin.clean.ui.newui;

import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.bl.d;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;
import com.tencent.mm.ui.gridviewheaders.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public final class b extends BaseAdapter implements e {
    private static int llY = 0;
    private boolean anv;
    ArrayList<com.tencent.mm.plugin.clean.c.a> jRO;
    OnItemClickListener kMo = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            x.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d", Integer.valueOf(i));
            com.tencent.mm.plugin.clean.c.a oH = b.this.oH(i);
            Intent intent = new Intent();
            switch (oH.type) {
                case 1:
                    intent.putExtra("key_title", b.this.lnu.getString(R.l.dTQ));
                    intent.putExtra("show_menu", false);
                    intent.putExtra("key_image_path", oH.filePath);
                    d.a(b.this.lnu, ".ui.tools.ShowImageUI", intent);
                    return;
                case 3:
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.fromFile(new File(oH.filePath)), "video/*");
                    try {
                        b.this.lnu.startActivity(Intent.createChooser(intent, b.this.lnu.getString(R.l.eTJ)));
                        return;
                    } catch (Exception e) {
                        return;
                    }
                case 4:
                    intent.putExtra("app_msg_id", oH.fqB);
                    d.a(b.this.lnu, ".ui.chatting.AppAttachDownloadUI", intent);
                    return;
                default:
                    return;
            }
        }
    };
    HashSet<Integer> krN;
    c llZ = new c() {
        public final void cl(View view) {
            b.a(b.this, (a) view.getTag());
            b.this.notifyDataSetChanged();
        }
    };
    private ag lma = new ag() {
        public final void handleMessage(Message message) {
            if (!b.this.anv) {
                b.this.notifyDataSetChanged();
            }
        }
    };
    OnScrollListener lmb = new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            o.PG().bp(i);
            if (i != 2) {
                b.this.anv = false;
                b.this.lma.removeCallbacksAndMessages(null);
                b.this.lma.sendEmptyMessageDelayed(0, 200);
                return;
            }
            b.this.anv = true;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private CleanChattingDetailUI lnu;

    class a {
        TextView lmd;
        TextView lme;
        CheckBox lmf;
        int position;

        a() {
        }
    }

    class b {
        CheckBox ikN;
        MMImageView lmg;
        ImageView lmh;
        View lmi;
        View lmj;
        TextView lmk;

        b() {
        }
    }

    static /* synthetic */ void a(b bVar, int i) {
        x.i("MicroMsg.CleanChattingDetailAdapter", "select position=%d", Integer.valueOf(i));
        if (!bVar.krN.remove(Integer.valueOf(i))) {
            bVar.krN.add(Integer.valueOf(i));
        }
        bVar.azg();
    }

    static /* synthetic */ void a(b bVar, a aVar) {
        int i;
        x.i("MicroMsg.CleanChattingDetailAdapter", "select header position=%d | headerId=%d", Integer.valueOf(aVar.position), Long.valueOf(bVar.oE(aVar.position)));
        Collection hashSet = new HashSet();
        for (i = 0; i < bVar.jRO.size(); i++) {
            if (((com.tencent.mm.plugin.clean.c.a) bVar.jRO.get(i)).ayG() == r4) {
                hashSet.add(Integer.valueOf(i));
            }
        }
        Iterator it = hashSet.iterator();
        i = 1;
        while (it.hasNext()) {
            i = !bVar.krN.remove(Integer.valueOf(((Integer) it.next()).intValue())) ? 0 : i;
        }
        if (i == 0) {
            bVar.krN.addAll(hashSet);
        }
        bVar.azg();
    }

    public final /* synthetic */ Object getItem(int i) {
        return oH(i);
    }

    public b(CleanChattingDetailUI cleanChattingDetailUI, ArrayList<com.tencent.mm.plugin.clean.c.a> arrayList) {
        this.lnu = cleanChattingDetailUI;
        this.jRO = arrayList;
        this.krN = new HashSet();
    }

    public final int getCount() {
        return this.jRO.size();
    }

    public final com.tencent.mm.plugin.clean.c.a oH(int i) {
        return (com.tencent.mm.plugin.clean.c.a) this.jRO.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = this.lnu.getLayoutInflater().inflate(R.i.dez, viewGroup, false);
            b bVar2 = new b();
            bVar2.lmg = (MMImageView) view.findViewById(R.h.bYP);
            bVar2.ikN = (CheckBox) view.findViewById(R.h.cKP);
            bVar2.lmi = view.findViewById(R.h.cKR);
            bVar2.lmj = view.findViewById(R.h.cLq);
            bVar2.lmh = (ImageView) view.findViewById(R.h.cCN);
            bVar2.lmk = (TextView) view.findViewById(R.h.cyG);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.mm.plugin.clean.c.a oH = oH(i);
        bVar.lmg.setTag(oH.filePath);
        bVar.lmi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this, i);
                b.this.notifyDataSetChanged();
            }
        });
        if (this.krN.contains(Integer.valueOf(i))) {
            bVar.ikN.setChecked(true);
            bVar.lmj.setVisibility(0);
        } else {
            bVar.ikN.setChecked(false);
            bVar.lmj.setVisibility(8);
        }
        if (oH.type == 3) {
            bVar.lmh.setVisibility(0);
        } else {
            bVar.lmh.setVisibility(8);
        }
        if (oH.type == 4) {
            bVar.lmg.setImageResource(r.Sd(com.tencent.mm.a.e.bQ(oH.filePath)));
            bVar.lmk.setText(new File(oH.filePath).getName());
            bVar.lmk.setVisibility(0);
        } else {
            if (llY == 0) {
                llY = view.getMeasuredWidth();
            }
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFq = 1;
            aVar.hFm = false;
            aVar.hFs = llY;
            aVar.hFr = llY;
            if (oH.type == 1) {
                aVar.hFn = oH.filePath;
                o.PG().a(oH.filePath, bVar.lmg, aVar.PQ());
            } else {
                aVar.hFn = oH.fwx;
                o.PG().a(oH.fwx, bVar.lmg, aVar.PQ());
            }
            bVar.lmk.setVisibility(8);
        }
        x.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return view;
    }

    public final long oE(int i) {
        return ((com.tencent.mm.plugin.clean.c.a) this.jRO.get(i)).ayG();
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            x.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
            view = this.lnu.getLayoutInflater().inflate(R.i.deA, viewGroup, false);
            aVar = new a();
            aVar.lmd = (TextView) view.findViewById(R.h.coz);
            aVar.lme = (TextView) view.findViewById(R.h.cox);
            aVar.lmf = (CheckBox) view.findViewById(R.h.cow);
            view.setTag(aVar);
        } else {
            x.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.clean.c.a oH = oH(i);
        aVar.position = i;
        aVar.lmd.setText(n.ak(this.lnu.getString(R.l.ejH), oH.hXt / 1000));
        long ayG = oH.ayG();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.jRO.size(); i2++) {
            if (((com.tencent.mm.plugin.clean.c.a) this.jRO.get(i2)).ayG() == ayG) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        Iterator it = hashSet.iterator();
        boolean z = true;
        while (it.hasNext()) {
            boolean z2;
            if (this.krN.contains(Integer.valueOf(((Integer) it.next()).intValue()))) {
                z2 = z;
            } else {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            aVar.lmf.setChecked(true);
        } else {
            aVar.lmf.setChecked(false);
        }
        return view;
    }

    final void azg() {
        boolean z;
        this.lnu.oF(this.krN.size());
        CleanChattingDetailUI cleanChattingDetailUI = this.lnu;
        if (this.krN.size() == this.jRO.size()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            cleanChattingDetailUI.krV.setChecked(true);
        } else {
            cleanChattingDetailUI.krV.setChecked(false);
        }
        Iterator it = this.krN.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = ((com.tencent.mm.plugin.clean.c.a) this.jRO.get(((Integer) it.next()).intValue())).size + j;
        }
        CleanChattingDetailUI cleanChattingDetailUI2 = this.lnu;
        if (j > 0) {
            cleanChattingDetailUI2.lmn.setText(cleanChattingDetailUI2.getString(R.l.dYF, new Object[]{bi.by(j)}));
            return;
        }
        cleanChattingDetailUI2.lmn.setText("");
    }

    public final void azf() {
        this.krN.clear();
        azg();
    }
}

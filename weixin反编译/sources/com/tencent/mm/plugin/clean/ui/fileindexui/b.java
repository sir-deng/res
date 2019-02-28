package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.database.Cursor;
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
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.gridviewheaders.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b extends BaseAdapter implements e {
    private static int llY = 0;
    private boolean anv;
    boolean isStop = false;
    ArrayList<i> jRO;
    OnItemClickListener kMo = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            x.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d", Integer.valueOf(i));
            i oD = b.this.oD(i);
            Intent intent = new Intent();
            switch (oD.type) {
                case 1:
                    intent.putExtra("key_title", b.this.llX.getString(R.l.dTQ));
                    intent.putExtra("show_menu", false);
                    intent.putExtra("key_image_path", FileOp.bO(oD.filePath) ? oD.filePath : oD.fwx);
                    d.a(b.this.llX, ".ui.tools.ShowImageUI", intent);
                    return;
                case 3:
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.fromFile(new File(oD.filePath)), "video/*");
                    try {
                        b.this.llX.startActivity(Intent.createChooser(intent, b.this.llX.getString(R.l.eTJ)));
                        return;
                    } catch (Exception e) {
                        return;
                    }
                case 4:
                    intent.putExtra("app_msg_id", oD.fqB);
                    d.a(b.this.llX, ".ui.chatting.AppAttachDownloadUI", intent);
                    return;
                default:
                    return;
            }
        }
    };
    HashSet<Integer> krN;
    private CleanChattingDetailUI llX;
    com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c llZ = new com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c() {
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
    private String username;

    class a {
        TextView lmd;
        TextView lme;
        CheckBox lmf;
        int position;

        a() {
        }
    }

    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        public final void run() {
            PLong pLong = new PLong();
            PLong pLong2 = new PLong();
            com.tencent.mm.plugin.i.b.b ato = com.tencent.mm.plugin.i.b.atn().ato();
            String a = b.this.username;
            long Wz = bi.Wz();
            String str = "select max(msgtime), min(msgtime) from WxFileIndex2 where username='" + a + "' and msgType in (43,62,44,3,49,268435505 )";
            Cursor cursor = null;
            try {
                cursor = ato.gLA.rawQuery(str, null);
                if (cursor != null && cursor.moveToFirst()) {
                    pLong.value = cursor.getLong(0);
                    pLong2.value = cursor.getLong(1);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", str);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
            x.i("MicroMsg.WxFileIndexStorage", "getMediaMsgTimeByUsername [%s] cost[%d]", a, Long.valueOf(bi.bB(Wz)));
            pLong2.value--;
            long j = pLong.value;
            Wz = Math.max(j - 604800000, pLong2.value);
            try {
                if (!b.this.isStop) {
                    if (Wz == j) {
                        Wz--;
                    }
                    ax(com.tencent.mm.plugin.i.b.atn().ato().i(b.this.username, j, Wz));
                    b.c(b.this);
                    while (true) {
                        j = Wz;
                        if (!b.this.isStop && j > pLong2.value) {
                            Wz = Math.max(j - 15552000000L, pLong2.value);
                            if (Wz == j) {
                                Wz--;
                            }
                            ax(com.tencent.mm.plugin.i.b.atn().ato().i(b.this.username, j, Wz));
                            b.c(b.this);
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.CleanChattingDetailAdapter", e2, "", new Object[0]);
            }
        }

        private void ax(List<com.tencent.mm.plugin.i.b.a> list) {
            int size = list.size();
            HashMap hashMap = new HashMap();
            Collection arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                com.tencent.mm.plugin.i.b.a aVar = (com.tencent.mm.plugin.i.b.a) list.get(i);
                i iVar = (i) hashMap.get(Long.valueOf(aVar.field_msgId));
                if (iVar == null) {
                    iVar = new i();
                    hashMap.put(Long.valueOf(aVar.field_msgId), iVar);
                    arrayList.add(iVar);
                }
                iVar.llt.add(aVar);
                iVar.hXt = aVar.field_msgtime;
                iVar.userName = aVar.field_username;
                iVar.fqB = aVar.field_msgId;
                if (!com.tencent.mm.plugin.i.a.nS(aVar.field_msgSubType)) {
                    iVar.size += aVar.field_size;
                }
                switch (aVar.field_msgSubType) {
                    case 1:
                        iVar.filePath = g.Dq().gRS + aVar.field_path;
                        iVar.type = 3;
                        break;
                    case 2:
                        iVar.fwx = g.Dq().gRS + aVar.field_path;
                        iVar.type = 3;
                        break;
                    case 20:
                        iVar.filePath = g.Dq().gRS + aVar.field_path;
                        iVar.type = 1;
                        break;
                    case 21:
                        iVar.fwx = g.Dq().gRS + aVar.field_path;
                        iVar.type = 1;
                        break;
                    case 30:
                        iVar.filePath = g.Dq().gRS + aVar.field_path;
                        iVar.type = 1;
                        break;
                    case 31:
                        iVar.fwx = g.Dq().gRS + aVar.field_path;
                        iVar.type = 1;
                        break;
                    case 32:
                        iVar.filePath = g.Dq().gRS + aVar.field_path;
                        iVar.type = 4;
                        break;
                    case 33:
                        iVar.fwx = g.Dq().gRS + aVar.field_path;
                        iVar.type = 4;
                        break;
                    case 34:
                        iVar.filePath = g.Dq().gRS + aVar.field_path;
                        iVar.type = 4;
                        break;
                    case 35:
                        iVar.fwx = g.Dq().gRS + aVar.field_path;
                        iVar.type = 4;
                        break;
                    default:
                        break;
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((i) it.next()).size <= 0) {
                    it.remove();
                }
            }
            b.this.jRO.addAll(arrayList);
        }
    }

    class c {
        CheckBox ikN;
        MMImageView lmg;
        ImageView lmh;
        View lmi;
        View lmj;
        TextView lmk;

        c() {
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
            if (((i) bVar.jRO.get(i)).ayG() == r4) {
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

    static /* synthetic */ void c(b bVar) {
        if (!bVar.isStop) {
            ah.y(new Runnable() {
                public final void run() {
                    b.this.notifyDataSetChanged();
                }
            });
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return oD(i);
    }

    public b(CleanChattingDetailUI cleanChattingDetailUI, String str) {
        this.llX = cleanChattingDetailUI;
        this.krN = new HashSet();
        this.jRO = new ArrayList();
        this.username = str;
    }

    public final int getCount() {
        return this.jRO.size();
    }

    public final i oD(int i) {
        return (i) this.jRO.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        c cVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = this.llX.getLayoutInflater().inflate(R.i.dez, viewGroup, false);
            c cVar2 = new c();
            cVar2.lmg = (MMImageView) view.findViewById(R.h.bYP);
            cVar2.ikN = (CheckBox) view.findViewById(R.h.cKP);
            cVar2.lmi = view.findViewById(R.h.cKR);
            cVar2.lmj = view.findViewById(R.h.cLq);
            cVar2.lmh = (ImageView) view.findViewById(R.h.cCN);
            cVar2.lmk = (TextView) view.findViewById(R.h.cyG);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        i oD = oD(i);
        cVar.lmg.setTag(oD.filePath);
        cVar.lmi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this, i);
                b.this.notifyDataSetChanged();
            }
        });
        if (this.krN.contains(Integer.valueOf(i))) {
            cVar.ikN.setChecked(true);
            cVar.lmj.setVisibility(0);
        } else {
            cVar.ikN.setChecked(false);
            cVar.lmj.setVisibility(8);
        }
        if (oD.type == 3) {
            cVar.lmh.setVisibility(0);
        } else {
            cVar.lmh.setVisibility(8);
        }
        if (oD.type == 4) {
            cVar.lmg.setImageResource(r.Sd(com.tencent.mm.a.e.bQ(oD.filePath)));
            cVar.lmk.setText(new File(oD.filePath).getName());
            cVar.lmk.setVisibility(0);
        } else {
            if (llY == 0) {
                llY = view.getMeasuredWidth();
            }
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFq = 1;
            aVar.hFm = false;
            aVar.hFs = llY;
            aVar.hFr = llY;
            int i2 = oD.type;
            aVar.hFn = oD.fwx;
            o.PG().a(oD.fwx, cVar.lmg, aVar.PQ());
            cVar.lmk.setVisibility(8);
        }
        x.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return view;
    }

    public final long oE(int i) {
        return ((i) this.jRO.get(i)).ayG();
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            x.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
            view = this.llX.getLayoutInflater().inflate(R.i.deA, viewGroup, false);
            aVar = new a();
            aVar.lmd = (TextView) view.findViewById(R.h.coz);
            aVar.lme = (TextView) view.findViewById(R.h.cox);
            aVar.lmf = (CheckBox) view.findViewById(R.h.cow);
            view.setTag(aVar);
        } else {
            x.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
            aVar = (a) view.getTag();
        }
        i oD = oD(i);
        aVar.position = i;
        aVar.lmd.setText(n.ak(this.llX.getString(R.l.ejH), oD.hXt / 1000));
        long ayG = oD.ayG();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.jRO.size(); i2++) {
            if (((i) this.jRO.get(i2)).ayG() == ayG) {
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
        this.llX.oF(this.krN.size());
        CleanChattingDetailUI cleanChattingDetailUI = this.llX;
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
            j = ((i) this.jRO.get(((Integer) it.next()).intValue())).size + j;
        }
        CleanChattingDetailUI cleanChattingDetailUI2 = this.llX;
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

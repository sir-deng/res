package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

abstract class n extends b<d> {
    protected Context mContext;
    protected int niV = 0;
    private a nrP;
    protected int nth;
    private OnClickListener nuZ = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            n.this.notifyDataSetChanged();
        }
    };
    protected int nuk = 14;
    private com.tencent.mm.plugin.game.model.n.b nuo = new com.tencent.mm.plugin.game.model.n.b() {
        public final void h(int i, String str, boolean z) {
            if (z && n.this.nyl != null && str != null) {
                try {
                    for (o oVar : n.this.nyl.values()) {
                        if (!(oVar == null || oVar.nhC == null)) {
                            if (oVar.nhC.field_appId.equals(str) || oVar.nhC.field_packageName.equals(str)) {
                                oVar.cQ(n.this.mContext);
                                oVar.aQQ();
                            }
                        }
                    }
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < n.this.njn.size()) {
                            d dVar = (d) n.this.njn.get(i3);
                            if (dVar.type != 0 || (!(dVar.field_appId.equals(str) || dVar.field_packageName.equals(str)) || n.this.nrP == null)) {
                                i2 = i3 + 1;
                            } else {
                                n.this.nrP.ri(i3);
                                return;
                            }
                        }
                        return;
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.GameListAdapter", e.getMessage());
                }
            }
        }
    };
    protected e nup;
    protected View.OnClickListener nva = new View.OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() instanceof d) {
                d dVar = (d) view.getTag();
                if (n.this.nyl.containsKey(dVar.field_appId)) {
                    o oVar = (o) n.this.nyl.get(dVar.field_appId);
                    oVar.cQ(n.this.mContext);
                    n.this.nup.nqO = dVar.ngQ;
                    n.this.nup.niV = n.this.niV;
                    n.this.nup.a(dVar, oVar);
                    return;
                }
                x.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
                return;
            }
            x.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
        }
    };
    protected int nyh;
    protected boolean nyi = true;
    protected boolean nyj = false;
    protected boolean nyk = false;
    protected ConcurrentHashMap<String, o> nyl;
    protected SparseArray<View> nym;

    public interface a {
        void ri(int i);
    }

    protected static class b {
        public ImageView nqo;
        public TextView nqp;
        public ViewGroup nrG;
        public TextView nyr;
        public TextView nys;
        public TextView nyt;
        public TextView nyu;
        public Button nyv;
        public TextProgressBar nyw;
        public GameListSocialView nyx;
        public ViewGroup nyy;
        public LinearLayout nyz;

        protected b() {
        }
    }

    abstract void a(d dVar, b bVar);

    abstract void a(d dVar, b bVar, int i);

    static /* synthetic */ void a(n nVar, LinkedList linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!(nVar.nyl.containsKey(dVar.field_appId) || dVar.type == 1 || dVar == null)) {
                o oVar = (o) nVar.nyl.get(dVar.field_appId);
                if (oVar == null) {
                    oVar = new o(dVar);
                    nVar.nyl.put(dVar.field_appId, oVar);
                }
                oVar.cQ(nVar.mContext);
                oVar.aQQ();
            }
        }
    }

    public n(Context context) {
        super(context);
        this.mContext = context;
        this.nyl = new ConcurrentHashMap();
        com.tencent.mm.plugin.game.model.n.a(this.nuo);
        this.nym = new SparseArray();
        this.nup = new e(context);
        this.nup.nre = this.nuZ;
    }

    public void rg(int i) {
        this.niV = i;
    }

    public void rj(int i) {
        this.nth = i;
    }

    public void refresh() {
        notifyDataSetChanged();
    }

    public void P(final LinkedList<d> linkedList) {
        if (linkedList != null) {
            as.Dt().F(new Runnable() {
                public final void run() {
                    n.a(n.this, linkedList);
                    ah.y(new Runnable() {
                        public final void run() {
                            super.P(linkedList);
                            x.i("MicroMsg.GameListAdapter", "add size: %d", Integer.valueOf(linkedList.size()));
                        }
                    });
                }
            });
        }
    }

    public void Q(final LinkedList<d> linkedList) {
        if (linkedList != null) {
            e.post(new Runnable() {
                public final void run() {
                    n.a(n.this, linkedList);
                    ah.y(new Runnable() {
                        public final void run() {
                            super.Q(linkedList);
                            x.i("MicroMsg.GameListAdapter", "set size: %d", Integer.valueOf(linkedList.size()));
                        }
                    });
                }
            }, "game_get_download_info");
        }
    }

    public int getItemViewType(int i) {
        return ((d) getItem(i)).type;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        d dVar = (d) getItem(i);
        if (view == null) {
            int i2;
            Context context = this.mContext;
            switch (dVar.type) {
                case 0:
                    i2 = this.nyh;
                    break;
                case 1:
                    i2 = R.i.ckG;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            view = View.inflate(context, i2, null);
            b bVar2 = new b();
            bVar2.nrG = (ViewGroup) view.findViewById(R.h.cuW);
            bVar2.nyr = (TextView) view.findViewById(R.h.cmZ);
            bVar2.nqo = (ImageView) view.findViewById(R.h.cmn);
            bVar2.nqp = (TextView) view.findViewById(R.h.cmX);
            bVar2.nys = (TextView) view.findViewById(R.h.cAc);
            bVar2.nyt = (TextView) view.findViewById(R.h.cmr);
            bVar2.nyu = (TextView) view.findViewById(R.h.ckV);
            bVar2.nyv = (Button) view.findViewById(R.h.clZ);
            bVar2.nyw = (TextProgressBar) view.findViewById(R.h.cmb);
            bVar2.nyz = (LinearLayout) view.findViewById(R.h.ckG);
            bVar2.nyx = (GameListSocialView) view.findViewById(R.h.cnm);
            bVar2.nyy = (ViewGroup) view.findViewById(R.h.cam);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        switch (dVar.type) {
            case 0:
                a(dVar, bVar, i);
                if (this.nth == 2 && !dVar.ngR) {
                    ap.a(this.mContext, 10, 1004, dVar.position, dVar.field_appId, this.niV, dVar.ngQ);
                    dVar.ngR = true;
                    break;
                }
            case 1:
                a(dVar, bVar);
                break;
        }
        return view;
    }

    public void b(SparseArray<View> sparseArray) {
        if (sparseArray != null) {
            this.nym = sparseArray;
        } else {
            this.nym = new SparseArray();
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.nrP = aVar;
    }

    public void x(View view, int i) {
        b bVar = (b) view.getTag();
        d dVar = (d) this.njn.get(i);
        if (bVar != null) {
            this.nup.a(bVar.nyw, bVar.nyv, dVar, (o) this.nyl.get(dVar.field_appId));
            return;
        }
        x.e("MicroMsg.GameListAdapter", "holder should not be null, %d", Integer.valueOf(i));
    }

    public void clear() {
        super.clear();
        com.tencent.mm.plugin.game.model.n.b(this.nuo);
    }

    public void CL(String str) {
        d dVar;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.njn.size()) {
                dVar = null;
                break;
            } else if (((d) this.njn.get(i2)).field_appId.equals(str)) {
                dVar = (d) this.njn.get(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        if (dVar != null) {
            if (this.nyl.containsKey(dVar.field_appId)) {
                this.nup.a(dVar, (o) this.nyl.get(dVar.field_appId));
                return;
            }
            x.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
        }
    }

    public void CK(String str) {
        if (!bi.oN(str) && this.nyl.containsKey(str)) {
            o oVar = (o) this.nyl.get(str);
            if (oVar != null) {
                oVar.aQQ();
            }
        }
    }

    public void CJ(String str) {
        if (!bi.oN(str) && this.nyl.containsKey(str)) {
            o oVar = (o) this.nyl.get(str);
            if (oVar != null) {
                oVar.aQR();
            }
        }
    }
}

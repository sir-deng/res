package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.n;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.record.ui.b.c;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.plugin.record.ui.b.e;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.LinkedList;
import java.util.List;

public abstract class h extends BaseAdapter {
    ListView Fv;
    protected Context context;
    private Runnable mxE = new Runnable() {
        public final void run() {
            x.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
            h.this.notifyDataSetChanged();
        }
    };
    protected ag pLF = null;
    SparseArray<b> pLG = new SparseArray();
    boolean pLH = false;
    private boolean pLI = false;
    protected a pLJ;
    protected a pLK;
    protected List<uz> pLo = new LinkedList();
    private int padding = com.tencent.mm.bu.a.fromDPToPix(this.context, 35);

    public interface a {

        public static class a {
            public uz fvZ;
            public ImageView fwa;
            public int fwb;
            public int height;
            public long pLM;
            public int width;
        }

        public static class b {
            public uz fvZ;
            public boolean fwc;
            public boolean fwd;
            public int maxWidth;
            public long pLM;
        }

        public static class c {
            public uz fvZ;
            public long pLM;
        }

        Bitmap a(b bVar);

        Bitmap a(c cVar);

        void a(a aVar);

        void bnB();
    }

    public interface b {
        void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar);

        void destroy();

        View dq(Context context);

        void pause();
    }

    public abstract void a(a aVar);

    public abstract void d(com.tencent.mm.plugin.record.ui.a.b bVar);

    public /* synthetic */ Object getItem(int i) {
        return vL(i);
    }

    public h(Context context, a aVar) {
        this.context = context;
        this.pLF = new ag(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                if (message.what == 1) {
                    x.d("MicroMsg.RecordMsgBaseAdapter", "do play music");
                    h.this.notifyDataSetChanged();
                }
            }
        };
        this.pLK = aVar;
    }

    public final void bnJ() {
        this.pLG.put(0, new d(this.context));
        this.pLG.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.pLK, this.Fv));
        this.pLG.put(2, new e());
        this.pLG.put(3, new com.tencent.mm.plugin.record.ui.b.b(this.pLK, this.pLF));
        this.pLG.put(4, new c(this.pLK));
    }

    public final void destroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.pLG.size()) {
                break;
            }
            b bVar = (b) this.pLG.valueAt(i2);
            if (bVar != null) {
                bVar.destroy();
            }
            i = i2 + 1;
        }
        if (this.pLK != null) {
            this.pLK.bnB();
            this.pLK = null;
        }
    }

    public int getItemViewType(int i) {
        return m(vL(i));
    }

    private static int m(uz uzVar) {
        switch (uzVar.bjS) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return 3;
        }
    }

    public int getViewTypeCount() {
        return 5;
    }

    public int getCount() {
        return this.pLo == null ? 0 : this.pLo.size();
    }

    private uz vL(int i) {
        if (this.pLo != null && i >= 0 && i < this.pLo.size()) {
            return (uz) this.pLo.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.record.ui.a.b aVar;
        uz vL = vL(i);
        b bVar = (b) this.pLG.get(m(vL));
        if (view == null) {
            view = bVar.dq(this.context);
        }
        switch (vL.bjS) {
            case 2:
                aVar = new com.tencent.mm.plugin.record.ui.a.a();
                break;
            case 15:
                aVar = new com.tencent.mm.plugin.record.ui.a.c();
                break;
            default:
                aVar = new com.tencent.mm.plugin.record.ui.a.b();
                break;
        }
        aVar.fvZ = vL;
        d(aVar);
        bVar.a(view, i, aVar);
        ImageView imageView = (ImageView) view.findViewById(R.h.cHb);
        TextView textView = (TextView) view.findViewById(R.h.cHf);
        textView.setText(i.b(textView.getContext(), vL.wkJ, textView.getTextSize()));
        textView = (TextView) view.findViewById(R.h.cHe);
        x.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", vL.wkL);
        if (vL.wkL != null) {
            if (this.pLH) {
                String str = vL.wkL;
                textView.setText(str.substring(str.indexOf("-") + 1));
            } else {
                String[] split = vL.wkL.split(" ");
                if (split.length < 2) {
                    textView.setText(vL.wkL);
                } else {
                    textView.setText(split[1]);
                }
            }
        }
        if (i == 0) {
            if (vL.wkH != null) {
                vb vbVar = vL.wkH.wlb;
                imageView.setVisibility(0);
                if (vbVar.wly) {
                    IR(vbVar.wlx);
                    if (com.tencent.mm.af.a.e.kp(vbVar.wlx)) {
                        o.PG().a(com.tencent.mm.af.a.e.ks(vbVar.wlx), imageView);
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, vbVar.wlx);
                    }
                } else if (!vbVar.wlt || (q.FY().equals(vbVar.fAJ) && vbVar.fAJ.equals(vbVar.toUser))) {
                    imageView.setVisibility(8);
                    view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
                    this.pLI = true;
                } else {
                    IR(vbVar.fAJ);
                    com.tencent.mm.pluginsdk.ui.a.b.a(imageView, vbVar.fAJ);
                }
            } else {
                imageView.setVisibility(8);
                view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
                this.pLI = true;
            }
        } else if (i <= 0 || this.pLI) {
            imageView.setVisibility(8);
            view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
        } else {
            String str2 = "";
            vb vbVar2 = vL.wkH.wlb;
            if (vL(i - 1).wkH.wlb.wly) {
                str2 = vL(i - 1).wkH.wlb.wlx;
            } else if (vL(i - 1).wkH.wlb.wlt) {
                str2 = vL(i - 1).wkH.wlb.fAJ;
            }
            imageView.setVisibility(0);
            String str3;
            if (vL.wkH.wlb.wly) {
                str3 = vL.wkH.wlb.wlx;
                if (str2.equals(str3)) {
                    imageView.setVisibility(4);
                } else {
                    IR(str3);
                    if (com.tencent.mm.af.a.e.kp(vbVar2.wlx)) {
                        o.PG().a(com.tencent.mm.af.a.e.ks(vbVar2.wlx), imageView);
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str3);
                    }
                }
            } else if (vL.wkH.wlb.wlt) {
                str3 = vL.wkH.wlb.fAJ;
                if (str2.equals(str3)) {
                    imageView.setVisibility(4);
                } else {
                    IR(str3);
                    com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str3);
                }
            } else {
                imageView.setVisibility(4);
            }
        }
        if (i == getCount() - 1) {
            view.findViewById(R.h.cHd).setVisibility(8);
        } else {
            view.findViewById(R.h.cHd).setVisibility(0);
        }
        return view;
    }

    private static void IR(String str) {
        if (!s.gH(str)) {
            com.tencent.mm.ac.h hVar = new com.tencent.mm.ac.h();
            hVar.username = str;
            n.JW().a(hVar);
        }
    }

    protected final void bnK() {
        this.pLF.post(this.mxE);
    }
}

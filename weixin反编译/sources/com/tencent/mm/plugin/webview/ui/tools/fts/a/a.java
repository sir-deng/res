package com.tencent.mm.plugin.webview.ui.tools.fts.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.t;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public final class a extends android.support.v7.widget.RecyclerView.a<t> {
    public List<c> hkf;
    List<View> tLo;
    List<View> tLp;
    public c tLq;
    private com.tencent.mm.ap.a.a.c trR;

    public class b extends t {
        private TextView ikn;
        private ImageView jTd;
        private TextView qdW;
        private View rts;
        private TextView tLu;
        private View tLv;

        public b(View view) {
            super(view);
            this.rts = view.findViewById(R.h.cIB);
            this.jTd = (ImageView) view.findViewById(R.h.coQ);
            this.ikn = (TextView) view.findViewById(R.h.cSB);
            this.qdW = (TextView) view.findViewById(R.h.cPj);
            this.tLu = (TextView) view.findViewById(R.h.cRR);
            this.tLv = view.findViewById(R.h.divider);
        }
    }

    public interface c {
        void a(c cVar);

        void b(c cVar);
    }

    public static class a extends t {
        FrameLayout tLt;

        public a(View view) {
            super(view);
            this.tLt = (FrameLayout) view;
        }
    }

    public a() {
        com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
        this.trR = aVar.PQ();
        this.hkf = new ArrayList();
        this.tLo = new ArrayList();
        this.tLp = new ArrayList();
    }

    public final t a(ViewGroup viewGroup, int i) {
        if (i == 333) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.i.diS, viewGroup, false));
        }
        View frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new LayoutParams(-1, -2));
        return new a(frameLayout);
    }

    public final void a(t tVar, int i) {
        if (i < this.tLo.size()) {
            a((a) tVar, (View) this.tLo.get(i));
        } else if (i >= this.tLo.size() + this.hkf.size()) {
            a((a) tVar, (View) this.tLp.get((i - this.hkf.size()) - this.tLo.size()));
        } else {
            CharSequence charSequence;
            b bVar = (b) tVar;
            int size = i - this.tLo.size();
            final c cVar = (c) this.hkf.get(size);
            x.v("FtsBrowseHistoryAdapter", "item %s", cVar.toString());
            bVar.ikn.setText(cVar.title);
            bVar.qdW.setText(cVar.bhd);
            TextView c = bVar.tLu;
            Context context = bVar.ikn.getContext();
            long j = cVar.timestamp;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                charSequence = "";
            } else {
                long timeInMillis = gregorianCalendar.getTimeInMillis();
                int i2;
                if ((timeInMillis - j) / 3600000 == 0) {
                    i2 = (int) ((timeInMillis - j) / 60000);
                    if (i2 <= 0) {
                        i2 = 1;
                    }
                    charSequence = context.getResources().getQuantityString(R.j.duF, i2, new Object[]{Integer.valueOf(i2)});
                } else {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                    long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
                    if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                        timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                        if (timeInMillis <= 0 || timeInMillis > 86400000) {
                            i2 = (int) (((gregorianCalendar2.getTimeInMillis() + 86400000) - j) / 86400000);
                            if (i2 <= 0) {
                                i2 = 1;
                            }
                            charSequence = context.getResources().getQuantityString(R.j.duG, i2, new Object[]{Integer.valueOf(i2)});
                        } else {
                            charSequence = context.getString(R.l.eji);
                        }
                    } else {
                        i2 = (int) ((timeInMillis - j) / 3600000);
                        if (i2 <= 0) {
                            i2 = 1;
                        }
                        charSequence = context.getResources().getQuantityString(R.j.duE, i2, new Object[]{Integer.valueOf(i2)});
                    }
                }
            }
            c.setText(charSequence);
            if (!TextUtils.isEmpty(cVar.iconUrl)) {
                com.tencent.mm.ap.a.a.PN().a(cVar.iconUrl, bVar.jTd, this.trR);
            }
            if (size == getItemCount() - 1) {
                bVar.tLv.setVisibility(8);
            } else {
                bVar.tLv.setVisibility(0);
            }
            bVar.rts.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (a.this.tLq != null) {
                        a.this.tLq.a(cVar);
                    }
                }
            });
            bVar.rts.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    if (a.this.tLq != null) {
                        a.this.tLq.b(cVar);
                    }
                    return true;
                }
            });
        }
    }

    public final int getItemCount() {
        return (this.tLo.size() + this.hkf.size()) + this.tLp.size();
    }

    private static void a(a aVar, View view) {
        aVar.tLt.removeAllViews();
        aVar.tLt.addView(view);
    }

    public final int bUN() {
        return this.hkf.size();
    }

    public final void ahM() {
        this.hkf.clear();
        this.UR.notifyChanged();
    }

    public final int getItemViewType(int i) {
        if (i < this.tLo.size()) {
            return 111;
        }
        if (i >= this.tLo.size() + this.hkf.size()) {
            return 222;
        }
        return 333;
    }
}

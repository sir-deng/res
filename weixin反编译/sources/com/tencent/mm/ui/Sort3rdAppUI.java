package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.ap.o;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.ui.widget.DragSortListView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.y.as;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort3rdAppUI extends MMActivity {
    private DragSortListView lIk;
    private a xVj;
    private long xVk;
    private List<f> xVl;

    private static class a extends ArrayAdapter<f> {
        private c lXC;
        List<f> lzC;
        private Context mContext;
        private long xVk;

        static class a {
            TextView ikL;
            ImageView jIs;
            View lzD;
            ImageView lzE;
            MMSwitchBtn tWk;

            public a(View view) {
                this.lzE = (ImageView) view.findViewById(R.h.coH);
                this.jIs = (ImageView) view.findViewById(R.h.coM);
                this.ikL = (TextView) view.findViewById(R.h.cSn);
                this.tWk = (MMSwitchBtn) view.findViewById(R.h.cQc);
                this.lzD = view.findViewById(R.h.bYH);
            }
        }

        public a(Context context, List<f> list, long j) {
            super(context, R.i.dsW, list);
            this.xVk = j;
            this.mContext = context;
            this.lzC = list;
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFA = R.g.bDV;
            this.lXC = aVar.PQ();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean z = true;
            if (view == null) {
                view = View.inflate(this.mContext, R.i.dsW, null);
                a aVar2 = new a(view);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            final f fVar = (f) getItem(i);
            aVar.ikL.setText(fVar.field_appName);
            Bitmap b = g.b(fVar.field_appId, 1, com.tencent.mm.bu.a.getDensity(this.mContext));
            if (b == null || b.isRecycled()) {
                o.PG().a(fVar.field_appIconUrl, aVar.jIs, this.lXC);
            } else {
                aVar.jIs.setImageBitmap(b);
            }
            MMSwitchBtn mMSwitchBtn = aVar.tWk;
            if ((fVar.field_appInfoFlag & 16384) != 0) {
                z = false;
            }
            mMSwitchBtn.nJ(z);
            aVar.tWk.zEt = new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
                public final void cy(boolean z) {
                    f fVar;
                    if (z) {
                        fVar = fVar;
                        fVar.field_appInfoFlag &= -16385;
                    } else {
                        fVar = fVar;
                        fVar.field_appInfoFlag |= 16384;
                    }
                    an.biT().a(fVar, new String[0]);
                }
            };
            view.setVisibility(0);
            return view;
        }
    }

    protected final int getLayoutId() {
        return R.i.dsV;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.xVk = getIntent().getLongExtra("KFlag", -1);
        initView();
        this.xVl = g.b((Context) this, this.xVk, true);
        final List ft = an.bZG().ft(this.xVk);
        if (ft != null && ft.size() > 0) {
            Collections.sort(this.xVl, new Comparator<f>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ft.indexOf(((f) obj2).field_appId) - ft.indexOf(((f) obj).field_appId);
                }
            });
        }
        this.xVj = new a(this, this.xVl, this.xVk);
        this.lIk.setAdapter(this.xVj);
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Sort3rdAppUI.this.finish();
                return true;
            }
        });
        setMMTitle(getString(R.l.dCu));
        this.lIk = (DragSortListView) findViewById(R.h.ctk);
        this.lIk.zAF = new DragSortListView.g() {
            public final void cu(int i, int i2) {
                f fVar = (f) Sort3rdAppUI.this.xVj.getItem(i);
                Sort3rdAppUI.this.xVj.remove(fVar);
                Sort3rdAppUI.this.xVj.insert(fVar, i2);
            }
        };
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        if (this.xVj != null) {
            List list = this.xVj.lzC;
            com.tencent.mm.pluginsdk.model.app.o bZG = an.bZG();
            long j = this.xVk;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delete from AppSort");
            stringBuilder.append(" where flag = ").append(j).append(" ");
            bZG.gLA.fD("AppSort", stringBuilder.toString());
            if (list != null && list.size() > 0) {
                as.Hm();
                j = com.tencent.mm.y.c.Fc().dA(Thread.currentThread().getId());
                com.tencent.mm.pluginsdk.model.app.o bZG2 = an.bZG();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < list.size()) {
                        n nVar = new n();
                        nVar.field_flag = this.xVk;
                        nVar.field_appId = ((f) list.get(i2)).field_appId;
                        nVar.field_sortId = i2;
                        bZG2.a(nVar);
                        i = i2 + 1;
                    } else {
                        as.Hm();
                        com.tencent.mm.y.c.Fc().fT(j);
                        return;
                    }
                }
            }
        }
    }
}

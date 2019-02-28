package com.tencent.mm.plugin.ipcall.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.v;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class IPCallMsgUI extends MMActivity {
    private View lap;
    private boolean laq = true;
    private ListView nQn;
    private a nQo;
    private View nQp;
    private com.tencent.mm.sdk.e.j.a nQq = new com.tencent.mm.sdk.e.j.a() {
        public final void a(String str, l lVar) {
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    synchronized (IPCallMsgUI.this.nQo) {
                        x.v("MicroMsg.IPCallMsgUI", "comment notify");
                        IPCallMsgUI.this.nQo.a(null, null);
                    }
                }
            });
        }
    };

    class a extends o<g> {
        int hLP = this.las;
        protected f kHo;
        protected c kHp;
        protected d kHr = new d() {
            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                if (z) {
                    nQt.add(mMSlideDelView);
                } else {
                    nQt.remove(mMSlideDelView);
                }
            }

            public final boolean aVe() {
                return nQt.size() > 0;
            }

            public final void aVf() {
                for (MMSlideDelView mMSlideDelView : nQt) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.cqp();
                    }
                }
                nQt.clear();
            }

            public final void aVg() {
                for (MMSlideDelView mMSlideDelView : nQt) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.cqo();
                    }
                }
                nQt.clear();
            }
        };
        int las = 10;
        private Set<MMSlideDelView> nQt = new HashSet();

        class a {
            TextView ikn;
            TextView ipP;
            TextView maq;

            a() {
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            g gVar = (g) obj;
            if (gVar == null) {
                gVar = new g();
                x.d("MicroMsg.IPCallMsgUI", "new IPCallMsg");
            }
            gVar.b(cursor);
            return gVar;
        }

        public a(Context context, g gVar) {
            super(context, gVar);
        }

        public final long getItemId(int i) {
            return ((g) getItem(i)).xrR;
        }

        protected final void XI() {
            aUU();
            XH();
        }

        public final void a(f fVar) {
            this.kHo = fVar;
        }

        public final void a(c cVar) {
            this.kHp = cVar;
        }

        public final synchronized void a(String str, l lVar) {
            super.a(str, lVar);
        }

        public final void XH() {
            this.hLP = i.aUn().getCount();
            h aUn = i.aUn();
            int i = this.las;
            setCursor(aUn.gLA.query("IPCallMsg", h.nMu, null, null, null, null, "pushTime desc limit " + i));
            notifyDataSetChanged();
        }

        public final boolean awL() {
            return this.las >= this.hLP;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            g gVar = (g) getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = v.fw(this.context).inflate(R.i.dmq, null);
                aVar = new a();
                aVar.ikn = (TextView) view.findViewById(R.h.cSo);
                aVar.ipP = (TextView) view.findViewById(R.h.bYM);
                aVar.maq = (TextView) view.findViewById(R.h.cRy);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.ikn.setText(gVar.field_title);
            aVar.ipP.setText(gVar.field_content);
            TextView textView = aVar.maq;
            Context context = IPCallMsgUI.this.mController.xRr;
            long j = gVar.field_pushTime * 1000;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
            String str = (String) DateFormat.format(context.getString(R.l.eiJ), j);
            if (str.indexOf("-") > 0) {
                charSequence = (str.split("-")[1] + " " + com.tencent.mm.plugin.ipcall.b.c.ap(context, str.split("-")[0]) + " ") + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.h(context, j));
            } else {
                long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis <= 0 || timeInMillis > 86400000) {
                    timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    charSequence = (timeInMillis <= 0 || timeInMillis > 86400000) ? str + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.h(context, j)) : context.getString(R.l.eji) + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.h(context, j));
                } else {
                    charSequence = ((String) com.tencent.mm.plugin.ipcall.b.c.h(context, j));
                }
            }
            textView.setText(charSequence);
            if ((gVar.field_isRead == (short) 1 ? 1 : null) != null) {
                aVar.ikn.setTextColor(IPCallMsgUI.this.getResources().getColor(R.e.bsR));
            } else {
                aVar.ikn.setTextColor(IPCallMsgUI.this.getResources().getColor(R.e.bsS));
            }
            return view;
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.dmr;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i.aUn().c(this.nQq);
        initView();
    }

    public void onDestroy() {
        x.d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
        i.aUn().j(this.nQq);
        this.nQo.aUU();
        h aUn = i.aUn();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isRead", Short.valueOf((short) 1));
        aUn.gLA.update(aUn.getTableName(), contentValues, "isRead!=? ", new String[]{"1"});
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.erR);
        this.nQp = findViewById(R.h.crk);
        this.nQn = (ListView) findViewById(R.h.crl);
        this.lap = v.fw(this).inflate(R.i.dny, null);
        this.nQn.addFooterView(this.lap);
        this.nQo = new a(this, new g());
        this.nQo.a(new c() {
            public final int ci(View view) {
                return IPCallMsgUI.this.nQn.getPositionForView(view);
            }
        });
        this.nQo.a(new f() {
            public final void t(View view, int i) {
                IPCallMsgUI.this.nQn.performItemClick(view, i, 0);
            }
        });
        this.nQo.xQN = new com.tencent.mm.ui.o.a() {
            public final void XF() {
            }

            public final void XE() {
                if (IPCallMsgUI.this.nQo.getCount() == 0) {
                    IPCallMsgUI.this.nQn.setVisibility(8);
                    IPCallMsgUI.this.nQp.setVisibility(0);
                    return;
                }
                IPCallMsgUI.this.nQn.setVisibility(0);
                IPCallMsgUI.this.nQp.setVisibility(8);
            }
        };
        this.nQn.setAdapter(this.nQo);
        this.nQn.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g gVar = (g) IPCallMsgUI.this.nQo.getItem(i);
                if (!bi.oN(gVar.field_descUrl)) {
                    int i2 = gVar.field_msgType;
                    com.tencent.mm.plugin.report.service.g.pWK.h(13780, Integer.valueOf(i2));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", gVar.field_descUrl);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.bl.d.b(IPCallMsgUI.this, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
        this.nQn.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    a b = IPCallMsgUI.this.nQo;
                    if (!b.awL()) {
                        b.las += 10;
                        if (b.las > b.hLP) {
                            b.las = b.hLP;
                        }
                    } else if (b.nQr.lap.getParent() != null) {
                        b.nQr.nQn.removeFooterView(b.nQr.lap);
                    }
                    IPCallMsgUI.this.nQo.a(null, null);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        if (this.nQo.getCount() == 0) {
            this.nQn.setVisibility(8);
            this.nQp.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.nQn.setVisibility(0);
            this.nQp.setVisibility(8);
            enableOptionMenu(true);
        }
        if (this.nQo.awL()) {
            this.nQn.removeFooterView(this.lap);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                IPCallMsgUI.this.finish();
                return true;
            }
        });
        if (this.nQo.awL()) {
            this.nQn.removeFooterView(this.lap);
        }
    }
}

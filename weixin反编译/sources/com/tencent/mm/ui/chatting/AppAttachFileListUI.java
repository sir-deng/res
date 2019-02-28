package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import junit.framework.Assert;

public class AppAttachFileListUI extends MMActivity implements com.tencent.mm.plugin.messenger.foundation.a.a.c.a {
    private OnItemClickListener kMo = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent = new Intent();
            intent.setClassName(AppAttachFileListUI.this, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", ((c) AppAttachFileListUI.this.yyf.get(i)).fFE.field_msgId);
            intent.setFlags(67108864);
            AppAttachFileListUI.this.startActivity(intent);
        }
    };
    private OnScrollListener lmb = new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && !AppAttachFileListUI.this.yyk && AppAttachFileListUI.this.yyj && absListView.getLastVisiblePosition() == AppAttachFileListUI.this.yyi.getCount()) {
                x.d("MicroMsg.AppAttachFileListUI", "need to add item");
                int e = AppAttachFileListUI.this.yym;
                new a(AppAttachFileListUI.this, (byte) 0).execute(new Integer[]{Integer.valueOf(e), Integer.valueOf(20)});
                AppAttachFileListUI.f(AppAttachFileListUI.this);
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ArrayList<c> yyf;
    private HashSet<Long> yyg;
    private ListView yyh;
    private b yyi;
    private boolean yyj = true;
    private boolean yyk = false;
    private View yyl;
    private int yym;

    private class c {
        public au fFE;
        public com.tencent.mm.x.g.a yyo;

        private c() {
        }

        /* synthetic */ c(AppAttachFileListUI appAttachFileListUI, byte b) {
            this();
        }
    }

    private class a extends AsyncTask<Integer, Integer, List<au>> {
        private a() {
        }

        /* synthetic */ a(AppAttachFileListUI appAttachFileListUI, byte b) {
            this();
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            Integer[] numArr = (Integer[]) objArr;
            int intValue = numArr[0].intValue();
            int intValue2 = numArr[1].intValue();
            String FY = q.FY();
            as.Hm();
            List N = com.tencent.mm.y.c.Fh().N(FY, intValue, intValue2);
            AppAttachFileListUI.this.yym = intValue2 + AppAttachFileListUI.this.yym;
            return N;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            List list = (List) obj;
            super.onPostExecute(list);
            AppAttachFileListUI.g(AppAttachFileListUI.this);
            AppAttachFileListUI.this.de(list);
            AppAttachFileListUI.this.yyi.notifyDataSetChanged();
        }
    }

    private class d {
        public MMImageView yyp;
        public TextView yyq;
        public TextView yyr;
        public TextView yys;

        private d() {
        }

        /* synthetic */ d(AppAttachFileListUI appAttachFileListUI, byte b) {
            this();
        }
    }

    private class b extends BaseAdapter {
        private b() {
        }

        /* synthetic */ b(AppAttachFileListUI appAttachFileListUI, byte b) {
            this();
        }

        public final int getCount() {
            return AppAttachFileListUI.this.yyf.size();
        }

        public final Object getItem(int i) {
            return AppAttachFileListUI.this.yyf.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            String str;
            if (view == null) {
                view = AppAttachFileListUI.this.getLayoutInflater().inflate(R.i.dap, viewGroup, false);
                Assert.assertNotNull(view);
                dVar = new d(AppAttachFileListUI.this, (byte) 0);
                dVar.yyp = (MMImageView) view.findViewById(R.h.chL);
                dVar.yyq = (TextView) view.findViewById(R.h.chN);
                dVar.yyr = (TextView) view.findViewById(R.h.chK);
                dVar.yys = (TextView) view.findViewById(R.h.chM);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            Assert.assertNotNull(dVar);
            c cVar = (c) AppAttachFileListUI.this.yyf.get(i);
            dVar.yyq.setText(cVar.yyo.title);
            if (cVar.fFE.field_isSend == 1) {
                str = "自己";
            } else {
                str = r.gw(cVar.yyo.fAJ);
            }
            dVar.yyr.setText(String.format("大小：%s，来自：%s", new Object[]{bi.by((long) cVar.yyo.hcM), str}));
            dVar.yys.setText(n.c(AppAttachFileListUI.this, cVar.fFE.field_createTime, true));
            dVar.yyp.setImageResource(com.tencent.mm.pluginsdk.model.r.Sd(cVar.yyo.hcN));
            return view;
        }
    }

    static /* synthetic */ void f(AppAttachFileListUI appAttachFileListUI) {
        x.d("MicroMsg.AppAttachFileListUI", "start to load");
        appAttachFileListUI.yyk = true;
        appAttachFileListUI.yyl.setVisibility(0);
    }

    static /* synthetic */ void g(AppAttachFileListUI appAttachFileListUI) {
        appAttachFileListUI.yyk = false;
        appAttachFileListUI.yyl.setVisibility(8);
        x.d("MicroMsg.AppAttachFileListUI", "stop to load");
    }

    protected final int getLayoutId() {
        return R.i.daq;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ehz);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppAttachFileListUI.this.finish();
                return true;
            }
        });
        this.yyh = (ListView) findViewById(R.h.chO);
        this.yyl = getLayoutInflater().inflate(R.i.dao, null);
        this.yyh.addFooterView(this.yyl);
        this.yyl.setVisibility(8);
        this.yyf = new ArrayList();
        this.yyg = new HashSet();
        String FY = q.FY();
        as.Hm();
        List N = com.tencent.mm.y.c.Fh().N(FY, 0, 20);
        this.yym += 20;
        de(N);
        this.yyi = new b();
        this.yyh.setAdapter(this.yyi);
        this.yyh.setOnItemClickListener(this.kMo);
        this.yyh.setOnScrollListener(this.lmb);
        as.Hm();
        com.tencent.mm.y.c.Fh().a((com.tencent.mm.plugin.messenger.foundation.a.a.c.a) this, getMainLooper());
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        as.Hm();
        com.tencent.mm.y.c.Fh().a((com.tencent.mm.plugin.messenger.foundation.a.a.c.a) this);
        super.onDestroy();
    }

    private void de(List<au> list) {
        if (list.size() < 20) {
            this.yyj = false;
            this.yyh.removeFooterView(this.yyl);
        }
        for (au auVar : list) {
            c ag = ag(auVar);
            if (ag != null && ag.yyo.type == 6 && this.yyg.add(Long.valueOf(auVar.field_msgId))) {
                this.yyf.add(ag);
            }
        }
        x.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", Integer.valueOf(list.size()), Integer.valueOf(this.yyf.size()));
    }

    private c ag(au auVar) {
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(auVar.field_content);
        if (fV == null) {
            return null;
        }
        c cVar = new c();
        cVar.fFE = auVar;
        cVar.yyo = fV;
        return cVar;
    }

    public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c cVar, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar2) {
        if ("insert".equals(cVar2.ouA)) {
            x.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
            for (int size = cVar2.ouB.size() - 1; size >= 0; size--) {
                au auVar = (au) cVar2.ouB.get(size);
                if (auVar.aNJ()) {
                    c ag = ag(auVar);
                    if (ag != null && ag.yyo.type == 6) {
                        this.yyf.add(0, ag);
                    }
                }
            }
            if (this.yyi != null) {
                this.yyi.notifyDataSetChanged();
            }
        }
    }
}

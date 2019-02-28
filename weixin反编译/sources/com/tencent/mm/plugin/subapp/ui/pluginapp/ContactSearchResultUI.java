package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.n;
import com.tencent.mm.af.m;
import com.tencent.mm.af.y;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.bfp;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.protocal.c.bgg;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI extends MMActivity {
    private static ag hcb = new ag(Looper.getMainLooper());
    private LinkedList<bfp> hfI = new LinkedList();
    private ListView seq;
    private b ser;
    private LinkedList<bgg> ses = new LinkedList();
    private Map<String, c> set;

    private class b extends BaseAdapter {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        public final int getCount() {
            return ContactSearchResultUI.this.hfI.size() + ContactSearchResultUI.this.ses.size();
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            int i2 = 8;
            if (view == null) {
                view = View.inflate(this.mContext, R.i.drC, null);
                d dVar2 = new d();
                dVar2.ikK = (ImageView) view.findViewById(R.h.bLE);
                dVar2.kKL = (TextView) view.findViewById(R.h.cAr);
                dVar2.kKM = view.findViewById(R.h.cUF);
                dVar2.kKN = (TextView) view.findViewById(R.h.cpV);
                dVar2.kKQ = view.findViewById(R.h.bNO);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            if (i >= ContactSearchResultUI.this.hfI.size()) {
                bgg bgg = (bgg) ContactSearchResultUI.this.ses.get(i - ContactSearchResultUI.this.hfI.size());
                dVar.username = bgg.kyG;
                dVar.iconUrl = bgg.wbZ;
                dVar.ikK.setTag(dVar.username);
                com.tencent.mm.pluginsdk.ui.a.b.a(dVar.ikK, dVar.username);
                dVar.kKM.setVisibility(8);
                dVar.kKQ.setVisibility(8);
                dVar.kKN.setText("");
                try {
                    dVar.kKL.setText(i.b(this.mContext, bgg.kzN, dVar.kKL.getTextSize()));
                } catch (Exception e) {
                    dVar.kKL.setText("");
                }
            } else {
                bfp bfp = (bfp) ContactSearchResultUI.this.hfI.get(i);
                if (bfp == null) {
                    x.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
                } else {
                    dVar.username = bfp.wfM.wRo;
                    dVar.iconUrl = bfp.wbZ;
                    dVar.ikK.setTag(dVar.username);
                    com.tencent.mm.pluginsdk.ui.a.b.a(dVar.ikK, dVar.username);
                    String str = bfp.wfM.wRo;
                    c cVar = (c) ContactSearchResultUI.this.set.get(str);
                    if (cVar == null) {
                        c cVar2 = new c();
                        ContactSearchResultUI.this.set.put(str, cVar2);
                        py pyVar = bfp.wCx;
                        if (pyVar != null) {
                            com.tencent.mm.af.d.b.d LF;
                            com.tencent.mm.af.d dVar3 = new com.tencent.mm.af.d();
                            dVar3.field_username = str;
                            dVar3.field_brandFlag = pyVar.hxs;
                            dVar3.field_brandIconURL = pyVar.hxv;
                            dVar3.field_brandInfo = pyVar.hxu;
                            dVar3.field_extInfo = pyVar.hxt;
                            if (dVar3.bK(false) != null) {
                                LF = dVar3.bK(false).LF();
                            } else {
                                LF = null;
                            }
                            if (LF != null) {
                                boolean z = dVar3.bK(false).LH() && !bi.oN(LF.hqV);
                                cVar2.kKJ = z;
                                cVar2.kKI = bfp.wCq != 0;
                            }
                        }
                        cVar = cVar2;
                    }
                    dVar.kKM.setVisibility(cVar.kKI ? 0 : 8);
                    View a = dVar.kKQ;
                    if (cVar.kKJ) {
                        i2 = 0;
                    }
                    a.setVisibility(i2);
                    x.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", Integer.valueOf(bfp.wCq));
                    try {
                        dVar.kKN.setText(i.b(this.mContext, bi.oM(bfp.hxh), dVar.kKN.getTextSize()));
                    } catch (Exception e2) {
                        dVar.kKN.setText("");
                    }
                    try {
                        TextView textView = dVar.kKL;
                        Context context = this.mContext;
                        CharSequence oM = !bi.oN(bfp.wzM.wRo) ? bfp.wzM.wRo : !bi.oN(bfp.hxj) ? bfp.hxj : bi.oM(bfp.wfM.wRo);
                        textView.setText(i.b(context, oM, dVar.kKL.getTextSize()));
                    } catch (Exception e3) {
                        dVar.kKL.setText("");
                    }
                }
            }
            return view;
        }
    }

    private static class c {
        protected boolean kKI;
        protected boolean kKJ;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    private static class d implements com.tencent.mm.af.m.a.a, Runnable {
        public String iconUrl;
        public ImageView ikK;
        public TextView kKL;
        public View kKM;
        public TextView kKN;
        private View kKQ;
        a sew = new a() {
            public final void run() {
                if (!bi.oN(this.username) && !bi.oN(d.this.username) && this.username.equals(d.this.username)) {
                    Bitmap d = m.d(this.username, this.iconUrl, 0);
                    if (d != null && !d.isRecycled()) {
                        Runnable runnable = d.this;
                        if (runnable.ikK != null) {
                            as.Dt().F(runnable);
                        }
                    }
                }
            }
        };
        public String username;

        public d() {
            y.Mt().a(this);
        }

        public final void run() {
            final Bitmap kj = m.kj(this.username);
            if (kj != null) {
                ContactSearchResultUI.hcb.post(new Runnable() {
                    public final void run() {
                        if (d.this.ikK != null && d.this.ikK.getTag() != null && d.this.username != null && d.this.username.equals(d.this.ikK.getTag())) {
                            d.this.ikK.setImageBitmap(kj);
                        }
                    }
                });
            } else {
                ContactSearchResultUI.hcb.post(new Runnable() {
                    public final void run() {
                        if (d.this.ikK != null) {
                            d.this.ikK.setImageResource(R.g.bAa);
                            d.this.sew.ey(d.this.username, d.this.iconUrl);
                            as.Dt().g(d.this.sew, 200);
                        }
                    }
                });
            }
        }

        public final void kl(String str) {
            if (str != null && str.equals(this.username)) {
                this.sew.ey(this.username, this.iconUrl);
                as.Dt().g(this.sew, 200);
            }
        }
    }

    private static abstract class a implements Runnable {
        public String iconUrl;
        public String username;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void ey(String str, String str2) {
            this.username = str;
            this.iconUrl = str2;
        }
    }

    static /* synthetic */ void a(ContactSearchResultUI contactSearchResultUI, bgg bgg) {
        int i = 1;
        Intent intent = new Intent();
        if (2 == bgg.wRE) {
            i = 15;
        } else if (1 != bgg.wRE) {
            i = 0;
        }
        com.tencent.mm.pluginsdk.ui.tools.c.a(intent, bgg, i);
        com.tencent.mm.bl.d.b(contactSearchResultUI, "profile", ".ui.ContactInfoUI", intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.dfg);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactSearchResultUI.this.finish();
                return true;
            }
        });
        this.set = new HashMap();
        this.seq = (ListView) findViewById(R.h.cHU);
        this.seq.setEmptyView((TextView) findViewById(R.h.empty));
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("result");
        final int intExtra = getIntent().getIntExtra("add_more_friend_search_scene", 0);
        if (byteArrayExtra != null) {
            try {
                bfr bfr = (bfr) new bfr().aH(byteArrayExtra);
                if (bfr != null) {
                    this.hfI = bfr.wrq;
                    if (!bi.oN(bfr.wfM.wRo)) {
                        LinkedList linkedList = this.hfI;
                        bfp bfp = new bfp();
                        bfp.wfM = bfr.wfM;
                        bfp.wzM = bfr.wzM;
                        bfp.wfA = bfr.wfA;
                        bfp.wfB = bfr.wfB;
                        bfp.hxe = bfr.hxe;
                        bfp.vNQ = bfr.vNQ;
                        bfp.hxf = bfr.hxf;
                        bfp.hxg = bfr.hxg;
                        bfp.hxh = bfr.hxh;
                        bfp.hxi = bfr.hxi;
                        bfp.wCq = bfr.wCq;
                        bfp.wCr = bfr.wCr;
                        bfp.wCs = bfr.wCs;
                        bfp.hxj = bfr.hxj;
                        bfp.hxl = bfr.hxl;
                        bfp.hxk = bfr.hxk;
                        bfp.hxm = bfr.hxm;
                        bfp.wCw = bfr.wCw;
                        bfp.hxn = bfr.hxn;
                        bfp.hxo = bfr.hxo;
                        bfp.wCx = bfr.wCx;
                        bfp.wbY = bfr.wbY;
                        bfp.wbZ = bfr.wbZ;
                        bfp.woW = bfr.woW;
                        bfp.wRE = bfr.wRE;
                        linkedList.add(bfp);
                    }
                    this.ses = bfr.wRK;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ContactSearchResultUI", e, "", new Object[0]);
            }
        }
        if (this.hfI.size() != 0 || !this.ses.isEmpty()) {
            this.ser = new b(this);
            this.seq.setAdapter(this.ser);
            this.seq.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    int headerViewsCount = i - ContactSearchResultUI.this.seq.getHeaderViewsCount();
                    if (headerViewsCount >= 0 && headerViewsCount < ContactSearchResultUI.this.seq.getCount()) {
                        if (headerViewsCount >= ContactSearchResultUI.this.hfI.size()) {
                            ContactSearchResultUI.a(ContactSearchResultUI.this, (bgg) ContactSearchResultUI.this.ses.get(i - ContactSearchResultUI.this.hfI.size()));
                            return;
                        }
                        bfp bfp = (bfp) ContactSearchResultUI.this.hfI.get(headerViewsCount);
                        String str = bfp.wfM.wRo;
                        as.Hm();
                        com.tencent.mm.f.b.ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
                        if (com.tencent.mm.k.a.ga(Xv.field_type)) {
                            Intent intent = new Intent();
                            intent.putExtra("Contact_User", str);
                            intent.putExtra("Contact_Scene", 3);
                            if (str != null && str.length() > 0) {
                                if (Xv.ciN()) {
                                    g.pWK.k(10298, str + ",35");
                                    intent.putExtra("Contact_Scene", 35);
                                }
                                com.tencent.mm.bl.d.b(ContactSearchResultUI.this, "profile", ".ui.ContactInfoUI", intent);
                                return;
                            }
                            return;
                        }
                        if ((bfp.wCq & 8) > 0) {
                            g.pWK.k(10298, bfp.wfM.wRo + ",35");
                        }
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", bfp.wfM.wRo);
                        intent2.putExtra("Contact_Alias", bfp.hxj);
                        intent2.putExtra("Contact_Nick", bfp.wzM.wRo);
                        intent2.putExtra("Contact_Signature", bfp.hxh);
                        intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.ai(bfp.hxn, bfp.hxf, bfp.hxg));
                        intent2.putExtra("Contact_Sex", bfp.hxe);
                        intent2.putExtra("Contact_VUser_Info", bfp.wCr);
                        intent2.putExtra("Contact_VUser_Info_Flag", bfp.wCq);
                        intent2.putExtra("Contact_KWeibo_flag", bfp.wCu);
                        intent2.putExtra("Contact_KWeibo", bfp.wCs);
                        intent2.putExtra("Contact_KWeiboNick", bfp.wCt);
                        intent2.putExtra("Contact_KSnsIFlag", bfp.wCw.hxp);
                        intent2.putExtra("Contact_KSnsBgId", bfp.wCw.hxr);
                        intent2.putExtra("Contact_KSnsBgUrl", bfp.wCw.hxq);
                        intent2.putExtra("Contact_Scene", 35);
                        if (intExtra != 0) {
                            intent2.putExtra("add_more_friend_search_scene", intExtra);
                        }
                        if (bfp.wCx != null) {
                            try {
                                intent2.putExtra("Contact_customInfo", bfp.wCx.toByteArray());
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.ContactSearchResultUI", e, "", new Object[0]);
                            }
                        }
                        if ((bfp.wCq & 8) > 0) {
                            g.pWK.k(10298, bfp.wfM.wRo + ",35");
                        }
                        com.tencent.mm.bl.d.b(ContactSearchResultUI.this, "profile", ".ui.ContactInfoUI", intent2);
                    }
                }
            });
            this.seq.setOnScrollListener(new com.tencent.mm.ui.applet.a());
        }
    }

    protected final int getLayoutId() {
        return R.i.dfg;
    }

    protected void onDestroy() {
        n.JY().cancel();
        if (this.set != null) {
            this.set.clear();
        }
        super.onDestroy();
    }
}

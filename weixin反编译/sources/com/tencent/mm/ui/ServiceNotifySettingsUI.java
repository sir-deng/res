package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.mz;
import com.tencent.mm.f.a.si;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.c.agf;
import com.tencent.mm.protocal.c.bic;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.y.as;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI extends MMActivity implements e {
    private DataSetObserver BD;
    private ListView Fv;
    private int mMode;
    private String mSceneId;
    private MMSwitchBtn sLs;
    private a xUT;
    private r xUU;

    private static class a extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mLayoutInflater;
        private int mMode;
        private OnClickListener mOnClickListener;
        private String mSceneId;
        LinkedList<a> xVb = new LinkedList();
        LinkedList<a> xVc = new LinkedList();
        private c xVd;

        private static class a {
            String title;
            String url;
            String username;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        private static class b {
            ImageView ikl;
            TextView ikn;
            TextView xVh;

            private b() {
            }

            /* synthetic */ b(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return Ev(i);
        }

        public a(Context context, LayoutInflater layoutInflater, final int i, String str) {
            this.mContext = context;
            this.mMode = i;
            this.mSceneId = str;
            this.mLayoutInflater = layoutInflater;
            this.mOnClickListener = new OnClickListener() {
                public final void onClick(View view) {
                    final String str = (String) view.getTag();
                    if (!TextUtils.isEmpty(str)) {
                        h.a(view.getContext(), i == 1 ? R.l.ezM : R.l.ezP, 0, i == 1 ? R.l.ezN : R.l.dGf, R.l.cancel, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                int i2 = 0;
                                while (i2 < a.this.xVb.size()) {
                                    a aVar = (a) a.this.xVb.get(i2);
                                    if (aVar == null || !str.equals(aVar.username)) {
                                        i2++;
                                    } else {
                                        a.this.xVc.add(a.this.xVb.remove(i2));
                                        a.this.notifyDataSetChanged();
                                        WxaAttributes rf = ((com.tencent.mm.plugin.appbrand.n.c) g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(str);
                                        String str = rf == null ? "" : rf.field_appId;
                                        if (i == 1) {
                                            x.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", Integer.valueOf(13798), Integer.valueOf(4), str, a.this.mSceneId);
                                            com.tencent.mm.plugin.report.service.g.pWK.h(13798, Integer.valueOf(4), str, Integer.valueOf(0), a.this.mSceneId, Long.valueOf(bi.Wx()));
                                            return;
                                        }
                                        com.tencent.mm.plugin.report.service.g.pWK.h(13796, Integer.valueOf(12), str, "", Integer.valueOf(0), Long.valueOf(bi.Wx()));
                                        return;
                                    }
                                }
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }, R.e.bsE);
                    }
                }
            };
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFJ = true;
            aVar.hFF = com.tencent.mm.modelappbrand.a.a.Jo();
            this.xVd = aVar.PQ();
        }

        public final int getCount() {
            return this.xVb.size();
        }

        private a Ev(int i) {
            return (a) this.xVb.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            a Ev = Ev(i);
            if (view == null) {
                view = this.mLayoutInflater.inflate(R.i.dsa, viewGroup, false);
                b bVar2 = new b();
                bVar2.ikl = (ImageView) view.findViewById(R.h.bLF);
                bVar2.ikn = (TextView) view.findViewById(R.h.cSo);
                bVar2.xVh = (TextView) view.findViewById(R.h.cHX);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            o.PG().a(Ev.url, bVar.ikl, this.xVd);
            bVar.ikn.setText(Ev.title);
            if (this.mMode == 1) {
                bVar.xVh.setText(this.mContext.getString(R.l.ezJ));
            } else {
                bVar.xVh.setText(this.mContext.getString(R.l.ezK));
            }
            bVar.xVh.setTag(Ev.username);
            bVar.xVh.setOnClickListener(this.mOnClickListener);
            return view;
        }
    }

    static /* synthetic */ void a(ServiceNotifySettingsUI serviceNotifySettingsUI, LinkedList linkedList) {
        Collection linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bic bic = (bic) it.next();
            a aVar = new a();
            aVar.username = bic.username;
            aVar.title = bic.fqG;
            aVar.url = bic.wSO;
            linkedList2.add(aVar);
        }
        a aVar2 = serviceNotifySettingsUI.xUT;
        aVar2.xVb.clear();
        if (!linkedList2.isEmpty()) {
            aVar2.xVb.addAll(linkedList2);
        }
        serviceNotifySettingsUI.xUT.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return R.i.dsb;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mMode = intent.getIntExtra("mode", 0);
        this.mSceneId = intent.getStringExtra("scene_id");
        intent.putExtra("scene_id", this.mSceneId);
        Object stringExtra = intent.getStringExtra("title");
        if (TextUtils.isEmpty(stringExtra)) {
            setMMTitle(R.l.ezR);
        } else {
            setMMTitle((String) stringExtra);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ServiceNotifySettingsUI.this.finish();
                return false;
            }
        });
        this.sLs = (MMSwitchBtn) findViewById(R.h.checkbox);
        this.Fv = (ListView) findViewById(R.h.ctk);
        ((TextView) findViewById(R.h.ctd)).setText(this.mMode == 1 ? R.l.ezD : R.l.ezA);
        ((TextView) findViewById(R.h.cSm)).setText(this.mMode == 1 ? R.l.ezE : R.l.ezF);
        this.xUT = new a(this, getLayoutInflater(), this.mMode, this.mSceneId);
        this.Fv.setAdapter(this.xUT);
        getString(R.l.dGZ);
        this.xUU = h.a((Context) this, getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                ServiceNotifySettingsUI.this.finish();
            }
        });
        this.BD = new DataSetObserver() {
            public final void onChanged() {
                ServiceNotifySettingsUI.this.findViewById(R.h.ctd).setVisibility(ServiceNotifySettingsUI.this.xUT.isEmpty() ? 4 : 0);
            }
        };
        this.xUT.registerDataSetObserver(this.BD);
        int i = 3;
        if (this.mMode == 1) {
            i = 12;
        }
        as.CN().a(1145, (e) this);
        as.CN().a(new l(i), 0);
        this.sLs.nJ(cor());
    }

    protected void onDestroy() {
        int i;
        int i2 = 3;
        as.CN().b(1145, (e) this);
        final boolean cor = cor();
        final boolean z = this.sLs.zEk != cor;
        final LinkedList linkedList = new LinkedList();
        if (z) {
            int i3;
            boolean z2;
            boh boh = new boh();
            if (this.sLs.zEk) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            boh.wXO = i3;
            if (this.mMode == 1) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            boh.kzz = i3;
            linkedList.add(boh);
            if (cor) {
                z2 = false;
            } else {
                z2 = true;
            }
            com.tencent.mm.storage.w.a aVar = com.tencent.mm.storage.w.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
            if (this.mMode == 1) {
                aVar = com.tencent.mm.storage.w.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
            }
            as.Hm();
            com.tencent.mm.y.c.Db().a(aVar, Boolean.valueOf(z2));
            com.tencent.mm.sdk.b.a.xmy.m(new mz());
            if (this.mMode == 1) {
                if (boh.wXO == 1) {
                    i3 = 3;
                } else {
                    i3 = 2;
                }
                x.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", Integer.valueOf(13798), Integer.valueOf(i3), this.mSceneId);
                com.tencent.mm.plugin.report.service.g.pWK.h(13798, Integer.valueOf(i3), "", Integer.valueOf(0), this.mSceneId, Long.valueOf(bi.Wx()));
            } else {
                i3 = boh.wXO == 1 ? 11 : 10;
                com.tencent.mm.plugin.report.service.g.pWK.h(13796, Integer.valueOf(i3), "", "", Integer.valueOf(0), Long.valueOf(bi.Wx()));
            }
        }
        if (this.mMode == 1) {
            i = 2;
        } else {
            i = 1;
        }
        LinkedList linkedList2 = this.xUT.xVc;
        if (!(linkedList2 == null || linkedList2.isEmpty())) {
            if (this.mMode != 1) {
                i2 = 1;
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                boh boh2 = new boh();
                boh2.wXP = aVar2.username;
                boh2.kzz = i2;
                boh2.wXO = 1;
                linkedList.add(boh2);
                b siVar = new si();
                siVar.fKS.foe = aVar2.username;
                siVar.fKS.action = 2;
                siVar.fKS.fKU = i;
                com.tencent.mm.sdk.b.a.xmy.m(siVar);
            }
        }
        if (!linkedList.isEmpty()) {
            as.CN().a(1176, new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    as.CN().b(1176, (e) this);
                    x.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i != 0 || i2 != 0) {
                        u.makeText(ServiceNotifySettingsUI.this, R.l.ezQ, 0).show();
                        if (z) {
                            as.Hm();
                            com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, Boolean.valueOf(cor));
                            com.tencent.mm.sdk.b.a.xmy.m(new mz());
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            boh boh = (boh) it.next();
                            b siVar = new si();
                            siVar.fKS.foe = boh.wXP;
                            siVar.fKS.action = 1;
                            siVar.fKS.fKU = i;
                            com.tencent.mm.sdk.b.a.xmy.m(siVar);
                        }
                    }
                }
            });
            as.CN().a(new com.tencent.mm.modelappbrand.k(linkedList), 0);
        }
        this.xUT.unregisterDataSetObserver(this.BD);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.xUU != null) {
            this.xUU.dismiss();
        }
        x.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            final agf Jh = ((l) kVar).Jh();
            if (this.mMode == 1) {
                this.sLs.nJ(Jh.wuL);
            } else {
                this.sLs.nJ(Jh.vSs);
            }
            runOnUiThread(new Runnable() {
                public final void run() {
                    if (ServiceNotifySettingsUI.this.mMode == 1) {
                        ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, Jh.wuM);
                    } else {
                        ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, Jh.vSt);
                    }
                }
            });
            return;
        }
        u.makeText(this, R.l.ezI, 0).show();
    }

    private boolean cor() {
        com.tencent.mm.storage.w.a aVar = com.tencent.mm.storage.w.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
        if (this.mMode == 1) {
            aVar = com.tencent.mm.storage.w.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
        }
        as.Hm();
        return com.tencent.mm.y.c.Db().getBoolean(aVar, true);
    }
}

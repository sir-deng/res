package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LaunchAAByPersonAmountSelectUI extends BaseAAPresenterActivity {
    private String fqA;
    private ag hbP = new ag(Looper.getMainLooper());
    private int ilA = -1;
    private boolean ilB;
    private boolean ilC = false;
    private Runnable ilD = new Runnable() {
        public final void run() {
            LaunchAAByPersonAmountSelectUI.this.Xk();
            LaunchAAByPersonAmountSelectUI.this.Xl();
        }
    };
    private com.tencent.mm.plugin.aa.a.c.c ilp = ((com.tencent.mm.plugin.aa.a.c.c) t(com.tencent.mm.plugin.aa.a.c.c.class));
    private ListView ilq;
    private TextView ilr;
    private TextView ils;
    private View ilt;
    private TextView ilu;
    private boolean ilv = false;
    private Map<String, String> ilw = new HashMap();
    private a ilx = null;
    private double ily;
    private long ilz = -1;

    private class a extends BaseAdapter {
        List<b> dataList;

        private class a {
            ImageView ikl;
            c ilK;
            TextView ill;
            WalletFormView ilm;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return jf(i);
        }

        public a(List<String> list, Map<String, Double> map) {
            this.dataList = null;
            this.dataList = new ArrayList();
            for (String str : list) {
                b bVar = new b(LaunchAAByPersonAmountSelectUI.this, (byte) 0);
                bVar.username = str;
                if (map == null || !map.containsKey(str)) {
                    bVar.ilL = "";
                } else {
                    bVar.ilL = LaunchAAByPersonAmountSelectUI.this.getString(i.uNp, new Object[]{map.get(str)});
                }
                this.dataList.add(bVar);
            }
        }

        public final int getCount() {
            return this.dataList.size();
        }

        private b jf(int i) {
            return (b) this.dataList.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b jf = jf(i);
            if (!(jf == null || bi.oN(jf.username))) {
                if (view == null) {
                    view = v.fw(LaunchAAByPersonAmountSelectUI.this).inflate(g.uID, viewGroup, false);
                    final a aVar = new a();
                    aVar.ikl = (ImageView) view.findViewById(f.bLD);
                    aVar.ill = (TextView) view.findViewById(f.cUw);
                    aVar.ilm = (WalletFormView) view.findViewById(f.uyc);
                    aVar.ilK = new c(jf.username);
                    aVar.ilm.a(aVar.ilK);
                    aVar.ikl.setOnTouchListener(new OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            aVar.ilm.requestFocus();
                            return false;
                        }
                    });
                    aVar.ill.setOnTouchListener(new OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            aVar.ilm.requestFocus();
                            return false;
                        }
                    });
                    view.setTag(aVar);
                    LaunchAAByPersonAmountSelectUI.this.a(aVar.ilm, 2, false, true);
                }
                a aVar2 = (a) view.getTag();
                if (!bi.oN(jf.username)) {
                    aVar2.ilK.username = jf.username;
                    com.tencent.mm.pluginsdk.ui.a.b.a(aVar2.ikl, jf.username);
                    aVar2.ill.setText(com.tencent.mm.pluginsdk.ui.d.i.b(LaunchAAByPersonAmountSelectUI.this.mController.xRr, ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.a.b.class)).L(jf.username, LaunchAAByPersonAmountSelectUI.this.fqA), aVar2.ill.getTextSize()));
                }
                if (!(jf.ilL == null || aVar2.ilm.getText() == null || jf.ilL.equals(aVar2.ilm.getText().toLowerCase()))) {
                    WalletFormView walletFormView = aVar2.ilm;
                    TextWatcher textWatcher = aVar2.ilK;
                    if (walletFormView.zSS != null) {
                        walletFormView.zSS.removeTextChangedListener(textWatcher);
                    }
                    aVar2.ilm.setText(jf.ilL);
                    aVar2.ilm.a(aVar2.ilK);
                }
            }
            return view;
        }
    }

    private class b {
        String ilL;
        String username;

        private b() {
            this.username = null;
            this.ilL = null;
        }

        /* synthetic */ b(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI, byte b) {
            this();
        }
    }

    protected class c implements TextWatcher {
        String username;

        public c(String str) {
            this.username = str;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            try {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, "0");
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                int lastIndexOf = obj.lastIndexOf(".");
                if (lastIndexOf != indexOf && lastIndexOf > 0 && length > lastIndexOf) {
                    editable.delete(lastIndexOf, length);
                }
            } catch (Exception e) {
            }
            if (bi.N(editable) || bi.getDouble(editable.toString(), 0.0d) <= 0.0d) {
                LaunchAAByPersonAmountSelectUI.this.ilw.remove(this.username);
            } else {
                LaunchAAByPersonAmountSelectUI.this.ilw.put(this.username, editable.toString());
            }
            LaunchAAByPersonAmountSelectUI.this.hbP.removeCallbacks(LaunchAAByPersonAmountSelectUI.this.ilD);
            LaunchAAByPersonAmountSelectUI.this.hbP.postDelayed(LaunchAAByPersonAmountSelectUI.this.ilD, 50);
        }
    }

    static /* synthetic */ void d(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        launchAAByPersonAmountSelectUI.Xk();
        launchAAByPersonAmountSelectUI.Xl();
        if (!launchAAByPersonAmountSelectUI.ilB) {
            ArrayList arrayList = new ArrayList();
            for (String str : launchAAByPersonAmountSelectUI.ilw.keySet()) {
                arrayList.add(str + "," + ((String) launchAAByPersonAmountSelectUI.ilw.get(str)));
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selectUI", arrayList);
            launchAAByPersonAmountSelectUI.setResult(-1, intent);
            launchAAByPersonAmountSelectUI.finish();
        }
    }

    static /* synthetic */ void m(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        try {
            launchAAByPersonAmountSelectUI.ilr.setTextColor(launchAAByPersonAmountSelectUI.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhf));
            launchAAByPersonAmountSelectUI.ilv = false;
            launchAAByPersonAmountSelectUI.ily = 0.0d;
            launchAAByPersonAmountSelectUI.ils.setText(launchAAByPersonAmountSelectUI.getString(i.uPW, new Object[]{Double.valueOf(launchAAByPersonAmountSelectUI.ily)}));
            launchAAByPersonAmountSelectUI.ilw.clear();
            launchAAByPersonAmountSelectUI.Xk();
            launchAAByPersonAmountSelectUI.Xl();
            if (launchAAByPersonAmountSelectUI.ilx != null) {
                a aVar = launchAAByPersonAmountSelectUI.ilx;
                for (b bVar : aVar.dataList) {
                    bVar.ilL = "";
                }
                aVar.notifyDataSetChanged();
            }
        } catch (Exception e) {
            x.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "clearAmount error: %s", e.getMessage());
        }
        com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(3), Integer.valueOf(9));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uPX);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (LaunchAAByPersonAmountSelectUI.this.ilw == null || LaunchAAByPersonAmountSelectUI.this.ilw.size() <= 0) {
                    LaunchAAByPersonAmountSelectUI.this.finish();
                } else {
                    h.a(LaunchAAByPersonAmountSelectUI.this, LaunchAAByPersonAmountSelectUI.this.getString(i.uNO), null, LaunchAAByPersonAmountSelectUI.this.getString(i.uNR), LaunchAAByPersonAmountSelectUI.this.getString(i.uNQ), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            LaunchAAByPersonAmountSelectUI.d(LaunchAAByPersonAmountSelectUI.this);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            LaunchAAByPersonAmountSelectUI.this.finish();
                        }
                    });
                }
                return true;
            }
        });
        a(233, getString(i.dGf), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (LaunchAAByPersonAmountSelectUI.this.ilA <= 0 || LaunchAAByPersonAmountSelectUI.this.ilw == null || LaunchAAByPersonAmountSelectUI.this.ilw.size() <= LaunchAAByPersonAmountSelectUI.this.ilA) {
                    LaunchAAByPersonAmountSelectUI.d(LaunchAAByPersonAmountSelectUI.this);
                    com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(3), Integer.valueOf(4));
                } else {
                    h.b(LaunchAAByPersonAmountSelectUI.this.mController.xRr, LaunchAAByPersonAmountSelectUI.this.getString(i.uPY, new Object[]{Integer.valueOf(LaunchAAByPersonAmountSelectUI.this.ilA)}), "", true);
                    com.tencent.mm.plugin.report.service.g.pWK.h(13722, Integer.valueOf(8));
                }
                return true;
            }
        }, com.tencent.mm.ui.p.b.xSe);
        this.ilq = (ListView) findViewById(f.uld);
        this.ilr = (TextView) findViewById(f.uom);
        this.ils = (TextView) findViewById(f.ule);
        this.ils.setText(getString(i.uPW, new Object[]{Float.valueOf(0.0f)}));
        this.ilt = findViewById(f.uDg);
        this.ilu = (TextView) findViewById(f.ukY);
        this.ilc = this.ilq;
        this.ilt.setVisibility(8);
        this.ilr.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!LaunchAAByPersonAmountSelectUI.this.ilv) {
                    return true;
                }
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    LaunchAAByPersonAmountSelectUI.this.ilr.setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.brC));
                } else if (LaunchAAByPersonAmountSelectUI.this.ilv) {
                    LaunchAAByPersonAmountSelectUI.this.ilr.setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.brB));
                } else {
                    LaunchAAByPersonAmountSelectUI.this.ilr.setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhf));
                }
                return false;
            }
        });
        this.ilr.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (LaunchAAByPersonAmountSelectUI.this.ilw != null && LaunchAAByPersonAmountSelectUI.this.ilw.size() > 0) {
                    try {
                        com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(LaunchAAByPersonAmountSelectUI.this);
                        aVar.ET(i.uNq);
                        aVar.EV(i.dGf).a(new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                LaunchAAByPersonAmountSelectUI.m(LaunchAAByPersonAmountSelectUI.this);
                            }
                        });
                        aVar.EW(i.dEy).b(new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(3), Integer.valueOf(10));
                            }
                        });
                        aVar.ale().show();
                    } catch (Exception e) {
                        x.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "clear amount error");
                    }
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(3), Integer.valueOf(8));
            }
        });
        this.ilv = true;
        this.ilq.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 1) {
                    LaunchAAByPersonAmountSelectUI.this.Xj();
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.fqA = getIntent().getStringExtra("chatroom");
        this.ilz = getIntent().getLongExtra("maxPerAmount", -1);
        this.ilA = getIntent().getIntExtra("maxUserNumber", -1);
        ArrayList stringArrayListExtra = getIntent().getStringArrayListExtra("oldAmountData");
        x.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, oldDataList: %s", this.fqA, Long.valueOf(this.ilz), stringArrayListExtra);
        this.ilw = new HashMap();
        final HashMap hashMap = new HashMap();
        if (stringArrayListExtra != null) {
            try {
                if (stringArrayListExtra.size() > 0) {
                    Iterator it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        String[] split = ((String) it.next()).split(",");
                        if (split != null && split.length == 2) {
                            hashMap.put(split[0], Double.valueOf(bi.getDouble(split[1], 0.0d)));
                            this.ilw.put(split[0], getString(i.uNp, new Object[]{Double.valueOf(r4)}));
                        }
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate parse old data error: %s", e.getMessage());
            }
        }
        this.ilp.K(com.tencent.mm.plugin.aa.a.c.c.a.class);
        this.ilp.a(com.tencent.mm.plugin.aa.a.c.c.a.class, new com.tencent.mm.vending.app.a.b<com.tencent.mm.plugin.aa.a.c.c.a>() {
            public final /* synthetic */ void aX(Object obj) {
                com.tencent.mm.plugin.aa.a.c.c.a aVar = (com.tencent.mm.plugin.aa.a.c.c.a) obj;
                String str = "MicroMsg.LaunchAAByPersonAmountSelectUI";
                String str2 = "get selectMembers: %s, list.size: %s";
                Object[] objArr = new Object[2];
                objArr[0] = aVar;
                objArr[1] = aVar != null ? Integer.valueOf(aVar.gKH.size()) : "0";
                x.i(str, str2, objArr);
                LaunchAAByPersonAmountSelectUI.this.ilq.addFooterView(v.fw(LaunchAAByPersonAmountSelectUI.this).inflate(g.uHr, null));
                LaunchAAByPersonAmountSelectUI.this.ilq.addHeaderView(v.fw(LaunchAAByPersonAmountSelectUI.this).inflate(g.uHx, null));
                if (!(aVar == null || aVar.gKH == null || aVar.gKH.size() <= 0)) {
                    LaunchAAByPersonAmountSelectUI.this.ilx = new a(aVar.gKH, hashMap);
                    LaunchAAByPersonAmountSelectUI.this.ilq.setAdapter(LaunchAAByPersonAmountSelectUI.this.ilx);
                }
                LaunchAAByPersonAmountSelectUI.this.ilt.setVisibility(0);
                LaunchAAByPersonAmountSelectUI.this.hbP.post(LaunchAAByPersonAmountSelectUI.this.ilD);
            }
        });
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void Xk() {
        try {
            this.ily = 0.0d;
            this.ilB = false;
            if (this.ilw != null) {
                for (String str : this.ilw.values()) {
                    double d = bi.getDouble(str, 0.0d);
                    this.ily += d;
                    if (this.ilz > 0 && d * 100.0d > ((double) this.ilz)) {
                        this.ilB = true;
                    }
                }
                if (this.ilx != null) {
                    a aVar = this.ilx;
                    Map map = this.ilw;
                    for (b bVar : aVar.dataList) {
                        bVar.ilL = "";
                    }
                    if (map != null && map.size() > 0) {
                        for (b bVar2 : aVar.dataList) {
                            if (map.containsKey(bVar2.username)) {
                                bVar2.ilL = (String) map.get(bVar2.username);
                            }
                        }
                    }
                }
            }
            this.ils.setText(getString(i.uPW, new Object[]{Double.valueOf(this.ily)}));
            if (this.ilw == null || this.ilw.size() <= 0) {
                updateOptionMenuText(233, getString(i.dGf));
            } else {
                updateOptionMenuText(233, getString(i.uNw, new Object[]{Integer.valueOf(this.ilw.size())}));
            }
            if (this.ilB) {
                com.tencent.mm.plugin.report.service.g.pWK.h(13722, Integer.valueOf(7));
                enableOptionMenu(233, false);
                CharSequence string = getString(i.uQg, new Object[]{Float.valueOf(((float) this.ilz) / 100.0f)});
                if (!bi.oN(string)) {
                    this.ilu.setText(string);
                    if (!this.ilu.isShown()) {
                        this.ilu.startAnimation(AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.wxpay.a.a.ugM));
                        this.ilu.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            enableOptionMenu(233, true);
            if (this.ilu.isShown()) {
                this.ilu.setText("");
                this.ilu.startAnimation(AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.wxpay.a.a.ugN));
                this.ilu.setVisibility(8);
            }
        } catch (Exception e) {
            x.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", e.getMessage());
        }
    }

    private void Xl() {
        if (this.ily > 0.0d) {
            this.ilv = true;
            this.ilr.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.brB));
            return;
        }
        this.ilv = false;
        this.ilr.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhf));
    }

    protected final int getLayoutId() {
        return g.uIE;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.ilw != null) {
            this.ilw.clear();
        }
    }
}

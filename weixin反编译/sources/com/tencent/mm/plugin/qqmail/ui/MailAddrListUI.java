package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailAddrListUI extends MMActivity {
    private j puH = null;
    private r pyn = null;
    private TextView pyo = null;
    private TextView pyp = null;
    private ListView pyq;
    private a pyr;
    private List<i> pys;
    private com.tencent.mm.plugin.qqmail.b.j.a pyt = new com.tencent.mm.plugin.qqmail.b.j.a() {
        public final void onComplete() {
            if (MailAddrListUI.this.pyn != null) {
                MailAddrListUI.this.pyn.dismiss();
            }
            MailAddrListUI.this.pys = MailAddrListUI.this.puH.Io(null);
            if (MailAddrListUI.this.pys.size() == 0) {
                MailAddrListUI.this.pyo.setText(R.l.eNa);
                MailAddrListUI.this.pyo.setVisibility(0);
            }
            String[] stringArrayExtra = MailAddrListUI.this.getIntent().getStringArrayExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA");
            for (String Ip : stringArrayExtra == null ? new String[]{""} : stringArrayExtra) {
                i Ip2 = j.Ip(Ip);
                if (Ip2 != null) {
                    int i;
                    for (i iVar : MailAddrListUI.this.pys) {
                        if (iVar.nWa.equalsIgnoreCase(Ip2.nWa)) {
                            MailAddrListUI.this.pyr.c(iVar);
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        MailAddrListUI.this.pyr.c(Ip2);
                    }
                }
            }
            MailAddrListUI.this.setMMTitle(MailAddrListUI.this.getString(R.l.eAt) + (MailAddrListUI.this.pyr.blz() > 0 ? "(" + MailAddrListUI.this.pyr.blz() + ")" : ""));
            MailAddrListUI.this.pyr.notifyDataSetChanged();
        }
    };

    class a extends BaseAdapter {
        private final Context context;
        boolean pyv = false;
        boolean pyw = false;
        Map<String, i> pyx = new HashMap();

        class a {
            CheckBox ikN;
            TextView lmk;
            TextView pyy;
            TextView pyz;

            a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return vv(i);
        }

        public a(Context context) {
            this.context = context;
        }

        public final void c(i iVar) {
            this.pyx.put(iVar.nWa, iVar);
        }

        public final int blz() {
            return this.pyx.size();
        }

        public final int getCount() {
            int size = MailAddrListUI.this.pys.size();
            if (size != 0) {
                return !this.pyw ? size + 1 : size;
            } else {
                if (this.pyv) {
                    return 1;
                }
                return 0;
            }
        }

        private TextView blA() {
            TextView textView = new TextView(this.context);
            textView.setBackgroundResource(R.g.bDr);
            textView.setTextColor(WebView.NIGHT_MODE_COLOR);
            textView.setTextSize(0, (float) MailAddrListUI.this.getResources().getDimensionPixelSize(R.f.bvt));
            int dimensionPixelSize = MailAddrListUI.this.getResources().getDimensionPixelSize(R.f.bvw);
            int dimensionPixelSize2 = MailAddrListUI.this.getResources().getDimensionPixelSize(R.f.bvT);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            return textView;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean z;
            if (i == 0) {
                if (this.pyv) {
                    view = blA();
                    view.setText(R.l.eAA);
                    int dimensionPixelSize = MailAddrListUI.this.getResources().getDimensionPixelSize(R.f.bvw);
                    view.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    view.setTextSize(0, (float) MailAddrListUI.this.getResources().getDimensionPixelSize(R.f.but));
                    view.setGravity(17);
                    return view;
                } else if (!this.pyw) {
                    view = blA();
                    view.setText(R.l.eAz);
                    return view;
                }
            }
            if (view == null || view.getTag() == null) {
                a aVar2 = new a();
                view = View.inflate(this.context, R.i.dqb, null);
                aVar2.pyy = (TextView) view.findViewById(R.h.cEH);
                aVar2.lmk = (TextView) view.findViewById(R.h.cEI);
                aVar2.pyz = (TextView) view.findViewById(R.h.cEG);
                aVar2.ikN = (CheckBox) view.findViewById(R.h.cEJ);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            i vv = vv(i);
            if (this.pyw || i <= 10) {
                aVar.pyy.setVisibility(8);
            } else {
                i vv2 = vv(i - 1);
                if (i == 11) {
                    vv2 = null;
                }
                String d = d(vv);
                String d2 = d(vv2);
                if (d == null) {
                    aVar.pyy.setVisibility(8);
                } else if (d.equals(d2)) {
                    aVar.pyy.setVisibility(8);
                } else {
                    aVar.pyy.setText(d.toUpperCase());
                    aVar.pyy.setVisibility(0);
                }
            }
            aVar.lmk.setText(vv.name);
            aVar.pyz.setText(vv.nWa);
            CheckBox checkBox = aVar.ikN;
            if (this.pyx.get(vv.nWa) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
            return view;
        }

        private static String d(i iVar) {
            if (iVar == null) {
                return null;
            }
            String Ik = com.tencent.mm.plugin.qqmail.b.a.Ik(iVar.pul);
            char charAt = Ik.length() > 1 ? Ik.charAt(0) : '~';
            switch (charAt) {
                case '{':
                    charAt = Ik.charAt(1);
                    if (bi.p(charAt)) {
                        return String.valueOf(charAt);
                    }
                    return "~";
                case '~':
                    return "~";
                default:
                    if (bi.o(charAt)) {
                        return String.valueOf(charAt);
                    }
                    return "~";
            }
        }

        public final i vv(int i) {
            if (!this.pyw) {
                i = i == 0 ? 0 : i - 1;
            }
            return (i) MailAddrListUI.this.pys.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final boolean areAllItemsEnabled() {
            return false;
        }

        public final boolean isEnabled(int i) {
            if (i == 0) {
                return this.pyw;
            }
            return true;
        }
    }

    protected final int getLayoutId() {
        return R.i.dqa;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eAt);
        this.pys = new ArrayList();
        this.puH = w.bkZ().puH;
        initView();
        this.puH.a(this.pyt);
        this.puH.bkP();
    }

    protected final void initView() {
        this.pyq = (ListView) findViewById(R.h.cEK);
        this.pyo = (TextView) findViewById(R.h.ceu);
        this.pyp = (TextView) findViewById(R.h.cAE);
        this.pyr = new a(this);
        p pVar = new p(true, true);
        pVar.zvw = new b() {
            public final void XC() {
            }

            public final void XD() {
            }

            public final boolean pc(String str) {
                return false;
            }

            public final void pd(String str) {
                String aD = bi.aD(str, "");
                MailAddrListUI.this.pys = MailAddrListUI.this.puH.Io(aD.toLowerCase().trim());
                if (aD.length() > 0) {
                    MailAddrListUI.this.pyr.pyw = true;
                } else {
                    MailAddrListUI.this.pyr.pyw = false;
                }
                MailAddrListUI.this.pyr.pyv = false;
                if (MailAddrListUI.this.pys.size() == 0) {
                    MailAddrListUI.this.enableOptionMenu(false);
                    MailAddrListUI.this.pyp.setVisibility(0);
                } else {
                    MailAddrListUI.this.enableOptionMenu(true);
                    MailAddrListUI.this.pyp.setVisibility(8);
                }
                MailAddrListUI.this.pyr.notifyDataSetChanged();
            }

            public final void XA() {
            }

            public final void XB() {
            }
        };
        a(pVar);
        this.pyq.setAdapter(this.pyr);
        this.pyq.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a e = MailAddrListUI.this.pyr;
                i vv = e.vv(i - MailAddrListUI.this.pyq.getHeaderViewsCount());
                String str = vv.nWa;
                if (e.pyx.containsKey(str)) {
                    e.pyx.remove(str);
                } else {
                    e.pyx.put(str, vv);
                }
                e.notifyDataSetChanged();
                MailAddrListUI.this.setMMTitle(MailAddrListUI.this.getString(R.l.eAt) + (MailAddrListUI.this.pyr.blz() > 0 ? "(" + MailAddrListUI.this.pyr.blz() + ")" : ""));
            }
        });
        this.pyq.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (1 == i) {
                    MailAddrListUI.this.aWY();
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.pys = this.puH.Io(null);
        this.pyr.notifyDataSetChanged();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MailAddrListUI.this.setResult(0);
                MailAddrListUI.this.finish();
                return true;
            }
        });
        AnonymousClass6 anonymousClass6 = new OnClickListener() {
            public final void onClick(View view) {
                c.a(MailAddrListUI.this.pyq);
            }
        };
        addTextOptionMenu(0, getString(R.l.eAs), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                a e = MailAddrListUI.this.pyr;
                List arrayList = new ArrayList();
                for (String str : e.pyx.keySet()) {
                    arrayList.add(e.pyx.get(str));
                }
                ComposeUI.bs(arrayList);
                MailAddrListUI.this.setResult(-1);
                MailAddrListUI.this.finish();
                return true;
            }
        });
        enableOptionMenu(!this.pys.isEmpty());
        Context context = this.mController.xRr;
        getString(R.l.dGZ);
        this.pyn = h.a(context, getString(R.l.eAr), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.pyr.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.puH.b(this.pyt);
    }
}

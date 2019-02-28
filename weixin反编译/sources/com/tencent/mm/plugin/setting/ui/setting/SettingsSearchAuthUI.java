package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.modelsimple.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.modelsimple.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bsw;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SettingsSearchAuthUI extends MMActivity implements e {
    private ListView Fv;
    private ProgressDialog nRI;
    private byte[] qma;
    private boolean qpD;
    private com.tencent.mm.ui.fts.widget.a qqM;
    private View qqN;
    private TextView qqO;
    private TextView qqP;
    private List<bsw> qqQ = new ArrayList();
    private a qqR;

    private class a extends BaseAdapter {
        List<bsw> qpF;

        private class a {
            TextView ldJ;
            Button lmo;
            TextView qpJ;
            TextView qpK;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        private a() {
        }

        /* synthetic */ a(SettingsSearchAuthUI settingsSearchAuthUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            return wl(i);
        }

        public final int getCount() {
            if (this.qpF == null || this.qpF.isEmpty()) {
                return 0;
            }
            return this.qpF.size();
        }

        public final bsw wl(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return (bsw) this.qpF.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = SettingsSearchAuthUI.this.getLayoutInflater().inflate(R.i.dsj, null);
                a aVar2 = new a();
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.ldJ = (TextView) view.findViewById(R.h.cMo);
            aVar.qpJ = (TextView) view.findViewById(R.h.cMp);
            aVar.qpK = (TextView) view.findViewById(R.h.cMn);
            aVar.lmo = (Button) view.findViewById(R.h.cMm);
            aVar.lmo.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (a.this.wl(i) != null) {
                        final k bVar = new b(a.this.wl(i).fGh, 2);
                        if (SettingsSearchAuthUI.this.nRI != null) {
                            SettingsSearchAuthUI.this.nRI.dismiss();
                        }
                        g.CN().a(bVar, 0);
                        SettingsSearchAuthUI.this.nRI = h.a(SettingsSearchAuthUI.this, SettingsSearchAuthUI.this.getString(R.l.dGM), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                g.CN().c(bVar);
                            }
                        });
                    }
                }
            });
            if (SettingsSearchAuthUI.this.qpD) {
                aVar.lmo.setVisibility(0);
            } else {
                aVar.lmo.setVisibility(8);
            }
            if (wl(i) != null) {
                aVar.ldJ.setText(wl(i).hea);
                aVar.qpJ.setText(wl(i).xaM);
                aVar.qpK.setText(SettingsSearchAuthUI.bH(wl(i).xaL));
            }
            return view;
        }
    }

    static /* synthetic */ void a(SettingsSearchAuthUI settingsSearchAuthUI) {
        settingsSearchAuthUI.qqN.setVisibility(0);
        settingsSearchAuthUI.qqO.setVisibility(0);
        settingsSearchAuthUI.qqP.setVisibility(8);
        settingsSearchAuthUI.Fv.setVisibility(8);
        settingsSearchAuthUI.qqQ.clear();
        settingsSearchAuthUI.brs();
    }

    static /* synthetic */ void a(SettingsSearchAuthUI settingsSearchAuthUI, String str) {
        final k hVar = new com.tencent.mm.plugin.setting.modelsimple.h(str);
        g.CN().a(hVar, 0);
        settingsSearchAuthUI.nRI = h.a((Context) settingsSearchAuthUI, settingsSearchAuthUI.getString(R.l.dFI), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                g.CN().c(hVar);
            }
        });
    }

    static /* synthetic */ void a(SettingsSearchAuthUI settingsSearchAuthUI, byte[] bArr) {
        final k hVar = new com.tencent.mm.plugin.setting.modelsimple.h(bArr);
        g.CN().a(hVar, 0);
        settingsSearchAuthUI.nRI = h.a((Context) settingsSearchAuthUI, settingsSearchAuthUI.getString(R.l.dFI), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                g.CN().c(hVar);
            }
        });
    }

    static /* synthetic */ String bH(List list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (bsx bsx : list) {
            stringBuilder.append(bsx.qmh);
            stringBuilder.append(",");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    static /* synthetic */ void c(SettingsSearchAuthUI settingsSearchAuthUI) {
        settingsSearchAuthUI.qqN.setVisibility(8);
        settingsSearchAuthUI.qqO.setText("");
        settingsSearchAuthUI.qqQ.clear();
        settingsSearchAuthUI.Fv.setVisibility(8);
        settingsSearchAuthUI.brs();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.qqM = new com.tencent.mm.ui.fts.widget.a(this);
        this.Fv = (ListView) findViewById(R.h.bLw);
        this.qqR = new a();
        this.Fv.setAdapter(this.qqR);
        this.qqN = findViewById(R.h.cKf);
        this.qqO = (TextView) findViewById(R.h.cJv);
        this.qqP = (TextView) findViewById(R.h.cJX);
        brs();
        getSupportActionBar().setCustomView(this.qqM);
        this.qqM.zny = new com.tencent.mm.ui.fts.widget.a.a() {
            public final void bqI() {
                x.i("MicroMsg.SettingsSearchAuthUI", "click search back");
                SettingsSearchAuthUI.this.finish();
            }
        };
        this.qqM.znx.znb = new com.tencent.mm.ui.fts.widget.FTSEditTextView.a() {
            public final void bqJ() {
            }

            public final void a(String str, String str2, List<com.tencent.mm.ui.fts.widget.a.b> list, FTSEditTextView.b bVar) {
                x.i("MicroMsg.SettingsSearchAuthUI", "search totalText %s", str);
                if (bi.oN(str)) {
                    SettingsSearchAuthUI.c(SettingsSearchAuthUI.this);
                    return;
                }
                SettingsSearchAuthUI.a(SettingsSearchAuthUI.this);
                String string = SettingsSearchAuthUI.this.getString(R.l.dGK);
                CharSequence jVar = new j(string + " " + str.trim());
                jVar.setSpan(new ForegroundColorSpan(SettingsSearchAuthUI.this.getResources().getColor(R.e.bsE)), string.length(), jVar.length(), 33);
                SettingsSearchAuthUI.this.qqO.setText(jVar);
            }

            public final void hQ(boolean z) {
                x.i("MicroMsg.SettingsSearchAuthUI", "searchView hasFocus %s", Boolean.valueOf(z));
                if (z) {
                    SettingsSearchAuthUI.this.showVKB();
                } else {
                    SettingsSearchAuthUI.this.aWY();
                }
            }

            public final void cs(View view) {
                x.i("MicroMsg.SettingsSearchAuthUI", "clear search text");
                SettingsSearchAuthUI.c(SettingsSearchAuthUI.this);
            }

            public final boolean als() {
                x.i("MicroMsg.SettingsSearchAuthUI", "search key down");
                CharSequence text = SettingsSearchAuthUI.this.qqM.znx.yqL.getText();
                SettingsSearchAuthUI.this.qqO.setVisibility(8);
                SettingsSearchAuthUI.this.qqM.znx.yqL.clearFocus();
                SettingsSearchAuthUI.this.aWY();
                SettingsSearchAuthUI.this.brs();
                if (!bi.N(text)) {
                    SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, text.toString().trim());
                }
                return true;
            }
        };
        this.qqO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                CharSequence text = SettingsSearchAuthUI.this.qqM.znx.yqL.getText();
                if (!bi.N(text)) {
                    SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, text.toString().trim());
                }
            }
        });
        this.Fv.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!SettingsSearchAuthUI.this.qpD) {
                    bsw wl = SettingsSearchAuthUI.this.qqR.wl(i);
                    if (wl != null) {
                        Intent intent = new Intent(SettingsSearchAuthUI.this, SettingsModifyUserAuthUI.class);
                        UserAuthItemParcelable[] userAuthItemParcelableArr = (UserAuthItemParcelable[]) UserAuthItemParcelable.CREATOR.newArray(wl.xaL.size());
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < wl.xaL.size()) {
                                bsx bsx = (bsx) wl.xaL.get(i3);
                                UserAuthItemParcelable userAuthItemParcelable = new UserAuthItemParcelable();
                                userAuthItemParcelable.scope = bsx.scope;
                                userAuthItemParcelable.qmh = bsx.qmh;
                                userAuthItemParcelable.state = bsx.state;
                                userAuthItemParcelable.qmi = bsx.qmi;
                                userAuthItemParcelableArr[i3] = userAuthItemParcelable;
                                i2 = i3 + 1;
                            } else {
                                intent.putExtra("app_id", wl.fGh);
                                intent.putExtra("app_name", wl.hea);
                                intent.putExtra("modify_scene", 2);
                                intent.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(userAuthItemParcelableArr)));
                                SettingsSearchAuthUI.this.startActivity(intent);
                                return;
                            }
                        }
                    }
                }
            }
        });
        this.Fv.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i + i2 == i3) {
                    x.i("MicroMsg.SettingsSearchAuthUI", "scroll to the end");
                    if (SettingsSearchAuthUI.this.qma != null) {
                        SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, SettingsSearchAuthUI.this.qma);
                        SettingsSearchAuthUI.this.qma = null;
                    }
                }
            }
        });
    }

    protected void onResume() {
        super.onResume();
        g.CN().a(1169, (e) this);
        g.CN().a(1127, (e) this);
    }

    protected void onPause() {
        super.onPause();
        g.CN().b(1169, (e) this);
        g.CN().b(1127, (e) this);
    }

    private void brs() {
        this.mController.removeAllOptionMenu();
        if (!this.qqQ.isEmpty()) {
            if (this.qpD) {
                addTextOptionMenu(700, getString(R.l.dFw), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == 700) {
                            SettingsSearchAuthUI.this.qpD = false;
                            SettingsSearchAuthUI.this.qqR.notifyDataSetChanged();
                            SettingsSearchAuthUI.this.brs();
                        }
                        return true;
                    }
                });
            } else {
                addTextOptionMenu(700, getString(R.l.dFL), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == 700) {
                            SettingsSearchAuthUI.this.qpD = true;
                            SettingsSearchAuthUI.this.qqR.notifyDataSetChanged();
                            SettingsSearchAuthUI.this.brs();
                        }
                        return true;
                    }
                });
            }
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.bql, R.a.bpQ);
    }

    protected final int getLayoutId() {
        return R.i.dsq;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SettingsSearchAuthUI", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.nRI != null) {
            this.nRI.dismiss();
        }
        if (i != 0 || i2 != 0) {
            h.bu(this, str);
        } else if (kVar.getType() == 1169) {
            int i3;
            com.tencent.mm.plugin.setting.modelsimple.h hVar = (com.tencent.mm.plugin.setting.modelsimple.h) kVar;
            byte[] toByteArray = (hVar.qmd == null || hVar.qmd.wvD != 1) ? null : hVar.qmd.wvB.toByteArray();
            this.qma = toByteArray;
            if (((com.tencent.mm.plugin.setting.modelsimple.h) kVar).qma != null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                this.qqQ.clear();
            }
            com.tencent.mm.plugin.setting.modelsimple.h hVar2 = (com.tencent.mm.plugin.setting.modelsimple.h) kVar;
            this.qqQ.addAll(hVar2.qmd != null ? hVar2.qmd.wvC : Collections.emptyList());
            if (this.qqQ.isEmpty()) {
                this.qqN.setVisibility(0);
                this.qqO.setVisibility(8);
                this.qqP.setVisibility(0);
                this.Fv.setVisibility(8);
                this.qqQ.clear();
                brs();
                return;
            }
            this.qqR.qpF = this.qqQ;
            this.qqR.notifyDataSetChanged();
            this.qqN.setVisibility(8);
            this.Fv.setVisibility(0);
            brs();
        } else if (kVar.getType() == 1127) {
            String str2 = ((b) kVar).appId;
            if (!bi.oN(str2)) {
                if (!this.qqQ.isEmpty()) {
                    Iterator it = this.qqQ.iterator();
                    while (it.hasNext()) {
                        if (((bsw) it.next()).fGh.equals(str2)) {
                            it.remove();
                            break;
                        }
                    }
                }
                this.qqR.notifyDataSetChanged();
            }
        }
    }
}

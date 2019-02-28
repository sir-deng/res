package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.modelsimple.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.modelsimple.b;
import com.tencent.mm.protocal.c.bsw;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SettingsManageAuthUI extends MMActivity implements e {
    private ListView Fv;
    private ProgressDialog nRI;
    private byte[] qma;
    private View qpA;
    private a qpB;
    private List<bsw> qpC = new ArrayList();
    private boolean qpD;

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

        /* synthetic */ a(SettingsManageAuthUI settingsManageAuthUI, byte b) {
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
                view = SettingsManageAuthUI.this.getLayoutInflater().inflate(R.i.dsj, null);
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
                        final k bVar = new b(a.this.wl(i).fGh, 1);
                        if (SettingsManageAuthUI.this.nRI != null) {
                            SettingsManageAuthUI.this.nRI.dismiss();
                        }
                        g.CN().a(bVar, 0);
                        SettingsManageAuthUI.this.nRI = h.a(SettingsManageAuthUI.this, SettingsManageAuthUI.this.getString(R.l.dGM), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                g.CN().c(bVar);
                            }
                        });
                    }
                }
            });
            if (SettingsManageAuthUI.this.qpD) {
                aVar.lmo.setVisibility(0);
            } else {
                aVar.lmo.setVisibility(8);
            }
            if (wl(i) != null) {
                aVar.ldJ.setText(wl(i).hea);
                aVar.qpJ.setText(wl(i).xaM);
                aVar.qpK.setText(SettingsManageAuthUI.bG(wl(i).xaL));
            }
            return view;
        }
    }

    static /* synthetic */ String bG(List list) {
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.Fv = (ListView) findViewById(R.h.bLw);
        this.qpA = findViewById(R.h.bLv);
        this.qpB = new a();
        this.Fv.setAdapter(this.qpB);
        this.Fv.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i + i2 == i3) {
                    x.i("MicroMsg.SettingsManageAuthUI", "scroll to the end");
                    if (SettingsManageAuthUI.this.qma != null) {
                        SettingsManageAuthUI.aJ(SettingsManageAuthUI.this.qma);
                        SettingsManageAuthUI.this.qma = null;
                    }
                }
            }
        });
        this.Fv.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!SettingsManageAuthUI.this.qpD) {
                    bsw wl = SettingsManageAuthUI.this.qpB.wl(i);
                    if (wl != null) {
                        Intent intent = new Intent(SettingsManageAuthUI.this, SettingsModifyUserAuthUI.class);
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
                                intent.putExtra("modify_scene", 1);
                                intent.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(userAuthItemParcelableArr)));
                                SettingsManageAuthUI.this.startActivity(intent);
                                return;
                            }
                        }
                    }
                }
            }
        });
        brs();
        setMMTitle(R.l.eLj);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsManageAuthUI.this.finish();
                return true;
            }
        });
    }

    private void brs() {
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(800, R.k.dvl, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsManageAuthUI.this.startActivity(new Intent(SettingsManageAuthUI.this, SettingsSearchAuthUI.class));
                com.tencent.mm.ui.base.b.fF(SettingsManageAuthUI.this);
                return true;
            }
        });
        if (this.qpC.isEmpty()) {
            this.qpA.setVisibility(0);
            return;
        }
        this.qpA.setVisibility(8);
        if (this.qpD) {
            addTextOptionMenu(700, getString(R.l.dFw), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (menuItem.getItemId() == 700) {
                        SettingsManageAuthUI.this.qpD = false;
                        SettingsManageAuthUI.this.qpB.notifyDataSetChanged();
                        SettingsManageAuthUI.this.brs();
                    }
                    return true;
                }
            });
        } else {
            addTextOptionMenu(700, getString(R.l.dFL), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (menuItem.getItemId() == 700) {
                        SettingsManageAuthUI.this.qpD = true;
                        SettingsManageAuthUI.this.qpB.notifyDataSetChanged();
                        SettingsManageAuthUI.this.brs();
                    }
                    return true;
                }
            });
        }
    }

    protected void onResume() {
        super.onResume();
        g.CN().a(1146, (e) this);
        g.CN().a(1127, (e) this);
        aJ(null);
    }

    protected void onPause() {
        super.onPause();
        g.CN().b(1146, (e) this);
        g.CN().b(1127, (e) this);
    }

    protected final int getLayoutId() {
        return R.i.dsm;
    }

    private static void aJ(byte[] bArr) {
        g.CN().a(new com.tencent.mm.plugin.setting.modelsimple.e(bArr), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SettingsManageAuthUI", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.nRI != null) {
            this.nRI.dismiss();
        }
        if (i != 0 || i2 != 0) {
            h.bu(this, str);
        } else if (kVar.getType() == 1146) {
            int i3;
            com.tencent.mm.plugin.setting.modelsimple.e eVar = (com.tencent.mm.plugin.setting.modelsimple.e) kVar;
            byte[] toByteArray = (eVar.qlZ == null || eVar.qlZ.wvD != 1) ? null : eVar.qlZ.wvB.toByteArray();
            this.qma = toByteArray;
            if (((com.tencent.mm.plugin.setting.modelsimple.e) kVar).qma != null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                this.qpC.clear();
            }
            com.tencent.mm.plugin.setting.modelsimple.e eVar2 = (com.tencent.mm.plugin.setting.modelsimple.e) kVar;
            this.qpC.addAll(eVar2.qlZ != null ? eVar2.qlZ.wvC : Collections.emptyList());
            this.qpB.qpF = this.qpC;
            this.qpB.notifyDataSetChanged();
            brs();
        } else if (kVar.getType() == 1127) {
            String str2 = ((b) kVar).appId;
            if (!bi.oN(str2)) {
                if (!this.qpC.isEmpty()) {
                    Iterator it = this.qpC.iterator();
                    while (it.hasNext()) {
                        if (((bsw) it.next()).fGh.equals(str2)) {
                            it.remove();
                            break;
                        }
                    }
                }
                this.qpB.notifyDataSetChanged();
            }
        }
    }
}

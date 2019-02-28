package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.setting.modelsimple.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.ahh;
import com.tencent.mm.protocal.c.bqe;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.e.g;
import com.tencent.mm.ui.p;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SettingsTrustFriendUI extends MMActivity implements e {
    private static int qru = 5;
    private GridView mXT;
    private r mhi;
    private TextView nAI;
    private boolean qpD;
    private List<String> qrr;
    private a qrs;
    private View qrt;

    private class a extends BaseAdapter {

        private class a {
            TextView kxN;
            ImageView qfr;
            ImageView qry;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        private a() {
        }

        /* synthetic */ a(SettingsTrustFriendUI settingsTrustFriendUI, byte b) {
            this();
        }

        public final int getCount() {
            int size = SettingsTrustFriendUI.this.qrr.size();
            if (SettingsTrustFriendUI.this.qpD) {
                return size;
            }
            if (size == 0) {
                return 1;
            }
            if (size <= 0 || size >= SettingsTrustFriendUI.qru) {
                return size >= SettingsTrustFriendUI.qru ? size + 1 : 0;
            } else {
                return size + 2;
            }
        }

        public final Object getItem(int i) {
            if (getItemViewType(i) == 0) {
                return SettingsTrustFriendUI.this.qrr.get(i);
            }
            return null;
        }

        public final int getItemViewType(int i) {
            int size = SettingsTrustFriendUI.this.qrr.size();
            if (SettingsTrustFriendUI.this.qpD || i < size) {
                return 0;
            }
            if (size == 0) {
                return 1;
            }
            if (size >= SettingsTrustFriendUI.qru) {
                return 2;
            }
            if (i == size) {
                return 1;
            }
            if (i == size + 1) {
                return 2;
            }
            return -1;
        }

        public final int getViewTypeCount() {
            return 3;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = SettingsTrustFriendUI.this.getLayoutInflater().inflate(R.i.dsw, null);
                ImageView imageView = (ImageView) view.findViewById(R.h.cST);
                ImageView imageView2 = (ImageView) view.findViewById(R.h.cSU);
                TextView textView = (TextView) view.findViewById(R.h.cSY);
                a aVar2 = new a();
                aVar2.qfr = imageView;
                aVar2.qry = imageView2;
                aVar2.kxN = textView;
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                String str = (String) SettingsTrustFriendUI.this.qrr.get(i);
                as.Hm();
                x Xv = c.Ff().Xv(str);
                aVar.qfr.setScaleType(ScaleType.FIT_XY);
                b.a(aVar.qfr, str);
                aVar.kxN.setText(i.b(SettingsTrustFriendUI.this, Xv.AX(), aVar.kxN.getTextSize()));
                if (SettingsTrustFriendUI.this.qpD) {
                    aVar.qry.setVisibility(0);
                } else {
                    aVar.qry.setVisibility(8);
                }
            } else {
                aVar.kxN.setVisibility(4);
                aVar.qry.setVisibility(8);
                aVar.qfr.setScaleType(ScaleType.FIT_XY);
                if (getItemViewType(i) == 1) {
                    aVar.qfr.setImageResource(R.g.bzl);
                } else if (getItemViewType(i) == 2) {
                    aVar.qfr.setImageResource(R.g.bzm);
                }
            }
            return view;
        }
    }

    static /* synthetic */ void a(SettingsTrustFriendUI settingsTrustFriendUI) {
        final k dVar = new d();
        as.CN().a(dVar, 0);
        settingsTrustFriendUI.getString(R.l.dEU);
        settingsTrustFriendUI.mhi = h.a((Context) settingsTrustFriendUI, settingsTrustFriendUI.getString(R.l.ctG), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(dVar);
            }
        });
    }

    static /* synthetic */ void h(SettingsTrustFriendUI settingsTrustFriendUI) {
        if (settingsTrustFriendUI.qrr.size() <= 0 || settingsTrustFriendUI.qrr.size() >= 3) {
            final k aVar = new com.tencent.mm.plugin.setting.modelsimple.a(settingsTrustFriendUI.qrr);
            as.CN().a(aVar, 0);
            if (settingsTrustFriendUI.mhi != null) {
                settingsTrustFriendUI.mhi.dismiss();
            }
            settingsTrustFriendUI.getString(R.l.dEU);
            settingsTrustFriendUI.mhi = h.a((Context) settingsTrustFriendUI, settingsTrustFriendUI.getString(R.l.dGM), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(aVar);
                }
            });
            return;
        }
        h.b(settingsTrustFriendUI, settingsTrustFriendUI.getString(R.l.eNP, new Object[]{Integer.valueOf(3)}), settingsTrustFriendUI.getString(R.l.dGZ), true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.Hm();
        String str = (String) c.Db().get(352277, null);
        if (!bi.oN(str)) {
            this.qrr = bi.F(str.split(","));
        }
        if (this.qrr == null) {
            this.qrr = new ArrayList();
        }
        this.mController.contentView.post(new Runnable() {
            public final void run() {
                SettingsTrustFriendUI.a(SettingsTrustFriendUI.this);
            }
        });
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dsv;
    }

    public void onStart() {
        super.onStart();
        as.CN().a(869, (e) this);
        as.CN().a(583, (e) this);
    }

    protected void onStop() {
        super.onStop();
        as.CN().b(869, (e) this);
        as.CN().b(583, (e) this);
    }

    protected final void initView() {
        setMMTitle(R.l.dsv);
        this.mXT = (GridView) findViewById(R.h.cSW);
        this.qrs = new a();
        this.mXT.setColumnWidth(getResources().getDimensionPixelSize(R.f.bvG));
        this.mXT.setNumColumns(-1);
        this.mXT.setStretchMode(1);
        this.mXT.setHorizontalSpacing(getResources().getDimensionPixelSize(R.f.bxB) * 2);
        this.mXT.setVerticalSpacing(getResources().getDimensionPixelSize(R.f.bxC));
        this.mXT.setAdapter(this.qrs);
        ((ViewGroup) this.mXT.getParent()).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (SettingsTrustFriendUI.this.qpD) {
                    SettingsTrustFriendUI.this.qpD = false;
                    SettingsTrustFriendUI.this.qrs.notifyDataSetChanged();
                }
            }
        });
        this.mXT.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!SettingsTrustFriendUI.this.qpD || motionEvent.getAction() != 1 || SettingsTrustFriendUI.this.mXT.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY()) != -1) {
                    return false;
                }
                SettingsTrustFriendUI.this.qpD = false;
                SettingsTrustFriendUI.this.qrs.notifyDataSetChanged();
                return true;
            }
        });
        this.mXT.setHorizontalScrollBarEnabled(false);
        this.mXT.setVerticalScrollBarEnabled(false);
        this.mXT.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (SettingsTrustFriendUI.this.qrs.getItemViewType(i) == 1) {
                    Intent intent = new Intent();
                    intent.putExtra("list_type", 12);
                    intent.putExtra("titile", SettingsTrustFriendUI.this.getString(R.l.dDz));
                    intent.putExtra("scene", 2);
                    intent.putExtra("max_limit_num", SettingsTrustFriendUI.qru);
                    intent.putExtra("stay_in_wechat", true);
                    intent.putExtra("already_select_contact", bi.d(SettingsTrustFriendUI.this.qrr, ","));
                    intent.putExtra("block_contact", q.FY());
                    intent.putExtra("list_attr", s.fe(s.zcE, 256));
                    intent.putExtra("too_many_member_tip_string", SettingsTrustFriendUI.this.getString(R.l.eNO, new Object[]{Integer.valueOf(SettingsTrustFriendUI.qru)}));
                    com.tencent.mm.bl.d.a(SettingsTrustFriendUI.this, ".ui.contact.SelectContactUI", intent, 1);
                    return;
                }
                if (SettingsTrustFriendUI.this.qrs.getItemViewType(i) == 2) {
                    if (!SettingsTrustFriendUI.this.qpD) {
                        SettingsTrustFriendUI.this.qpD = true;
                    } else {
                        return;
                    }
                } else if (SettingsTrustFriendUI.this.qrs.getItemViewType(i) == 0 && SettingsTrustFriendUI.this.qpD) {
                    SettingsTrustFriendUI.this.qrr.remove(SettingsTrustFriendUI.this.qrs.getItem(i));
                    if (SettingsTrustFriendUI.this.qrr.size() == 0) {
                        SettingsTrustFriendUI.this.qpD = false;
                    }
                } else {
                    return;
                }
                SettingsTrustFriendUI.this.qrs.notifyDataSetChanged();
            }
        });
        this.nAI = (TextView) findViewById(R.h.cSV);
        CharSequence stringExtra = getIntent().getStringExtra(g.xMR);
        if (bi.oN(stringExtra)) {
            this.nAI.setText(getResources().getString(R.l.eNQ, new Object[]{Integer.valueOf(3)}));
        } else {
            this.nAI.setText(stringExtra);
        }
        this.qrt = findViewById(R.h.cSZ);
        this.qrt.setVisibility(8);
        ((TextView) this.qrt.findViewById(R.h.cYG)).setText(getString(R.l.eNP, new Object[]{Integer.valueOf(3)}));
        this.qrt.findViewById(R.h.bWn).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SettingsTrustFriendUI.this.qrt.setVisibility(8);
            }
        });
        findViewById(R.h.cSX).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=w_security_center_website/trusted_friend_guide");
                com.tencent.mm.bl.d.b(SettingsTrustFriendUI.this, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsTrustFriendUI.this.brK();
                return true;
            }
        });
        a(1, getString(R.l.dFw), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsTrustFriendUI.h(SettingsTrustFriendUI.this);
                return true;
            }
        }, p.b.xSe);
        showOptionMenu(true);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            if (!bi.oN(stringExtra)) {
                this.qrr.clear();
                this.qrr.addAll(bi.F(stringExtra.split(",")));
                this.qrs.notifyDataSetChanged();
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SettingsTrustFriendUI", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.mhi != null) {
            this.mhi.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 869) {
                int i3;
                ahh ahh = (ahh) ((com.tencent.mm.ad.b) kVar.hoq).hnR.hnY;
                qru = ahh.wvo;
                List<bqe> list = ahh.vOa;
                if (list.size() != this.qrr.size()) {
                    i3 = 1;
                    break;
                } else if (list.size() == 0) {
                    i3 = 0;
                } else {
                    for (bqe bqe : list) {
                        if (!this.qrr.contains(bqe.kyG)) {
                            i3 = 1;
                            break;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    this.qrr.clear();
                    for (bqe bqe2 : list) {
                        this.qrr.add(bqe2.kyG);
                    }
                    this.qrs.notifyDataSetChanged();
                }
                if (this.qrr.size() > 0 && this.qrr.size() < 3) {
                    this.qrt.setVisibility(0);
                }
                as.Hm();
                c.Db().set(352277, bi.d(this.qrr, ","));
            } else if (kVar.getType() == 583) {
                as.Hm();
                c.Db().set(352277, bi.d(this.qrr, ","));
                finish();
            }
        } else if (!bi.oN(str)) {
            h.bu(this, str);
        }
    }

    private void brK() {
        Collection F;
        as.Hm();
        String str = (String) c.Db().get(352277, null);
        ArrayList arrayList = new ArrayList();
        if (bi.oN(str)) {
            Object F2 = arrayList;
        } else {
            F2 = bi.F(str.split(","));
        }
        if (this.qrr.size() == F2.size() && this.qrr.containsAll(F2)) {
            finish();
        } else {
            h.a((Context) this, getString(R.l.eHs), getString(R.l.dGZ), getString(R.l.dGI), getString(R.l.dGd), true, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsTrustFriendUI.h(SettingsTrustFriendUI.this);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsTrustFriendUI.this.finish();
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        brK();
        return true;
    }
}

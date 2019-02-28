package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.n;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.j;
import com.tencent.mm.modelfriend.j.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.c.aph;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAddUI extends MMWizardActivity {
    private TextView emptyTipTv = null;
    private e hRg = null;
    private ListView inF;
    private ProgressDialog inI = null;
    private int jjv;
    private String liu = null;
    private View onR;
    private boolean pEf = true;
    private String pXN;
    private String ydo = "";
    private int ydp = 2;
    private j zlr;
    private TextView zls = null;
    private TextView zlt = null;
    private TextView zlu = null;
    private TextView zlv = null;
    private Button zlw = null;
    private List<String[]> zlx;
    private a zly = new a() {
        public final void notifyDataSetChanged() {
            if (FindMContactAddUI.this.ydp == 2 || FindMContactAddUI.this.ydp != 1) {
                FindMContactAddUI.this.zlw.setText(FindMContactAddUI.this.getString(R.l.ehR, new Object[]{Integer.valueOf(FindMContactAddUI.this.zlr.getCount())}));
            } else {
                FindMContactAddUI.this.zlw.setText(FindMContactAddUI.this.getString(R.l.ehS));
            }
            if (FindMContactAddUI.this.zlr.NO()) {
                if (!(FindMContactAddUI.this.ydp == 1 || FindMContactAddUI.this.zlw.getVisibility() != 0 || FindMContactAddUI.this.zlv == null)) {
                    FindMContactAddUI.this.zlw.setVisibility(8);
                    FindMContactAddUI.this.zlv.setVisibility(0);
                }
            } else if (!(FindMContactAddUI.this.ydp == 1 || FindMContactAddUI.this.zlw.getVisibility() != 8 || FindMContactAddUI.this.zlv == null)) {
                FindMContactAddUI.this.zlw.setVisibility(0);
                FindMContactAddUI.this.zlv.setVisibility(8);
            }
            if (FindMContactAddUI.this.zlr.NN() <= 0 || FindMContactAddUI.this.ydp == 1) {
                FindMContactAddUI.this.zls.setText(FindMContactAddUI.this.getResources().getQuantityString(R.j.duD, FindMContactAddUI.this.zlr.getCount(), new Object[]{Integer.valueOf(FindMContactAddUI.this.zlr.getCount())}));
                return;
            }
            FindMContactAddUI.this.zls.setText(FindMContactAddUI.this.getResources().getQuantityString(R.j.duA, FindMContactAddUI.this.zlr.NN(), new Object[]{Integer.valueOf(FindMContactAddUI.this.zlr.NN())}));
        }
    };

    static /* synthetic */ void i(FindMContactAddUI findMContactAddUI) {
        findMContactAddUI.aWY();
        if (findMContactAddUI.zlr.NN() == 0) {
            h.a((Context) findMContactAddUI, findMContactAddUI.getString(R.l.eij), "", findMContactAddUI.getString(R.l.ehP), findMContactAddUI.getString(R.l.ehQ), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (FindMContactAddUI.this.ydo == null || !FindMContactAddUI.this.ydo.contains("2")) {
                        FindMContactAddUI.this.bpd();
                        return;
                    }
                    Intent intent = new Intent(FindMContactAddUI.this, FindMContactInviteUI.class);
                    intent.putExtra("regsetinfo_ticket", FindMContactAddUI.this.liu);
                    intent.putExtra("login_type", FindMContactAddUI.this.jjv);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactAddUI.this.ydp);
                    MMWizardActivity.A(FindMContactAddUI.this, intent);
                }
            });
            return;
        }
        n CN = as.CN();
        e anonymousClass2 = new e() {
            public final void a(int i, int i2, String str, k kVar) {
                if (FindMContactAddUI.this.inI != null) {
                    FindMContactAddUI.this.inI.dismiss();
                    FindMContactAddUI.this.inI = null;
                }
                if (FindMContactAddUI.this.hRg != null) {
                    as.CN().b(30, FindMContactAddUI.this.hRg);
                    FindMContactAddUI.this.hRg = null;
                }
                if (i == 4 && i2 == -24 && !bi.oN(str)) {
                    Toast.makeText(FindMContactAddUI.this.mController.xRr, str, 1).show();
                } else if (FindMContactAddUI.this.ydo == null || !FindMContactAddUI.this.ydo.contains("2")) {
                    FindMContactAddUI.this.bpd();
                } else {
                    Intent intent = new Intent(FindMContactAddUI.this, FindMContactInviteUI.class);
                    intent.putExtra("regsetinfo_ticket", FindMContactAddUI.this.liu);
                    intent.putExtra("login_type", FindMContactAddUI.this.jjv);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactAddUI.this.ydp);
                    MMWizardActivity.A(FindMContactAddUI.this, intent);
                }
            }
        };
        findMContactAddUI.hRg = anonymousClass2;
        CN.a(30, anonymousClass2);
        Context context = findMContactAddUI.mController.xRr;
        findMContactAddUI.getString(R.l.dGZ);
        findMContactAddUI.inI = h.a(context, findMContactAddUI.getString(R.l.eid), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        j jVar = findMContactAddUI.zlr;
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (int i = 0; i < jVar.hxz.size(); i++) {
            if (jVar.hxD[i] == 1) {
                linkedList.add(((aph) jVar.hxz.get(i)).kyG);
                linkedList2.add(Integer.valueOf(52));
            }
        }
        as.CN().a(new o(2, linkedList, linkedList2, "", ""), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ehW);
        com.tencent.mm.plugin.c.a.ihO.uq();
        this.liu = getIntent().getStringExtra("regsetinfo_ticket");
        this.ydo = getIntent().getStringExtra("regsetinfo_NextStep");
        this.ydp = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.jjv = getIntent().getIntExtra("login_type", 0);
        this.pXN = b.Xw();
        initView();
    }

    private void cxL() {
        Context context = this.mController.xRr;
        getString(R.l.dGZ);
        this.inI = h.a(context, getString(R.l.evy), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        as.Dt().a(new ah.a() {
            public final boolean JI() {
                if (FindMContactAddUI.this.inI != null) {
                    FindMContactAddUI.this.inI.dismiss();
                    FindMContactAddUI.this.inI = null;
                }
                FindMContactAddUI.this.zlr.notifyDataSetChanged();
                return false;
            }

            public final boolean JH() {
                try {
                    FindMContactAddUI.this.zlx = com.tencent.mm.pluginsdk.a.bW(FindMContactAddUI.this);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FindMContactAddUI", e, "", new Object[0]);
                }
                FindMContactAddUI.this.zlr.hxB = FindMContactAddUI.this.zlx;
                FindMContactAddUI.this.zlr.e(af.OP());
                return true;
            }

            public final String toString() {
                return super.toString() + "|listMFriendData";
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        bpd();
        return true;
    }

    private void bpd() {
        b.oZ(this.pXN);
        aWY();
        En(1);
    }

    protected void onResume() {
        super.onResume();
        this.zlr.notifyDataSetChanged();
        if (this.jjv == 1) {
            b.b(true, as.CI() + "," + getClass().getName() + ",R300_300_QQ," + as.fJ("R300_300_QQ") + ",1");
            b.oY("R300_300_QQ");
        } else {
            b.b(true, as.CI() + "," + getClass().getName() + ",R300_300_phone," + as.fJ("R300_300_phone") + ",1");
            b.oY("R300_300_phone");
        }
        if (this.pEf) {
            x.i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.chl());
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                cxL();
            }
        }
    }

    public void onPause() {
        super.onPause();
        if (this.jjv == 1) {
            b.b(false, as.CI() + "," + getClass().getName() + ",R300_300_QQ," + as.fJ("R300_300_QQ") + ",2");
        } else {
            b.b(false, as.CI() + "," + getClass().getName() + ",R300_300_phone," + as.fJ("R300_300_phone") + ",2");
        }
    }

    public void onDestroy() {
        if (this.hRg != null) {
            as.CN().b(30, this.hRg);
            this.hRg = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dik;
    }

    protected final void initView() {
        this.emptyTipTv = (TextView) findViewById(R.h.cwD);
        this.emptyTipTv.setText(R.l.evw);
        this.inF = (ListView) findViewById(R.h.cwF);
        if (this.ydp == 2 || this.ydp != 1) {
            this.onR = LayoutInflater.from(this).inflate(R.i.dil, null);
            this.zls = (TextView) this.onR.findViewById(R.h.chX);
            this.zlt = (TextView) this.onR.findViewById(R.h.cia);
            this.zlu = (TextView) this.onR.findViewById(R.h.chV);
            this.zlw = (Button) this.onR.findViewById(R.h.chU);
            this.zlt.setText(getString(R.l.ein));
            this.zlu.setText(getString(R.l.eio));
            this.zlw.setText(getString(R.l.ehR, new Object[]{Integer.valueOf(0)}));
            this.zlv = (TextView) this.onR.findViewById(R.h.cwz);
        } else {
            this.onR = LayoutInflater.from(this).inflate(R.i.dim, null);
            this.zls = (TextView) this.onR.findViewById(R.h.chX);
            this.zlt = (TextView) this.onR.findViewById(R.h.cia);
            this.zlu = (TextView) this.onR.findViewById(R.h.chV);
            this.zlw = (Button) this.onR.findViewById(R.h.chU);
            this.zlt.setText(getString(R.l.ein));
            this.zlu.setText(getString(R.l.eio));
            this.zlw.setText(getString(R.l.ehS));
        }
        this.zlr = new j(this, this.zly, 1);
        this.zlw.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.pa(as.CI() + "," + FindMContactAddUI.this.getClass().getName() + ",R300_300_AddAllButton," + as.fJ("R300_300_AddAllButton") + ",3");
                if (FindMContactAddUI.this.ydp == 2) {
                    FindMContactAddUI.this.zlr.bP(true);
                    FindMContactAddUI.this.zlr.notifyDataSetChanged();
                    FindMContactAddUI.this.zlw.setVisibility(8);
                    if (FindMContactAddUI.this.zlv != null) {
                        FindMContactAddUI.this.zlv.setVisibility(0);
                    }
                } else if (FindMContactAddUI.this.ydp == 1) {
                    FindMContactAddUI.this.zlr.bP(true);
                    FindMContactAddUI.this.zlr.notifyDataSetChanged();
                    FindMContactAddUI.i(FindMContactAddUI.this);
                } else {
                    FindMContactAddUI.this.zlr.bP(true);
                    FindMContactAddUI.this.zlr.notifyDataSetChanged();
                    FindMContactAddUI.this.zlw.setVisibility(8);
                    if (FindMContactAddUI.this.zlv != null) {
                        FindMContactAddUI.this.zlv.setVisibility(0);
                    }
                }
            }
        });
        if (this.zlv != null) {
            this.zlv.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    FindMContactAddUI.this.zlw.setVisibility(0);
                    FindMContactAddUI.this.zlv.setVisibility(8);
                    FindMContactAddUI.this.zlr.bP(false);
                    FindMContactAddUI.this.zlr.notifyDataSetChanged();
                }
            });
            this.zlv.setVisibility(8);
        }
        this.inF.addHeaderView(this.onR);
        this.inF.setAdapter(this.zlr);
        addTextOptionMenu(0, getString(R.l.dGb), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FindMContactAddUI.i(FindMContactAddUI.this);
                return true;
            }
        });
        AnonymousClass11 anonymousClass11 = new View.OnClickListener() {
            public final void onClick(View view) {
                c.a(FindMContactAddUI.this.inF);
            }
        };
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactAddUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case org.xwalk.core.R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    cxL();
                    return;
                }
                this.pEf = false;
                h.a((Context) this, getString(R.l.eAb), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FindMContactAddUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        FindMContactAddUI.this.pEf = true;
                        FindMContactAddUI.this.finish();
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FindMContactAddUI.this.pEf = true;
                        FindMContactAddUI.this.finish();
                    }
                });
                return;
            default:
                return;
        }
    }
}

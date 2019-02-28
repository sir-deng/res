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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.j;
import com.tencent.mm.modelfriend.j.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import java.util.List;

public class FindMContactInviteUI extends MMWizardActivity {
    private TextView emptyTipTv = null;
    private e hRg = null;
    private ListView inF;
    private ProgressDialog inI = null;
    private int jjv;
    private View onR;
    private boolean pEf = true;
    private String pXN;
    private int ydp = 2;
    private String zlA = null;
    private j zlr;
    private TextView zls = null;
    private TextView zlt = null;
    private TextView zlu = null;
    private TextView zlv = null;
    private Button zlw = null;
    private List<String[]> zlx;
    private a zly = new a() {
        public final void notifyDataSetChanged() {
            if (FindMContactInviteUI.this.ydp == 2 || FindMContactInviteUI.this.ydp != 1) {
                FindMContactInviteUI.this.zlw.setText(FindMContactInviteUI.this.getString(R.l.eia, new Object[]{Integer.valueOf(FindMContactInviteUI.this.zlr.getCount())}));
            } else {
                FindMContactInviteUI.this.zlw.setText(FindMContactInviteUI.this.getString(R.l.eib));
            }
            if (FindMContactInviteUI.this.zlr.NO()) {
                if (!(FindMContactInviteUI.this.ydp == 1 || FindMContactInviteUI.this.zlw.getVisibility() != 0 || FindMContactInviteUI.this.zlv == null)) {
                    FindMContactInviteUI.this.zlw.setVisibility(8);
                    FindMContactInviteUI.this.zlv.setVisibility(0);
                }
            } else if (!(FindMContactInviteUI.this.ydp == 1 || FindMContactInviteUI.this.zlw.getVisibility() != 8 || FindMContactInviteUI.this.zlv == null)) {
                FindMContactInviteUI.this.zlw.setVisibility(0);
                FindMContactInviteUI.this.zlv.setVisibility(8);
            }
            if (FindMContactInviteUI.this.zlr.NN() <= 0 || FindMContactInviteUI.this.ydp == 1) {
                FindMContactInviteUI.this.zls.setText(FindMContactInviteUI.this.getResources().getQuantityString(R.j.duC, FindMContactInviteUI.this.zlr.getCount(), new Object[]{Integer.valueOf(FindMContactInviteUI.this.zlr.getCount())}));
                return;
            }
            FindMContactInviteUI.this.zls.setText(FindMContactInviteUI.this.getResources().getQuantityString(R.j.duB, FindMContactInviteUI.this.zlr.NN(), new Object[]{Integer.valueOf(FindMContactInviteUI.this.zlr.NN())}));
        }
    };

    static /* synthetic */ void h(FindMContactInviteUI findMContactInviteUI) {
        findMContactInviteUI.aWY();
        if (findMContactInviteUI.zlr.NN() == 0) {
            findMContactInviteUI.bpd();
        } else {
            h.a((Context) findMContactInviteUI, findMContactInviteUI.getString(R.l.ehZ), "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (FindMContactInviteUI.this.jjv == 1) {
                        b.pa(as.CI() + "," + getClass().getName() + ",R300_500_QQ," + as.fJ("R300_500_QQ") + ",3");
                    } else {
                        b.pa(as.CI() + "," + getClass().getName() + ",R300_500_phone," + as.fJ("R300_500_phone") + ",3");
                    }
                    as.CN().a(432, FindMContactInviteUI.this.hRg = new e() {
                        public final void a(int i, int i2, String str, k kVar) {
                            if (FindMContactInviteUI.this.inI != null) {
                                FindMContactInviteUI.this.inI.dismiss();
                                FindMContactInviteUI.this.inI = null;
                            }
                            if (FindMContactInviteUI.this.hRg != null) {
                                as.CN().b(432, FindMContactInviteUI.this.hRg);
                                FindMContactInviteUI.this.hRg = null;
                            }
                            FindMContactInviteUI.this.bpd();
                        }
                    });
                    FindMContactInviteUI findMContactInviteUI = FindMContactInviteUI.this;
                    Context context = FindMContactInviteUI.this.mController.xRr;
                    FindMContactInviteUI.this.getString(R.l.dGZ);
                    findMContactInviteUI.inI = h.a(context, FindMContactInviteUI.this.getString(R.l.eid), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    FindMContactInviteUI.this.zlr.kZ(FindMContactInviteUI.this.zlA);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eie);
        com.tencent.mm.plugin.c.a.ihO.uq();
        this.zlA = getIntent().getStringExtra("regsetinfo_ticket");
        this.jjv = getIntent().getIntExtra("login_type", 0);
        this.ydp = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.pXN = b.Xw();
        initView();
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
            b.b(true, as.CI() + "," + getClass().getName() + ",R300_400_QQ," + as.fJ("R300_400_QQ") + ",1");
        } else {
            b.b(true, as.CI() + "," + getClass().getName() + ",R300_400_phone," + as.fJ("R300_400_phone") + ",1");
        }
        if (this.pEf) {
            x.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.chl());
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                cxL();
            }
        }
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
                if (FindMContactInviteUI.this.inI != null) {
                    FindMContactInviteUI.this.inI.dismiss();
                    FindMContactInviteUI.this.inI = null;
                }
                FindMContactInviteUI.this.zlr.notifyDataSetChanged();
                return false;
            }

            public final boolean JH() {
                try {
                    FindMContactInviteUI.this.zlx = com.tencent.mm.pluginsdk.a.bW(FindMContactInviteUI.this);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FindMContactInviteUI", e, "", new Object[0]);
                }
                FindMContactInviteUI.this.zlr.hxB = FindMContactInviteUI.this.zlx;
                FindMContactInviteUI.this.zlr.e(af.OP());
                return true;
            }

            public final String toString() {
                return super.toString() + "|listMFriendData";
            }
        });
    }

    public void onPause() {
        super.onPause();
        if (this.jjv == 1) {
            b.b(false, as.CI() + "," + getClass().getName() + ",R300_400_QQ," + as.fJ("R300_400_QQ") + ",2");
        } else {
            b.b(false, as.CI() + "," + getClass().getName() + ",R300_400_phone," + as.fJ("R300_400_phone") + ",2");
        }
    }

    public void onDestroy() {
        if (this.hRg != null) {
            as.CN().b(432, this.hRg);
            this.hRg = null;
        }
        if (this.zlr != null) {
            j jVar = this.zlr;
            if (jVar.hxF != null) {
                jVar.hxF.detach();
                jVar.hxF = null;
            }
        }
        af.OQ();
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
            this.zlt.setText(getString(R.l.eif));
            this.zlu.setText(getString(R.l.eic));
            this.zlw.setText(getString(R.l.eia, new Object[]{Integer.valueOf(0)}));
            this.zlv = (TextView) this.onR.findViewById(R.h.cwz);
        } else {
            this.onR = LayoutInflater.from(this).inflate(R.i.dim, null);
            this.zls = (TextView) this.onR.findViewById(R.h.chX);
            this.zlt = (TextView) this.onR.findViewById(R.h.cia);
            this.zlu = (TextView) this.onR.findViewById(R.h.chV);
            this.zlw = (Button) this.onR.findViewById(R.h.chU);
            this.zlt.setText(getString(R.l.eic));
            this.zlu.setText(getString(R.l.eic));
            this.zlw.setText(getString(R.l.eib));
        }
        this.zlr = new j(this, this.zly, 2);
        this.zlw.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.pa(as.CI() + "," + FindMContactInviteUI.this.getClass().getName() + ",R300_400_AddAllButton," + as.fJ("R300_300_AddAllButton") + ",3");
                if (FindMContactInviteUI.this.ydp == 2) {
                    FindMContactInviteUI.this.zlr.bP(true);
                    FindMContactInviteUI.this.zlr.notifyDataSetChanged();
                    FindMContactInviteUI.this.zlw.setVisibility(8);
                    if (FindMContactInviteUI.this.zlv != null) {
                        FindMContactInviteUI.this.zlv.setVisibility(0);
                    }
                } else if (FindMContactInviteUI.this.ydp == 1) {
                    FindMContactInviteUI.this.zlr.bP(true);
                    FindMContactInviteUI.this.zlr.notifyDataSetChanged();
                    FindMContactInviteUI.h(FindMContactInviteUI.this);
                } else {
                    FindMContactInviteUI.this.zlr.bP(true);
                    FindMContactInviteUI.this.zlr.notifyDataSetChanged();
                    FindMContactInviteUI.this.zlw.setVisibility(8);
                    if (FindMContactInviteUI.this.zlv != null) {
                        FindMContactInviteUI.this.zlv.setVisibility(0);
                    }
                }
            }
        });
        if (this.zlv != null) {
            this.zlv.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    FindMContactInviteUI.this.zlw.setVisibility(0);
                    FindMContactInviteUI.this.zlv.setVisibility(8);
                    FindMContactInviteUI.this.zlr.bP(false);
                    FindMContactInviteUI.this.zlr.notifyDataSetChanged();
                }
            });
            this.zlv.setVisibility(8);
        }
        this.inF.addHeaderView(this.onR);
        this.inF.setAdapter(this.zlr);
        this.inF.setOnScrollListener(new com.tencent.mm.ui.applet.a());
        this.inF.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (FindMContactInviteUI.this.zlr != null) {
                    j b = FindMContactInviteUI.this.zlr;
                    if (b.hxF != null) {
                        b.hxF.onTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        });
        addTextOptionMenu(0, getString(R.l.dFw), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FindMContactInviteUI.h(FindMContactInviteUI.this);
                return true;
            }
        });
        AnonymousClass11 anonymousClass11 = new View.OnClickListener() {
            public final void onClick(View view) {
                c.a(FindMContactInviteUI.this.inF);
            }
        };
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactInviteUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case org.xwalk.core.R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    cxL();
                    return;
                }
                this.pEf = false;
                h.a((Context) this, getString(R.l.eAb), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FindMContactInviteUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        FindMContactInviteUI.this.pEf = true;
                        FindMContactInviteUI.this.finish();
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FindMContactInviteUI.this.pEf = true;
                        FindMContactInviteUI.this.finish();
                    }
                });
                return;
            default:
                return;
        }
    }
}

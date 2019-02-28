package com.tencent.mm.ui.bindmobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.n;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.y;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.c.aph;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactIntroUI extends MMWizardActivity {
    private String fBa;
    private e hRg = null;
    private List<String[]> hxB = null;
    private ProgressDialog inI = null;
    private String liu = null;
    private String pXN;
    private TextView qbT;
    private String ydo = "";
    private int ydp = 2;
    private boolean yuG = false;
    private y yuH;
    private Button yuO;
    private TextView yuP;

    static /* synthetic */ void a(FindMContactIntroUI findMContactIntroUI) {
        if (findMContactIntroUI.yuG) {
            b.pa(as.CI() + "," + findMContactIntroUI.getClass().getName() + ",R300_200_phone," + as.fJ("R300_200_phone") + ",1");
            h.a((Context) findMContactIntroUI, R.l.ehX, R.l.dGZ, R.l.dGf, R.l.dEy, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    as.Hm();
                    c.Db().set(12322, Boolean.valueOf(true));
                    b.oZ("R200_100");
                    Intent intent = new Intent();
                    intent.putExtra("mobile_input_purpose", 4);
                    intent.putExtra("regsetinfo_ticket", FindMContactIntroUI.this.liu);
                    intent.putExtra("regsetinfo_NextStep", FindMContactIntroUI.this.ydo);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.this.ydp);
                    a.ihN.a(FindMContactIntroUI.this, intent);
                    b.oZ("R300_300_phone");
                    b.b(false, as.CI() + "," + FindMContactIntroUI.this.getClass().getName() + ",R300_200_phone," + as.fJ("R300_200_phone") + ",2");
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    as.Hm();
                    c.Db().set(12322, Boolean.valueOf(false));
                }
            });
        } else if (m.NS()) {
            b.pa(as.CI() + "," + findMContactIntroUI.getClass().getName() + ",R300_200_phone," + as.fJ("R300_200_phone") + ",1");
            h.a((Context) findMContactIntroUI, R.l.ehX, R.l.dGZ, R.l.dGf, R.l.dEy, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    as.Hm();
                    c.Db().set(12322, Boolean.valueOf(true));
                    FindMContactIntroUI.this.crr();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    as.Hm();
                    c.Db().set(12322, Boolean.valueOf(false));
                }
            });
        } else {
            findMContactIntroUI.crr();
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        setMMTitle(R.l.chV);
        a.ihO.uq();
        this.liu = getIntent().getStringExtra("regsetinfo_ticket");
        this.ydo = getIntent().getStringExtra("regsetinfo_NextStep");
        this.ydp = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        if (m.NT() != m.a.SUCC) {
            z = true;
        } else {
            z = false;
        }
        this.yuG = z;
        this.pXN = b.Xw();
        x.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", this.ydo, Integer.valueOf(this.ydp));
    }

    public void onDestroy() {
        if (this.hRg != null) {
            as.CN().b((int) d.CTRL_INDEX, this.hRg);
            this.hRg = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        initView();
        if (this.yuG) {
            b.b(true, as.CI() + "," + getClass().getName() + ",R300_100_QQ," + as.fJ("R300_100_QQ") + ",1");
            b.oY("R300_100_QQ");
            return;
        }
        b.b(true, as.CI() + "," + getClass().getName() + ",R300_100_phone," + as.fJ("R300_100_phone") + ",1");
        b.oY("R300_100_phone");
    }

    protected void onPause() {
        super.onPause();
        b.oZ("RE900_100");
        if (this.yuG) {
            b.b(false, as.CI() + "," + getClass().getName() + ",R300_100_QQ," + as.fJ("R300_100_QQ") + ",4");
        } else {
            b.b(false, as.CI() + "," + getClass().getName() + ",R300_100_phone," + as.fJ("R300_100_phone") + ",4");
        }
    }

    protected final void initView() {
        this.yuO = (Button) findViewById(R.h.cMc);
        this.yuP = (TextView) findViewById(R.h.chZ);
        this.qbT = (TextView) findViewById(R.h.chY);
        if (this.ydo == null || !this.ydo.contains("2")) {
            this.qbT.setText(getString(R.l.ehV));
        } else {
            this.qbT.setText(getString(R.l.ehU));
        }
        as.Hm();
        this.fBa = (String) c.Db().get(6, null);
        if (this.fBa == null || this.fBa.equals("")) {
            as.Hm();
            this.fBa = (String) c.Db().get(4097, null);
        }
        this.yuO.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FindMContactIntroUI.a(FindMContactIntroUI.this);
            }
        });
        this.yuP.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                h.a(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(R.l.eih), null, FindMContactIntroUI.this.getString(R.l.eii), FindMContactIntroUI.this.getString(R.l.eig), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FindMContactIntroUI.this.bpd();
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
    }

    private void crr() {
        x.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.chl());
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            n CN = as.CN();
            e anonymousClass9 = new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    if (FindMContactIntroUI.this.inI != null) {
                        FindMContactIntroUI.this.inI.dismiss();
                        FindMContactIntroUI.this.inI = null;
                    }
                    if (FindMContactIntroUI.this.hRg != null) {
                        as.CN().b((int) d.CTRL_INDEX, FindMContactIntroUI.this.hRg);
                        FindMContactIntroUI.this.hRg = null;
                    }
                    if (i == 0 && i2 == 0) {
                        int i3;
                        LinkedList Ow = ((y) kVar).Ow();
                        af.f(Ow);
                        int i4;
                        if (Ow == null || Ow.size() <= 0) {
                            i4 = 0;
                            i3 = 0;
                        } else {
                            Iterator it = Ow.iterator();
                            i3 = 0;
                            while (it.hasNext()) {
                                aph aph = (aph) it.next();
                                if (aph != null) {
                                    if (aph.kyY == 1) {
                                        i4 = i3 + 1;
                                    } else {
                                        i4 = i3;
                                    }
                                    i3 = i4;
                                }
                            }
                            i4 = i3 > 0 ? 1 : 0;
                        }
                        String str2 = "MicroMsg.FindMContactIntroUI";
                        String str3 = "tigerreg data size=%d, addcount=%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(Ow == null ? 0 : Ow.size());
                        objArr[1] = Integer.valueOf(i3);
                        x.d(str2, str3, objArr);
                        if (FindMContactIntroUI.this.ydo == null || !FindMContactIntroUI.this.ydo.contains("1") || i4 == 0) {
                            FindMContactIntroUI.this.bpd();
                            return;
                        }
                        b.oZ("R300_300_phone");
                        Intent intent = new Intent(FindMContactIntroUI.this, FindMContactAddUI.class);
                        intent.putExtra("regsetinfo_ticket", FindMContactIntroUI.this.liu);
                        intent.putExtra("regsetinfo_NextStep", FindMContactIntroUI.this.ydo);
                        intent.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.this.ydp);
                        intent.putExtra("login_type", 0);
                        MMWizardActivity.A(FindMContactIntroUI.this, intent);
                        return;
                    }
                    Toast.makeText(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(R.l.dFa, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            };
            this.hRg = anonymousClass9;
            CN.a((int) d.CTRL_INDEX, anonymousClass9);
            Context context = this.mController.xRr;
            getString(R.l.dGZ);
            this.inI = h.a(context, getString(R.l.eYK), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (FindMContactIntroUI.this.hRg != null) {
                        as.CN().b((int) d.CTRL_INDEX, FindMContactIntroUI.this.hRg);
                        FindMContactIntroUI.this.hRg = null;
                    }
                }
            });
            as.Dt().a(new ah.a() {
                public final boolean JI() {
                    if (FindMContactIntroUI.this.hxB == null || FindMContactIntroUI.this.hxB.size() == 0) {
                        if (FindMContactIntroUI.this.inI != null) {
                            FindMContactIntroUI.this.inI.dismiss();
                            FindMContactIntroUI.this.inI = null;
                        }
                        FindMContactIntroUI.this.bpd();
                    } else {
                        FindMContactIntroUI.this.yuH = new y(FindMContactIntroUI.this.liu, FindMContactIntroUI.this.hxB);
                        as.CN().a(FindMContactIntroUI.this.yuH, 0);
                    }
                    return false;
                }

                public final boolean JH() {
                    try {
                        FindMContactIntroUI.this.hxB = com.tencent.mm.pluginsdk.a.bW(FindMContactIntroUI.this);
                        x.d("MicroMsg.FindMContactIntroUI", "tigerreg mobileList size " + (FindMContactIntroUI.this.hxB == null ? 0 : FindMContactIntroUI.this.hxB.size()));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.FindMContactIntroUI", e, "", new Object[0]);
                    }
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|doUpload";
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
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

    protected final int getLayoutId() {
        return R.i.din;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactIntroUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case org.xwalk.core.R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    crr();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.eAb), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            FindMContactIntroUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}

package com.tencent.mm.ui.bindmobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.n;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.y;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.g.a;
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

public class FindMContactLearmMoreUI extends MMWizardActivity {
    private String fBa;
    private e hRg = null;
    private List<String[]> hxB = null;
    private ProgressDialog inI = null;
    private String liu = null;
    private String ydo = "";
    private int ydp = 2;
    private y yuH;
    private Button yuS;
    private TextView yuT;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.liu = getIntent().getStringExtra("regsetinfo_ticket");
        this.ydo = getIntent().getStringExtra("regsetinfo_NextStep");
        this.ydp = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        initView();
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
        b.oY("R300_100_phone");
        b.b(true, as.CI() + "," + getClass().getName() + ",RE300_600," + as.fJ("RE300_600") + ",1");
    }

    protected void onPause() {
        super.onPause();
        b.b(false, as.CI() + "," + getClass().getName() + ",RE300_600," + as.fJ("RE300_600") + ",2");
    }

    protected final void initView() {
        setMMTitle(R.l.eim);
        this.yuS = (Button) findViewById(R.h.cBI);
        this.yuT = (TextView) findViewById(R.h.bPp);
        this.yuS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                as.Hm();
                c.Db().set(12322, Boolean.valueOf(true));
                m.k(true, false);
                FindMContactLearmMoreUI.this.crr();
            }
        });
        this.yuT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                as.Hm();
                c.Db().set(12322, Boolean.valueOf(false));
                m.k(false, false);
                FindMContactLearmMoreUI.this.bpd();
            }
        });
        as.Hm();
        c.Db().set(12323, Boolean.valueOf(true));
        as.Hm();
        this.fBa = (String) c.Db().get(6, null);
        if (this.fBa == null || this.fBa.equals("")) {
            as.Hm();
            this.fBa = (String) c.Db().get(4097, null);
        }
    }

    private void crr() {
        x.i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.chl());
        if (a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            n CN = as.CN();
            e anonymousClass3 = new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    if (FindMContactLearmMoreUI.this.inI != null) {
                        FindMContactLearmMoreUI.this.inI.dismiss();
                        FindMContactLearmMoreUI.this.inI = null;
                    }
                    if (FindMContactLearmMoreUI.this.hRg != null) {
                        as.CN().b((int) d.CTRL_INDEX, FindMContactLearmMoreUI.this.hRg);
                        FindMContactLearmMoreUI.this.hRg = null;
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
                        String str2 = "MicroMsg.FindMContactLearmMoreUI";
                        String str3 = "tigerreg data size=%d, addcount=%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(Ow == null ? 0 : Ow.size());
                        objArr[1] = Integer.valueOf(i3);
                        x.d(str2, str3, objArr);
                        if (FindMContactLearmMoreUI.this.ydo == null || !FindMContactLearmMoreUI.this.ydo.contains("1") || i4 == 0) {
                            FindMContactLearmMoreUI.this.bpd();
                            return;
                        }
                        b.oZ("R300_300_phone");
                        Intent intent = new Intent(FindMContactLearmMoreUI.this, FindMContactAddUI.class);
                        intent.putExtra("regsetinfo_ticket", FindMContactLearmMoreUI.this.liu);
                        intent.putExtra("regsetinfo_NextStep", FindMContactLearmMoreUI.this.ydo);
                        intent.putExtra("regsetinfo_NextStyle", FindMContactLearmMoreUI.this.ydp);
                        intent.putExtra("login_type", 0);
                        MMWizardActivity.A(FindMContactLearmMoreUI.this, intent);
                        return;
                    }
                    Toast.makeText(FindMContactLearmMoreUI.this, FindMContactLearmMoreUI.this.getString(R.l.dFa, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    FindMContactLearmMoreUI.this.bpd();
                }
            };
            this.hRg = anonymousClass3;
            CN.a((int) d.CTRL_INDEX, anonymousClass3);
            Context context = this.mController.xRr;
            getString(R.l.dGZ);
            this.inI = h.a(context, getString(R.l.eYK), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (FindMContactLearmMoreUI.this.hRg != null) {
                        as.CN().b((int) d.CTRL_INDEX, FindMContactLearmMoreUI.this.hRg);
                        FindMContactLearmMoreUI.this.hRg = null;
                    }
                }
            });
            as.Dt().a(new ah.a() {
                public final boolean JI() {
                    if (FindMContactLearmMoreUI.this.hxB == null || FindMContactLearmMoreUI.this.hxB.size() == 0) {
                        if (FindMContactLearmMoreUI.this.inI != null) {
                            FindMContactLearmMoreUI.this.inI.dismiss();
                            FindMContactLearmMoreUI.this.inI = null;
                        }
                        FindMContactLearmMoreUI.this.bpd();
                    } else {
                        FindMContactLearmMoreUI.this.yuH = new y(FindMContactLearmMoreUI.this.liu, FindMContactLearmMoreUI.this.hxB);
                        as.CN().a(FindMContactLearmMoreUI.this.yuH, 0);
                    }
                    return false;
                }

                public final boolean JH() {
                    try {
                        FindMContactLearmMoreUI.this.hxB = com.tencent.mm.pluginsdk.a.bW(FindMContactLearmMoreUI.this);
                        x.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg mobileList size " + (FindMContactLearmMoreUI.this.hxB == null ? 0 : FindMContactLearmMoreUI.this.hxB.size()));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.FindMContactLearmMoreUI", e, "", new Object[0]);
                    }
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|doUpload";
                }
            });
            m.k(true, false);
            com.tencent.mm.modelfriend.a.Ns();
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
        aWY();
        En(1);
    }

    protected final int getLayoutId() {
        return R.i.dio;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactLearmMoreUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case org.xwalk.core.R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    crr();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.eAb), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            FindMContactLearmMoreUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener() {
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

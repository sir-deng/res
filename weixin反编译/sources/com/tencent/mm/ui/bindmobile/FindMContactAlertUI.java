package com.tencent.mm.ui.bindmobile;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
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
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aph;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAlertUI extends MMWizardActivity {
    private int X = 0;
    private int Y = 0;
    private String fBa;
    private e hRg = null;
    private List<String[]> hxB = null;
    private ProgressDialog inI = null;
    private String jCc;
    private String jCd;
    private String liu = null;
    private String pXN;
    private int rti = 0;
    private String ydo = "";
    private int ydp = 2;
    private String yuE = null;
    private String yuF = null;
    private boolean yuG = false;
    private y yuH;
    private int yuI = 0;
    private final int yuJ = 200;
    private int yuK = 0;
    private int yuL = 0;
    private int yuM = 0;

    static /* synthetic */ void a(FindMContactAlertUI findMContactAlertUI, int i, int i2) {
        findMContactAlertUI.yuK = i;
        findMContactAlertUI.yuL = i2;
        if (findMContactAlertUI.yuM > 0 && findMContactAlertUI.rti > 0) {
            findMContactAlertUI.crq();
        }
    }

    static /* synthetic */ void b(FindMContactAlertUI findMContactAlertUI, int i, int i2) {
        findMContactAlertUI.yuM = i;
        findMContactAlertUI.rti = i2;
        if (findMContactAlertUI.yuK > 0 && findMContactAlertUI.yuL > 0) {
            findMContactAlertUI.crq();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.chV);
        a.ihO.uq();
        this.liu = getIntent().getStringExtra("regsetinfo_ticket");
        this.ydo = getIntent().getStringExtra("regsetinfo_NextStep");
        this.ydp = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.yuE = getIntent().getStringExtra("alert_title");
        this.yuF = getIntent().getStringExtra("alert_message");
        this.yuG = m.NT() != m.a.SUCC;
        this.pXN = b.Xw();
        x.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", this.ydo, Integer.valueOf(this.ydp));
        if (!isFinishing()) {
            initView();
            crp();
        }
    }

    public void onDestroy() {
        x.d("MicroMsg.FindMContactAlertUI", "ondestroy");
        if (this.hRg != null) {
            as.CN().b((int) d.CTRL_INDEX, this.hRg);
            this.hRg = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (this.yuG) {
            b.oY("R300_100_QQ");
            b.b(true, as.CI() + "," + getClass().getName() + ",R300_100_QQ," + as.fJ("R300_100_QQ") + ",1");
            return;
        }
        b.oY("R300_100_phone");
        b.b(true, as.CI() + "," + getClass().getName() + ",RE300_100," + as.fJ("RE300_100") + ",1");
    }

    protected void onPause() {
        super.onPause();
        if (this.yuG) {
            b.b(false, as.CI() + "," + getClass().getName() + ",R300_100_QQ," + as.fJ("R300_100_QQ") + ",2");
        } else {
            b.b(false, as.CI() + "," + getClass().getName() + ",RE300_100," + as.fJ("RE300_100") + ",2");
        }
    }

    protected final void initView() {
        this.jCc = getString(R.l.ehY);
        this.jCd = getString(R.l.ehX);
        if (!bi.oN(this.yuE)) {
            this.jCc = this.yuE;
        }
        if (!bi.oN(this.yuF)) {
            this.jCd = this.yuF;
        }
        as.Hm();
        this.fBa = (String) c.Db().get(6, null);
        if (this.fBa == null || this.fBa.equals("")) {
            as.Hm();
            this.fBa = (String) c.Db().get(4097, null);
        }
    }

    private void crp() {
        if (this.yuG) {
            b.pa(as.CI() + "," + getClass().getName() + ",R300_200_phone," + as.fJ("R300_200_phone") + ",1");
            h.a((Context) this, false, getString(R.l.ehX), getString(R.l.dGZ), getString(R.l.dGf), getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    as.Hm();
                    c.Db().set(12322, Boolean.valueOf(true));
                    b.oZ("R200_100");
                    Intent intent = new Intent();
                    intent.putExtra("mobile_input_purpose", 4);
                    intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.this.liu);
                    intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.this.ydo);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.this.ydp);
                    a.ihN.a(FindMContactAlertUI.this, intent);
                    b.oZ("R300_300_phone");
                    b.b(false, as.CI() + "," + FindMContactAlertUI.this.getClass().getName() + ",R300_200_phone," + as.fJ("R300_200_phone") + ",2");
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    as.Hm();
                    c.Db().set(12322, Boolean.valueOf(false));
                    b.pa(as.CI() + "," + FindMContactAlertUI.this.getClass().getName() + ",R300_200_phone," + as.fJ("R300_200_phone") + ",2");
                    FindMContactAlertUI.this.bpd();
                }
            });
        } else if (m.NS()) {
            CharSequence charSequence = this.jCd;
            CharSequence charSequence2 = this.jCc;
            int i = R.l.eil;
            int i2 = R.l.eik;
            OnClickListener anonymousClass5 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    as.Hm();
                    c.Db().set(12322, Boolean.valueOf(true));
                    FindMContactAlertUI.this.crr();
                    dialogInterface.dismiss();
                }
            };
            OnClickListener anonymousClass6 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(FindMContactAlertUI.this, FindMContactLearmMoreUI.class);
                    intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.this.liu);
                    intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.this.ydo);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.this.ydp);
                    MMWizardActivity.A(FindMContactAlertUI.this, intent);
                }
            };
            final Dialog iVar = new i(this);
            iVar.setTitle(charSequence2);
            iVar.setMessage(charSequence);
            iVar.a(i, anonymousClass5);
            iVar.b(i2, anonymousClass6);
            iVar.tbx.setVisibility(0);
            iVar.setCancelable(false);
            iVar.show();
            iVar.getWindow().clearFlags(2);
            addDialog(iVar);
            iVar.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    int measuredWidth;
                    iVar.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    int measuredWidth2 = iVar.getWindow().getDecorView().getMeasuredWidth();
                    int measuredHeight = iVar.getWindow().getDecorView().getMeasuredHeight();
                    View a = FindMContactAlertUI.this.j((ViewGroup) iVar.getWindow().getDecorView());
                    if (a != null) {
                        measuredWidth = a.getMeasuredWidth() * 2;
                    } else {
                        measuredWidth = measuredWidth2;
                    }
                    x.d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
                    FindMContactAlertUI.a(FindMContactAlertUI.this, measuredWidth, measuredHeight);
                }
            });
            final View findViewById = findViewById(R.h.background);
            findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    findViewById.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    int measuredHeight = findViewById.getMeasuredHeight();
                    x.d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", Integer.valueOf(findViewById.getMeasuredWidth()), Integer.valueOf(measuredHeight));
                    FindMContactAlertUI.b(FindMContactAlertUI.this, r1, measuredHeight);
                }
            });
        } else {
            crr();
        }
    }

    private View j(ViewGroup viewGroup) {
        if (this.yuI >= 200) {
            return null;
        }
        this.yuI++;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof Button) {
                return childAt;
            }
            if (childAt instanceof ViewGroup) {
                childAt = j((ViewGroup) childAt);
                if (childAt != null) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private void crq() {
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int dimensionPixelSize = this.yuM - (getResources().getDimensionPixelSize(R.f.bvN) + com.tencent.mm.bu.a.fromDPToPix(this, 48));
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(this, 20) + (((height / 2) + (this.yuL / 2)) - (height - this.rti));
        if (dimensionPixelSize != this.X || fromDPToPix != this.Y) {
            this.X = dimensionPixelSize;
            this.Y = fromDPToPix;
            View findViewById = findViewById(R.h.chW);
            findViewById.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.setMargins(dimensionPixelSize - (findViewById.getMeasuredWidth() / 2), fromDPToPix, 0, 0);
            x.d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", Integer.valueOf(dimensionPixelSize), Integer.valueOf(fromDPToPix), Integer.valueOf(findViewById.getMeasuredWidth()));
            findViewById.setLayoutParams(layoutParams);
            findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.a.bpR));
        }
    }

    private void crr() {
        x.i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.chl());
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            View findViewById = findViewById(R.h.chW);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            n CN = as.CN();
            e anonymousClass9 = new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    if (FindMContactAlertUI.this.inI != null) {
                        FindMContactAlertUI.this.inI.dismiss();
                        FindMContactAlertUI.this.inI = null;
                    }
                    if (FindMContactAlertUI.this.hRg != null) {
                        as.CN().b((int) d.CTRL_INDEX, FindMContactAlertUI.this.hRg);
                        FindMContactAlertUI.this.hRg = null;
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
                        String str2 = "MicroMsg.FindMContactAlertUI";
                        String str3 = "tigerreg data size=%d, addcount=%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(Ow == null ? 0 : Ow.size());
                        objArr[1] = Integer.valueOf(i3);
                        x.d(str2, str3, objArr);
                        if (FindMContactAlertUI.this.ydo == null || !FindMContactAlertUI.this.ydo.contains("1") || i4 == 0) {
                            FindMContactAlertUI.this.bpd();
                            return;
                        }
                        b.oZ("R300_300_phone");
                        Intent intent = new Intent(FindMContactAlertUI.this, FindMContactAddUI.class);
                        intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.this.liu);
                        intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.this.ydo);
                        intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.this.ydp);
                        intent.putExtra("login_type", 0);
                        MMWizardActivity.A(FindMContactAlertUI.this, intent);
                        return;
                    }
                    Toast.makeText(FindMContactAlertUI.this, FindMContactAlertUI.this.getString(R.l.dFa, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    FindMContactAlertUI.this.bpd();
                }
            };
            this.hRg = anonymousClass9;
            CN.a((int) d.CTRL_INDEX, anonymousClass9);
            Context context = this.mController.xRr;
            getString(R.l.dGZ);
            this.inI = h.a(context, getString(R.l.eYK), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (FindMContactAlertUI.this.hRg != null) {
                        as.CN().b((int) d.CTRL_INDEX, FindMContactAlertUI.this.hRg);
                        FindMContactAlertUI.this.hRg = null;
                        FindMContactAlertUI.this.crp();
                    }
                }
            });
            as.Dt().a(new ah.a() {
                public final boolean JI() {
                    if (FindMContactAlertUI.this.hxB == null || FindMContactAlertUI.this.hxB.size() == 0) {
                        if (FindMContactAlertUI.this.inI != null) {
                            FindMContactAlertUI.this.inI.dismiss();
                            FindMContactAlertUI.this.inI = null;
                        }
                        FindMContactAlertUI.this.bpd();
                    } else {
                        FindMContactAlertUI.this.yuH = new y(FindMContactAlertUI.this.liu, FindMContactAlertUI.this.hxB);
                        as.CN().a(FindMContactAlertUI.this.yuH, 0);
                    }
                    return false;
                }

                public final boolean JH() {
                    try {
                        FindMContactAlertUI.this.hxB = com.tencent.mm.pluginsdk.a.bW(FindMContactAlertUI.this);
                        x.d("MicroMsg.FindMContactAlertUI", "tigerreg mobileList size " + (FindMContactAlertUI.this.hxB == null ? 0 : FindMContactAlertUI.this.hxB.size()));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.FindMContactAlertUI", e, "", new Object[0]);
                    }
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|doUpload";
                }
            });
            com.tencent.mm.platformtools.m.k(true, false);
            com.tencent.mm.modelfriend.a.Ns();
            g.pWK.h(11438, Integer.valueOf(1));
            x.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(1));
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
        return R.i.dip;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactAlertUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case org.xwalk.core.R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    crr();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.eAb), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            FindMContactAlertUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
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

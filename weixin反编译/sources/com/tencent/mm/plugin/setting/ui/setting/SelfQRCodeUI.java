package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileObserver;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.af.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bj;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class SelfQRCodeUI extends MMActivity implements e {
    private static final String qnC = (h.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/");
    private Bitmap hmD = null;
    private ProgressDialog inI = null;
    private ImageView jIs = null;
    private long lrE;
    private ImageView qmL = null;
    private byte[] qmM = null;
    private boolean qnA = false;
    private a qnB;
    private TextView qny = null;
    private TextView qnz = null;
    private String userName = "";

    public class a extends FileObserver {
        private MMActivity qnE;
        private String qnF;

        public a(MMActivity mMActivity) {
            super(SelfQRCodeUI.qnC, 8);
            this.qnE = mMActivity;
        }

        public final void onEvent(int i, String str) {
            if (str != null && i == 8) {
                if (this.qnF == null || !str.equalsIgnoreCase(this.qnF)) {
                    this.qnF = str;
                    Uri.fromFile(new File(SelfQRCodeUI.qnC + str));
                    SelfQRCodeUI.brf();
                    x.i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
                }
            }
        }

        public final void start() {
            super.startWatching();
        }

        public final void stop() {
            super.stopWatching();
        }
    }

    static /* synthetic */ void b(SelfQRCodeUI selfQRCodeUI) {
        g gVar = new g(selfQRCodeUI, g.zCt, false);
        gVar.rQF = new c() {
            public final void a(n nVar) {
                boolean eX = s.eX(SelfQRCodeUI.this.userName);
                boolean ka = f.ka(SelfQRCodeUI.this.userName);
                if (!(ka || eX)) {
                    nVar.eT(2, R.l.eJK);
                }
                nVar.eT(1, R.l.eJO);
                if (!ka) {
                    nVar.eT(3, R.l.eJZ);
                }
                if (SelfQRCodeUI.this.qnA) {
                    nVar.eT(4, R.l.eJY);
                }
            }
        };
        gVar.rQG = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        SelfQRCodeUI.e(SelfQRCodeUI.this);
                        return;
                    case 2:
                        SelfQRCodeUI.this.wj(0);
                        return;
                    case 3:
                        if (!com.tencent.mm.o.a.aV(SelfQRCodeUI.this.mController.xRr)) {
                            ActionBarActivity actionBarActivity = SelfQRCodeUI.this.mController.xRr;
                            if (!com.tencent.mm.at.a.Qq()) {
                                com.tencent.mm.bl.d.y(SelfQRCodeUI.this.mController.xRr, "scanner", ".ui.BaseScanUI");
                                return;
                            }
                            return;
                        }
                        return;
                    case 4:
                        com.tencent.mm.ui.base.h.a((Context) SelfQRCodeUI.this, true, SelfQRCodeUI.this.getString(R.l.eEU), SelfQRCodeUI.this.getString(R.l.eEV), SelfQRCodeUI.this.getString(R.l.eEW), SelfQRCodeUI.this.getString(R.l.cancel), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                SelfQRCodeUI.this.wj(2);
                            }
                        }, null);
                        return;
                    default:
                        return;
                }
            }
        };
        gVar.bUX();
    }

    static /* synthetic */ void e(SelfQRCodeUI selfQRCodeUI) {
        byte[] toByteArray;
        Throwable e;
        if (s.eX(selfQRCodeUI.userName) || f.ka(selfQRCodeUI.userName)) {
            com.tencent.mm.plugin.report.service.g.pWK.a(219, 10, 1, true);
            Bitmap de = com.tencent.mm.sdk.platformtools.d.de(selfQRCodeUI.findViewById(R.h.cFi));
            if (de != null) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                de.compress(CompressFormat.PNG, 90, byteArrayOutputStream);
                toByteArray = byteArrayOutputStream.toByteArray();
            } else {
                toByteArray = null;
            }
            if (toByteArray == null) {
                toByteArray = selfQRCodeUI.qmM;
            }
        } else {
            toByteArray = selfQRCodeUI.qmM;
        }
        if (toByteArray != null && toByteArray.length > 0) {
            String str = k.cds() + "mmqrcode" + System.currentTimeMillis() + ".png";
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    fileOutputStream.write(toByteArray);
                    Toast.makeText(selfQRCodeUI, selfQRCodeUI.getString(R.l.dYb, new Object[]{k.cds()}), 1).show();
                    k.b(str, selfQRCodeUI);
                    try {
                        fileOutputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.SelfQRCodeNewUI", e, "", new Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
                x.printErrStackTrace("MicroMsg.SelfQRCodeNewUI", e, "", new Object[0]);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.drW;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qnB = new a(this);
        this.qnB.start();
        as.CN().a((int) JsApiSetClipboardData.CTRL_INDEX, (e) this);
        initView();
        this.qmL.post(new Runnable() {
            public final void run() {
                int width = SelfQRCodeUI.this.qmL.getWidth();
                LayoutParams layoutParams = (LayoutParams) SelfQRCodeUI.this.qmL.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = width;
                SelfQRCodeUI.this.qmL.setLayoutParams(layoutParams);
            }
        });
    }

    public void onDestroy() {
        as.CN().b((int) JsApiSetClipboardData.CTRL_INDEX, (e) this);
        if (this.qnB != null) {
            this.qnB.stop();
        }
        if (!(this.hmD == null || this.hmD.isRecycled())) {
            this.hmD.recycle();
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (!s.eX(this.userName) && !f.ka(this.userName)) {
            View findViewById = findViewById(R.h.cLw);
            this.lrE = q.Gd();
            x.d("MicroMsg.SelfQRCodeNewUI", (this.lrE & 2) + ",extstatus:" + this.lrE);
            if ((this.lrE & 2) != 0) {
                findViewById.setVisibility(0);
                this.qmL.setAlpha(0.1f);
                findViewById(R.h.cLv).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        com.tencent.mm.bl.d.y(SelfQRCodeUI.this, "setting", ".ui.setting.SettingsAddMeUI");
                    }
                });
                return;
            }
            findViewById.setVisibility(8);
            this.qmL.setAlpha(1.0f);
        }
    }

    protected final void initView() {
        this.userName = getIntent().getStringExtra("from_userName");
        if (bi.oN(this.userName)) {
            this.userName = q.FY();
        }
        if (q.FY().equals(this.userName)) {
            this.qnA = true;
        }
        if (s.eX(this.userName)) {
            setMMTitle(R.l.eNe);
            ((TextView) findViewById(R.h.cFr)).setText("");
            enableOptionMenu(false);
        } else if (f.ka(this.userName)) {
            setMMTitle(R.l.eck);
            ((TextView) findViewById(R.h.cFr)).setText(R.l.ecl);
            enableOptionMenu(false);
        } else {
            setMMTitle(R.l.eMX);
        }
        this.qmL = (ImageView) findViewById(R.h.cLt);
        this.jIs = (ImageView) findViewById(R.h.cos);
        this.qny = (TextView) findViewById(R.h.cAo);
        this.qnz = (TextView) findViewById(R.h.ccj);
        CharSequence charSequence;
        if (!s.eX(this.userName) && !f.ka(this.userName)) {
            as.Hm();
            String str = (String) com.tencent.mm.y.c.Db().get(42, null);
            String string = getString(R.l.dFp);
            if (bi.oN(str)) {
                as.Hm();
                str = (String) com.tencent.mm.y.c.Db().get(2, null);
                string = string + str;
                com.tencent.mm.storage.x.Xi(str);
                str = string;
            } else {
                str = string + str;
            }
            x.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", str);
            if (this.hmD == null) {
                x.d("MicroMsg.SelfQRCodeNewUI", "%s", "bitmap == null");
                wj(1);
            } else {
                this.qmL.setImageBitmap(this.hmD);
            }
            b.a(this.jIs, q.FY());
            as.Hm();
            x.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", (String) com.tencent.mm.y.c.Db().get(4, null));
            this.qny.setText(i.c(this, str, com.tencent.mm.bu.a.aa(this.mController.xRr, R.f.bvt)));
            bj HW = bj.HW();
            string = bi.oM(HW.getProvince());
            x.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", r.gy(string) + " " + bi.oM(HW.getCity()));
            this.qnz.setText(charSequence);
            as.Hm();
            switch (bi.a((Integer) com.tencent.mm.y.c.Db().get(12290, null), 0)) {
                case 1:
                    this.qny.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bu.a.b(this, R.k.dyY), null);
                    break;
                case 2:
                    this.qny.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bu.a.b(this, R.k.dyX), null);
                    break;
            }
        }
        wj(1);
        b.a(this.jIs, this.userName);
        as.Hm();
        ag Xv = com.tencent.mm.y.c.Ff().Xv(this.userName);
        this.qny.setSingleLine(false);
        this.qny.setMaxLines(3);
        this.qny.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (Xv != null) {
            charSequence = Xv.field_nickname;
            if (bi.oN(charSequence)) {
                as.Hm();
                charSequence = com.tencent.mm.y.c.Fo().hH(this.userName).field_displayname;
            }
            this.qny.setText(i.b(this, charSequence, this.qny.getTextSize()));
        } else {
            this.qny.setVisibility(8);
        }
        this.qnz.setVisibility(8);
        addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SelfQRCodeUI.b(SelfQRCodeUI.this);
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SelfQRCodeUI.this.aWY();
                SelfQRCodeUI.this.finish();
                return true;
            }
        });
    }

    private void wj(int i) {
        int e;
        if (this.qnA) {
            as.Hm();
            e = bi.e((Integer) com.tencent.mm.y.c.Db().get(66561, null));
        } else {
            e = 0;
        }
        final com.tencent.mm.ad.k aVar = new com.tencent.mm.az.a(this.userName, e, i);
        as.CN().a(aVar, 0);
        Context context = this.mController.xRr;
        getString(R.l.dGZ);
        this.inI = com.tencent.mm.ui.base.h.a(context, getString(R.l.eJN), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(aVar);
                if (s.eX(SelfQRCodeUI.this.userName) || f.ka(SelfQRCodeUI.this.userName)) {
                    SelfQRCodeUI.this.finish();
                }
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        com.tencent.mm.az.a aVar = (com.tencent.mm.az.a) kVar;
        if (kVar.getType() == JsApiSetClipboardData.CTRL_INDEX && !com.tencent.mm.plugin.setting.a.ihO.b(this.mController.xRr, i, i2, str)) {
            if (i == 0 && i2 == 0) {
                this.qmM = aVar.hLK;
                this.hmD = com.tencent.mm.sdk.platformtools.d.bn(this.qmM);
                if (s.eX(this.userName) || f.ka(this.userName)) {
                    enableOptionMenu(true);
                    CharSequence charSequence = aVar.hLI;
                    if (!bi.oN(charSequence)) {
                        ((TextView) findViewById(R.h.cFr)).setText(charSequence);
                    }
                } else if (this.qnA) {
                    CharSequence charSequence2 = aVar.hLJ;
                    TextView textView = (TextView) findViewById(R.h.cSi);
                    View view = (View) textView.getParent();
                    if (bi.oN(charSequence2)) {
                        view.setVisibility(8);
                    } else {
                        textView.setText(charSequence2);
                        view.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                com.tencent.mm.ui.base.h.a((Context) SelfQRCodeUI.this, true, SelfQRCodeUI.this.getString(R.l.eEU), SelfQRCodeUI.this.getString(R.l.eEV), SelfQRCodeUI.this.getString(R.l.eEW), SelfQRCodeUI.this.getString(R.l.cancel), /* anonymous class already generated */, null);
                            }
                        });
                        view.setVisibility(0);
                    }
                }
                this.qmL.setImageBitmap(this.hmD);
                return;
            }
            Toast.makeText(this, getString(R.l.ejt, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }

    public static void brf() {
        com.tencent.mm.plugin.report.service.g.pWK.a(219, 14, 1, true);
    }
}

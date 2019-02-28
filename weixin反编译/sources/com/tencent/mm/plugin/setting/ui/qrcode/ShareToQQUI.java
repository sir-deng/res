package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.mm.z.a;

public class ShareToQQUI extends MMActivity implements e {
    private ProgressDialog inI = null;
    private EditText pwv;
    private TextView qmF;
    private int qmG;
    private boolean qmH = false;

    static /* synthetic */ void d(ShareToQQUI shareToQQUI) {
        x.e("MicroMsg.ShareToQQUI", "dealWithRefreshTokenFail");
        if (!shareToQQUI.qmH) {
            String string = shareToQQUI.mController.xRr.getString(R.l.dGZ);
            h.a(shareToQQUI.mController.xRr, shareToQQUI.mController.xRr.getString(R.l.eey), string, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(ShareToQQUI.this.mController.xRr, FacebookAuthUI.class);
                    intent.putExtra("is_force_unbind", true);
                    ShareToQQUI.this.mController.xRr.startActivityForResult(intent, 8);
                }
            }, null);
        }
    }

    protected final int getLayoutId() {
        return R.i.dfF;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(26, (e) this);
        initView();
        if (q.Gz()) {
            c cVar = new c("290293790992170");
            as.Hm();
            cVar.aap(bi.oM((String) com.tencent.mm.y.c.Db().get(65830, null)));
            new com.tencent.mm.ui.account.h(cVar, new a() {
                public final void k(Bundle bundle) {
                    super.k(bundle);
                }

                public final void onError(int i, String str) {
                    super.onError(i, str);
                    if (i == 3) {
                        ShareToQQUI.d(ShareToQQUI.this);
                    }
                }
            }).coJ();
        }
    }

    public void onDestroy() {
        as.CN().b(26, (e) this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eKl);
        this.pwv = (EditText) findViewById(R.h.content);
        this.qmF = (TextView) findViewById(R.h.cZN);
        this.pwv.addTextChangedListener(new MMEditText.c(this.pwv, this.qmF, 280));
        this.qmG = getIntent().getIntExtra("show_to", 2);
        if (this.qmG == 4) {
            this.pwv.setText(R.l.eJU);
        } else {
            this.pwv.setText(R.l.eJW);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShareToQQUI.this.aWY();
                ShareToQQUI.this.finish();
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.l.dGP), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                k adVar;
                ShareToQQUI.this.qmH = true;
                if (ShareToQQUI.this.qmG == 2 || ShareToQQUI.this.qmG == 1) {
                    boolean z;
                    boolean z2;
                    String obj = ShareToQQUI.this.pwv.getText().toString();
                    if (ShareToQQUI.this.qmG == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (ShareToQQUI.this.qmG == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    adVar = new ad(obj, z, z2);
                } else if (ShareToQQUI.this.qmG == 4) {
                    as.Hm();
                    long c = bi.c((Long) com.tencent.mm.y.c.Db().get(65831, null));
                    as.Hm();
                    String oM = bi.oM((String) com.tencent.mm.y.c.Db().get(65830, null));
                    if (bi.bA(c) > 86400000 && oM.length() > 0) {
                        c cVar = new c("290293790992170");
                        cVar.aap(oM);
                        new com.tencent.mm.ui.account.h(cVar, new a() {
                            public final void k(Bundle bundle) {
                                super.k(bundle);
                            }

                            public final void onError(int i, String str) {
                                super.onError(i, str);
                            }
                        }).coJ();
                    }
                    adVar = new ad(ShareToQQUI.this.pwv.getText().toString());
                } else {
                    h.h(ShareToQQUI.this.mController.xRr, R.l.ePu, R.l.dGZ);
                    return true;
                }
                as.CN().a(adVar, 0);
                ShareToQQUI shareToQQUI = ShareToQQUI.this;
                Context context = ShareToQQUI.this.mController.xRr;
                ShareToQQUI.this.getString(R.l.dGZ);
                shareToQQUI.inI = h.a(context, ShareToQQUI.this.getString(R.l.euN), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(adVar);
                    }
                });
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ShareToQQUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 26) {
            if (this.inI != null) {
                this.inI.dismiss();
                this.inI = null;
            }
            if (i == 4 && i2 == -68) {
                if (bi.oN(str)) {
                    str = "error";
                }
                h.a((Context) this, str, getString(R.l.dGZ), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ShareToQQUI.this.mController.xRr, FacebookAuthUI.class);
                        intent.putExtra("is_force_unbind", true);
                        ShareToQQUI.this.mController.xRr.startActivity(intent);
                        ShareToQQUI.this.aWY();
                        ShareToQQUI.this.finish();
                    }
                }, null);
            } else if (i == 0 && i2 == 0) {
                aWY();
                String string = getString(R.l.ePw);
                AnonymousClass4 anonymousClass4 = new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        ShareToQQUI.this.finish();
                    }
                };
                h.bu(this, string);
            } else {
                this.qmH = false;
                if (!com.tencent.mm.plugin.setting.a.ihO.a(this.mController.xRr, i, i2, str)) {
                    Toast.makeText(this, getString(R.l.ePv, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        }
    }
}

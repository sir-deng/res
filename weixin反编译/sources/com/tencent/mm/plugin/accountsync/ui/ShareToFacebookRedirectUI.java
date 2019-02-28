package com.tencent.mm.plugin.accountsync.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.protocal.c.bhj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

@a(3)
public class ShareToFacebookRedirectUI extends MMActivity implements e {
    private static String TAG = "MicroMsg.ShareToFacebookRedirectUI";
    private String inY;
    private String inZ;
    private String ioa;
    private String iob;
    private r ioc;

    static /* synthetic */ void a(ShareToFacebookRedirectUI shareToFacebookRedirectUI) {
        x.e(TAG, "dealWithRefreshTokenFail");
        shareToFacebookRedirectUI.aJ(shareToFacebookRedirectUI.mController.xRr.getString(R.l.dGZ), shareToFacebookRedirectUI.mController.xRr.getString(R.l.eey));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(433, (e) this);
        this.inY = getIntent().getStringExtra("title");
        this.inZ = getIntent().getStringExtra("digest");
        this.ioa = getIntent().getStringExtra("img");
        this.iob = getIntent().getStringExtra("link");
        x.i(TAG, "title %s, digest:%s, img:%s, link:%s", this.inY, this.inZ, this.ioa, this.iob);
        if (q.Gz()) {
            XL();
            XM();
            return;
        }
        Intent intent = new Intent(this, FacebookAuthUI.class);
        intent.putExtra("is_force_unbind", true);
        startActivityForResult(intent, 0);
    }

    protected void onDestroy() {
        as.CN().b(433, (e) this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i(TAG, "type:%d, code:%d, msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        aWY();
        this.ioc.dismiss();
        if (i == 4 && i2 == -68) {
            if (bi.oN(str)) {
                str = "error";
            }
            aJ(getString(R.l.dGZ), str);
        } else if (i == 0 && i2 == 0) {
            String string = getString(R.l.ePw);
            AnonymousClass1 anonymousClass1 = new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                }
            };
            h.bu(this, string);
            finish();
        } else {
            h.a(this.mController.xRr, "err(" + i2 + "," + i + ")", getString(R.l.dGZ), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ShareToFacebookRedirectUI.this.finish();
                }
            }, null);
        }
    }

    private void XL() {
        x.i(TAG, "refreshFacebookToken");
        as.Hm();
        long c = bi.c((Long) c.Db().get(65831, null));
        as.Hm();
        String oM = bi.oM((String) c.Db().get(65830, null));
        if (bi.bA(c) <= 86400000 || oM.length() <= 0) {
            XM();
            return;
        }
        com.tencent.mm.ui.f.a.c cVar = new com.tencent.mm.ui.f.a.c("290293790992170");
        cVar.aap(oM);
        new com.tencent.mm.ui.account.h(cVar, new com.tencent.mm.z.a() {
            public final void k(Bundle bundle) {
                super.k(bundle);
            }

            public final void onError(int i, String str) {
                x.e(ShareToFacebookRedirectUI.TAG, "refresh token error. errType:%d, errMsg:%s", Integer.valueOf(i), str);
                super.onError(i, str);
                if (i == 3) {
                    ShareToFacebookRedirectUI.a(ShareToFacebookRedirectUI.this);
                }
            }
        }).coJ();
    }

    private void XM() {
        x.i(TAG, "doSend");
        final com.tencent.mm.pluginsdk.ui.applet.e.a aVar = new com.tencent.mm.pluginsdk.ui.applet.e.a(this);
        String str = this.inY;
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(aVar.mContext, (int) (20.0f * com.tencent.mm.bu.a.ev(aVar.mContext)));
        if (!bi.oN(str)) {
            aVar.vtY.Q(((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).a(aVar.mContext, str.toString(), (float) fromDPToPix));
        }
        aVar.SV(this.ioa).SU(this.inZ).SX(getString(R.l.dEB)).Co(R.l.dGP).a(new o.a() {
            public final void a(boolean z, String str, int i) {
                ShareToFacebookRedirectUI.this.aWY();
                aVar.pDT.dismiss();
                if (z) {
                    bhj bhj = new bhj();
                    if (bi.oN(str)) {
                        str = " ";
                    }
                    bhj.nlB = str;
                    bhj.nkW = ShareToFacebookRedirectUI.this.inY;
                    bhj.vPF = ShareToFacebookRedirectUI.this.inZ;
                    bhj.oVe = ShareToFacebookRedirectUI.this.iob;
                    bhj.wSx = ShareToFacebookRedirectUI.this.ioa;
                    as.CN().a(new com.tencent.mm.plugin.accountsync.model.c(bhj), 0);
                    ShareToFacebookRedirectUI.this.ioc = h.a(ShareToFacebookRedirectUI.this, "", false, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            ShareToFacebookRedirectUI.this.ioc.dismiss();
                            ShareToFacebookRedirectUI.this.finish();
                        }
                    });
                    return;
                }
                ShareToFacebookRedirectUI.this.finish();
            }
        }).pDT.show();
    }

    private void aJ(String str, String str2) {
        h.a(this.mController.xRr, str2, str, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(ShareToFacebookRedirectUI.this.mController.xRr, FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                ShareToFacebookRedirectUI.this.mController.xRr.startActivityForResult(intent, 0);
            }
        }, null);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = TAG;
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.i(str, str2, objArr);
        if (i == 0 && i2 == -1 && intent != null) {
            x.i(TAG, "bind facebooksucc %b", Boolean.valueOf(intent.getBooleanExtra("bind_facebook_succ", false)));
            if (intent.getBooleanExtra("bind_facebook_succ", false)) {
                XL();
                XM();
                return;
            }
        }
        finish();
    }
}

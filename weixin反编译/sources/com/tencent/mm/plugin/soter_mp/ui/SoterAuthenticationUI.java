package com.tencent.mm.plugin.soter_mp.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.soter.c.g;
import com.tencent.mm.plugin.soter_mp.a.c;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.plugin.soter_mp.b.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(7)
public class SoterAuthenticationUI extends MMActivity {
    public static a rZt = null;
    private String appId = null;
    private int fromScene = -1;
    private r jqf = null;
    private c rZs = null;

    public static class a extends ag {
        private WeakReference<SoterAuthenticationUI> moH;

        /* synthetic */ a(SoterAuthenticationUI soterAuthenticationUI, byte b) {
            this(soterAuthenticationUI);
        }

        static /* synthetic */ void a(a aVar) {
            if (aVar.moH != null) {
                aVar.moH.clear();
            }
        }

        private a(SoterAuthenticationUI soterAuthenticationUI) {
            this.moH = null;
            this.moH = new WeakReference(soterAuthenticationUI);
        }

        @TargetApi(23)
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            e eVar;
            switch (message.what) {
                case 0:
                    x.i("MicroMsg.SoterAuthenticationUI", "hy: inform ok");
                    eVar = (e) message.obj;
                    if (this.moH == null || this.moH.get() == null) {
                        x.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        SoterAuthenticationUI.a((SoterAuthenticationUI) this.moH.get(), eVar);
                        return;
                    }
                case 1:
                    x.i("MicroMsg.SoterAuthenticationUI", "hy: inform cancel");
                    eVar = (e) message.obj;
                    if (this.moH == null || this.moH.get() == null) {
                        x.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        SoterAuthenticationUI.b((SoterAuthenticationUI) this.moH.get(), eVar);
                        return;
                    }
                case 2:
                    x.i("MicroMsg.SoterAuthenticationUI", "hy: inform fail");
                    eVar = (e) message.obj;
                    if (this.moH == null || this.moH.get() == null) {
                        x.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        ((SoterAuthenticationUI) this.moH.get()).a(eVar);
                        return;
                    }
                case 3:
                    x.i("MicroMsg.SoterAuthenticationUI", "hy: request permission");
                    if (this.moH == null || this.moH.get() == null) {
                        x.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    }
                    String[] stringArray = message.getData().getStringArray("permissions");
                    int i = message.getData().getInt("request_code");
                    if (stringArray == null || stringArray.length <= 1) {
                        x.e("MicroMsg.SoterAuthenticationUI", "hy: permission null");
                        return;
                    } else {
                        ((SoterAuthenticationUI) this.moH.get()).requestPermissions(stringArray, i);
                        return;
                    }
                case 4:
                    x.i("MicroMsg.SoterAuthenticationUI", "hy: show progress");
                    if (this.moH == null || this.moH.get() == null) {
                        x.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        SoterAuthenticationUI.a((SoterAuthenticationUI) this.moH.get());
                        return;
                    }
                case 5:
                    x.i("MicroMsg.SoterAuthenticationUI", "hy: dismiss progress");
                    if (this.moH == null || this.moH.get() == null) {
                        x.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        SoterAuthenticationUI.b((SoterAuthenticationUI) this.moH.get());
                        return;
                    }
                case 6:
                    x.i("MicroMsg.SoterAuthenticationUI", "hy: show dialog");
                    if (this.moH == null || this.moH.get() == null) {
                        x.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    }
                    ((SoterAuthenticationUI) this.moH.get()).addDialog((i) message.obj);
                    return;
                default:
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: unidentified msg: %d", Integer.valueOf(message.what));
                    return;
            }
        }
    }

    static /* synthetic */ void a(SoterAuthenticationUI soterAuthenticationUI) {
        if (soterAuthenticationUI.jqf == null || !soterAuthenticationUI.jqf.isShowing()) {
            soterAuthenticationUI.jqf = h.a((Context) soterAuthenticationUI, soterAuthenticationUI.getString(R.l.dHn), false, null);
        }
    }

    static /* synthetic */ void a(SoterAuthenticationUI soterAuthenticationUI, e eVar) {
        soterAuthenticationUI.setResult(-1, b(eVar));
        soterAuthenticationUI.c(eVar);
        soterAuthenticationUI.finish();
    }

    static /* synthetic */ void b(SoterAuthenticationUI soterAuthenticationUI) {
        if (soterAuthenticationUI.jqf != null && soterAuthenticationUI.jqf.isShowing()) {
            soterAuthenticationUI.jqf.dismiss();
        }
    }

    static /* synthetic */ void b(SoterAuthenticationUI soterAuthenticationUI, e eVar) {
        eVar.errCode = 90008;
        eVar.foE = "user cancelled the authentication process";
        soterAuthenticationUI.setResult(0, b(eVar));
        soterAuthenticationUI.c(eVar);
        soterAuthenticationUI.finish();
    }

    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        if (rZt != null) {
            a.a(rZt);
        }
        rZt = new a();
        d dVar = new d();
        e eVar = new e();
        String stringExtra = getIntent().getStringExtra("auth_mode");
        if (bi.oN(stringExtra)) {
            x.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode : null");
            eVar.errCode = 90003;
            eVar.foE = "authen mode is null";
        } else {
            try {
                dVar.rZp = Byte.parseByte(bi.aD(stringExtra.substring(2), "00"), 16);
                dVar.mFv = getIntent().getStringExtra("challenge");
                dVar.content = getIntent().getStringExtra("auth_content");
                if (!com.tencent.mm.plugin.soter.c.h.bDD()) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: not support soter");
                    eVar.errCode = 90001;
                    eVar.foE = "not support soter";
                } else if (dVar.rZp <= (byte) 0) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: param error: request mode illegal");
                    eVar.errCode = 90003;
                    eVar.foE = "resp model error";
                } else if (bi.oN(dVar.mFv)) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge null");
                    eVar.errCode = 90004;
                    eVar.foE = "challenge is null";
                } else if (dVar.mFv.length() >= WXMediaMessage.TITLE_LENGTH_LIMIT) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge too long");
                    eVar.errCode = 90004;
                    eVar.foE = "challenge is too long. 512 chars at most";
                } else if (bi.oN(dVar.content)) {
                    dVar.content = getString(R.l.eQo);
                } else if (dVar.content.length() > 42) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: param error: content too long. use default");
                    dVar.content = getString(R.l.eQo);
                }
            } catch (NumberFormatException e) {
                x.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", stringExtra);
                eVar.errCode = 90003;
                eVar.foE = "authen mode is illegal: number format error. found: " + stringExtra;
                if (eVar.errCode != 0) {
                    i = com.tencent.mm.plugin.soter_mp.a.a.rYX;
                    this.rZs = com.tencent.mm.plugin.soter_mp.a.a.a(this, dVar, eVar);
                    if (this.rZs == null) {
                        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
                        this.appId = getIntent().getStringExtra("key_app_id");
                        this.rZs.cS();
                    }
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
                    eVar.errCode = 90003;
                    eVar.foE = "no corresponding mode";
                    a(eVar);
                    return;
                }
                a(eVar);
                return;
            } catch (IndexOutOfBoundsException e2) {
                x.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", stringExtra);
                eVar.errCode = 90003;
                eVar.foE = "authen mode is illegal: number format error. found: " + stringExtra;
                if (eVar.errCode != 0) {
                    a(eVar);
                    return;
                }
                i = com.tencent.mm.plugin.soter_mp.a.a.rYX;
                this.rZs = com.tencent.mm.plugin.soter_mp.a.a.a(this, dVar, eVar);
                if (this.rZs == null) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
                    eVar.errCode = 90003;
                    eVar.foE = "no corresponding mode";
                    a(eVar);
                    return;
                }
                this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
                this.appId = getIntent().getStringExtra("key_app_id");
                this.rZs.cS();
            }
        }
        if (eVar.errCode != 0) {
            a(eVar);
            return;
        }
        i = com.tencent.mm.plugin.soter_mp.a.a.rYX;
        this.rZs = com.tencent.mm.plugin.soter_mp.a.a.a(this, dVar, eVar);
        if (this.rZs == null) {
            x.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
            eVar.errCode = 90003;
            eVar.foE = "no corresponding mode";
            a(eVar);
            return;
        }
        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
        this.appId = getIntent().getStringExtra("key_app_id");
        this.rZs.cS();
    }

    protected void onResume() {
        super.onResume();
        if (this.rZs != null) {
            this.rZs.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.rZs != null) {
            this.rZs.onPause();
        }
    }

    private void a(e eVar) {
        setResult(1, b(eVar));
        c(eVar);
        finish();
    }

    private static Intent b(e eVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("err_code", eVar.errCode);
        bundle.putString("err_msg", eVar.foE);
        bundle.putByte("use_mode", eVar.rZq);
        bundle.putString("result_json", eVar.fHh);
        bundle.putString("result_json_signature", eVar.rZr);
        x.d("MicroMsg.SoterAuthenticationUI", "hy: dump mp soter result: %s", bundle.toString());
        Intent intent = new Intent();
        intent.putExtras(bundle);
        return intent;
    }

    private void c(e eVar) {
        if (eVar != null && this.fromScene == 0) {
            int i = -1;
            switch (eVar.errCode) {
                case 0:
                    i = 0;
                    break;
                case 90001:
                case 90002:
                case 90003:
                case 90004:
                case 90006:
                case 90007:
                case 90011:
                    i = 2;
                    break;
                case 90008:
                case 90009:
                case 90010:
                    i = 3;
                    break;
            }
            g gVar = g.rYr;
            g.o("requireSoterBiometricAuthentication", this.appId, i, eVar.errCode);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.rZs != null) {
            this.rZs.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        a.a(rZt);
    }

    protected final int getLayoutId() {
        return -1;
    }
}

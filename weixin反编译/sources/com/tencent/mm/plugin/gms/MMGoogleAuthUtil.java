package com.tencent.mm.plugin.gms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.auth.b;
import com.google.android.gms.auth.c;
import com.google.android.gms.auth.d;
import com.google.android.gms.common.e;
import java.io.IOException;

public class MMGoogleAuthUtil extends Activity {
    private String hAU;
    private String jjB;
    private String nFd;
    public int nFe = 0;

    class a extends AsyncTask<Void, Void, Void> {
        private String jhM;
        private String jjB;
        private Context mContext;
        private int mErrorCode;
        private boolean nFf = false;
        private boolean nFg;
        private String nFh;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aST();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            if (!this.nFf) {
                Intent intent;
                if (this.nFg) {
                    intent = new Intent();
                    intent.putExtra("error_code", 0);
                    intent.putExtra("token", MMGoogleAuthUtil.this.hAU);
                    MMGoogleAuthUtil.this.setResult(-1, intent);
                    MMGoogleAuthUtil.this.finish();
                    return;
                }
                intent = new Intent();
                intent.putExtra("error_code", -1);
                intent.putExtra("error_msg", this.jhM);
                MMGoogleAuthUtil.this.setResult(-1, intent);
                MMGoogleAuthUtil.this.finish();
            }
        }

        public a(Context context, String str, String str2) {
            this.mContext = context;
            this.nFh = str;
            this.jjB = str2;
            this.nFf = false;
        }

        protected final void onPreExecute() {
            super.onPreExecute();
            this.nFg = false;
        }

        private Void aST() {
            try {
                MMGoogleAuthUtil.this.hAU = b.d(this.mContext, this.nFh, this.jjB);
                this.nFg = true;
                this.mErrorCode = 0;
            } catch (c e) {
                this.jhM = e.getMessage();
                this.mErrorCode = -2;
            } catch (d e2) {
                d dVar = e2;
                this.jhM = dVar.getMessage();
                this.mErrorCode = -3;
                if (MMGoogleAuthUtil.this.nFe < 4) {
                    MMGoogleAuthUtil mMGoogleAuthUtil = MMGoogleAuthUtil.this;
                    mMGoogleAuthUtil.nFe++;
                    this.nFf = true;
                    MMGoogleAuthUtil.this.startActivityForResult(dVar.Ks == null ? null : new Intent(dVar.Ks), 2002);
                }
            } catch (IOException e3) {
                this.jhM = e3.getMessage();
                this.mErrorCode = -4;
            } catch (com.google.android.gms.auth.a e4) {
                this.jhM = e4.getMessage();
                this.mErrorCode = -5;
            } catch (Exception e5) {
                this.jhM = e5.getMessage();
                this.mErrorCode = -1;
            }
            return null;
        }
    }

    protected void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        requestWindowFeature(1);
        Intent intent = getIntent();
        Intent intent2 = new Intent();
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                if (action.equals("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT")) {
                    String[] strArr = new String[]{"com.google"};
                    intent = new Intent();
                    intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
                    intent.setPackage("com.google.android.gms");
                    intent.putExtra("allowableAccounts", null);
                    intent.putExtra("allowableAccountTypes", strArr);
                    intent.putExtra("addAccountOptions", null);
                    intent.putExtra("selectedAccount", null);
                    intent.putExtra("alwaysPromptForAccount", false);
                    intent.putExtra("descriptionTextOverride", null);
                    intent.putExtra("authTokenType", null);
                    intent.putExtra("addAccountRequiredFeatures", null);
                    intent.putExtra("setGmsCoreAccount", false);
                    intent.putExtra("overrideTheme", 0);
                    intent.putExtra("overrideCustomTheme", 0);
                    startActivityForResult(intent, 2001);
                    return;
                } else if (action.equals("com.tencent.mm.gms.ACTION_GET_TOKEN")) {
                    this.nFd = intent.getStringExtra("gmail");
                    this.jjB = intent.getStringExtra("scope");
                    cZ(this.nFd, this.jjB);
                    return;
                } else if (action.equals("com.tencent.mm.gms.CHECK_GP_SERVICES")) {
                    int C = e.C(this);
                    new StringBuilder().append(C);
                    action = "gpservices";
                    if (C != 0) {
                        z = false;
                    }
                    intent2.putExtra(action, z);
                    setResult(-1, intent2);
                    finish();
                }
            }
        }
        intent2.putExtra("error_msg", "null intent or action.");
        setResult(-1, intent2);
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 2001:
                    String stringExtra = intent.getStringExtra("authAccount");
                    Intent intent2 = new Intent();
                    intent2.putExtra("error_code", 0);
                    intent2.putExtra("account", stringExtra);
                    setResult(-1, intent2);
                    finish();
                    return;
                case 2002:
                    cZ(this.nFd, this.jjB);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 2001:
            case 2002:
                Intent intent3 = new Intent();
                intent3.putExtra("error_code", -1);
                intent3.putExtra("error_msg", "User Cancel.");
                setResult(i2, intent3);
                finish();
                return;
            default:
                return;
        }
    }

    private void cZ(String str, String str2) {
        new a(this, str, str2).execute(new Void[0]);
    }
}

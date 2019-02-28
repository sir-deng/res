package com.tencent.mm.modelsimple;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Settings;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.regex.Pattern;

public final class d {

    public interface a {
        void l(Bundle bundle);
    }

    public static int a(Context context, a aVar) {
        if (context == null) {
            x.e("MicroMsg.MMAccountManager", "context is null");
            return 0;
        }
        String RH = RH();
        if (bi.oN(RH)) {
            x.e("MicroMsg.MMAccountManager", "account username is null or nil");
            as.Hm();
            RH = (String) c.Db().get(6, (Object) "");
            if (bi.oN(RH)) {
                return 0;
            }
        }
        if (D(context, RH)) {
            return 3;
        }
        if (!com.tencent.mm.pluginsdk.g.a.aZ(context, "android.permission.READ_CONTACTS")) {
            return 2;
        }
        try {
            AccountManager accountManager = AccountManager.get(context);
            Account account = new Account(RH, "com.tencent.mm.account");
            if (accountManager.addAccountExplicitly(account, "", null)) {
                ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                Bundle bundle = new Bundle();
                bundle.putString("authAccount", RH);
                bundle.putString("accountType", "com.tencent.mm.account");
                if (aVar != null) {
                    aVar.l(bundle);
                }
                return 1;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            x.e("MicroMsg.MMAccountManager", "exception in addAccountNoNeedBindMobile() " + e.getMessage());
        }
        if (aVar != null) {
            aVar.l(null);
        }
        return 2;
    }

    public static int a(Context context, String str, a aVar) {
        if (context == null) {
            x.e("MicroMsg.MMAccountManager", "activity is null");
            return 0;
        } else if (bi.oN(str)) {
            x.e("MicroMsg.MMAccountManager", "account username is null or nil");
            return 0;
        } else {
            String RH = RH();
            if (!bi.oN(RH)) {
                str = RH;
            }
            try {
                AccountManager accountManager = AccountManager.get(context);
                Account account = new Account(str, "com.tencent.mm.account");
                if (!com.tencent.mm.pluginsdk.g.a.aZ(context, "android.permission.READ_CONTACTS")) {
                    return 2;
                }
                if (D(context, str)) {
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                    return 3;
                }
                B(context, null);
                if (accountManager.addAccountExplicitly(account, "", null)) {
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                    Bundle bundle = new Bundle();
                    bundle.putString("authAccount", str);
                    bundle.putString("accountType", "com.tencent.mm.account");
                    if (aVar != null) {
                        aVar.l(bundle);
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("account_name", str);
                    contentValues.put("account_type", "com.tencent.mm.account");
                    contentValues.put("should_sync", Integer.valueOf(1));
                    contentValues.put("ungrouped_visible", Integer.valueOf(1));
                    context.getContentResolver().insert(Settings.CONTENT_URI, contentValues);
                    return 1;
                }
                if (aVar != null) {
                    aVar.l(null);
                }
                return 2;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
                x.e("MicroMsg.MMAccountManager", "exception in addAccount() " + e.getMessage());
            }
        }
    }

    public static void bq(Context context) {
        com.tencent.mm.bl.d.cdJ();
        if (f.feo == 0) {
            x.d("MicroMsg.MMAccountManager", "do not auto add account");
        } else if (f.feo == 1) {
            if (m.NT() == com.tencent.mm.modelfriend.m.a.SUCC) {
                x.d("MicroMsg.MMAccountManager", "auto add account result: " + a(context, m.NV(), null));
                return;
            }
            x.i("MicroMsg.MMAccountManager", "the user not bind mobile or not aggreed to upload addressbook");
        } else if (f.feo == 2) {
            x.d("MicroMsg.MMAccountManager", "auto add account result: " + a(context, null));
        }
    }

    public static boolean B(Context context, String str) {
        boolean oN = bi.oN(str);
        x.v("MicroMsg.MMAccountManager", "remove account : " + str);
        if (context == null) {
            x.e("MicroMsg.MMAccountManager", "null context");
            return false;
        }
        try {
            Account[] bw = bw(context);
            if (bw == null || bw.length == 0) {
                x.d("MicroMsg.MMAccountManager", "get account info is null or nil");
                return true;
            }
            AccountManager accountManager = AccountManager.get(context);
            for (Account account : bw) {
                if (oN) {
                    accountManager.removeAccount(account, null, null);
                } else if (account.name.equals(str)) {
                    accountManager.removeAccount(account, null, null);
                    x.i("MicroMsg.MMAccountManager", "remove account success: " + str);
                }
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            x.e("MicroMsg.MMAccountManager", "exception in removeAccount() " + e.getMessage());
            return false;
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
    public static boolean br(Context context) {
        boolean z = false;
        if (context != null) {
            Intent intent = new Intent("com.tencent.mm.login.ACTION_LOGOUT");
            intent.putExtra("accountName", RH());
            intent.putExtra("accountType", "com.tencent.mm.account");
            z = B(context, RH());
            if (z) {
                context.sendBroadcast(intent);
            }
        }
        return z;
    }

    private static String RH() {
        if (as.Hp()) {
            String str = "";
            as.Hm();
            String str2 = (String) c.Db().get(4, null);
            if (bi.oN(str2)) {
                str2 = q.FZ();
                if (bi.oN(str2)) {
                    str2 = q.FY();
                    if (bi.oN(str2) || com.tencent.mm.storage.x.Xi(str2)) {
                        str2 = str;
                    }
                }
            }
            return mz(str2);
        }
        x.e("MicroMsg.MMAccountManager", "getCurrentAccountName MMCore.acc Not Ready");
        return "";
    }

    public static void bs(Context context) {
        if (bt(context)) {
            e.b(new b(context, bv(context)), "MMAccountManager_updateAllContact").start();
            return;
        }
        B(context, null);
        x.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }

    public static void C(Context context, String str) {
        if (bt(context)) {
            e.b(new b(context, bv(context), str), "MMAccountManager_deleteSpecifiedContact").start();
            return;
        }
        B(context, null);
        x.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }

    public static boolean bt(Context context) {
        Account bv = bv(context);
        if (bv != null && bv.name.equals(RH())) {
            return true;
        }
        return false;
    }

    public static boolean bu(Context context) {
        if (!bt(context)) {
            x.e("MicroMsg.MMAccountManager", "no account added or not current account");
            return false;
        } else if (!com.tencent.mm.pluginsdk.g.a.aZ(context, "android.permission.READ_CONTACTS")) {
            return false;
        } else {
            Account bv = bv(context);
            if (bv != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("expedited", true);
                bundle.putBoolean("do_not_retry", true);
                ContentResolver.requestSync(bv, "com.android.contacts", bundle);
                return true;
            }
            x.e("MicroMsg.MMAccountManager", "no account added");
            return false;
        }
    }

    public static Account bv(Context context) {
        String RH = RH();
        if (bi.oN(RH)) {
            as.Hm();
            RH = (String) c.Db().get(6, (Object) "");
        }
        if (!bi.oN(RH)) {
            Account[] bw = bw(context);
            if (bw == null) {
                return null;
            }
            for (Account account : bw) {
                if (account.name.equals(RH)) {
                    return account;
                }
            }
        }
        return null;
    }

    private static Account[] bw(Context context) {
        try {
            return AccountManager.get(context).getAccountsByType("com.tencent.mm.account");
        } catch (Throwable e) {
            x.e("MicroMsg.MMAccountManager", "get all accounts failed");
            x.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            return null;
        }
    }

    private static boolean D(Context context, String str) {
        Account[] bw = bw(context);
        if (bw == null || bw.length == 0) {
            return false;
        }
        for (Account account : bw) {
            if (account.name.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static Account[] E(Context context, String str) {
        Account[] accountArr = null;
        try {
            return AccountManager.get(context).getAccountsByType(str);
        } catch (Throwable e) {
            x.e("MicroMsg.MMAccountManager", "get all accounts failed");
            x.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            return accountArr;
        }
    }

    public static String bx(Context context) {
        Account[] E = E(context, "com.google");
        String str = null;
        if (E != null && E.length > 0) {
            for (Account account : E) {
                str = account.name;
                if (!bi.oN(str) && bi.VZ(str)) {
                    break;
                }
            }
        }
        return str;
    }

    private static String mz(String str) {
        try {
            return Pattern.compile("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#¥￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(str).replaceAll("_").trim();
        } catch (Throwable e) {
            x.e("MicroMsg.MMAccountManager", "stringFilter failed, %s, %s", str, e.getMessage());
            x.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            return str;
        }
    }
}

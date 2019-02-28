package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class a {
    private static Intent vCp;
    private static WeakReference<Activity> vCq;
    private static final HashMap<String, String> vCr;

    public enum a {
        NOT_INSTALL,
        INSTALL_BUT_NEED_UPDATE,
        INSTALL_BUT_NOT_SUPPORT,
        INSTALL_AND_SUPPORT
    }

    public static boolean a(Activity activity, String str, String str2, int i) {
        x.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", str, Boolean.valueOf(r0.exists()), Long.valueOf(new File(str).length()));
        if (new File(str).exists()) {
            int i2;
            String To = To(str2);
            String Tn = Tn(To);
            if (!Tn.equals("")) {
                x.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", Tn);
                Intent fm = fm(To, str);
                fm.setPackage(Tn);
                if (bi.k(activity, fm)) {
                    x.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType");
                    activity.startActivity(fm);
                    return false;
                }
                x.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
                x.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
            }
            x.i("MicroMsg.AppChooserIntentUtil", "QQBrowser status is %s", x(activity, To, str).name());
            if (x(activity, To, str) == a.INSTALL_AND_SUPPORT) {
                Intent fo = fo(str, str2);
                if (bi.k(activity, fo)) {
                    fo.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    activity.startActivity(fo);
                    g.pWK.h(11168, Integer.valueOf(5), Integer.valueOf(i));
                    return false;
                }
                fo.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                Intent fn = fn(To, str);
                if (bi.k(activity, fn)) {
                    activity.startActivity(fn);
                    g.pWK.h(11168, Integer.valueOf(5), Integer.valueOf(i));
                    x.e("MicroMsg.AppChooserIntentUtil", "Occur error, has bugs, status is install and support but not found support activity");
                } else {
                    x.e("MicroMsg.AppChooserIntentUtil", "Occur error, has bugs, status is install and support but not found support activity");
                    return true;
                }
            }
            if (!bi.oN(str2)) {
                as.Hm();
                To = (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, (Object) "");
                if (!bi.oN(To) && To.contains(str2)) {
                    i2 = 1;
                    if (i2 != 0) {
                        return true;
                    }
                    b(activity, str, str2);
                    return false;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                return true;
            }
            b(activity, str, str2);
            return false;
        }
        x.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
        return true;
    }

    public static void b(Activity activity, String str, String str2, int i) {
        boolean z = true;
        x.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", str, Boolean.valueOf(r0.exists()), Long.valueOf(new File(str).length()));
        if (new File(str).exists()) {
            boolean z2;
            boolean z3;
            Parcelable fm;
            String To = To(str2);
            String Tn = Tn(To);
            if (!Tn.equals("")) {
                x.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", Tn);
                Intent fm2 = fm(To, str);
                fm2.setPackage(Tn);
                if (bi.k(activity, fm2)) {
                    x.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType");
                    activity.startActivity(fm2);
                    return;
                }
                x.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
            }
            x.i("MicroMsg.AppChooserIntentUtil", "QQBrowser status is %s", x(activity, To, str).name());
            Object fm3;
            switch (x(activity, To, str)) {
                case NOT_INSTALL:
                    z2 = false;
                    fm3 = fm(To, str);
                    z3 = true;
                    break;
                case INSTALL_BUT_NOT_SUPPORT:
                    z2 = false;
                    fm3 = fm(To, str);
                    z3 = false;
                    break;
                case INSTALL_BUT_NEED_UPDATE:
                    z2 = true;
                    fm3 = fm(To, str);
                    z3 = true;
                    break;
                case INSTALL_AND_SUPPORT:
                    Intent fo = fo(str, str2);
                    if (!bi.k(activity, fo)) {
                        z2 = false;
                        fm3 = fm(To, str);
                        z3 = true;
                        break;
                    }
                    activity.startActivity(fo);
                    return;
                default:
                    z2 = false;
                    fm3 = fm(To, str);
                    z3 = true;
                    break;
            }
            String To2 = To(str2);
            Uri fromFile = Uri.fromFile(new File(str));
            Bundle bundle = new Bundle();
            bundle.putString("targeturl", fromFile.toString());
            bundle.putString("filepath", str);
            bundle.putString("fileext", str2);
            bundle.putParcelable("targetintent", fm3);
            Intent intent = new Intent();
            intent.putExtra(Columns.TYPE, 0);
            intent.putExtra("title", activity.getResources().getString(R.l.dTI));
            intent.putExtra("needupate", z2);
            Tn = "not_show_recommend_app";
            if (z3) {
                z = false;
            }
            intent.putExtra(Tn, z);
            intent.putExtra("mimetype", To2);
            intent.putExtra("targetintent", fm3);
            intent.putExtra("transferback", bundle);
            intent.putExtra("scene", i);
            b(activity, str, str2);
            vCp = intent;
            vCq = new WeakReference(activity);
            return;
        }
        x.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
    }

    private static void b(Activity activity, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.setComponent(new ComponentName(h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
        activity.sendBroadcast(intent);
    }

    public static void ae(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
        intent.getStringExtra("file_path");
        Object stringExtra = intent.getStringExtra("file_ext");
        x.i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", Boolean.valueOf(booleanExtra));
        if (!as.Hf() && as.Hp()) {
            as.Hm();
            Object obj = (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, (Object) "");
            if (!booleanExtra) {
                obj = obj.replace(stringExtra, "");
            } else if (!obj.contains(stringExtra)) {
                obj = obj.concat(stringExtra);
            }
            as.Hm();
            c.Db().a(com.tencent.mm.storage.w.a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, obj);
            if (!(booleanExtra || vCp == null || vCq == null || vCq.get() == null)) {
                vCp.setClass((Context) vCq.get(), AppChooserUI.class);
                ((Activity) vCq.get()).startActivityForResult(vCp, 2);
            }
            vCp = null;
        }
    }

    public static void a(Activity activity, int i, int i2, Intent intent, boolean z, int i3, int i4, int i5) {
        if (i != 2) {
            return;
        }
        if (-1 == i2 && intent != null) {
            String stringExtra = intent.getStringExtra("selectpkg");
            Bundle bundleExtra = intent.getBundleExtra("transferback");
            Intent intent2 = (Intent) bundleExtra.getParcelable("targetintent");
            String string = bundleExtra.getString("filepath");
            String string2 = bundleExtra.getString("fileext");
            if (intent2 != null) {
                Intent fo;
                x.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI select package name %s and target intent is not null", stringExtra);
                if ("com.tencent.mtt".equals(stringExtra) && string != null) {
                    fo = fo(string, string2);
                    fo.addFlags(SQLiteGlobal.journalSizeLimit);
                    fo.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
                    fo.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 4);
                    if (bi.k(activity, fo)) {
                        x.i("MicroMsg.AppChooserIntentUtil", "user has installed new version of QQbrowser");
                        activity.startActivity(fo);
                        g.pWK.h(11168, Integer.valueOf(5), Integer.valueOf(i5));
                        return;
                    }
                }
                fo = new Intent(intent2);
                fo.setPackage(stringExtra);
                fo.addFlags(SQLiteGlobal.journalSizeLimit);
                if (bi.k(activity, fo)) {
                    activity.startActivity(fo);
                    return;
                }
                x.e("MicroMsg.AppChooserIntentUtil", "Always Intent is not support mimetype");
                if (z) {
                    com.tencent.mm.ui.base.h.h(activity, i3, i4);
                    return;
                }
                return;
            }
            x.e("MicroMsg.AppChooserIntentUtil", "AppChooserUI target intent is null in handlerResultOfAppChooserUI");
            if (z) {
                com.tencent.mm.ui.base.h.h(activity, i3, i4);
            }
        } else if (4098 == i2) {
            x.e("MicroMsg.AppChooserIntentUtil", "Not Found App Support media type");
            if (z) {
                com.tencent.mm.ui.base.h.h(activity, i3, i4);
            }
        } else if (4097 == i2) {
            x.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is no choice");
            if (z) {
                com.tencent.mm.ui.base.h.h(activity, i3, i4);
            }
        } else {
            x.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is not ok or data is null");
        }
    }

    private static Intent fm(String str, String str2) {
        Uri fromFile = Uri.fromFile(new File(str2));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(fromFile, str);
        return intent;
    }

    private static Intent fn(String str, String str2) {
        Intent intent = new Intent();
        intent.setPackage("com.tencent.mtt");
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str2)), str);
        return intent;
    }

    private static Intent fo(String str, String str2) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
        File file = new File(str);
        intent.setPackage("com.tencent.mtt");
        intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
        intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 4);
        intent.putExtra("key_reader_sdk_id", 1);
        intent.putExtra("key_reader_sdk_type", 0);
        intent.putExtra("key_reader_sdk_format", str2);
        intent.putExtra("key_reader_sdk_path", str);
        intent.setData(Uri.fromFile(file));
        return intent;
    }

    private static String Tn(String str) {
        int i = 274528;
        as.Hm();
        t Db = c.Db();
        if (str != null) {
            i = 274528 + str.hashCode();
        }
        return (String) Db.get(i, (Object) "");
    }

    private static a x(Context context, String str, String str2) {
        if (!r.ee(context)) {
            return a.NOT_INSTALL;
        }
        if (bi.k(context, fn(str, str2))) {
            return a.INSTALL_AND_SUPPORT;
        }
        if (r.Sc(str)) {
            return a.INSTALL_BUT_NEED_UPDATE;
        }
        return a.INSTALL_BUT_NOT_SUPPORT;
    }

    private static String To(String str) {
        String str2 = null;
        if (str != null && str.length() > 0) {
            str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        if (str2 == null || str2.length() == 0) {
            str2 = (String) vCr.get(str);
        }
        if (str2 != null && str2.length() != 0) {
            return str2;
        }
        x.w("MicroMsg.AppChooserIntentUtil", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
        return "*/" + str;
    }

    static {
        HashMap hashMap = new HashMap();
        vCr = hashMap;
        hashMap.put("wps", "application/wps");
        vCr.put("ett", "application/ett");
        vCr.put("log", "application/log");
        vCr.put("wpt", "application/wpt");
        vCr.put("et", "application/et");
        vCr.put("ksdps", "application/ksdps");
        vCr.put("kset", "application/kset");
        vCr.put("kswps", "application/kswps");
    }
}

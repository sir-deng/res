package com.tencent.mm.plugin.webview.stub;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static final boolean dP(Context context) {
        try {
            PackageInfo packageInfo = s.getPackageInfo(context, "com.tencent.mobileqq");
            String str = "MicroMsg.ConstantsWebViewStub";
            String str2 = "isQQSupportShare(%s).";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(packageInfo != null);
            x.d(str, str2, objArr);
            if (packageInfo != null) {
                return true;
            }
        } catch (Exception e) {
            x.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQQSupportShare(), e : %s.", e.getMessage());
        }
        return false;
    }

    public static final boolean aM(Context context, String str) {
        if (bi.oN(str)) {
            return false;
        }
        try {
            PackageInfo packageInfo = s.getPackageInfo(context, "com.tencent.weread");
            String str2 = "MicroMsg.ConstantsWebViewStub";
            String str3 = "isWeReadSupportShare(%s).";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(packageInfo != null);
            x.d(str2, str3, objArr);
            if (packageInfo == null || !Uri.parse(str).getHost().startsWith("mp.weixin.qq.com") || packageInfo.versionCode <= 2000812) {
                return false;
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQzoneSupportShare(), e : %s.", e.getMessage());
            return false;
        }
    }
}

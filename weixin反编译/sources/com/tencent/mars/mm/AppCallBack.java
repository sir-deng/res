package com.tencent.mars.mm;

import android.content.Context;
import com.tencent.mars.app.AppLogic.AccountInfo;
import com.tencent.mars.app.AppLogic.DeviceInfo;
import com.tencent.mars.app.AppLogic.ICallBack;
import com.tencent.mm.network.aa;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class AppCallBack implements ICallBack {
    private static final String TAG = "AppCallBack";
    private Context context = null;
    DeviceInfo info = new DeviceInfo(d.vHj, d.DEVICE_TYPE);

    private static String exception2String(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public AppCallBack(Context context) {
        this.context = context;
    }

    public String getAppFilePath() {
        if (this.context == null) {
            Assert.assertTrue(false);
            return null;
        }
        try {
            File filesDir = this.context.getFilesDir();
            if (!filesDir.exists()) {
                filesDir.createNewFile();
            }
            return filesDir.toString();
        } catch (Exception e) {
            x.e(TAG, exception2String(e));
            Assert.assertTrue(e.getClass().getSimpleName() + ":" + e.getStackTrace()[0] + ", " + e.getStackTrace()[1], false);
            return null;
        }
    }

    public AccountInfo getAccountInfo() {
        AccountInfo accountInfo = new AccountInfo();
        if (!(aa.VX() == null || aa.VX().iby == null)) {
            try {
                accountInfo.uin = (long) aa.VX().iby.Cn();
                accountInfo.userName = aa.VX().iby.KY();
                if (bi.oN(accountInfo.userName)) {
                    accountInfo.userName = aa.VX().iby.getUsername();
                }
            } catch (Exception e) {
            }
        }
        return accountInfo;
    }

    public int getClientVersion() {
        return d.vHl;
    }

    public DeviceInfo getDeviceType() {
        return this.info;
    }

    public String getCurLanguage() {
        return w.cfV();
    }
}

package com.tencent.recovery;

import android.content.Context;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.option.IOptionsCreator;
import com.tencent.recovery.option.ProcessOptions;
import com.tencent.recovery.util.Util;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.FileUtil;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.File;

public class DefaultOptionsCreator implements IOptionsCreator {
    private String clientVersion;

    public ProcessOptions createProcessOptions(String str, int i) {
        return null;
    }

    public CommonOptions createCommonOptions(Context context) {
        Builder builder = new Builder();
        builder.AaP = WXRecoveryHandleService.class.getName();
        builder.AaQ = WXRecoveryUploadService.class.getName();
        builder.clientVersion = getClientVersion();
        builder.AaL = String.format("http://dldir1.qq.com/weixin/android/recovery-%s.conf", new Object[]{getClientVersion()});
        builder.njL = WXUtil.gq(context);
        builder.AaR = true;
        builder.AaS = 600000;
        builder.AaT = 600000;
        return builder.cEf();
    }

    private String getClientVersion() {
        if (Util.oN(this.clientVersion)) {
            File file = new File(WXConstantsRecovery.Abb, "version.info");
            if (file.exists()) {
                this.clientVersion = FileUtil.M(file);
            }
        }
        if (Util.oN(this.clientVersion)) {
            this.clientVersion = "0x26060532";
        }
        return this.clientVersion;
    }

    public String toString() {
        return String.format("Creator: [ClientVersion=%s]", new Object[]{getClientVersion()});
    }
}

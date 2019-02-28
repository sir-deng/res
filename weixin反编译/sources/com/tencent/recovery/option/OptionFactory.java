package com.tencent.recovery.option;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.recovery.ConstantsRecovery.DefaultProcessOptions;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.util.Util;

public class OptionFactory {
    private static IOptionsCreator AaU;

    public static ProcessOptions dI(String str, int i) {
        ProcessOptions processOptions = null;
        if (AaU != null) {
            processOptions = AaU.createProcessOptions(str, i);
        }
        if (processOptions != null) {
            return processOptions;
        }
        RecoveryLog.i("Recovery.OptionFactory", "not found custom process options, use default %d", Integer.valueOf(i));
        if (i == 1) {
            return DefaultProcessOptions.Aao;
        }
        return DefaultProcessOptions.Aam;
    }

    public static CommonOptions gk(Context context) {
        CommonOptions commonOptions = null;
        if (AaU != null) {
            commonOptions = AaU.createCommonOptions(context);
        }
        if (commonOptions != null) {
            return commonOptions;
        }
        RecoveryLog.i("Recovery.OptionFactory", "not found custom custom options, use default", new Object[0]);
        Builder builder = new Builder();
        builder.AaL = "";
        builder.AaR = false;
        builder.njL = String.valueOf(Util.gm(context));
        try {
            builder.clientVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
        }
        builder.AaS = 600000;
        builder.AaT = 600000;
        return builder.cEf();
    }
}

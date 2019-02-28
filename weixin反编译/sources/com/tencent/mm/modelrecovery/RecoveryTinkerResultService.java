package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.a;
import java.util.ArrayList;

public class RecoveryTinkerResultService extends AbstractResultService {
    public void onCreate() {
        super.onCreate();
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "onCreate", new Object[0]);
    }

    public void onDestroy() {
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "onDestroy", new Object[0]);
        super.onDestroy();
    }

    public final void a(a aVar) {
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "RecoveryTinkerResultService receive result: %s", aVar);
        CommonOptions gk = OptionFactory.gk(this);
        ArrayList arrayList = new ArrayList();
        RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
        recoveryHandleItem.njL = gk.njL;
        recoveryHandleItem.clientVersion = gk.clientVersion;
        recoveryHandleItem.timestamp = System.currentTimeMillis();
        recoveryHandleItem.aAM = "KeyPatchResultTotalCount";
        if (aVar.ftC) {
            RecoveryLog.i("Recovery.RecoveryTinkerResultService", "patch success", new Object[0]);
            recoveryHandleItem.aAM = "KeyPatchResultSuccessCount";
        } else {
            RecoveryLog.i("Recovery.RecoveryTinkerResultService", "patch fail ", new Object[0]);
            if (aVar.AaG != null) {
                RecoveryLog.i("Recovery.RecoveryTinkerResultService", "fail reason %s", aVar.AaG.getMessage());
                recoveryHandleItem.aAM = String.format("%s[%s]", new Object[]{"KeyPatchResultFailCount", aVar.AaG.getMessage()});
            } else {
                recoveryHandleItem.aAM = "KeyPatchResultFailCount";
            }
        }
        arrayList.add(recoveryHandleItem);
        RecoveryLogic.a((Context) this, arrayList, WXRecoveryUploadService.class.getName());
        stopSelf();
    }
}

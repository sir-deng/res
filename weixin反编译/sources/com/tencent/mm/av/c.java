package com.tencent.mm.av;

import com.tencent.mm.plugin.x.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay;

public final class c {
    public static boolean a(ay ayVar) {
        if (ayVar == null) {
            x.e("MicroMsg.NewTipsManager", "check time, tipsInfo is null!!!");
            return false;
        }
        boolean z;
        long Wx = bi.Wx();
        if (ayVar.field_overdueTime == 0 && ayVar.field_disappearTime == 0) {
            z = true;
        } else {
            z = Wx >= ayVar.field_beginShowTime && Wx <= Long.valueOf(Math.min(ayVar.field_beginShowTime + ayVar.field_overdueTime, ayVar.field_disappearTime)).longValue();
        }
        x.i("MicroMsg.NewTipsManager", "timeEffective current: %s, overdueTime: %s, disappearTime: %s, show:%s", Long.valueOf(Wx), Long.valueOf(ayVar.field_overdueTime), Long.valueOf(ayVar.field_disappearTime), Boolean.valueOf(z));
        return z;
    }

    protected static boolean b(ay ayVar) {
        if (ayVar == null) {
            x.e("MicroMsg.NewTipsManager", "can not show new  tips！！ tipsInfo is null !!");
            return false;
        } else if (ayVar.field_isExit && !ayVar.field_hadRead && a(ayVar)) {
            return true;
        } else {
            x.i("MicroMsg.NewTipsManager", "can not show tips, isExit:%s, hadRead:%s, timeEffective:%s", Boolean.valueOf(ayVar.field_isExit), Boolean.valueOf(ayVar.field_hadRead), Boolean.valueOf(a(ayVar)));
            return false;
        }
    }

    public final boolean ij(int i) {
        ay DK = a.bfT().DK(i);
        if (DK == null) {
            x.e("MicroMsg.NewTipsManager", "showDot, newTipsInfo is null !!");
            return false;
        } else if (b(a.bfT().DK(i)) && DK.field_tipsShowInfo != null && DK.field_tipsShowInfo.showType == b.hJZ) {
            return true;
        } else {
            return false;
        }
    }
}

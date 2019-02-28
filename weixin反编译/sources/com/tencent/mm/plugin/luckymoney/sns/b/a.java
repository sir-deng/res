package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.mm.kernel.g;

public final class a {
    public static int aXY() {
        g.Dr();
        return ((Integer) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_NEWYEAR_2016_HONGBAO_IS_OPEN_SNS_PAY_INT_SYNC, Integer.valueOf(0))).intValue();
    }

    public static void su(int i) {
        g.Dr();
        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_NEWYEAR_2016_HONGBAO_IS_OPEN_SNS_PAY_INT_SYNC, Integer.valueOf(i));
        g.Dr();
        g.Dq().Db().lO(true);
    }

    public static String aXZ() {
        g.Dr();
        return (String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_TITLE_STRING_SYNC, (Object) "");
    }

    public static String aYa() {
        g.Dr();
        return (String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_WORDING_STRING_SYNC, (Object) "");
    }
}

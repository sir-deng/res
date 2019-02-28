package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.utils.TbsLog;

public final class m {
    public static volatile int Agq = -1;
    private static m Agr = null;
    a Agn = null;
    boolean Ago = false;
    private final int Agp = 3;

    public class a {
        int[] Ags;
        int Agt;
        int Agu;

        public final String toString() {
            if ((this.Agu == this.Agt ? 1 : null) != null) {
                return "";
            }
            int i;
            StringBuilder stringBuilder = new StringBuilder("[");
            for (i = this.Agt; i < this.Agu; i++) {
                stringBuilder.append(String.valueOf(this.Ags[i]) + ",");
            }
            i = stringBuilder.length();
            return stringBuilder.delete(i - 1, i).append("]").toString();
        }
    }

    private m() {
    }

    public static m cEY() {
        if (Agr == null) {
            Agr = new m();
        }
        return Agr;
    }

    final synchronized void a(Context context, int i, Throwable th) {
        if (Agq == -1) {
            Agq = i;
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, "code=%d,desc=%s", Integer.valueOf(i), String.valueOf(th));
            if (th != null) {
                v hp = v.hp(context);
                String str = "NULL";
                if (th != null) {
                    str = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
                    if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                        str = str.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    }
                }
                hp.bj(i, str);
            } else {
                TbsLog.e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + i + "; Check & correct it!");
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder("setLoadErrorCode :: error(");
            stringBuilder.append(Agq);
            stringBuilder.append(") was already reported; ");
            stringBuilder.append(i);
            stringBuilder.append(" is duplicated. Try to remove it!");
            TbsLog.w("TbsCoreLoadStat", stringBuilder.toString());
        }
    }

    final void ao(Context context, int i) {
        a(context, i, null);
        TbsLog.e("loaderror", String.valueOf(i));
    }
}

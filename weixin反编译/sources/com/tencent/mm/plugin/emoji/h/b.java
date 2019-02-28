package com.tencent.mm.plugin.emoji.h;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.u;

public final class b {
    private final String TAG = "MicroMsg.emoji.UseSmileyTool";
    public int jQy;
    public String lOs;

    public b(int i) {
        this.jQy = i;
    }

    public static void a(Intent intent, String str, Activity activity) {
        if (intent != null) {
            a(intent.getStringExtra("Select_Conv_User"), str, activity);
        }
    }

    public static void a(String str, String str2, Activity activity) {
        if (bi.oN(str)) {
            x.d("MicroMsg.emoji.UseSmileyTool", "talker name is invalid so can't go to chat room use.");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("smiley_product_id", str2);
        com.tencent.mm.plugin.emoji.b.ihN.e(intent, (Context) activity);
    }

    public final void n(Activity activity) {
        x.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
        Intent intent = new Intent();
        intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
        intent.putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
        d.a((Context) activity, ".ui.transmit.SelectConversationUI", intent, this.jQy);
        activity.overridePendingTransition(R.a.bqo, R.a.bqa);
    }
}

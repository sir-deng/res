package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class ad implements a {
    ad() {
    }

    public final void b(a aVar, int i, ChattingUI.a aVar2, au auVar) {
        b bVar = (b) aVar;
        bVar.yUZ.setText(auVar.field_content);
        Object bundle = new Bundle();
        bundle.putString("chatroom_name", aVar2.csn());
        bundle.putLong("msg_id", auVar.field_msgId);
        if ((auVar.field_flag & 8) != 0) {
            i.a(bVar.yUZ, 1, false, bundle);
            bVar.yUZ.setClickable(true);
        } else {
            i.a(bVar.yUZ, bundle);
        }
        bVar.yUZ.invalidate();
    }
}

package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class n {
    private x fBc;
    a yAD;
    q yAE;
    ChatFooter yAF;
    ChatFooterCustom yAG;
    private boolean yAH = false;
    long[] yAI = null;
    boolean yxU;

    public n(a aVar, q qVar, ChatFooter chatFooter, ChatFooterCustom chatFooterCustom, x xVar, boolean z, long[] jArr) {
        this.yAD = aVar;
        this.yAF = chatFooter;
        this.yAG = chatFooterCustom;
        this.yAE = qVar;
        this.fBc = xVar;
        this.yxU = z;
        this.yAI = jArr;
        this.yAD.removeAllOptionMenu();
        this.yAD.addTextOptionMenu$7df2a0ca(2, this.yAD.getString(R.l.dMv), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                Set<Long> set = n.this.yAE.yBX;
                if (set != null) {
                    List<Long> arrayList = new ArrayList();
                    for (Long l : set) {
                        if (l != null) {
                            arrayList.add(l);
                        }
                    }
                    long[] jArr = new long[arrayList.size()];
                    int i = 0;
                    for (Long l2 : arrayList) {
                        int i2 = i + 1;
                        jArr[i] = l2.longValue();
                        i = i2;
                    }
                    intent.putExtra("k_outside_expose_proof_item_list", jArr);
                    n.this.yAD.thisActivity().setResult(-1, intent);
                } else {
                    n.this.yAD.thisActivity().setResult(0, intent);
                }
                intent.putExtra("k_is_group_chat", n.this.yxU);
                n.this.yAD.finish();
                return false;
            }
        }, null, b.xSe);
        this.yAE.yCi = new OnClickListener() {
            public final void onClick(View view) {
                n.this.yAE.fX(((Long) view.getTag()).longValue());
            }
        };
    }
}

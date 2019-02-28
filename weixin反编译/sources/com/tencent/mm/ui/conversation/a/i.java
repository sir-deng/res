package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.bu.a;
import com.tencent.mm.f.a.cl;
import com.tencent.mm.j.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends b {
    int fXe;
    private c xNQ;
    View zjR;

    public i(final Context context) {
        super(context);
        this.zjR = View.inflate(context, R.i.dlR, null);
        if (this.zjR != null) {
            this.fXe = t.getInt(g.Af().getValue("InviteFriendsControlFlags"), 0);
            this.zjR.setVisibility(8);
            this.zjR.setPadding(0, -a.fromDPToPix(context, R.f.bvJ), 0, 0);
            if ((this.fXe & 1) > 0) {
                this.zjR.setVisibility(0);
                this.zjR.setPadding(0, 0, 0, 0);
            }
            this.zjR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("Invite_friends", 1);
                    d.b(context, "subapp", ".ui.pluginapp.InviteFriendsBy3rdUI", intent);
                    com.tencent.mm.plugin.report.service.g.pWK.h(14034, Integer.valueOf(1));
                }
            });
            this.xNQ = new c<cl>() {
                {
                    this.xmG = cl.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    x.i("MicroMsg.InviteFriendBanner", "dynamic config file change");
                    i.this.fXe = t.getInt(g.Af().getValue("InviteFriendsControlFlags"), 0);
                    if ((i.this.fXe & 1) > 0) {
                        i.this.zjR.post(new Runnable() {
                            public final void run() {
                                i.this.zjR.setVisibility(0);
                                i.this.zjR.setPadding(0, 0, 0, 0);
                            }
                        });
                    }
                    return true;
                }
            };
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean alN() {
        com.tencent.mm.sdk.b.a.xmy.b(this.xNQ);
        return this.zjR != null && this.zjR.getVisibility() == 0;
    }

    public final void release() {
        com.tencent.mm.sdk.b.a.xmy.c(this.xNQ);
    }

    public final void destroy() {
    }

    public final View getView() {
        return this.zjR;
    }
}

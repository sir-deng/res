package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.chatroom.d.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

@a(3)
@Deprecated
public class RoomAlphaProcessUI extends MMActivity implements a {
    private String chatroomName;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
        k oVar = new o(this.chatroomName);
        as.CN().a(482, new com.tencent.mm.plugin.chatroom.ui.a.AnonymousClass2(false, h.a((Context) this, getString(R.l.ctG), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        }), this, this));
        as.CN().a(oVar, 0);
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
    }

    public final int getLayoutId() {
        return -1;
    }

    private static void u(Runnable runnable) {
        new ag().postDelayed(runnable, 200);
    }

    public final void i(final boolean z, final int i) {
        if (z) {
            h.bu(this, getString(R.l.eGK));
            u(new Runnable() {
                public final void run() {
                    Intent intent = new Intent(RoomAlphaProcessUI.this, RoomUpgradeUI.class);
                    intent.setFlags(603979776);
                    intent.putExtra("room_name", RoomAlphaProcessUI.this.chatroomName);
                    intent.putExtra("upgrade_success", z);
                    intent.putExtra("left_quota", i);
                    RoomAlphaProcessUI.this.startActivity(intent);
                }
            });
            return;
        }
        h.a((Context) this, getString(R.l.eGJ), "", null);
        u(new Runnable() {
            public final void run() {
                Intent intent = new Intent(RoomAlphaProcessUI.this, RoomUpgradeUI.class);
                intent.setFlags(603979776);
                intent.putExtra("room_name", RoomAlphaProcessUI.this.chatroomName);
                intent.putExtra("upgrade_success", z);
                RoomAlphaProcessUI.this.startActivity(intent);
            }
        });
    }
}

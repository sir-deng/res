package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameTabBridgeUI extends GameCenterActivity {
    private BroadcastReceiver nCs = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && "com.tencent.mm.ACTION_EXIT".equals(intent.getAction()) && GameTabBridgeUI.this != null && !GameTabBridgeUI.this.isFinishing()) {
                x.i("MicroMsg.GameTabBridgeUI", "GameTabBridgeUI exit!");
                GameTabBridgeUI.this.finish();
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameTabBridgeUI", "%s create", getClass().getSimpleName());
        GameTabWidget.nCy = hashCode();
        initView();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.nCs, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
        final Intent intent = getIntent();
        GameTabData gameTabData = (GameTabData) intent.getParcelableExtra("tab_data");
        String stringExtra = intent.getStringExtra("tab_key");
        GameTabWidget gameTabWidget = (GameTabWidget) findViewById(R.h.cQi);
        a aVar = new a(this);
        gameTabWidget.a(aVar);
        aVar.a(gameTabData, stringExtra);
        intent.setComponent((ComponentName) intent.getParcelableExtra("next_tab_component"));
        final long currentTimeMillis = System.currentTimeMillis();
        f.a("com.tencent.mm:tools", null, GameTabWidget.a.class, new c() {
            public final void i(Bundle bundle) {
                ah.y(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.GameTabBridgeUI", "load tools process, web page load time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        if (GameTabWidget.nCy == GameTabBridgeUI.this.hashCode()) {
                            GameTabWidget.a(GameTabBridgeUI.this, intent, false, true, true, false);
                            return;
                        }
                        x.i("MicroMsg.GameTabBridgeUI", "GameTabWidget.mHashCode(%d) != hashCode(%d), dont need turn page!", Integer.valueOf(GameTabWidget.nCy), Integer.valueOf(GameTabBridgeUI.this.hashCode()));
                    }
                });
            }
        });
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameTabBridgeUI.this.goBack();
                return true;
            }
        });
        setMMTitle(R.l.enu);
    }

    protected void onResume() {
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().mEnable = false;
        }
    }

    protected final boolean aRX() {
        return false;
    }

    public final int aRY() {
        return 0;
    }

    public final int aRZ() {
        return 0;
    }

    public final int aSa() {
        return 0;
    }

    protected final int getLayoutId() {
        return R.i.djB;
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.nCs);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        x.i("MicroMsg.GameTabBridgeUI", "GameTabHomeUI goBack!");
        if (bi.oM(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            d.a((Context) this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(R.a.bqz, R.a.bqC);
            x.i("MicroMsg.GameTabBridgeUI", "back to FindMoreFriendsUI");
        }
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), WXApp.WXAPP_BROADCAST_PERMISSION);
    }
}

package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterUI5;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class GameTabHomeUI extends GameCenterUI5 {
    private BroadcastReceiver nCs = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && "com.tencent.mm.ACTION_EXIT".equals(intent.getAction()) && GameTabHomeUI.this != null && !GameTabHomeUI.this.isFinishing()) {
                x.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI exit!");
                GameTabHomeUI.this.finish();
            }
        }
    };
    public String nCv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameTabHomeUI", "%s create", getClass().getSimpleName());
        GameTabData gameTabData = (GameTabData) getIntent().getParcelableExtra("tab_data");
        this.nCv = getIntent().getStringExtra("tab_key");
        GameTabWidget gameTabWidget = (GameTabWidget) findViewById(R.h.cQi);
        a aVar = new a(this);
        gameTabWidget.a(aVar);
        aVar.a(gameTabData, this.nCv);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.nCs, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameTabHomeUI.this.goBack();
                return true;
            }
        });
    }

    protected void onResume() {
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().mEnable = false;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            setIntent(intent);
            if (!bi.oM(this.nCv).equals(intent.getStringExtra("tab_key"))) {
                x.i("MicroMsg.GameTabHomeUI", "reload %s. current_key:%s, next_key:%s", getClass().getSimpleName(), this.nCv, intent.getStringExtra("tab_key"));
                finish();
                startActivity(intent);
            }
            overridePendingTransition(R.a.bqe, R.a.bqe);
        }
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
        x.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI goBack!");
        if (bi.oM(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            d.a((Context) this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(R.a.bqz, R.a.bqC);
            x.i("MicroMsg.GameTabHomeUI", "back to FindMoreFriendsUI");
        }
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), WXApp.WXAPP_BROADCAST_PERMISSION);
    }
}

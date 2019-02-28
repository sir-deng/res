package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class GameTabWebUI extends GameWebViewUI {
    private Activity activity;
    private BroadcastReceiver nCs = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && "com.tencent.mm.ACTION_EXIT".equals(intent.getAction()) && GameTabWebUI.this.activity != null && !GameTabWebUI.this.activity.isFinishing()) {
                x.i("MicroMsg.GameTabWebUI", "%s exit!", GameTabWebUI.this.activity.getClass().getSimpleName());
                GameTabWebUI.this.activity.finish();
            }
        }
    };
    private String nCv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameTabWebUI", "%s create", getClass().getSimpleName());
        this.activity = this;
        GameTabData gameTabData = (GameTabData) getIntent().getParcelableExtra("tab_data");
        this.nCv = getIntent().getStringExtra("tab_key");
        View gameTabWidget = new GameTabWidget(this);
        a aVar = new a(this);
        gameTabWidget.a(aVar);
        aVar.a(gameTabData, this.nCv);
        ((LinearLayout) findViewById(R.h.cYX)).addView(gameTabWidget);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.nCs, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameTabWebUI.this.goBack();
                return true;
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            setIntent(intent);
            if (!bi.oM(this.nCv).equals(intent.getStringExtra("tab_key"))) {
                x.i("MicroMsg.GameTabWebUI", "reload %s", this.activity.getClass().getSimpleName());
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

    public void onBackPressed() {
        super.onBackPressed();
        goBack();
    }

    private void goBack() {
        x.i("MicroMsg.GameTabWebUI", "%s goBack!", this.activity.getClass().getSimpleName());
        if (bi.oM(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            d.a((Context) this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(R.a.bqz, R.a.bqC);
            x.i("MicroMsg.GameTabWebUI", "back to FindMoreFriendsUI.");
        }
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), WXApp.WXAPP_BROADCAST_PERMISSION);
    }
}

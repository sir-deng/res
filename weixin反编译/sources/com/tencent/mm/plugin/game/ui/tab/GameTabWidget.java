package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class GameTabWidget extends LinearLayout {
    public static int nCy = 0;
    private Activity mActivity;
    private a nCz;

    public static class a implements com.tencent.mm.ipcinvoker.a {
        public final void a(Bundle bundle, c cVar) {
            if (cVar != null) {
                cVar.i(bundle);
            }
        }
    }

    static /* synthetic */ void a(GameTabWidget gameTabWidget) {
        int count = gameTabWidget.nCz.getCount();
        if (count != 0) {
            LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.bu.a.eB(gameTabWidget.mActivity) / count, -1);
            for (int i = 0; i < count; i++) {
                View view = gameTabWidget.nCz.getView(i, null, gameTabWidget);
                if (view != null) {
                    view.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            try {
                                GameTabWidget.a(GameTabWidget.this.mActivity, (TabItem) view.getTag(), false, false, false);
                            } catch (Exception e) {
                                x.e("MicroMsg.GameTabWidget", "selectTab err:%s", e.getMessage());
                            }
                        }
                    });
                    view.setLayoutParams(layoutParams);
                    gameTabWidget.addView(view);
                }
            }
        }
    }

    public GameTabWidget(Context context) {
        super(context);
        ce(context);
    }

    public GameTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ce(context);
    }

    public GameTabWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ce(context);
    }

    private void ce(Context context) {
        this.mActivity = (Activity) context;
        setLayoutParams(new LayoutParams(-1, -2));
        setBackgroundResource(R.e.bsx);
        setOrientation(0);
    }

    public final void a(a aVar) {
        this.nCz = aVar;
        aVar.registerDataSetObserver(new DataSetObserver() {
            public final void onInvalidated() {
                GameTabWidget.a(GameTabWidget.this);
            }

            public final void onChanged() {
                GameTabWidget.a(GameTabWidget.this);
            }
        });
        aVar.notifyDataSetChanged();
    }

    public static void a(Activity activity, TabItem tabItem, boolean z, boolean z2, boolean z3) {
        if (activity != null && tabItem != null && !com.tencent.mm.plugin.game.d.c.ad(activity, tabItem.jumpUrl)) {
            String stringExtra = activity.getIntent().getStringExtra("tab_key");
            if (!bi.oM(tabItem.njQ).equals(stringExtra)) {
                boolean z4;
                boolean z5;
                x.i("MicroMsg.GameTabWidget", "current_page:%s, next_page:%s, hasAnimation:%b", activity.getClass().getSimpleName(), tabItem.njX, Boolean.valueOf(z));
                Intent intent = new Intent();
                intent.setClassName(activity, tabItem.njX);
                Bundle extras = activity.getIntent().getExtras();
                if (extras != null) {
                    intent.putExtras(extras);
                } else {
                    extras = new Bundle();
                }
                Bundle bundle = new Bundle();
                bundle.putString("tab_key", tabItem.njQ);
                GameTabData gameTabData = (GameTabData) extras.getParcelable("tab_data");
                if (gameTabData != null) {
                    TabItem tabItem2 = (TabItem) gameTabData.njN.get(bi.oM(stringExtra));
                    if (tabItem2 != null) {
                        tabItem2.njY = true;
                    }
                    tabItem2 = (TabItem) gameTabData.njN.get(tabItem.njQ);
                    if (tabItem2 != null) {
                        z4 = tabItem2.njY;
                    } else {
                        z4 = false;
                    }
                    bundle.putParcelable("tab_data", gameTabData);
                    z5 = z4;
                } else {
                    z5 = false;
                }
                if (!z3) {
                    ap.a(activity, tabItem.fGe, tabItem.njZ, activity.getIntent().getIntExtra("game_report_from_scene", 0), ap.CD(tabItem.ngQ));
                }
                if (!tabItem.njS) {
                    bundle.putString("rawUrl", tabItem.jumpUrl);
                    bundle.putBoolean("KRightBtn", true);
                    bundle.putBoolean("isWebwx", true);
                    bundle.putBoolean("show_bottom", false);
                    bundle.putString("title", activity.getString(R.l.enu));
                    bundle.putBoolean("forceHideShare", true);
                    bundle.putBoolean("disable_swipe_back", true);
                    bundle.putBoolean("show_native_web_view", true);
                    bundle.putBoolean("disable_progress_bar", true);
                    bundle.putBoolean("disable_bounce_scroll", true);
                    bundle.putInt("screen_orientation", 1);
                    bundle.putString("KPublisherId", "game_center_entrance");
                    bundle.putInt("geta8key_scene", 32);
                    if (!(gameTabData == null || gameTabData.njO == null)) {
                        bundle.putString("status_bar_style", gameTabData.njO.njP);
                        bundle.putInt("customize_status_bar_color", gameTabData.njO.color);
                    }
                    bundle.putBoolean("game_check_float", z3);
                    String string = bundle.getString("rawUrl");
                    if (!bi.oN(string)) {
                        if (z3) {
                            z4 = intent.getBooleanExtra("from_find_more_friend", false);
                            int intExtra = intent.getIntExtra("game_report_from_scene", 0);
                            if (z4) {
                                SubCoreGameCenter.aRL();
                                t aQW = w.aQW();
                                bundle.putString("rawUrl", p.a(string, aQW));
                                if (aQW != null) {
                                    aQW.aQT();
                                    if (aQW.nij.niF) {
                                        bundle.putString("game_transparent_float_url", aQW.nij.url);
                                    }
                                    bundle.putInt("game_sourceScene", intExtra);
                                }
                            }
                        } else {
                            bundle.remove("game_transparent_float_url");
                            bundle.remove("game_sourceScene");
                        }
                    }
                }
                intent.putExtras(bundle);
                a(activity, intent, z, z2, z5, tabItem.njS);
            }
        }
    }

    public static void a(Activity activity, Intent intent, boolean z, boolean z2, boolean z3, boolean z4) {
        String str = "MicroMsg.GameTabWidget";
        String str2 = "(%s isActivityExist):%b, hasAnimation:%b, forceFinish:%b, isNative:%b";
        Object[] objArr = new Object[5];
        objArr[0] = intent.getComponent() == null ? "" : intent.getComponent().getClassName();
        objArr[1] = Boolean.valueOf(z3);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Boolean.valueOf(z2);
        objArr[4] = Boolean.valueOf(z4);
        x.i(str, str2, objArr);
        str = "MicroMsg.GameTabWidget";
        String str3 = (z3 || z4) ? "straight to jump" : "jump to bridge";
        x.i(str, str3);
        if (!z3 && z4) {
            f.a("com.tencent.mm:tools", null, a.class, null);
        }
        if (z3 || z4) {
            nCy = 0;
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            activity.startActivity(intent);
        } else {
            Intent intent2 = new Intent(activity, GameTabBridgeUI.class);
            intent2.putExtras(intent.getExtras());
            intent2.putExtra("next_tab_component", intent.getComponent());
            activity.startActivity(intent2);
        }
        if (!(!z2 || activity.isDestroyed() || activity.isFinishing())) {
            activity.finish();
        }
        if (z) {
            activity.overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.xSL, com.tencent.mm.ui.MMFragmentActivity.a.xSM);
        } else {
            activity.overridePendingTransition(R.a.bqe, R.a.bqe);
        }
    }
}

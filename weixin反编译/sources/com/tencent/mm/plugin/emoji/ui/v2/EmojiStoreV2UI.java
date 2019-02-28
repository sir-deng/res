package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.p;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.HashMap;

public class EmojiStoreV2UI extends MMActivity {
    private int lNI = 0;
    private HashMap<Integer, a> lNR = new HashMap();
    EmojiStoreV2TabView lNS;
    private EmojiStoreV2ViewPager lNT;
    private a lNU;
    private boolean lNV = true;
    private boolean lNW = false;

    class a extends p implements e, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.a {
        private boolean lNV = false;
        private WxViewPager lNY;

        public final /* synthetic */ Fragment R(int i) {
            return pq(i);
        }

        public a(FragmentActivity fragmentActivity, WxViewPager wxViewPager, boolean z) {
            super(fragmentActivity.getSupportFragmentManager());
            this.lNV = z;
            this.lNY = wxViewPager;
            this.lNY.a((u) this);
            this.lNY.b((e) this);
            this.lNY.ah(EmojiStoreV2UI.this.lNI);
            d.fO(11);
            if (EmojiStoreV2UI.this.lNS != null) {
                EmojiStoreV2UI.this.lNS.lNO = this;
            }
        }

        public final a pq(int i) {
            return EmojiStoreV2UI.this.pp(i);
        }

        public final int getCount() {
            if (this.lNV) {
                return 2;
            }
            return 1;
        }

        public final void a(int i, float f, int i2) {
            if (EmojiStoreV2UI.this.lNS != null) {
                EmojiStoreV2UI.this.lNS.h(i, f);
            }
        }

        public final void ae(int i) {
            x.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageSelected :%d", Integer.valueOf(i));
            EmojiStoreV2UI.this.lNI = i;
            if (EmojiStoreV2UI.this.lNS != null) {
                EmojiStoreV2UI.this.lNS.pn(i);
            }
            if (EmojiStoreV2UI.this.lNI == 1 && !EmojiStoreV2UI.this.lNW) {
                g.pWK.h(12090, new Object[0]);
                EmojiStoreV2UI emojiStoreV2UI = EmojiStoreV2UI.this;
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_STORE_NEW_ORIGINAL_BOOLEAN, Boolean.valueOf(false));
                if (emojiStoreV2UI.lNS != null) {
                    emojiStoreV2UI.lNS.eJ(false);
                }
                EmojiStoreV2UI.this.lNW = true;
            }
        }

        public final void af(int i) {
            x.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageScrollStateChanged state:%d", Integer.valueOf(i));
            if (i == 0 && EmojiStoreV2UI.this.pp(EmojiStoreV2UI.this.lNI) != null) {
                a pp = EmojiStoreV2UI.this.pp(EmojiStoreV2UI.this.lNI);
                if (pp.Fv != null && pp.lDw != null && pp.aDX()) {
                    pp.lDw.amN();
                }
            }
        }

        public final void po(int i) {
            if (i != EmojiStoreV2UI.this.lNI) {
                this.lNY.d(i, false);
            }
            EmojiStoreV2UI.this.lNI = i;
        }
    }

    static /* synthetic */ void a(EmojiStoreV2UI emojiStoreV2UI) {
        Intent QT = b.QT();
        b.p(QT);
        QT.putExtra("ftsneedkeyboard", true);
        QT.putExtra("key_load_js_without_delay", true);
        com.tencent.mm.bl.d.b(emojiStoreV2UI.mController.xRr, "webview", ".ui.tools.fts.FTSSOSMoreWebViewUI", QT);
        int i = emojiStoreV2UI.lNI == 0 ? 0 : 1;
        g.pWK.h(13054, Integer.valueOf(i), Integer.valueOf(0), "");
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        String value = com.tencent.mm.j.g.Af().getValue("ShowPersonalEmotion");
        x.i("MicroMsg.emoji.EmojiStoreV2UI", "get dynamic config value:%s", value);
        if (bi.oN(value) || bi.Wo(value) != 1) {
            this.lNV = false;
        } else {
            this.lNV = true;
        }
        if (this.lNV) {
            this.lNI = getIntent().getIntExtra("emoji_tab", 0);
        }
        initView();
        as.Dt().F(new Runnable() {
            public final void run() {
                com.tencent.mm.r.c.Bx().o(262147, false);
                com.tencent.mm.r.c.Bx().o(262149, false);
                com.tencent.mm.r.c.Bx().aS(262147, 266244);
                com.tencent.mm.r.c.Bx().aS(262149, 266244);
                as.Hm();
                c.Db().set(208899, Boolean.valueOf(false));
                as.Hm();
                c.Db().set(208913, Boolean.valueOf(false));
            }
        });
        as.Hm();
        boolean booleanValue = ((Boolean) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_EMOJI_STORE_NEW_ORIGINAL_BOOLEAN, Boolean.valueOf(false))).booleanValue();
        if (this.lNS != null) {
            this.lNS.eJ(booleanValue);
        }
        g.pWK.a(406, 0, 1, false);
        g.pWK.a(406, 2, System.currentTimeMillis() - currentTimeMillis, false);
    }

    protected void onResume() {
        super.onResume();
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            public final boolean queueIdle() {
                x.i("MicroMsg.emoji.EmojiStoreV2UI", "now try to activity the tools process");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                EmojiStoreV2UI.this.sendBroadcast(intent);
                return false;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dgm;
    }

    protected final void initView() {
        addIconOptionMenu(0, R.k.dvm, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                EmojiStoreV2UI.a(EmojiStoreV2UI.this);
                return false;
            }
        });
        addIconOptionMenu(1, R.k.dvn, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("10931", 1);
                intent.setClass(EmojiStoreV2UI.this, EmojiMineUI.class);
                EmojiStoreV2UI.this.startActivity(intent);
                return false;
            }
        });
        this.lNS = (EmojiStoreV2TabView) findViewById(R.h.cdY);
        this.lNT = (EmojiStoreV2ViewPager) findViewById(R.h.cdX);
        this.lNT.xw(0);
        this.lNU = new a(this, this.lNT, this.lNV);
        if (this.lNV) {
            this.lNS.setVisibility(0);
        } else {
            this.lNS.setVisibility(8);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lNR != null) {
            this.lNR.clear();
        }
    }

    public final a pp(int i) {
        a aVar = null;
        if (i < 0) {
            return null;
        }
        if (this.lNR.containsKey(Integer.valueOf(i))) {
            return (a) this.lNR.get(Integer.valueOf(i));
        }
        switch (i) {
            case 0:
                aVar = (a) Fragment.instantiate(this, b.class.getName(), null);
                break;
            case 1:
                aVar = (a) Fragment.instantiate(this, c.class.getName(), null);
                break;
            default:
                x.w("MicroMsg.emoji.EmojiStoreV2UI", "create fragment failed.");
                break;
        }
        x.d("MicroMsg.emoji.EmojiStoreV2UI", "create fragment index:%d", Integer.valueOf(i));
        if (aVar != null) {
            aVar.setParent(this);
        }
        this.lNR.put(Integer.valueOf(i), aVar);
        return aVar;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.emoji.EmojiStoreV2UI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (this.lNU != null && this.lNU.pq(this.lNI) != null) {
            this.lNU.pq(this.lNI).onActivityResult(i, i2, intent);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}

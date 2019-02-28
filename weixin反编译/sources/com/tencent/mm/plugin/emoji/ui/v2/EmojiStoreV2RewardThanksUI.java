package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.protocal.c.ack;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class EmojiStoreV2RewardThanksUI extends MMActivity {
    private String lEi;
    private ack lIy;
    private EmojiStoreV2RewardBannerView lMe;
    private View lMf;
    private MMCopiableTextView lMg;
    private TextView lMh;
    private TextView lMi;
    private AnimationDrawable lMj;
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    String str = (String) message.obj;
                    if (bi.oN(str) || !e.bO(str)) {
                        x.i("MicroMsg.emoji.EmojiStoreV2RewardThanksUI", "path is null or file no exists");
                        return;
                    }
                    EmojiStoreV2RewardThanksUI.this.lMe.cY(str, null);
                    EmojiStoreV2RewardThanksUI.this.lMe.setScaleType(ScaleType.FIT_XY);
                    if (EmojiStoreV2RewardThanksUI.this.lMj != null && EmojiStoreV2RewardThanksUI.this.lMj.isRunning()) {
                        EmojiStoreV2RewardThanksUI.this.lMj.stop();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    protected final int getLayoutId() {
        return R.i.dgf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lEi = getIntent().getStringExtra("extra_id");
        initView();
        this.lIy = i.aCl().lCB.YI(this.lEi);
        if (this.lIy == null) {
            this.lMe.setBackgroundDrawable(getResources().getDrawable(R.g.bBX));
            this.lMe.setImageDrawable(this.lMj);
            this.lMe.setScaleType(ScaleType.CENTER);
            this.lMj.start();
        } else if (this.lIy.wsa == null || bi.oN(this.lIy.wsa.whW)) {
            this.lMe.setBackgroundDrawable(getResources().getDrawable(R.g.bBX));
            this.lMe.setImageDrawable(this.lMj);
            this.lMe.setScaleType(ScaleType.CENTER);
            this.lMj.start();
        } else {
            final String str = this.lIy.wsa.whX;
            as.Hm();
            final String H = EmojiLogic.H(c.Fw(), this.lEi, str);
            if (e.bO(H)) {
                this.lMe.cY(H, null);
                this.lMe.setScaleType(ScaleType.FIT_XY);
                if (this.lMj != null && this.lMj.isRunning()) {
                    this.lMj.stop();
                }
            } else {
                o.PG().a(str, this.lMe, f.g(this.lEi, str, new Object[0]), new com.tencent.mm.ap.a.c.i() {
                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        if (!bi.oN(str) && str.equalsIgnoreCase(str)) {
                            Message message = new Message();
                            message.what = 1001;
                            message.obj = H;
                            EmojiStoreV2RewardThanksUI.this.mHandler.sendMessage(message);
                        }
                    }
                });
                this.lMe.setBackgroundDrawable(getResources().getDrawable(R.g.bBX));
                this.lMe.setImageDrawable(this.lMj);
                this.lMe.setScaleType(ScaleType.CENTER);
                this.lMj.start();
            }
        }
        if (this.lIy == null || this.lIy.wsa == null) {
            this.lMf.setVisibility(8);
            return;
        }
        this.lMf.setVisibility(0);
        bi.oN(this.lIy.wsa.whZ);
        this.lMg.setVisibility(0);
        this.lMg.setText(R.l.ebd);
        this.lMh.setVisibility(8);
        this.lMi.setVisibility(8);
    }

    protected void onDestroy() {
        if (this.lMj != null && this.lMj.isRunning()) {
            this.lMj.stop();
        }
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.ebc);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                EmojiStoreV2RewardThanksUI.this.finish();
                return false;
            }
        });
        this.lMe = (EmojiStoreV2RewardBannerView) findViewById(R.h.cQR);
        this.lMe.gr = 1.0f;
        this.lMf = findViewById(R.h.cuG);
        this.lMg = (MMCopiableTextView) findViewById(R.h.cuI);
        this.lMh = (TextView) findViewById(R.h.cuF);
        this.lMi = (TextView) findViewById(R.h.cuH);
        this.lMj = (AnimationDrawable) getResources().getDrawable(R.g.bBO);
    }

    protected final int getForceOrientation() {
        return 1;
    }
}

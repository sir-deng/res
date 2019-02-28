package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aci;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiMineUI extends BaseEmojiStoreUI implements OnClickListener {
    private final String TAG = "MicroMsg.emoji.EmojiMineUI";
    private View lHq;
    private TextView lHr;
    private ViewGroup lIb;
    private ViewGroup lIc;
    private ViewGroup lId;
    private ViewGroup lIe;
    private TextView lIf;

    protected final int getLayoutId() {
        return R.i.dfS;
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        g.pWK.k(10931, String.valueOf(getIntent().getIntExtra("10931", 0)));
        x.i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", Integer.valueOf(r0));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                EmojiMineUI.this.finish();
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.l.eas), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ArrayList clf = i.aCl().lCx.clf();
                List arrayList = new ArrayList();
                Iterator it = clf.iterator();
                while (it.hasNext()) {
                    EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) it.next();
                    if (emojiGroupInfo.field_type != EmojiGroupInfo.TYPE_CUSTOM) {
                        arrayList.add(emojiGroupInfo);
                    }
                }
                if (arrayList.size() <= 1) {
                    h.h(EmojiMineUI.this.mController.xRr, R.l.dZN, R.l.dGZ);
                } else if (ao.isConnected(ad.getContext())) {
                    Intent intent = new Intent();
                    intent.setClass(EmojiMineUI.this, EmojiSortUI.class);
                    EmojiMineUI.this.startActivity(intent);
                } else {
                    h.a((Context) EmojiMineUI.this, EmojiMineUI.this.getString(R.l.eav), "", EmojiMineUI.this.getString(R.l.eau), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                return true;
            }
        });
        as.Hm();
        if (!((Boolean) c.Db().get(a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_FINISH_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
            com.tencent.mm.plugin.emoji.c.a.ew(true);
        }
        g.pWK.a(406, 3, 1, false);
        g.pWK.a(406, 5, System.currentTimeMillis() - currentTimeMillis, false);
    }

    protected final void initView() {
        setMMTitle(R.l.eLB);
        super.initView();
        this.lHq = findViewById(R.h.cQg);
        this.lHr = (TextView) this.lHq.findViewById(R.h.cQf);
        this.lHr.setText(R.l.ebE);
        if (i.aCi().lFb.lFr) {
            i.aCi();
            if (BKGLoaderManager.aCJ()) {
                this.lHq.setVisibility(0);
                ct(8001, 3000);
                this.Fv.setOnScrollListener(null);
            }
        }
        this.lHq.setVisibility(8);
        this.Fv.setOnScrollListener(null);
    }

    public void onClick(View view) {
        Intent intent;
        if (view == this.lIc) {
            intent = new Intent();
            intent.setClass(this, EmojiCustomUI.class);
            startActivity(intent);
        } else if (view == this.lId) {
            intent = new Intent();
            intent.setClass(this, EmojiPaidUI.class);
            startActivity(intent);
        }
    }

    protected final boolean aCU() {
        return false;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.a aCQ() {
        return new com.tencent.mm.plugin.emoji.a.c(this.mController.xRr);
    }

    protected final int aCX() {
        return 8;
    }

    protected final int aCZ() {
        return 2;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i - 1, j);
    }

    public final void a(String str, l lVar) {
        if (str != null && str.equals("event_update_group")) {
            aDp();
            ct(131074, 50);
        }
    }

    public final void h(String str, int i, int i2, String str2) {
    }

    protected final boolean aDg() {
        return false;
    }

    protected final void aCR() {
        this.lIe = (ViewGroup) View.inflate(this.mController.xRr, R.i.dfM, null);
        this.lIf = (TextView) this.lIe.findViewById(16908310);
        this.lIf.setText(R.l.eLC);
        this.lIe.setVisibility(8);
        this.lIf.setVisibility(8);
        this.Fv.addHeaderView(this.lIe, null, false);
        this.lIb = (ViewGroup) View.inflate(this.mController.xRr, R.i.dfL, null);
        this.lIc = (ViewGroup) this.lIb.findViewById(R.h.cwc);
        ((TextView) this.lIc.findViewById(16908310)).setText(R.l.dfH);
        this.lId = (ViewGroup) this.lIb.findViewById(R.h.cwd);
        ((TextView) this.lId.findViewById(16908310)).setText(R.l.eak);
        this.lId.findViewById(R.h.content).setBackgroundResource(R.g.bBz);
        this.lIc.setOnClickListener(this);
        this.lId.setOnClickListener(this);
        this.Fv.addFooterView(this.lIb, null, false);
    }

    protected final boolean aDf() {
        return true;
    }

    protected final boolean aDc() {
        boolean z = true;
        if (this.lDw != null) {
            this.lDw.notifyDataSetChanged();
            this.lGB = true;
            this.klX.setVisibility(8);
        } else {
            z = false;
        }
        aDh();
        return z;
    }

    protected final void c(aci aci) {
        super.c(aci);
    }

    protected final void a(boolean z, f fVar, boolean z2, boolean z3) {
    }

    protected final boolean aCT() {
        return false;
    }

    public final void l(Message message) {
        if (message.what == 8001 && this.lHq != null) {
            this.lHq.setVisibility(8);
        }
        super.l(message);
    }

    public final void aDh() {
        if (this.lIe == null) {
            return;
        }
        if (this.lDw == null || this.lDw.isEmpty()) {
            this.lIe.setVisibility(8);
            this.lIf.setVisibility(8);
            return;
        }
        this.lIe.setVisibility(0);
        this.lIf.setVisibility(0);
    }

    protected final int aCO() {
        return 24;
    }

    protected final int aCP() {
        return 7;
    }
}

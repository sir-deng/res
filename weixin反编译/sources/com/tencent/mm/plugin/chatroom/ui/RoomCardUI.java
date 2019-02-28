package com.tencent.mm.plugin.chatroom.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ll;
import com.tencent.mm.plugin.chatroom.d.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.as;
import com.tencent.smtt.utils.TbsLog;

public class RoomCardUI extends MMActivity implements e {
    private r jqf;
    private c lfQ = new c<ll>() {
        {
            this.xmG = ll.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ll llVar = (ll) bVar;
            String str = llVar.fDF.fDG;
            String str2 = llVar.fDF.fDH;
            int i = llVar.fDF.ret;
            if (i != 0 && str2 != null) {
                h.b(RoomCardUI.this, str2, str, true);
                if (RoomCardUI.this.lgV != null) {
                    as.Hm();
                    com.tencent.mm.y.c.Fe().c(RoomCardUI.this.lgV);
                }
            } else if (i == 0) {
                if (RoomCardUI.this.lhv) {
                    RoomCardUI.a(RoomCardUI.this, RoomCardUI.this.lhn.getText().toString());
                } else {
                    RoomCardUI.this.ayw();
                }
            }
            if (!(RoomCardUI.this.lhv || RoomCardUI.this.jqf == null || !RoomCardUI.this.jqf.isShowing())) {
                RoomCardUI.this.jqf.dismiss();
            }
            return false;
        }
    };
    private String lgQ;
    private com.tencent.mm.plugin.messenger.foundation.a.a.e.b lgV;
    private String lhf;
    private int lhg;
    private String lhh;
    private boolean lhi;
    private String lhj;
    private String lhk;
    private long lhl;
    private TextView lhm;
    private MMEditText lhn;
    private TextView lho;
    private TextView lhp;
    private ImageView lhq;
    private LinearLayout lhr;
    private LinearLayout lhs;
    private LinearLayout lht;
    private LinearLayout lhu;
    private boolean lhv = false;

    private class a implements TextWatcher {
        private boolean lhA;
        private int lhy;
        private String lhz;

        private a() {
            this.lhy = 280;
            this.lhz = "";
            this.lhA = false;
        }

        /* synthetic */ a(RoomCardUI roomCardUI, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            RoomCardUI.this.ayv();
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI) {
        if (roomCardUI.ayu()) {
            String str = roomCardUI.lhn.getText().toString();
            String zP = com.tencent.mm.j.b.zP();
            if (bi.oN(zP) || !str.matches(".*[" + zP + "].*")) {
                int i;
                int i2;
                roomCardUI.showVKB();
                if (bi.oN(roomCardUI.lhn.getText().toString())) {
                    i = R.l.eQD;
                    i2 = R.l.eQC;
                } else {
                    i = R.l.eyE;
                    i2 = R.l.eyG;
                }
                h.a((Context) roomCardUI, i, 0, i2, R.l.eyF, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RoomCardUI roomCardUI = RoomCardUI.this;
                        Context context = RoomCardUI.this.mController.xRr;
                        RoomCardUI.this.getString(R.l.dGZ);
                        roomCardUI.jqf = h.a(context, RoomCardUI.this.getString(R.l.eGn), false, null);
                        if (RoomCardUI.this.ayu()) {
                            RoomCardUI.this.lhv = false;
                            RoomCardUI.a(RoomCardUI.this, RoomCardUI.this.lhn.getText().toString());
                        }
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RoomCardUI.this.ayv();
                    }
                });
                return;
            }
            h.b(roomCardUI.mController.xRr, roomCardUI.getString(R.l.epR, new Object[]{zP}), roomCardUI.getString(R.l.dGZ), true);
            return;
        }
        roomCardUI.ayw();
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI, final TextView textView) {
        l lVar = new l(roomCardUI);
        lVar.rQF = new p.c() {
            public final void a(n nVar) {
                nVar.add(R.l.dED);
            }
        };
        lVar.rQG = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                if (i == 0) {
                    ((ClipboardManager) textView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, textView.getText().toString()));
                }
            }
        };
        lVar.bCH();
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI, String str) {
        if (roomCardUI.ayu()) {
            as.CN().a(new m(roomCardUI.lgQ, str), 0);
        }
    }

    protected final int getLayoutId() {
        return R.i.dqZ;
    }

    protected final void initView() {
        setMMTitle(R.l.eGb);
        a(0, getString(R.l.dEQ), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getTitle().equals(RoomCardUI.this.getString(R.l.dFw))) {
                    RoomCardUI.a(RoomCardUI.this);
                }
                RoomCardUI.this.lhn.setEnabled(true);
                RoomCardUI.this.lhn.setFocusableInTouchMode(true);
                RoomCardUI.this.lhn.setFocusable(true);
                RoomCardUI.this.lhn.setCursorVisible(true);
                RoomCardUI.this.updateOptionMenuText(0, RoomCardUI.this.getString(R.l.dFw));
                RoomCardUI.this.enableOptionMenu(false);
                RoomCardUI.this.showVKB();
                RoomCardUI.this.lhn.setSelection(RoomCardUI.this.lhn.getText().toString().length());
                return true;
            }
        }, com.tencent.mm.ui.p.b.xSe);
        enableOptionMenu(true);
        this.lht = (LinearLayout) findViewById(R.h.cov);
        this.lhu = (LinearLayout) findViewById(R.h.cIt);
        this.lhn = (MMEditText) findViewById(R.h.cBq);
        this.lho = (TextView) findViewById(R.h.cBt);
        this.lhp = (TextView) findViewById(R.h.cBs);
        this.lhr = (LinearLayout) findViewById(R.h.cIw);
        this.lhq = (ImageView) findViewById(R.h.cBr);
        this.lhs = (LinearLayout) findViewById(R.h.cIy);
        this.lhn.setText(this.lhj);
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.lhn.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) - 100);
        i.b(this.lhn, Integer.valueOf(31));
        this.lhm = (TextView) findViewById(R.h.csR);
        this.lhm.setText(Integer.toString(com.tencent.mm.ui.tools.h.be(280, this.lhj)));
        this.lhs.setVisibility(8);
        this.lhn.setCursorVisible(false);
        this.lhn.setFocusable(false);
        if (this.lhi) {
            this.lhu.setVisibility(8);
        } else {
            removeOptionMenu(0);
            this.lhu.setVisibility(0);
            this.lhn.setFocusable(false);
            this.lhn.setCursorVisible(false);
            this.lhn.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    RoomCardUI.a(RoomCardUI.this, RoomCardUI.this.lhn);
                    return true;
                }
            });
        }
        if (this.lhl != 0) {
            this.lho.setVisibility(0);
            this.lho.setText(com.tencent.mm.pluginsdk.h.n.ak("yyyy-MM-dd HH:mm", this.lhl));
        } else {
            this.lho.setVisibility(8);
        }
        if (bi.oN(this.lhj)) {
            this.lhn.setEnabled(true);
            this.lhn.setFocusableInTouchMode(true);
            this.lhn.setFocusable(true);
            this.lht.setVisibility(8);
            this.lhn.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) + 100);
            this.lhn.requestFocus();
            this.lhn.setCursorVisible(true);
            updateOptionMenuText(0, this.mController.xRr.getString(R.l.dFw));
            ayv();
            this.lhn.performClick();
            showVKB();
        } else {
            this.lht.setVisibility(0);
        }
        this.lhp.setText(i.b(this, com.tencent.mm.y.r.gw(this.lhk), this.lhp.getTextSize()));
        ImageView imageView = this.lhq;
        String str = this.lhk;
        if (bi.oN(str)) {
            imageView.setImageResource(R.g.bBC);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        }
        this.lhn.addTextChangedListener(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.pWK.a(219, 0, 1, true);
        as.CN().a((int) TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, (e) this);
        this.lgQ = getIntent().getStringExtra("RoomInfo_Id");
        this.lhj = getIntent().getStringExtra("room_notice");
        this.lhk = getIntent().getStringExtra("room_notice_editor");
        this.lhl = getIntent().getLongExtra("room_notice_publish_time", 0);
        this.lhf = getIntent().getStringExtra("room_name");
        this.lhg = getIntent().getIntExtra("room_member_count", 0);
        this.lhh = getIntent().getStringExtra("room_owner_name");
        this.lhi = getIntent().getBooleanExtra("Is_RoomOwner", false);
        initView();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RoomCardUI.this.goBack();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b((int) TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, (e) this);
        if (this.jqf != null && this.jqf.isShowing()) {
            this.jqf.dismiss();
        }
    }

    private void goBack() {
        if (!this.lhi) {
            setResult(0);
            finish();
        } else if (ayu()) {
            h.a((Context) this, getString(R.l.eFa), null, getString(R.l.eFc), getString(R.l.eFb), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    RoomCardUI.this.setResult(0);
                    RoomCardUI.this.finish();
                }
            });
        } else {
            setResult(0);
            finish();
        }
    }

    private boolean ayu() {
        String obj = this.lhn.getText().toString();
        if (bi.oN(obj)) {
            if (bi.oN(this.lhj)) {
                return false;
            }
            return true;
        } else if (this.lhj == null || !this.lhj.equals(obj)) {
            return true;
        } else {
            return false;
        }
    }

    private void ayv() {
        if (ayu()) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        super.onKeyDown(i, keyEvent);
        if (keyEvent.getKeyCode() != 4) {
            return false;
        }
        goBack();
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1) {
            this.lhi = false;
            if (!this.lhi) {
                this.lhs.setVisibility(8);
                this.lhn.setFocusableInTouchMode(false);
                this.lhn.setFocusable(false);
                this.lhs.setVisibility(8);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.jqf != null && this.jqf.isShowing()) {
            this.jqf.dismiss();
        }
        if (kVar.getType() == TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE) {
            if (this.jqf != null && this.jqf.isShowing()) {
                this.jqf.dismiss();
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
                this.lhj = this.lhn.getText().toString();
                g.pWK.a(219, 15, 1, true);
                ayw();
                return;
            }
            x.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", str);
            u.makeText(this, R.l.eGk, 1).show();
            x.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            return;
        }
        x.w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", Integer.valueOf(kVar.getType()));
    }

    private void ayw() {
        Intent intent = new Intent();
        intent.putExtra("room_name", this.lhf);
        intent.putExtra("room_notice", this.lhj);
        setResult(-1, intent);
        finish();
    }
}

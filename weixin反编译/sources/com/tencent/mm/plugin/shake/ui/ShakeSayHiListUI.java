package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.be.j;
import com.tencent.mm.be.k;
import com.tencent.mm.be.l;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.k.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public class ShakeSayHiListUI extends MMActivity {
    private int asN = 0;
    private ListView inF;
    private d kHD = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            l.TG().nc(String.valueOf(ShakeSayHiListUI.this.ksO));
            ShakeSayHiListUI.this.qyu.a(null, null);
        }
    };
    private long ksO;
    private int oUN = 0;
    private int oUO = 0;
    private k qwl = null;
    private int qyt = 0;
    private b qyu;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qyt = getIntent().getIntExtra("IntentSayHiType", 1);
        if (this.qyt == 1) {
            this.qwl = l.TG();
            setMMTitle(R.l.eHy);
        } else {
            setMMTitle(R.l.eHx);
        }
        this.oUO = this.qwl.Tx();
        this.asN = this.oUO == 0 ? 8 : this.oUO;
        this.oUN = this.qwl.getCount();
        k kVar = this.qwl;
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(4));
        if (kVar.gLA.update(kVar.getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            kVar.doNotify();
        }
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.oUN != this.qwl.getCount()) {
            this.oUN = this.qwl.getCount();
            if (this.oUN == 0) {
                TextView textView = (TextView) findViewById(R.h.ceo);
                textView.setText(R.l.eHz);
                textView.setVisibility(0);
                enableOptionMenu(false);
            }
            this.qyu.XH();
        }
        this.qyu.notifyDataSetChanged();
    }

    public void onDestroy() {
        this.qyu.aUU();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        if (this.qyu.kHr != null) {
            this.qyu.kHr.aVf();
        }
    }

    protected final int getLayoutId() {
        return R.i.dmI;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected final void initView() {
        final View inflate = getLayoutInflater().inflate(R.i.drd, null);
        this.inF = (ListView) findViewById(R.h.cIP);
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ShakeSayHiListUI.this.asN = ShakeSayHiListUI.this.asN + 8;
                x.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + ShakeSayHiListUI.this.asN);
                ShakeSayHiListUI.this.qyu.wx(ShakeSayHiListUI.this.asN);
                if (ShakeSayHiListUI.this.oUN <= ShakeSayHiListUI.this.asN) {
                    ShakeSayHiListUI.this.inF.removeFooterView(inflate);
                    x.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + ShakeSayHiListUI.this.asN);
                }
            }
        });
        addTextOptionMenu(0, getString(R.l.dEz), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                h.a(ShakeSayHiListUI.this.mController.xRr, true, ShakeSayHiListUI.this.getString(R.l.eHw), "", ShakeSayHiListUI.this.getString(R.l.eHv), ShakeSayHiListUI.this.getString(R.l.dEy), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ShakeSayHiListUI.this.qwl.TA();
                        ShakeSayHiListUI.this.qyu.XH();
                        TextView textView = (TextView) ShakeSayHiListUI.this.findViewById(R.h.ceo);
                        textView.setText(R.l.eHz);
                        textView.setVisibility(0);
                        ShakeSayHiListUI.this.enableOptionMenu(false);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        });
        if (this.oUN == 0) {
            TextView textView = (TextView) findViewById(R.h.ceo);
            textView.setText(R.l.eHz);
            textView.setVisibility(0);
            enableOptionMenu(false);
        }
        if (this.oUN > 0 && this.asN < this.oUN) {
            this.inF.addFooterView(inflate);
        }
        this.qyu = new b(this, this.qwl, this.asN);
        this.qyu.a(new c() {
            public final int ci(View view) {
                return ShakeSayHiListUI.this.inF.getPositionForView(view);
            }
        });
        this.qyu.a(new f() {
            public final void t(View view, int i) {
                ShakeSayHiListUI.this.inF.performItemClick(view, i, 0);
            }
        });
        this.qyu.a(new e() {
            public final void bp(Object obj) {
                if (obj == null) {
                    x.e("MicroMsg.SayHiListUI", "onItemDel object null");
                    return;
                }
                l.TG().nc(obj.toString());
                ShakeSayHiListUI.this.qyu.a(null, null);
            }
        });
        this.inF.setAdapter(this.qyu);
        this.inF.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                j jVar = (j) ShakeSayHiListUI.this.qyu.getItem(i);
                if (jVar != null && jVar.field_content != null) {
                    au.d Yb = au.d.Yb(jVar.field_content);
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", Yb.sfb);
                    intent.putExtra("Contact_Encryptusername", Yb.xHX);
                    intent.putExtra("Contact_Alias", Yb.ggL);
                    intent.putExtra("Contact_Nick", Yb.fqG);
                    intent.putExtra("Contact_QuanPin", Yb.hyG);
                    intent.putExtra("Contact_PyInitial", Yb.hyF);
                    intent.putExtra("Contact_Sex", Yb.fXa);
                    intent.putExtra("Contact_Signature", Yb.signature);
                    intent.putExtra("Contact_Scene", Yb.scene);
                    intent.putExtra("Contact_FMessageCard", true);
                    intent.putExtra("Contact_City", Yb.getCity());
                    intent.putExtra("Contact_Province", Yb.getProvince());
                    intent.putExtra("Contact_Content", bi.oN(jVar.field_sayhicontent) ? ShakeSayHiListUI.this.getString(R.l.dRq) : jVar.field_sayhicontent);
                    intent.putExtra("Contact_verify_Scene", Yb.scene);
                    intent.putExtra("Contact_Uin", Yb.ppA);
                    intent.putExtra("Contact_QQNick", Yb.hyH);
                    intent.putExtra("Contact_Mobile_MD5", Yb.xHI);
                    intent.putExtra("User_From_Fmessage", true);
                    intent.putExtra("Contact_from_msgType", 37);
                    intent.putExtra("Verify_ticket", Yb.mTU);
                    intent.putExtra("Contact_ShowFMessageList", true);
                    intent.putExtra("Contact_Source_FMessage", Yb.scene);
                    as.Hm();
                    ag Xv = com.tencent.mm.y.c.Ff().Xv(Yb.sfb);
                    if (!(Xv == null || ((int) Xv.gKO) < 0 || a.ga(Xv.field_type))) {
                        int i2 = Yb.fvG;
                        if (i2 == 0 || i2 == 2 || i2 == 5) {
                            intent.putExtra("User_Verify", true);
                        }
                        intent.putExtra("Contact_IsLBSFriend", true);
                        intent.putExtra("Sns_from_Scene", 18);
                    }
                    com.tencent.mm.plugin.shake.a.ihN.d(intent, ShakeSayHiListUI.this);
                }
            }
        });
        final com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this);
        this.inF.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < ShakeSayHiListUI.this.inF.getHeaderViewsCount()) {
                    x.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, ShakeSayHiListUI.this, ShakeSayHiListUI.this.kHD);
                }
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShakeSayHiListUI.this.aWY();
                ShakeSayHiListUI.this.finish();
                return true;
            }
        });
        AnonymousClass10 anonymousClass10 = new OnClickListener() {
            public final void onClick(View view) {
                BackwardSupportUtil.c.a(ShakeSayHiListUI.this.inF);
            }
        };
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.ksO = ((j) this.qyu.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.dEH);
    }
}

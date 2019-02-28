package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public class ShakeMsgListUI extends MMActivity {
    private int asN = 0;
    private int fqZ;
    private d kHD = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            g a = ShakeMsgListUI.this.qwR;
            x.i("MicroMsg.ShakeMessageStorage", "delBySvrId = " + a.gLA.delete(a.getTableName(), "svrid = '" + String.valueOf(ShakeMsgListUI.this.ksO) + "'", null));
            ShakeMsgListUI.this.qwS.a(null, null);
        }
    };
    private long ksO;
    private TextView lrc;
    private int mType;
    private int oUN = 0;
    private int oUO = 0;
    private g qwR = null;
    private d qwS;
    private ListView qwT;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("shake_msg_type", 0);
        this.qwR = m.bsn();
        this.oUO = this.qwR.Tx();
        this.asN = this.oUO == 0 ? 8 : this.oUO;
        this.oUN = this.qwR.getCount();
        this.fqZ = getIntent().getIntExtra("shake_msg_from", 1);
        if (this.fqZ == 1) {
            com.tencent.mm.plugin.report.service.g.pWK.h(11313, Integer.valueOf(this.oUO), e.btj());
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.h(11315, Integer.valueOf(this.oUO), e.btj());
        }
        g gVar = this.qwR;
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(1));
        gVar.gLA.update(gVar.getTableName(), contentValues, "status!=? ", new String[]{"1"});
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.oUN != this.qwR.getCount()) {
            this.oUN = this.qwR.getCount();
            if (this.oUN == 0) {
                bsU();
            }
            this.qwS.XH();
        }
        this.qwS.notifyDataSetChanged();
    }

    public void onDestroy() {
        this.qwS.aUU();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dsD;
    }

    protected final void initView() {
        setMMTitle(getIntent().getStringExtra("shake_msg_list_title"));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShakeMsgListUI.this.aWY();
                ShakeMsgListUI.this.finish();
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.l.dEz), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                h.a(ShakeMsgListUI.this.mController.xRr, true, ShakeMsgListUI.this.getString(R.l.eOS), "", ShakeMsgListUI.this.getString(R.l.eHv), ShakeMsgListUI.this.getString(R.l.dEy), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        g a = ShakeMsgListUI.this.qwR;
                        a.gLA.delete(a.getTableName(), null, null);
                        ShakeMsgListUI.this.qwS.XH();
                        ShakeMsgListUI.this.bsU();
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        });
        this.lrc = (TextView) findViewById(R.h.ceo);
        if (this.oUN == 0) {
            bsU();
        }
        this.qwT = (ListView) findViewById(R.h.cNa);
        final View inflate = getLayoutInflater().inflate(R.i.drd, null);
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShakeMsgListUI.this.asN = ShakeMsgListUI.this.asN + 8;
                ShakeMsgListUI.this.qwS.wx(ShakeMsgListUI.this.asN);
                if (ShakeMsgListUI.this.oUN <= ShakeMsgListUI.this.asN) {
                    ShakeMsgListUI.this.qwT.removeFooterView(inflate);
                }
            }
        });
        if (this.oUN > 0 && this.asN < this.oUN) {
            this.qwT.addFooterView(inflate);
        }
        this.qwS = new d(this);
        this.qwS.qwO = this.asN;
        this.qwT.setAdapter(this.qwS);
        this.qwT.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                f fVar = (f) ShakeMsgListUI.this.qwS.getItem(i);
                if (!bi.oN(fVar.field_tag)) {
                    com.tencent.mm.plugin.report.service.g.pWK.k(11316, ShakeMsgListUI.this.fqZ + "," + fVar.field_tag);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", fVar.field_tag);
                    com.tencent.mm.bl.d.b(ShakeMsgListUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
        final l lVar = new l(this);
        this.qwT.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < ShakeMsgListUI.this.qwT.getHeaderViewsCount()) {
                    x.w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, ShakeMsgListUI.this.mController.xRr, ShakeMsgListUI.this.kHD);
                }
                return true;
            }
        });
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.ksO = ((f) this.qwS.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.dEH);
    }

    private void bsU() {
        this.lrc.setText(R.l.eOT);
        this.lrc.setVisibility(0);
        enableOptionMenu(false);
    }
}

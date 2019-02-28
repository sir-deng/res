package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.DragSortListView;
import com.tencent.mm.ui.widget.DragSortListView.g;
import com.tencent.mm.ui.widget.DragSortListView.l;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiSortUI extends EmojiBaseActivity implements e, a {
    private com.tencent.mm.plugin.emoji.a.e lIj;
    private DragSortListView lIk;
    private s lIl;
    private g lIm = new g() {
        public final void cu(int i, int i2) {
            EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) EmojiSortUI.this.lIj.getItem(i);
            EmojiSortUI.this.lIj.remove(emojiGroupInfo);
            EmojiSortUI.this.lIj.insert(emojiGroupInfo, i2);
        }
    };
    private l lIn = new l() {
        public final void remove(int i) {
            EmojiSortUI.this.lIj.remove(EmojiSortUI.this.lIj.getItem(i));
        }
    };
    ProgressDialog lzx;
    private ArrayList<EmojiGroupInfo> mData = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.mData = i.aCl().lCx.clf();
        this.lIk = (DragSortListView) findViewById(16908298);
        this.lIk.zAF = this.lIm;
        this.lIk.zAG = this.lIn;
        this.lIj = new com.tencent.mm.plugin.emoji.a.e(this.mController.xRr, this.mData);
        this.lIk.setAdapter(this.lIj);
        i.aCl().lCx.c(this);
        as.CN().a(717, (e) this);
    }

    protected void onDestroy() {
        i.aCl().lCx.j(this);
        as.CN().b(717, (e) this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dfN;
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                EmojiSortUI.this.finish();
                return true;
            }
        });
        setMMTitle(getString(R.l.eLA));
        addTextOptionMenu(0, getString(R.l.dFw), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (ao.isConnected(ad.getContext())) {
                    Context context = EmojiSortUI.this;
                    context.getString(R.l.dGZ);
                    context.lzx = h.a(context, context.getString(R.l.dHn), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            if (EmojiSortUI.this.lIl != null) {
                                as.CN().c(EmojiSortUI.this.lIl);
                            }
                        }
                    });
                    List arrayList = new ArrayList();
                    if (!(EmojiSortUI.this.lIj == null || EmojiSortUI.this.lIj.lzC == null)) {
                        for (EmojiGroupInfo emojiGroupInfo : EmojiSortUI.this.lIj.lzC) {
                            arrayList.add(emojiGroupInfo.field_productID);
                        }
                    }
                    EmojiSortUI.this.lIl = new s(arrayList, 2);
                    as.CN().a(EmojiSortUI.this.lIl, 0);
                } else {
                    h.a((Context) EmojiSortUI.this, EmojiSortUI.this.getString(R.l.eav), "", EmojiSortUI.this.getString(R.l.eau), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                return true;
            }
        });
        ((TextView) findViewById(16908310)).setText(R.l.eaN);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (str != null && str.equals("event_update_group") && this.lIj != null) {
            com.tencent.mm.plugin.emoji.a.e eVar = this.lIj;
            ArrayList clf = i.aCl().lCx.clf();
            eVar.clear();
            Iterator it = clf.iterator();
            while (it.hasNext()) {
                eVar.insert((EmojiGroupInfo) it.next(), eVar.getCount());
            }
            eVar.notifyDataSetChanged();
        }
    }

    public final void k(Message message) {
    }

    public final void l(Message message) {
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.emoji.EmojiSortUI", "ErrType:" + i + "   errCode:" + i2);
        if (this.lzx != null) {
            this.lzx.dismiss();
        }
        if (i == 0 && i == 0) {
            this.lIj.aBo();
            finish();
            return;
        }
        h.a((Context) this, getString(R.l.eat), "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}

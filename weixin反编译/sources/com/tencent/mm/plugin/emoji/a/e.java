package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.List;

public final class e extends ArrayAdapter<EmojiGroupInfo> {
    private static final int lzA = R.i.dfO;
    private final String TAG = "MicroMsg.emoji.EmojiSortAdapter";
    private int lzB;
    public List<EmojiGroupInfo> lzC;
    private Context mContext;

    class a {
        TextView ikL;
        ImageView jIs;
        View lzD;
        ImageView lzE;

        public a(View view) {
            this.lzE = (ImageView) view.findViewById(R.h.cdU);
            this.jIs = (ImageView) view.findViewById(R.h.cdS);
            this.ikL = (TextView) view.findViewById(R.h.cdT);
            this.lzD = view.findViewById(R.h.cdE);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = e.this.lzB;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public e(Context context, List<EmojiGroupInfo> list) {
        super(context, lzA, list);
        this.lzB = context.getResources().getDimensionPixelSize(R.f.bxc);
        this.mContext = context;
        this.lzC = list;
    }

    public final void aBo() {
        if (this.lzC != null) {
            int size = this.lzC.size();
            for (int i = 0; i < size; i++) {
                ((EmojiGroupInfo) this.lzC.get(i)).field_idx = i;
            }
            i.aCl().lCx.cX(this.lzC);
            c bg = i.aCl().lCx.bg(EmojiGroupInfo.xIF, false);
            bg.field_sort = this.lzC.size() + 2;
            com.tencent.mm.storage.emotion.a aVar = i.aCl().lCx;
            if (!com.tencent.mm.storage.emotion.a.ckW()) {
                aVar = i.aCl().lCx;
                if (bg != null) {
                    x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupInfo: packname: %s, lasttime: %d, sort: %d", bg.field_packName, Long.valueOf(bg.field_lastUseTime), Integer.valueOf(bg.field_sort));
                    aVar.a(bg);
                    aVar.b("event_update_group", 0, bi.chl().toString());
                }
            }
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(lzA, null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) getItem(i);
        if (com.tencent.mm.plugin.emoji.h.a.b(emojiGroupInfo)) {
            aVar.ikL.setText(R.l.ebr);
        } else {
            aVar.ikL.setText(emojiGroupInfo.field_packName);
        }
        if (com.tencent.mm.plugin.emoji.h.a.b(emojiGroupInfo)) {
            aVar.jIs.setImageResource(R.g.bCZ);
        } else {
            o.PG().a(emojiGroupInfo.field_packIconUrl, aVar.jIs, f.cn(emojiGroupInfo.field_productID, emojiGroupInfo.field_packIconUrl));
        }
        if (i + 1 == getCount()) {
            aVar.lzD.setBackgroundResource(R.g.bBz);
        }
        view.setVisibility(0);
        return view;
    }
}

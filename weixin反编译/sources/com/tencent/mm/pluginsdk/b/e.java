package com.tencent.mm.pluginsdk.b;

import com.tencent.mm.ap.a.a;
import com.tencent.mm.protocal.c.bkc;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

public interface e {
    String FJ();

    void a(bkc bkc);

    boolean a(EmojiGroupInfo emojiGroupInfo);

    byte[] a(EmojiInfo emojiInfo);

    bkc aBG();

    int aBH();

    ArrayList<EmojiGroupInfo> aBI();

    int aBJ();

    ArrayList<EmojiInfo> aBK();

    a aBL();

    boolean aBM();

    EmojiInfo c(EmojiInfo emojiInfo);

    void f(j.a aVar);

    void g(j.a aVar);

    void h(j.a aVar);

    void i(j.a aVar);

    void onDestroy();

    String yF(String str);

    int yS(String str);

    ArrayList<EmojiInfo> yT(String str);
}

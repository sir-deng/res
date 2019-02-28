package com.tencent.mm.plugin.address.e;

import android.content.Intent;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static Intent b(b bVar) {
        if (bVar == null) {
            x.e("MicroMsg.AddrUtil", "addressObj == null");
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("nationalCode", bVar.ioM);
        intent.putExtra("userName", bVar.ioK);
        intent.putExtra("telNumber", bVar.ioL);
        intent.putExtra("addressPostalCode", bVar.ioI);
        intent.putExtra("proviceFirstStageName", bVar.ioF);
        intent.putExtra("addressCitySecondStageName", bVar.ioG);
        intent.putExtra("addressCountiesThirdStageName", bVar.ioH);
        intent.putExtra("addressDetailInfo", bVar.ioJ);
        return intent;
    }
}

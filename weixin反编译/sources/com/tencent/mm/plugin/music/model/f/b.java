package com.tencent.mm.plugin.music.model.f;

import com.tencent.mm.ab.d;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource.Factory;

public final class b implements Factory {
    public d hmj;

    public b(d dVar) {
        this.hmj = dVar;
    }

    public final IDataSource createDataSource() {
        return new a(this.hmj);
    }
}

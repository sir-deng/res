package com.tencent.mm.p;

import com.tencent.mm.BuildConfig;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    public final String getName() {
        return "FTS5FriendStorage";
    }

    public final int getType() {
        return BuildConfig.VERSION_CODE;
    }

    public final int getPriority() {
        return BuildConfig.VERSION_CODE;
    }

    protected final void Be() {
        if (Bf()) {
            this.mPC.v(-107, 1);
        }
    }

    protected final String getTableName() {
        return "Friend";
    }

    protected final boolean Bf() {
        return !cF(-107, 1);
    }
}

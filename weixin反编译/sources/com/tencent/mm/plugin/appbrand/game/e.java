package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.vulkan.VulkanJniExport;
import com.tencent.mm.plugin.appbrand.n.b;

public final class e implements b {
    public final boolean isSupportVulkan() {
        return VulkanJniExport.isSupportVulkan();
    }
}

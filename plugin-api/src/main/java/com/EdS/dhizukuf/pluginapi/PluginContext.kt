package com.EdS.dhizukuf.pluginapi

import android.content.Context

/**
 * Context given to a plugin. Intentionally limited for safety.
 */
interface PluginContext {
    val appContext: Context

    /** Whether DhizukuF currently holds Device Owner or Profile Owner. */
    val isOwner: Boolean

    /** Whether the global “Dangerous commands” switch is enabled. */
    val dangerousCommandsEnabled: Boolean

    /** Whether this plugin is currently allowed to auto-start. */
    val autoStartEnabled: Boolean

    /**
     * Simple key-value storage scoped to this plugin.
     * Do not store large data.
     */
    fun getPreference(key: String, default: String? = null): String?
    fun putPreference(key: String, value: String?)
}

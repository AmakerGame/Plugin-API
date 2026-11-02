package com.EdS.dhizukuf.pluginapi

/**
 * Entry that appears in Settings or navigation.
 */
data class PluginSettingsEntry(
    val id: String,
    val title: String,
    val subtitle: String? = null,
    val route: String,               // must match a key from providePages() or a built-in route
    val order: Int = 100,
    val iconResName: String? = null  // optional drawable name inside the plugin
)

/**
 * Activation method shown on the home / activate screen.
 */
data class PluginActivationMethod(
    val id: String,
    val title: String,
    val description: String,
    val order: Int = 100,
    val onActivate: () -> Unit
)

/**
 * Extra dangerous command exposed by the plugin.
 */
data class PluginDangerousCommand(
    val id: String,
    val name: String,
    val description: String,
    val requiresDeviceOwner: Boolean = true
)

/**
 * Factory that creates a UI page (Compose or View).
 * The host decides how to host it.
 */
fun interface PluginPageFactory {
    fun create(context: PluginContext): Any  // Compose @Composable or View
}

/**
 * Parsed content of plugin.json
 */
data class PluginManifest(
    val id: String,
    val name: String,
    val version: String,
    val versionCode: Int,
    val description: String = "",
    val author: String = "",
    val minDhizukuF: Int = 1,
    val entryClass: String,
    val autoStart: Boolean = false,
    val requestsDangerousCommands: Boolean = false,
    val permissions: List<String> = emptyList()
)

/**
 * Runtime state of an installed plugin.
 */
enum class PluginState {
    INSTALLED,      // present but not loaded
    ENABLED,        // loaded and running
    DISABLED,       // installed but user turned off
    STOPPED,        // was running, explicitly stopped
    ERROR           // failed to load
}

/**
 * Full info shown in the Plugins UI.
 */
data class PluginInfo(
    val manifest: PluginManifest,
    val state: PluginState,
    val autoStart: Boolean,                 // current user preference
    val installPath: String,
    val errorMessage: String? = null,
    val whatItReceives: List<String> = emptyList()  // human-readable summary for UI
)

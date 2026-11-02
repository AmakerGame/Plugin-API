# Developing plugins for DhizukuF

## 1. Create the project

You can use a plain Kotlin/JVM or Android library module. The only hard requirement is that the entry class implements `DhizukuPlugin` and can be loaded by the host.

Recommended structure:

```
my-plugin/
├── plugin.json
├── src/main/java/com/example/myplugin/MyPlugin.kt
└── build.gradle.kts
```

## 2. Implement DhizukuPlugin

```kotlin
package com.example.myplugin

import com.EdS.dhizukuf.pluginapi.*

class MyPlugin : DhizukuPlugin {
    override val id = "com.example.myplugin"
    override val name = "My Plugin"
    override val version = "1.0.0"
    override val description = "Example plugin"

    override fun onLoad(context: PluginContext) {
        // initialization
    }

    override fun provideSettingsEntries(context: PluginContext): List<PluginSettingsEntry> {
        return listOf(
            PluginSettingsEntry(
                id = "my_settings",
                title = "My Plugin Settings",
                subtitle = "Configure the plugin",
                route = "plugin/myplugin/settings",
                order = 80
            )
        )
    }

    override fun providePages(context: PluginContext): Map<String, PluginPageFactory> {
        return mapOf(
            "plugin/myplugin/settings" to PluginPageFactory {
                // return a @Composable or View
                MySettingsPage()
            }
        )
    }
}
```

## 3. plugin.json

```json
{
  "id": "com.example.myplugin",
  "name": "My Plugin",
  "version": "1.0.0",
  "versionCode": 1,
  "description": "Example plugin for DhizukuF",
  "author": "You",
  "minDhizukuF": 1,
  "entryClass": "com.example.myplugin.MyPlugin",
  "autoStart": false,
  "requestsDangerousCommands": false,
  "permissions": ["settings_entry", "page"]
}
```

If `requestsDangerousCommands` is `true`, the user **must** enable the global “Dangerous commands” switch before the plugin can be installed. The UI will show the reason.

## 4. Package as .zip

```
my-plugin-1.0.0.zip
├── plugin.json
├── classes.dex          # or the compiled classes
└── (optional assets)
```

## 5. Installation

User opens DhizukuF → **Plugins** → **Install from zip** → selects the file.

Before installation the screen shows:

- Plugin name, author, version
- Whether it requests **dangerous commands**
- Whether it wants **auto-start**
- List of permissions / what it receives

After install the user can:

- Enable / Disable
- Start / Stop (if not auto-start)
- Delete
- Toggle auto-start in plugin configuration

## Security notes

- Plugins run in the same process as DhizukuF.
- They inherit Device Owner privileges when DhizukuF is the owner.
- Always declare only the permissions you need.
- The host shows a clear warning and the list of capabilities before install.

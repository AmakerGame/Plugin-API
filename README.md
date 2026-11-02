# Plugin-API (DhizukuF)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![JitPack](https://jitpack.io/v/AmakerGame/Plugin-API.svg)](https://jitpack.io/#AmakerGame/Plugin-API)

Official **Plugin API** for [DhizukuF](https://github.com/AmakerGame/DhizukuF).

Plugins are distributed as **`.zip`** packages and can:

- Add menu items and pages inside DhizukuF
- Register activation methods
- Provide extra dangerous commands (requires the “Dangerous commands” switch)
- Choose auto-start or manual start
- Be enabled / disabled / stopped / deleted by the user

## Warning

> Plugins run with the same privileges as DhizukuF (including Device Owner when active).  
> Only install plugins from sources you trust.  
> A plugin can request **dangerous commands** and **auto-start** — these are clearly shown before installation and on the plugin details screen.

## Use from GitHub (JitPack)

```kotlin
// settings.gradle.kts  (or dependencyResolutionManagement)
repositories {
    maven { url = uri("https://jitpack.io") }
}

// app/build.gradle.kts
dependencies {
    implementation("com.github.AmakerGame:Plugin-API:1.0.0")
    // until a tag exists you can use:
    // implementation("com.github.AmakerGame:Plugin-API:main-SNAPSHOT")
}
```

Source of truth: [github.com/AmakerGame/Plugin-API](https://github.com/AmakerGame/Plugin-API)

## Plugin package format (`.zip`)

```
my-plugin.zip
├── plugin.json          # required
├── classes.dex
├── res/                 # optional
└── README.md            # optional
```

### `plugin.json` example

```json
{
  "id": "com.example.myplugin",
  "name": "My Plugin",
  "version": "1.0.0",
  "versionCode": 1,
  "description": "Does something useful",
  "author": "Author Name",
  "minDhizukuF": 1,
  "entryClass": "com.example.myplugin.MyPlugin",
  "autoStart": false,
  "requestsDangerousCommands": false,
  "permissions": ["settings_entry", "activation_method", "page"]
}
```

## Quick start for plugin developers

1. Depend on this API via JitPack (or copy the interfaces).
2. Implement `com.EdS.dhizukuf.pluginapi.DhizukuPlugin`.
3. Create `plugin.json`.
4. Package as `.zip`.
5. Install from DhizukuF → Plugins.

See [docs/PLUGIN_DEVELOPMENT.md](docs/PLUGIN_DEVELOPMENT.md).

## Links

- [DhizukuF](https://github.com/AmakerGame/DhizukuF)
- [Original Dhizuku](https://github.com/iamr0s/Dhizuku)
- [Dhizuku API (upstream)](https://github.com/iamr0s/Dhizuku-API)

## License

MIT

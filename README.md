# DhizukuF Plugin API

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

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

## Plugin package format (`.zip`)

```
my-plugin.zip
├── plugin.json          # required – manifest
├── classes.dex          # or classes.jar / .so (implementation)
├── res/                 # optional resources
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
  "permissions": [
    "settings_entry",
    "activation_method",
    "page"
  ]
}
```

| Field | Required | Description |
|-------|----------|-------------|
| `id` | yes | Unique plugin ID |
| `name` | yes | Display name |
| `version` | yes | Human-readable version |
| `versionCode` | yes | Integer for updates |
| `description` | no | Short description |
| `author` | no | Author |
| `minDhizukuF` | no | Minimum DhizukuF API level |
| `entryClass` | yes | Fully-qualified class that implements `DhizukuPlugin` |
| `autoStart` | no | Default auto-start preference (user can change) |
| `requestsDangerousCommands` | no | If `true`, user must enable “Dangerous commands” to install |
| `permissions` | no | Declared capabilities |

## Quick start for developers

1. Depend on this API (or copy the interfaces).
2. Implement `DhizukuPlugin`.
3. Create `plugin.json`.
4. Package as `.zip`.
5. Install from DhizukuF → Plugins.

See [docs/PLUGIN_DEVELOPMENT.md](docs/PLUGIN_DEVELOPMENT.md) for full details.

## Links

- [DhizukuF](https://github.com/AmakerGame/DhizukuF)
- [Original Dhizuku](https://github.com/iamr0s/Dhizuku)
- [Dhizuku API (upstream)](https://github.com/iamr0s/Dhizuku-API)

## License

MIT

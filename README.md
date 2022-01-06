# WolfPlugin
Mute all users in discord with command.

## 仕様

対応サーバーソフトウェア : Spigot/PaperMC
対応バージョン          : 1.18

## セットアップ方法

1. プラグインを一度起動し、config等を生成してください。
2. 生成されたconfigにBot Tokenと利用するボイスチャンネルIDを入力して、プラグインを再起動してください。

## コマンド

`/mute`   チャンネルにいるすべてのメンバー(無視されたメンバーを除く)を強制的にサーバーミュートします。

`/unmute` チャンネルにいるすべてのメンバー(無視されたメンバーを除く)を強制的にサーバーミュートを解除します。

## パーミッション

`WolfPlugin.command.mute`   `/mute`コマンドを実行できるようにします

`WolfPlugin.command.unmute` `/unmute`コマンドを実行できるようにします

## Licence

WolfPluginは [MIT licence](https://opensource.org/licenses/MIT) になっています。詳しくは [the licence file](LICENCE) を閲覧してください。[tl;dr](https://tldrlegal.com/license/mit-license) ソフトウェア/ソースのコピーに元の著作権とライセンスの通知を含める限り、自由に行うことができます。

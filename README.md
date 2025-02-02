# mono-back

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## 技術スタック

| 項目          | 使用技術         | バージョン     |
|-------------|--------------|-----------|
| **Backend** | Java         | 21        |
|             | Quarkus      | 3.17.8    |
|             | Panache(ORM) | 3.17.8(?) |
| **DB**      | PostgreSQL   | 15.10     |
| **Other**   | Maven        | 3.9.9     |

## ディレクトリ構成

```
mono-back/
├── pom.xml                                            # プロジェクトの設定ファイル
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── jp/
│   │   │       └── co/
│   │   │           └── monocrea/
│   │   │               ├── entity/
│   │   │               │   └── UserEntity.java        # エンティティ
│   │   │               ├── resource/
│   │   │               │   └── UserResource.java      # APIエンドポイント（RESTリソース）
│   │   │               ├── repository/
│   │   │               │   └── UserRepository.java    # リポジトリ（データアクセス）
│   │   │               └── service/
│   │   │                   └── UserService.java       # サービスロジック
│   │   └── resources/
│   │       ├── application.properties                 # 設定ファイル（データベース設定/CORS設定）
│   │       └── db.migration/
│   │           └── V1__***.sql                        # データベースの初期化SQL
│   └── test/
│       ├── java/
│       │   └── jp/
│       │       └── co/
│       │           └── monocrea/
│       │               └── resource/
│       │                   └── UserResourceTest.java  # ユーザーリソースのテスト(未実装)
│       └── resources/
│           └── application.properties                 # テスト用設定ファイル
└── target/                                            # ビルド成果物格納ディレクトリ

```

## 実行方法

Docker起動
```
docker-compose up -d  
```

アプリケーション実行
```
mvn quarkus:dev
```

postgreSQL ログイン
```
docker exec -it quarkus_postgres psql -U quarkus -d quarkus_db
```

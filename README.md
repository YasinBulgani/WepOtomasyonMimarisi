project_name/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               └── project/
│   │                   ├── pages/
│   │                   │   ├── BasePage.java         // Temel sayfa işlevselliği
│   │                   │   ├── HomePage.java         // Ana sayfa sınıfı
│   │                   │   └── LoginPage.java        // Giriş sayfası sınıfı
│   │                   ├── utils/
│   │                   │   ├── DriverManager.java   // WebDriver yönetimi
│   │                   │   ├── ConfigReader.java     // Konfigürasyon okuma işlevselliği
│   │                   │   ├── EmailSender.java      // E-posta gönderme işlevselliği
│   │                   │   ├── DatabaseConnector.java // Veritabanı bağlantı işlevselliği
│   │                   │   └── XpathConstants.java    // XPath sabitleri
│   │                   └── RunCucumberTests.java     // Cucumber testlerini çalıştırmak için ana sınıf
│   │
│   ├── test/
│   │   └── resources/
│   │       ├── config/
│   │       │   ├── browser.properties              // Tarayıcı konfigürasyonları
│   │       │   ├── log4j.properties                // Log4j konfigürasyonları
│   │       │   └── env/
│   │       │       ├── development_config.properties // Geliştirme ortamı konfigürasyonu
│   │       │       └── production_config.properties  // Üretim ortamı konfigürasyonu
│   │       ├── data/
│   │       │   └── test_data.csv                    // Test veri setleri
│   │       ├── hooks/
│   │       │   └── Hooks.java                       // Senaryo başlama ve bitiş işlemleri
│   │       ├── reports/
│   │       │   ├── extent_report.html               // Extent raporu
│   │       │   └── allure_report/                  // Allure raporu (yaratılacak dosyalar)
│   │       ├── screenshots/
│   │       │   ├── error_screenshot1.png           // Hata durumunda ekran görüntüleri
│   │       │   ├── error_screenshot2.png           // Hata durumunda ekran görüntüleri
│   │       │   └── ...
│   │       ├── static/
│   │       │   ├── images/
│   │       │   └── css/
│   │       └── features/
│   │           ├── feature_file.feature            // Cucumber özellik dosyaları
│   │           └── step_definitions/
│   │               └── StepDefinitions.java        // Cucumber adımları
│   │
│   └── test-automation.properties                  // Genel test otomasyonu yapılandırma dosyası
│
├── drivers/
│   ├── chromedriver.exe (veya chromedriver dosyası) // Chrome tarayıcı sürücüsü
│   ├── geckodriver.exe (veya geckodriver dosyası)   // Firefox tarayıcı sürücüsü
│   └── ...
│
├── .gitignore                                     // Git için yoksayılacak dosya ve klasör listesi
├── Jenkinsfile                                    // Jenkins entegrasyonu için pipeline konfigürasyonu
├── pom.xml                                        // Maven proje tanımlama dosyası
└── test-automation.properties                      // Genel test otomasyonu yapılandırma dosyası

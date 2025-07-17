## API Automation Project Structor and Component we used

vabro-api-automation/                  # 🚀 Main project folder (GitHub repo root)
│
├── Jenkinsfile                        # 📦 Jenkins CI/CD pipeline script
├── Dockerfile                         # 🐳 Docker config to run tests in a container
├── pom.xml                            # 📦 Maven file for dependencies (RestAssured, TestNG, etc.)
├── testng.xml                         # 🧪 TestNG test suite configuration
├── README.md                          # 📘 Project overview, setup instructions
│
├── config/                            # ⚙️ External test config files
│   └── config.properties              # 🔧 Base URI, auth tokens, timeout configs, etc.
│
├── reports/                           # 📊 Custom or Allure test reports (optional)
│   └── allure-results/                # 📁 Allure raw report data (if used)
│
├── target/                            # ⚙️ Auto-generated compiled code and test reports
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── vabro/
│   │               ├── api/                           # 📡 All API-related services and models
│   │               │   ├── account/                   # 🔐 Account APIs
│   │               │   │   ├── AccountService.java    # ↔️ Service methods to call account endpoints
│   │               │   │   ├── AccountRequest.java    # 📤 Request body structure
│   │               │   │   └── AccountResponse.java   # 📥 Response body structure
│   │               │   ├── booking/                   # 📆 Booking module (same structure as account)
│   │               │   ├── auth/                      # 🔑 Authentication-related APIs
│   │               │   └── ...                        # ➕ Add other modules here
│   │               │
│   │               ├── config/                        # ⚙️ Java config classes
│   │               │   ├── ApiConfig.java             # 🔧 Central API config (base URI, headers)
│   │               │   └── TestConfig.java            # 🧪 Timeouts, retry, env settings
│   │               │
│   │               ├── data/                          # 🧬 Test data generation and storage
│   │               │   ├── ApiTestData.java           # 🗂️ Static data or from files
│   │               │   └── TestDataGenerator.java     # 🔄 Random data generation utility
│   │               │
│   │               └── utils/                         # 🛠️ Utility/helper classes
│   │                   ├── RestClient.java            # 🌐 HTTP methods (GET, POST, PUT, DELETE)
│   │                   ├── JsonUtils.java             # 🔄 Object <-> JSON conversion
│   │                   ├── ResponseValidator.java     # ✅ Common response validation methods
│   │                   ├── RetryMechanism.java        # 🔁 Retry failed tests
│   │                   └── RestAssuredUtils.java      # ⚙️ RestAssured configuration wrapper
│
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── vabro/
│   │               ├── tests/                         # 🧪 TestNG test classes
│   │               │   ├── AccountTest.java           # ✅ Account module tests
│   │               │   ├── LoginTest.java             # ✅ Login tests
│   │               │   ├── ForgotPasswordTest.java    # ✅ Forgot password tests
│   │               │   └── OrganizationTest/          # 📁 Org-specific test classes
│   │               │       ├── CreateOrganizationTest.java
│   │               │       ├── ValidateOrgNameWithIdPresentTest.java
│   │               │       └── ...
│   │               │
│   │               ├── base/                          # 🏗️ Common base classes for setup
│   │               │   ├── BaseTest.java              # 🧱 Base class with setup/teardown
│   │               │   └── TestBase.java              # 🔁 Inherited test base for specific modules
│   │               │
│   │               └── listener/                      # 👂 TestNG listeners (optional but powerful)
│   │                   └── TestListener.java          # 🔁 Retry, logs, custom TestNG events
│
└── .github/
└── workflows/
└── ci.yml                     # ⚙️ GitHub Actions workflow (optional alternative to Jenkins)

--------------------------------------------------------------------------------------------------------


| Folder/File          | Purpose                                                       |   |
| -------------------- | ------------------------------------------------------------- |---|
| `api/`               | API request logic, request/response models per module         |   |
| `tests/`             | Actual TestNG test classes per module                         |   |
| `utils/`             | Common helper methods for API calls, JSON parsing, validation |   |
| `config/`            | Environment and global configurations (URL, tokens)           |   |
| `base/`              | Test base classes for setup/teardown/reuse                    |   |
| `listener/`          | Retry logic, custom listeners for TestNG                      |   |
| `Jenkinsfile`        | CI/CD automation via Jenkins                                  |   |
| `Dockerfile`         | Run framework in a container (optional)                       |   |
| `.github/workflows/` | GitHub Actions CI/CD pipeline (if not using Jenkins)          |   |
| `pom.xml`            | All project dependencies like RestAssured, TestNG             |   |
| `testng.xml`         | Defines which tests to run, in which order                    |   |
| `reports/`           | For Allure/custom reports                                     |   |
| `target/`            | Auto-generated files after build (don't edit manually)        |   |


# VELI STORE TEST AUTOMATION FRAMEWORK

**Java | Maven | TestNG | GitHub**

---

## ᲛᲘᲛᲝᲮᲘᲚᲕᲐ

ეს პროექტი წარმოადგენს ტესტ ავტომატიზაციის ფრეიმვორქს, რომელიც შექმნილია `Java`-ზე და აერთიანებს როგორც UI, ასევე API ტესტირებას ერთ პროექტში.

პროექტის ძირითადი მიზანია **veli.store** ვებგვერდისა და **Fake API Store**-ის ძირითადი ფუნქციონალის ავტომატიზებული შემოწმება.

---

## ᲛᲜᲘᲨᲕᲜᲔᲚᲝᲕᲐᲜᲘ ᲙᲝᲛᲞᲝᲜᲔᲜᲢᲔᲑᲘ

- UI ტესტირება (Page Object Model)
- API ტესტირება
- ტესტების გაშვების და რეპორტინგის სისტემა
- კონფიგურირებადი გარემო

---

## ᲢᲔᲥᲜᲝᲚᲝᲒᲘᲔᲑᲘ

- `Java` - პროგრამირების ენა
- `Selenium WebDriver` - ბრაუზერის ავტომატიზაციისთვის
- `TestNG` - ტესტების შესრულებისთვის
- `Maven` - პროექტის მართვისთვის
- `Extent Reports` - რეპორტინგისთვის
- `Rest Assured` - API ტესტირებისთვის
- `WebDriverManager` - WebDriver-ის მართვისთვის

---

## ᲡᲐᲢᲔᲡᲢᲝ ᲒᲐᲠᲔᲛᲝ

### UI

- ქართული ვერსია: [https://veli.store/](https://veli.store/)
- ინგლისური ვერსია: [https://veli.store/en](https://veli.store/en)

### API

- Base URI: [https://api.escuelajs.co/api/v1](https://api.escuelajs.co/api/v1)

---

## ᲞᲠᲝᲔᲥᲢᲘᲡ ᲡᲢᲠᲣᲥᲢᲣᲠᲐ

```
Veli-POM-Project
├── src
│   ├── main
│   │   └── java
│   │       └── ge
│   │           └── store
│   │               └── veli
│   │                   ├── BasePage.java
│   │                   ├── Pages
│   │                   │   ├── CartPage.java
│   │                   │   ├── HomePage.java
│   │                   │   ├── LoginPage.java
│   │                   │   ├── VouchersPage.java
│   │                   │   └── WishListPage.java
│   │                   └── utils
│   │                       ├── ApiManager.java
│   │                       ├── ConfigReader.java
│   │                       ├── DriverManager.java
│   │                       ├── ExtentReportManager.java
│   │                       ├── TestListener.java
│   │                       └── Utils.java
│   └── test
│       └── java
│           └── ge
│               └── store
│                   └── veli
│                       ├── BaseTest.java
│                       ├── Api
│                       │   └── ApiTest.java
│                       ├── Cart
│                       │   └── CartTest.java
│                       ├── Home
│                       │   └── HomeTest.java
│                       ├── Login
│                       │   └── LoginTest.java
│                       ├── Voucher
│                       │   └── VouchersTest.java
│                       └── WishList
│                           └── WishListTest.java
├── config.properties
├── pom.xml
├── uiTestNg.xml
├── apiTestNg.xml
└── README.md
```

---

## ᲙᲝᲜᲤᲘᲒᲣᲠᲐᲪᲘᲐ

პროექტის კონფიგურაცია ხდება `config.properties` ფაილის მეშვეობით:

```properties
base.url
base.URI
ui.user.email
ui.user.password
api.user.email
api.user.password
api.user.avatar
api.product.image
```

---

## ᲓᲐᲤᲐᲠᲣᲚᲘ ᲤᲣᲜᲥᲪᲘᲝᲜᲐᲚᲘ

### UI ტესტები

- ვალიდური login
- პროდუქტის ძებნა
- logout
- ვაუჩერის დამატება კალათაში
- პროდუქტის დამატება wish list-ში
- პროდუქტის დამატება კალათაში
- პროდუქტის წაშლა კალათიდან

### API ტესტები

- პროდუქტის შექმნის მცდელობა არასწორი ფასით
- არარსებული პროდუქტის მოძებნა id-ით
- პროდუქტების ფილტრაცია ფასით
- ვალიდური login და profile request
- მომხმარებლის შექმნა არასწორი email-ით
- მომხმარებლის შექმნა email-ის გარეშე
- მომხმარებლის შექმნა, განახლება და წაშლა

---

## ᲘᲜᲡᲢᲐᲚᲐᲪᲘᲐ

რეპოზიტორიის კლონირება:

```bash
git clone https://github.com/21Seta/FinalPaidWork.git
```

დამოკიდებულებების დაყენება:

```bash
mvn clean install
```

ტესტების გაშვება:

```bash
mvn test
mvn clean test
```

---

## ᲠᲔᲞᲝᲠᲢᲔᲑᲘ

პროექტში გამოყენებულია Extent Report და TestNG Report.

Extent Report იქმნება შემდეგ მისამართზე:
```
/report/ExtentReport.html
```

Screenshot-ები ინახება აქ:
```
/report/screenshots/
```

---

## ᲨᲔᲡᲐᲫᲚᲔᲑᲚᲝᲑᲔᲑᲘ

- UI ტესტირება
- API ტესტირება
- Page Object Model
- Assertion-ები
- Logging და Reporting

---

## ᲐᲕᲢᲝᲠᲘ

**გიორგი სეთურიძე**

---

> პროექტი შექმნილია სასწავლო მიზნებისთვის.
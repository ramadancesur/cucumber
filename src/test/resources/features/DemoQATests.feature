Feature: DemoQA Web Elements Tests

  Scenario: Click Button Test
    Given kullanici "https://demoqa.com/elements" sayfasina gider
    When Buttons seçeneğini tıklar
    And Click Me butonuna tıklar
    Then mesajın "You have done a dynamic click" olduğunu doğrular

  Scenario: Add and Edit Record Test
    Given kullanici "https://demoqa.com/webtables" sayfasina gider
    When Add butonuna tıklar
    And yeni kayıt bilgilerini girer
      | FirstName | LastName | Email           | Age | Salary | Department |
      | John      | Doe      | john@email.com  | 30  | 5000   | IT         |
    And Submit butonuna tıklar
    Then kaydın eklendiğini doğrular
    When kayıt düzenleme butonuna tıklar
    And kayıt bilgilerini günceller
      | FirstName | LastName | Email           | Age | Salary | Department |
      | Jane      | Smith    | jane@email.com  | 35  | 6000   | HR         |
    Then kaydın güncellendiğini doğrular
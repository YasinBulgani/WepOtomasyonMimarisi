@test
Feature: Arama Fonksiyonu Kullanımı

  Scenario: Web sitesinde arama yapma
    Given Kullanıcı ana sayfaya gider
    When Kullanıcı arama kutusuna "Cucumber" yazar
    And Kullanıcı arama butonuna tıklar
    Then Sonuç sayfasında "Cucumber" ile ilgili sonuçları görür


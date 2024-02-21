
Feature: Arama Fonksiyonu Kullanımı

@test
  Scenario: Web sitesinde arama yapma
  // Bu adım, kullanıcının 10 saniye boyunca beklemesini simgeliyor.
  // Bazı durumlarda sayfanın yüklenmesini veya diğer işlemleri beklemek için kullanılabilir.
     And I see "HomePage" page
     Then I clicks the "search_box"
     Then User enters text "turktelekom" without clicking
     And User presses "enter" key
     And User waits for 2 seconds
      And I see "Giris_Sayfasi" page
       Then I clicks the "ttanasayfa"
  And User waits for 2 seconds









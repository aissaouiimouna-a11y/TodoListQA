Feature: je souhaite tester la barre de navigation de l application TodoList

  @navbar_non_connecte
  Scenario: les liens Taches et Deconnexion n apparaissent pas si non connecte
    Given je me connecte a l application TodoList
    Then le lien Taches n est pas visible
    And le lien Deconnexion n est pas visible

  @navbar_connecte
  Scenario: les liens Taches et Deconnexion apparaissent si connecte
    Given je suis connecte a l application TodoList
    Then le lien Taches est visible
    And le lien Deconnexion est visible
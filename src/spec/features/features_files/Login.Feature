Feature: je souhaite tester la page de connexion de l application TodoList

  @login_bouton_desactive
  Scenario: le bouton Envoyer est desactive si les champs sont vides
    Given je me connecte a l application TodoList
    Then le bouton Envoyer est desactive

  @login_invalide
  Scenario: un message rouge apparait si les identifiants sont incorrects
    Given je me connecte a l application TodoList
    When je saisis l email "wrong@gmail.com" et le mot de passe "wrongpass"
    And je clique sur le bouton Envoyer
    Then un message d erreur rouge apparait

  @login_valide
  Scenario: connexion avec identifiants corrects
    Given je me connecte a l application TodoList
    When je saisis l email "test@test.com" et le mot de passe "test"
    And je clique sur le bouton Envoyer
    Then je suis redirige vers la page des taches
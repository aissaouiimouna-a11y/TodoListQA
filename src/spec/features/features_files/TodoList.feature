Feature: je souhaite tester la gestion des taches de l application TodoList

  Background:
    Given je suis connecte a l application TodoList

  @tache_bouton_desactive
  Scenario: le bouton Ajouter est desactive si le champ est vide
    Then le bouton Ajouter est desactive

  @tache_ajout
  Scenario: ajouter une tache met a jour le localStorage
    When j ajoute une tache "Ma nouvelle tache"
    Then la tache "Ma nouvelle tache" est presente dans le localStorage

  @tache_modification
  Scenario: modifier le statut d une tache met a jour le localStorage
    When j ajoute une tache "Tache a modifier"
    And je modifie le statut de la tache
    Then le statut de la tache est mis a jour dans le localStorage

  @tache_suppression
  Scenario: supprimer une tache met a jour le localStorage
    When j ajoute une tache "Tache a supprimer"
    And je supprime la tache
    Then la tache est supprimee du localStorage
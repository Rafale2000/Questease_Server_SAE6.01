Feature: Utilisation de la base de donnée
  En tant qu'utilisateur quand je veux faire des opérations crud sur la base de données

  Background: L'utilisateur est connecté en tant que joueur
    Given L'utilisateur est inscrit sur le serveur
    And Il est connecté en tant que joueur

  Scenario: L'utilisateur souhaite supprimer des éléments nécessaires pour jouer au Prix Juste de la base de donnée.
    Given Il existe un élément
    When l'utilisateur veut le supprimer
    Then Il disparait de la base de donnée



  Scenario: L'utilisateur arrive a ajouter des éléments nécessaires au jeu prix juste dans la bdd
    Given l utilisateur souhaite ajouter des objets dans la bdd
      | id | name   | path    | prix |
      | 1  | vature | c:root  | 10   |
    When l utilisateur creer les objets
    Then les objets sont sur la bdd

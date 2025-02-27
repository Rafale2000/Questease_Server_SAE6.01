Feature: Utilisation de la base de donnée
  En tant qu'utilisateur quand je veux faire des opérations crud sur la table prix juste

  Background: Je suis connecte à la bdd
    Given J ai acces a la bdd

  Scenario Outline: L'utilisateur arrive a ajouter des éléments nécessaires au jeu prix juste dans la bdd
    Given l utilisateur souaite ajouter des objets dans la bdd
    When l utilisateur creer les objets "<id>" "<name>" "<path>" "<prix>"
    Then les objets sont sur la bdd

    Examples:
      | id | name             | path   | prix  |
      | 1  | vature           | c:root | 10    |
      | 2  | edi malou mobile | c:root | 15    |
      | 3  | vega missie      | c:root | 27000 |

  Scenario: L'utilisateur modifie un élément contenu dans la bdd
    Given l utilisateur souhaite modifier un objet
    When l utilisateur modifie l objet
    Then l objet est modifie

  Scenario: L'utilisateur souhaite supprimer des éléments nécessaires pour jouer au Prix Juste de la base de donnée.
    Given Il existe un élément
    When l'utilisateur veut le supprimer
    Then Il disparait de la base de donnée




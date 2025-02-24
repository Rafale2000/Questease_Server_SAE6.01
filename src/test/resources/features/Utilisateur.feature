Feature: Utilisation de la base de donnée
  En tant qu'utilisateur quand je veux faire des opérations crud sur la table utilisateur

  Background: Je suis connecte à la bdd
    Given J ai acces a la bdd

  Scenario Outline: L'utilisateur arrive a ajouter les éléments neccessaire a son compte dans la bdd
    Given l utilisateur souaite ajouter des utilisateurs dans la bdd
    When l utilisateur creer les objets utils "<id>" "<nom>" "<xp>" "<diff>"
    Then les utilisateurs sont sur la bdd

    Examples:
      | id | nom         | xp  | diff |
      | 1  | roberto     | 10  | 1    |
      | 2  | morin       | 150 | 2    |
      | 3  | skibidiEddy | 96  | 3    |

  Scenario: L'utilisateur modifie un utilisateut de la bdd
    Given l utilisateur souaite modifier un utilisateur
    When l utilisateur modifie l utilisateur
    Then l utilisateur est modifie

  Scenario: L'utilisateur souhaite supprimer un compte.
    Given Il existe un compte
    When l utilisateur veut supprimer le compte
    Then le compte est supprimer







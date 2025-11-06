# Hangman — README

## Table des matières

* [Introduction](#introduction)
* [Installation](#installation)
* [Utilisation](#utilisation)
* [Règles-du-jeu](#règles-du-jeu)
* [Fonctionnalités](#fonctionnalités)
* [Structure-du-code](#structure-du-code)

---

## Introduction

Ce projet est une implémentation simple du **jeu du pendu** en Java, jouable en console. Le mot à deviner est sélectionné aléatoirement dans une petite banque de mots français.

---

## Installation

### Prérequis

* Java 8 ou supérieur (JDK)

### Compilation

Dans le dossier contenant `Hangman.java` :

```bash
javac Hangman.java
```

### Exécution

```bash
java Hangman
```

> Si `java`/`javac` ne sont pas reconnus, ajoutez le dossier `bin` du JDK à votre `PATH`.

---

## Utilisation

Lancez le programme puis suivez les instructions dans la console :

1. Le jeu affiche le **mot mystère** sous forme de tirets bas (`_ _ _`).
2. Entrez **une lettre** à chaque tour puis validez.
3. Le programme indique si la lettre est présente et met à jour l’affichage.
4. Vous disposez de **5 essais** au départ (décrémentés seulement quand la lettre n’est pas dans le mot).
5. La partie se termine par une **victoire** (toutes les lettres trouvées) ou une **défaite** (plus d’essais).

Exemple de session :

```
Mot mystère : _ _ _ _ _
Proposez une lettre : a
Dommage ! La lettre 'a' n'est pas dans le mot. Il vous reste 5 essais
Mot mystère : _ r b r e
Proposez une lettre : e
Bien joué ! La lettre 'e' est dans le mot
...
Félicitations ! Vous avez deviné le mot : arbre
```

---

## Règles-du-jeu

* Un mot aléatoire est choisi parmi une liste prédéfinie (français).
* Vous proposez **une seule lettre** par tentative.
* **Caractères valides** : toute lettre (les chiffres sont refusés).
* **Essais** : 5 au départ, un essai est perdu uniquement si la lettre n’est pas dans le mot.
* **Victoire** : toutes les lettres du mot ont été dévoilées.
* **Défaite** : le nombre d’essais restants atteint 0 après une proposition incorrecte.

---

## Fonctionnalités

*  **Sélection aléatoire** d’un mot dans `wordList`.
*  **Affichage partiel** du mot avec `_` pour les lettres non découvertes.
*  **Révélation** des lettres trouvées pour toutes leurs occurrences.
*  **Historique** des lettres déjà proposées (évite les doublons dans l’affichage de la liste).
*  **Validation d’entrée** : refuse les chiffres et ne garde qu’un seul caractère saisi.
*  **Messages de fin** de partie (victoire/défaite) clairs.

> Pour changer la banque de mots, modifiez simplement le tableau `wordList` dans `main`.

---

## Structure-du-code

Fichier unique : `Hangman.java`

```text
Hangman.java
└─ public class Hangman
   ├─ public static void main(String[] args)
   │   ├─ Initialise Scanner, wordList, tirage aléatoire
   │   ├─ lettersMap : LinkedHashMap<Character, Boolean> (lettre → trouvée ?)
   │   ├─ Boucle de jeu avec compteur d’essais et saisie utilisateur
   │   └─ Affichage / logique victoire-défaite
   │
   ├─ private static Map<Character, Boolean> revealLetters(char, Map<Character, Boolean>)
   │   └─ Marque à true la/les lettre(s) identifiées dans la map
   │
   ├─ private static boolean isLetterInHiddenWord(char, String)
   │   └─ Teste la présence d’une lettre dans le mot (via indexOf)
   │
   ├─ private static boolean isValidChoice(char)
   │   └─ Vérifie que l’entrée n’est pas un chiffre
   │
   ├─ private static void printHiddenRandomWord(Map<Character, Boolean>, String)
   │   └─ Construit et affiche le mot partiellement révélé
   │
   └─ private static String getRandomWord(String[])
       └─ Retourne un mot aléatoire à partir de la liste


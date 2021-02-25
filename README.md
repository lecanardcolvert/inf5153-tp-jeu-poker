# TP 1 - Jeu de Poker (Fiche de réponses)

  - Auteur : Hamel Bourdeau, Alexandre (`HAMA12128907`)
  - Date de remise : 24/02/2021
  - Estimation du temps de travail passé sur le projet : au moins 25 heures comptées.

## Réponses aux questions  

### Question 1: Évolution du code légataire

1. Commencer par créer une classe Player. Ensuite, créer un objet de type **map** qui contient **Player** comme clé, 
   et le nombre de parties gagnées en valeur.


2. Il y a beaucoup de travail à faire pour ajouter un ou plusieurs joueur(s) car cette fonctionnalité n'était pas 
   prévue initialement. Ajouter un attribut **hand** à une nouvelle classe Player. Créer une liste de Player et y 
   ajouter tous les joueurs. Les fonctions **comp()** et **tie()** doivent être modifiées pour prendre cette liste en 
   paramètre pour comparer la main des joueurs. Mais encore là, c'est loin d'être la meilleure solution, c'est seulement
   une "patch" en attendant de faire une refonte complète du logiciel.
   

3. Je crois que la meilleure solution est que l'as soit spécifié par un A et non pas 1. Dans ce cas, apporter une 
   modification dans la fonction **getTable()**. Remplacer _('1', 1)_ par _('A', 14)_. Il faut aussi modifier la 
   variable **vSymb** dans la fonction **str2Array()** pour remplacer _'1'_ par _'A'_.
   
### Question 2: Analyse des défauts du code légataire

1. La gestion des erreurs n'est pas faite adéquatement. Elles sont stockées dans la variable **result**, qui devrait 
   contenir seulement le résultat. En effet, cette variable semble avoir plus d'un rôle. Par exemple, les fonction 
   **main** et **str2Array** stockent des erreurs dans la variable **result**.
   

2. Les couleurs des cartes devraient être représentées par un Enum. Même chose pour les valeurs des cartes. La 
   fonction **getTable()** ne devrait pas exister.


3. Une carte devrait être représentée par une classe. Une carte devrait avoir comme attribut **valeur** et **couleur**.


4. Les reponsabilités devraient être mieux définies. Chaque objet différent devrait être représenté par une classe.


5. Des valeurs 'statiques' avec des codes tels que 'F', 'X' sont utilisées dans la fonction **findComb** pour 
   stocker les combinaisons d'un joueur. Ce n'est pas une bonne pratique de programmation.
   

6. Les comparaisons d'une main et d'une carte devraient être implantée avec **Comparable** au lieu des fonctions 
   **comp()** et **tie()**.


7. Le style de code n'est pas constant. Par exemple, dans la fonction **comp()**, il y a parfois des espaces 
   entre `if` et la parenthèse ouvrante, d'autres fois non. Parfois il y a un `else`, parfois non.
   

8. Un joueur devrait être représenté par une classe.


9. Il serait très compliqué d'ajouter une autre combinaison de carte.


### Question 3: Justification des choix de conception

1.1 La première demande est de pouvoir ajouter de nouvelles combinaisons de cartes. Pour ce faire, il est important de 
créer une classe qui s'assure que les règles du jeu sont bien appliquées. J'ai donc créé la classe **Poker**. 
Celle-ci vérifie les combinaisons des cartes d'une main et lui attribue un pointage. Pour ajouter de nouvelles 
combinaisons, il n'y aurait qu'à modifier cette classe.
   
1.2 La deuxième demande est de pouvoir passer de 2 à (n) joueurs. Premièrement j'ai dû créer une classe **Player** afin 
de pouvoir stocker son nom et sa main de cartes. Après une partie, le programme demande à l'utilisateur s'il veut 
ajouter un nouveau joueur. Dans ce cas il suffit de créer une nouvelle instance de **Joueur**, de l'ajouter à la liste 
des joueurs de la partie et au tableau de pointage.

1.3 La troisième demande est d'afficher plus de détails sur la main gagnante. Premièrement j'ai dû créer deux enums 
**Color** et **Value**. Dans les deux, j'ai ajouté les valeurs par défaut (ONE, TWO, THREE, ACE, KING, TEN, etc.) et 
ajouté un attribut **word**. Ensuite la nouvelle classe **Poker** est utilisée afin de pouvoir déterminer la main 
gagnante parmi celles des joueurs. Finalement, c'est la classe **Poker** qui transforme la combinaison de la main 
gagnante en mots à l'aide de l'attribut **word** de **Color** et **Value**. 

1.4 La quatrième demande est de bien documenter le code et d'y ajouter des modèles. Il n'y a pas beaucoup 
d'explications à donner à ce sujet sauf que le travail a été fait.


2.1 Je crois que la conception actuelle du projet respecte le principe S de SOLID. Chaque objet différent est 
représenté par une classe. Chacune d'entre elle représente une seule chose et a ses responsabilités. Par exemple, la 
classe **CardFactory** sert à générer des cartes en décodant les chaînes de caractères. La classe **Scoreboard** 
représente le tableau des scores d'une partie de poker, etc.


2.2 Je crois que le code respecte la substition de Likov. Prenons par exemple les classes **Color** et **Value**. 
Elles représentent deux classes distinctes et non pas un **Enum** qui aurait été mis dans la classe **Card**, par 
exemple.


2.3 Dans l'ensemble, je crois que le code respecte la Loi de Demeter, à quelques exception près. Par exemple, je 
n'ai pas trouvé de solution pour afficher les noms des joueurs sans déroger à cette loi. Aussi, j'ai eu quelques 
difficultés à faire respecter cette loi dans la classe **Poker** qui doit faire plusieurs analyses pour trouver les 
cartes les plus fortes d'une main.


3.0 Comme mentionné précédemment, j'ai dû déroger à la Loi de Demeter quelques fois afin d'aller chercher les valeurs,
   qui sont dans les cartes, qui sont dans une main...
   

### Question 4: Évolution du code objet

Je crois que j'ai suivi ce principe mais je n'en suis pas certain. Pour l'ajout des parties gagnées, j'ai simplement 
implémenté une Map, je n'ai pas eu besoin d'écrire beaucoup de code. Même chose pour le multijoueur.

## Auto-évaluation (optionnelle)

Vous êtes libre de faire l'exercice de vous auto-évaluer en remplissant la grille d'évaluation du projet ci-dessous.

| Élement         | Critère d'évaluation                       | Note  |
| :---:           | :---                                       | :---: |
|  _Questions_    | (#1) Évolution du code légataire           | 5/5    |
|                 | (#2) Analyse des défauts du code légataire | 8/10   |
|                 | (#3) Justification des choix de conception | 13/15   |
|                 | (#4) Évolution du code objet               | 1/5    |
|  _Modèles_      | Justesse & Pertinence de la conception     | 13/15   |
|                 | Cohérence inter-modèles                    | 3/5    |
|                 | Respect des principes de conception        | 10/15   |
|  _Code_         | Qualité du code Java et du dépôt Git       | 10/10   |
|                 | Cohérence du code avec les modèles         | 10/10   | 
|                 | Qualité des tests                          | 8/10   | 
| **Note Finale** | Questions + Modèles + Code                 | 80/100  | 

_Cette auto-évaluation permet au correcteur de vous donner une rétro-action plus personnalisée en pointant les critères sur lesquels vous vous sur-évaluez et ceux sur lesquels au contraire vous vous sous-évaluez._
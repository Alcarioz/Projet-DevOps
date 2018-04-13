# Projet-DevOps

## Documentation

### Fonctionnalités fournies

  Notre bibilothèque d'analyse de données fournit les fonctionnalités suivantes:
  
      -Création de Dataframe avec données
      -Création d'un Dataframe à l'aide d'un fichier CSV
      -Affichage d'un Dataframe: totalement, les premières lignes ou les dernières lignes (3 si non spécifiées)
      -Sélection d'un Dataframe: Sélection d'un sous ensemble de lignes ou de colonnes afin de créer un nouveau Dataframe
      -Ajout d'une colonne au sein d'un Dataframe

### Choix outils

  Nous avons choisi les outils suivants
  
    -Ide: Eclipse
    -Utilisation d'un dépôt GitHub pour travailler sur le projet
    -Le projet était au départ en privé, cependant nous l'avons remis en public pour pouvoir accéder à l'URL.
    -Utilisation de Maven pour construire les différentes phases du projet.
    -JUnit pour les tests unitaires (lancer la commande mvn clean test pour les exécuter)
    -Travis CI: Pour vérifier à chaque modification du dépôt si des erreurs sont appararues. 
              (aucune erreur détectée par Travis pour la dernière version)
    -EclEmma: Nous souhaitions pouvoir générer des rapports de couverture de code à l'aide de JaCoCo, cependant nous n'avons au  final pas réussi à le faire fonctionner correctement. Cependant, sous Eclipse, en lançant EclEmma, on obtient une couverture de code totale de 94,2 %. Le pourcentage restant provient d'une exception non testée, et d'assert et de conditions ne semblant pas forcément accédés.

### Feedback

  Ce projet était intéressant à faire car il nous a permis de revoir les différents outils vu tout au long du semestre en TP ou en cours et de mieux les prendre en main. Nous aurions aimé pouvoir utiliser plus d'outils (Docker, faire marcher JaCoCo), mais nous aurions du pour cela peut être nous mettre à 3 ou 4 au lieu de 2, afin de pouvoir approfondir l'utilisation des autres outils, et aussi fournir plus de fonctionnalités par notre bibliothèque. Cependant, les outils que nous avons utilisés sont très intéressants et très pratiques dans le cadre d'un développement tel que celui-ci.

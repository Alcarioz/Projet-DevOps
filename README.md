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

  -Ide: Eclipse
  -Utilisation d'un dépôt GitHub pour travailler sur le projet
  -Le projet était au départ en privé, cependant nous l'avons remis en public pour pouvoir accéder à l'URL.
  -Utilisation de Maven pour construire les différentes phases du projet.
  -JUnit pour les tests unitaires (lancer la commande mvn clean test pour les exécuter)
  -Travis CI: Pour vérifier à chaque modification du dépôt si des erreurs sont appararues. 
              (aucune erreur détectée par Travis pour la dernière version)
  -EclEmma: Nous souhaitions pouvoir générer des rapports de couverture de code à l'aide de JaCoCo, cependant nous n'avons au   final pas réussi à le faire fonctionner correctement. Cependant, sous Eclipse, en lançant EclEmma, on obtient une couverture de code totale de 94,2 %. Le pourcentage restant provient d'une exception non testée, et d'assert et de conditions ne semblant pas forcément accédés.

### Feedback

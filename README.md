# WebService-Movie1

## Sujet

L’objectif est la création d’un WebService permettant la gestion d’une liste de film.

La notion de collection de d’entité (comme des catégories, des langues …) est un des premiers concept croisé en entreprise.

C’est aussi très pratique pour mettre en place les bases des projets sur lesquels vous travaillerez par la suite.

- Il doit disposer de routes de récupération des films (en listing, et récupération d’entité)
- Il doit être possible de modifier un film
- Il doit être possible de créer un film
- Il doit être possible de supprimer un film


## Contraintes 

### L’entité film dispose des éléments suivants :

- Le nom (texte libre, maximum 128 charactères)
- La description (texte libre, maximum 2048 charactères)
- La date de parution (date format ISO 8601)
- La note (entier entre 0 et 5, optionel)


### Les codes de retour sont implémentés :

- 200 pour une récupération de ressource ou listing ou modification avec succès
- 201 création avec succès
- 404 ressource absente
- 422 validation impossible


### Deux formats de sortie sont gérés :

- JSON
- XML

Ces formats sont explicités via le header Accept


### Technologies utilisées
- Java 19
- Spring boot 3.2
- MySQL : 8


### Documentation

Implémentation de la documentation OpenAPI disponible :
- http://localhost:8080/swagger-ui/index.html
- http://localhost:8080/v3/api-docs

Implémentation de la documentation Postman disponible :
- https://documenter.getpostman.com/view/9356996/2sA3Bq4An3


## Lancer le projet

J'ai essayé de mettre en place un DockerFile et un docker-compose.yaml. Ils sont disponibles dans le repo, mais ne sont pas encore fonctionnel.

Donc pour le moment il vous faut : 
- Java évidement :
	- Téléchargez et installez Java JDK à partir du site officiel d'Oracle : https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html
	- Suivez les instructions d'installation pour votre système d'exploitation
- Maven :
	- Téléchargez et installez Apache Maven à partir du site officiel : https://maven.apache.org/download.cgi
    - Décompressez l'archive téléchargée dans un répertoire de votre choix. 
    - Configurez la variable d'environnement  M2_HOME pour qu'elle pointe vers le répertoire Maven que vous venez de décompresser. 
    - Ajoutez le répertoire  bin de Maven à votre variable d'environnement  PATH. 
- Cloner le projet

- Deux solutions pour le lancer
	- Avec un IDE (Eclipse, Intellij ou celui que vous connaissez bien pour du JAVA)
		- Un exemple avec Eclipse ( https://www.eclipse.org/downloads/ )
			- Ouvrez votre projet dans Eclipse 
			- Lancez Eclipse et ouvrez votre projet Spring Boot en utilisant  File -> Open Projects from File System ou  File -> Import -> Maven -> Existing Maven Projects, selon votre configuration. 
			- Exécutez votre projet Spring Boot  : 
				- Cliquez avec le bouton droit de la classe `MovieApplication`, sélectionnez  Run As -> Spring Boot App
	- En ligne de commande 
		- Naviguez jusqu'au répertoire racine de votre projet Spring Boot  : 
        - Utilisez la commande  `cd` pour naviguer jusqu'au répertoire contenant le fichier  pom.xml du Spring Boot. 
        - Utilisez la commande Maven  `mvn spring-boot:run` pour lancer l'application Spring Boot. 
 
Maven téléchargera les dépendances nécessaires, compilera le code source et exécutera l'application Spring Boot. 
Vous pourrez accéder à l'application via un navigateur Web ou un outil comme Postman en utilisant l'URL par défaut http://localhost:8080/api

(Plus tard la solution sera de seulement lancer la commande suivante : `docker compose up -d`)


## Membre du projet 

- Clara Vesval
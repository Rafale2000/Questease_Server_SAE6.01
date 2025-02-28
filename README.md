# Questease

Questease est un jeu mobile collaboratif où deux joueurs doivent résoudre des énigmes ensemble. Développé initialement dans le cadre de la SAE 5.A.01, il a été amélioré lors de la SAE 6.A.01.
Ce README concerne la partie Serveur du Logiciel


## Statuts

En cours d'amélioration: ajout de fonctionalité et correction de bug
## Prérequis

Un ordinateur avec:
IDE Java, 
PostgreSql


## Deployment

- Créer une base de donné PostgreSQL

- récupere le script insert et mettez le dans votre bdd

- modifier l'application properties et modifier les paramètre URl, username et password de votre basse de données

- Lancer l'application




## Dépendance
    implementation libs.datastore.core.android
    implementation libs.filament.android
    implementation libs.media3.common
    implementation libs.games.activity
    androidTestImplementation libs.junit.jupiter
    def fragment_version = "1.8.3"

    // Java language implementation
    implementation "androidx.fragment:fragment:$fragment_version"
    implementation 'com.google.android.material:material:1.9.0'
    implementation libs.appcompat
    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation libs.material
    implementation libs.activity
    implementation libs.constraintlayout
    testImplementation libs.junit
    androidTestImplementation libs.ext.junit
    androidTestImplementation libs.espresso.core
    implementation "androidx.datastore:datastore-preferences:1.0.0"
    implementation "androidx.datastore:datastore-core:1.0.0"
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"
## A l'intention de :

- Rafik Belloum
## Authors

- [ @Duterte–Richardot Théo](https://github.com/Arirou)
- [ @Faës Hugo](https://github.com/TWP444)
- [ @Morneau Loïck]( https://github.com/Rafale2000 )
- [ @Morin Aymeric](https://github.com/Aymeric0000)
- [ @Parent Théo](https://github.com/letheos)

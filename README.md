# SiiliProjekti

## Päivittäisen työskentelyn aloitus:

Aloitus aina `git status`

Hyvä käytäntö on myös käyttää commit-historian nähdäksesi `git log`

Tarkista branchisi komennolla `git branch`

Voit vaihtaa branchia `git checkout branchinNimi`

Tiedoston muutoksia aiempaan versioon voi tarkastella komennolla diff.
`git diff tiedosto.js`

Jos commitistaunohtui jotain tai viesti meni väärin, 
voit täydentää tuoreinta kommittialaajentimella--amend. 
Lisää (add) muutokset ja tee commit:
`git commit --amend`

Jos lisäsit seuraavaan committiin(add) tiedoston, joka ei sinne kuuluisi, voit peruuttaa staginginkomennolla reset:
`git reset HEAD temp.log` # HEAD viittaa tuoreimpaan versioon

Jos haluat hylätä tiedostoon tekemäsi muutokset ja palata versionhallinnassa olevaan versioon, se onnistuu komennolla checkout.
`git checkout –- tiedosto.tyyppi`

Muista, että kaikki, mikä on commitilla talletettu, on palautettavissa. Siksi committeja kannattaa tehdä usein.

Yksinkertaisin malli, jota useimmissa pienissä projekteissa käytetään, on keskitetty. 
Kaikilla on kirjoitusoikeudet yhteiseen repositoryyn. 

1. Aluksi kaikki kloonaavat yhteisen repositoryn 
`git clone<repository-url>`

2. Muutokset tehdään omaan repositoryyn, kukin omaan tahtiinsa 
`git commit`

3. Valmiit muutokset viedään yhteiseen repositoryyn. 
`git push origin master` # etä-repository origin, muutokset masterissa

4. Muiden muutokset haetaan omaan repositoryyn, yhdistetään omiin ja julkaistaan
`git  fetch origin`
`git  merge origin/master`
`git  push origin master`

Pull requestin tekeminen:

Komento `git pull`

Pull requestissa tarjottavat muutokset kannattaa aina tehdä feature-haaroissa.

Jos muutokset on otettu mukaan, saat omat muutoksesi takaisin omaan repositoryysiprojektin master-haarassa pull-operaatiolla.

Jos teet muutokset master-haaraasi, joudut todennäköisesti peruuttamaan master-haarassasi, 
koska se ei enää vastaa etärepositoryn master-haaraa.

## Branchin nimeäminen:

Branchien nimet pienellä

Luo uusi branchi 

`git branch branchinNimi`

Luo uudelle ominaisuudelle haara (git branch) ja vaihda siihen haaraan  (git checkout). Tähän on pikakomento:

`git  checkout –b branch`   # luo haaran ja vaihtaa siihen

Jos haaraa ei enää tarvita, sen voi poistaa laajentimella–d (--delete). 
Se ei kuitenkaan onnistu pakottamatta, jos poistettavaa haaraa ei ole yhdistetty. 

`git  branch –d branch`

## Add new file/files to github repository.
`Step 1. Go to project folder`

`Step 2. Write git add . to add all files to repository don't use this all the time.`
`Step 2. Write git add file name to add sigle file to github repository.`

`Step 3. Write git commit -m "message goes here.`

`Step 4. Write git push origin master to push changes to master branch replace master with other branch name when you push to github.`

`Step 5. Write git checkout branch name to change current working branch.`

## Delete commit using commit id you can find commit id from github commits id contains 8 charecters, digits.

`Write git push origin +id^: master`

## Usefull commands.

`Write git branch -a to display all branches`

`Write git status to display files containing changes.`


## In case you want to merge branch to master.

`Step 1. Write git checkout master in order to go master branch`

`Step 2. Write git merge branch name`

`Step 3. Enter writing mode by pressing i on your keyboard.`

`Step 4. Write message message is displayed in yellow color.`

`Step 5. Exit writing mode by pressing esc key on your keyboard.`

`Step 6. Finish merging process by writing :wq and pressing enter on your keyboard.`


  ## Tool versions and links
   `Node.js -versio 12.14.1 LTS - https://nodejs.org/en/`
   
   `React.js -versio 16.12 - https://reactjs.org/versions`
   
   `Java -versio 8 - https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html`
   
   `Springboot -versio 2.2.4.RELEASE - https://spring.io/projects/spring-boot`

   `Visual Studio Code https://code.visualstudio.com/`
   
   `Intellji https://www.jetbrains.com/idea/`

# SiiliProjekti
## SiiliProjekti
### `SiiliProjekti`
`SiiliProjekti`
[Linkki](www.github.com)

## Päivittäisen työskentelyn aloitus:

Aloitus aina `git status`
Hyvä käytäntö on myös käyttää commit-historian nähdäksesi `git log`

Tarkista branchisi `git branch` komennolla
Voit vaihtaa branchia `git checkout branchinNimi`

Tiedoston muutoksia aiempaan versioon voi tarkastella komennolla diff.
`git diff tiedosto.js`

Jos commitistaunohtui jotain tai viesti meni väärin, 
voit täydentää tuoreinta kommittialaajentimella--amend. 
Lisää (add) muutokset ja tee commit:
`git commit --amend`


Jos lisäsit seuraavaan committiin(add) tiedoston, joka ei sinne kuuluisi, voit peruuttaa staginginkomennolla reset:
`git reset HEAD temp.log`              <----- HEAD viittaa tuoreimpaan versioon

Jos haluat hylätä tiedostoon tekemäsi muutokset ja palata versionhallinnassa olevaan versioon, se onnistuu komennolla checkout.
`git checkout –- tiedosto.tyyppi`

Muista, että kaikki, mikä on commitilla talletettu, on palautettavissa. Siksi committeja kannattaa tehdä usein.

Yksinkertaisin malli, jota useimmissa pienissä projekteissa käytetään, on keskitetty. 
Kaikilla on kirjoitusoikeudet yhteiseen repositoryyn. 

1.Aluksi kaikki kloonaavat yhteisen repositoryn `git clone<repository-url>`
2.Muutokset tehdään omaan repositoryyn, kukin omaan tahtiinsa `git commit`
3.Valmiit muutokset viedään yhteiseen repositoryyn. `git push origin master` # etä-repository origin, muutokset masterissa
4.Muiden muutokset haetaan omaan repositoryyn, yhdistetään omiin ja julkaistaan
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
Luo uusi branchi `git branch branchinNimi`

Luo uudelle ominaisuudelle haara (gitbranch) ja vaihda siihen haaraan  (gitcheckout). Tähän on pikakomento:
`git  checkout –b branch`   # luo haaran ja vaihtaa siihen

Jos haaraa ei enää tarvita, sen voi poistaa laajentimella–d (--delete). 
Se ei kuitenkaan onnistu pakottamatta, jos poistettavaa haaraa ei ole yhdistetty. 
`git  branch –d branch`

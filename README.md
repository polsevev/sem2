# [Semesteroppgave 2: Fire på rad og Tripp-trapp-tresko]


* **README**
* [Oppgavetekst](SEM-2.md)
* [Tips for å komme i gang](Tips.md)
* [Advanced](Advanced.md)

**Innleveringsfrist:** Hele oppgaven skal være ferdig og levert via din private gitlab-repositorie til **Fredag 24. april kl. 2359** ([AoE](https://www.timeanddate.com/worldclock/fixedtime.html?msg=4&iso=20180427T2359&p1=3399)).  

### Innlevering 
 Du finner koden din i repositoriet med URIen:

    https://retting.ii.uib.no/<brukernavn>/inf101.v20.sem2.git

Oppgaven leveres inn ved å pushe til retting.ii.uib.no, [slik du har gjort med alle tidligere INF101-oppgaver](https://retting.ii.uib.no/inf101/inf101.v20/wikis/hente-levere-oppgaver). Husk å få med eventuelle nye filer du har opprettet.

**VIKTIG:** *Sjekk kvitteringssiden som kommer opp når du pusher, i tilfelle det skjer feil!* 

Vi anbefaler at du gjør commit hver dag, eller hver gang du er ferdig med en
deloppgave, i tilfelle du mister det du jobber med på din egen maskin. Du kan levere inn så mye og ofte du vil. Versjonen som teller er den **siste du pushet før innleveringsfristen**.

Denne oppgaven teller på din endelige vurdering i faget. Maks poeng er 100. Du kan få opp til 120 totalt, inkludert ekstrapoeng. 

# Fyll inn egne svar/beskrivelse/kommentarer til prosjektet under
* Levert av:   *Rolf Martin Glomsrud* (*rgl002*)
* [X] hele semesteroppgaven er ferdig og klar til retting!
* Code review:
   * [] jeg har fått tilbakemelding underveis fra @brukernavn, ...
   * [] jeg har gitt tilbakemelding underveis til @brukernavn, ...
* Sjekkliste:
   * [X] Kjørbart Fire på Rad-spill
	   * [X] Funksjonelt spill 
	   * [X] Fungerende user interface
	   * [X] Støtter AI 
   * [X] Kjørbart Tripp-trapp-tresko-spill
	   * [X] Funksjonelt spill 
	   * [X] Fungerende user interface
	   * [X] Støtter AI 
   * [X] Forklart designvalg, hvordan koden er organisert, abstraksjon, og andre ting 
   * [X] Tester
   * [X] Dokumentasjon (JavaDoc, kommentarer, diagrammer, README, etc.)
   * [X] Fornuftige navn på klasser, interfaces, metoder og variabler
   * [X] Fornuftige abstraksjoner og innkapsling (bruk av klasser, interface, metoder, etc.)

## Oversikt
(antar at dere vil ha en slags flowchart med forklaring her) 

Programmet starter i Main hvor det kaller på GameStart. Denne klassens ansvar er å sørge for "initial setup" bl.a:
hvilket spill som bruker ønsker, om bruker ønsker 1 eller 2 spillere og navn på spillerene. Den sjekker også for 
feil i userInput. 

Deretter basert på om bruker ønsker TicTacToe eller 4 på rad vil programmet kjøre de respektive funksjonene playSingleplayer
eller playMultiplayer, valgte å gjøre det slik da det er noen forskjeller på om det er en eller 2 spillere. 
PlayMultiplayer/PlaySingleplayer sørger for å loope i evigheten så lenge ingen har vunnet eller brettet er fullt. Selve
trekket blir gjort av Player og Ai klassene respektivt. 

Player TicTacToe: 
metoden makeMoveTicTac sørger for å sjekke om det er ledig plass der bruker valgte med metoden legalMoveTicTac. Dersom 
det er det setter den riktig symbol der. Dersom det ikke er det får du error om at det ikke er ledig og det er samme
spillers tur igjen. legalMoveTicTac sjekker også for at det skal være innenfor brettet. 

Ai TicTacToe: 
Aien baserer seg på game-teori miniMax som går ut på at datamaskinen finner alle mulige veier i et gitt valgtre fra det
brettet den får oppgitt og gir disse en score rekursivt for hvem som vinner i enden. Dersom Aien vinner får trekket en
score på 1, dersom motstander vinner på trekket en score på -1, dersom det er uavgjort får trekket en score på 0. 
(se bilde i img folder ved navn minimax). metoden miniMax kjører rekursivt helt til den finner et end-Board. og gir 
"veien" den tok en score basert på hvem som vant, eller om det ble uavgjort. Se kommentarer i koden for kodeforklaring. 

Player 4 på rad: 
Denne er veldig lik TicTacToe, men bruker andre metoder. Her når den skal gjøre et trekk er den nødt til å sjekke hva
som er "laveste" Y posisjon siden bruker bare velger kolonne. Dette blir gjort i checkLowestY. Dersom denne metoden 
gjengir et negativt tall betyr det at kolonnen er full og spiller må velge på nytt slik som når du velger en optatt 
rute i TicTacToe. 

Ai 4 på rad: 
Denne er ikke smart i det hele tatt. Den rett og slett bare velger en tilfeldig kolonne, og dersom kolonnen er full 
velger den en gang til. 

checkWin 4 på rad: 
Denne er også veldig enkel. Den bare kjører gjennom alle posisjoner som kan ha 3 ruter til "fremfor" seg, og sjekker
om den forrige spilleren har vunnet eller ikke. 
Dette gjør den diagonalt i begge rettninger, vanrett og loddrett. 

checkWin TicTacToe: 
 Denne bruker en liste av "winConditions" som rett og slett er alle vinn-scenarioer i TicTacToe. Den sjekker også
 kun om forrige spiller som spilte vant, dette fordi den blir kalt på rett etter et trekk og kun med forrige spiller
 som actor. 
 
 checkTie: 
 Sjekker bare om det eksisterer ledige plasser på brettet.  

### Bruk
For å starte programmet kjør: Main.java     
For å legge ut en brikke må du skrive X kordinat først, deretter mellomrom så Y kordinat, kordinat (0,0) er øverst i
venstre.      
Det står i konsollen hvem som vinner, eller uavgjort 
Dersom du velger AI på TicTacToe utfordrer jeg deg til å slå den, det skal ikke være mulig 

## Designvalg
Jeg valgte å løse oppgaven med en commandline-applikasjon. Hvor Main starter klassen GameStart som  
tar seg av "initial setup" av programmet, slike ting som hvilket spill, om du vil spille 2 player eller mot AI.

Jeg lagde et felles Interface for de to spillene da de bruker de samme metodene. Dette gjorde at jeg kan bruke  
samme objektet i GameStart og en GameFactory er brukbar da den returnerer hvilket spill som bruker valgte.  
Siden begge spillene bruker samme interface kan jeg dermed kalle de samme funksjonene uavhengig av hvilket spill    
bruker valgte. 

AI og Player er nokså like men AI har blandt annet algoritmer for å finne det beste trekket på et gitt brett. Dette
gjorde at jeg kunne bruke samme Interface som "grunnblokk" men at jeg utvidet det for Player og Ai respektivt. Dermed
kunne jeg bruke checkWin metoden fra begge spillene på både AI spiller og Playere. Dette gjorde ting vesentlig mer
oversiktlig og jeg trenger bare kalle checkWin etter hvert av spillerene sine trekk noe som gjør at jeg ikke må sjekke 
etter winning for alle spillerne etter et hvert trekk. 

AIen til TicTacToe er uslåelig. Det er kun mulig å få uavgjort eller tap mot den (med mindre man jukser :)). Den bruker 
minimax for å oppnå dette (beskrevet over)-

Jeg valgte å bruke Gridet som ble utdelt men jeg fjernet de metodene jeg ikke brukte som f.eks copy. 

### Bruk av abstraksjon
*(hvordan du har valgt objekter/klasser for å representere ting i spillet)*
Jeg valgte å la begge spillene bruke samme interface siden de har de samme metodene. Dessuten så bruker Player og AI 
samme grunn-interface noe som gjør det lettere å bruke dem om hverandre i checkWin metodene til de to spillene. 


### Erfaring – hvilke valg viste seg å være gode / dårlige?
*(designerfaringer – er det noe du ville gjort annerledes?)*
Jeg ville nok ha plassert miniMax i sin egen klasse og gjort det slik at den hadde tilgang på instance i player1 slik at
jeg slapp å føre den inn gjennom alle metodene, jeg ser selv at dette er dårlig å gjøre men jeg fant ingen annen løsning
før tiden var ute. 

## Testing
*(hvordan du har testet ting)*
Stort sett har printet til konsollen under utvikling. Skrev testene etter store dele av programmet var ferdig. Men de
var praktiske når jeg gjorde små endringer og slapp å sjekke koden i 15 minutter. Så fremover skal jeg skrive dem 
tidligere. 

## Funksjonalitet, bugs
*(hva virker / virker ikke)*
Begge spillene skal fungere 100%. Jeg har heller ikke funnet noen bugs som jeg ikke har rettet opp i. 

## Evt. erfaring fra code review
*(lærte du noe av å gå gjennom din eller andres kode?)*

## Annet
*(er det noe du ville gjort annerledes?)*
Jeg ville nok skrevet testene tidligere. Slik at jeg slapp å bruke så mye tid å teste for hånd når jeg kunne brukt 
tiden min på å utvikle programmet videre. 

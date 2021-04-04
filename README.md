#Library Management
Un proiect Java ce simulează funcționarea unei biblioteci. Aplicația pune la dispoziție obiecte de tip client, autor, carte etc., și funcționalități specifice unei biblioteci.

#Termene de Predare
1. Etapa I: 31 martie
   
2. Etapa II: 28 aprilie 
   
3. Etapa III: 26 mai

#Etapa 1

1.Definirea sistemului:

- sa se creeze o lista pe baza temei alese cu cel puțin 10 acțiuni/interogări care se pot face în cadrul sistemului și o lista cu cel puțin 8 tipuri de obiecte.

2.Sa se implementeze în limbajul Java o aplicație pe baza celor definite la punctul 1. Aplicația va conține:
- clase simple cu atribute private / protected și metode de acces
- cel puțin 2 colecții diferite capabile să gestioneze obiectele definite anterior (List, Set, Map, etc.) dintre care cel puțin una sa fie sortata – se vor folosi array-uri uni/bidimensionale in cazul in care nu se parcurg colectiile pana la data checkpoint-ului.
- utilizare moștenire pentru crearea de clase adiționale și utilizarea lor în cadrul colecțiilor
- cel puțin o clasa serviciu care sa expună operațiile
- o clasa main din care sunt făcute apeluri către servicii

#Etapa 2

1.Extindeți proiectul din prima etapa prin realizarea persistentei utilizând fișiere.
- Se vor realiza fișiere de tip csv (comma separated values) pentru cel puțin 4 dintre clasele definite in prima etapa.
- se vor realiza servicii singleton generice pentru scrierea și citirea din fișiere
- la pornirea programului se vor încărca datele din fișiere utilizând serviciile create

2.Realizarea unui serviciu de audit
- se va realiza un serviciu care sa scrie într-un fișier de tip CSV de fiecare data când este executata una dintre acțiunile descrise in prima etapa. Structura fișierului: nume_actiune, timestamp

#Etapa 3

Înlocuiți serviciile realizate în etapa a II-a cu servicii care sa asigure persistenta utilizând baza de date folosind JDBC.

- sa se realizeze servicii care sa expună operații de tip create, read, update, delete pentru cel puțin 4 dintre clasele definite
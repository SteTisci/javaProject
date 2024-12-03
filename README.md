# Gestione Scuola - Applicazione a Linea di Comando

Un'applicazione a linea di comando per la gestione di una scuola, completa di classi, studenti e corsi. L'applicazione consente di amministrare facilmente studenti e classi attraverso un menu interattivo.

---

## Struttura del Progetto

### Classi principali

- **`Student`**  
  Gestisce le informazioni di uno studente. Ogni studente ha un nome e un elenco dei corsi a cui è iscritto.  
  **Funzionalità**:

  - Aggiunta e rimozione di corsi.
  - Visualizzazione dei corsi a cui lo studente è iscritto.

- **`Classroom`**  
  Rappresenta una classe associata a una materia specifica. Ogni classe contiene un nome e un elenco di studenti iscritti.  
  **Funzionalità**:

  - Aggiunta e rimozione di studenti (fino a un massimo di 10 per classe).
  - Visualizzazione degli studenti iscritti.

- **`School`**  
  Contiene il nome della scuola, l'elenco delle classi presenti e tutti gli studenti iscritti.  
  **Funzionalità**:

  - Gestione dell'aggiunta, rimozione e visualizzazione delle classi.
  - Gestione degli studenti iscritti alla scuola.
  - Visualizzazione dei corsi frequentati da ciascuno studente.

- **`Controller`**  
  Contiene la logica per la gestione interattiva della scuola. È il cuore dell'applicazione e collega le altre classi per consentire all'utente di eseguire operazioni come:
  - Creazione e rimozione di classi.
  - Registrazione e cancellazione di studenti.
  - Gestione degli studenti all'interno di una classe.
  - Visualizzazione delle informazioni sulla scuola.

---

## Funzionalità dell'applicazione

L'applicazione offre le seguenti funzionalità attraverso un'interfaccia a menu:

1. **Creare una nuova classe**  
   Inserire il nome della materia per creare una nuova classe nella scuola.

2. **Rimuovere una classe**  
   Visualizzare l'elenco delle classi e selezionare quella da rimuovere.

3. **Gestire una classe**  
   Entrare nel menu di gestione di una classe per:

   - Aggiungere studenti esistenti alla classe.
   - Rimuovere studenti dalla classe.
   - Visualizzare gli studenti iscritti.

4. **Visualizzare le classi**
   Mostrare un elenco delle classi presenti nella scuola.

5. **Registrare uno studente**  
   Inserire il nome di uno studente per aggiungerlo alla scuola.

6. **Cancellare uno studente**  
   Visualizzare l'elenco degli studenti iscritti e selezionare quello da rimuovere dalla scuola.

7. **Visualizzare gli studenti registrati**  
   Mostrare un elenco degli studenti iscritti alla scuola con i relativi corsi.

8. **Uscire**  
   Terminare l'applicazione.

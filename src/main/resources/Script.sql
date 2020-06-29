CREATE TABLE UTILISATEUR(
   idUTILISATEUR INT AUTO_INCREMENT,
   nom VARCHAR(50) NOT NULL,
   prenom VARCHAR(50) NOT NULL,
   email VARCHAR(50) NOT NULL,
   motDePasseSHA VARCHAR(64) NOT NULL,
   PRIMARY KEY(idUTILISATEUR)
);

CREATE TABLE ADMINISTRATEUR(
   idUTILISATEUR INT,
   PRIMARY KEY(idUTILISATEUR),
   FOREIGN KEY(idUTILISATEUR) REFERENCES UTILISATEUR(idUTILISATEUR)
);

CREATE TABLE CHEFDEPROJET(
   idUTILISATEUR INT,
   dateEmbauche DATE NOT NULL,
   PRIMARY KEY(idUTILISATEUR),
   FOREIGN KEY(idUTILISATEUR) REFERENCES UTILISATEUR(idUTILISATEUR)
);

CREATE TABLE STAGIAIRE(
   idUTILISATEUR INT,
   dateNaissance DATE NOT NULL,
   numPoleEmploi VARCHAR(50) NOT NULL,
   estHandicape TINYINT(1) NOT NULL,
   PRIMARY KEY(idUTILISATEUR),
   FOREIGN KEY(idUTILISATEUR) REFERENCES UTILISATEUR(idUTILISATEUR)
);

CREATE TABLE FORMATION(
   idFORMATION INT AUTO_INCREMENT,
   intitule VARCHAR(50) NOT NULL,
   description VARCHAR(2000),
   PRIMARY KEY(idFORMATION)
);

CREATE TABLE QUESTIONNAIRE(
   idQUESTIONNAIRE INT AUTO_INCREMENT,
   PRIMARY KEY(idQUESTIONNAIRE)
);

CREATE TABLE DOMAINE(
   idDOMAINE INT AUTO_INCREMENT,
   nom VARCHAR(50) NOT NULL,
   PRIMARY KEY(idDOMAINE)
);

CREATE TABLE ENSEIGNANT(
   idENSEIGNANT INT AUTO_INCREMENT,
   nom VARCHAR(50) NOT NULL,
   prenom VARCHAR(50) NOT NULL,
   PRIMARY KEY(idENSEIGNANT)
);

CREATE TABLE NIVEAU(
   idNIVEAU INT AUTO_INCREMENT,
   nom VARCHAR(50) NOT NULL,
   PRIMARY KEY(idNIVEAU)
);

CREATE TABLE SESSION(
   idSESSION INT AUTO_INCREMENT,
   nbPlaces INT NOT NULL,
   numero INT NOT NULL,
   idFORMATION INT NOT NULL,
   PRIMARY KEY(idSESSION),
   FOREIGN KEY(idFORMATION) REFERENCES FORMATION(idFORMATION)
);

CREATE TABLE RECRUTEMENT(
   idRECRUTEMENT INT AUTO_INCREMENT,
   lieu VARCHAR(50) NOT NULL,
   dateHeureDebut DATETIME NOT NULL,
   duree INT,
   nbPlaces INT NOT NULL,
   idQUESTIONNAIRE INT,
   idSESSION INT NOT NULL,
   PRIMARY KEY(idRECRUTEMENT),
   FOREIGN KEY(idQUESTIONNAIRE) REFERENCES QUESTIONNAIRE(idQUESTIONNAIRE),
   FOREIGN KEY(idSESSION) REFERENCES SESSION(idSESSION)
);

CREATE TABLE QUESTION(
   idQUESTION INT AUTO_INCREMENT,
   enonce VARCHAR(500) NOT NULL,
   lienMedia VARCHAR(50),
   estChoixMultiples TINYINT(1),
   estEliminatoire TINYINT(1),
   idUTILISATEUR INT NOT NULL,
   idQUESTIONNAIRE INT,
   idDOMAINE INT NOT NULL,
   idNIVEAU INT,
   PRIMARY KEY(idQUESTION),
   FOREIGN KEY(idUTILISATEUR) REFERENCES ADMINISTRATEUR(idUTILISATEUR),
   FOREIGN KEY(idQUESTIONNAIRE) REFERENCES QUESTIONNAIRE(idQUESTIONNAIRE),
   FOREIGN KEY(idDOMAINE) REFERENCES DOMAINE(idDOMAINE),
   FOREIGN KEY(idNIVEAU) REFERENCES NIVEAU(idNIVEAU)
);

CREATE TABLE REPONSE(
   idREPONSE INT AUTO_INCREMENT,
   libelle VARCHAR(50) NOT NULL,
   estCorrecte TINYINT(1),
   idQUESTION INT NOT NULL,
   PRIMARY KEY(idREPONSE),
   FOREIGN KEY(idQUESTION) REFERENCES QUESTION(idQUESTION)
);

CREATE TABLE CONVOCATION(
   idCONVOCATION INT AUTO_INCREMENT,
   acceptation TINYINT(1),
   presence TINYINT(1),
   lienSignature VARCHAR(50),
   idRECRUTEMENT INT NOT NULL,
   idUTILISATEUR INT NOT NULL,
   PRIMARY KEY(idCONVOCATION),
   FOREIGN KEY(idRECRUTEMENT) REFERENCES RECRUTEMENT(idRECRUTEMENT),
   FOREIGN KEY(idUTILISATEUR) REFERENCES STAGIAIRE(idUTILISATEUR)
);

CREATE TABLE ENTRETIEN(
   idENTRETIEN INT AUTO_INCREMENT,
   notes VARCHAR(2000),
   horairePassage TIME NOT NULL,
   idUTILISATEUR INT NOT NULL,
   idENSEIGNANT INT NOT NULL,
   idCONVOCATION INT NOT NULL,
   PRIMARY KEY(idENTRETIEN),
   UNIQUE(idCONVOCATION),
   FOREIGN KEY(idUTILISATEUR) REFERENCES CHEFDEPROJET(idUTILISATEUR),
   FOREIGN KEY(idENSEIGNANT) REFERENCES ENSEIGNANT(idENSEIGNANT),
   FOREIGN KEY(idCONVOCATION) REFERENCES CONVOCATION(idCONVOCATION)
);

CREATE TABLE bareme(
   idQUESTIONNAIRE INT,
   idDOMAINE INT,
   minimum INT NOT NULL,
   PRIMARY KEY(idQUESTIONNAIRE, idDOMAINE),
   FOREIGN KEY(idQUESTIONNAIRE) REFERENCES QUESTIONNAIRE(idQUESTIONNAIRE),
   FOREIGN KEY(idDOMAINE) REFERENCES DOMAINE(idDOMAINE)
);

CREATE TABLE repondre(
   idREPONSE INT,
   idCONVOCATION INT,
   estSelectionne TINYINT(1),
   PRIMARY KEY(idREPONSE, idCONVOCATION),
   FOREIGN KEY(idREPONSE) REFERENCES REPONSE(idREPONSE),
   FOREIGN KEY(idCONVOCATION) REFERENCES CONVOCATION(idCONVOCATION)
);
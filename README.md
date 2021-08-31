# StAlban_App
Die **St. Alban - App** wurde im Rahmen des Hauptseminars "Verarbeitung mehrdimensionaler Daten" der Masterstudiengänge Informationsverarbeitung und Medieninformatik der Universität zu Köln im SS 2021 entwickelt.<br/><br/>
Sie beschäftigt sich inhaltlich mit der Ruine der St. Alban Kirche in Köln, die während des zweiten Weltkriegs zerstört wurde, und soll einen historischen Einblick in die Geschichte dieser ermöglichen.<br/><br/>
Hierbei bietet die App verschiedene Optionen an: während die **Tour** umfangreiche geschichtliche Informationen und Bilder zusammenträgt, ermöglicht die **Zeitleiste** kurze prägnante Daten zu wichtigen Zeitpunkten in der Geschichte der Kirche.
Außerdem kann sich Bildmaterial zu verschiedenen historischen Zeitpunkten in den unterschiedlichen **Galerien** angeschaut werden.<br/>


## Entwicklung<br/>
Anna-Maria Evers, Universität zu Köln<br/>
Benedikte Löbbert, Universität zu Köln<br/>
Christine Schäfer, Universität zu Köln<br/>


## Ziele<br/>
&nbsp;&nbsp;&nbsp;&nbsp;a.&nbsp;&nbsp;Entwicklung einer App, die einen historischen Einblick in die Geschichte der St. Alban Kirche ermöglicht<br/>
&nbsp;&nbsp;&nbsp;&nbsp;b.&nbsp;&nbsp;Benutzerfreundliche und barrierefreie Bedienung<br/>
&nbsp;&nbsp;&nbsp;&nbsp;c.&nbsp;&nbsp;Einbindung historischer Daten und Bildmaterialen<br/>
&nbsp;&nbsp;&nbsp;&nbsp;d.&nbsp;&nbsp;Nutzen eines einheitlichen Designs<br/>
	
## Verwendete Materialien<br/>
&nbsp;&nbsp;&nbsp;&nbsp;a.&nbsp;&nbsp;Bildmaterial: Rheinisches Bildarchiv Köln (RBA)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;b.&nbsp;&nbsp;Literatur:<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kier, Hiltrud und Esch, Hans Georg. 2000. Kirchen in Köln. Köln: Bachem. <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Pfotenhauer, Angela. 1993. Köln: Der Gürzenich und Alt St. Alban. Köln: Bachem.<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Poth, Hugo.1978. St. Alban. Köln.<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Reiners, Heribert (1911): Kölner Kirchen. J.P. Bachem Köln.<br/>
&nbsp;&nbsp;&nbsp;&nbsp;c.&nbsp;&nbsp;Onlinequellen:<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; http://www.lexikus.de/bibliothek/Koelner-Kirchen-ST-ALBAN <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; https://www.stadt-koeln.de/leben-in-koeln/kultur/rheinisches-bildarchiv/ <br/>


## Quickstart<br/>
Die Anwendung wurde in Java geschrieben.<br/>
Da die App nicht im Appstore verfügbar ist, muss sie über die Entwicklungsumgebung [Android Studio](https://developer.android.com/studio) entweder über den Emulator 
oder über ein eigenes Endgerät mit Android-Betriebssystem gestartet werden.<br/>
&nbsp;&nbsp;&nbsp;&nbsp;a.&nbsp;&nbsp;Klonen des Repositorys aus Github<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```https://github.com/ChristineSchaefer/StAlban_App.git```<br/>
&nbsp;&nbsp;&nbsp;&nbsp;b.&nbsp;&nbsp;Öffnen des Projekts in Android Studio<br/>
&nbsp;&nbsp;&nbsp;&nbsp;c.&nbsp;&nbsp;Einrichten eines virtuellen Emulators oder Starten der App auf einem Endgerät<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Eine Anleitung ist unter folgender URL verfügbar:<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; https://developer.android.com/training/basics/firstapp/running-app <br/>
Die gesamte App kann ohne weitere Einstellungen gestartet werden.<br/>


## Code Struktur<br/>
![Ordnerstruktur](https://user-images.githubusercontent.com/82021777/130090506-ff978dd3-24be-4568-a275-575ec29c8462.png)

### Android Manifest
Jedes App-Projekt muss eine AndroidManifest.xml-Datei im Stammverzeichnis des Projektquellsatzes haben. Die Manifestdatei beschreibt wesentliche Informationen über Ihre App für die Android-Build-Tools, das Android-Betriebssystem und Google Play. <br/>
Weitere Informationen unter https://developer.android.com/guide/topics/manifest/manifest-intr.

### Ausführbare Java-Klassen
Die für die App programmierten Java-Anwendungen befinden sich in themenspezifischen Unterordnern. Alle Anwendungen wurden als Activities realisiert.<br/><br/>
```sta_start```: Zeigt beim Starten der App Startbildschirm an. Durch ein Drücken auf den Bildschirm gelangt man in das Hauptmenü.<br/><br/>
```sta_menu```: Hauptmenü. Durch Drücken auf einen der möglichen Buttons gelangt man zu den o.g. Funktionalitäten.<br/><br/>
```sta_tour```: Activities für das Durchlaufen der Tour. Diese startet bei ```StaTourActivityMain```, durchläuft verschiedene Tourstops über ```StaTourActivityStops``` und endet bei ```StaTourActivityEnd```.<br/><br/>
```sta_gallery```: Ermöglicht das Durchschauen verschiedener Galerien zu unterschiedlichen historischen Schwerpunkten der Kirche. In ```StaGalleryActivityMain``` gelangt man in das Menü, in dem die Untergalerien auswählbar sind. Die Galerie wird durch ```StaGalleryView``` angezeigt. Hier ist es über ```StaImageAdapter``` und ```StaFullView``` möglich, die Bilder im Vollbildmodus anzeigen zu lassen.<br/><br/>
```sta_timeline```: Zeigt über ```StaTimelineActivityMain``` prägnante wichtige Daten der Kirche in einer Zeitleiste. Bei Klick auf ein Datum öffnet sich ein kurzer Überblickstext zu dem ausgewählten Datum.<br/><br/>
```sta_impressum```: Hier sind alle Informationen rund um das Projekt aufgeführt (```StaImActivityMain```).

### res-Ordner
Innerhalb des res-Ordners befinden sich alle gestalterischen und inhaltlichen Elemente. Die wichtigsten Ordner sind folgende:<br/><br/>
```drawable```: Hier sind alle verwendeten Bilder, Icons etc. hinterlegt.<br/><br/>
```layout```: In diesem Ordner sind die entwickelten Layouts für die unterschiedlichen Activities hinterlegt.<br/><br/>
```menu```: Beinhaltet das Layout für das Seitenmenü, dass bei Nutzen der Activities in der oberen rechten Rechte vorzufinden ist.<br/><br/>
```values```: In diesem Ordner befinden sich alle verwendeten Farben (```colors.xml```), Texte (```strings.xml``` und ```arrays.xml```) und Themes (```themes.xml```).

### Gradle Scripts
https://developer.android.com/studio/build
	

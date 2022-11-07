# Ufficio-Postale

Simulare il flusso di clienti in un ufficio postale che ha 4 sportelli. 

Nell'ufficio esiste:
- un'ampia sala d'attesa in cui ogni persona può entrare liberamente. Quando entra, ogni persona prende il numero dalla numeratrice e aspetta il proprio turno in questa sala.
- una seconda sala, meno ampia, posta davanti agli sportelli, in cui si può entrare solo a gruppi di k persone
- una persona si mette quindi prima in coda nella prima sala, poi passa nella seconda sala.

Ogni persona impiega un tempo differente per la propria operazione allo sportello. 
Una volta terminata l'operazione, la persona esce dall'ufficio.

L'ufficio viene modellato come una classe JAVA, in cui viene attivato un ThreadPool di dimensione uguale al numero degli sportelli.
La coda delle persone presenti nella sala d'attesa è gestita esplicitamente dal programma.
La seconda coda (davanti agli sportelli) è quella gestita implicitamente dal ThreadPool.
Ogni persona viene modellata come un task, un task che deve essere assegnato ad uno dei thread associati agli sportelli.
L'operatore chiude lo sportello stesso dopo che in un certo intervallo di tempo non si presentano clienti al suo sportello.

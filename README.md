# Nauta_Stats

## Que es Nauta_Stats
 
Nauta_Stats es una pequeña aplicación en Java para conocer el estado actual de la cuenta en [Mi Cubacel](https://mi.cubacel.net) 

## Cómo se usa Nauta_Stats

Al ser una aplicación hecha en Java, requiere Java JRE para funcionar. Debe tener en la misma carpeta un archivo nauta.conf con la siguiente estructura:

```
guestUserProfile=VALUE
portaluser=VALUE
DRUTT_DSERVER_SESSIONID=VALUE
```
Donde cada `VALUE` es el respectivo valor de la cookie tomada del sitio mi.cubacel.net
 
Es una aplicación basada en consola y el método de uso es el siguiente:
 
 ```
 java -jar Nauta.jar
 ```
 
 ## Valores a Devolver:
  
 La Aplicación debe devolver los valores como se muestra en el ejemplo siguiente:
 ```
Paquete de Datos 1.863 GB
Bono Nacional 299.404 MB
Bono SMS 87 SMS
Bono Minutos 46 Minutes
```
## Aviso:
 
Esta aplicación se creó para uso personal y está sujeta a cambios sin previo aviso. Si te gustó, dejame una estrella y si piensas que le falta algo (muy probable que así sea), pues escribeme por Telegram como @danny920825
